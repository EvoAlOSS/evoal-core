package de.evoal.generator.main.functions.distributions;

import de.evoal.core.api.cdi.EvoalComponent;

public interface Distribution extends EvoalComponent<Distribution> {
    double sample();
}
