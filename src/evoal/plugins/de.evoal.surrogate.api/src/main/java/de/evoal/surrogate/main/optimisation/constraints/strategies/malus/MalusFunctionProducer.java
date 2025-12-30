package de.evoal.surrogate.main.optimisation.constraints.strategies.malus;

import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.properties.info.PropertiesDependencies;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.constraints.model.Constraint;
import de.evoal.optimisation.api.constraints.model.Constraints;
import de.evoal.surrogate.api.ea.constraints.strategies.malus.MalusForFitnessStrategy;
import de.evoal.surrogate.api.ea.constraints.strategies.malus.MalusFunction;
import de.evoal.optimisation.api.constraints.calculation.CalculationFactory;
import de.evoal.optimisation.api.constraints.calculation.CalculationStrategy;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import de.evoal.surrogate.api.cdi.DependenciesProducer;
import de.evoal.surrogate.main.optimisation.constraints.strategies.malus.internal.MalusForFitnessFunction;
import de.evoal.optimisation.main.constraints.constraint.utils.ConfigurationUtils;
import jakarta.inject.Provider;
import org.apache.commons.math3.util.Pair;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class MalusFunctionProducer {
    @Inject
    private Provider<AttributeHelper> helper;

    @Inject
    private ConfigurationUtils configUtil;

    @Inject
    private DependenciesProducer producer;

    @ApplicationScoped @Produces
    public MalusForFitnessStrategy create(
            final @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.handlers") List<Instance> handlers,
            final @Named("search-space-specification") PropertiesSpecification source,
            final @Named("optimisation-space-specification") PropertiesSpecification target,
            final Constraints constraints,
            final CalculationFactory factory) {
        // select constraint handlers that use malus-for-malus
        final List<Instance> relevantHandlers = configUtil.findConstraintHandlerByHandlingStrategy(handlers, "malus-for-malus");

        final PropertiesDependencies dependencies = null; //producer.calculatePropertyDependencies(null);

        // collect group names of relevant handlers
        final Set<String> allGroups = relevantHandlers.stream()
                .map(i -> helper.get().<String>lookup(i, "category"))
                .collect(Collectors.toSet());

        // resulting constraints
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
                            final Instance configuration = configUtil.findConstraintHandlerByHandlingStrategyAndCategory(handlers, "malus-for-malus", constraint.getGroup());
                            constraintsBySourceIndex.get(index)
                                    .add(new Pair<>(constraint, configuration));
                        } else {
                            // handle target specification
                            final int index = target.indexOf(ps);
                            final Instance configuration = configUtil.findConstraintHandlerByHandlingStrategyAndCategory(handlers, "malus-for-malus", constraint.getGroup());
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

                    // prevent constraints from being applied multiple times per malus value
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

                // prevent constraints from being applied multiple times per malus value
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
