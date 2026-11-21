package de.evoal.optimisation.cma_es.main;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.core.utils.FQNProvider;
import de.evoal.models.v202704.optimisation.memory.PropertyScope;
import de.evoal.models.v202704.optimisation.memory.PropertyValueType;

import de.evoal.optimisation.api.checks.CheckPoint;
import de.evoal.optimisation.api.checks.CheckReaction;
import de.evoal.optimisation.api.correlations.LinkageGroup;
import de.evoal.optimisation.api.correlations.ProblemCorrelations;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.fitness.Evaluator;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.run.Population;
import de.evoal.optimisation.api.steps.EvaluateCandidates;
import de.evoal.optimisation.api.steps.Step;
import de.evoal.optimisation.api.steps.Template;
import de.evoal.optimisation.api.steps.TemplateAlgorithm;

import de.evoal.optimisation.cma_es.main.distribution.BoundTransform;
import de.evoal.optimisation.cma_es.main.distribution.CovarianceModel;
import de.evoal.optimisation.cma_es.main.distribution.Distribution;
import de.evoal.optimisation.cma_es.main.distribution.StrategyParameters;
import de.evoal.optimisation.cma_es.main.distribution.TerminationCriteria;
import de.evoal.optimisation.cma_es.main.restart.RestartStrategy;
import de.evoal.optimisation.cma_es.main.restart.RunSetting;

/**
 * The covariance matrix adaptation evolution strategy (DL type {@code 'cma-es'}), a
 *   (mu/mu_w, lambda)-CMA-ES as a template of steps.
 * <p>
 * Initialisation (iteration 0):
 * <ol>
 *   <li>ParameterAdjustment: set up the distribution with the first candidate of the
 *     'initialisation' as its mean, the initial step size and C = I,</li>
 *   <li>Adaption: sample lambda candidates from N(m, sigma^2 C), mapped into the bounds,</li>
 *   <li>Check: the checks of new candidates, if any are configured,</li>
 *   <li>FitnessCalculation: evaluate them,</li>
 *   <li>Acceptance: they become the population (comma selection).</li>
 * </ol>
 * Every iteration:
 * <ol>
 *   <li>Selection: the mu best members,</li>
 *   <li>ParameterAdjustment: update the mean, the evolution paths, the covariance matrix and
 *     the step size,</li>
 *   <li>ParameterAdjustment: if a termination criterion of CMA-ES holds, restart with the
 *     next distribution of the restart strategy (the next candidate of the 'initialisation'
 *     as mean), or end the search,</li>
 *   <li>Adaption, Check, FitnessCalculation and Acceptance as in the initialisation.</li>
 * </ol>
 * Only real search features are supported. The candidate checks of new candidates may warn
 *   or resample; replacing or repairing a candidate would bias the update, since it is not a
 *   sample of the distribution.
 */
@Dependent
@Named("de.evoal.optimisation.cma_es.optimisation.cma-es")
@Slf4j
public class CmaEsAlgorithm extends TemplateAlgorithm {
    /**
     * The DL type of the diagonal covariance model.
     */
    private static final String DIAGONAL = "de.evoal.optimisation.cma_es.optimisation.diagonal-covariance";

    /**
     * The DL type of the full covariance model.
     */
    private static final String FULL = "de.evoal.optimisation.cma_es.optimisation.full-covariance";

    private static final FQNProvider NAMES = new FQNProvider();

    /**
     * The bounds of the search features.
     */
    private BoundTransform bounds;

    /**
     * Whether the covariance matrix is diagonal.
     */
    private boolean diagonal;

    @Inject
    private Evaluator evaluator;

    @Inject
    private AttributeHelper helper;

    /**
     * The initial step size sigma_0.
     */
    private double initialStepSize;

    /**
     * The learning rates of the configuration; {@code null} keeps the default.
     */
    private Double[] learningRates = new Double[6];

    @Inject
    private DistributionMetrics metrics;

    /**
     * The configured number of parents, {@code null} for the default.
     */
    private Integer parentNumber;

    /**
     * The population size of the configuration, lambda_default.
     */
    private int populationSize;

    @Inject
    private ProblemCorrelations problemCorrelations;

    @Inject @Named("initial")
    private InitialCandidatesProvider provider;

    @Inject
    private RandomService randomService;

    @Inject
    private ExecutionRecorder recorder;

    /**
     * The restart strategy.
     */
    private RestartStrategy restartStrategy;

    @Inject @Named("search-space")
    private Space searchSpace;

    /**
     * The termination criteria of CMA-ES.
     */
    private TerminationCriteria termination;

