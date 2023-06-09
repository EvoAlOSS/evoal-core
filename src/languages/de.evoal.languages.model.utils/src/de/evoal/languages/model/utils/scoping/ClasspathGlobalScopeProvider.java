package de.evoal.languages.model.utils.scoping;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.util.IAcceptor;

import de.evoal.languages.model.base.Import;

public class ClasspathGlobalScopeProvider extends ImportUriGlobalScopeProvider {
	private final static Logger log = Logger.getLogger(ClasspathGlobalScopeProvider.class.getCanonicalName());
	
	public static List<String> SEARCH_PATH = new LinkedList<>(Collections.singleton("./"));
	
	public static class CustomUriResolver extends ImportUriResolver  {
		
		public CustomUriResolver() {
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
			case "data":
				result += ".ddl";
				break;
			case "definitions":
				result += ".dl";
				break;
			case "optimisation":
			case "optimization":
				result += ".ol";
				break;
			}
			
			for(final String path : SEARCH_PATH) {
				if(new File(path, result).exists()) {
					final String resolvedFile = new File(path, result).toString();
					log.info("Resolved file to " + resolvedFile);
					return resolvedFile;
				} 				
			}
			
			log.info("Resolved file to classpath:/" + result);
			return "classpath:/" + result;
		}
	}
	
	public static class LoggingURICollector extends URICollector {
		
		public LoggingURICollector(ResourceSet resourceSet, Set<URI> result) {
			super(resourceSet, result);
		}

		public URI resolve(String uriAsString) throws IllegalArgumentException {
			return super.resolve(uriAsString);
		}

		@Override
		public void accept(String uriAsString) {
			super.accept(uriAsString);
		}
	}
	
	@Override
	protected IAcceptor<String> createURICollector(Resource resource, Set<URI> collectInto) {
		setImportResolver(new CustomUriResolver());

		ResourceSet resourceSet = resource.getResourceSet();
		return new LoggingURICollector(resourceSet, collectInto);
	}

	@Override
	public ImportUriResolver getImportUriResolver() {
		final ImportUriResolver resolver = super.getImportUriResolver();
		if(resolver != null) {
			resolver.setAttributeName("importedNamespace");
		}
		
		return resolver;
	}
}

