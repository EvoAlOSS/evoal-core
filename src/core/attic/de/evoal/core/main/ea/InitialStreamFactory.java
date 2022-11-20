package de.evoal.core.main.ea;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.ea.surrogate.model.points.Point;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.ea.surrogate.model.points.PointsFactory;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import io.jenetics.Gene;
import io.jenetics.Genotype;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionInit;
import io.jenetics.engine.EvolutionStream;
import io.jenetics.util.ISeq;
import io.jenetics.util.RandomRegistry;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import org.apache.deltaspike.core.api.provider.BeanProvider;

@ApplicationScoped
public class InitialStreamFactory {
	/**
	 * Creates a initial generation based on the heuristic configuration.
	 *
	 * Blackboard slots used:
	 * <ul>
	 *   <li>{@link BlackboardEntry#EA_CONFIGURATION}.</li>
	 * </ul>
	 */
	@Produces
	public Function<Engine, EvolutionStream> create(
			@Named("source-properties-specification") final PropertiesSpecification sourceSpecification,
			@Named("target-properties-specification") final PropertiesSpecification targetSpecification,
			@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.size_of_population") final int sizeOfPopulation,
			@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.initialization.name") final String initializationType,
			final CustomCodec encoding) {

		final PropertiesSpecification totalSpecification = PropertiesSpecification.builder()
																				  .add(sourceSpecification)
																				  .add(targetSpecification)
																				  .build();

		switch (initializationType) {
			case "random": return engine -> engine.stream();
			case "training": return engine -> engine.stream(createTargetBasedInitialPopulation(encoding, totalSpecification, sourceSpecification, sizeOfPopulation));
		}

		throw new IllegalArgumentException("Initialization type " + initializationType + " is unknown.");
	}

	private static <G extends Gene<?, G>> EvolutionInit<G> createTargetBasedInitialPopulation(final CustomCodec<G> encoding, final PropertiesSpecification total, final PropertiesSpecification input, final int sizeOfPopulation) {
		final ISeq<Genotype<G>> inital = createInitialPopulation(encoding, total, input, sizeOfPopulation);

		return EvolutionInit.of(inital, 1);
	}

	private static <G extends Gene<?, G>> ISeq<Genotype<G>> createInitialPopulation(final CustomCodec<G> encoding, final PropertiesSpecification total, final PropertiesSpecification input, final int sizeOfPopulation) {
		final List<Genotype<G>> initialPopulation = new ArrayList<>(sizeOfPopulation);
		final PointsFactory factory = BeanProvider.getContextualReference("training-points", false, PointsFactory.class);
		final RandomGenerator random = RandomRegistry.random();

		final List<Point> trainingPoints = factory.apply(total).get().collect(Collectors.toList());

		for(int i = 0; i < sizeOfPopulation; ++i) {
			final int pointIndex = random.nextInt(trainingPoints.size());
			final Point point = trainingPoints.get(pointIndex);

			final Properties properties = Properties.create(input, point);

			final Genotype<G> genotype = encoding.encode(properties);

			ö  .add(genotype);
		}

		return initialPopulation.stream().collect(ISeq.toISeq());
	}
}
