package de.evoal.optimisation.main.initial;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.random.RandomService;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.builder.BuildSettings;
import de.evoal.optimisation.api.builder.ModelBuilder;
import de.evoal.optimisation.api.builder.ModelTypes;
import de.evoal.optimisation.api.builder.ValueDrawer;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.models.ModelCandidates;

/**
 * The random population ({@code 'random-population'}): every feature of the search space gets a
 *   random value (see {@link ValueDrawer}), structured data a random model of its DL type
 *   (see {@link ModelBuilder}) built with the {@code method}. The models are checked when the
 *   stream of candidates is created; a model that cannot be built is reported with all its
 *   problems.
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.core.random-population")
public class RandomInitialCandidates implements InitialCandidatesProvider {
    /**
     * The name of the random stream of the population.
     */
    private static final String STREAM = "de.evoal.optimisation.core.random-population";

    /**
     * The model features of the search space, their DL types and the builder settings.
     */
    @Inject
    private ModelCandidates models;

    /**
     * The settings of the builder of models; {@code null} if the configuration has no
     *   {@code method}.
     */
    private BuildSettings settings;

    @Inject
    private RandomService randomService;

    @Inject @Named("search-space")
    private Space searchSpace;

    @Override
    public Stream<TypedEObject> create() {
        final AtomicInteger counter = new AtomicInteger();
        final RandomGenerator randomness = randomService.random(STREAM);
        final ValueDrawer values = models.values();
        final ModelBuilder builder = modelBuilder(values, randomness).orElse(null);

        return Stream.generate(() -> {
            final int index = counter.getAndIncrement();
            log.info("Creating random initial candidate #{}.", index);

            final TypedEObject object = searchSpace.newEObject();
            for(final EStructuralFeature feature : searchSpace) {
                final Object value = valueOf(feature, index, values, builder, randomness);
                object.eSet(feature, value);
            }

            return object;
        });
    }

    @Override
    public InitialCandidatesProvider init(final EObject configuration) {
        settings = ModelCandidates.optionalValue(configuration, "method")
                                  .map(EObject.class::cast)
                                  .map(ModelCandidates::settingsOf)
                                  .orElse(null);

        return this;
    }

    /**
     * Checks the search space and, if it contains structured data, creates the builder.
     *
     * @throws IllegalArgumentException with all problems if a feature cannot get random values.
     */
    private Optional<ModelBuilder> modelBuilder(final ValueDrawer values, final RandomGenerator randomness) {
        final List<String> problems = new ArrayList<>();
        final List<EClass> roots = new ArrayList<>();

        for(final EStructuralFeature feature : searchSpace) {
            if(feature instanceof EReference model) {
                roots.add(model.getEReferenceType());
            } else {
                values.problemOf((EAttribute) feature)
                      .ifPresent(problems::add);
            }
        }

        if(roots.isEmpty()) {
            requireNoProblems(problems);

            return Optional.empty();
        }

        if(settings == null) {
            problems.add("the search space contains structured data, so 'random-population' needs a 'method'");
            requireNoProblems(problems);
        }

        final ModelTypes types = models.types();
        problems.addAll(types.problems());
        problems.addAll(ModelCandidates.problemsOfSettings(settings, types, roots));
        requireNoProblems(problems);

        return Optional.of(new ModelBuilder(types, values, settings, randomness));
    }

    private static void requireNoProblems(final List<String> problems) {
        if(problems.isEmpty()) {
            return;
        }

        final String message = "'random-population' cannot create candidates: " + String.join("; ", problems) + ".";
        log.error(message);

        throw new IllegalArgumentException(message);
    }

    /**
     * @return The random value of the feature: a model for structured data, else a value of the
     *   attribute.
     *
     * @param models The builder of the models; {@code null} if the search space has no
     *   structured data.
     */
    private static Object valueOf(final EStructuralFeature feature,
                                  final int index,
                                  final ValueDrawer values,
                                  final ModelBuilder models,
                                  final RandomGenerator randomness) {
        if(feature instanceof EReference model) {
            final EClass rootType = model.getEReferenceType();

            return models.build(rootType, index);
        }

        return values.draw((EAttribute) feature, randomness);
    }
}
