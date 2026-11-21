package de.evoal.optimisation.main.constraints;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.languages.ExpressionText;
import de.evoal.core.api.languages.base.CallSwitch;
import de.evoal.core.api.languages.base.DataReferenceSwitch;
import de.evoal.core.api.languages.base.NumberSwitch;
import de.evoal.languages.model.base.definitions.BaseDataDescription;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.languages.model.base.expressions.Call;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.languages.model.interpreter.ConstantEvaluator;
import de.evoal.models.v202704.optimisation.model.Problem;

import de.evoal.optimisation.api.correlations.BuildingBlock;
import de.evoal.optimisation.api.correlations.Correlation;
import de.evoal.optimisation.api.correlations.CorrelationKind;
import de.evoal.optimisation.api.correlations.CorrelationRange;
import de.evoal.optimisation.api.correlations.Correlations;
import de.evoal.optimisation.api.correlations.LinkageGroup;

/**
 * Reads the correlations and the building blocks of an optimisation problem from the
 *   {@code constraints} sections of the DDL modules that declare its features and of the DDL
 *   modules imported by the OL module of the problem (the same modules as the
 *   {@link ConstraintCompiler}):
 * <ul>
 *   <li>{@code correlation(data f, data g, rho)} declares a correlation of two search
 *     features;</li>
 *   <li>{@code 'ranged-correlation'(data f, range(l, u), data g, range(l, u), rho)} declares a
 *     correlation that applies only while both features lie in their ranges;</li>
 *   <li>{@code 'building-block'([data f, data g, …])} declares a building block, a group of
 *     search features that interact.</li>
 * </ul>
 * A correlation with an objective, of a feature with itself, with a coefficient outside
 *   [-1, 1] or with an empty range is rejected, and so is a building block whose parameter is
 *   no array of data, with a feature that is not searched, with fewer than two features or
 *   with a feature twice. The kind of a correlation follows from the scales of its features
 *   ({@link CorrelationKind}). The correlations are numbered from 1 in the order of the DDL,
 *   and so are the building blocks.
 */
@ApplicationScoped
@Slf4j
public class CorrelationCompiler {
    /**
     * The name of the DDL function that declares a correlation.
     */
    private static final String CORRELATION = "correlation";

    /**
     * The name of the DDL function that declares a building block.
     */
    private static final String BUILDING_BLOCK = "building-block";

    /**
     * The name of the DDL function that declares a range.
     */
    private static final String RANGE = "range";

    /**
     * The name of the DDL function that declares a ranged correlation.
     */
    private static final String RANGED_CORRELATION = "ranged-correlation";

    @Inject
    private EAnnotationHelper annotations;

    @Inject
    private ConstraintCompiler calls;

    /**
     * Creates a compiler whose parts are injected.
     */
    public CorrelationCompiler() {
    }

    /**
     * @param annotations Finds the data description of a feature.
     */
    public CorrelationCompiler(final EAnnotationHelper annotations) {
        this(annotations, List.of());
    }

    /**
     * @param annotations Finds the data description of a feature.
     * @param importedModules The DDL modules that the OL module of the problem imports.
     */
    public CorrelationCompiler(final EAnnotationHelper annotations, final List<DataDescriptionModule> importedModules) {
        this.annotations = annotations;
        this.calls = new ConstraintCompiler(annotations, importedModules);
    }

    /**
     * @param problem The optimisation problem.
     * @return The correlations and the building blocks of the problem.
     * @throws IllegalArgumentException if a correlation or a building block cannot be used.
     */
    public Correlations compile(final Problem problem) {
        final List<EStructuralFeature> searchFeatures = problem.getSearchSpace().getEAllStructuralFeatures();
        final List<EStructuralFeature> objectives = problem.getOptimisationSpace().getEAllStructuralFeatures();

        return compile(searchFeatures, objectives);
    }

    /**
     * @param searchFeatures The search features of the problem.
     * @param objectives The objectives of the problem.
     * @return The correlations and the building blocks of the problem.
     * @throws IllegalArgumentException if a correlation or a building block cannot be used.
     */
    public Correlations compile(final Collection<EStructuralFeature> searchFeatures,
                               final Collection<EStructuralFeature> objectives) {
        final ConstraintCompiler.DdlCalls ddl = calls.readCalls(searchFeatures, objectives);
        final List<LinkageGroup> groups = new ArrayList<>();
        int correlations = 0;
        int blocks = 0;

        for(final Call call : ddl.calls()) {
            final String function = call.getFunction().getName();
            final boolean ranged = RANGED_CORRELATION.equals(function);

            if(ranged || CORRELATION.equals(function)) {
                try {
                    groups.add(toCorrelation(++correlations, call, ranged, ddl.searchByData()));
                } catch(final IllegalArgumentException e) {
                    throw new IllegalArgumentException("The correlation '" + ExpressionText.of(call)
                                                       + "' cannot be used: " + e.getMessage(), e);
                }
            } else if(BUILDING_BLOCK.equals(function)) {
                try {
                    groups.add(toBuildingBlock(++blocks, call, ddl.searchByData()));
                } catch(final IllegalArgumentException e) {
                    throw new IllegalArgumentException("The building block '" + ExpressionText.of(call)
                                                       + "' cannot be used: " + e.getMessage(), e);
                }
            }
        }

        final Correlations result = new Correlations(groups);
        if(!result.isEmpty()) {
            log.info("Read {} correlations and {} building blocks.", correlations, blocks);
        }

        return result;
    }

