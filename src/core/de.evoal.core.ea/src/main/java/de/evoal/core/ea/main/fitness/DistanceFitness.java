package de.evoal.core.ea.main.fitness;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.optimisation.OptimisationFunction;
import de.evoal.core.api.optimisation.OptimisationFunctionDecorator;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.instance.*;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("distance")
@Slf4j
public class DistanceFitness extends OptimisationFunctionDecorator {

    @Inject
    private Blackboard board;

    /**
     * The target to search for.
     */
    private Properties target;

    @Override
    public double[] evaluate(final Properties properties) {
        final Object [] target = this.target.getValues();
        final double [] current = decoratedFunction.evaluate(properties);

        Requirements.<Object>requireSameSize(current, target);

        final double result[] = new double[target.length];
        for(int i = 0; i  < target.length; ++i) {
            result[i] = distance(target[i], current[i]);
        }

        return result;
    }

    private double distance(final Object o, final double v) {
        return Math.abs(((Number)o).doubleValue() - v);
    }

    @Override
    public OptimisationFunction init(final Instance config) {
        super.init(config);

        final Attribute target = config.findAttribute("target");

        if(target == null) {
            this.target = board.get(CoreBlackboardEntries.TARGET_PROPERTIES);
        } else {
            this.target = toProperties((Array)target.getValue());
            log.info("Binding target properties based on information found in MLL to {}.", this.target);
            board.bind(CoreBlackboardEntries.TARGET_PROPERTIES, this.target);
        }

        return this;
    }

    private static Properties toProperties(final Array array) {
        PropertiesSpecification specification = PropertiesSpecification.builder()
                                                                       .add(array.getValues()
                                                                                 .stream()
                                                                                 .map(Instance.class::cast)
                                                                                 .map(i -> i.findAttribute("name"))
                                                                                 .map(Attribute::getValue)
                                                                                 .map(DataReference.class::cast)
                                                                                 .map(DataReference::getDefinition)
                                                                           )
                                                                       .build();

        final Properties properties = new Properties(specification);
        array.getValues()
                .stream()
                .map(Instance.class::cast)
                .forEach(i -> {
                    final String name = ((DataReference)i.findAttribute("name").getValue()).getDefinition().getName();
                    final Object value = ((LiteralValue)i.findAttribute("val").getValue()).getLiteral().getValue();

                    properties.put(specification.indexOf(name), value);
                });

        return properties;
    }
}
