package de.evoal.optimisation.main.statistics.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;

import de.evoal.optimisation.api.execution.EvaluationPosition;
import de.evoal.optimisation.api.run.CurrentRun;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;

/**
 * Writes the models of structured search data whose class comes from an Ecore metamodel
 *   ({@code @EcoreType}) as XMI files (DL type {@code 'model-xmi'}). A file holds the model of
 *   one candidate, its root and everything it contains, and nothing else:
 *   {@code models/<data>/<iteration>-<individual id>.xmi} in the output folder of the run (in
 *   the evaluation setup in the subfolder of the run, as for the memory model).
 * <ul>
 *   <li>{@code all}: every surviving candidate of every iteration;</li>
 *   <li>{@code best-per-iteration}: the best candidates of every iteration;</li>
 *   <li>{@code best-so-far}: the best candidate so far, only when it changes, so the last file
 *     is the result of the run.</li>
 * </ul>
 * The folder is deleted when the run starts. The files are UTF-8 with {@code \n} line ends and
 *   without schema location, so they are the same on every machine; a reader registers the
 *   packages of the metamodel by their namespace URIs. The model is copied into the resource,
 *   since a resource takes the objects it contains out of their container.
 * <p>
 * A failure to write is logged and stops the writer; the run continues.
 */
@Dependent
@Named("de.evoal.optimisation.core.model-xmi")
@Slf4j
public class ModelXmiWriter implements StatisticsWriter {
    /**
     * The folder of the models in the output folder of the run.
     */
    public static final String FOLDER_NAME = "models";

    /**
     * The candidates whose models are written.
     */
    private enum Candidates {
        ALL,
        BEST_PER_ITERATION,
        BEST_SO_FAR;

        static Candidates of(final EEnumLiteral literal) {
            return switch(literal.getName()) {
                case "all" -> ALL;
                case "best-per-iteration" -> BEST_PER_ITERATION;
                case "best-so-far" -> BEST_SO_FAR;
                default -> throw new IllegalArgumentException("Unknown 'model-candidates' literal '" + literal.getName() + "'.");
            };
        }
    }

    @Inject
    private AttributeHelper attributes;

    /**
     * Provides the output folder and the position of the run.
     */
    @Inject
    private CurrentRun currentRun;

    @Inject @Named("search-space")
    private Space searchSpace;

    /**
     * The candidates whose models are written.
     */
    private Candidates candidates;

    /**
     * Whether a write failed; then nothing more is written.
     */
    private boolean failed;

    /**
     * The search data with the models.
     */
    private EReference feature;

    /**
     * The folder of the files of the run; {@code null} before the run starts.
     */
    private Path folder;

    /**
     * The id of the last best candidate written with {@code best-so-far}; {@code null} before
     *   the first one.
     */
    private Integer lastBest;

    @Override
    public StatisticsWriter init(final EObject configuration) {
        final EStructuralFeature data = attributes.lookup(configuration, "feature");
        final EStructuralFeature found = searchSpace.find(data.getName()).orElse(null);
        if(!(found instanceof EReference reference) || !reference.isContainment()) {
            throw new IllegalArgumentException("The 'feature' of 'model-xmi' has to be structured search data, but '"
                                               + data.getName() + "' is not.");
        }
        if(DynamicEClassProvider.toClassDefinition(reference.getEReferenceType()).isPresent()) {
            throw new IllegalArgumentException("The 'feature' of 'model-xmi' holds models of the DL type '"
                                               + DynamicEClassProvider.dlTypeOf(reference.getEReferenceType())
                                               + "', which has no metamodel file; 'model-xmi' writes models of "
                                               + "Ecore metamodels (@EcoreType), the memory model writes models of DL types.");
        }

        feature = reference;
        candidates = Candidates.of(attributes.lookup(configuration, "candidates"));

        return this;
    }

    @Override
    public void start() {
        folder = runFolder();
        try {
            deleteFolder(folder);
            Files.createDirectories(folder);
        } catch(final IOException e) {
            stopWriting(e);
        }
    }

    @Override
    public void add(final Iteration iteration) {
        if(failed) {
            return;
        }
        if(folder == null) {
            throw new IllegalStateException("'model-xmi' got iteration " + iteration.getNumber() + " before the run started.");
        }

        final int number = iteration.getNumber();
        selected(iteration).forEach(individual -> write(number, individual));
    }

    @Override
    public void write() {
        // every iteration is written when it is added
    }

    private Stream<? extends Individual> selected(final Iteration iteration) {
        return switch(candidates) {
            case ALL -> iteration.survivedIndividuals();
            case BEST_PER_ITERATION -> iteration.bestIndividuals();
            case BEST_SO_FAR -> newBestSoFar(iteration);
        };
    }

    private Stream<? extends Individual> newBestSoFar(final Iteration iteration) {
        final Individual best = iteration.getBestSoFar();
        if(best == null || Integer.valueOf(best.getId()).equals(lastBest)) {
            return Stream.empty();
        }

        lastBest = best.getId();

        return Stream.of(best);
    }

    private void write(final int iteration, final Individual individual) {
        if(failed || individual.getInput() == null) {
            return;
        }

        final Object model = individual.getInput().eGet(feature);
        if(!(model instanceof EObject root)) {
            return;
        }

        final Path file = folder.resolve(iteration + "-" + individual.getId() + ".xmi");
        final Resource resource = new XMIResourceImpl(URI.createFileURI(file.toString()));
        resource.getContents().add(EcoreUtil.copy(root));

        try {
            resource.save(Map.of(XMLResource.OPTION_ENCODING, "UTF-8",
                                 XMLResource.OPTION_LINE_DELIMITER, "\n"));
        } catch(final IOException e) {
            stopWriting(e);
        }
    }

    /**
     * @return The folder of the files of the current run.
     */
    private Path runFolder() {
        final Path baseFolder = currentRun.outputFolder()
                                          .toPath()
                                          .resolve(FOLDER_NAME);
        final Optional<EvaluationPosition> position = currentRun.position();
        final Path runFolder = position.map(EvaluationPosition::relativeFolder)
                                       .map(baseFolder::resolve)
                                       .orElse(baseFolder);

        return runFolder.resolve(feature.getName());
    }

    private static void deleteFolder(final Path folder) throws IOException {
        if(!Files.exists(folder)) {
            return;
        }

        try(Stream<Path> paths = Files.walk(folder)) {
            final Path[] deepestFirst = paths.sorted(Comparator.reverseOrder())
                                             .toArray(Path[]::new);
            for(final Path path : deepestFirst) {
                Files.delete(path);
            }
        }
    }

    private void stopWriting(final IOException e) {
        failed = true;
        log.error("'model-xmi' cannot write the models of '{}' into '{}'; it stops writing.", feature.getName(), folder, e);
    }
}
