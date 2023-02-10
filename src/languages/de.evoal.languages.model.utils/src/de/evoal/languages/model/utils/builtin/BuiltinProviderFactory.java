package de.evoal.languages.model.utils.builtin;


import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.function.Supplier;

public final class BuiltinProviderFactory {
	public static BuiltinProvider create() {
		final ServiceLoader<BuiltinProvider> loader = ServiceLoader.load(BuiltinProvider.class);
		final Iterator<BuiltinProvider> iterator = loader.iterator();
		while(iterator.hasNext()) {
			return iterator.next();
		}
		
		
		try {
			final Class<Supplier<BuiltinProvider>> clazz = (Class<Supplier<BuiltinProvider>>) Class.forName("de.evoal.languages.model.utils.builtin.ExtensionPointLookup");
			return clazz.newInstance().get();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
