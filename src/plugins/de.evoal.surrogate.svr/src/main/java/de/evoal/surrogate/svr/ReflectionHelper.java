package de.evoal.surrogate.svr;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ReflectionHelper {
	/**
	 * Logger instance
	 */
	private final static Logger log = LoggerFactory.getLogger(ReflectionHelper.class);

	private ReflectionHelper() {
	}

	public static Object getField(final Object object, final String name) {
		try {
			final Field field = object.getClass().getDeclaredField(name);

			field.setAccessible(true);
			
			return field.get(object);
		} catch(final NoSuchFieldException e) {
			log.error("Cannot determine the model parameters: Unable to read model of SVR.", e);
		} catch (final IllegalArgumentException e) {
			log.error("Cannot determine the model parameters: ", e);
		} catch (IllegalAccessException e) {
			log.error("Cannot determine the model parameters: ", e);
		}
		
		throw new IllegalStateException();
	}
}
