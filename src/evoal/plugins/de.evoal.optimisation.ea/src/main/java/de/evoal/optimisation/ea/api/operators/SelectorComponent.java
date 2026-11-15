package de.evoal.optimisation.ea.api.operators;

import io.jenetics.Selector;

/**
 * An selector component is a wrapper for Jenetics selector and are necessary to inject
 *   them properly.
 */
public interface SelectorComponent extends EvoalComponent<SelectorComponent>, Selector {
}
