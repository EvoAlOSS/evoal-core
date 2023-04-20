package de.evoal.languages.model.utils.scoping;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.ClasspathUriResolutionException;
import org.eclipse.xtext.resource.IClasspathUriResolver;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider.URICollector;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

import de.evoal.languages.model.base.Import;
import de.evoal.languages.model.utils.builtin.BuiltinProvider;
import de.evoal.languages.model.utils.builtin.BuiltinProviderFactory;

public abstract class ClasspathGlobalScopeProvider extends ImportUriGlobalScopeProvider {
	private static Logger log = Logger.getLogger("de.evoal.languages.model.utils.scoping.ClasspathGlobalScopeProvider");

	private @Inject
	IResourceDescription.Manager mgr;
	
	private final String name;
	
	public ClasspathGlobalScopeProvider(final String name) {
		System.err.println("Creating ClasspathGlobalScopeProvider.");
		this.name = name;
	}

	@Override
	public ImportUriResolver getImportUriResolver() {
		System.err.println("getImportUriResolver.");
		ImportUriResolver resolver = super.getImportUriResolver();
		
		if(resolver != null) {
			resolver.setAttributeName("importedNamespace");
		}
		
		return resolver;
	}

	public static class ClasspathURICollector implements IAcceptor<String> {
		private IClasspathUriResolver uriResolver;
		private Object uriContext;
		private Set<URI> result;
		private XtextResourceSet rs;

		public ClasspathURICollector(ResourceSet resourceSet, Set<URI> result) {
			this.result = result;
			if (resourceSet instanceof XtextResourceSet) {
				uriResolver = ((XtextResourceSet) resourceSet).getClasspathUriResolver();
				uriContext = ((XtextResourceSet) resourceSet).getClasspathURIContext();
				rs = (XtextResourceSet)resourceSet;
			}
		}

		public URI resolve(String uriAsString) throws IllegalArgumentException {
			System.err.println("Resolve: " + uriAsString);

			URI uri = URI.createURI(uriAsString);
			if (uriResolver != null) {
				try {
					return uriResolver.resolve(uriContext, uri);
				} catch(ClasspathUriResolutionException e) {
					return uri;
				}
			}
			return uri;
		}

		@Override
		public void accept(String uriAsString) {
			System.err.println("Accept: " + uriAsString);
			if (uriAsString == null) {
				return;
			}
			try {
				System.err.println("Accepting " + uriAsString);
				URI importUri = resolve(uriAsString);
				if (importUri != null) {
					result.add(importUri);
					System.err.println("Loading ---------------------> "+ importUri);
//					rs.getResource(importUri, false);
					System.err.println("Loaded ---------------------> "+ importUri);
				}
			} catch(Exception e) {
				e.printStackTrace();
				// ignore, invalid uri given
			}
		}
	}
	
	@Override
	protected IAcceptor<String> createURICollector(Resource resource, Set<URI> collectInto) {
		System.err.println("Create URI collector: " + resource);

		final ImportUriResolver r = getImportUriResolver();

		setImportResolver(new ImportUriResolver()  {
			public void setAttributeName(String attributeName) {
				System.err.println("setAttributeName(" + attributeName + ")");
				r.setAttributeName(attributeName);
			}
		
			public String getAttributeName() {
				System.err.println("getAttributeName()");
				return r.getAttributeName();
			}
	
			private SimpleAttributeResolver<EObject, String> resolver = null;
			@Override
			public SimpleAttributeResolver<EObject, String> getResolver() {
				if (resolver == null) {
					resolver = new SimpleAttributeResolver<>(String.class, "importedNamespace") {

						@Override
						public EAttribute getAttribute(EObject object) {
							System.err.println("SimpleAttributeResolver.getAttribute(" + object + ")");
							// TODO Auto-generated method stub
							return super.getAttribute(object);
						}

						@Override
						public String apply(EObject from) {
							System.err.println("SimpleAttributeResolver.apply(" + from + ")");
							// TODO Auto-generated method stub
							return super.apply(from);
						}

						@Override
						public Iterable<EObject> getMatches(Iterable<EObject> candidates, String value) {
							System.err.println("SimpleAttributeResolver.getMatches(" + candidates.iterator().next() + ", " + value + ")");
							// TODO Auto-generated method stub
							return super.getMatches(candidates, value);
						}

						@Override
						public String getValue(EObject object) {
							System.err.println("SimpleAttributeResolver.getValue(" + object + ") --> " +super.getValue(object));
							// TODO Auto-generated method stub
							return super.getValue(object);
						}
						
					};
				}
				return resolver;
			}

	
			public String resolve(EObject object) {
				System.err.println("resolve(" + object + ")");
				
				return r.resolve(object);
			}
	
			public EStructuralFeature getAttribute(EObject object) {
				System.err.println("getAttribute(" + object + ")");

				return r.getAttribute(object);
			}
	
			@Override
			public String apply(EObject from) {
				if(!(from instanceof Import)) {
					return null;
				}
				
				final Import imp = (Import) from;
				String result = imp.getImportedNamespace();
				result = result.replace('.', '/');
				
				switch(imp.getLanguage()) {
				case "definitions":
					result += ".dl";
					break;
				case "data":
					result += ".ddl";
					break;
				}

				System.err.println("ImportUriResolver.apply(" + from + ") --> " + result);
				
				System.err.println("  File exists:" + new File(result).exists());
				
				return "classpath:/" + result;
			}
		});

		ResourceSet resourceSet = resource.getResourceSet();
		return new ClasspathURICollector(resourceSet, collectInto);
	}
}

