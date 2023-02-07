package de.evoal.core.api.board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlackboardEntryTest {
    @Test
    public void testIsSameToItself() {
        final BlackboardEntry e1 = BlackboardEntry.of("example");

        Assertions.assertTrue(e1.isSame("example"));
    }

    @Test
    public void testIsSameWithDifferentLabel() {
        final BlackboardEntry e1 = BlackboardEntry.of("example");

        Assertions.assertFalse(e1.isSame("example2"));
    }
}
