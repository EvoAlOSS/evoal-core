package de.evoal.core.arff;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.io.PropertiesReader;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.core.arff.io.ArffPropertiesReader;
import de.evoal.core.arff.utils.LanguageUtils;
import de.evoal.core.arff.utils.ResourceUtils;
import de.evoal.languages.model.ddl.DataDescription;
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

        final File toLoad = new File(temporaryFolder, "simple/specification.ddl");
        final DataDescriptionModel model = LanguageUtils.load(toLoad, DataDescriptionModel.class);
        final PropertiesSpecification specification = toSpecification(model);

        final PropertiesReader testee = new ArffPropertiesReader()
                        .init(new File(temporaryFolder, "simple/input.arff"), specification);

        {
            Assertions.assertTrue(testee.hasNext());
            final Properties p = testee.next();
            Assertions.assertEquals(5.1, p.get(new PropertySpecification("sepallength", null)));
            Assertions.assertEquals(3.5, p.get(new PropertySpecification("sepalwidth", null)));
            Assertions.assertEquals(1.4, p.get(new PropertySpecification("petallength", null)));
            Assertions.assertEquals(0.2, p.get(new PropertySpecification("petalwidth", null)));
            Assertions.assertEquals("Iris-setosa", p.get(new PropertySpecification("class", null)));
        }
        {
            Assertions.assertTrue(testee.hasNext());
            final Properties p = testee.next();
            Assertions.assertEquals(4.9, p.get(new PropertySpecification("sepallength", null)));
            Assertions.assertEquals(3.0, p.get(new PropertySpecification("sepalwidth", null)));
            Assertions.assertEquals(1.4, p.get(new PropertySpecification("petallength", null)));
            Assertions.assertEquals(0.2, p.get(new PropertySpecification("petalwidth", null)));
            Assertions.assertEquals("Iris-setosa", p.get(new PropertySpecification("class", null)));
        }
        {
            Assertions.assertTrue(testee.hasNext());
            final Properties p = testee.next();
            Assertions.assertEquals(4.7, p.get(new PropertySpecification("sepallength", null)));
            Assertions.assertEquals(3.2, p.get(new PropertySpecification("sepalwidth", null)));
            Assertions.assertEquals(1.3, p.get(new PropertySpecification("petallength", null)));
            Assertions.assertEquals(0.2, p.get(new PropertySpecification("petalwidth", null)));
            Assertions.assertEquals("Iris-setosa", p.get(new PropertySpecification("class", null)));
        }
        {
            Assertions.assertTrue(testee.hasNext());
            final Properties p = testee.next();
            Assertions.assertEquals(4.6, p.get(new PropertySpecification("sepallength", null)));
            Assertions.assertEquals(3.1, p.get(new PropertySpecification("sepalwidth", null)));
            Assertions.assertEquals(1.5, p.get(new PropertySpecification("petallength", null)));
            Assertions.assertEquals(0.2, p.get(new PropertySpecification("petalwidth", null)));
            Assertions.assertEquals("Iris-setosa", p.get(new PropertySpecification("class", null)));
        }

        Assertions.assertFalse(testee.hasNext());
    }

    private PropertiesSpecification toSpecification(final DataDescriptionModel model) {
        return PropertiesSpecification
                .builder()
                .add(model.getDescriptions().stream())
                .build();
    }
}
