package de.evoal.core.api.dynamic;

import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.languages.model.dynamic.DefinitionMapping;
import de.evoal.models.core.ecore.Space;
import de.evoal.core.api.ecore.info.BoundaryExtractor;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.definitions.BaseDataDescription;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.RepresentationType;
import de.evoal.languages.model.base.expressions.TypeDefinitionReference;
import de.evoal.languages.model.dynamic.DynamicFactory;
import de.evoal.languages.model.dynamic.DynamicPackage;
import de.evoal.languages.model.generator.ConcreteStep;
import de.evoal.languages.model.generator.GeneratorModule;
import de.evoal.languages.model.generator.PipelineStep;
import de.evoal.languages.model.generator.Step;
import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.languages.model.ol.OptimisationGoal;
import de.evoal.languages.model.ol.ProblemInstance;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Pair;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.util.Diagnostician;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Component for generating a dynamic ecore package for a given model.
 */
@ApplicationScoped
@Slf4j
public class EClassProvider {
    /**
     * Ecore factory for creating new ecore objects.
     */
    private static final EcoreFactory factory = EcoreFactory.eINSTANCE;

    /**
     * Dynamic factory for creating new dynamic objects.
     */
    private static final DynamicFactory dynFactory = DynamicFactory.eINSTANCE;

    /**
     * Keeping track of already mapped classes.
     */
    private final Map<Object, EClass> eClassCache = new HashMap<>();

    public EClass eClassFor(final GeneratorModule module) {
        log.info("Creating dynamic eclass for module {}.", module.getName());
        if(eClassCache.containsKey(module)) {
            return eClassCache.get(module);
        }

        // create a set of all used data
        final Set<DataDescription> references =
            module.getPipelines()
                    .stream()
                    .flatMap(p -> p.getSteps().stream())
                    .flatMap(EClassProvider::toUsedDataStream)
                    .map(TypeDefinitionReference::getDefinition)
                    .filter(DataDescription.class::isInstance)
                    .map(DataDescription.class::cast)
                    .collect(Collectors.toSet());

        final EClass result = eClassOf(references);

        eClassCache.put(module, result);

        return result;
    }

    public EClass eClassFor(final DataDescriptionModule module) {
        log.info("Creating dynamic eclass for module {}.", module.getName());
        if(eClassCache.containsKey(module)) {
            return eClassCache.get(module);
        }

        // create a set of all used data
        final Set<DataDescription> references =
                new HashSet<>(module.getDescriptions());

        final EClass result = eClassOf(references);

        eClassCache.put(module, result);

        return result;
    }

    public Pair<EClass, EClass> eClassFor(final ProblemInstance problem) {
        log.info("Creating dynamic eclass for problem {}.", problem.getName());
        EClass searchSpace = eClassCache.get(problem.getSearchSpace());
        EClass optimisationSpace = eClassCache.get(problem.getOptimisationSpace());

        if(searchSpace == null) {
            final Set<DataDescription> references =
                    problem.getSearchSpace()
                            .stream()
                            .map(TypeDefinitionReference::getDefinition)
                            .filter(DataDescription.class::isInstance)
                            .map(DataDescription.class::cast)
                            .collect(Collectors.toSet());

            searchSpace = eClassOf(references);
        }

        if(optimisationSpace == null) {
            final Set<DataDescription> references =
                    problem.getOptimisationSpace()
                            .stream()
                            .map(OptimisationGoal::getData)
                            .map(TypeDefinitionReference::getDefinition)
                            .filter(DataDescription.class::isInstance)
                            .map(DataDescription.class::cast)
                            .collect(Collectors.toSet());

            optimisationSpace = eClassOf(references);
        }

        eClassCache.put(problem.getSearchSpace(), searchSpace);
        eClassCache.put(problem.getOptimisationSpace(), optimisationSpace);

        return Pair.create(searchSpace, optimisationSpace);
    }

