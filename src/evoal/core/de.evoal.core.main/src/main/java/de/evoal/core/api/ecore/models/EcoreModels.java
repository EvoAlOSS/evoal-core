package de.evoal.core.api.ecore.models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import de.evoal.languages.model.base.definitions.StructuredDataDescription;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.ecore.info.BoundaryExtractor;
import de.evoal.core.api.ecore.info.ConstraintAnnotations;
import de.evoal.core.api.ecore.info.FeatureBoundaries;

/**
 * The classes of structured data that come from Ecore metamodels ({@code .ecore} files) instead
 *   of DL types. The DDL names them with an annotation of {@code de.evoal.core.ecore}:
 * <pre>
 * &#64;EcoreType { files := [ "policy.ecore", "conditions.ecore" ]; root := "policy.ecore#//Policy"; }
 * data 'policy' of instance 'ecore-model';
 * </pre>
 * <ul>
 *   <li>All files of the application are loaded into one resource set (dynamic EMF). Their
 *     packages are registered by namespace URI in the resource set only, not globally. A file
 *     named by several annotations is loaded once.</li>
 *   <li>A relative file is resolved against the folder of the DDL file first, then against the
 *     working directory.</li>
 *   <li>A file whose namespace URI is the one of a package of an {@link EcorePackages} bean is
 *     only checked against that generated package (classes, features, types and multiplicities
 *     by name); references to the file then lead to the generated classes.</li>
 *   <li>After loading, every reference between the files must resolve, and the files must not
 *     refer to files that are not listed.</li>
 *   <li>The number boundaries of an attribute come from the facets {@code minInclusive},
 *     {@code maxInclusive}, {@code minExclusive} and {@code maxExclusive} of its data type
 *     ({@link ExtendedMetaData}), following the base types for a side without facet. They are
 *     attached to the attribute as {@link FeatureBoundaries} (in memory; the files are never
 *     saved). The scale is the annotation of {@code FeatureScales} that the metamodel writes on
 *     the attribute.</li>
 * </ul>
 * The problems of an annotation are reported together as an {@link IllegalStateException} when
 *   its data is mapped.
 */
@ApplicationScoped
@Slf4j
public class EcoreModels {
    /**
     * The DL module of the annotation and of the data type.
     */
    public static final String MODULE = "de.evoal.core.ecore";

    /**
     * The name of the annotation type.
     */
    public static final String ANNOTATION = "EcoreType";

    /**
     * The DL type of the data whose class the annotation names.
     */
    public static final String MODEL_TYPE = "ecore-model";

    /**
     * The generated packages of the plugins; looked up when they are first needed.
     */
    @Inject
    private jakarta.enterprise.inject.Instance<EcorePackages> packageBeans;

    /**
     * The generated packages by namespace URI; {@code null} until they are first needed.
     */
    private Map<String, EPackage> generatedPackages;

    /**
     * The resource set with all loaded files; {@code null} until the first file is loaded.
     */
    private ResourceSetImpl resources;

    /**
     * The URIs of the listed files, in the order they were first named.
     */
    private final Set<URI> listedFiles = new LinkedHashSet<>();

    /**
     * The root packages of the listed files (loaded or generated), in the order of the files.
     */
    private final Map<URI, EPackage> filePackages = new LinkedHashMap<>();

    /**
     * Creates the bean; the generated packages are looked up through CDI.
     */
    public EcoreModels() {
    }

    /**
     * Creates the loader without CDI, e.g., for tests.
     *
     * @param generated The generated packages, as {@link EcorePackages} beans would give them.
     */
    public EcoreModels(final @NonNull Collection<EPackage> generated) {
        this.generatedPackages = byNamespace(generated);
    }

    /**
     * @return {@code true} if the data description carries an {@code @EcoreType} annotation.
     */
    public static boolean hasEcoreType(final @NonNull StructuredDataDescription description) {
        return !annotationsOf(description).isEmpty();
    }

