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

import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class JeneticsConstraintProducer {
    @Produces
    public List<io.jenetics.engine.Constraint> create(
            final @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.handlers") Array handlerConfigurations,
            final @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.fitness") Instance fitnessConfiguration,
            final Constraints constraints,
            final CustomCodec codec,
            final CalculationFactory factory) {
        // collect group information to handle
        final List<Instance> groups = ConfigurationUtils.findConstraintHandlerByHandlingStrategy(handlerConfigurations, "kill-at-birth");
        final Set<String> allGroups = groups.stream().map(i -> (String)((LiteralValue)i.findAttribute("category").getValue()).getLiteral().getValue()).collect(Collectors.toSet());
        final List<Constraint> listOfConstraints = constraints.getConstraints();

        final FitnessFunction function = create(fitnessConfiguration);
        final PropertiesSpecification fitnessSpec = toSpecification(fitnessConfiguration);

        final List<io.jenetics.engine.Constraint> result = listOfConstraints
                    .stream()
                    .filter(c -> allGroups.contains(c.getGroup()))
                    .map(factory::create)
                    .map(s -> new JeneticsConstraintStrategy(s, codec, function, fitnessSpec, new RandomGenotypeStrategy()))
                    .collect(Collectors.toList());

        return result;
    }

    private PropertiesSpecification toSpecification(final Instance fitnessConfiguration) {
        return PropertiesSpecification.builder()
                .add(((Array)findInner(fitnessConfiguration).findAttribute("maps-to").getValue())
                        .getValues()
                        .stream()
                        .map(DataReference.class::cast)
                        .map(DataReference::getDefinition)
                )
                .build();
    }

    private FitnessFunction create(Instance fitnessConfig) {
        fitnessConfig = findInner(fitnessConfig);

        final String fitnessName = fitnessConfig.getName().getName();

        return BeanProvider.getContextualReference(fitnessName, false, FitnessFunction.class)
                .init(fitnessConfig);
    }

    private Instance findInner(final Instance fitnessConfig) {
        final Attribute subFunction = fitnessConfig.findAttribute("function");

        if(subFunction != null) {
            return findInner((Instance)subFunction.getValue());
        }

        return fitnessConfig;
    }
}
