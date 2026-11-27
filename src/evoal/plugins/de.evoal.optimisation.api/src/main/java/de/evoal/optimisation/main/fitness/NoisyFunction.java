package de.evoal.optimisation.main.fitness;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.Requirements;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl;
import de.evoal.optimisation.api.evaluation.EvaluationSource;
import de.evoal.optimisation.api.evaluation.EvaluationSourceProvider;

/**
 * An optimisation function with noise (DL type {@code 'noisy-function'}): evaluates the
 *   wrapped function and adds Gaussian noise to every objective, {@code v + e}
 *   ({@code additive}) or {@code v * (1 + e)} ({@code multiplicative}), with e drawn from a
 *   normal distribution with mean 0 and the configured standard deviation.
 * <p>
 * The noise comes from the task stream of the evaluation ({@link RandomService#taskRandom}),
 *   so it depends only on the seed, the run and the index of the evaluation. The function
 *   is thread-safe iff the wrapped function is, and it reports the source of the wrapped
 *   function (real or surrogate).
 */
@Dependent
@Named("de.evoal.optimisation.core.noisy-function")
public class NoisyFunction extends OptimisationFunctionImpl implements EvaluationSourceProvider {
    /**
     * The name of the task stream.
     */
    private static final String STREAM = "de.evoal.optimisation.core.noisy-function";

    @Inject
    private AttributeEvaluator evaluator;

    @Inject
    private AttributeHelper helper;

    @Inject
    private RandomService randomService;

    @Inject
    @Named("optimisation-space")
    private Space optimisationSpace;

    /**
     * The function whose objectives get the noise.
     */
    private OptimisationFunction delegate;

    /**
     * Whether the noise scales the objectives instead of adding to them.
     */
    private boolean multiplicative;

    /**
     * The standard deviation of the noise.
     */
    private double standardDeviation;

    @Override
    public TypedEObject evaluate(final TypedEObject candidate) {
        final TypedEObject objectives = new TypedEObject(delegate.evaluate(candidate));
        final RandomGenerator random = randomService.taskRandom(STREAM);

        for(final EAttribute objective : objectives.eClass().getEAllAttributes()) {
            final double value = ((Number) objectives.eGet(objective)).doubleValue();
            final double noise = standardDeviation * random.nextGaussian();

            objectives.eSet(objective, multiplicative ? value * (1.0 + noise) : value + noise);
        }

        return objectives;
    }

    /**
     * {@inheritDoc}
     * <p>
     * The noise of every evaluation comes from its own task stream, so the function is
     *   thread-safe iff the wrapped function is.
     */
    @Override
    public boolean isThreadSafe() {
        return delegate.isThreadSafe();
    }

    @Override
    public EvaluationSource getEvaluationSource() {
        return EvaluationSource.of(delegate);
    }

    @Override
    public NoisyFunction init(final EObject configuration) {
        for(final var feature : optimisationSpace) {
            Requirements.requireTrue(EClassifierHelper.isReal(feature.getEType()),
                                     "The objective '" + feature.getName() + "' of a 'noisy-function' is not real-valued.");
        }

        delegate = BeanFactory.createComponent(OptimisationFunction.class, helper.<EObject>lookup(configuration, "function"));
        multiplicative = "multiplicative".equals(helper.<EEnumLiteral>lookup(configuration, "noise").getName());
        standardDeviation = evaluator.attributeToDouble(configuration, "standard-deviation");

        return this;
    }
}