    /**
     * Loads the files that the {@code @EcoreType} annotation of the data names and returns the
     *   class it names.
     *
     * @param description Structured data with an {@code @EcoreType} annotation.
     * @return The class of the data.
     *
     * @throws IllegalStateException with all problems of the annotation, e.g. a file that is
     *   found nowhere, a reference that does not resolve or a root that is no class.
     */
    public EClass classOf(final @NonNull StructuredDataDescription description) {
        final List<Instance> annotations = annotationsOf(description);
        final String data = "'" + description.getName() + "'";
        if(annotations.size() != 1) {
            throw new IllegalStateException("The data " + data + " needs exactly one @EcoreType, but has " + annotations.size() + ".");
        }

        final Instance annotation = annotations.getFirst();
        final List<String> files = stringsOf(ConstraintAnnotations.valueOf(annotation, "files"));
        final Object root = ConstraintAnnotations.valueOf(annotation, "root");
        final URI base = description.eResource() == null ? null : description.eResource().getURI();

        return classOf(files, root instanceof String name ? name : null, base, "the @EcoreType of the data " + data);
    }

    /**
     * Loads the files and returns the class that {@code root} names, as for an {@code @EcoreType}
     *   annotation with these values.
     *
     * @param files The files of the metamodels.
     * @param root The class as {@code <file>#//<class>}, the file written as in {@code files}.
     * @param base The URI the files are resolved against first (the DDL file); {@code null} to
     *   resolve them against the working directory only.
     * @param what What names the files, for the messages.
     * @return The class.
     *
     * @throws IllegalStateException with all problems.
     */
    public EClass classOf(final @NonNull List<String> files, final String root, final URI base, final @NonNull String what) {
        final List<String> problems = new ArrayList<>();
        if(files.isEmpty()) {
            problems.add("'files' names no file");
        }
        if(root == null) {
            problems.add("'root' names no class");
        }

        final Map<String, URI> resolved = new LinkedHashMap<>();
        for(final String file : files) {
            resolve(file, base, problems).ifPresent(uri -> resolved.put(file, uri));
        }

        if(problems.isEmpty()) {
            resolved.values().forEach(uri -> load(uri, problems));
        }
        if(problems.isEmpty()) {
            checkReferences(problems);
        }

        EClass eClass = null;
        if(problems.isEmpty()) {
            eClass = rootClassOf(root, resolved, problems);
        }

        if(!problems.isEmpty()) {
            final String text = Character.toUpperCase(what.charAt(0)) + what.substring(1);
            throw new IllegalStateException(text + " cannot be loaded: " + String.join("; ", problems) + ".");
        }

        filePackages.values().forEach(EcoreModels::annotateBoundaries);

        return eClass;
    }

    /**
     * Returns the concrete classes a feature of the given type can hold: the classes of all loaded
     *   files that are neither abstract nor interfaces and are the type or extend it, ordered by
     *   their {@link #typeNameOf type names}. For a class of no loaded file, the classes of its
     *   own package tree are searched.
     *
     * @param type A class of a metamodel.
     * @return The concrete classes, including the type itself if it is concrete.
     */
    public List<EClass> concreteSubclassesOf(final @NonNull EClass type) {
        final Set<EPackage> packages = new LinkedHashSet<>(filePackages.values());
        final EPackage own = rootPackageOf(type);
        if(own != null && !packages.contains(own)) {
            packages.add(own);
        }

        final Map<String, EClass> subclasses = new TreeMap<>();
        for(final EPackage ePackage : packages) {
            for(final EClass candidate : classesOf(ePackage)) {
                final boolean isConcrete = !candidate.isAbstract() && !candidate.isInterface();
                final boolean isSubclass = candidate == type || candidate.getEAllSuperTypes().contains(type);
                if(isConcrete && isSubclass) {
                    subclasses.putIfAbsent(typeNameOf(candidate), candidate);
                }
            }
        }

        return List.copyOf(subclasses.values());
    }

    /**
     * Returns the name of the type of a model object's class as the outputs write it: the DL name
     *   for a class of a DL type (e.g. {@code model.Entry}), {@code <nsURI>#//<class>} for a
     *   class of a metamodel (e.g. {@code http://evoal.de/examples/policy#//Policy}, a class of a
     *   subpackage {@code <nsURI>#//<package>/<class>}). The name does not depend on where the
     *   file lies.
     *
     * @param eClass The class.
     * @return The name of its type.
     */
    public static String typeNameOf(final @NonNull EClass eClass) {
        if(DynamicEClassProvider.toClassDefinition(eClass).isPresent()) {
            return DynamicEClassProvider.dlTypeOf(eClass);
        }

        final EPackage root = rootPackageOf(eClass);
        if(root == null || root.getNsURI() == null) {
            return DynamicEClassProvider.dlTypeOf(eClass);
        }

        return root.getNsURI() + "#" + fragmentOf(eClass);
    }

