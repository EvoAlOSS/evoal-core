package de.evoal.core.api.board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.enterprise.event.Event;

@ExtendWith(MockitoExtension.class)
public class BlackboardTest {
    @Mock
    private Event<BlackboardEntry> event;

    @InjectMocks
    private Blackboard blackboard;

    @Test
    public void readArgumentsWithoutMinusB() {
        blackboard.readArguments(new String [] {"myargument"});
    }

    @Test void getNonExistingEntry() {
        Assertions.assertThrows(IllegalStateException.class, () -> blackboard.get("non-existing-entry"));
    }

    @Test
    public void setLogging() {
        blackboard.readArguments(new String[]{ "-Bcore:logging=debug"});
    }
}
