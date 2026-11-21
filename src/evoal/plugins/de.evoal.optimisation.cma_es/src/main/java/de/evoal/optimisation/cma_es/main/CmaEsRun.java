package de.evoal.optimisation.cma_es.main;

import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.random.RandomGenerator;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.random.Gaussian;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.cma_es.main.distribution.BoundTransform;
import de.evoal.optimisation.cma_es.main.distribution.Distribution;
import de.evoal.optimisation.cma_es.main.distribution.RunHistory;
import de.evoal.optimisation.cma_es.main.restart.RestartSchedule;
import de.evoal.optimisation.cma_es.main.restart.RunSetting;

/**
 * The state of CMA-ES in one optimisation run: the distribution of the current CMA-ES run
 *   (since the start or the last restart), its history, the restart schedule, and the
 *   genotypes of the candidates sampled last.
 */
final class CmaEsRun {
    /**
     * The bounds of the search variables.
     */
    private final BoundTransform bounds;

    /**
     * Creates the distribution of a CMA-ES run.
     */
    private final DistributionFactory factory;

    /**
     * The distribution of the current CMA-ES run.
     */
    private Distribution distribution;

    /**
     * The evaluations of the current CMA-ES run.
     */
    private long evaluations;

    /**
     * The genotypes of the candidates sampled last, by their input; the survivors of a
     *   candidate share its input.
     */
    private Map<TypedEObject, double[]> genotypes = new IdentityHashMap<>();

    /**
     * The function values of the current CMA-ES run.
     */
    private RunHistory history = new RunHistory();

    /**
     * The initial step size of the current CMA-ES run.
     */
    private double initialStepSize;

    /**
     * The candidates of the 'initialisation' that become the initial means.
     */
    private final Iterator<TypedEObject> means;

    /**
     * The number of the current CMA-ES run, 0 for the first one.
     */
    private int restart;

    /**
     * The random numbers of the restart strategy.
     */
    private final RandomGenerator restartRandom;

    /**
     * The random numbers of the samples.
     */
    private final RandomGenerator samplingRandom;

    /**
     * The restart schedule of the optimisation run.
     */
    private final RestartSchedule schedule;

    /**
     * The search space; its features are the variables of the distribution, in their order.
     */
    private final Space searchSpace;

    /**
     * The setting of the current CMA-ES run.
     */
    private RunSetting setting;

    CmaEsRun(final DistributionFactory factory, final BoundTransform bounds, final Space searchSpace,
             final Iterator<TypedEObject> means, final RestartSchedule schedule, final RandomGenerator samplingRandom,
             final RandomGenerator restartRandom) {
        this.factory = factory;
        this.bounds = bounds;
        this.searchSpace = searchSpace;
        this.means = means;
        this.schedule = schedule;
        this.samplingRandom = samplingRandom;
        this.restartRandom = restartRandom;

        start(schedule.first());
    }

    /**
     * Counts the evaluated candidates of an iteration of the current CMA-ES run.
     */
    void countEvaluations(final int count) {
        evaluations += count;
    }

    /**
     * @return The distribution of the current CMA-ES run.
     */
    Distribution distribution() {
        return distribution;
    }

    /**
     * @param input A candidate sampled last, or one of its survivors.
     * @return Its genotype, the point of the distribution.
     */
    double[] genotypeOf(final TypedEObject input) {
        final double[] genotype = genotypes.get(input);
        if(genotype != null) {
            return genotype.clone();
        }

        // a candidate the distribution did not sample, e.g., a warned candidate kept as is
        return bounds.inverse(valuesOf(input));
    }

    /**
     * @param input A candidate sampled last.
     * @return Its genotype if the bounds changed it, otherwise empty.
     */
    Optional<List<Double>> transformedGenotypeOf(final TypedEObject input) {
        final double[] genotype = genotypes.get(input);
        final double[] phenotype = valuesOf(input);
        if(genotype == null || Arrays.equals(genotype, phenotype)) {
            return Optional.empty();
        }

        return Optional.of(Arrays.stream(genotype)
                                 .boxed()
                                 .toList());
    }

    /**
     * @return The function values of the current CMA-ES run.
     */
    RunHistory history() {
        return history;
    }

    /**
     * @return The initial step size of the current CMA-ES run.
     */
    double initialStepSize() {
        return initialStepSize;
    }

    /**
     * Starts the next CMA-ES run of the restart schedule.
     *
     * @return Whether the schedule restarts.
     */
    boolean restart() {
        final Optional<RunSetting> next = schedule.next(evaluations, restartRandom);
        if(next.isEmpty()) {
            return false;
        }

        ++restart;
        start(next.get());

        return true;
    }

    /**
     * @return The number of the current CMA-ES run, 0 for the first one.
     */
    int restartNumber() {
        return restart;
    }

    /**
     * Samples a new candidate from the distribution and keeps its genotype.
     *
     * @return The phenotype, the point within the bounds.
     */
    TypedEObject sample() {
        final int dimension = searchSpace.size();
        final double[] standardNormal = new double[dimension];
        for(int i = 0; i < dimension; ++i) {
            standardNormal[i] = Gaussian.next(samplingRandom);
        }

        final double[] genotype = distribution.sample(standardNormal);
        final double[] phenotype = bounds.transform(genotype);
        final TypedEObject input = toInput(phenotype);
        genotypes.put(input, genotype);

        return input;
    }

    /**
     * @return The setting of the current CMA-ES run.
     */
    RunSetting setting() {
        return setting;
    }

    /**
     * Forgets the genotypes of the candidates sampled before; called before a new population
     *   is sampled.
     */
    void startSampling() {
        genotypes = new IdentityHashMap<>();
    }

    private void start(final RunSetting runSetting) {
        if(!means.hasNext()) {
            throw new IllegalStateException("The 'initialisation' has no further candidate for the mean of CMA-ES run "
                                            + (restart + 1) + ".");
        }

        final double[] initialMean = bounds.inverse(valuesOf(means.next()));
        setting = runSetting;
        distribution = factory.create(runSetting, initialMean);
        initialStepSize = distribution.stepSize();
        history = new RunHistory();
        evaluations = 0;
    }

    /**
     * @return The candidate with the given values of the search features.
     */
    private TypedEObject toInput(final double[] values) {
        final TypedEObject input = searchSpace.newEObject();
        int i = 0;
        for(final EStructuralFeature feature : searchSpace) {
            input.eSet(feature, values[i]);
            ++i;
        }

        return input;
    }

    private double[] valuesOf(final TypedEObject input) {
        final double[] values = new double[searchSpace.size()];
        int i = 0;
        for(final EStructuralFeature feature : searchSpace) {
            values[i] = input.eGetAsDouble(feature);
            ++i;
        }

        return values;
    }

    /**
     * Creates the distribution of a CMA-ES run from its setting and its initial mean.
     */
    @FunctionalInterface
    interface DistributionFactory {
        Distribution create(RunSetting setting, double[] initialMean);
    }
}
