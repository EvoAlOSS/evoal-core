package de.evoal.core.main.ea.fitness;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.ea.fitness.FitnessFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Attribute;
import de.evoal.languages.model.instance.Instance;
import org.apache.commons.math3.util.Pair;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.stream.Stream;

@Dependent
@Named("distance")
public class DistanceFitness extends FitnessDecorator {

    @Inject
    private Blackboard board;

    /**
     * The target to search for.
     */
    private Properties target;

    @Override
    public double[] evaluate(final Properties properties) {
        final double [] target = this.target.getValues();
        final double [] current = decoratedFunction.evaluate(properties);

        Requirements.requireSameSize(current, target);


        final double result[] = new double[target.length];
        for(int i = 0; i  < target.length; ++i) {
            result[i] = target[i] - current[i];
        }

        return result;
    }

    @Override
    public FitnessFunction init(final Instance config) {
        super.init(config);

        final Attribute target = config.findAttribute("target");

        if(target == null) {
            this.target = board.get(BlackboardEntry.TARGET_PROPERTIES);
        } else {
            this.target = toProperties((Array)target.getValue());
        }

        return this;
    }

    private static Properties toProperties(final Array value) {

        return null;
    }
}