    private EStructuralFeature featureOf(final Expression parameter, final Map<DataDescription, EStructuralFeature> searchByData,
                                         final String declarations) {
        DataDescription description;
        try {
            description = new DataReferenceSwitch().doSwitch(parameter);
        } catch(final IllegalStateException e) {
            // the switch rejects literals with an exception
            description = null;
        }
        if(description == null) {
            throw new IllegalArgumentException("'" + ExpressionText.of(parameter) + "' is no data.");
        }

        return searchFeatureOf(description, searchByData, declarations);
    }

    private static EStructuralFeature searchFeatureOf(final DataDescription description,
                                                      final Map<DataDescription, EStructuralFeature> searchByData,
                                                      final String declarations) {
        final EStructuralFeature feature = searchByData.get(description);
        if(feature == null) {
            throw new IllegalArgumentException("'" + description.getName() + "' is not searched for; " + declarations
                                               + " are only declared between search features.");
        }

        return feature;
    }

    /**
     * @return The kind of a correlation of the two features by their scales.
     */
    private CorrelationKind kindOf(final EStructuralFeature first, final EStructuralFeature second) {
        return CorrelationKind.of(scaleOf(first), scaleOf(second));
    }

    private static double numberOf(final Expression parameter) {
        final Number number = new NumberSwitch().doSwitch(parameter);
        if(number == null) {
            throw new IllegalArgumentException("'" + ExpressionText.of(parameter) + "' is no number.");
        }

        return number.doubleValue();
    }

    private static CorrelationRange rangeOf(final Expression parameter) {
        final Call call = new CallSwitch().doSwitch(parameter);
        if(call == null || !RANGE.equals(call.getFunction().getName())) {
            throw new IllegalArgumentException("'" + ExpressionText.of(parameter) + "' is no range(lower, upper).");
        }

        ConstraintCompiler.requireParameters(call, 2);

        return new CorrelationRange(numberOf(call.getParameters().get(0)), numberOf(call.getParameters().get(1)));
    }

    private ScaleType scaleOf(final EStructuralFeature feature) {
        return annotations.dataDescriptionOf(feature)
                          .filter(BaseDataDescription.class::isInstance)
                          .map(BaseDataDescription.class::cast)
                          .map(BaseDataDescription::getScale)
                          .orElse(ScaleType.UNKNOWN);
    }

    private BuildingBlock toBuildingBlock(final int number, final Call call,
                                          final Map<DataDescription, EStructuralFeature> searchByData) {
        ConstraintCompiler.requireParameters(call, 1);

        final Expression parameter = call.getParameters().getFirst();
        final String rejection = "'" + ExpressionText.of(parameter) + "' is no array of data, e.g. "
                                 + "[data 'x:0', data 'x:1'].";

        // the interpreter evaluates an array to a list and a data reference to its description
        final Object value;
        try {
            value = new ConstantEvaluator().doSwitch(parameter);
        } catch(final IllegalStateException e) {
            // the interpreter rejects expressions it cannot evaluate with an exception
            throw new IllegalArgumentException(rejection, e);
        }
        if(!(value instanceof List<?> elements)) {
            throw new IllegalArgumentException(rejection);
        }

        final List<EStructuralFeature> features = new ArrayList<>();
        for(final Object element : elements) {
            if(!(element instanceof DataDescription description)) {
                throw new IllegalArgumentException(rejection);
            }

            features.add(searchFeatureOf(description, searchByData, "building blocks"));
        }

        return new BuildingBlock(number, features);
    }

    private Correlation toCorrelation(final int number, final Call call, final boolean ranged,
                                      final Map<DataDescription, EStructuralFeature> searchByData) {
        ConstraintCompiler.requireParameters(call, ranged ? 5 : 3);

        final List<Expression> parameters = call.getParameters();
        final EStructuralFeature first = featureOf(parameters.get(0), searchByData, "correlations");
        final CorrelationRange firstRange = ranged ? rangeOf(parameters.get(1)) : null;
        final EStructuralFeature second = featureOf(parameters.get(ranged ? 2 : 1), searchByData, "correlations");
        final CorrelationRange secondRange = ranged ? rangeOf(parameters.get(3)) : null;
        final double coefficient = numberOf(parameters.get(ranged ? 4 : 2));

        return new Correlation(number, first, second, coefficient, firstRange, secondRange, kindOf(first, second));
    }
}
