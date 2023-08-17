package de.evoal.languages.model.utils.validator;

import java.util.function.Consumer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class ModuleValidator {
	 
	public static void check(final EObject module, final String moduleName, final String extension, final Consumer<String> acceptor) {
		final Resource moduleResource = module.eResource();
		final URI moduleURI = moduleResource.getURI();
		final String moduleResourceName = moduleURI.toString();
		
		String expectedName = moduleName.replace(".", "/");
		expectedName += "." + extension;
		
		if(!moduleResourceName.endsWith(expectedName)) {
			acceptor.accept("The filename is expected to be '" + expectedName + "'.");
		}
	}

}