package de.evoal.core.api.languages;

import com.google.inject.Injector;
import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.utils.EvoAlShutDownException;
import de.evoal.core.api.validation.components.MetaValidationComponent;
import de.evoal.core.api.validation.model.Diagnostics;
import de.evoal.languages.model.base.Import;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.inject.Inject;
import java.io.File;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
public abstract class ModuleLoaderBase<T extends EObject> {
    @Inject
    protected Blackboard board;

    @Inject
    protected MetaValidationComponent validator;

    protected boolean observedErrors = false;

    public T load(final String filename) {
        log.info("Loading machine learning configuration from '{}'.",filename);

        final File configurationFile = new File(filename);
        if(!configurationFile.exists()) {
            log.info("Configuration file '{}' does not exist.", filename);
            throw new IllegalArgumentException("Please specify an existing configuration file.");
        }

        if(!configurationFile.isFile()) {
            log.info("Configuration file '{}' is not a file.", filename);
            throw  new IllegalArgumentException("Please specify a configuration file.");
        }

        if(!configurationFile.canRead()) {
            log.info("Configuration file '{}' cannot be read.", filename);
            throw new IllegalArgumentException("Please specify a readable configuration file.");
        }

        initializeEMF();

        return read(configurationFile);
    }

    /**
     * Initialize the model packages and perform the parser setup.
     */
    protected abstract void initializeEMF();

    /**
     * Parses the given generator file and returns the corresponding model.
     *
     * @param modelFile The model file to read.
     * @return The data validation model or an empty optional.
     */
    private T read(final File modelFile) {
        log.info("Reading model file {}.", modelFile);

        final Injector injector = setupInjector();

        final XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        resourceSet.addLoadOption(XtextResource.OPTION_ENCODING, "UTF-8");

        try {
            final URI modelURI = URI.createFileURI(modelFile.getAbsolutePath());

            final ArrayList<URI> loadingStack = new ArrayList<>();
            loadingStack.add(modelURI);

            log.info("Pre-Loading model URI {}", modelURI);
            final ArrayList<URI> order = extractLoadingGraph(injector, loadingStack);

            log.info("Loading the model and transitive resources.");

            log.info("Loading model from URI {}.", modelURI);
            Resource resource = null;
            for (URI uri : order) {
                resource = resourceSet.getResource(uri, true);
            }
            EcoreUtil.resolveAll(resource);

            observedErrors = false;
            validator.validate(resourceSet);

            if (observedErrors) {
                log.error("An error was found while validating '{}'. Please fix the shown errors and rerun EvoAl.", modelFile);
                throw new EvoAlShutDownException(3);
            }

            return toModule(resource);
        } catch (final EvoAlShutDownException e) {
            throw e;
        } catch (final Exception e) {
            log.error("Unable to load configuration file '{}'.", modelFile, e);
            throw new RuntimeException(e);
        }
    }

    public void receive(@Observes(notifyObserver = Reception.IF_EXISTS) final Diagnostics diag) {
        if(Diagnostics.Level.Error.equals(diag.level())) {
            log.error("Observed {} error.", diag);
            observedErrors = true;
        }
    }

    /**
     * Creates and setups the injector for creating the parser.
     *
     * @return A valid injector.
     */
    protected abstract Injector setupInjector();

    /**
     * Extracts the module from the resource.
     *
     * @param resource The loaded resource.
     * @return The root module.
     */
    protected abstract T toModule(final Resource resource);

