package de.evoal.core.junit.dsl;


import de.evoal.languages.model.utils.builtin.BuiltinProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;

public class NoOpBuiltinProviderTest {
    @Test
    public void testBuiltInsAreEmpty() {
        final BuiltinProvider testee = new NoOpBuiltinProvider();

        final Collection<URI> result = testee.findBuiltins("de.evoal.core.junit");

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());
    }
}
