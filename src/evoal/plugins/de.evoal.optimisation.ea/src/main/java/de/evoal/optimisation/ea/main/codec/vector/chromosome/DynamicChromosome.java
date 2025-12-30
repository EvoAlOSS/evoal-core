package de.evoal.optimisation.ea.main.codec.vector.chromosome;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.Instance;
import io.jenetics.Chromosome;

import jakarta.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class DynamicChromosome implements EvoalComponent<DynamicChromosome> {
   @Inject
   private AttributeHelper helper;

    protected List<DataDescription> dataRepresented;
    protected PropertiesSpecification specification;

    @Override
    public DynamicChromosome init(final Instance specification) {
        final List<Instance> genes = helper.lookup(specification, "genes");

        this.dataRepresented = genes.stream()
                                    .map(i -> helper.<DataDescription>lookup(i, "content"))
                                    .collect(Collectors.toList());

        this.dataRepresented = Collections.unmodifiableList(dataRepresented);
        this.specification = PropertiesSpecification.builder()
                                                    .addDescriptions(dataRepresented.stream())
                                                    .build();

        return this;
    }

    public abstract Chromosome toJenetics();
    public abstract Chromosome toJenetics(final Properties values);

    public abstract Properties toProperties(final Chromosome chromosome, final Properties properties);
}
