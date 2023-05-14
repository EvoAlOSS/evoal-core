package de.evoal.core.ea.main.codec.chromosome;

import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.base.Array;
import de.evoal.languages.model.base.Attribute;
import de.evoal.languages.model.instance.DataReference;
import de.evoal.languages.model.base.Instance;
import io.jenetics.Chromosome;
import org.apache.commons.math3.util.Pair;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class DynamicChromosome {
   @Inject
   private ExpressionEvaluator evaluator;

    protected List<DataDescription> dataRepresented;
    protected PropertiesSpecification specification;

    public void init(final Instance specification) {
        final List<Instance> genes = (List<Instance>) evaluator.attributeToObject(specification, "genes");

        this.dataRepresented = genes.stream()
                                    .map(i -> evaluator.attributeToObject(i, "content"))
                                    .map(DataDescription.class::cast)
                                    .collect(Collectors.toList());

        this.dataRepresented = Collections.unmodifiableList(dataRepresented);
        this.specification = PropertiesSpecification.builder()
                                                    .add(dataRepresented.stream())
                                                    .build();
    }

    public abstract Chromosome toJenetics();
    public abstract Chromosome toJenetics(final Properties values);

    public abstract Properties toProperties(final Chromosome chromosome, final Properties properties);
}
