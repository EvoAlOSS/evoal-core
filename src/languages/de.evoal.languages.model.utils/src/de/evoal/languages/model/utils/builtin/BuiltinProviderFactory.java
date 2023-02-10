package de.evoal.languages.model.utils.builtin;


import java.util.Iterator;
import java.util.ServiceLoader;

public final class BuiltinProviderFactory {
	public static BuiltinProvider create() {
		final ServiceLoader<BuiltinProvider> loader = ServiceLoader.load(BuiltinProvider.class);
		final Iterator<BuiltinProvider> iterator = loader.iterator();
		while(iterator.hasNext()) {
			return iterator.next();
		}
		
		return new ExtensionPointLookup().get();
	}
}
