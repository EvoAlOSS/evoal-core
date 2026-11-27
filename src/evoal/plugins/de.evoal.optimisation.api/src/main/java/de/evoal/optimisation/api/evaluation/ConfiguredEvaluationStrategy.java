package de.evoal.optimisation.api.evaluation;

import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.RunScoped;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.optimisation.memory.PropertyScope;
import de.evoal.models.v202704.optimisation.memory.PropertyValueType;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.fitness.ObjectiveSamples;
import de.evoal.optimisation.main.evaluation.SingleEvaluation;

/**
 * The evaluation strategy of the algorithm of the run ({@code 'evaluation-strategy'}). It is
 *   read when the algorithm is created, i.e. in the definition phase of the run; a strategy
 *   with several samples then defines the properties of the memory model: the number of
 *   samples ({@value ObjectiveSamples#SAMPLES}) and the sample standard deviations
 *   ({@value ObjectiveSamples#STANDARD_DEVIATIONS}) of the individuals and, for
 *   re-evaluation, {@value #RE_EVALUATED} of the relationships.
 */
@RunScoped
public class ConfiguredEvaluationStrategy {
    /**
     * The property of the relationship of a re-evaluated member to its previous individual.
     */
    public static final String RE_EVALUATED = "re-evaluated";

    @Inject
    private Blackboard board;

    @Inject
    private AttributeHelper helper;

    @Inject
    private ExecutionRecorder recorder;

    @Inject
    @Named("optimisation-space")
    private Provider<Space> optimisationSpace;

    /**
     * The strategy of the run.
     */
    private EvaluationStrategy strategy = SingleEvaluation.INSTANCE;

    /**
     * Reads the strategy of the algorithm and defines its properties.
     */
    @PostConstruct
    public void initialise() {
        final EObject configuration = board.getOrNull(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION);
        if(configuration == null) {
            return;
        }

        final EObject algorithm = helper.lookup(configuration, "algorithm");
        final EObject strategyConfiguration = helper.lookup(algorithm, "evaluation-strategy");
        strategy = BeanFactory.createComponent(EvaluationStrategy.class, strategyConfiguration);

        defineProperties(recorder, strategy);
    }

    /**
     * @return The strategy of the run.
     */
    public EvaluationStrategy strategy() {
        return strategy;
    }

    /**
     * @return The objectives that cannot be aggregated because they are not real-valued; empty
     *   for a strategy with one sample per candidate.
     */
    public List<String> objectivesThatCannotBeAggregated() {
        if(!strategy.samples()) {
            return List.of();
        }

        return optimisationSpace.get()
                                .stream()
                                .filter(feature -> !EClassifierHelper.isReal(feature.getEType()))
                                .map(EStructuralFeature::getName)
                                .toList();
    }

    /**
     * Defines the properties of the memory model that the strategy records, nothing for a
     *   strategy with one sample per candidate.
     *
     * @param recorder The recorder of the run, in its definition phase.
     * @param strategy The evaluation strategy of the run.
     */
    public static void defineProperties(final ExecutionRecorder recorder, final EvaluationStrategy strategy) {
        if(!strategy.samples()) {
            return;
        }

        recorder.defineProperty(ObjectiveSamples.SAMPLES, PropertyScope.INDIVIDUAL, PropertyValueType.INTEGER, false,
                                "Number of evaluations whose objectives are aggregated in the output.");
        recorder.defineProperty(ObjectiveSamples.STANDARD_DEVIATIONS, PropertyScope.INDIVIDUAL, PropertyValueType.REAL, true,
                                "Sample standard deviation of every objective over the evaluations, in the order of the"
                                + " objectives; only with at least two evaluations.");

        if(strategy.reEvaluates()) {
            recorder.defineProperty(RE_EVALUATED, PropertyScope.RELATIONSHIP, PropertyValueType.BOOLEAN, false,
                                    "The member was evaluated once more at the start of the iteration; its output"
                                    + " aggregates all its evaluations.");
        }
    }
}
