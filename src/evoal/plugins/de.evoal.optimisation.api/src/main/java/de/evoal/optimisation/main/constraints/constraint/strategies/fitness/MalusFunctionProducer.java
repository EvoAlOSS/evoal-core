package de.evoal.optimisation.main.constraints.constraint.strategies.fitness;

import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.constraints.model.Constraint;
import de.evoal.optimisation.api.constraints.model.Constraints;
import de.evoal.optimisation.api.constraints.strategies.fitness.MalusForFitnessStrategy;
import de.evoal.optimisation.api.constraints.strategies.fitness.MalusFunction;
import de.evoal.core.api.properties.info.PropertiesDependencies;
import de.evoal.optimisation.api.constraints.calculation.CalculationFactory;
import de.evoal.optimisation.api.constraints.calculation.CalculationStrategy;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import de.evoal.optimisation.main.constraints.constraint.strategies.fitness.internal.MalusForFitnessFunction;
import de.evoal.optimisation.main.constraints.constraint.utils.ConfigurationUtils;
import de.evoal.languages.model.base.*;
import org.apache.commons.math3.util.Pair;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class MalusFunctionProducer {
    @Inject
    private Provider<AttributeHelper> helper;

    @Inject
    private ConfigurationUtils configUtil;

    @ApplicationScoped @Produces
    public MalusForFitnessStrategy create(
            final @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.handlers") List<Instance> handlers,
            final @Named("search-space-specification") PropertiesSpecification source,
            final @Named("optimisation-space-specification") PropertiesSpecification target,
            final @Named("output-dependencies") PropertiesDependencies dependencies,
            final Constraints constraints,
            final CalculationFactory factory) {
        // select constraint handlers that use malus-for-fitness
        final List<Instance> relevantHandlers = configUtil.findConstraintHandlerByHandlingStrategy(handlers, "malus-for-fitness");

        // collect group names of relevant handlers
        final Set<String> allGroups = relevantHandlers.stream()
                .map(i -> helper.get().<String>lookup(i, "category"))
                .collect(Collectors.toSet());

        // resulting strategies
        final MalusForFitnessStrategy resultingFunction = new MalusForFitnessStrategy(target.size());

        // collect all constraints for each index (of the appropriate groups)
        final List<List<Pair<Constraint, Instance>>> constraintsBySourceIndex = new ArrayList<>(source.size());
        for(int index = 0; index < source.size(); ++index) {
            constraintsBySourceIndex.add(new ArrayList<>());
        }

        final List<List<Pair<Constraint, Instance>>> constraintsByTargetIndex = new ArrayList<>(target.size());
        for(int index = 0; index < target.size(); ++index) {
            constraintsByTargetIndex.add(new ArrayList<>());
        }

        constraints.getConstraints()
                .stream()
                .filter(c -> allGroups.contains(c.getGroup()))
                .forEach(constraint -> {
                    for(final PropertySpecification ps : constraint.getUsedProperties()) {
                        if(source.equals(ps)) {
                            // handle source specification
                            final int index = source.indexOf(ps);
                            final Instance configuration = configUtil.findConstraintHandlerByHandlingStrategyAndCategory(handlers, "malus-for-fitness", constraint.getGroup());
                            constraintsBySourceIndex.get(index)
                                    .add(new Pair<>(constraint, configuration));
                        } else {
                            // handle target specification
                            final int index = target.indexOf(ps);
                            final Instance configuration = configUtil.findConstraintHandlerByHandlingStrategyAndCategory(handlers, "malus-for-fitness", constraint.getGroup());
                            constraintsByTargetIndex.get(index)
                                    .add(new Pair<>(constraint, configuration));
                        }
                    }
                });

        // build actual malus function for each output
        for(int index = 0; index < target.size(); ++index) {
            // keep track of already applied constraints
            final Set<Constraint> applied  = new HashSet<>();

            // iterate over input property specifications that influence the current output specification
            for(final PropertySpecification ips : dependencies.get(target.getProperties().get(index))) {
                final int ipsIndex = source.indexOf(ips);

                for(final Pair<Constraint, Instance> pair : constraintsBySourceIndex.get(ipsIndex)) {
                    final Constraint constraint = pair.getFirst();
                    final Instance configuration = pair.getSecond();

                    // prevent constraints from being applied multiple times per fitness value
                    if(applied.contains(constraint)) {
                        continue;
                    }
                    applied.add(constraint);

                    final CalculationStrategy calculation = factory.create(constraint);

                    final String handlerName = helper.get().lookup(configuration, "name");

                    final MalusFunction strategy = new MalusForFitnessFunction(helper.get(), constraint, helper.get().lookup(configuration, "constraint-handling"), index) ;
                    resultingFunction.add(index, strategy);
               }
            }

            // iterate over target constraints
            for(final Pair<Constraint, Instance> pair : constraintsByTargetIndex.get(index)) {
                final Constraint constraint = pair.getFirst();
                final Instance configuration = pair.getSecond();

                // prevent constraints from being applied multiple times per fitness value
                if(applied.contains(constraint)) {
                    continue;
                }
                applied.add(constraint);

                final CalculationStrategy calculation = factory.create(constraint);

                final String handlerName = helper.get().lookup(configuration, "name");

                final MalusFunction strategy = new MalusForFitnessFunction(helper.get(), constraint, helper.get().lookup(configuration, "constraint-handling"), index) ;
                resultingFunction.add(index, strategy);
            }
        }

        return resultingFunction;
    }
}
