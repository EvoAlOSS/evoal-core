package de.evoal.surrogate.main.cdi;

import java.io.*;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * Loader for different files necessary to train a prediction and load/store
 *   its state.
 */
@ApplicationScoped
@Slf4j
public class IOProducer {

	@Produces
	@Named("surrogate-loader")
	public Function<@NonNull File, @NonNull SurrogateConfiguration> createSurrogateLoader() {
		return IOProducer::loadPredictiveConfiguration;
	}

	@Produces
	@Named("surrogate-writer")
	public BiConsumer<@NonNull SurrogateConfiguration, @NonNull File> createSurrogateWriter() {
		return IOProducer::storePredictiveConfiguration;
	}

	private static SurrogateConfiguration loadPredictiveConfiguration(final @NonNull File file) {
		log.info("Loading predictive configuration from {}.", file);
		try(final InputStream is = new FileInputStream(file)) {
			return new ObjectMapper().readValue(is, SurrogateConfiguration.class);
		} catch (final IOException e) {
			log.error("Failed to load predictive configuration from {}.", file, e);

			throw new IllegalStateException("Failed to load predictive configuration from " + file);
		}
	}

	private static void storePredictiveConfiguration(final SurrogateConfiguration config, final File file) {
		log.info("Storing predictive configuration to {}.", file);

		try {
			new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(file, config);
		} catch (IOException e) {
			log.error("Failed to store configuration to {}", file, e);
		}
	}
}
