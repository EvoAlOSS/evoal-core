package de.evoal.surrogate.adaption.density.model;

import de.evoal.surrogate.api.io.ModelWriter;
import de.evoal.surrogate.api.io.pson.Parameter;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.function.Consumer;

public interface DensityData {

    void attachTo(final Consumer<Parameter> appender);

    double probability(final double value);
}