    private static List<Instance> annotationsOf(final StructuredDataDescription description) {
        return ConstraintAnnotations.annotationsOf(description.getConstraints(), MODULE, ANNOTATION);
    }

    private static List<String> stringsOf(final Object value) {
        if(!(value instanceof List<?> values)) {
            return List.of();
        }

        return values.stream()
                     .filter(String.class::isInstance)
                     .map(String.class::cast)
                     .toList();
    }

    /**
     * Resolves a file against the folder of the DDL file, then against the working directory.
     */
    private Optional<URI> resolve(final String file, final URI base, final List<String> problems) {
        final ResourceSet set = resources();

        if(Path.of(file).isAbsolute()) {
            final URI absolute = URI.createFileURI(Path.of(file).normalize().toString());
            if(set.getURIConverter().exists(absolute, null)) {
                return Optional.of(absolute);
            }

            problems.add("the file '" + file + "' does not exist");
            return Optional.empty();
        }

        final List<URI> tried = new ArrayList<>();
        final URI relative = URI.createURI(file);
        if(base != null && base.isHierarchical() && !base.isRelative()) {
            final URI besideDdl = relative.resolve(base);
            tried.add(besideDdl);
            if(set.getURIConverter().exists(besideDdl, null)) {
                return Optional.of(besideDdl);
            }
        }

        final URI inWorkingDirectory = URI.createFileURI(Path.of(file).toAbsolutePath().normalize().toString());
        tried.add(inWorkingDirectory);
        if(set.getURIConverter().exists(inWorkingDirectory, null)) {
            return Optional.of(inWorkingDirectory);
        }

        problems.add("the file '" + file + "' is found neither at " + String.join(" nor at ", tried.stream().map(URI::toString).toList()));
        return Optional.empty();
    }

    /**
     * Loads a listed file once: into the resource set, or, if a generated package has its
     *   namespace URI, only for the check against that package.
     */
    private void load(final URI file, final List<String> problems) {
        if(!listedFiles.add(file)) {
            return;
        }

        final ResourceSetImpl set = resources();
        final Resource resource;
        try {
            resource = set.getResource(file, true);
        } catch(final RuntimeException e) {
            set.getResources().removeIf(loaded -> file.equals(loaded.getURI()));
            problems.add("the file " + file + " cannot be read: " + rootMessageOf(e));
            return;
        }

        if(resource.getContents().size() != 1 || !(resource.getContents().getFirst() instanceof EPackage loaded)) {
            problems.add("the file " + file + " has no package as its only root");
            return;
        }

        final String nsURI = loaded.getNsURI();
        final EPackage generated = nsURI == null ? null : generatedPackages().get(nsURI);
        if(generated != null) {
            set.getResources().remove(resource);
            useGenerated(file, generated, problems);
            return;
        }

        if(nsURI == null) {
            problems.add("the package of " + file + " has no namespace URI");
            return;
        }

        final Object registered = set.getPackageRegistry().get(nsURI);
        if(registered != null && registered != loaded) {
            problems.add("the namespace URI " + nsURI + " of " + file + " is already used by another package");
            return;
        }

        registerWithSubpackages(loaded);
        filePackages.put(file, loaded);
    }

    /**
     * Checks the file against the generated package and lets references to the file lead to it.
     */
    private void useGenerated(final URI file, final EPackage generated, final List<String> problems) {
        final ResourceSetImpl check = newResourceSet();
        final EPackage loaded;
        try {
            loaded = (EPackage) check.getResource(file, true).getContents().getFirst();
        } catch(final RuntimeException e) {
            problems.add("the file " + file + " cannot be read for the check against the generated package: " + rootMessageOf(e));
            return;
        }

        final List<String> differences = new ArrayList<>();
        PackageComparison.compare(loaded, generated, differences);
        if(!differences.isEmpty()) {
            problems.add("the file " + file + " differs from the generated package " + generated.getNsURI() + ": " + String.join(", ", differences));
            return;
        }

        if(generated.eResource() == null) {
            problems.add("the generated package " + generated.getNsURI() + " has no resource");
            return;
        }

        resources().getURIResourceMap().put(file, generated.eResource());
        registerWithSubpackages(generated);
        filePackages.put(file, generated);
        log.info("Using the generated package {} for {}.", generated.getNsURI(), file);
    }

