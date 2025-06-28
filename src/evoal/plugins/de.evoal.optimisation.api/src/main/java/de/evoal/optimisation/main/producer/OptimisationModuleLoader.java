package de.evoal.optimisation.main.producer;

import com.google.inject.Injector;
import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.utils.EvoAlShutDownException;
import de.evoal.core.api.validation.model.Diagnostics;
import de.evoal.core.api.validation.components.MetaValidationComponent;
import javax.enterprise.context.ApplicationScoped;

import de.evoal.languages.model.base.Import;
import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import de.evoal.languages.model.ddl.impl.DdlPackageImpl;
import de.evoal.languages.model.dl.dsl.DefinitionLanguageStandaloneSetup;
import de.evoal.languages.model.dl.impl.DlPackageImpl;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.languages.model.ol.dsl.OptimisationLanguageStandaloneSetup;
import de.evoal.languages.model.ol.impl.OLPackageImpl;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
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
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.io.File;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@ApplicationScoped
@Slf4j
public class OptimisationModuleLoader {
    @Inject
    private Blackboard board;

    @Inject
    private MetaValidationComponent validator;

    private boolean observedErrors = false;

    public OptimisationModule load(final String filename) {
        log.info("Loading optimisation configuration from {}.",  filename);

        final File configurationFile = new File(filename);
        if(!configurationFile.exists() || ! configurationFile.canRead()) {
            log.error("Unable to read optimisation configuration file '{}'", filename);
            throw new IllegalArgumentException("Unable to read optimisation configuration file: " + filename);
        }

        final File folder = configurationFile.getAbsoluteFile().getParentFile();

        initializeEMF();

        final Injector olInjector = new OptimisationLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
        // do not remove the following line even if the injector is not used. Otherwise, parsing ol files breaks.
        final Injector idlInjector = new DefinitionLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();

        final XtextResourceSet resourceSet = olInjector.getInstance(XtextResourceSet.class);
        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        resourceSet.addLoadOption(XtextResource.OPTION_ENCODING, "UTF-8");

        try {
            final URI modelURI = URI.createFileURI(configurationFile.getAbsolutePath());

            final ArrayList<URI> loadingStack = new ArrayList<>();
            loadingStack.add(modelURI);

            log.info("Pre-Loading model URI {}", modelURI);
            final ArrayList<URI> order = extractLoadingGraph(olInjector, loadingStack);

            log.info("Loading the model and transitive resources.");

            log.info("Loading ol model from URI {}.", modelURI);
            Resource resource = null;
            for(URI uri : order) {
                resource = resourceSet.getResource(uri, true);
            }
            EcoreUtil.resolveAll(resource);

            observedErrors = false;
            validator.validate(resourceSet);

            if(observedErrors) {
                log.error("An error was found while validating '{}'. Please fix the shown errors and rerun EvoAl.", filename);
                throw new EvoAlShutDownException(3);
            }

            return (OptimisationModule) resource.getContents().get(0);
        } catch(final EvoAlShutDownException e) {
            throw e;
        } catch (final Exception e) {
            log.error("Unable to load optimisation configuration file '{}'.", configurationFile, e);
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
     * Initialize the model packages and perform the parser setup.
     */
    private void initializeEMF() {
        OLPackageImpl.init();
        DlPackageImpl.init();
        DdlPackageImpl.init();

        OptimisationLanguageStandaloneSetup.doSetup();
        DefinitionLanguageStandaloneSetup.doSetup();
        DataDescriptionLanguageStandaloneSetup.doSetup();
    }

    @Produces
    public OptimisationModule create(final Blackboard board) {
        return board.get(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION);
    }

    private @NonNull ArrayList<URI> extractLoadingGraph(final @NonNull Injector injector, final @NonNull ArrayList<URI> loadingStack) {
        log.info("Extracting loading graph from {} initial files.", loadingStack.size());
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
                    .filter(f -> ! deps.stream().anyMatch(dep -> dep.getURI().toString().endsWith(f)))
                    .forEach(f -> deps.add(temporarySet.getResource(URI.createURI("classpath:/" + f), true)));
        });

        // build order
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

        workingList.addAll(loadingOrder);
        loadingOrder.clear();

        while(!workingList.isEmpty()) {
            final List<Resource> toAdd = workingList.stream()
                            .filter(r -> loadingOrder.containsAll(dependencies.getOrDefault(r, Collections.emptySet())))
                            .toList();

            loadingOrder.addAll(toAdd);
            workingList.removeAll(toAdd);
        }

        if(loadingStack.size() != loadingOrder.size()) {
            return extractLoadingGraph(injector, new ArrayList<>(loadingOrder.stream().map(Resource::getURI).toList()));
        }

        return loadingStack;
    }
}
