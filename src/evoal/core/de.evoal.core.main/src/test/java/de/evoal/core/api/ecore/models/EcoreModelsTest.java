package de.evoal.core.api.ecore.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.languages.model.base.definitions.StructuredDataDescription;
import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import de.evoal.languages.model.dl.dsl.DefinitionLanguageStandaloneSetup;

public class EcoreModelsTest {
    @TempDir
    private Path folder;

    /**
     * @return A metamodel with the given namespace URI and classifiers (XMI text).
     */
    private static String metamodel(final String name, final String nsURI, final String classifiers) {
        return """
               <?xml version="1.0" encoding="UTF-8"?>
               <ecore:EPackage xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                   xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" name="%s" nsURI="%s" nsPrefix="%s">
               %s
               </ecore:EPackage>
               """.formatted(name, nsURI, name, classifiers);
    }

    /**
     * A tree of nodes: an abstract node, a leaf in this file and a branch in {@code branch.ecore}.
     */
    private static final String NODES = metamodel("nodes", "http://evoal.de/test/nodes", """
              <eClassifiers xsi:type="ecore:EClass" name="Node" abstract="true"/>
              <eClassifiers xsi:type="ecore:EClass" name="Leaf" eSuperTypes="#//Node">
                <eStructuralFeatures xsi:type="ecore:EAttribute" name="weight" lowerBound="1" eType="#//Weight"/>
              </eClassifiers>
              <eClassifiers xsi:type="ecore:EDataType" name="Weight" instanceClassName="double">
                <eAnnotations source="http:///org/eclipse/emf/ecore/util/ExtendedMetaData">
                  <details key="minExclusive" value="0.0"/>
                  <details key="maxInclusive" value="1.0"/>
                </eAnnotations>
              </eClassifiers>
              <eSubpackages name="extra" nsURI="http://evoal.de/test/nodes/extra" nsPrefix="extra">
                <eClassifiers xsi:type="ecore:EClass" name="Marker" eSuperTypes="#//Node"/>
              </eSubpackages>
            """);

    private static final String BRANCH = metamodel("branch", "http://evoal.de/test/branch", """
              <eClassifiers xsi:type="ecore:EClass" name="Branch" eSuperTypes="nodes.ecore#//Node">
                <eStructuralFeatures xsi:type="ecore:EReference" name="children" lowerBound="1" upperBound="3"
                    eType="ecore:EClass nodes.ecore#//Node" containment="true"/>
              </eClassifiers>
            """);

    private Path write(final String name, final String text) throws IOException {
        final Path file = folder.resolve(name);
        Files.createDirectories(file.getParent());
        Files.writeString(file, text);

        return file;
    }

    private URI base() {
        return URI.createFileURI(folder.resolve("search.ddl").toString());
    }

    private static IllegalStateException failureOf(final Runnable loading) {
        return Assertions.assertThrows(IllegalStateException.class, loading::run);
    }

    @Nested
    class Loading {
        @Test
        public void classesOfSeveralFilesAreLoadedTogether() throws IOException {
            write("nodes.ecore", NODES);
            write("branch.ecore", BRANCH);
            final EcoreModels models = new EcoreModels(List.of());

            final EClass branch = models.classOf(List.of("nodes.ecore", "branch.ecore"), "branch.ecore#//Branch", base(), "the test");
            final EClass node = ((EReference) branch.getEStructuralFeature("children")).getEReferenceType();

            Assertions.assertEquals("Branch", branch.getName());
            Assertions.assertSame(node, branch.getESuperTypes().getFirst());
            Assertions.assertEquals(List.of("http://evoal.de/test/branch#//Branch",
                                            "http://evoal.de/test/nodes#//Leaf",
                                            "http://evoal.de/test/nodes#//extra/Marker"),
                                    models.concreteSubclassesOf(node).stream().map(EcoreModels::typeNameOf).toList());
        }

        @Test
        public void aFileNamedTwiceIsLoadedOnce() throws IOException {
            write("nodes.ecore", NODES);
            write("branch.ecore", BRANCH);
            final EcoreModels models = new EcoreModels(List.of());

            final EClass branch = models.classOf(List.of("nodes.ecore", "branch.ecore"), "branch.ecore#//Branch", base(), "the test");
            final EClass leaf = models.classOf(List.of("nodes.ecore"), "nodes.ecore#//Leaf", base(), "the test");

            Assertions.assertSame(branch.getESuperTypes().getFirst().getEPackage(), leaf.getEPackage());
        }

        @Test
        public void boundariesComeFromTheFacets() throws IOException {
            write("nodes.ecore", NODES);
            final EClass leaf = new EcoreModels(List.of()).classOf(List.of("nodes.ecore"), "nodes.ecore#//Leaf", base(), "the test");
            final EAttribute weight = (EAttribute) leaf.getEStructuralFeature("weight");

            final FeatureBoundaries.Boundaries boundaries = new FeatureBoundaries().get(weight);

            Assertions.assertEquals(new FeatureBoundaries.Boundaries(0.0, false, 1.0, true), boundaries);
        }

