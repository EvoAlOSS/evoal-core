package de.evoal.core.main.credits;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResourceSet;

import de.evoal.core.api.languages.LiteratureReader;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.expressions.ExpressionsPackage;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.dl.dsl.DefinitionLanguageStandaloneSetup;

/**
 * The literature of a module that the credits check needs besides its own credits files: the
 *   keys that its DL types and declarations name ({@code @Literature}) and the BibTeX entries
 *   of the modules it depends on.
 *
 * @param dlCitations The keys of the module's DL files, each with the DL definitions that name
 *   it ({@code '<module>.<name>'}), in the order of the files.
 * @param dependencyEntries The keys of the {@value CreditsFiles#CITATIONS_FILE} files of the
 *   dependencies, each with the file that defines it.
 * @param problems The DL annotations that could not be read.
 */
public record LiteratureSources(Map<String, List<String>> dlCitations,
                                Map<String, String> dependencyEntries,
                                List<String> problems) {
    /**
     * No DL files and no dependencies.
     */
    public static final LiteratureSources NONE = new LiteratureSources(Map.of(), Map.of(), List.of());

    public LiteratureSources {
        dlCitations = Collections.unmodifiableMap(new LinkedHashMap<>(dlCitations));
        dependencyEntries = Collections.unmodifiableMap(new LinkedHashMap<>(dependencyEntries));
        problems = List.copyOf(problems);
    }

    /**
     * Reads the DL files of the module and the citations of its dependencies.
     *
     * @param classesFolder The output folder of the module ({@code target/classes}); its DL
     *   files are read, its own {@value CreditsFiles#CITATIONS_FILE} is not a dependency.
     * @param classpath The class loader with the module and its dependencies; DL imports and the
     *   citations of the dependencies are resolved with it.
     */
    public static LiteratureSources read(final Path classesFolder, final ClassLoader classpath) throws IOException {
        final Map<String, List<String>> dlCitations = new LinkedHashMap<>();
        final List<String> problems = new ArrayList<>();
        readDlFiles(classesFolder, classpath, dlCitations, problems);

        return new LiteratureSources(dlCitations, readDependencyEntries(classesFolder, classpath), problems);
    }

    private static void readDlFiles(final Path classesFolder,
                                    final ClassLoader classpath,
                                    final Map<String, List<String>> dlCitations,
                                    final List<String> problems) throws IOException {
        final List<Path> files = dlFilesIn(classesFolder);
        if(files.isEmpty()) {
            return;
        }

        final XtextResourceSet resourceSet = new DefinitionLanguageStandaloneSetup()
                .createInjectorAndDoEMFRegistration()
                .getInstance(XtextResourceSet.class);
        resourceSet.setClasspathURIContext(classpath);

        for(final Path file : files) {
            final String name = classesFolder.relativize(file).toString();
            final Resource resource = resourceSet.getResource(URI.createFileURI(file.toAbsolutePath().toString()), true);
            EcoreUtil.resolveAll(resource);

            for(final EObject content : resource.getContents()) {
                if(content instanceof DefinitionModule module) {
                    addCitations(module, name, dlCitations, problems);
                }
            }
        }
    }

    /**
     * @return The DL files in the folder and its subfolders, sorted.
     */
    private static List<Path> dlFilesIn(final Path folder) throws IOException {
        if(!Files.isDirectory(folder)) {
            return List.of();
        }

        try(Stream<Path> files = Files.walk(folder)) {
            return files.filter(Files::isRegularFile)
                        .filter(file -> file.getFileName().toString().endsWith(".dl"))
                        .sorted()
                        .toList();
        }
    }

    private static void addCitations(final DefinitionModule module,
                                     final String file,
                                     final Map<String, List<String>> dlCitations,
                                     final List<String> problems) {
        final List<Definition> definitions = new ArrayList<>();
        definitions.addAll(module.getTypes());
        definitions.addAll(module.getEnums());
        definitions.addAll(module.getFunctions());

        for(final Definition definition : definitions) {
            final String citer = "'" + module.getName() + "." + definition.getName() + "'";
            checkAnnotations(definition, citer, file, problems);

            for(final String key : LiteratureReader.ownKeysOf(definition)) {
                dlCitations.computeIfAbsent(key, k -> new ArrayList<>()).add(citer);
            }
        }
    }

    /**
     * Reports an annotation {@code @Literature} whose type cannot be resolved; its keys would
     *   be lost silently otherwise.
     */
    private static void checkAnnotations(final Definition definition,
                                         final String citer,
                                         final String file,
                                         final List<String> problems) {
        for(final EObject constraint : definition.getConstraints()) {
            if(!(constraint instanceof Instance annotation) || annotation.getDefinition() == null
               || !annotation.getDefinition().eIsProxy()) {
                continue;
            }

            final List<INode> nodes = NodeModelUtils.findNodesForFeature(annotation, ExpressionsPackage.Literals.INSTANCE__DEFINITION);
            if(!nodes.isEmpty() && LiteratureReader.ANNOTATION.equals(NodeModelUtils.getTokenText(nodes.getFirst()))) {
                problems.add("The @" + LiteratureReader.ANNOTATION + " of " + citer + " in " + file + " cannot be "
                             + "resolved; import \"definitions\" from 'de.evoal.core.constraints';.");
            }
        }
    }

    /**
     * @return The keys of the citations files on the class path except the module's own one,
     *   each with the file; the first file wins if two define the same key.
     */
    private static Map<String, String> readDependencyEntries(final Path classesFolder, final ClassLoader classpath) throws IOException {
        final Map<String, String> entries = new LinkedHashMap<>();
        final Path ownFile = classesFolder.resolve(CreditsFiles.FOLDER).resolve(CreditsFiles.CITATIONS_FILE).toAbsolutePath().normalize();

        final Enumeration<URL> files = classpath.getResources(CreditsFiles.FOLDER + "/" + CreditsFiles.CITATIONS_FILE);
        while(files.hasMoreElements()) {
            final URL file = files.nextElement();
            if(isFile(file, ownFile)) {
                continue;
            }

            final String text;
            try(InputStream stream = file.openStream()) {
                text = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
            }

            try {
                BibTeXParser.parse(text)
                            .forEach(entry -> entries.putIfAbsent(entry.key(), file.toString()));
            } catch(final IllegalArgumentException e) {
                // checked by the build of the dependency
            }
        }

        return entries;
    }

    private static boolean isFile(final URL url, final Path file) {
        if(!"file".equals(url.getProtocol())) {
            return false;
        }

        try {
            return Path.of(url.toURI()).toAbsolutePath().normalize().equals(file);
        } catch(final URISyntaxException e) {
            return false;
        }
    }
}