    private void registerWithSubpackages(final EPackage ePackage) {
        if(ePackage.getNsURI() != null) {
            resources().getPackageRegistry().put(ePackage.getNsURI(), ePackage);
        }
        ePackage.getESubpackages().forEach(this::registerWithSubpackages);
    }

    /**
     * Resolves every reference between the loaded files; reports references that do not resolve
     *   and files that are loaded on demand although they are not listed.
     */
    private void checkReferences(final List<String> problems) {
        final ResourceSetImpl set = resources();
        EcoreUtil.resolveAll(set);

        final Map<EObject, Collection<EStructuralFeature.Setting>> proxies = EcoreUtil.ProxyCrossReferencer.find(set);
        proxies.keySet()
               .stream()
               .map(proxy -> "the reference to " + EcoreUtil.getURI(proxy) + " does not resolve")
               .distinct()
               .sorted()
               .forEach(problems::add);

        for(final Resource resource : List.copyOf(set.getResources())) {
            if(!listedFiles.contains(resource.getURI())) {
                problems.add("the files refer to " + resource.getURI() + ", which is not in 'files'");
                set.getResources().remove(resource);
            }
        }
    }

    /**
     * @return The class that {@code root} names ({@code <file>#<fragment>}, the file written as in
     *   'files'); {@code null} after adding a problem.
     */
    private EClass rootClassOf(final String root, final Map<String, URI> files, final List<String> problems) {
        final int hash = root.indexOf('#');
        if(hash < 0) {
            problems.add("'root' (" + root + ") has no '#': write it as <file>#//<class>");
            return null;
        }

        final String file = root.substring(0, hash);
        final URI uri = files.get(file);
        if(uri == null) {
            problems.add("'root' (" + root + ") names the file '" + file + "', which is not in 'files'");
            return null;
        }

        final EObject object = resources().getEObject(uri.appendFragment(root.substring(hash + 1)), false);
        if(!(object instanceof EClass eClass)) {
            problems.add("'root' (" + root + ") is no class of " + uri);
            return null;
        }

        return eClass;
    }

    /**
     * Attaches the boundaries from the facets of the data types to the numeric attributes of the
     *   package and its subpackages, unless an attribute has them already.
     */
    private static void annotateBoundaries(final EPackage ePackage) {
        for(final EClass eClass : classesOf(ePackage)) {
            for(final EAttribute attribute : eClass.getEAttributes()) {
                final boolean hasBoundaries = attribute.getEAnnotation(FeatureBoundaries.BOUNDARIES_SOURCE) != null;
                if(hasBoundaries || !(attribute.getEType() instanceof EDataType type) || !NumericConversions.isNumeric(type)) {
                    continue;
                }

                final BoundaryExtractor.Extracted boundaries = boundariesOf(type);
                try {
                    FeatureBoundaries.annotate(attribute, boundaries);
                } catch(final IllegalStateException e) {
                    throw new IllegalStateException("The facets of " + eClass.getName() + "." + attribute.getName() + " are no valid boundaries: " + e.getMessage(), e);
                }
            }
        }
    }

    private static BoundaryExtractor.Extracted boundariesOf(final EDataType type) {
        final ExtendedMetaData metaData = ExtendedMetaData.INSTANCE;

        final Optional<BoundaryExtractor.Bound> lower = boundOf(type, metaData::getMinInclusiveFacet, metaData::getMinExclusiveFacet);
        final Optional<BoundaryExtractor.Bound> upper = boundOf(type, metaData::getMaxInclusiveFacet, metaData::getMaxExclusiveFacet);

        return new BoundaryExtractor.Extracted(lower, upper);
    }

    /**
     * @return The bound of the first type along the base types that has the inclusive or the
     *   exclusive facet; the inclusive one if a type has both.
     */
    private static Optional<BoundaryExtractor.Bound> boundOf(final EDataType type,
                                                             final Function<EDataType, String> inclusive,
                                                             final Function<EDataType, String> exclusive) {
        final Set<EDataType> visited = new HashSet<>();
        for(EDataType current = type; current != null && visited.add(current); current = ExtendedMetaData.INSTANCE.getBaseType(current)) {
            final String included = inclusive.apply(current);
            if(included != null) {
                return Optional.of(new BoundaryExtractor.Bound(Double.parseDouble(included), true));
            }

            final String excluded = exclusive.apply(current);
            if(excluded != null) {
                return Optional.of(new BoundaryExtractor.Bound(Double.parseDouble(excluded), false));
            }
        }

        return Optional.empty();
    }

