package de.evoal.optimisation.main.initial;

import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.definitions.RepresentationType;
import de.evoal.languages.model.base.definitions.TypedBaseDataDescription;
import de.evoal.languages.model.base.definitions.UntypedBaseDataDescription;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

@Slf4j
@Dependent
@Named("de.evoal.optimisation.core.random-population")
public class RandomInitialCandidates implements InitialCandidatesProvider {

    @Inject
    private PropertiesBoundaries boundaries;

    @Inject @Named("search-space-specification")
    private PropertiesSpecification searchSpaceSpecification;

    private final RandomGenerator randomness = RandomGenerator.getDefault();

    @Override
    public Stream<Properties> create() {
        final AtomicInteger counter = new AtomicInteger();
        return Stream.generate(() -> {
            log.info("Creating random initial candidate #{}.", counter.getAndIncrement());
            final Properties p =  new Properties(searchSpaceSpecification);

            for(final PropertySpecification spec : searchSpaceSpecification.getProperties()) {
                final PropertiesBoundaries.Boundaries bounds = boundaries.get(spec);

                Requirements.requireTrue(spec.type() instanceof UntypedBaseDataDescription || spec.type() instanceof TypedBaseDataDescription, "Only typed and untyped data allowed");

                RepresentationType repr = null;
                if(spec.type() instanceof UntypedBaseDataDescription) {
                    repr = ((UntypedBaseDataDescription)spec.type()).getRepresentation();
                } else if(spec.type() instanceof TypedBaseDataDescription) {
                    repr = ((TypedBaseDataDescription)spec.type()).getRepresentation();
                }

                Requirements.requireTrue(RepresentationType.REAL == repr || RepresentationType.INTEGER == repr || RepresentationType.BOOLEAN == repr, "Representation type " + repr + " not supported");

                if(RepresentationType.REAL == repr) {
                    p.put(spec, randomness.nextDouble(bounds.lower().doubleValue(), bounds.upper().doubleValue()));
                } else if (RepresentationType.INTEGER == repr) {
                    p.put(spec, randomness.nextInt(bounds.lower().intValue(), bounds.upper().intValue()));
                } else if (RepresentationType.BOOLEAN == repr) {
                    p.put(spec, randomness.nextInt(0, 2) == 1);
                } else {
                    Requirements.requireTrue(false);
                }
            }

            return p;
        });
    }
}
