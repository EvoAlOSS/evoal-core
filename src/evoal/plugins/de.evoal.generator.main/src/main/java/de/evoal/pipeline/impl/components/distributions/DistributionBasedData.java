package de.evoal.pipeline.impl.components.distributions;

import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.pipeline.api.distribution.Distribution;
import de.evoal.pipeline.api.distribution.DistributionFactory;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.core.api.ecore.TypedEObject;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Iterator;
import java.util.List;

@Named("de.evoal.pipeline.distributions.distribution-based-data")
@Dependent
public class DistributionBasedData extends PipelineComponentImpl {
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
