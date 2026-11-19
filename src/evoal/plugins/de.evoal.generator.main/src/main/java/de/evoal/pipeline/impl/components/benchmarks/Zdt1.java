package de.evoal.pipeline.impl.components.benchmarks;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import lombok.NonNull;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.pipeline.api.model.PipelineComponentImpl;

/**
 * The benchmark ZDT1 (DL type {@code zdt1}; E. Zitzler, K. Deb, L. Thiele: Comparison of
 *   multiobjective evolutionary algorithms: empirical results. Evolutionary Computation 8(2),
 *   2000, pp. 173-195) with two objectives, both minimised, for n variables x_1, ..., x_n
 *   in [0, 1]:
 * <ul>
 *   <li>f_1 = x_1,</li>
 *   <li>g = 1 + 9 / (n - 1) * (x_2 + ... + x_n),</li>
 *   <li>f_2 = g * (1 - sqrt(f_1 / g)).</li>
 * </ul>
 * The Pareto-optimal front is f_2 = 1 - sqrt(f_1) for f_1 in [0, 1] (all x_i = 0 for i >= 2).
 *   The reads are x_1, ..., x_n in their order, the writes f_1 and f_2.
 */
@Dependent
@Named("de.evoal.pipeline.benchmarks.zdt1")
public class Zdt1 extends PipelineComponentImpl {
    /**
     * @throws IllegalStateException if the benchmark reads fewer than two variables or does
     *   not write exactly two values.
     */
    @Override
    public @NonNull TypedEObject apply(final @NonNull TypedEObject obj) {
        final List<EStructuralFeature> reads = new ArrayList<>();
        getReads().forEach(reads::add);
        final List<EStructuralFeature> writes = new ArrayList<>();
        getWrites().forEach(writes::add);

        if(reads.size() < 2 || writes.size() != 2) {
            throw new IllegalStateException("ZDT1 reads at least two variables and writes two values, but it reads "
                                            + reads.size() + " and writes " + writes.size() + ".");
        }

        final double f1 = obj.eGetAsDouble(reads.getFirst());

        double sum = 0.0;
        for(int i = 1; i < reads.size(); ++i) {
            sum += obj.eGetAsDouble(reads.get(i));
        }
        final double g = 1.0 + 9.0 * sum / (reads.size() - 1);
        // Math.sqrt is exactly rounded (IEEE 754), so it gives the same result on every platform
        final double f2 = g * (1.0 - Math.sqrt(f1 / g));

        obj.eSet(writes.get(0), f1);
        obj.eSet(writes.get(1), f2);
        return obj;
    }
}
