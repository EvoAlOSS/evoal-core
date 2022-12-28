package de.evoal.core.main.ea.constraints.constraint.strategies.constraint;

import de.evoal.core.api.ea.constraints.model.Constraint;
import de.evoal.core.api.ea.constraints.model.Constraints;
import de.evoal.core.api.ea.constraints.calculation.CalculationFactory;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.main.ea.constraints.constraint.utils.ConfigurationUtils;
import de.evoal.languages.model.instance.Attribute;
import de.evoal.languages.model.instance.Instance;
import de.evoal.languages.model.instance.Misc;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class JeneticsConstraintProducer {
    @Produces
    public List<io.jenetics.engine.Constraint> create(
            final @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.constraint_handling") Instance handlerConfiguration,
            final Constraints constraints,
            final CustomCodec codec,
            final CalculationFactory factory) {
        // collect group information to handle
        final List<Attribute> groups = ConfigurationUtils.findByHandlerName(handlerConfiguration, "killAtBirth");
        final Set<String> allGroups = groups.stream().map(e -> ((Misc)e.getName()).getName()).collect(Collectors.toSet());
        final List<Constraint> listOfConstraints = constraints.getConstraints();

        final List<io.jenetics.engine.Constraint> result = listOfConstraints
                    .stream()
                    .filter(c -> allGroups.contains(c.getGroup()))
                    .map(factory::create)
                    .map(s -> new JeneticsConstraintStrategy(s, codec, new RandomGenotypeStrategy()))
                    .collect(Collectors.toList());

        return result;
    }
}
