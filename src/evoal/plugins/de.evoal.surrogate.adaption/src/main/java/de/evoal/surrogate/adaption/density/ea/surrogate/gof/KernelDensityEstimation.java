package de.evoal.surrogate.adaption.density.ea.surrogate.gof;

import de.evoal.surrogate.adaption.density.model.DensityData;
import de.evoal.surrogate.adaption.density.model.KernelDensityData;
import de.evoal.core.api.properties.PropertiesPair;
import de.evoal.core.api.properties.stream.PropertiesBasedPropertiesPairStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesPairStreamSupplier;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
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
    protected DensityData calculateDensityData(final Function<PropertiesPair, Double> mapper) {
        final PropertiesPairStreamSupplier supplier = new PropertiesBasedPropertiesPairStreamSupplier(trainingData, sourcePropertiesSpec, targetPropertiesSpec);
        final double [] data = supplier.get()
                .mapToDouble(pair -> mapper.apply(pair))
                .toArray();

        return new KernelDensityData(bandwidth, data);
    }
}
