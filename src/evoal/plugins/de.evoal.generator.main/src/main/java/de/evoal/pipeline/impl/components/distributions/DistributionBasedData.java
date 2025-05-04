package de.evoal.pipeline.impl.components.distributions;

import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.pipeline.api.distribution.Distribution;
import de.evoal.pipeline.api.distribution.DistributionFactory;
import de.evoal.pipeline.api.model.ComponentImpl;
import de.evoal.pipeline.api.model.TypedEObject;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Iterator;
import java.util.List;

@Named("de.evoal.pipeline.distributions.distribution-based-data")
@Dependent
public class DistributionBasedData extends ComponentImpl {
    /**
     * List of distributions to use to sample data
     */
    private List<Distribution> distributions;

    @Inject
    private DistributionFactory factory;

    @Override
    public DistributionBasedData init(final Instance configuration) {
        distributions = factory.readDistributions(configuration, "distributions");

        return this;
    }

    @Override
    public @NonNull TypedEObject apply(@NonNull TypedEObject object) {
        final Iterator<EStructuralFeature> iterator = getWrites().iterator();
        int distributionIndex = 0;
        int sampleIndex = 0;
        double [] sample = distributions.get(distributionIndex).sample();

        while(iterator.hasNext()) {
            final EStructuralFeature feature = iterator.next();

            if(sampleIndex == sample.length) {
                sampleIndex = 0;
                distributionIndex += 1;
                sample = distributions.get(distributionIndex).sample();
            }

            object.eSet(feature, sample[sampleIndex++]);
        }

        return object;
    }
}
