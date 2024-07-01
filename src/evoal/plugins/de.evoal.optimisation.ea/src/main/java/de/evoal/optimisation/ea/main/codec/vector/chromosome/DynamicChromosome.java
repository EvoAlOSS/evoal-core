package de.evoal.optimisation.ea.main.codec.vector.chromosome;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.base.Instance;
import io.jenetics.Chromosome;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class DynamicChromosome implements EvoalComponent<DynamicChromosome> {
   @Inject
   private ExpressionEvaluator evaluator;

    protected List<DataDescription> dataRepresented;
    protected PropertiesSpecification specification;

    @Override
    public DynamicChromosome init(final Instance specification) {
        final List<Instance> genes = (List<Instance>) evaluator.attributeToObject(specification, "genes");

        this.dataRepresented = genes.stream()
                                    .map(i -> evaluator.attributeToObject(i, "content"))
                                    .map(DataDescription.class::cast)
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
