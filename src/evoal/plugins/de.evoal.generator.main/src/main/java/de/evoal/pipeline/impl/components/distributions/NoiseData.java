package de.evoal.pipeline.impl.components.distributions;

import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.pipeline.api.distribution.Distribution;
import de.evoal.pipeline.api.distribution.DistributionFactory;
import de.evoal.pipeline.api.model.ComponentImpl;
import de.evoal.core.api.ecore.TypedEObject;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Iterator;
import java.util.List;

@Dependent
@Named("de.evoal.pipeline.distributions.noise-data")
public class NoiseData extends ComponentImpl {

	/**
	 * The different distributions to apply.
	 */
	private List<Distribution> distributions;

	@Inject
	private DistributionFactory factory;

	public ComponentImpl init(final Instance configuration) throws InitializationException {
		super.init(configuration);

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

			object.eSet(feature, object.eGetAsDouble(feature) + sample[sampleIndex++]);
		}

		return object;
	}
}
