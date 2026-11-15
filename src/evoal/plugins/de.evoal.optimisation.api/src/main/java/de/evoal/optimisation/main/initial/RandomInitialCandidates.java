package de.evoal.optimisation.main.initial;

import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.core.api.random.RandomService;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.utils.Requirements;

import de.evoal.optimisation.api.model.InitialCandidatesProvider;

@Slf4j
@Dependent
@Named("de.evoal.optimisation.core.random-population")
public class RandomInitialCandidates implements InitialCandidatesProvider {

    @Inject
    private FeatureBoundaries boundaries;

    @Inject @Named("search-space")
    private Space searchSpace;

    @Inject
    private RandomService randomService;

    @Override
    public Stream<TypedEObject> create() {
        final AtomicInteger counter = new AtomicInteger();
        final RandomGenerator randomness = randomService.random("de.evoal.optimisation.core.random-population");

        checkFeatureTypes();

        Consumer<TypedEObject> randomCandidateProducer = (object) -> {};
        for(final EStructuralFeature feature : searchSpace) {
            randomCandidateProducer = randomCandidateProducer.andThen(producerFor(feature, randomness));
        }

        final Consumer<TypedEObject> producer = randomCandidateProducer;
        return Stream.generate(() -> {
            log.info("Creating random initial candidate #{}.", counter.getAndIncrement());
            final TypedEObject object =  searchSpace.newEObject();

            producer.accept(object);

            return object;
        });
    }

    /**
     * Creates a producer that sets a random value within the boundaries of the feature.
     */
    private Consumer<TypedEObject> producerFor(final EStructuralFeature feature, final RandomGenerator randomness) {
        final EClassifier classifier = feature.getEType();

        if(EClassifierHelper.isBoolean(classifier)) {
            return (object) -> object.eSet(feature, randomness.nextBoolean());
        }

        final FeatureBoundaries.Boundaries bounds = boundaries.get(feature);

        if(EClassifierHelper.isDouble(classifier)) {
            final double lower = bounds.lower().doubleValue();
            final double upper = bounds.upper().doubleValue();

            // interpolation does not overflow, even for the full range of double
            return (object) -> {
                final double ratio = randomness.nextDouble();
                object.eSet(feature, ratio * upper + (1.0 - ratio) * lower);
            };
        }

        // integer: the bounds are within the int range, so long arithmetic cannot overflow
        final long lower = bounds.lower().longValue() + (bounds.lowerIncluded() ? 0 : 1);
        final long upper = bounds.upper().longValue() - (bounds.UpperIncluded() ? 0 : 1);
        Requirements.requireTrue(lower <= upper, "Feature '" + feature.getName() + "' has no valid value.");

        return (object) -> object.eSet(feature, (int) randomness.nextLong(lower, upper + 1));
    }

    /**
     * Only integer, real, and boolean data is supported.
     */
    private void checkFeatureTypes() {
        for(final EStructuralFeature feature : searchSpace) {
            final EClassifier classifier = feature.getEType();

            Requirements.requireTrue(
                    EClassifierHelper.isInteger(classifier) ||
                            EClassifierHelper.isDouble(classifier) ||
                            EClassifierHelper.isBoolean(classifier),
                    "Representation type " + classifier.getName() + " of '" + feature.getName() + "' not supported");
        }
    }
}
