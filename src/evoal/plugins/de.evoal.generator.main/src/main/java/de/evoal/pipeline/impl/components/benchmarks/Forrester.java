package de.evoal.pipeline.impl.components.benchmarks;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import lombok.NonNull;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.math.EvoalMath;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.pipeline.api.model.PipelineComponentImpl;

/**
 * The one-dimensional Forrester function (DL type {@code forrester}; A. I. J. Forrester,
 *   A. Sóbester, A. J. Keane: Engineering Design via Surrogate Modelling. Wiley, 2008)
 *   f(x) = (6x - 2)^2 sin(12x - 4) on [0, 1]. It has a local minimum near x = 0.14 and the
 *   global minimum f(0.7572) = -6.0207. The benchmark reads x and writes f(x); values outside
 *   [0, 1] are computed by the same formula.
 */
@Dependent
@Named("de.evoal.pipeline.benchmarks.forrester")
public class Forrester extends PipelineComponentImpl {
    /**
     * @throws IllegalStateException if the benchmark does not read exactly one variable and
     *   write exactly one value.
     */
    @Override
    public @NonNull TypedEObject apply(final @NonNull TypedEObject obj) {
        final List<EStructuralFeature> reads = new ArrayList<>();
        getReads().forEach(reads::add);
        final List<EStructuralFeature> writes = new ArrayList<>();
        getWrites().forEach(writes::add);

        if(reads.size() != 1 || writes.size() != 1) {
            throw new IllegalStateException("The Forrester function reads one variable and writes one value, but it reads "
                                            + reads.size() + " and writes " + writes.size() + ".");
        }

        obj.eSet(writes.getFirst(), value(obj.eGetAsDouble(reads.getFirst())));
        return obj;
    }

    /**
     * @return f(x) = (6x - 2)^2 sin(12x - 4).
     */
    static double value(final double x) {
        return EvoalMath.square(6.0 * x - 2.0) * EvoalMath.sin(12.0 * x - 4.0);
    }
}
