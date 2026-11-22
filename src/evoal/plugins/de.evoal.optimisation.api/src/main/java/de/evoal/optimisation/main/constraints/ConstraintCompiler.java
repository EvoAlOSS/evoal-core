package de.evoal.optimisation.main.constraints;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.languages.ExpressionText;
import de.evoal.core.api.languages.base.CallSwitch;
import de.evoal.core.api.languages.base.DataReferenceSwitch;
import de.evoal.core.api.languages.base.NumberSwitch;
import de.evoal.core.api.languages.base.StringSwitch;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.Call;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.models.v202704.optimisation.model.Problem;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.constraints.Constraint;
import de.evoal.optimisation.api.constraints.Constraints;

/**
 * Reads the constraints of an optimisation problem from the {@code constraints} sections of
 *   the DDL modules that declare its search features and objectives, and of the DDL modules
 *   that the OL module of the problem imports ({@link ImportedDataModules}, bound to
 *   {@link OptimisationBlackboardEntries#IMPORTED_DATA_MODULES}):
 * <ul>
 *   <li>{@code constraint(comparison, "group")} declares a constraint. The comparison is
 *     compiled into its normal form g ({@link ConditionCompiler}); a constraint that cannot be
 *     compiled is rejected.</li>
 *   <li>{@code 'standard-deviation'(data 'f', sigma)} declares the standard deviation of a
 *     feature for the {@code 'tolerance-measure'}.</li>
 * </ul>
 * Other calls (e.g., correlations, see {@link CorrelationCompiler}) are ignored. The constraints
 *   are numbered in the order of the modules (first use of a feature, search features first,
 *   then the imported modules in the order of their imports) and of the DDL.
 */
@ApplicationScoped
@Slf4j
public class ConstraintCompiler {
    /**
     * The name of the DDL function that declares a constraint.
     */
    public static final String CONSTRAINT = "constraint";

    /**
     * The name of the DDL function that declares a standard deviation.
     */
    private static final String STANDARD_DEVIATION = "standard-deviation";

    @Inject
    private EAnnotationHelper annotations;

    /**
     * Holds the imported DDL modules of the problem; {@code null} if they are given.
     */
    @Inject
    private Blackboard board;

    /**
     * The imported DDL modules of the problem; {@code null} if they come from the blackboard.
     */
    private List<DataDescriptionModule> importedModules;

    /**
     * Creates a compiler whose helpers are injected.
     */
    public ConstraintCompiler() {
    }

    /**
     * @param annotations Finds the data description of a feature.
     */
    public ConstraintCompiler(final EAnnotationHelper annotations) {
        this(annotations, List.of());
    }

    /**
     * @param annotations Finds the data description of a feature.
     * @param importedModules The DDL modules that the OL module of the problem imports.
     */
    public ConstraintCompiler(final EAnnotationHelper annotations, final List<DataDescriptionModule> importedModules) {
        this.annotations = annotations;
        this.importedModules = List.copyOf(importedModules);
    }

    private Map<DataDescription, EStructuralFeature> byData(final Collection<EStructuralFeature> features) {
        final Map<DataDescription, EStructuralFeature> result = new HashMap<>();

        for(final EStructuralFeature feature : features) {
            annotations.dataDescriptionOf(feature)
                       .ifPresent(description -> result.put(description, feature));
        }

        return result;
    }

    /**
     * @param problem The optimisation problem.
     * @return The constraints of the problem.
     * @throws IllegalArgumentException if a constraint cannot be compiled.
     */
    public Constraints compile(final Problem problem) {
        final List<EStructuralFeature> searchFeatures = problem.getSearchSpace().getEAllStructuralFeatures();
        final List<EStructuralFeature> objectives = problem.getOptimisationSpace().getEAllStructuralFeatures();

        return compile(searchFeatures, objectives);
    }

    /**
     * @param problem The optimisation problem.
     * @return The DDL declarations of the problem, e.g. {@code correlation} or
     *   {@code 'building-block'}: the calls of the {@code constraints} sections of the DDL
     *   modules that declare its features and of the imported DDL modules, in their order.
     */
    public List<Call> declarations(final Problem problem) {
        final List<EStructuralFeature> searchFeatures = problem.getSearchSpace().getEAllStructuralFeatures();
        final List<EStructuralFeature> objectives = problem.getOptimisationSpace().getEAllStructuralFeatures();

        return readCalls(searchFeatures, objectives).calls();
    }

    /**
     * @param features The features, e.g. the data that a pipeline step reads.
     * @return The DDL declarations of the DDL modules that declare the features and of the
     *   imported DDL modules, in their order.
     */
    public List<Call> declarations(final Collection<EStructuralFeature> features) {
        return readCalls(features, List.of()).calls();
    }

    /**
     * @param searchFeatures The search features of the problem.
     * @param objectives The objectives of the problem.
     * @return The constraints of the problem.
     * @throws IllegalArgumentException if a constraint cannot be compiled.
     */
    public Constraints compile(final Collection<EStructuralFeature> searchFeatures,
                               final Collection<EStructuralFeature> objectives) {
        final DdlCalls ddl = readCalls(searchFeatures, objectives);
        final List<Call> calls = ddl.calls();
        final Map<DataDescription, EStructuralFeature> searchByData = ddl.searchByData();
        final Map<DataDescription, EStructuralFeature> objectivesByData = ddl.objectivesByData();

        final Map<EStructuralFeature, Double> deviations = readDeviations(calls, searchByData, objectivesByData);
        final List<Constraint> constraints = new ArrayList<>();

        for(final Call call : calls) {
            if(!CONSTRAINT.equals(call.getFunction().getName())) {
                continue;
            }

            final int number = constraints.size() + 1;
            final Constraint constraint = toConstraint(number, call, searchByData, objectivesByData, deviations);
            constraints.add(constraint);
        }

        final Constraints result = new Constraints(constraints);
        log.info("Read {} constraints in the groups {}.", result.size(), result.groups());

        return result;
    }

