package de.evoal.optimisation.ea.main.comparator;

import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.constraints.ViolationRecord;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessComponent;
import de.evoal.optimisation.api.fitness.Goal;
import de.evoal.optimisation.api.model.OptimisationValueComparator;

/**
 * The comparator of NSGA-II (DL type {@code 'crowded-comparator'}). The value of a candidate
 *   is its canonical fitness, compared by Pareto dominance ({@link ParetoValue}). The
 *   selections of the evolutionary algorithm compare by the crowded-comparison operator
 *   instead ({@link de.evoal.optimisation.ea.api.selection.CrowdedOrder}), with the front and
 *   crowding distance that {@code 'nsga2-selection'} computes.
 * <p>
 * Only the evolutionary algorithm can use it; its configuration checks that
 *   {@code 'nsga2-selection'} is configured as well. If the selection has a constraint
 *   {@code group}, the values compare by constrained domination on the violation of the group,
 *   as the selection does.
 */
@Dependent
@Named(CrowdedComparator.TYPE)
public class CrowdedComparator implements OptimisationValueComparator {
    /**
     * The fully qualified DL type.
     */
    public static final String TYPE = "de.evoal.optimisation.ea.optimisation.crowded-comparator";

    /**
     * The fully qualified DL type of the only algorithm that can use the comparator.
     */
    private static final String ALGORITHM = "de.evoal.optimisation.ea.optimisation.evolutionary-algorithm";

    /**
     * Holds the optimisation configuration.
     */
    @Inject
    private Blackboard board;

    /**
     * The constraint group of {@code 'nsga2-selection'}; {@code null} if there is none.
     */
    private String group;

    @Inject
    private AttributeHelper helper;

    /**
     * @return The constraint group of the selection of the replacement, if it is set;
     *   otherwise {@code null}.
     */
    private String groupOfSelection(final EObject algorithm) {
        final EObject replacement = helper.lookup(algorithm, "replacement");
        final EObject selection = helper.lookup(replacement, "selection");
        final EStructuralFeature groupFeature = selection.eClass().getEStructuralFeature("group");
        final boolean hasGroup = groupFeature != null && selection.eIsSet(groupFeature);

        return hasGroup ? helper.lookup(selection, "group") : null;
    }

    /**
     * @throws InitializationException if the comparator is not configured in an evolutionary
     *   algorithm.
     */
    @Override
    public CrowdedComparator init(final EObject configuration) throws InitializationException {
        final EObject optimisation = board.get(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION);
        final EObject algorithm = helper.lookup(optimisation, "algorithm");
        final String type = DynamicEClassProvider.dlTypeOf(algorithm);

        if(!ALGORITHM.equals(type)) {
            throw new InitializationException("'crowded-comparator' compares by Pareto dominance and needs the fronts of "
                                              + "'nsga2-selection'; only 'evolutionary-algorithm' can use it, not '" + type + "'.");
        }

        group = groupOfSelection(algorithm);

        return this;
    }

    @Override
    public ParetoValue toValue(final TypedEObject objectives, final Fitness fitness) {
        final List<EStructuralFeature> statisticsFeatures = fitness.layout()
                                                                   .components()
                                                                   .stream()
                                                                   .map(FitnessComponent::goal)
                                                                   .flatMap(Optional::stream)
                                                                   .map(Goal::objective)
                                                                   .toList();

        return new ParetoValue(objectives, fitness, statisticsFeatures);
    }

    /**
     * @throws IllegalArgumentException if the problem has no constraint in the group of the
     *   selection.
     */
    @Override
    public ParetoValue toValue(final TypedEObject objectives, final Fitness fitness, final ViolationRecord violations) {
        final ParetoValue value = toValue(objectives, fitness);
        if(group == null) {
            return value;
        }

        final double violation = violations.violation(group);

        return new ParetoValue(objectives, fitness, value.statisticsFeatures(), violation);
    }
}
