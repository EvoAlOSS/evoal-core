package de.evoal.languages.model.utils.scoping;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

import de.evoal.languages.model.utils.builtin.BuiltinProvider;
import de.evoal.languages.model.utils.builtin.BuiltinProviderFactory;

public abstract class ClasspathGlobalScopeProvider extends ImportUriGlobalScopeProvider {
	private static Logger log = Logger.getLogger("de.evoal.languages.model.utils.scoping.ClasspathGlobalScopeProvider");
	@Inject
	IResourceDescription.Manager mgr;
	
	private final String name;
	
	public ClasspathGlobalScopeProvider(final String name) {
		this.name = name;
	}

	/*
	@Override
	protected IScope getScope(Resource resource, boolean ignoreCase, EClass type, Predicate<IEObjectDescription> predicate) {
		log.info(() -> "Providing scopes for " + resource.toString());
		final BuiltinProvider provider = BuiltinProviderFactory.create();
		final Collection<java.net.URI> files = provider.findBuiltins(name);

		IScope scope = super.getScope(resource, ignoreCase, type, predicate);
		for(final java.net.URI file : files) {
			final URI libearyResourceURI = URI.createURI(file.toString());
			Resource libraryResource = resource.getResourceSet().getResource(libearyResourceURI, false);
			if (libraryResource == null) {
				try {
					libraryResource = resource.getResourceSet().createResource(libearyResourceURI);
					libraryResource.load(Collections.emptyMap());
					libraryResource.getWarnings().stream().forEach(System.err::println);
					libraryResource.getErrors().stream().forEach(System.err::println);
				} catch (final IOException e) {
					log.warning(() -> "Failed to load library resource: " + file);
					e.printStackTrace();
				}
			}
			
			final IResourceDescription libraryDescription = mgr.getResourceDescription(libraryResource);
			scope = SelectableBasedScope.createScope(scope, libraryDescription, predicate, type, ignoreCase);
		}
		
		return scope;
	}
	*/
}

