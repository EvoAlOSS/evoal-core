package de.evoal.core.main.language;

import de.evoal.languages.model.utils.builtin.BuiltinProvider;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;

@Slf4j
public class ModuleBuiltinProvider implements BuiltinProvider {
    @Override
    public Collection<URI> findBuiltins(final String name) {
        return Collections.emptyList();
    }
}
