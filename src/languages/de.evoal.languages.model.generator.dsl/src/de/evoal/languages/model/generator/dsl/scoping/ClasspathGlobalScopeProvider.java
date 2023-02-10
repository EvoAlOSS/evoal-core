package de.evoal.languages.model.generator.dsl.scoping;


import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceLoader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

import de.evoal.languages.model.utils.builtin.BuiltinProvider;
import de.evoal.languages.model.utils.builtin.BuiltinProviderFactory;

public class ClasspathGlobalScopeProvider extends ImportUriGlobalScopeProvider {
	@Inject
	IResourceDescription.Manager mgr;

	@Override
	public IScope getScope(final Resource resource, final EReference reference, final Predicate<IEObjectDescription> filter) {
		System.err.println("Asking for scope of " + resource);
		final BuiltinProvider provider = BuiltinProviderFactory.create();
		final Collection<java.net.URI> uris = provider.findBuiltins("META-INF/definitions/surrogate/");

		URI libaryResourceURI = URI.createURI("dummy://demo/test.mydsl");
		Resource libaryResource = resource.getResourceSet().getResource(libaryResourceURI, false);
		if (libaryResource == null) {
			System.out.println("LOOOOOOOOAAAAADDDDD");
			libaryResource = resource.getResourceSet().createResource(libaryResourceURI);
//			try {
//				libaryResource.load(new StringInputStream("Hello Libary1! Hello Libary2 from Libary1!"), null);
//			} catch (final IOException e) {
//				e.printStackTrace();
//			}
		}
		
//		IResourceDescription resourceDescription = mgr.getResourceDescription(libaryResource);
//		Iterable<IEObjectDescription> libary = resourceDescription.getExportedObjects();
//		return new SimpleScope(super.getScope(resource, reference, filter), libary, false);
		
		return super.getScope(resource, reference, filter);
	}
}
