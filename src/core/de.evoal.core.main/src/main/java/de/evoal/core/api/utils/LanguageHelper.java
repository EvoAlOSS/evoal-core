package de.evoal.core.api.utils;

import de.evoal.languages.model.dl.*;
import de.evoal.languages.model.base.BooleanLiteral;
import de.evoal.languages.model.base.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Helper class for processing instances.
 */
public final class LanguageHelper {
    /**
     * Logger instance
     */
    private static final Logger log = LoggerFactory.getLogger(LanguageHelper.class);

    /**
     * Private constructor for avoiding instances of this class.
     */
    private LanguageHelper() {
    }

    public static <T> T lookup(final Instance instance, final String path) {
        log.debug("Locking up '{}':", path);

        if(path == null) {
            log.warn("Asking for a null-path.");
            throw new IllegalArgumentException("Path is not allowed to be null");
        } else if(path.isEmpty()) {
            return (T)instance;
        }

        final String [] parts = path.split("\\.");

        Object current = instance;

        for(final String part : parts) {
            try {
                if(current == null) {
                    log.error("Unable to select child on null value.");
                    throw new IllegalStateException("Unable to select child on null value.");
                } else if(!(current instanceof Instance)) {
                    log.error("Failed to lookup part '{}' of path '{}' in '{}'.", part, path, current);
                    throw new IllegalStateException("Configuration is not valid.");
                }

                final Attribute attribute = ((Instance)current).findAttribute(part);

                if(attribute != null) {
                    current = attribute.getValue();
                } else if("name".equals(part)) {
                    current = ((Instance)current).getDefinition().getName();
                } else {
                    log.warn("Failed to lookup part '{}' of path '{}'. Returning null.", part, path);
                    log.warn("Current instance is: {}", ((Instance) current).getDefinition().getName());
                    log.warn("Available attributes:");
                    for(final Attribute a : ((Instance) current).getAttributes()) {
                        log.warn("  {}", a.getDefinition().getName());
                    }

                    log.error("Selecting non-existing path '{}'.", path);
                    throw new IllegalStateException("Selecting non-existing field: " + part);
                }
                if(attribute != null) {
                    current = convertToJava(current, attribute.getDefinition().getType());
                }
            } catch(final NullPointerException e) {
                log.error("Failed to lookup part '{}' of path '{}'.", part, path);
                throw e;
            }
        }

        if(current instanceof Instance) {
            log.debug("Mapping '{}' to instance with name '{}'.", path, ((Instance)current).getDefinition().getName());
        } else {
            log.debug("Mapping '{}' to '{}'.", path, current);
        }
        return (T) current;
    }

    private static Object convertToJava(final Object current, final Type type) {
        if(type instanceof InstanceType) {
            return (Instance)current;
        } else if(type instanceof LiteralType) {
            return readLiteral(current, type);
        } else if(type instanceof ArrayType) {
            return readArray(current, type);
        }

        return current;
    }

    private static Object readArray(final Object current, final Type type) {
        final Array array = (Array)current;

        return array.getValues()
                    .stream()
                    .map(current1 -> convertToJava(current1, ((ArrayType)type).getElements().get(0)))
                    .toArray();
    }

    private static Object readLiteral(final Object current, final Type type) {
        if(type instanceof FloatType) {
            return ((Number)((Literal)current).getValue()).doubleValue();
        } else if(type instanceof IntType) {
            return ((Number)((Literal)current).getValue()).intValue();
        } else if(type instanceof StringType) {
            return Objects.toString(((Literal)current).getValue());
        } else if(type instanceof BooleanType) {
            // TODO Fix hard call to is value
            return Boolean.TRUE.equals(((Literal)((Literal)current)).getValue());
        }

        throw new UnsupportedOperationException("Type " + type.toString() + " is not supported.");
    }

    public static Predicate<? super Value> filterInstanceByType(final String instanceTypeName) {
        return i -> instanceTypeName.equals(((Instance)i).getDefinition().getName());
    }

    public static Predicate<? super Instance> filterByAttributesInstanceType(final String attributeName, final String attributeTypeName) {
        return i -> attributeTypeName.equals(((Instance) i.findAttribute(attributeName).getValue()).getDefinition().getName());
    }
}
