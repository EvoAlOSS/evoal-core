package de.evoal.pipeline.impl.components.misc;

import java.util.List;
import java.util.Optional;
import java.util.random.RandomGenerator;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.pipeline.api.model.PipelineFilterImpl;
import de.evoal.pipeline.impl.components.distributions.RandomStreams;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;

/**
 * Rejection sampling (DL type {@code 'rejection-sampling'}): keeps a row with the probability
 *   p that its {@code 'acceptance-probability'} computes from the read data. A uniform random
 *   number u in [0, 1) is drawn for every row from the filter's own random stream
 *   ({@link RandomStreams}), and the row is kept if u < p, so the same seed keeps the same rows.
 *   A p outside [0, 1] stops the run.
 */
@Dependent
@Named(RejectionSampling.NAME)
public class RejectionSampling extends PipelineFilterImpl {
    /**
     * The CDI name of the filter, which also names its random streams.
     */
    static final String NAME = "de.evoal.pipeline.misc.rejection-sampling";

    @Inject
    private EAnnotationHelper helper;

    @Inject
    private RandomStreams randomStreams;

    /**
     * The acceptance probability.
     */
    private ReadDataExpression probability;

    /**
     * The random stream of this filter.
     */
    private RandomGenerator randomness;

    /**
     * Creates a filter that is configured by {@link #init(EObject)}.
     */
    public RejectionSampling() {
    }

    /**
     * Creates a configured filter, e.g., for tests.
     *
     * @param maximumConsecutiveRejections The number of rows in a row that the filter may drop.
     * @param probability The acceptance probability.
     * @param pipeline The space of the pipeline.
     * @param reads The data the step reads.
     * @param randomness The random numbers of the filter.
     * @throws InitializationException if the probability uses data that the step does not read.
     */
    RejectionSampling(final int maximumConsecutiveRejections, final Expression probability, final Space pipeline, final Space reads,
                      final RandomGenerator randomness) throws InitializationException {
        super("rejection-sampling", maximumConsecutiveRejections);
        this.helper = new EAnnotationHelper();
        this.randomness = randomness;
        setFeatures(pipeline, reads, pipeline.subSpace(List.of()));
        configure(probability);
    }

    @Override
    public PipelineComponentImpl init(final EObject configuration) throws InitializationException {
        super.init(configuration);
        configure(ReadDataExpression.of(configuration, "acceptance-probability"));
        randomness = randomStreams.forNewInstance(NAME);

        return this;
    }

    private void configure(final Expression expression) throws InitializationException {
        probability = new ReadDataExpression("acceptance probability", expression, readData(helper));
    }

    @Override
    protected Optional<String> violation(final @NonNull TypedEObject row) {
        final Object result = probability.evaluate(row);
        final double p = result instanceof Number number ? number.doubleValue() : Double.NaN;

        // also rejects NaN
        if(!(p >= 0.0 && p <= 1.0)) {
            throw new IllegalStateException("The acceptance probability '" + probability.text() + "' is " + result
                                            + " for a row, but must be in [0, 1].");
        }

        // drawn for every row, so the stream does not depend on the values of p
        final double u = randomness.nextDouble();

        return u < p ? Optional.empty() : Optional.of("was rejected with the acceptance probability " + p);
    }
}
