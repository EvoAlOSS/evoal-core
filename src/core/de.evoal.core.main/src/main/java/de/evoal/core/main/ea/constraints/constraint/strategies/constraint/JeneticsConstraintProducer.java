package de.evoal.core.main.ea.constraints.constraint.strategies.constraint;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.ea.constraints.calculation.CalculationStrategy;
import de.evoal.core.api.ea.constraints.model.Constraint;
import de.evoal.core.api.ea.constraints.model.Constraints;
import de.evoal.core.api.ea.constraints.calculation.CalculationFactory;
import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.ea.constraints.strategies.RepairStrategy;
import de.evoal.core.api.ea.fitness.FitnessFunction;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.core.main.ea.constraints.constraint.utils.ConfigurationUtils;
import de.evoal.languages.model.instance.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@ApplicationScoped
public class JeneticsConstraintProducer {
    @Produces
    public List<io.jenetics.engine.Constraint> create(
            final @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.handlers") Array handlerConfigurations,
            final @Named("optimization-function-output") PropertiesSpecification optimizationSpec,
            final @Named("optimization-function")  FitnessFunction function,
            final CustomCodec codec,
            final Constraints constraints,
            final CalculationFactory factory) {

        // collect group information to handle
        final List<Instance> groups = ConfigurationUtils.findConstraintHandlerByHandlingStrategy(handlerConfigurations, "kill-at-birth");
        final Map<String, Instance> configurationMap = groups.stream().collect(Collectors.toMap(i -> (String)((LiteralValue)i.findAttribute("category").getValue()).getLiteral().getValue(), Function.identity()));
        final List<Constraint> listOfConstraints = constraints.getConstraints();


        return listOfConstraints
                    .stream()
                    .filter(c -> configurationMap.keySet().contains(c.getGroup()))
                    .map(s -> {
                        final Instance handlerConfiguration = configurationMap.get(s.getGroup());
                        final Instance repairConfiguration = LanguageHelper.lookup(handlerConfiguration, "constraint-handling.repair-strategy");

                        final CalculationStrategy cStrategy = factory.create(s);
                        final RepairStrategy rStrategy = BeanFactory.create(repairConfiguration.getDefinition().getName(), RepairStrategy.class)
                                                                    .init(repairConfiguration);

                        return new JeneticsConstraintStrategy(cStrategy, codec, function, optimizationSpec, rStrategy);
                    })
                    .collect(Collectors.toList());
    }
}