    private @NonNull ArrayList<URI> extractLoadingGraph(final @NonNull Injector injector, final @NonNull ArrayList<URI> loadingStack) {
        log.info("Extracting loading graph from {} initial files.", loadingStack.size());
        loadingStack.forEach(u -> log.info("  {}", u));
        final XtextResourceSet temporarySet = injector.getInstance(XtextResourceSet.class);
        temporarySet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        temporarySet.addLoadOption(XtextResource.OPTION_ENCODING, "UTF-8");

        Resource eResource = null;
        for(final URI uri : loadingStack) {
            eResource = temporarySet.getResource(uri, true);
        }

        EcoreUtil.resolveAll(temporarySet);

        // collect which resources are loading which resources
        final Map<Resource, Set<Resource>> dependencies =
                temporarySet.getResources()
                        .stream()
                        .collect(Collectors.toMap(
                                Function.identity(),
                                r -> StreamSupport.stream(
                                                Spliterators.spliteratorUnknownSize(r.getAllContents(), Spliterator.ORDERED),
                                                false)
                                        .flatMap(e -> e.eCrossReferences().stream())
                                        .map(EObject::eResource)
                                        .collect(Collectors.toSet())
                        ));

        // remove self and null
        dependencies.forEach((key, val) -> val.remove(key));
        dependencies.forEach((key, val) -> val.remove(null));

        // Search for imports that are missing
        dependencies.forEach((resource, deps) -> {
            StreamSupport.stream(
                            Spliterators.spliteratorUnknownSize(resource.getAllContents(), Spliterator.ORDERED),
                            false)
                    .filter(Import.class::isInstance)
                    .map(Import.class::cast)
                    .map(Import::getFilename)
                    .filter(f -> deps.stream().noneMatch(dep -> dep.getURI().toString().endsWith(f)))
                    .forEach(f -> deps.add(temporarySet.getResource(URI.createURI("classpath:/" + f), true)));
        });

        // collect all files to load (transitively)
        final ArrayList<Resource> loadingOrder = new ArrayList<>();
        final ArrayList<Resource> workingList = new ArrayList<>();
        workingList.add(eResource);

        while(!workingList.isEmpty()) {
            final Resource resource = workingList.remove(workingList.size() - 1);
            if(loadingOrder.contains(resource)) {
                continue;
            }

            loadingOrder.add(0, resource);
            workingList.addAll(dependencies.getOrDefault(resource, Collections.emptySet()));
        }

        // do cycle detection
        Map<Resource, List<Set<Resource>>> cycles = findCycles(loadingOrder, dependencies);
        Map<Resource, Integer> cycleSizes = cycles.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().stream().mapToInt(Set::size).sum()));

        // sort them so dependencies are loaded first
        workingList.addAll(loadingOrder);
        loadingOrder.clear();

        while(!workingList.isEmpty()) {
            List<Resource> toAdd = workingList.stream()
                    .filter(r -> loadingOrder.containsAll(dependencies.getOrDefault(r, Collections.emptySet())))
                    .toList();

            if(toAdd.isEmpty()) {
                log.info("Resolving cycle");
                // We have a cycle that is blocking the ordering
                int smallest = Integer.MAX_VALUE;
                Resource smallestResource = null;

                for(final Resource r : workingList) {
                    if(!cycleSizes.containsKey(r)) {
                        continue;
                    }

                    int size = cycleSizes.get(r);

                    if(size < smallest) {
                        smallest = size;
                        smallestResource = r;
                    }
                }

                toAdd = cycles.get(smallestResource)
                        .stream()
                        .flatMap(Collection::stream)
                        .toList();
            }

            loadingOrder.addAll(toAdd);
            workingList.removeAll(toAdd);
        }

        if(loadingStack.size() != loadingOrder.size()) {
            return extractLoadingGraph(injector, new ArrayList<>(loadingOrder.stream().map(Resource::getURI).toList()));
        }

        return loadingStack;
    }

    private Map<Resource, List<Set<Resource>>> findCycles(final ArrayList<Resource> loadingOrder, Map<Resource, Set<Resource>> dependencies) {
        final Map<Resource, List<Set<Resource>>> cycles = new HashMap<>();

        for(final Resource resource : loadingOrder) {
            cycles.put(resource, findCycles(resource, Collections.singleton(resource), resource, dependencies));
        }

        return cycles;
    }

    private List<Set<Resource>> findCycles(final Resource start, final Set<Resource> path, final Resource last, final Map<Resource, Set<Resource>> dependencies) {
        // last dependency closed the cycle. Return the cycle.
        if(start == last) {
            return Collections.singletonList(path);
        }

        final Set<Resource> deps = dependencies.get(last);

        // No outgoing edges for last node in path -> No path found
        if(deps == null) {
            return Collections.emptyList();
        }

        final List<Set<Resource>> cycles = new ArrayList<>();
        for(final Resource dep : deps) {
            final Set<Resource> nextPath = new HashSet<>(path);
            nextPath.add(dep);

            cycles.addAll(findCycles(start, nextPath, dep, dependencies));
        }

        return cycles;

    }
}
