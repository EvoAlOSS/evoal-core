package de.evoal.pipeline.impl.internal;

import de.evoal.languages.model.ddl.BaseDataDescription;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.RepresentationType;
import de.evoal.languages.model.dynamic.Definition;
import de.evoal.languages.model.dynamic.DynamicFactory;
import de.evoal.languages.model.dynamic.DynamicPackage;
import de.evoal.languages.model.generator.GeneratorModule;
import de.evoal.languages.model.instance.DataReference;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.util.Diagnostician;

import javax.enterprise.context.ApplicationScoped;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
@Slf4j
public class DynamicEClassProvider {
    public static String ORIGIN_SOURCE = "http://www.evoal.de/model/dynamic/2024/04/Origin";

    private static final EcoreFactory factory = EcoreFactory.eINSTANCE;
    private static final DynamicPackage dynPackage = DynamicPackage.eINSTANCE;

    public EClass eClassFor(final GeneratorModule module) {
        log.info("Creating dynamic eclass for module {}.", module.getName());
        final EPackage pkg = factory.createEPackage();
        pkg.setName("dynamic");
        pkg.setNsPrefix("dyn");
        pkg.setNsURI("http://www.evoal.de/model/dynamic/2024/04");

        // create a set of all used data
        final Set<DataDescription> references =
            module.getPipelines()
                    .stream()
                    .flatMap(p -> p.getSteps().stream())
                    .flatMap(s -> Stream.concat(s.getReads().stream(), s.getWrites().stream()))
                    .map(DataReference::getDefinition)
                    .collect(Collectors.toSet());

        final EClass result = factory.createEClass();
        result.setName("Space");

        for(final DataDescription ref : references) {
            final Definition definition = DynamicFactory.eINSTANCE.createDefinition();
            definition.setSource(ref);

            final EAnnotation annotation = factory.createEAnnotation();
            annotation.setSource(DynamicPackage.eNS_URI);
            annotation.getContents().add(definition);

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
        log.info(result.toString());


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
}
