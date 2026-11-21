package de.evoal.optimisation.main.initial;

import java.util.List;
import java.util.function.Supplier;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.ecore.stream.EObjectStreamSupplier;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;

/**
 * Base of the initial populations of given candidates ({@code 'specify-candidates'},
 *   {@code 'candidates-from-file'}): the candidates are drawn uniformly with repetition
 *   ({@code random}), or one after the other, starting again after the last one.
 */
@Slf4j
public abstract class GivenInitialCandidates implements InitialCandidatesProvider {
    @Inject
    @Named("search-space")
    protected Space searchSpace;

    @Inject
    protected AttributeHelper helper;

    @Inject
    private RandomService randomService;

    /**
     * Supplies the given candidates.
     */
    private EObjectStreamSupplier streamSupplier;

    /**
     * Whether the candidates are drawn uniformly with repetition.
     */
    private boolean random;

    @Override
    public InitialCandidatesProvider init(final EObject configuration) {
        random = helper.lookup(configuration, "random");
        streamSupplier = supplier(configuration);

        return this;
    }

    /**
     * @param configuration The configuration of the population.
     * @return The supplier of the given candidates.
     */
    protected abstract EObjectStreamSupplier supplier(EObject configuration);

    /**
     * @return The name of the random stream of the draws.
     */
    protected abstract String stream();

    @Override
    public Stream<TypedEObject> create() {
        final List<TypedEObject> candidates = streamSupplier.apply(searchSpace).toList();
        final RandomGenerator generator = random ? randomService.random(stream()) : null;

        return order(candidates, generator, getClass().getSimpleName());
    }

    /**
     * @param candidates The given candidates.
     * @param random The generator for drawing with repetition, {@code null} for one after the
     *   other.
     * @param source The source of the candidates, for the message.
     * @return An unlimited stream of the candidates.
     * @throws IllegalStateException if there are no candidates.
     */
    static Stream<TypedEObject> order(final List<TypedEObject> candidates, final RandomGenerator random, final String source) {
        if(candidates.isEmpty()) {
            throw new IllegalStateException("The initial population " + source + " has no candidates.");
        }

        if(random != null) {
            log.info("Drawing the given candidates uniformly with repetition.");
            final Supplier<TypedEObject> draw = () -> candidates.get(random.nextInt(candidates.size()));
            return Stream.iterate(draw.get(), previous -> draw.get());
        }

        log.info("Taking the given candidates one after the other.");
        return Stream.iterate(0, i -> (i + 1) % candidates.size())
                     .map(candidates::get);
    }
}
