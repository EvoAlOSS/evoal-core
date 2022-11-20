package de.evoal.core.main.ea;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


import com.fasterxml.jackson.databind.ObjectMapper;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.main.ea.codecs.BitGenotypeToPropertiesCodec;
import de.evoal.core.main.ea.codecs.DoubleGenotypeToPropertiesCodec;
import de.evoal.core.main.ea.codecs.GrayBitGenotypeToPropertiesCodec;
import de.evoal.core.main.ea.chromosomes.BoundedOperations;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.board.BlackboardEntry;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import org.apache.commons.math3.util.Pair;

import javax.inject.Named;

@ApplicationScoped
public class EncodingFactory {

	/**
	 * Creates an encoding based on the heuristic configuration.
	 */
	@Produces
	public CustomCodec create(
			final @Named("source-properties-specification") PropertiesSpecification inputSpecification,
			final @Named("genotype-limits") List<Pair<Double, Double>> limits,
			final @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.encoding.name") String name,
			final @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.encoding.bounded_operations") boolean boundedOperations
			) {
		BoundedOperations.setUseBoundedOperations(boundedOperations);
		
		switch(name) {
		case "double_to_properties":
			return new DoubleGenotypeToPropertiesCodec(inputSpecification, limits);
		case "bit_to_properties":
			return new BitGenotypeToPropertiesCodec(inputSpecification, limits, 14);
		case "gray_bit_to_properties":
			return new GrayBitGenotypeToPropertiesCodec(inputSpecification, limits, 14);
		}
		
		throw new IllegalStateException("Code '" + name + "' is unknown.");
	}

	@Produces @ApplicationScoped @Named("genotype-limits")
	public List<Pair<Double, Double>> readLimits(final @BlackboardValue(BlackboardEntry.FITNESS_STANDARD_FUNCTION_FILE) String filename) {
		try (final InputStream os = new FileInputStream(new File(filename))) {
			final ObjectMapper mapper = new ObjectMapper();
			final Map<?, ?> configuration = mapper.readValue(os, Map.class);

			final List<Double> mins = ((List<Double>)configuration.get("lefthandSide")).stream().map(Double.class::cast).collect(Collectors.toList());
			final List<Double> maxs = ((List<Double>)configuration.get("righthandSide")).stream().map(Double.class::cast).collect(Collectors.toList());

			return IntStream.range(0, mins.size())
					        .mapToObj(i -> new Pair<>(mins.get(i), maxs.get(i)))
							.collect(Collectors.toList());
		} catch (final IOException e) {
			throw new IllegalArgumentException("Failed to configure original function.", e);
		}
	}
}
