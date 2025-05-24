package de.evoal.pipeline.impl.components.benchmarks;

import de.evoal.pipeline.api.model.ComponentImpl;
import de.evoal.core.api.ecore.TypedEObject;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.pipeline.benchmarks.weighted-sphere")
public class WeightedSphere extends ComponentImpl {
    @Override
    public @NonNull TypedEObject apply(final @NonNull TypedEObject obj) {
        final double n = getReads().size();
        double value = 0.0;
        int counter = 1;

        for(final EStructuralFeature feat : getReads()) {
            double read_i = obj.eGetAsDouble(feat);

            value += Math.pow(read_i, 2.0)  * counter++;
        }


        obj.eSet(getWrites().iterator().next(), value);

        return obj;
    }
}