    private static List<EClass> classesOf(final EPackage ePackage) {
        final List<EClass> classes = new ArrayList<>();
        for(final EClassifier classifier : ePackage.getEClassifiers()) {
            if(classifier instanceof EClass eClass) {
                classes.add(eClass);
            }
        }
        ePackage.getESubpackages().forEach(sub -> classes.addAll(classesOf(sub)));

        return classes;
    }

    private static EPackage rootPackageOf(final EClass eClass) {
        EPackage current = eClass.getEPackage();
        while(current != null && current.getESuperPackage() != null) {
            current = current.getESuperPackage();
        }

        return current;
    }

    /**
     * @return The fragment of the class as Ecore writes it: {@code //<class>}, or
     *   {@code //<package>/.../<class>} for a class of a subpackage.
     */
    private static String fragmentOf(final EClass eClass) {
        final List<String> segments = new ArrayList<>();
        segments.add(eClass.getName());
        for(EPackage current = eClass.getEPackage(); current != null && current.getESuperPackage() != null; current = current.getESuperPackage()) {
            segments.addFirst(current.getName());
        }

        return "//" + String.join("/", segments);
    }

    private Map<String, EPackage> generatedPackages() {
        if(generatedPackages == null) {
            final List<EPackage> generated = new ArrayList<>();
            if(packageBeans != null) {
                packageBeans.forEach(bean -> generated.addAll(bean.packages()));
            }
            generatedPackages = byNamespace(generated);
        }

        return generatedPackages;
    }

    private static Map<String, EPackage> byNamespace(final Collection<EPackage> packages) {
        final Map<String, EPackage> byNamespace = new HashMap<>();
        for(final EPackage ePackage : packages) {
            final EPackage existing = byNamespace.putIfAbsent(Objects.requireNonNull(ePackage.getNsURI(), "A generated package has no namespace URI."), ePackage);
            if(existing != null && existing != ePackage) {
                throw new IllegalStateException("Two generated packages have the namespace URI " + ePackage.getNsURI() + ".");
            }
        }

        return byNamespace;
    }

    private ResourceSetImpl resources() {
        if(resources == null) {
            resources = newResourceSet();
        }

        return resources;
    }

    private static ResourceSetImpl newResourceSet() {
        // the base types of restricted data types refer to XMLType
        Objects.requireNonNull(XMLTypePackage.eINSTANCE);

        final ResourceSetImpl set = new ResourceSetImpl();
        set.getResourceFactoryRegistry()
           .getExtensionToFactoryMap()
           .put("ecore", new EcoreResourceFactoryImpl());
        set.setURIResourceMap(new HashMap<>());
        set.getURIConverter().getURIHandlers().addFirst(new ClasspathHandler());

        return set;
    }

    /**
     * Reads {@code classpath:} URIs, the URIs of DSL files from the plugin jars, through the
     *   context class loader, so a DDL file of a plugin can name files next to it.
     */
    private static final class ClasspathHandler extends URIHandlerImpl {
        private static final String SCHEME = "classpath";

        @Override
        public boolean canHandle(final URI uri) {
            return SCHEME.equals(uri.scheme());
        }

        @Override
        public InputStream createInputStream(final URI uri, final Map<?, ?> options) throws IOException {
            final URL url = urlOf(uri);
            if(url == null) {
                throw new FileNotFoundException(uri.toString());
            }

            return url.openStream();
        }

        @Override
        public boolean exists(final URI uri, final Map<?, ?> options) {
            return urlOf(uri) != null;
        }

        private static URL urlOf(final URI uri) {
            final String path = uri.path() == null ? "" : uri.path();
            final String name = path.startsWith("/") ? path.substring(1) : path;

            return Thread.currentThread().getContextClassLoader().getResource(name);
        }
    }

    private static String rootMessageOf(final Throwable throwable) {
        Throwable current = throwable;
        while(current.getCause() != null && current.getCause() != current) {
            current = current.getCause();
        }

        return Objects.requireNonNullElse(current.getMessage(), current.getClass().getSimpleName());
    }

    /**
     * Compares a loaded package with a generated one by name.
     */
    private static final class PackageComparison {
        private PackageComparison() {
        }