        @Test
        public void aFileNotBesideTheDdlFileIsSearchedInTheWorkingDirectory() throws IOException {
            write("models/nodes.ecore", NODES);
            final Path relative = Path.of("").toAbsolutePath().relativize(folder.resolve("models/nodes.ecore"));
            final URI elsewhere = URI.createFileURI(folder.resolve("configuration/search.ddl").toString());

            final EClass leaf = new EcoreModels(List.of()).classOf(List.of(relative.toString()), relative + "#//Leaf", elsewhere, "the test");

            Assertions.assertEquals("Leaf", leaf.getName());
        }
    }

    @Nested
    class Problems {
        @Test
        public void aMissingFileIsReportedWithBothPlaces() {
            final IllegalStateException failure = failureOf(() -> new EcoreModels(List.of()).classOf(List.of("missing.ecore"), "missing.ecore#//X", base(), "the test"));

            Assertions.assertTrue(failure.getMessage().startsWith("The test cannot be loaded: the file 'missing.ecore' is found neither at "), failure.getMessage());
            Assertions.assertTrue(failure.getMessage().contains(" nor at "), failure.getMessage());
        }

        @Test
        public void aReferenceToAFileThatIsNotListedIsReported() throws IOException {
            write("nodes.ecore", NODES);
            write("branch.ecore", BRANCH);

            final IllegalStateException failure = failureOf(() -> new EcoreModels(List.of()).classOf(List.of("branch.ecore"), "branch.ecore#//Branch", base(), "the test"));

            Assertions.assertTrue(failure.getMessage().contains("nodes.ecore, which is not in 'files'"), failure.getMessage());
        }

        @Test
        public void aReferenceThatDoesNotResolveIsReported() throws IOException {
            write("nodes.ecore", NODES);
            write("branch.ecore", BRANCH.replace("nodes.ecore#//Node\"", "nodes.ecore#//Tree\""));

            final IllegalStateException failure = failureOf(() -> new EcoreModels(List.of()).classOf(List.of("nodes.ecore", "branch.ecore"), "branch.ecore#//Branch", base(), "the test"));

            Assertions.assertTrue(failure.getMessage().contains("nodes.ecore#//Tree does not resolve"), failure.getMessage());
        }

        @Test
        public void aRootOfAnotherFileOrNoClassIsReported() throws IOException {
            write("nodes.ecore", NODES);
            final EcoreModels models = new EcoreModels(List.of());

            final IllegalStateException otherFile = failureOf(() -> models.classOf(List.of("nodes.ecore"), "tree.ecore#//Leaf", base(), "the test"));
            final IllegalStateException noClass = failureOf(() -> models.classOf(List.of("nodes.ecore"), "nodes.ecore#//Weight", base(), "the test"));
            final IllegalStateException noHash = failureOf(() -> models.classOf(List.of("nodes.ecore"), "nodes.ecore", base(), "the test"));

            Assertions.assertTrue(otherFile.getMessage().contains("names the file 'tree.ecore', which is not in 'files'"), otherFile.getMessage());
            Assertions.assertTrue(noClass.getMessage().contains("is no class of"), noClass.getMessage());
            Assertions.assertTrue(noHash.getMessage().contains("has no '#'"), noHash.getMessage());
        }

        @Test
        public void aPackageWithoutNamespaceIsReported() throws IOException {
            write("nodes.ecore", NODES.replace(" nsURI=\"http://evoal.de/test/nodes\"", ""));

            final IllegalStateException failure = failureOf(() -> new EcoreModels(List.of()).classOf(List.of("nodes.ecore"), "nodes.ecore#//Leaf", base(), "the test"));

            Assertions.assertTrue(failure.getMessage().contains("has no namespace URI"), failure.getMessage());
        }
    }

    @Nested
    class GeneratedPackages {
        /**
         * @return A package as a plugin's generated code gives it: the classes of {@code nodes.ecore}
         *   and a resource with the namespace URI.
         */
        private EPackage generated(final boolean withWeight) {
            final EcoreFactory factory = EcoreFactory.eINSTANCE;
            final EPackage ePackage = factory.createEPackage();
            ePackage.setName("nodes");
            ePackage.setNsURI("http://evoal.de/test/nodes");
            ePackage.setNsPrefix("nodes");

            final EClass node = factory.createEClass();
            node.setName("Node");
            node.setAbstract(true);

            final EDataType weightType = factory.createEDataType();
            weightType.setName("Weight");
            weightType.setInstanceClassName("double");

            final EClass leaf = factory.createEClass();
            leaf.setName("Leaf");
            leaf.getESuperTypes().add(node);
            if(withWeight) {
                final EAttribute weight = factory.createEAttribute();
                weight.setName("weight");
                weight.setLowerBound(1);
                weight.setEType(weightType);
                leaf.getEStructuralFeatures().add(weight);
            }

            final EPackage extra = factory.createEPackage();
            extra.setName("extra");
            extra.setNsURI("http://evoal.de/test/nodes/extra");
            extra.setNsPrefix("extra");
            final EClass marker = factory.createEClass();
            marker.setName("Marker");
            marker.getESuperTypes().add(node);
            extra.getEClassifiers().add(marker);

            ePackage.getEClassifiers().addAll(List.of(node, leaf, weightType));
            ePackage.getESubpackages().add(extra);

            final Resource resource = new XMIResourceImpl(URI.createURI(ePackage.getNsURI()));
            resource.getContents().add(ePackage);

            return ePackage;
        }

