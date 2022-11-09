package de.evoal.core.main.ddl.constraint.ast;

import de.evoal.core.api.utils.Requirements;
import de.evoal.core.api.ea.constraints.model.ConstraintType;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.languages.model.eal.DataReference;
import de.evoal.languages.model.el.*;
import de.evoal.languages.model.el.util.ELSwitch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class ConditionConverter extends ELSwitch<Object> {
    private Function<Properties, Double> function;
    private final List<PropertySpecification> usedProperties = new ArrayList<>();
    private final PropertiesSpecification specification;
    private ConstraintType type;

    public ConditionConverter(final PropertiesSpecification specification) {
        this.specification = specification;
    }

    @Override
    public Object caseOrExpression(OrExpression object) {
        Requirements.requireSize(object.getSubExpressions(), 1);

        doSwitch(object.getSubExpressions().get(0));

        return null;
    }

    @Override
    public Object caseXorExpression(XorExpression object) {
        Requirements.requireSize(object.getSubExpressions(), 1);

        doSwitch(object.getSubExpressions().get(0));

        return null;
    }

    @Override
    public Object caseAndExpression(AndExpression object) {
        Requirements.requireSize(object.getSubExpressions(), 1);

        doSwitch(object.getSubExpressions().get(0));

        return null;
    }

    @Override
    public Object caseNotExpression(NotExpression object) {
        Requirements.requireFalse(object.isNegated());

        doSwitch(object.getOperand());

        return null;
    }

    @Override
    public Object caseComparisonExpression(ComparisonExpression object) {
        Requirements.requireSize(object.getComparison(), 1);

        final Function<Properties, Double> leftValue = (Function<Properties, Double>) doSwitch(object.getLeftOperand());
        final Function<Properties, Double> rightValue = (Function<Properties, Double>) doSwitch(object.getComparison().get(0).getSubExpression());

        switch (object.getComparison().get(0).getOperator()) {
            case EQUAL:
            case GREATER_EQUAL:
            case GREATER_THAN: {
                function = properties -> leftValue.apply(properties) - rightValue.apply(properties);
                break;
            }
            case LESS_EQUAL:
            case LESS_THAN:
            {
                function = properties -> rightValue.apply(properties) - leftValue.apply(properties);
                break;
            }
            case UNEQUAL: {
                throw new IllegalArgumentException("Unequal is not allowed");
            }
        }

        switch (object.getComparison().get(0).getOperator()) {
            case EQUAL:
                type = ConstraintType.Equality;
                break;

            case GREATER_EQUAL:
            case GREATER_THAN:
            case LESS_EQUAL:
            case LESS_THAN:
                type = ConstraintType.Inequality;
                break;

            case UNEQUAL: {
                throw new IllegalArgumentException("Unequal is not allowed");
            }
        }

        return null;
    }

    @Override
    public Object caseAddOrSubtractExpression(final AddOrSubtractExpression object) {
        Function<Properties, Double> value = (Function<Properties, Double>) doSwitch(object.getLeftOperand());

        for(int i = 0; i < object.getOperators().size(); ++i) {
            final AddOrSubtractOperator operator = object.getOperators().get(i);
            final Function<Properties, Double> rOp = (Function<Properties, Double>) doSwitch(object.getOperands().get(i));

            switch (operator) {
                case ADD: {
                    final Function<Properties, Double> lOp = value;
                    value = properties -> lOp.apply(properties) + rOp.apply(properties);
                    break;
                }

                case SUBTRACT: {
                    final Function<Properties, Double> lOp = value;
                    value = properties -> lOp.apply(properties) - rOp.apply(properties);
                    break;
                }
            }
        }
        return value;
    }

    @Override
    public Object caseMultiplyDivideModuloExpression(MultiplyDivideModuloExpression object) {
        Function<Properties, Double> value = (Function<Properties, Double>) doSwitch(object.getLeftOperand());

        for(int i = 0; i < object.getOperators().size(); ++i) {
            final MultiplyDivideModuloOperator operator = object.getOperators().get(i);
            final Function<Properties, Double> rOp = (Function<Properties, Double>) doSwitch(object.getOperands().get(i));

            switch (operator) {
                case DIVIDE: {
                    final Function<Properties, Double> lOp = value;
                    value = properties -> lOp.apply(properties) / rOp.apply(properties);
                    break;
                }

                case MODULO: {
                    final Function<Properties, Double> lOp = value;
                    value = properties -> lOp.apply(properties) % rOp.apply(properties);
                    break;
                }

                case MULTIPLY: {
                    final Function<Properties, Double> lOp = value;
                    value = properties -> lOp.apply(properties) * rOp.apply(properties);
                    break;
                }
            }
        }
        return value;
    }

    @Override
    public Object casePowerOfExpression(PowerOfExpression object) {
        Function<Properties, Double> value = (Function<Properties, Double>) doSwitch(object.getLeftOperand());

        if(object.getRightOperand() != null) {
            final Function<Properties, Double> lOp = value;
            final Function<Properties, Double> rOp = (Function<Properties, Double>) doSwitch(object.getRightOperand());

            value = properties -> Math.pow(lOp.apply(properties), rOp.apply(properties));
        }
        return value;
    }

    @Override
    public Object caseUnaryAddOrSubtractExpression(UnaryAddOrSubtractExpression object) {
        Function<Properties, Double> value = (Function<Properties, Double>) doSwitch(object.getSubExpression());

        for(final AddOrSubtractOperator operator : object.getOperators()) {
            switch (operator) {
                case ADD: {
                    value = value;
                    break;
                }

                case SUBTRACT: {
                    final Function<Properties, Double> lOp = value;
                    value = properties -> -lOp.apply(properties);
                    break;
                }
            }
        }
        return value;    }

    @Override
    public Object caseIntegerLiteral(final IntegerLiteral object) {
        return (Function<Properties, Double>) properties -> (double)object.getValue();
    }

    @Override
    public Object caseDoubleLiteral(final DoubleLiteral object) {
        return (Function<Properties, Double>) properties -> object.getValue();
    }

    @Override
    public Object caseStringLiteral(final StringLiteral object) {
        return (Function<Properties, Double>) properties -> Double.parseDouble(object.getValue());
    }

    @Override
    public Object caseValueReference(final ValueReference object) {
        if(!(object instanceof DataReference)) {
            throw new IllegalStateException("Value reference is not a data reference.");
        }

        final DataReference reference = (DataReference)object;
        final String propertyName = reference.getDefinition().getName();
        final int propertyIndex = specification.indexOf(new PropertySpecification(propertyName));

        usedProperties.add(specification.getProperties().get(propertyIndex));

        return (Function<Properties, Double>) properties -> properties.get(propertyIndex);
    }

    @Override
    public Object caseBooleanLiteral(final BooleanLiteral object) {
        throw new IllegalArgumentException("Boolean values are not supported");
    }

    @Override
    public Object caseCall(Call object) {
        throw new IllegalArgumentException("Calls are not supported");
    }

    @Override
    public Object caseParantheses(final Parantheses object) {
        return doSwitch(object.getSubExpression());
    }

    public Function<Properties, Double> getFunction() {
        return function;
    }

    public List<PropertySpecification> getUsedProperties() {
        return Collections.unmodifiableList(usedProperties);
    }

    public ConstraintType getType() {
        return type;
    }
}
