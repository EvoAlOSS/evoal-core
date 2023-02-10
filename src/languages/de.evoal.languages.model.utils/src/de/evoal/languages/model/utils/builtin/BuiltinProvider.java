package de.evoal.languages.model.utils.builtin;

import java.net.URI;
import java.util.Collection;

public interface BuiltinProvider {
	public Collection<URI> findBuiltins(final String name);
}
