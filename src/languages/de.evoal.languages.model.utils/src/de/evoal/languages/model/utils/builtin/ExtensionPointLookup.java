package de.evoal.languages.model.utils.builtin;

import java.util.function.Supplier;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * Using Eclipse's extension point mechanism to provide the builtin provider.
 */
public class ExtensionPointLookup implements Supplier<BuiltinProvider>{

	@Override
	public BuiltinProvider get() {
		final  IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor("de.evoal.languages.model.utils.builtin");
		
		for(final IConfigurationElement element : elements) {
			try {
				return (BuiltinProvider)element.createExecutableExtension("class");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return null;
	}
}
