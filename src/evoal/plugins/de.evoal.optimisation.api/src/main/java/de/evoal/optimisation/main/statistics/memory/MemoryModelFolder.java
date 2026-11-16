package de.evoal.optimisation.main.statistics.memory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.NonNull;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;

import de.evoal.core.api.utils.EvoalIOException;

/**
 * The folder that holds the memory model files of one run. Every file is first written
 *   into the subfolder {@value #INCOMPLETE_FOLDER} and then moved into the folder in one
 *   step, so readers never see a partially written file.
 */
public class MemoryModelFolder {
    /**
     * The subfolder that holds the files while they are written.
     */
    public static final String INCOMPLETE_FOLDER = ".incomplete";

    /**
     * Writes the documents indented, one property per line.
     */
    private static final JsonMapper MAPPER = JsonMapper.builder()
                                                       .enable(SerializationFeature.INDENT_OUTPUT)
                                                       .build();

    /**
     * The folder of the run.
     */
    @Getter
    private final Path folder;

    /**
     * The subfolder that holds the files while they are written.
     */
    private final Path incompleteFolder;

    /**
     * @param folder The folder of the run.
     */
    public MemoryModelFolder(final @NonNull Path folder) {
        this.folder = folder;
        this.incompleteFolder = folder.resolve(INCOMPLETE_FOLDER);
    }

    /**
     * Removes the subfolder for incomplete files after the last file is written.
     *
     * @throws EvoalIOException if the subfolder cannot be removed.
     */
    public void complete() throws EvoalIOException {
        try {
            Files.deleteIfExists(incompleteFolder);
        } catch(final IOException e) {
            throw new EvoalIOException("Cannot remove the folder '" + incompleteFolder + "'.", e);
        }
    }

    /**
     * Deletes the folder and its content, e.g. the files of an earlier execution.
     */
    private void deleteFolder() throws IOException {
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

    /**
     * Prepares the folder for a new run: deletes the folder with all files of an earlier
     *   execution and creates it with an empty subfolder for incomplete files.
     *
     * @throws EvoalIOException if the folder cannot be deleted or created.
     */
    public void prepare() throws EvoalIOException {
        try {
            deleteFolder();
            Files.createDirectories(incompleteFolder);
        } catch(final IOException e) {
            throw new EvoalIOException("Cannot prepare the memory model folder '" + folder + "'.", e);
        }
    }

    /**
     * Writes the document into the folder. The file appears completely or not at all.
     *
     * @param fileName The name of the file, e.g. {@code iteration-0.json}.
     * @param document The content of the file.
     * @throws EvoalIOException if the file cannot be written.
     */
    public void write(final String fileName, final JsonNode document) throws EvoalIOException {
        final Path incompleteFile = incompleteFolder.resolve(fileName);
        final Path file = folder.resolve(fileName);
        final String content = MAPPER.writeValueAsString(document) + "\n";

        try {
            Files.writeString(incompleteFile, content, StandardCharsets.UTF_8);
            Files.move(incompleteFile, file, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch(final IOException e) {
            throw new EvoalIOException("Cannot write the memory model file '" + file + "'.", e);
        }
    }
}
