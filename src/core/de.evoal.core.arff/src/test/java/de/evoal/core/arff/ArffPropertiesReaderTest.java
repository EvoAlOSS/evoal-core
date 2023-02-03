package de.evoal.core.arff;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.io.PropertiesReader;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.core.arff.utils.LanguageUtils;
import de.evoal.core.arff.utils.ResourceUtils;
import de.evoal.languages.model.ddl.DataDescriptionModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ArffPropertiesReaderTest {

    @Test
    public void testSimpleArff() throws EvoalIOException, IOException {
        final Path temporary = Files.createTempDirectory("evoal");
        final File temporaryFolder = temporary.toFile();
        ResourceUtils.unpack(getClass().getClassLoader(), temporaryFolder, "simple/input.arff", "simple/specification.ddl");
//        final DataDescriptionModel model = LanguageUtils.load(new File(temporaryFolder, "simple/specification.ddl"), DataDescriptionModel.class);
//        final PropertiesSpecification specification = toSpecification(model);


//        final PropertiesReader testee = new ArffPropertiesReader()
//                        .init(new File(temporaryFolder, "input.arff"), specification);

//        Assertions.assertTrue(testee.hasNext());
    }

    private PropertiesSpecification toSpecification(final DataDescriptionModel model) {
        return PropertiesSpecification
                .builder()
                .add(model.getDescriptions().stream())
                .build();
    }
}
