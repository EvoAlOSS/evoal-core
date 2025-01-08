package de.evoal.pipeline.impl.internal;

import org.eclipse.emf.ecore.*;

public class DynamicAnnotationsPackage {
    public static DynamicAnnotationsPackage eINSTANCE = new DynamicAnnotationsPackage();

    public final static String NS_URI = "http://www.evoal.de/model/dynamic/annotations/";

    private final EPackage pkg;

    private final EClass definition;

    private final EAttribute definition_source;


    private DynamicAnnotationsPackage() {
        final EcoreFactory factory = EcoreFactory.eINSTANCE;

        pkg = factory.createEPackage();
        pkg.setName("DynamicAnnotations");
        pkg.setNsPrefix("dynAnn");
        pkg.setNsURI(NS_URI);

        definition = factory.createEClass();
        definition.setName("Definition");

        definition_source = factory.createEAttribute();
        definition_source.setName("source");
        definition_source.setEType(EcorePackage.eINSTANCE.getEJavaObject());

        definition.getEStructuralFeatures().add(definition_source);
        pkg.getEClassifiers().add(definition);
    }

    public EPackage getEPackage() {
        return pkg;
    }

    public EClass getDefinition() {
        return definition;
    }

    public EAttribute getDefinition_Source() {
        return definition_source;
    }
}
