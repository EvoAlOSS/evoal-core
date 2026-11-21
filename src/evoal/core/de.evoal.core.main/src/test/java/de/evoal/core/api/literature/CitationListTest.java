package de.evoal.core.api.literature;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResourceSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import de.evoal.core.main.credits.BibTeXEntry;
import de.evoal.core.main.credits.BibTeXParser;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.dl.dsl.DefinitionLanguageStandaloneSetup;

public class CitationListTest {
    /**
     * The class loader with the two plugins of the test and core.main.
     */
    private URLClassLoader classpath;

    @TempDir
    private Path folder;

    /**
     * Writes a module with an SBOM, credits files and DL files into a folder of the class path.
     *
     * @param dl The DL files by path.
     */
    private Path writeModule(final String name,
                             final String credits,
                             final String bibtex,
                             final String dlPath,
                             final String dl) throws IOException {
        final Path module = folder.resolve(name);
        final Path evoal = Files.createDirectories(module.resolve("META-INF/evoal"));
        Files.writeString(evoal.resolve("sbom.cdx.json"), "{}");
        Files.writeString(evoal.resolve("credits.json"), credits);
        Files.writeString(evoal.resolve("credits.bib"), bibtex);

        final Path dlFile = module.resolve(dlPath);
        Files.createDirectories(dlFile.getParent());
        Files.writeString(dlFile, dl);

        return module;
    }

    @BeforeEach
    public void writeModules() throws IOException {
        final Path operators = writeModule("operators", """
                {"citations": ["plugin2026paper"],
                 "libraries": [{"library": "org.example:tool", "purpose": "Test.", "citations": ["tool2020library"]}]}
                """, """
                @misc{plugin2026paper, title = {The plugin}}
                @misc{tool2020library, title = {The tool}}
                @article{harik1996learning, author = {G. R. Harik}, title = {Learning linkage}, journal = {FOGA}, year = 1996}
                """, "de/example/operators.dl", """
                import "definitions" from 'de.evoal.core.constraints';

                module de.example.operators {
                    @Literature { keys := ["harik1996learning"]; }
                    abstract type crossover {}

                    @Literature { keys := ["berger2024evoal"]; }
                    type 'linkage-crossover' extends crossover {}
                }
                """);
        final Path other = writeModule("other", """
                {"libraries": []}
                """, """
                @misc{harik1996learning, title = {Another entry with the same key}}
                """, "de/other/other.dl", """
                module de.other {
                    type unused {}
                }
                """);

        classpath = new URLClassLoader(new URL[] {other.toUri().toURL(), operators.toUri().toURL()},
                                       CitationListTest.class.getClassLoader());
    }

    @AfterEach
    public void closeClasspath() throws IOException {
        classpath.close();
    }

    private ClassDefinition loadType(final String uri, final String name) {
        final XtextResourceSet resourceSet = new DefinitionLanguageStandaloneSetup()
                .createInjectorAndDoEMFRegistration()
                .getInstance(XtextResourceSet.class);
        resourceSet.setClasspathURIContext(classpath);
        final Resource resource = resourceSet.getResource(URI.createURI(uri), true);
        EcoreUtil.resolveAll(resource);
        Assertions.assertEquals(List.of(), resource.getErrors());

        return ((DefinitionModule) resource.getContents().getFirst()).getTypes()
                                                                   .stream()
                                                                   .filter(type -> name.equals(type.getName()))
                                                                   .findFirst()
                                                                   .orElseThrow();
    }

    @Test
    public void theListStartsWithEvoAlAndAddsTheTypeItsSuperTypesItsModuleAndItsLibraries() {
        // given
        final LiteratureIndex index = LiteratureIndex.load(classpath);
        final CitationList citations = new CitationList(index);

        // when
        citations.add(loadType("classpath:/de/example/operators.dl", "linkage-crossover"));
        citations.add(loadType("classpath:/de/example/operators.dl", "crossover"));

        // then
        Assertions.assertEquals(List.of("berger2024evoal", "harik1996learning", "plugin2026paper", "tool2020library"),
                                citations.keys());
    }

    @Test
    public void theBibTeXHoldsEveryEntryOnceAndPrefersTheEntryOfTheCitingModule() {
        // given
        final LiteratureIndex index = LiteratureIndex.load(classpath);
        final CitationList citations = new CitationList(index);
        citations.add(loadType("classpath:/de/example/operators.dl", "linkage-crossover"));

        // when
        final List<BibTeXEntry> entries = BibTeXParser.parse(citations.toBibTeX());

        // then
        Assertions.assertEquals(List.of("berger2024evoal", "harik1996learning", "plugin2026paper", "tool2020library"),
                                entries.stream().map(BibTeXEntry::key).toList());
        Assertions.assertEquals("Learning linkage", entries.get(1).fields().get("title"));
    }

    @Test
    public void aDefinitionOutsideOfTheModulesAddsOnlyItsOwnKeys() throws IOException {
        // given
        final Path file = Files.writeString(folder.resolve("standalone.dl"), """
                import "definitions" from 'de.evoal.core.constraints';

                module standalone {
                    @Literature { keys := ["unknown2000key"]; }
                    type operator {}
                }
                """);
        final LiteratureIndex index = LiteratureIndex.load(classpath);
        final CitationList citations = new CitationList(index);

        // when
        citations.add(loadType(file.toUri().toString(), "operator"));

        // then: the unknown key has no entry and is left out of the BibTeX
        Assertions.assertEquals(List.of("berger2024evoal", "unknown2000key"), citations.keys());
        Assertions.assertEquals(List.of("berger2024evoal"),
                                BibTeXParser.parse(citations.toBibTeX()).stream().map(BibTeXEntry::key).toList());
    }
}
