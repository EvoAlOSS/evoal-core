package de.evoal.optimisation.ea;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.builder.BuildSettings;
import de.evoal.optimisation.api.builder.ModelBuilder;
import de.evoal.optimisation.api.builder.TreeMethod;
import de.evoal.optimisation.api.models.ModelCandidates;
import de.evoal.optimisation.ea.api.genotype.BoundaryHandling;
import de.evoal.optimisation.ea.api.genotype.ModelChromosome;
import de.evoal.optimisation.ea.api.genotype.ModelGenes;

/**
 * A search space with one model feature of a test DL type and, optionally, further features;
 *   for the tests of the model chromosome and its operators.
 */
public final class ModelSpace {
    private final DynamicEClassProvider dynamicClasses = new DynamicEClassProvider();

    private final EReference model;

    private final ModelCandidates models;

    private final Space space;

    /**
     * @param resource The DL module on the class path, e.g. {@code de/evoal/optimisation/ea/test/models/policy.dl}.
     * @param typeName The type of the model feature; an abstract type is given by one of its
     *   subtypes and {@code abstractRoot}.
     * @param abstractRoot Whether the feature has the super type of the named type.
     * @param others Further features of the search space.
     */
    public ModelSpace(final String resource, final String typeName, final boolean abstractRoot, final EAttribute... others) {
        final DefinitionModule module = LanguageHelper.loadFromClasspath(resource);
        final ClassDefinition type = module.getTypes()
                                           .stream()
                                           .filter(candidate -> typeName.equals(candidate.getName()))
                                           .findFirst()
                                           .orElseThrow();

        final EClass spaceClass = EcoreFactory.eINSTANCE.createEClass();
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(spaceClass);

        model = EcoreFactory.eINSTANCE.createEReference();
        model.setName("model");
        model.setContainment(true);
        model.setEType(dynamicClasses.toEClass(abstractRoot ? type.getSuperType() : type));
        spaceClass.getEStructuralFeatures().add(model);
        for(final EAttribute other : others) {
            spaceClass.getEStructuralFeatures().add(other);
        }

        space = new Space(spaceClass);
        models = new ModelCandidates(space, new FeatureBoundaries(), dynamicClasses);
    }

    /**
     * @return The chromosome of the model feature with the boundary handling.
     */
    public ModelChromosome chromosome(final BoundaryHandling handling) {
        final ModelGenes.Context context = new ModelGenes.Context(models.types(), models.values(), new FeatureBoundaries(), handling,
                                                                  List.of(model.getEReferenceType()));

        return new ModelChromosome(List.<EStructuralFeature>of(model), context);
    }

    /**
     * @return Random models built with the method, one per index.
     */
    public List<EObject> models(final TreeMethod method, final Double optionalProbability, final int count, final long seed) {
        final BuildSettings settings = new BuildSettings(method, BuildSettings.NO_SIZE_LIMIT, optionalProbability);
        final ModelBuilder builder = new ModelBuilder(models.types(), models.values(), settings, random(seed));
        final List<EObject> result = new ArrayList<>();
        for(int i = 0; i < count; ++i) {
            result.add(builder.build(model.getEReferenceType(), i));
        }

        return result;
    }

    /**
     * @return The model feature.
     */
    public EReference model() {
        return model;
    }

    /**
     * @return The front-end of the models.
     */
    public ModelCandidates models() {
        return models;
    }

    /**
     * @return A candidate input with the model.
     */
    public TypedEObject input(final EObject root) {
        final TypedEObject input = space.newEObject();
        input.eSet(model, root);

        return input;
    }

    /**
     * @return The search space.
     */
    public Space space() {
        return space;
    }

    /**
     * @return A random generator for the seed.
     */
    public static RandomGenerator random(final long seed) {
        return RandomService.withSeed(seed).random("de.evoal.optimisation.ea.test.models");
    }
}
