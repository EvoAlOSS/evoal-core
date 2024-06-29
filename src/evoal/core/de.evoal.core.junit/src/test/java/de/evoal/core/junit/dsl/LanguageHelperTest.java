package de.evoal.core.junit.dsl;

import org.eclipse.emf.ecore.EObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LanguageHelperTest {
    @Test
    public void loadBrokenDDLFile() {
        Assertions.assertThrows(RuntimeException.class, () -> LanguageHelper.loadFromClasspath("de/evoal/core/junit/dsl/broken.ddl"));
    }

    @Test
    public void loadBrokenDLFile() {
        Assertions.assertThrows(RuntimeException.class, () -> LanguageHelper.loadFromClasspath("de/evoal/core/junit/dsl/broken.dl"));
    }

    @Test
    public void loadBrokenGeneratorFile() {
        Assertions.assertThrows(RuntimeException.class, () -> LanguageHelper.loadFromClasspath("de/evoal/core/junit/dsl/broken.generator"));
    }

    @Test
    public void loadBrokenMLLFile() {
        Assertions.assertThrows(RuntimeException.class, () -> LanguageHelper.loadFromClasspath("de/evoal/core/junit/dsl/broken.mll"));
    }

    @Test
    public void loadBrokenOlFile() {
        Assertions.assertThrows(RuntimeException.class, () -> LanguageHelper.loadFromClasspath("de/evoal/core/junit/dsl/broken.ol"));
    }

    @Test
    public void loadUnsupportedFile() {
        EObject object = LanguageHelper.loadFromClasspath("de/evoal/core/junit/dsl/broken.unknown");

        Assertions.assertNull(object);
    }
}
