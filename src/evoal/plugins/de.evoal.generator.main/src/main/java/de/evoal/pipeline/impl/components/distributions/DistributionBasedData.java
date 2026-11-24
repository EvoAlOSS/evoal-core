package de.evoal.pipeline.impl.components.distributions;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.languages.model.base.definitions.BaseDataDescription;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.Requirements;
import de.evoal.pipeline.api.distribution.Distribution;
import de.evoal.pipeline.api.distribution.DistributionFactory;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.models.core.ecore.TypedEObject;
import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Fills the written data of a row with samples of the distributions, in the order of the
 *   distributions and their values. A discrete value is written as an {@code int} to integer
 *   data, any other value as a {@code double} to real data. A categorical value needs nominal or
 *   ordinal data.
 */
@Named("de.evoal.pipeline.distributions.distribution-based-data")
@Dependent
public class DistributionBasedData extends PipelineComponentImpl {
    /**
     * List of distributions to use to sample data
     */
    private List<Distribution> distributions;

    @Inject
    private DistributionFactory factory;

    @Inject
    private AttributeHelper helper;

    /**
     * Gives the data description, and so the scale, of a written data.
     */
    @Inject
    private EAnnotationHelper annotations;

    /**
     * If the value for the i-th written data is discrete.
     */
    private boolean [] discrete;

    /**
     * Creates the step; CDI injects its helpers.
     */
    public DistributionBasedData() {
    }

    /**
     * Creates a step with the given annotation helper, e.g., for tests.
     */
    DistributionBasedData(final EAnnotationHelper annotations) {
        this.annotations = annotations;
    }

    /**
     * @throws IllegalArgumentException if the number of written data differs from the number of
     *   values of the distributions, a discrete value does not go to integer data, a categorical
     *   value not to nominal or ordinal data, or a continuous value not to real data.
     */
    @Override
    public DistributionBasedData init(final EObject configuration) {
        final List<EObject> configurations = helper.lookup(configuration, "distributions");
        configure(factory.readDistributions(configuration, "distributions"),
                  configurations.stream().map(c -> c.eClass().getName()).toList());

        return this;
    }

    /**
     * Sets the distributions and checks the written data against their values, e.g., for
     *   tests. The features have to be set before.
     *
     * @param distributions The distributions.
     * @param names The DL names of the distributions, for the messages.
     */
    void configure(final List<Distribution> distributions, final List<String> names) {
        this.distributions = List.copyOf(distributions);
        discrete = checkWrites(names);
    }

    /**
     * Checks the written data against the values of the distributions.
     *
     * @return If the value for the i-th written data is discrete.
     */
    private boolean [] checkWrites(final List<String> names) {
        final List<EStructuralFeature> writes = new ArrayList<>();
        getWrites().iterator().forEachRemaining(writes::add);

        final int values = distributions.stream().mapToInt(Distribution::dimension).sum();
        Requirements.requireTrue(writes.size() == values,
                "'distribution-based-data' writes " + writes.size() + " data, but its distributions give " + values
                + " values per sample.");

        final boolean [] result = new boolean[values];
        int index = 0;
        for(int d = 0; d < distributions.size(); ++d) {
            final Distribution distribution = distributions.get(d);
            final String name = "'" + names.get(d) + "'";

            for(int i = 0; i < distribution.dimension(); ++i, ++index) {
                final EStructuralFeature feature = writes.get(index);
                result[index] = distribution.isDiscrete(i);

                if(result[index]) {
                    Requirements.requireTrue(EClassifierHelper.isInteger(feature.getEType()),
                            "'distribution-based-data' writes the whole numbers of " + name + " to '" + feature.getName()
                            + "', which is not integer data.");
                }
                if(distribution.isCategorical(i)) {
                    final ScaleType scale = scaleOf(feature);
                    Requirements.requireTrue(scale == ScaleType.NOMINAL || scale == ScaleType.ORDINAL,
                            "'distribution-based-data' writes the categories of " + name + " to '" + feature.getName()
                            + "', whose scale is " + scale.getLiteral() + "; categories need nominal or ordinal data.");
                }
                if(!result[index]) {
                    Requirements.requireTrue(EClassifierHelper.isDouble(feature.getEType()),
                            "'distribution-based-data' writes the real numbers of " + name + " to '" + feature.getName()
                            + "', which is not real data.");
                }
            }
        }

        return result;
    }

    /**
     * Returns the DDL scale of the data. Data without a scale in the DDL is nominal (the default
     *   of the DDL); typed data has the scale of its type.
     *
     * @return The scale, unknown if the data has no data description.
     */
    private ScaleType scaleOf(final EStructuralFeature feature) {
        return annotations.dataDescriptionOf(feature)
                          .filter(BaseDataDescription.class::isInstance)
                          .map(description -> ((BaseDataDescription) description).getScale())
                          .orElse(ScaleType.UNKNOWN);
    }

    @Override
    public @NonNull TypedEObject apply(@NonNull TypedEObject object) {
        final Iterator<EStructuralFeature> iterator = getWrites().iterator();
        int distributionIndex = 0;
        int sampleIndex = 0;
        int writeIndex = 0;
        double [] sample = distributions.get(distributionIndex).sample();

        while(iterator.hasNext()) {
            final EStructuralFeature feature = iterator.next();

            if(sampleIndex == sample.length) {
                sampleIndex = 0;
                distributionIndex += 1;
                sample = distributions.get(distributionIndex).sample();
            }

            final double value = sample[sampleIndex++];
            if(discrete[writeIndex++]) {
                object.eSet(feature, (int) value);
            } else {
                object.eSet(feature, value);
            }
        }

        return object;
    }
}
