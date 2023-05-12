package de.evoal.surrogate.main.cdi;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.languages.model.mll.MachineLearningConfiguration;
import de.evoal.surrogate.api.SurrogateBlackboardEntries;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

import javax.enterprise.event.Observes;
import java.io.File;

public class MLLConfigurationProducerTest {
    @Test
    public void loadEmptyMLL() {
        final File mllFile = new File("src/test/resources/de/evoal/surrogate/main/cdi/empty.mll");

        final MLLConfigurationProducer producer = new MLLConfigurationProducer();

        final BlackboardEntry entryMock = mock(BlackboardEntry.class);
        when(entryMock.isSame(SurrogateBlackboardEntries.SURROGATE_CONFIGURATION_FILE)).thenReturn(true);
        when(entryMock.getLabel()).thenReturn(SurrogateBlackboardEntries.SURROGATE_CONFIGURATION_FILE);

        final Blackboard boardMock = mock(Blackboard.class);
        when(boardMock.get(SurrogateBlackboardEntries.SURROGATE_CONFIGURATION_FILE)).thenReturn(mllFile.getAbsolutePath());

        final MLLConfigurationProducer testee = new MLLConfigurationProducer();
        testee.loadModel(entryMock, boardMock);

        final ArgumentCaptor<MachineLearningConfiguration> captor = ArgumentCaptor.forClass(MachineLearningConfiguration.class);
        verify(boardMock).bind(eq(SurrogateBlackboardEntries.SURROGATE_CONFIGURATION), captor.capture());

        final MachineLearningConfiguration mlc = captor.getValue();

        Assertions.assertNotNull(mlc);
        Assertions.assertTrue(mlc.getDefinitions().isEmpty());
        Assertions.assertTrue(mlc.getStatements().isEmpty());
        Assertions.assertTrue(mlc.getImports().isEmpty());
    }

    @Test
    public void loadSimpleMLL() {
        final File mllFile = new File("src/test/resources/de/evoal/surrogate/main/cdi/simple.mll");

        final MLLConfigurationProducer producer = new MLLConfigurationProducer();

        final BlackboardEntry entryMock = mock(BlackboardEntry.class);
        when(entryMock.isSame(SurrogateBlackboardEntries.SURROGATE_CONFIGURATION_FILE)).thenReturn(true);
        when(entryMock.getLabel()).thenReturn(SurrogateBlackboardEntries.SURROGATE_CONFIGURATION_FILE);

        final Blackboard boardMock = mock(Blackboard.class);
        when(boardMock.get(SurrogateBlackboardEntries.SURROGATE_CONFIGURATION_FILE)).thenReturn(mllFile.getAbsolutePath());

        final MLLConfigurationProducer testee = new MLLConfigurationProducer();
        testee.loadModel(entryMock, boardMock);

        final ArgumentCaptor<MachineLearningConfiguration> captor = ArgumentCaptor.forClass(MachineLearningConfiguration.class);
        verify(boardMock).bind(eq(SurrogateBlackboardEntries.SURROGATE_CONFIGURATION), captor.capture());

        final MachineLearningConfiguration mlc = captor.getValue();

        Assertions.assertNotNull(mlc);
        Assertions.assertEquals(2, mlc.getImports().size());
        Assertions.assertEquals(1, mlc.getDefinitions().size());
        Assertions.assertTrue(mlc.getStatements().isEmpty());
    }
}