    private static Stream<TypeDefinitionReference> toUsedDataStream(final Step step) {
        if(step instanceof ConcreteStep concrete) {
            return Stream.concat(concrete.getReads().stream(), concrete.getWrites().stream());
        } else if(step instanceof PipelineStep pipeline) {
            return pipeline.getDefinition()
                    .getSteps()
                    .stream()
                    .flatMap(EClassProvider::toUsedDataStream);
        } else {
            throw new IllegalArgumentException("Unsupported step: " + step.eClass().getName());
        }
    }

    public EClass eClassFor(final MachineLearningModule module) {
        log.info("Creating dynamic eclass for module {}.", module.getName());
        if(eClassCache.containsKey(module)) {
            return eClassCache.get(module);
        }

        // create a set of all used data
        final Set<DataDescription> references =
                Stream.concat(
                            module.getTask().getInputs().stream(),
                            module.getTask().getOutputs().stream()
                        )
                      .collect(Collectors.toSet());

        final EClass result = eClassOf(references);

        eClassCache.put(module, result);

        return result;
    }

    private EClass eClassOf(final Collection<DataDescription> descriptions) {
        final EPackage pkg = factory.createEPackage();
        pkg.setName("dynamic");
        pkg.setNsPrefix("dyn");
        pkg.setNsURI("http://www.evoal.de/model/dynamic/2024/04");

        final EClass result = factory.createEClass();
        result.setName("Space");

        for(final DataDescription ref : descriptions) {
            log.info("Creating attribute for '{}'.", ref.getName());

            final EAttribute attr = factory.createEAttribute();
            attr.setName(ref.getName());
            attr.setLowerBound(0);
            attr.setUpperBound(1);
            attr.setEType(toEType(ref));

            // the boundaries are taken from the @LowerBoundary/@UpperBoundary constraints
            FeatureBoundaries.annotate(attr, BoundaryExtractor.extract(ref));

            result.getEStructuralFeatures()
                  .add(attr);


            // add mapping to ecore world
            final DefinitionMapping definition = dynFactory.createDefinitionMapping();
            definition.setSource(ref);
            definition.setTarget(attr);

            final EAnnotation annotation = factory.createEAnnotation();
            annotation.setSource(DynamicPackage.eNS_URI);
            annotation.getContents().add(definition);

            attr.getEAnnotations()
                .add(annotation);

            // add mapping to ddl world
            ref.getEAnnotations()
               .add(EcoreUtil.copy(annotation));
        }

        final Diagnostic diagnostics = Diagnostician.INSTANCE.validate(result);
        for(final Diagnostic diag : diagnostics.getChildren()) {
            log.info(severityToString(diag.getSeverity()) + " " + diag.getMessage()            );
        }

        pkg.getEClassifiers().add(result);

        return result;
    }

    private String severityToString(int severity) {
        return switch (severity) {
            case Diagnostic.OK -> "OK  ";
            case Diagnostic.INFO -> "INFO";
            case Diagnostic.WARNING -> "WARN";
            case Diagnostic.ERROR -> "ERR ";
            case Diagnostic.CANCEL -> "CANC";
            default -> "UNKN";
        };
    }

    private EClassifier toEType(final DataDescription descr) {
        if(descr instanceof BaseDataDescription baseDescr) {
            if(RepresentationType.BOOLEAN.equals(baseDescr.getRepresentation())) {
                return EcorePackage.eINSTANCE.getEBoolean();
            } else if(RepresentationType.INTEGER.equals(baseDescr.getRepresentation())) {
                return EcorePackage.eINSTANCE.getEInt();
            } else if(RepresentationType.REAL.equals(baseDescr.getRepresentation())) {
                return EcorePackage.eINSTANCE.getEDouble();
            } else if(RepresentationType.STRING.equals(baseDescr.getRepresentation())) {
                return EcorePackage.eINSTANCE.getEString();
            } else {
                throw new IllegalArgumentException(baseDescr.getRepresentation().getName());
            }
        } else {
            throw new IllegalArgumentException(descr.getClass().getName());
        }
    }

    public EClass eClassFor(final Space source, final Space target) {
        final LinkedHashSet<DataDescription> references = new LinkedHashSet<>();

        Requirements.requireEqual(source.getEClass(), target.getEClass());

        return source.getEClass();
    }
}