    /**
     * The calls of the {@code constraints} sections of the DDL modules of a problem.
     *
     * @param calls The calls, in the order of the modules and of the DDL.
     * @param searchByData The search features by their data description.
     * @param objectivesByData The objectives by their data description.
     */
    record DdlCalls(List<Call> calls,
                    Map<DataDescription, EStructuralFeature> searchByData,
                    Map<DataDescription, EStructuralFeature> objectivesByData) {
    }

    /**
     * Reads the calls of the {@code constraints} sections of the DDL modules that declare the
     *   features and of the imported DDL modules, in the order of the modules (first use of a
     *   feature, search features first, then the imports) and of the DDL.
     *
     * @param searchFeatures The search features of the problem.
     * @param objectives The objectives of the problem.
     * @return The calls with the features by their data description.
     */
    DdlCalls readCalls(final Collection<EStructuralFeature> searchFeatures,
                       final Collection<EStructuralFeature> objectives) {
        final Map<DataDescription, EStructuralFeature> searchByData = byData(searchFeatures);
        final Map<DataDescription, EStructuralFeature> objectivesByData = byData(objectives);
        final Set<DataDescriptionModule> modules = new LinkedHashSet<>();
        searchByData.keySet().forEach(description -> moduleOf(description).ifPresent(modules::add));
        objectivesByData.keySet().forEach(description -> moduleOf(description).ifPresent(modules::add));
        modules.addAll(importedModules());

        final List<Call> calls = modules.stream()
                                        .flatMap(module -> module.getConstraints().stream())
                                        .map(ConstraintCompiler::toCall)
                                        .flatMap(Optional::stream)
                                        .toList();

        return new DdlCalls(calls, searchByData, objectivesByData);
    }

    /**
     * @return The imported DDL modules of the problem, none if no configuration was loaded.
     */
    private List<DataDescriptionModule> importedModules() {
        if(importedModules != null) {
            return importedModules;
        }

        final List<DataDescriptionModule> bound = board == null
                ? null
                : board.getOrNull(OptimisationBlackboardEntries.IMPORTED_DATA_MODULES);

        return bound == null ? List.of() : bound;
    }

    private static Optional<DataDescriptionModule> moduleOf(final DataDescription description) {
        EObject current = description.eContainer();

        while(current != null && !(current instanceof DataDescriptionModule)) {
            current = current.eContainer();
        }

        return Optional.ofNullable((DataDescriptionModule) current);
    }

    /**
     * @return The standard deviations of the features of the problem; declarations for other
     *   data are ignored.
     * @throws IllegalArgumentException if a declaration is malformed or a deviation negative.
     */
    private static Map<EStructuralFeature, Double> readDeviations(
            final List<Call> calls,
            final Map<DataDescription, EStructuralFeature> searchByData,
            final Map<DataDescription, EStructuralFeature> objectivesByData) {
        final Map<EStructuralFeature, Double> deviations = new HashMap<>();

        for(final Call call : calls) {
            if(!STANDARD_DEVIATION.equals(call.getFunction().getName())) {
                continue;
            }

            requireParameters(call, 2);

            final Expression dataParameter = call.getParameters().get(0);
            final Expression deviationParameter = call.getParameters().get(1);
            final DataDescription description = new DataReferenceSwitch().doSwitch(dataParameter);
            final double deviation = new NumberSwitch().doSwitch(deviationParameter).doubleValue();

            // also rejects NaN
            if(!(deviation >= 0.0)) {
                throw new IllegalArgumentException("The standard deviation of '" + description.getName()
                                                   + "' must not be negative, but is " + deviation + ".");
            }

            final EStructuralFeature searchFeature = searchByData.get(description);
            final EStructuralFeature objective = objectivesByData.get(description);
            final EStructuralFeature feature = searchFeature != null ? searchFeature : objective;
            if(feature != null) {
                deviations.put(feature, deviation);
            }
        }

        return deviations;
    }

    static void requireParameters(final Call call, final int count) {
        final int actual = call.getParameters().size();

        if(actual != count) {
            final String function = call.getFunction().getName();
            final String text = ExpressionText.of(call);

            throw new IllegalArgumentException("'" + function + "' needs " + count + " parameters, but has " + actual
                                               + ": " + text + ".");
        }
    }

    private static Optional<Call> toCall(final Expression expression) {
        final Call call = new CallSwitch().doSwitch(expression);

        if(call == null) {
            log.warn("Ignoring the entry '{}' of a constraints section: it is no call.", ExpressionText.of(expression));
        }

        return Optional.ofNullable(call);
    }

    private static Constraint toConstraint(final int number,
                                           final Call call,
                                           final Map<DataDescription, EStructuralFeature> searchByData,
                                           final Map<DataDescription, EStructuralFeature> objectivesByData,
                                           final Map<EStructuralFeature, Double> deviations) {
        requireParameters(call, 2);

        final Expression comparison = call.getParameters().get(0);
        final Expression groupParameter = call.getParameters().get(1);
        final String group = new StringSwitch().doSwitch(groupParameter);
        final String text = ExpressionText.of(comparison);

        try {
            final ConditionCompiler compiler = new ConditionCompiler(searchByData, objectivesByData);

            return compiler.compile(number, group, text, comparison, deviations);
        } catch(final IllegalArgumentException e) {
            throw new IllegalArgumentException("The constraint '" + text + "' (group '" + group + "') cannot be used: "
                                               + e.getMessage(), e);
        }
    }
}
