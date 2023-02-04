package de.evoal.languages.model.eal.dsl.utils;

import java.util.LinkedHashSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;

/**
 * A global scope provider that injects built-in DSL files.
 */
public abstract class ClasspathDefaultGlobalScopeProvider extends ImportUriGlobalScopeProvider {
	/**
	 * The actual provider.
	 */
	private final BuiltinMapProvider provider;

	public ClasspathDefaultGlobalScopeProvider(final BuiltinMapProvider provider) {
		this.provider = provider;
	}
	
    @Override
    protected LinkedHashSet<URI> getImportedUris(final Resource resource) {
        final LinkedHashSet<URI> importedURIs = super.getImportedUris(resource);

        addBuiltinURIs(importedURIs);
        
        return importedURIs;
    }
    
    private void addBuiltinURIs(final LinkedHashSet<URI> uris) {
    	provider.get()
    			.map(BuiltinDSLInfo::getImportURI)
    			.forEach(uris::add);
    }

	protected BuiltinMapProvider getProvider() {
		return provider;
	}
}