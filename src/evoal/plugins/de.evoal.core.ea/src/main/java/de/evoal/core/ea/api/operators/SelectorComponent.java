package de.evoal.core.ea.api.operators;

import de.evoal.core.api.cdi.EvoalComponent;
import io.jenetics.Selector;

/**
 * An selector component is a wrapper for Jenetics selector and are necessary to inject
 *   them properly.
 */
public interface SelectorComponent extends EvoalComponent<SelectorComponent>, Selector {
}
