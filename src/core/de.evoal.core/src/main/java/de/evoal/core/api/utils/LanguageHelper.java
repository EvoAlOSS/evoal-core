package de.evoal.core.api.utils;

import de.evoal.languages.model.el.*;
import de.evoal.languages.model.instance.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Predicate;

/**
 * Helper class for processing eal files.
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

        final String [] parts = path.split("\\.");

        Object current = instance;

        for(final String part : parts) {
            try {
                if(!(current instanceof Instance)) {
                    log.error("Failed to lookup part '{}' of path '{}' in '{}'.", part, path, current);
                    throw new IllegalStateException("EA configuration is not valid.");
                }

                final Attribute attribute = ((Instance)current).findAttribute(part);

                if(attribute != null) {
                    current = attribute.getValue();
                } else if("name".equals(part)) {
                    current = ((Instance)current).getName().getName();
                } else {
                    log.warn("Failed to lookup part '{}' of path '{}'. Returning null.", part, path);
                    log.warn("Current instance is: {}", ((Instance) current).getName().getName());
                    log.warn("Available attributes:");
                    for(final Attribute a : ((Instance) current).getAttributes()) {
                        log.warn("  {}", ((Name)a.getName()).getName().getName());
                    }
                    return null;
                }
            } catch(final NullPointerException e) {
                log.error("Failed to lookup part '{}' of path '{}'.", part, path);
                throw e;
            }
        }

        if(current instanceof LiteralValue) {
            Literal literal = ((LiteralValue)current).getLiteral();

            if(literal instanceof StringLiteral) {
                current = ((StringLiteral)literal).getValue();
            } else if(literal instanceof IntegerLiteral) {
                current = ((IntegerLiteral)literal).getValue();
            } else if(literal instanceof DoubleLiteral) {
                current = ((DoubleLiteral)literal).getValue();
            } else if(literal instanceof BooleanLiteral) {
                current = ((BooleanLiteral)literal).isValue();
            }
        }

        if(current instanceof Instance) {
            log.debug("Mapping '{}' to instance with name '{}'.", path, ((Instance)current).getName().getName());
        } else {
            log.debug("Mapping '{}' to '{}'.", path, current);
        }
        return (T) current;
    }

    public static Predicate<? super Value> filterInstanceByType(final String instanceTypeName) {
        return i -> instanceTypeName.equals(((Instance)i).getName().getName());
    }

    public static Predicate<? super Instance> filterByAttributesInstanceType(final String attributeName, final String attributeTypeName) {
        return i -> attributeTypeName.equals(((Instance) i.findAttribute(attributeName).getValue()).getName().getName());
    }
}
