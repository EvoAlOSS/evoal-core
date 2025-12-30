package de.evoal.surrogate.adaption.density.ea.surrogate.gof;

import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.core.api.ecore.stream.EObjectPairStreamFactory;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.surrogate.adaption.density.model.KernelDensityData;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.util.function.Function;


/**
 * Calculates the density for each parameter and result of each predictive function
 *   and adds them to the pre-calculated data.
 */
@Dependent
@Named("de.evoal.surrogate.adaption.density.ml.kernel-density-estimation")
@Slf4j
public class KernelDensityEstimation extends AbstractDensityEstimation {

    @Override
    protected KernelDensityData calculateDensityData(final Function<EObjectPair, Double> mapper) {
        final EObjectPairStreamSupplier supplier = EObjectPairStreamFactory.createFromList(sourcePropertiesSpec, targetPropertiesSpec, trainingData);
        final double [] data = supplier.get()
                .mapToDouble(pair -> mapper.apply(pair))
                .toArray();

        return new KernelDensityData(bandwidth, data);
    }
}
