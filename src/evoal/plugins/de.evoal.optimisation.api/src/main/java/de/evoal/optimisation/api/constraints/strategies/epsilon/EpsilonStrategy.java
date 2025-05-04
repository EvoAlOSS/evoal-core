package de.evoal.optimisation.main.constraints.constraint.strategies.constraint;

import de.evoal.optimisation.api.constraints.strategies.RepairStrategy;
import de.evoal.core.api.properties.Properties;
import de.evoal.optimisation.main.initial.RandomInitialCandidates;
import de.evoal.optimisation.main.fitness.JeneticsFitnessFunction;
import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.core.api.properties.PropertiesSpecification;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.epsilon-handler")
public class EpsilonStrategy implements RepairStrategy {

    @Inject
    private RandomInitialCandidates generator;

    @Inject
    private AttributeEvaluator attributeEvaluator;

    @Inject
    @Named("optimisation-space-specification")
    private PropertiesSpecification optimisationSpec;

    double[] bounds;

    int[] indices;

    @Inject
    private JeneticsFitnessFunction fitnessFunction;

    @Override
    public Properties apply(final Properties individual, long generation) {
        Properties p = individual;
        boolean boundsSatisfied = false;

        while (!boundsSatisfied) {
            p = generator.create().findFirst().get();
            OptimisationValue fitness = fitnessFunction.apply(p);
            Object[] fitnessValues = fitness.toStatistics();

            boundsSatisfied = true;
            for (int i = 0; i < bounds.length; i++) {
                if ((double) fitnessValues[this.indices[i]] >= bounds[i]) {
                    boundsSatisfied = false;
                }
            }
        }

        return p;
    }

    @Override
    public RepairStrategy init(Instance configuration) {
        this.bounds = attributeEvaluator.attributeToDoubleArray(configuration, "bounds");
        DataDescription[] epsilonData = attributeEvaluator.attributeToDataDescriptionArray(configuration, "objectives");
        int[] indices = new int[epsilonData.length];
        for (int i=0; i<epsilonData.length;i++) {
            int dataIndex = optimisationSpec.indexOf(epsilonData[i].getName());
            indices[i] = dataIndex;
        }
        this.indices = indices;
        return this;
    }
}