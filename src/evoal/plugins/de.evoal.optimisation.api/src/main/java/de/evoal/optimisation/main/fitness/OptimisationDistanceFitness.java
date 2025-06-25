package de.evoal.optimisation.main.fitness;

import de.evoal.core.api.board.Blackboard;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationFunctionDecorator;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.base.definitions.DataDescription;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Dependent
@Named("de.evoal.optimisation.core.optimisation-distance")
@Slf4j
public class OptimisationDistanceFitness extends OptimisationFunctionDecorator {

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

        Requirements.requireSameSize(current, target);

        final double[] result = new double[target.length];
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

        final List<Instance> target = helper.lookup(config, "target");

        if(target == null) {
            this.target = board.get(OptimisationBlackboardEntries.TARGET_PROPERTIES);
        } else {
            this.target = toProperties(target);
            log.info("Binding target properties based on information found in MLL to {}.", this.target);
            board.bind(OptimisationBlackboardEntries.TARGET_PROPERTIES, this.target);
        }

        return this;
    }

    private Properties toProperties(final List<Instance> array) {
        PropertiesSpecification specification = PropertiesSpecification.builder()
                .add(array.stream()
                        .map(i -> helper.<DataDescription>lookup(i, "var"))
                        .map(DataDescription.class::cast)
                )
                .build();

        final Properties properties = new Properties(specification);
        array
                .forEach(i -> {
                    final DataDescription dd = helper.<DataDescription>lookup(i, "var");
                    final Object val = helper.lookup(i, "val");
                    properties.put(specification.indexOf(dd.getName()), val);
                });

        return properties;
    }
}
