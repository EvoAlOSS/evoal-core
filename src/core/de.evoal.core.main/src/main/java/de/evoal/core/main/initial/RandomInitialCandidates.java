package de.evoal.core.main.initial;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.optimisation.InitialCandidatesProvider;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.languages.model.base.Instance;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

@Slf4j
public class RandomInitialCandidates implements InitialCandidatesProvider {

    @Inject
    private PropertiesBoundaries boundaries;

    @Inject @Named("search-space-specification")
    private PropertiesSpecification searchSpaceSpecification;

    private RandomGenerator randomness = RandomGenerator.getDefault();

    @Override
    public InitialCandidatesProvider init(final Instance configuration) {
        // this is not the function you are looking for.
        return this;
    }

    @Override
    public Stream<Properties> create() {
        return Stream.generate(() -> {
//            log.info("Creating a random initial candidate for {}.", searchSpaceSpecification);
            final Properties p =  new Properties(searchSpaceSpecification);

            for(final PropertySpecification spec : searchSpaceSpecification.getProperties()) {
                final PropertiesBoundaries.Boundaries bounds = boundaries.get(spec);
                p.put(spec, randomness.nextDouble(bounds.lower().doubleValue(), bounds.upper().doubleValue())); //FIXME
            }

            return p;
        });
    }
}