        @Test
        public void aFileWithTheNamespaceOfAGeneratedPackageLeadsToItsClasses() throws IOException {
            write("nodes.ecore", NODES);
            write("branch.ecore", BRANCH);
            final EPackage generated = generated(true);
            final EcoreModels models = new EcoreModels(List.of(generated));

            final EClass branch = models.classOf(List.of("nodes.ecore", "branch.ecore"), "branch.ecore#//Branch", base(), "the test");

            Assertions.assertSame(generated.getEClassifier("Node"), branch.getESuperTypes().getFirst());
            Assertions.assertSame(generated.getEClassifier("Node"), ((EReference) branch.getEStructuralFeature("children")).getEReferenceType());
            Assertions.assertTrue(models.concreteSubclassesOf((EClass) generated.getEClassifier("Node")).contains(generated.getEClassifier("Leaf")));
        }

        @Test
        public void aGeneratedPackageThatDiffersFromTheFileIsReported() throws IOException {
            write("nodes.ecore", NODES);

            final IllegalStateException failure = failureOf(() -> new EcoreModels(List.of(generated(false))).classOf(List.of("nodes.ecore"), "nodes.ecore#//Leaf", base(), "the test"));

            Assertions.assertTrue(failure.getMessage().contains("differs from the generated package http://evoal.de/test/nodes: 'Leaf.weight' is missing"), failure.getMessage());
        }
    }

    @Nested
    class Annotation {
        private StructuredDataDescription parse(final String ddl) throws IOException {
            final Path file = write("search.ddl", ddl);
            DefinitionLanguageStandaloneSetup.doSetup();
            final XtextResourceSet resourceSet = new DataDescriptionLanguageStandaloneSetup()
                    .createInjectorAndDoEMFRegistration()
                    .getInstance(XtextResourceSet.class);
            resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
            final Resource resource = resourceSet.getResource(URI.createFileURI(file.toString()), true);
            Assertions.assertEquals(List.of(), resource.getErrors());
            final DataDescriptionModule module = (DataDescriptionModule) resource.getContents().getFirst();

            return (StructuredDataDescription) module.getDescriptions().getFirst();
        }

        @Test
        public void structuredDataWithTheAnnotationIsAContainmentOfTheNamedClass() throws IOException {
            write("nodes.ecore", NODES);
            write("branch.ecore", BRANCH);
            final StructuredDataDescription tree = parse("""
                    import "definitions" from 'de.evoal.core.ecore';

                    module search {
                        data:
                            @EcoreType { files := [ "nodes.ecore", "branch.ecore" ]; root := "branch.ecore#//Branch"; }
                            data 'tree' of instance 'ecore-model';
                    }
                    """);
            final EcoreModels models = new EcoreModels(List.of());

            final EClass space = new EClassProvider(new DynamicEClassProvider(), models)
                    .eClassForConfigurationData(List.of(tree));
            final EReference feature = (EReference) space.getEStructuralFeature("tree");

            Assertions.assertTrue(EcoreModels.hasEcoreType(tree));
            Assertions.assertTrue(feature.isContainment());
            Assertions.assertEquals("http://evoal.de/test/branch#//Branch", EcoreModels.typeNameOf(feature.getEReferenceType()));
        }

        @Test
        public void dataWithoutTheAnnotationKeepsItsDlType() throws IOException {
            final StructuredDataDescription tree = parse("""
                    import "definitions" from 'de.evoal.core.ecore';

                    module search {
                        data:
                            data 'tree' of instance 'ecore-model';
                    }
                    """);

            Assertions.assertFalse(EcoreModels.hasEcoreType(tree));
        }
    }

    @Test
    public void classesOfDlTypesAndWithoutNamespaceKeepTheirDlNames() {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.setName("Entry");
        final EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        ePackage.setName("model");
        ePackage.getEClassifiers().add(eClass);

        Assertions.assertEquals(DynamicEClassProvider.dlTypeOf(eClass), EcoreModels.typeNameOf(eClass));
    }
}
