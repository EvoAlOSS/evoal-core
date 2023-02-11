/**
 * Built-ins are definition language files that are part of EvoAl plugins and
 *   describe the extensions for the different DSLs. We inject them automatically
 *   into the global scope of the DSLs so that the user can simply use them
 *   without importing them explicitly.
 *   
 * Depending on the environment, we need different strategies to find available
 *   builtins and different mechanisms to create the environment-specific provider.
 *   Pitifully, we have no dependency injection mechanism for Java module world
 *   and Eclipse world.
 */
package de.evoal.languages.model.utils.builtin;