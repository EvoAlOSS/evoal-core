package de.evoal.core.api.utils;

import de.evoal.languages.model.el.*;
import de.evoal.languages.model.instance.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
                    log.error("Failed to lookup part '{}' of path '{}'.", part, path);
                    throw new IllegalStateException("EA configuration is not valid.");
                }

                boolean foundAttribute = false;
                for(final Attribute attr : ((Instance)current).getAttributes()) {
                    final NameOrMisc nom = attr.getName();

                    if(nom instanceof Misc && ((Misc)nom).getName().equals(part)) {
                        current =  attr.getValue();
                        foundAttribute = true;
                        break;
                    } else if(nom instanceof Name && ((Name)nom).getName().getName().equals(part)) {
                        current =  attr.getValue();
                        foundAttribute = true;
                        break;
                    }
                }

                if(!foundAttribute && "name".equals(part)) {
                    current = ((Instance)current).getName().getName();
                    foundAttribute = true;
                }

                if(!foundAttribute) {
                    log.error("Failed to lookup part '{}' of path '{}'. Returning null.", part, path);
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

        log.debug("Mapping " + path + " to " + current + " of type " + current.getClass());

        return (T) current;
    }

}