    /**
     * @return The bounds of the search features from the DDL; a side without bound is
     *   infinite.
     */
    private static BoundTransform boundsOf(final List<EStructuralFeature> features) {
        final double[] lower = new double[features.size()];
        final double[] upper = new double[features.size()];
        for(int i = 0; i < features.size(); ++i) {
            lower[i] = boundOf(features.get(i), FeatureBoundaries.LOWER, Double.NEGATIVE_INFINITY);
            upper[i] = boundOf(features.get(i), FeatureBoundaries.UPPER, Double.POSITIVE_INFINITY);
        }

        return new BoundTransform(lower, upper);
    }

    /**
     * @param side {@link FeatureBoundaries#LOWER} or {@link FeatureBoundaries#UPPER}.
     * @return The bound of the side as declared in the DDL, otherwise the given infinity.
     */
    private static double boundOf(final EStructuralFeature feature, final String side, final double unbounded) {
        final EAnnotation annotation = feature.getEAnnotation(FeatureBoundaries.BOUNDARIES_SOURCE);
        if(annotation == null || !annotation.getDetails().containsKey(side)) {
            return unbounded;
        }

        final String literal = annotation.getDetails().get(side);

        return Double.parseDouble(literal);
    }

    /**
     * @return The check points: new candidates, before their evaluation.
     */
    @Override
    protected Set<CheckPoint> checkPoints() {
        return Set.of(CheckPoint.NEW_CANDIDATES);
    }

    @Override
    protected void configure(final EObject configuration) throws InitializationException {
        final List<EStructuralFeature> features = new ArrayList<>(searchSpace);
        for(final EStructuralFeature feature : features) {
            if(!EClassifierHelper.isReal(feature.getEType())) {
                throw new InitializationException("CMA-ES supports only real search variables, but '" + feature.getName()
                                                  + "' is of type " + feature.getEType().getName() + ".");
            }
        }

        initialStepSize = helper.<Double>lookup(configuration, "initial-step-size");
        final Integer configuredPopulationSize = optional(configuration, "population-size");
        populationSize = configuredPopulationSize == null ? StrategyParameters.defaultPopulationSize(features.size())
                                                          : configuredPopulationSize;
        parentNumber = optional(configuration, "parent-number");
        diagonal = isDiagonal(helper.lookup(configuration, "covariance-model"));
        readLearningRates(optional(configuration, "learning-rates"));
        termination = readTermination(helper.lookup(configuration, "termination"));
        restartStrategy = BeanFactory.createComponent(RestartStrategy.class, helper.lookup(configuration, "restart-strategy"));
        bounds = boundsOf(features);

        try {
            final StrategyParameters parameters = parametersFor(populationSize);
            log.info("CMA-ES with {} ({} covariance matrix).", parameters, diagonal ? "diagonal" : "full");
        } catch(final IllegalArgumentException e) {
            throw new InitializationException("The parameters of CMA-ES cannot be used: " + e.getMessage(), e);
        }

        defineRecords(configuration, features);
    }

    /**
     * Defines the iteration metrics of the distribution and the properties of the candidates.
     */
    private void defineRecords(final EObject configuration, final List<EStructuralFeature> features) {
        final boolean allPairs = helper.<Boolean>lookup(configuration, "record-all-correlations");
        final List<LinkageGroup> groups = diagonal ? List.of() : problemCorrelations.correlations().linkageGroups();
        metrics.define(recorder, features, groups, allPairs && !diagonal, bounds);

        if(!bounds.isIdentity()) {
            recorder.defineProperty(SampleDistribution.GENOTYPE, PropertyScope.INDIVIDUAL, PropertyValueType.REAL, true,
                                    "The point of the distribution of CMA-ES that the bounds transformed into the "
                                    + "candidate; set only if it differs from the candidate.");
        }

        if(restartStrategy.restarts()) {
            recorder.defineProperty(SampleDistribution.RESTART, PropertyScope.INDIVIDUAL, PropertyValueType.INTEGER, false,
                                    "The number of the CMA-ES run whose distribution sampled the candidate, 0 before "
                                    + "the first restart.");
        }
    }

    /**
     * @return The distribution of a CMA-ES run.
     */
    private Distribution distributionFor(final RunSetting setting, final double[] initialMean) {
        final StrategyParameters parameters = parametersFor(setting.populationSize());
        final int dimension = parameters.dimension();
        final CovarianceModel covariance = diagonal ? CovarianceModel.diagonal(dimension)
                                                    : CovarianceModel.full(dimension, decompositionGap(parameters));

        return new Distribution(parameters, covariance, initialMean, initialStepSize * setting.stepSizeFactor());
    }

    /**
     * @return max(1, floor(1 / (10 n (c_1 + c_mu)))), appendix B.2 of the tutorial.
     */
    private static int decompositionGap(final StrategyParameters parameters) {
        final double rates = parameters.c1() + parameters.cMu();
        final double gap = 1.0 / (10.0 * parameters.dimension() * rates);

        return Math.max(1, (int) Math.floor(gap));
    }

