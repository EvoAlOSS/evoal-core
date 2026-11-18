package de.evoal.optimisation.main.stopping;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.reproducibility.ReproducibilityNote;
import de.evoal.core.api.reproducibility.ReproducibilityProtocol;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;

@ExtendWith(MockitoExtension.class)
public class CheckFileForExistenceCriterionTest {
    @Mock
    private EObject configuration;

    @Mock
    private AttributeEvaluator evaluator;

    @TempDir
    private Path folder;

    private Path stopFile;

    private final ReproducibilityProtocol reproducibility = new ReproducibilityProtocol();

    private final CheckFileForExistenceCriterion criterion = new CheckFileForExistenceCriterion();

    private void inject(final String name, final Object value) throws Exception {
        final Field field = CheckFileForExistenceCriterion.class.getDeclaredField(name);
        field.setAccessible(true);
        field.set(criterion, value);
    }

    @BeforeEach
    public void configure() throws Exception {
        inject("evaluator", evaluator);
        inject("reproducibility", reproducibility);

        stopFile = folder.resolve("evoal-stop.txt");
        Mockito.when(evaluator.attributeToString(configuration, "file"))
               .thenReturn(stopFile.toString());
        criterion.init(configuration);
    }

    @Test
    public void theRunContinuesWithoutTheFile() {
        Assertions.assertFalse(criterion.shouldTerminate(MemoryFactory.eINSTANCE.createIteration()));
    }

    @Test
    public void theRunTerminatesWhenTheFileExists() throws IOException {
        // given
        Files.createFile(stopFile);

        // when
        final boolean terminates = criterion.shouldTerminate(MemoryFactory.eINSTANCE.createIteration());

        // then
        Assertions.assertTrue(terminates);
    }

    @Test
    public void reportsThatTheResultDependsOnTheFile() {
        // when
        final List<ReproducibilityNote> notes = reproducibility.notes();

        // then
        final String reason = "stops the run when the file '" + stopFile + "' exists, so the result depends on something outside the run";
        Assertions.assertEquals(List.of(new ReproducibilityNote("file-check", reason)), notes);
    }
}
