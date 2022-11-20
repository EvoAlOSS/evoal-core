package de.evoal.core.main.ea.fitness;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.evoal.core.api.ea.fitness.FitnessBase;
import de.evoal.core.main.generator.functions.value.FunctionFactory;
import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.ea.fitness.type.FitnessConverter;
import de.evoal.core.api.properties.Properties;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;

import java.io.*;
import java.util.Map;
import java.util.Vector;
import java.util.function.Function;

@Named("standard-fitness")
@Dependent
@Slf4j
public class FitnessStandard extends FitnessBase {
	@Inject
	private Blackboard board;

	@Inject @Named("depending")
	private FitnessConverter converter;

	private Function<Vector<Double>, Vector<Double>> originalFunction;

	@PostConstruct
	public void init() {
		final String functionFileName = board.get(BlackboardEntry.FITNESS_STANDARD_FUNCTION_FILE);

		log.info("Using function specification from {}.", functionFileName);

		try (final InputStream os = new FileInputStream(new File(functionFileName))) {
			final ObjectMapper mapper = new ObjectMapper();
			final Map<?, ?> configuration = mapper.readValue(os, Map.class);

			originalFunction = FunctionFactory.create(configuration);
		} catch (final IOException e) {
			 throw new IllegalArgumentException("Failed to configure original function.", e);
		}
	}

	@Override
	protected double [] _fitness(final Properties candidate) {
		final int calculatedSize = targetVector.size();

		double fitness [] = new double [calculatedSize];

		final Vector<Double> input = new Vector<>();
		for(final double v : candidate.getValues()) {
			input.add(v);
		}

		final Vector<Double> calculated = originalFunction.apply(input);

		/* ACHTUNG: calculated enthält input + result. */

		for(int i = 0; i < calculatedSize; i++) {
			final double originalValue = calculated.get(input.size() + i);
			final double calculatedValue = targetVector.get(i);

			fitness[i] = -Math.abs(originalValue - calculatedValue);
		}

		return fitness;
	}
}