    private static boolean isDiagonal(final EObject covarianceModel) throws InitializationException {
        final String name = NAMES.get(covarianceModel);
        if(DIAGONAL.equals(name)) {
            return true;
        }
        if(FULL.equals(name)) {
            return false;
        }

        throw new InitializationException("Unknown covariance model '" + name + "'.");
    }

    private <T> T optional(final EObject configuration, final String name) {
        final EStructuralFeature feature = configuration.eClass().getEStructuralFeature(name);
        if(feature == null || !configuration.eIsSet(feature)) {
            return null;
        }

        return helper.lookup(configuration, name);
    }

    /**
     * @return The parameters for the population size: the defaults of the tutorial, those of
     *   sep-CMA-ES for the diagonal model, then the configured learning rates. The configured
     *   number of parents applies to the configured population size; other population sizes
     *   (restarts) have floor(lambda / 2) parents.
     * @throws IllegalArgumentException if the parameters do not fit.
     */
    private StrategyParameters parametersFor(final int lambda) {
        final int dimension = searchSpace.size();
        final boolean configuredSize = lambda == populationSize && parentNumber != null;
        final int parents = configuredSize ? parentNumber : lambda / 2;

        final StrategyParameters defaults = StrategyParameters.defaults(dimension, lambda, Math.max(1, parents));
        final StrategyParameters model = diagonal ? defaults.separable() : defaults;

        return model.with(learningRates[0], learningRates[1], learningRates[2], learningRates[3], learningRates[4],
                          learningRates[5]);
    }

    /**
     * @return The reactions that keep the candidates samples of the distribution: warn and
     *   resample.
     */
    @Override
    protected Set<CheckReaction> reactions() {
        return EnumSet.of(CheckReaction.WARN, CheckReaction.RESAMPLE);
    }

    private void readLearningRates(final EObject configuration) {
        if(configuration == null) {
            return;
        }

        final String[] names = {"c-sigma", "d-sigma", "c-c", "c-1", "c-mu", "c-m"};
        for(int i = 0; i < names.length; ++i) {
            learningRates[i] = optional(configuration, names[i]);
        }
    }

    private TerminationCriteria readTermination(final EObject configuration) {
        return new TerminationCriteria(helper.<Double>lookup(configuration, "tol-fun"),
                                       helper.<Double>lookup(configuration, "tol-x"),
                                       helper.<Double>lookup(configuration, "tol-x-up"),
                                       helper.<Double>lookup(configuration, "condition-cov"),
                                       helper.<Boolean>lookup(configuration, "no-effect-axis"),
                                       helper.<Boolean>lookup(configuration, "no-effect-coord"),
                                       helper.<Boolean>lookup(configuration, "equal-fun-values"),
                                       helper.<Boolean>lookup(configuration, "stagnation"));
    }

    /**
     * @return {@code true}: a failed candidate is sampled again from the distribution.
     */
    @Override
    protected boolean resamples() {
        return true;
    }

    @Override
    protected Template template() {
        final SampleDistribution sampling = new SampleDistribution(restartStrategy.restarts(), !bounds.isIdentity());
        final List<Step> checks = newCandidateChecks(sampling);
        final List<Step> initialisation = new ArrayList<>();
        initialisation.add(new SetUpDistribution(this::newRun));
        initialisation.add(sampling);
        initialisation.addAll(checks);
        initialisation.add(new EvaluateCandidates(evaluator));
        initialisation.add(new AcceptSamples());

        final List<Step> iteration = new ArrayList<>();
        iteration.add(new SelectParents());
        iteration.add(new UpdateDistribution());
        iteration.add(new CheckTermination(termination, restartStrategy.restarts()));
        iteration.add(sampling);
        iteration.addAll(checks);
        iteration.add(new EvaluateCandidates(evaluator));
        iteration.add(new AcceptSamples());

        return new CmaEsTemplate(initialisation, iteration);
    }

    private CmaEsRun newRun() {
        final Iterator<TypedEObject> means = provider.create().iterator();

        return new CmaEsRun(this::distributionFor,
                            bounds,
                            searchSpace,
                            means,
                            restartStrategy.schedule(populationSize),
                            randomService.random("de.evoal.optimisation.cma_es/sampling"),
                            randomService.random("de.evoal.optimisation.cma_es/restart"));
    }

    /**
     * The template of CMA-ES; it shows the distribution of every population to the metrics.
     */
    private final class CmaEsTemplate extends Template {
        private CmaEsTemplate(final List<Step> initialisation, final List<Step> iteration) {
            super(initialisation, iteration);
        }

        @Override
        public Population population() {
            state().strategy(SetUpDistribution.RUN)
                   .ifPresent(run -> metrics.show(run.distribution(), run.restartNumber()));

            return super.population();
        }
    }
}
