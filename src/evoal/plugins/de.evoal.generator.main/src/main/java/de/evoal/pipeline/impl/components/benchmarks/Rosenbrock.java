package de.evoal.pipeline.impl.components.benchmarks;

import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.core.api.ecore.TypedEObject;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.util.Iterator;

@Dependent
@Named("de.evoal.pipeline.benchmarks.rosenbrock")
public class Rosenbrock extends PipelineComponentImpl {
    @Override
    public @NonNull TypedEObject apply(final @NonNull TypedEObject obj) {
        final double n = getReads().size();
        double value = 0.0;

        final Iterator<EStructuralFeature> iter = getReads().iterator();
        EStructuralFeature ps_i = iter.next();

        while(iter.hasNext()) {
            final EStructuralFeature ps_n = iter.next();

            double read_i = obj.eGetAsDouble(ps_i);
            double read_n = obj.eGetAsDouble(ps_n);

            value += 100 * Math.pow(read_n - (Math.pow(read_i,  2.0)), 2.0) + Math.pow(1 - read_i, 2.0);
            ps_i = ps_n;
        }

        obj.eSet(getWrites().iterator().next(), value);

        return obj;
    }
}
