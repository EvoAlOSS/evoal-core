package de.evoal.core.api.dynamic;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.languages.model.base.definitions.BaseDataDescription;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.RepresentationType;
import de.evoal.languages.model.base.expressions.TypeDefinitionReference;
import de.evoal.languages.model.dynamic.Definition;
import de.evoal.languages.model.dynamic.DynamicFactory;
import de.evoal.languages.model.dynamic.DynamicPackage;
import de.evoal.languages.model.generator.GeneratorModule;
import de.evoal.languages.model.mll.MachineLearningModule;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.util.Diagnostician;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
@Slf4j
public class EClassProvider {
    private static final EcoreFactory factory = EcoreFactory.eINSTANCE;
    private static final DynamicFactory dynFactory = DynamicFactory.eINSTANCE;

    private Map<Object, EClass> eClassCache = new HashMap<>();

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
                    .flatMap(s -> Stream.concat(s.getReads().stream(), s.getWrites().stream()))
                    .map(TypeDefinitionReference::getDefinition)
                    .filter(DataDescription.class::isInstance)
                    .map(DataDescription.class::cast)
                    .collect(Collectors.toSet());

        final EClass result = eClassOf(references);

        eClassCache.put(module, result);

        return result;
    }

    public EClass eClassFor(final MachineLearningModule module) {
        log.info("Creating dynamic eclass for module {}.", module.getName());
        if(eClassCache.containsKey(module)) {
            return eClassCache.get(module);
        }

        // create a set of all used data
        final Set<DataDescription> references =
                module.getDefinitions()
                        .stream()
                        .flatMap(p -> Stream.concat(p.getInputs().stream(), p.getOutputs().stream()))
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
            final Definition definition = dynFactory.createDefinition();
            definition.setSource(ref);

            final EAnnotation annotation = factory.createEAnnotation();
            annotation.setSource(DynamicPackage.eNS_URI);
            annotation.getContents().add(definition);

            log.info("Creating attribute for '{}'.", ref.getName());

            final EAttribute attr = factory.createEAttribute();
            attr.setName(ref.getName());
            attr.setLowerBound(0);
            attr.setUpperBound(1);
            attr.setEType(toEType(ref));
            attr.getEAnnotations().add(annotation);

            result.getEStructuralFeatures().add(attr);
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

    public EClass eClassFor(final PropertiesSpecification source, final PropertiesSpecification target) {
        final LinkedHashSet<DataDescription> references = new LinkedHashSet<>();

        // create a set of all used data
        Stream.concat(source.getProperties().stream(),
                      target.getProperties().stream())
                .map(PropertySpecification::type)
                .map(DataDescription.class::cast)
                .forEach(references::add);

        return eClassOf(references);
    }

    public EClass eClassFor(final List<DataDescription> source, final List<DataDescription> target) {
        final LinkedHashSet<DataDescription> references = new LinkedHashSet<>();

        // create a set of all used data
        Stream.concat(source.stream(),
                      target.stream())
              .forEach(references::add);

        return eClassOf(references);
    }
}
