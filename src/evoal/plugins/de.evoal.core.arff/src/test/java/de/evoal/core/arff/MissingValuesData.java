package de.evoal.core.arff;

import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.core.junit.resources.ResourceUtils;
import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.models.core.ecore.Space;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The test data {@code missing/}: a real {@code x:0}, an integer {@code n}, a boolean {@code b}
 *   and a string {@code s}; the ARFF file has a row of missing values and a row with 0 and an
 *   empty string.
 */
public final class MissingValuesData {
    public final Space space;
    public final EStructuralFeature x;
    public final EStructuralFeature n;
    public final EStructuralFeature b;
    public final EStructuralFeature s;

    /**
     * The folder with {@code missing/input.arff}.
     */
    public final Path folder;

    public MissingValuesData() throws IOException {
        final DataDescriptionModule model = LanguageHelper.loadFromClasspath("missing/specification.ddl");
        space = new Space(new EClassProvider().eClassFor(model));
        x = space.find("x:0").orElseThrow();
        n = space.find("n").orElseThrow();
        b = space.find("b").orElseThrow();
        s = space.find("s").orElseThrow();

        folder = Files.createTempDirectory("evoal-arff");
        ResourceUtils.unpack(getClass().getClassLoader(), folder.toFile(), "missing/input.arff");
    }

    public File input() {
        return folder.resolve("missing/input.arff").toFile();
    }

    /**
     * Writes an ARFF file with the attributes of {@code missing/input.arff} and the given rows.
     */
    public File arff(final String name, final String... rows) throws IOException {
        final String header = """
                @relation missing
                @attribute 'x:0' numeric
                @attribute n numeric
                @attribute b {false,true}
                @attribute s string
                @data
                """;

        final Path file = folder.resolve(name);
        Files.writeString(file, header + String.join("\n", rows) + "\n");

        return file.toFile();
    }
}
