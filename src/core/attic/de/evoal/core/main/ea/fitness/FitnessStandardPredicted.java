package de.evoal.core.main.ea.fitness;

import de.evoal.core.api.ea.fitness.FitnessBase;
import de.evoal.core.api.ea.fitness.type.FitnessConverter;
import de.evoal.core.api.properties.Properties;
import javax.enterprise.context.Dependent;

import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("standard_predicted-fitness")
public class FitnessStandardPredicted extends FitnessBase {
	@Inject @Named("depending")
	private FitnessConverter converter;

	@Override
	public double [] _fitness(final Properties candidate) {
		final int calculatedSize = targetVector.size();

		double fitness [] = new double [calculatedSize];

		final Properties predicted = surrogate.apply(candidate);

		for(int i = 0; i < calculatedSize; i++) {
			
			//fitness[i] = - Math.abs(predicted.get(i) - targetVector.get(i));
			fitness[i] = predicted.get(i) - targetVector.get(i);
		}

		return fitness;
	}
}
