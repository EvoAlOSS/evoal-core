package de.evoal.languages.model.utils.builtin;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;

public class ExtensionPointLookup implements Supplier<BuiltinProvider>{

	@Override
	public BuiltinProvider get() {
		final  IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor("de.evoal.languages.model.utils.builtin");
		
		for(final IConfigurationElement element : elements) {
			try {
				System.out.println(Arrays.toString(element.getAttributeNames()));
				return (BuiltinProvider)element.createExecutableExtension("class");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return null;
	}

}
