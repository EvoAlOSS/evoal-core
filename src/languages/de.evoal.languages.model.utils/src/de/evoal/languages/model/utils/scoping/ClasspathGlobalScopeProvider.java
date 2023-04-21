package de.evoal.languages.model.utils.scoping;

import java.io.File;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.util.IAcceptor;

import de.evoal.languages.model.base.Import;

public class ClasspathGlobalScopeProvider extends ImportUriGlobalScopeProvider {
	public static class CustomUriResolver extends ImportUriResolver  {
		
		public CustomUriResolver() {
			System.err.println("Created custom URI resolver.");
			setAttributeName("importedNamespace");
		}
		
		public void setAttributeName(String attributeName) {
			super.setAttributeName("importedNamespace");
		}
		
		@Override
		public String apply(final EObject from) {
			if(!(from instanceof Import)) {
				return null;
			}
			
			// get imported module name
			final Import imp = (Import) from;
			String result = imp.getImportedNamespace();
			
			// turn into path
			result = result.replace('.', '/');
			
			// append file ending
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
			if(new File(result).exists()) {
				return "file:/" + result;
			} else {
				return "classpath:/" + result;
			}			
		}
	}
	
	/*
	@Override
	protected IAcceptor<String> createURICollector(Resource resource, Set<URI> collectInto) {
		System.err.println("Create URI collector: " + resource);
		setImportResolver(new CustomUriResolver());

		return super.createURICollector(resource, collectInto);
	}*/

	@Override
	public ImportUriResolver getImportUriResolver() {
		final ImportUriResolver resolver = super.getImportUriResolver();
		System.err.println("Resolver is " + resolver.getClass());
		if(resolver != null) {
			resolver.setAttributeName("importedNamespace");
		}
		
		return resolver;
	}
}

