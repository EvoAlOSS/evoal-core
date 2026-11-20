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
import de.evoal.core.api.languages.base.CallSwitch;
import de.evoal.core.api.languages.base.DataReferenceSwitch;
import de.evoal.core.api.languages.base.NumberSwitch;
import de.evoal.languages.model.base.definitions.BaseDataDescription;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.languages.model.base.expressions.Call;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.models.v202704.optimisation.model.Problem;

import de.evoal.optimisation.api.correlations.Correlation;
import de.evoal.optimisation.api.correlations.CorrelationKind;
import de.evoal.optimisation.api.correlations.CorrelationRange;
import de.evoal.optimisation.api.correlations.Correlations;

/**
 * Reads the correlations of an optimisation problem from the {@code constraints} sections of
 *   the DDL modules that declare its features (the same modules as the
 *   {@link ConstraintCompiler}):
 * <ul>
 *   <li>{@code correlation(data f, data g, rho)} declares a correlation of two search
 *     features;</li>
 *   <li>{@code 'ranged-correlation'(data f, range(l, u), data g, range(l, u), rho)} declares a
 *     correlation that applies only while both features lie in their ranges.</li>
 * </ul>
 * A correlation with an objective, of a feature with itself, with a coefficient outside
 *   [-1, 1] or with an empty range is rejected. The kind of a correlation follows from the
 *   scales of its features ({@link CorrelationKind}). The correlations are numbered from 1 in
 *   the order of the DDL.
 */
@ApplicationScoped
@Slf4j
public class CorrelationCompiler {
    /**
     * The name of the DDL function that declares a correlation.
     */
    private static final String CORRELATION = "correlation";

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
        this.annotations = annotations;
        this.calls = new ConstraintCompiler(annotations);
    }

    /**
     * @param problem The optimisation problem.
     * @return The correlations of the problem.
     * @throws IllegalArgumentException if a correlation cannot be used.
     */
    public Correlations compile(final Problem problem) {
        final List<EStructuralFeature> searchFeatures = problem.getSearchSpace().getEAllStructuralFeatures();
        final List<EStructuralFeature> objectives = problem.getOptimisationSpace().getEAllStructuralFeatures();

        return compile(searchFeatures, objectives);
    }

    /**
     * @param searchFeatures The search features of the problem.
     * @param objectives The objectives of the problem.
     * @return The correlations of the problem.
     * @throws IllegalArgumentException if a correlation cannot be used.
     */
    public Correlations compile(final Collection<EStructuralFeature> searchFeatures,
                               final Collection<EStructuralFeature> objectives) {
        final ConstraintCompiler.DdlCalls ddl = calls.readCalls(searchFeatures, objectives);
        final List<Correlation> correlations = new ArrayList<>();

        for(final Call call : ddl.calls()) {
            final String function = call.getFunction().getName();
            final boolean ranged = RANGED_CORRELATION.equals(function);
            if(!ranged && !CORRELATION.equals(function)) {
                continue;
            }

            try {
                correlations.add(toCorrelation(correlations.size() + 1, call, ranged, ddl.searchByData()));
            } catch(final IllegalArgumentException e) {
                throw new IllegalArgumentException("The correlation '" + ConstraintCompiler.textOf(call)
                                                   + "' cannot be used: " + e.getMessage(), e);
            }
        }

        final Correlations result = new Correlations(correlations);
        if(!result.isEmpty()) {
            log.info("Read {} correlations.", result.size());
        }

        return result;
    }

    private EStructuralFeature featureOf(final Expression parameter, final Map<DataDescription, EStructuralFeature> searchByData) {
        final DataDescription description = new DataReferenceSwitch().doSwitch(parameter);
        if(description == null) {
            throw new IllegalArgumentException("'" + ConstraintCompiler.textOf(parameter) + "' is no data.");
        }

        final EStructuralFeature feature = searchByData.get(description);
        if(feature == null) {
            throw new IllegalArgumentException("'" + description.getName() + "' is not searched for; correlations are "
                                               + "only declared between search features.");
        }

        return feature;
    }

    /**
     * @return The kind of a correlation of the two features by their scales.
     */
    private CorrelationKind kindOf(final EStructuralFeature first, final EStructuralFeature second) {
        final ScaleType firstScale = scaleOf(first);
        final ScaleType secondScale = scaleOf(second);

        if(firstScale == ScaleType.NOMINAL || secondScale == ScaleType.NOMINAL) {
            return CorrelationKind.NOMINAL;
        }
        if(firstScale == ScaleType.ORDINAL || secondScale == ScaleType.ORDINAL) {
            return CorrelationKind.RANK;
        }

        return CorrelationKind.LINEAR;
    }

    private static double numberOf(final Expression parameter) {
        final Number number = new NumberSwitch().doSwitch(parameter);
        if(number == null) {
            throw new IllegalArgumentException("'" + ConstraintCompiler.textOf(parameter) + "' is no number.");
        }

        return number.doubleValue();
    }

    private static CorrelationRange rangeOf(final Expression parameter) {
        final Call call = new CallSwitch().doSwitch(parameter);
        if(call == null || !RANGE.equals(call.getFunction().getName())) {
            throw new IllegalArgumentException("'" + ConstraintCompiler.textOf(parameter) + "' is no range(lower, upper).");
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

    private Correlation toCorrelation(final int number, final Call call, final boolean ranged,
                                      final Map<DataDescription, EStructuralFeature> searchByData) {
        ConstraintCompiler.requireParameters(call, ranged ? 5 : 3);

        final List<Expression> parameters = call.getParameters();
        final EStructuralFeature first = featureOf(parameters.get(0), searchByData);
        final CorrelationRange firstRange = ranged ? rangeOf(parameters.get(1)) : null;
        final EStructuralFeature second = featureOf(parameters.get(ranged ? 2 : 1), searchByData);
        final CorrelationRange secondRange = ranged ? rangeOf(parameters.get(3)) : null;
        final double coefficient = numberOf(parameters.get(ranged ? 4 : 2));

        return new Correlation(number, first, second, coefficient, firstRange, secondRange, kindOf(first, second));
    }
}
