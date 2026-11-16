package de.evoal.pipeline.impl.components.benchmarks;

import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.models.core.ecore.TypedEObject;
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

            final double valley = read_n - read_i * read_i;
            final double offset = 1 - read_i;
            value += 100 * (valley * valley) + offset * offset;
            ps_i = ps_n;
        }

        obj.eSet(getWrites().iterator().next(), value);

        return obj;
    }
}
