package de.evoal.core.main.ea.constraints.constraint.strategies.constraint;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.ea.constraints.model.Constraint;
import de.evoal.core.api.ea.constraints.model.Constraints;
import de.evoal.core.api.ea.constraints.calculation.CalculationFactory;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.ea.fitness.FitnessFunction;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.main.ea.constraints.constraint.utils.ConfigurationUtils;
import de.evoal.languages.model.instance.*;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class JeneticsConstraintProducer {
    @Produces
    public List<io.jenetics.engine.Constraint> create(
            final @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.handlers") Array handlerConfigurations,
            final @Named("optimization-function-output") PropertiesSpecification optimizationSpec,
            final @Named("optimization-function")  FitnessFunction function,
            final CustomCodec codec,
            final Constraints constraints,
            final CalculationFactory factory) {

        // collect group information to handle
        final List<Instance> groups = ConfigurationUtils.findConstraintHandlerByHandlingStrategy(handlerConfigurations, "kill-at-birth");
        final Set<String> allGroups = groups.stream().map(i -> (String)((LiteralValue)i.findAttribute("category").getValue()).getLiteral().getValue()).collect(Collectors.toSet());
        final List<Constraint> listOfConstraints = constraints.getConstraints();

        return listOfConstraints
                    .stream()
                    .filter(c -> allGroups.contains(c.getGroup()))
                    .map(factory::create)
                    .map(s -> new JeneticsConstraintStrategy(s, codec, function, optimizationSpec, new RandomGenotypeStrategy()))
                    .collect(Collectors.toList());
    }
}
