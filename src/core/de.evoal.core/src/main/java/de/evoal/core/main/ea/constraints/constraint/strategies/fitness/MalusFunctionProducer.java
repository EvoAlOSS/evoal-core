package de.evoal.core.main.ea.constraints.constraint.strategies.fitness;

import de.evoal.core.api.ea.constraints.model.Constraint;
import de.evoal.core.api.ea.constraints.model.Constraints;
import de.evoal.core.api.ea.constraints.strategies.fitness.MalusForFitnessStrategy;
import de.evoal.core.api.ea.constraints.strategies.fitness.MalusFunction;
import de.evoal.core.api.properties.info.PropertiesDependencies;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.core.api.ea.constraints.calculation.CalculationFactory;
import de.evoal.core.api.ea.constraints.calculation.CalculationStrategy;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import de.evoal.core.main.ea.constraints.constraint.strategies.fitness.internal.MalusForFitnessFunction;
import de.evoal.core.main.ea.constraints.constraint.utils.ConfigurationUtils;
import de.evoal.languages.model.instance.Attribute;
import de.evoal.languages.model.instance.Instance;
import de.evoal.languages.model.instance.Misc;
import org.apache.commons.math3.util.Pair;

import javax.inject.Named;
import java.util.*;

@ApplicationScoped
public class MalusFunctionProducer {
    @ApplicationScoped @Produces
    public MalusForFitnessStrategy create(
            final @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.constraint_handling") Instance handlerConfiguration,
            final Constraints constraints,
            final @Named("genotype-specification") PropertiesSpecification source,
            final @Named("output-dependencies") PropertiesDependencies dependencies,
            final @Named("surrogate-target-properties-specification") PropertiesSpecification target, // FIXME I don't think that this is correct here since we may not have a surrogate function at hand. But we have to define this usecase in order to be able to fix this issue.
            final CalculationFactory factory) {
        final MalusForFitnessStrategy resultingFunction = new MalusForFitnessStrategy(target.size());

        // collect group information to handle
        final List<Attribute> groups = ConfigurationUtils.findByHandlerName(handlerConfiguration, "malusForFitness");

        // collect all constraints for each index (of the appropriate groups)
        final List<List<Pair<Constraint, Attribute>>> constraintsForIndex = new ArrayList<>(source.size());
        for(int index = 0; index < source.size(); ++index) {
            constraintsForIndex.add(new ArrayList<>());
        }

        for(final Constraint constraint : constraints.getConstraints()) {
            final String group = constraint.getGroup();

            for(final Attribute info : groups) {
                if(((Misc)info.getName()).getName().equals(group)) {
                    for(final PropertySpecification ps : constraint.getUsedProperties()) {
                        final int index = source.indexOf(ps);
                        constraintsForIndex.get(index).add(new Pair<>(constraint, info));
                    }
                }
            }
        }

        // build MalusFunctionParts
        for(int index = 0; index < target.size(); ++index) {
            final Set<Constraint> applied  = new HashSet<>();

            for(final PropertySpecification ips : dependencies.get(target.getProperties().get(index))) {
                final int ipsIndex = source.indexOf(ips);

                for(final Pair<Constraint, Attribute> pair : constraintsForIndex.get(ipsIndex)) {
                    final Constraint constraint = pair.getFirst();
                    final Attribute configuration = pair.getSecond();

                    // prevent constraints from being applied multiple times per fitness value
                    if(applied.contains(constraint)) {
                        continue;
                    }
                    applied.add(constraint);

                    final CalculationStrategy calculation = factory.create(constraint);

                    final String handlerName = LanguageHelper.lookup((Instance) configuration.getValue(), "name");

                    final MalusFunction strategy = new MalusForFitnessFunction(constraint, LanguageHelper.lookup((Instance)configuration.getValue(), "handling"), index) ;
                    resultingFunction.add(index, strategy);
               }
            }
        }

        return resultingFunction;
    }
}
