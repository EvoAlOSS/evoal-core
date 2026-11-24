package de.evoal.optimisation.api.run;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LineageTest {
    private final Lineage mutation = Lineage.mutation(Mockito.mock(Candidate.class));

    @Test
    public void withPropertiesKeepsTheEarlierPropertiesAndTheOrder() {
        final Map<String, Object> added = new LinkedHashMap<>();
        added.put("b", 2L);
        added.put("a", 1L);

        final Lineage lineage = mutation.withProperty("c", 3L).withProperties(added);

        Assertions.assertEquals(List.of("c", "b", "a"), List.copyOf(lineage.properties().keySet()));
        Assertions.assertEquals(List.of(3L, 2L, 1L), List.copyOf(lineage.properties().values()));
    }

    @Test
    public void withPropertiesReplacesAPropertyWithTheSameName() {
        final Lineage lineage = mutation.withProperty("a", 1L).withProperties(Map.of("a", 2L));

        Assertions.assertEquals(Map.of("a", 2L), lineage.properties());
    }

    @Test
    public void withPropertiesLeavesTheOriginalUnchanged() {
        mutation.withProperties(Map.of("a", 1L));

        Assertions.assertEquals(Map.of(), mutation.properties());
    }
}
