package de.evoal.languages.model.utils.builtin;

import java.net.URI;
import java.util.Collection;

/**
 * A provider searches for all available definition files with a specific
 * basename.
 */
public interface BuiltinProvider {
	/**
	 * Find all builtins matching the pattern: META-INF/specifications/{@code basename}/**\/*.dl
	 * 
	 * @param basename The location to search in.
	 * @return A list of URIs to the matching resources.
	 */
	public Collection<URI> findBuiltins(final String basename);
}
