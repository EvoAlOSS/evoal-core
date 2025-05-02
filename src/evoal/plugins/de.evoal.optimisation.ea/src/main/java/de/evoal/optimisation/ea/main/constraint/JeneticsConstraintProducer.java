package de.evoal.optimisation.ea.main.constraint;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.constraints.calculation.CalculationFactory;
import de.evoal.optimisation.api.constraints.calculation.CalculationStrategy;
import de.evoal.optimisation.api.constraints.model.Constraint;
import de.evoal.optimisation.api.constraints.model.Constraints;
import de.evoal.optimisation.api.constraints.strategies.RepairStrategy;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.optimisation.ea.api.codec.CustomCodec;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.optimisation.main.constraints.constraint.utils.ConfigurationUtils;
import de.evoal.optimisation.main.constraints.constraint.strategies.constraint.EpsilonStrategy;
import de.evoal.optimisation.main.constraints.constraint.strategies.calculations.NormalCalculation;
import de.evoal.languages.model.base.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Optional;

@ApplicationScoped
public class JeneticsConstraintProducer {
    @Inject
    private AttributeHelper helper;

    @Inject
    private ConfigurationUtils configUtil;

    @Produces
    public List<io.jenetics.engine.Constraint> create(
            final @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.handlers") List<Instance> handlerConfigurations,
            final @Named("optimisation-space-specification") PropertiesSpecification optimisationSpec,
            final @Named("optimisation-function") OptimisationFunction function,
            final @Named("codec") CustomCodec codec,
            final Constraints constraints,
            final CalculationFactory factory) {

        // collect group information to handle
        final List<Instance> groups = configUtil.findConstraintHandlerByHandlingStrategy(handlerConfigurations, "kill-at-birth");

        Optional<Instance> epsilonHandler = configUtil.findEpsilonHandler(handlerConfigurations);
        epsilonHandler.ifPresent(handler -> {
            groups.add(handler);
        });

        final Map<String, Instance> configurationMap = groups.stream()
                                                             .collect(Collectors.toMap(i -> (String)(helper.lookup(i, "category")), Function.identity()));

        final List<Constraint> listOfConstraints = constraints.getConstraints();

        List<io.jenetics.engine.Constraint> jConstraints = new ArrayList<>();
        jConstraints.addAll(listOfConstraints
                    .stream()
                    .filter(c -> configurationMap.containsKey(c.getGroup()))
                    .map(s -> {
                        final Instance handlerConfiguration = configurationMap.get(s.getGroup());
                        final Instance repairConfiguration = (s.getGroup().equals("epsilon")) ? handlerConfiguration
                                : helper.lookup(handlerConfiguration, "constraint-handling.repair-strategy");

                        final CalculationStrategy cStrategy = factory.create(s);
                        final RepairStrategy rStrategy = BeanFactory.createComponent(RepairStrategy.class, repairConfiguration);

                        return new JeneticsConstraintStrategy(cStrategy, codec, function, optimisationSpec, rStrategy);
                    })
                    .collect(Collectors.toList()));
        return jConstraints;
    }
}
