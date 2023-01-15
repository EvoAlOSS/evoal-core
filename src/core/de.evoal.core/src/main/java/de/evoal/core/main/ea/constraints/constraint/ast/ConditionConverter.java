package de.evoal.core.main.ea.constraints.constraint.ast;

import de.evoal.core.api.utils.Requirements;
import de.evoal.core.api.ea.constraints.model.ConstraintType;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import static de.evoal.core.main.ea.constraints.constraint.utils.ArithmeticNumberOperations.*;

import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.DataReference;
import de.evoal.languages.model.ddl.SelfReference;
import de.evoal.languages.model.el.*;
import de.evoal.languages.model.el.util.ELSwitch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class ConditionConverter extends ELSwitch<Object> {
    private Function<Properties, Object> function;
    private final List<PropertySpecification> usedProperties = new ArrayList<>();
    private final PropertiesSpecification specification;
    private final DataDescription context;
    private ConstraintType type;

    public ConditionConverter(final PropertiesSpecification specification, final DataDescription context) {
        this.specification = specification;
        this.context = context;
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

        final Function<Properties, Object> leftValue = (Function<Properties, Object>) doSwitch(object.getLeftOperand());
        final Function<Properties, Object> rightValue = (Function<Properties, Object>) doSwitch(object.getComparison().get(0).getSubExpression());

        switch (object.getComparison().get(0).getOperator()) {
            case EQUAL:
            case GREATER_EQUAL:
            case GREATER_THAN: {
                function = properties -> minus(leftValue.apply(properties), rightValue.apply(properties));
                break;
            }
            case LESS_EQUAL:
            case LESS_THAN:
            {
                function = properties -> minus(rightValue.apply(properties), leftValue.apply(properties));
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
        Function<Properties, Object> value = (Function<Properties, Object>) doSwitch(object.getLeftOperand());

        for(int i = 0; i < object.getOperators().size(); ++i) {
            final AddOrSubtractOperator operator = object.getOperators().get(i);
            final Function<Properties, Object> rOp = (Function<Properties, Object>) doSwitch(object.getOperands().get(i));

            switch (operator) {
                case ADD: {
                    final Function<Properties, Object> lOp = value;
                    value = properties -> add(lOp.apply(properties), rOp.apply(properties));
                    break;
                }

                case SUBTRACT: {
                    final Function<Properties, Object> lOp = value;
                    value = properties -> minus(lOp.apply(properties), rOp.apply(properties));
                    break;
                }
            }
        }
        return value;
    }

    @Override
    public Object caseMultiplyDivideModuloExpression(MultiplyDivideModuloExpression object) {
        Function<Properties, Object> value = (Function<Properties, Object>) doSwitch(object.getLeftOperand());

        for(int i = 0; i < object.getOperators().size(); ++i) {
            final MultiplyDivideModuloOperator operator = object.getOperators().get(i);
            final Function<Properties, Object> rOp = (Function<Properties, Object>) doSwitch(object.getOperands().get(i));

            switch (operator) {
                case DIVIDE: {
                    final Function<Properties, Object> lOp = value;
                    value = properties -> divide(lOp.apply(properties), rOp.apply(properties));
                    break;
                }

                case MODULO: {
                    final Function<Properties, Object> lOp = value;
                    value = properties -> modulo(lOp.apply(properties), rOp.apply(properties));
                    break;
                }

                case MULTIPLY: {
                    final Function<Properties, Object> lOp = value;
                    value = properties -> multiply(lOp.apply(properties), rOp.apply(properties));
                    break;
                }
            }
        }
        return value;
    }

    @Override
    public Object casePowerOfExpression(PowerOfExpression object) {
        Function<Properties, Object> value = (Function<Properties, Object>) doSwitch(object.getLeftOperand());

        if(object.getRightOperand() != null) {
            final Function<Properties, Object> lOp = value;
            final Function<Properties, Object> rOp = (Function<Properties, Object>) doSwitch(object.getRightOperand());

            value = properties -> pow(lOp.apply(properties), rOp.apply(properties));
        }
        return value;
    }

    @Override
    public Object caseUnaryAddOrSubtractExpression(UnaryAddOrSubtractExpression object) {
        Function<Properties, Object> value = (Function<Properties, Object>) doSwitch(object.getSubExpression());

        for(final AddOrSubtractOperator operator : object.getOperators()) {
            switch (operator) {
                case ADD: {
                    value = value;
                    break;
                }

                case SUBTRACT: {
                    final Function<Properties, Object> lOp = value;
                    value = properties -> minus(0, lOp.apply(properties));
                    break;
                }
            }
        }
        return value;    }

    @Override
    public Object caseIntegerLiteral(final IntegerLiteral object) {
        return (Function<Properties, Object>) properties -> (double)object.getValue();
    }

    @Override
    public Object caseDoubleLiteral(final DoubleLiteral object) {
        return (Function<Properties, Object>) properties -> object.getValue();
    }

    @Override
    public Object caseStringLiteral(final StringLiteral object) {
        return (Function<Properties, Object>) properties -> Double.parseDouble(object.getValue());
    }

    @Override
    public Object caseValueReference(final ValueReference object) {
        if(object instanceof SelfReference) {
            Requirements.requireNotNull(context);
            final String propertyName = context.getName();
            final int propertyIndex = specification.indexOf(propertyName);

            usedProperties.add(specification.getProperties().get(propertyIndex));

            return (Function<Properties, Object>) properties -> properties.get(propertyIndex);
        }

        if(!(object instanceof DataReference)) {
            throw new IllegalStateException("Value reference is not a data reference.");
        }

        final DataReference reference = (DataReference)object;
        final String propertyName = reference.getDefinition().getName();
        final int propertyIndex = specification.indexOf(propertyName);

        usedProperties.add(specification.getProperties().get(propertyIndex));

        return (Function<Properties, Object>) properties -> properties.get(propertyIndex);
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

    public Function<Properties, Object> getFunction() {
        return function;
    }

    public List<PropertySpecification> getUsedProperties() {
        return Collections.unmodifiableList(usedProperties);
    }

    public ConstraintType getType() {
        return type;
    }
}