        static void compare(final EPackage loaded, final EPackage generated, final List<String> differences) {
            for(final EClassifier classifier : loaded.getEClassifiers()) {
                final EClassifier counterpart = generated.getEClassifier(classifier.getName());
                if(counterpart == null) {
                    differences.add("'" + classifier.getName() + "' is missing");
                    continue;
                }

                compareClassifiers(classifier, counterpart, differences);
            }

            for(final EClassifier classifier : generated.getEClassifiers()) {
                if(loaded.getEClassifier(classifier.getName()) == null) {
                    differences.add("'" + classifier.getName() + "' is not in the file");
                }
            }

            for(final EPackage sub : loaded.getESubpackages()) {
                final EPackage counterpart = generated.getESubpackages()
                                                      .stream()
                                                      .filter(candidate -> sub.getName().equals(candidate.getName()))
                                                      .findFirst()
                                                      .orElse(null);
                if(counterpart == null) {
                    differences.add("the package '" + sub.getName() + "' is missing");
                } else {
                    compare(sub, counterpart, differences);
                }
            }
        }

        private static void compareClassifiers(final EClassifier loaded, final EClassifier generated, final List<String> differences) {
            final String name = "'" + loaded.getName() + "'";
            if(loaded.eClass() != generated.eClass()) {
                differences.add(name + " is a " + loaded.eClass().getName() + " in the file, but a " + generated.eClass().getName());
                return;
            }

            if(loaded instanceof EClass loadedClass && generated instanceof EClass generatedClass) {
                compareClasses(loadedClass, generatedClass, differences);
            } else if(loaded instanceof EEnum loadedEnum && generated instanceof EEnum generatedEnum) {
                final List<String> loadedLiterals = loadedEnum.getELiterals().stream().map(EEnumLiteral::getName).toList();
                final List<String> generatedLiterals = generatedEnum.getELiterals().stream().map(EEnumLiteral::getName).toList();
                if(!loadedLiterals.equals(generatedLiterals)) {
                    differences.add(name + " has the literals " + loadedLiterals + " in the file, but " + generatedLiterals);
                }
            } else if(!Objects.equals(loaded.getInstanceClassName(), generated.getInstanceClassName())) {
                differences.add(name + " has the instance class " + loaded.getInstanceClassName() + " in the file, but " + generated.getInstanceClassName());
            }
        }

        private static void compareClasses(final EClass loaded, final EClass generated, final List<String> differences) {
            final String name = "'" + loaded.getName() + "'";
            if(loaded.isAbstract() != generated.isAbstract() || loaded.isInterface() != generated.isInterface()) {
                differences.add(name + " is abstract or an interface in only one of them");
            }

            final List<String> loadedSupertypes = loaded.getESuperTypes().stream().map(EClass::getName).toList();
            final List<String> generatedSupertypes = generated.getESuperTypes().stream().map(EClass::getName).toList();
            if(!loadedSupertypes.equals(generatedSupertypes)) {
                differences.add(name + " extends " + loadedSupertypes + " in the file, but " + generatedSupertypes);
            }

            for(final EStructuralFeature feature : loaded.getEStructuralFeatures()) {
                final EStructuralFeature counterpart = generated.getEStructuralFeature(feature.getName());
                final String featureName = "'" + loaded.getName() + "." + feature.getName() + "'";
                if(counterpart == null || !generated.getEStructuralFeatures().contains(counterpart)) {
                    differences.add(featureName + " is missing");
                    continue;
                }

                final boolean isSame = feature.eClass() == counterpart.eClass()
                                    && Objects.equals(typeName(feature), typeName(counterpart))
                                    && feature.getLowerBound() == counterpart.getLowerBound()
                                    && feature.getUpperBound() == counterpart.getUpperBound()
                                    && isContainment(feature) == isContainment(counterpart);
                if(!isSame) {
                    differences.add(featureName + " has another kind, type, multiplicity or containment");
                }
            }

            for(final EStructuralFeature feature : generated.getEStructuralFeatures()) {
                if(loaded.getEStructuralFeature(feature.getName()) == null) {
                    differences.add("'" + loaded.getName() + "." + feature.getName() + "' is not in the file");
                }
            }
        }

        private static String typeName(final EStructuralFeature feature) {
            return feature.getEType() == null ? null : feature.getEType().getName();
        }

        private static boolean isContainment(final EStructuralFeature feature) {
            return feature instanceof EReference reference && reference.isContainment();
        }
    }
}
