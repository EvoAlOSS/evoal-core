package de.evoal.core.api.languages;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResourceSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.dl.dsl.DefinitionLanguageStandaloneSetup;

public class LiteratureReaderTest {
    /**
     * A DL module with the annotation type, annotated types and an annotated declaration.
     */
    private static final String MODULE = """
            module test {
                type Literature {
                    keys : array string;
                }

                @Literature { keys := ["baker1985adaptive"]; }
                abstract type ranking {}

                @Literature { keys := ["blickle1995mathematical", "baker1985adaptive"]; }
                type 'exponential-ranking' extends ranking {}

                type 'linear-ranking' extends ranking {}

                type plain {}

                @Literature { keys := ["harik1996learning"]; }
                def void 'building-block'(array data features);

                def void correlation(data feature1, data feature2, real coefficient);

                @Literature { keys := ["deb2002fast"]; }
                nominal enum representation ( 'double', 'integer' );
            }
            """;

    private static DefinitionModule parse() throws Exception {
        final XtextResourceSet resourceSet = new DefinitionLanguageStandaloneSetup()
                .createInjectorAndDoEMFRegistration()
                .getInstance(XtextResourceSet.class);
        final Resource resource = resourceSet.createResource(URI.createURI("test.dl"));
        resource.load(new ByteArrayInputStream(MODULE.getBytes(StandardCharsets.UTF_8)), Map.of());
        EcoreUtil.resolveAll(resource);

        Assertions.assertEquals(List.of(), resource.getErrors(), "The module has errors.");
        return (DefinitionModule) resource.getContents().getFirst();
    }

    private static ClassDefinition type(final DefinitionModule module, final String name) {
        return module.getTypes()
                     .stream()
                     .filter(type -> name.equals(type.getName()))
                     .findFirst()
                     .orElseThrow();
    }

    private static Definition function(final DefinitionModule module, final String name) {
        return module.getFunctions()
                     .stream()
                     .filter(function -> name.equals(function.getName()))
                     .findFirst()
                     .orElseThrow();
    }

    @Test
    public void aTypeHasItsOwnKeysFirstAndThenThoseOfItsSuperTypesEachOnce() throws Exception {
        // given
        final DefinitionModule module = parse();

        // when
        final List<String> keys = LiteratureReader.keysOf(type(module, "exponential-ranking"));

        // then
        Assertions.assertEquals(List.of("blickle1995mathematical", "baker1985adaptive"), keys);
    }

    @Test
    public void aTypeWithoutAnnotationHasTheKeysOfItsSuperType() throws Exception {
        // given
        final DefinitionModule module = parse();

        // when
        final List<String> keys = LiteratureReader.keysOf(type(module, "linear-ranking"));
        final List<String> ownKeys = LiteratureReader.ownKeysOf(type(module, "linear-ranking"));

        // then
        Assertions.assertEquals(List.of("baker1985adaptive"), keys);
        Assertions.assertEquals(List.of(), ownKeys);
    }

    @Test
    public void aTypeWithoutLiteratureHasNoKeys() throws Exception {
        // given
        final DefinitionModule module = parse();

        // when
        final List<String> keys = LiteratureReader.keysOf(type(module, "plain"));

        // then
        Assertions.assertEquals(List.of(), keys);
    }

    @Test
    public void aDeclarationHasTheKeysOfItsAnnotation() throws Exception {
        // given
        final DefinitionModule module = parse();

        // when
        final List<String> keys = LiteratureReader.keysOf(function(module, "building-block"));
        final List<String> none = LiteratureReader.keysOf(function(module, "correlation"));

        // then
        Assertions.assertEquals(List.of("harik1996learning"), keys);
        Assertions.assertEquals(List.of(), none);
    }

    @Test
    public void anEnumerationCanNameItsLiterature() throws Exception {
        // given
        final DefinitionModule module = parse();

        // when
        final List<String> keys = LiteratureReader.keysOf(module.getEnums().getFirst());

        // then
        Assertions.assertEquals(List.of("deb2002fast"), keys);
    }
}
