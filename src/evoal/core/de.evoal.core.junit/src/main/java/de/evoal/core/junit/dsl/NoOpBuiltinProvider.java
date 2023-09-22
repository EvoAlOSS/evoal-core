package de.evoal.core.junit.dsl;

import de.evoal.languages.model.utils.builtin.BuiltinProvider;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;

public class NoOpBuiltinProvider implements BuiltinProvider {
    @Override
    public Collection<URI> findBuiltins(String s) {
        return Collections.emptyList();
    }
}
