package de.evoal.optimisation.ea.api.operators;

import io.jenetics.Alterer;

/**
 * An alterer component is a wrapper for Jenetics alterer and are necessary to inject
 *   them properly.
 */
public interface AltererComponent extends EvoalComponent<AltererComponent>, Alterer {
}
