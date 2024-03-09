package de.evoal.core.ea.main.fitness;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.optimisation.OptimisationFunction;
import de.evoal.core.api.optimisation.OptimisationFunctionDecorator;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.*;
import de.evoal.languages.model.ddl.DataDescription;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;

@Dependent
@Named("optimisation-distance")
@Slf4j
public class DistanceFitness extends OptimisationFunctionDecorator {

    @Inject
    private Blackboard board;

    /**
     * The target to search for.
     */
    private Properties target;

    @Inject
    private ExpressionEvaluator evaluator;

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

        final Object[] target = helper.lookup(config, "target");
        final Instance[] asInstance = new Instance[target.length];
        System.arraycopy(target, 0, asInstance, 0, target.length);

        if(target == null) {
            this.target = board.get(CoreBlackboardEntries.TARGET_PROPERTIES);
        } else {
            this.target = toProperties(asInstance);
            log.info("Binding target properties based on information found in MLL to {}.", this.target);
            board.bind(CoreBlackboardEntries.TARGET_PROPERTIES, this.target);
        }

        return this;
    }

    private Properties toProperties(final Instance [] array) {
        PropertiesSpecification specification = PropertiesSpecification.builder()
                                                                       .add(Arrays.stream(array)
                                                                                 .map(i -> helper.lookup(i, "name"))
                                                                                 .map(evaluator::evaluate)
                                                                                 .map(DataDescription.class::cast)
                                                                           )
                                                                       .build();

        final Properties properties = new Properties(specification);
        Arrays.stream(array)
                .forEach(i -> {
                    final Object obj = helper.lookup(i, "name");
                    final DataDescription dd = (DataDescription) evaluator.evaluate(obj);
                    final Object val = helper.lookup(i, "val");

                    properties.put(specification.indexOf(dd.getName()), val);
                });

        return properties;
    }
}
