package de.evoal.core.api.math;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Allows a method of {@link EvoalMath} to call a function that the build
 *   forbids everywhere else (forbiddenapis recognises annotations with this
 *   name). It is package-private, so only this package can use it.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
@interface SuppressForbidden {
}
