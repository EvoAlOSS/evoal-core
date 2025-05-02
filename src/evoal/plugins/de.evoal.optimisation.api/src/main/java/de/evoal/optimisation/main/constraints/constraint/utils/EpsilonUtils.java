package de.evoal.optimisation.main.constraints.constraint.utils;

import de.evoal.core.api.utils.ArithmeticOperations;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.optimisation.api.constraints.model.Constraint;
import de.evoal.optimisation.api.constraints.model.ConstraintType;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.function.BiFunction;

@ApplicationScoped
public class EpsilonUtils {

    public Constraint convert(final PropertySpecification data, final int index, final double bound) {
        final Constraint result = new Constraint();
        result.setGroup("epsilon");
        List<PropertySpecification> usedProperties = new ArrayList<>();
        usedProperties.add(data);
        BiFunction<Properties, Properties, Object> function = (genSpec, optSpec) -> ArithmeticOperations.minus(bound, optSpec.get(index));
        result.setFunction(function);
        result.setUsedProperties(usedProperties);
        result.setConstraintType(ConstraintType.Inequality);
        return result;
    }
}