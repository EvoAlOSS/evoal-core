package de.evoal.core.main.constraints.constraint.ast;

import de.evoal.core.api.utils.Requirements;
import de.evoal.core.api.constraints.model.ConstraintType;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;

import de.evoal.core.main.constraints.constraint.utils.ArithmeticNumberOperations;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.DataReference;
import de.evoal.languages.model.ddl.SelfReference;
import de.evoal.languages.model.base.*;
import de.evoal.languages.model.base.util.BaseSwitch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class ConditionConverter extends BaseSwitch<Object> {
    private BiFunction<Properties, Properties, Object> function;
    private final List<PropertySpecification> usedProperties = new ArrayList<>();
    private final PropertiesSpecification genoSpec;
    private final PropertiesSpecification fitnessSpec;
    private final DataDescription context;
    private ConstraintType type;

    public ConditionConverter(final PropertiesSpecification genoSpec, final PropertiesSpecification fitnessSpec, final DataDescription context) {
        this.genoSpec = genoSpec;
        this.fitnessSpec = fitnessSpec;
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

        final BiFunction<Properties, Properties, Object> leftValue = (BiFunction<Properties, Properties, Object>) doSwitch(object.getLeftOperand());
        final BiFunction<Properties, Properties, Object> rightValue = (BiFunction<Properties, Properties, Object>) doSwitch(object.getComparison().get(0).getSubExpression());

        switch (object.getComparison().get(0).getOperator()) {
            case EQUAL:
            case GREATER_EQUAL:
            case GREATER_THAN: {
                function = (gen, fit) -> ArithmeticNumberOperations.minus(leftValue.apply(gen, fit), rightValue.apply(gen, fit));
                break;
            }
            case LESS_EQUAL:
            case LESS_THAN:
            {
                function = (gen, fit) -> ArithmeticNumberOperations.minus(rightValue.apply(gen, fit), leftValue.apply(gen, fit));
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
        BiFunction<Properties, Properties, Object> value = (BiFunction<Properties, Properties, Object>) doSwitch(object.getLeftOperand());

        for(int i = 0; i < object.getOperators().size(); ++i) {
            final AddOrSubtractOperator operator = object.getOperators().get(i);
            final BiFunction<Properties, Properties, Object> rOp = (BiFunction<Properties, Properties, Object>) doSwitch(object.getOperands().get(i));

            switch (operator) {
                case ADD: {
                    final BiFunction<Properties, Properties, Object> lOp = value;
                    value = (gen, fit) -> ArithmeticNumberOperations.add(lOp.apply(gen, fit), rOp.apply(gen, fit));
                    break;
                }

                case SUBTRACT: {
                    final BiFunction<Properties, Properties, Object> lOp = value;
                    value = (gen, fit) -> ArithmeticNumberOperations.minus(lOp.apply(gen, fit), rOp.apply(gen, fit));
                    break;
                }
            }
        }
        return value;
    }

    @Override
    public Object caseMultiplyDivideModuloExpression(MultiplyDivideModuloExpression object) {
        BiFunction<Properties, Properties, Object> value = (BiFunction<Properties, Properties, Object>) doSwitch(object.getLeftOperand());

        for(int i = 0; i < object.getOperators().size(); ++i) {
            final MultiplyDivideModuloOperator operator = object.getOperators().get(i);
            final BiFunction<Properties, Properties, Object> rOp = (BiFunction<Properties, Properties, Object>) doSwitch(object.getOperands().get(i));

            switch (operator) {
                case DIVIDE: {
                    final BiFunction<Properties, Properties, Object> lOp = value;
                    value = (gen, fit) -> ArithmeticNumberOperations.divide(lOp.apply(gen, fit), rOp.apply(gen, fit));
                    break;
                }

                case MODULO: {
                    final BiFunction<Properties, Properties, Object> lOp = value;
                    value = (gen, fit) -> ArithmeticNumberOperations.modulo(lOp.apply(gen, fit), rOp.apply(gen, fit));
                    break;
                }

                case MULTIPLY: {
                    final BiFunction<Properties, Properties, Object> lOp = value;
                    value = (gen, fit) -> ArithmeticNumberOperations.multiply(lOp.apply(gen, fit), rOp.apply(gen, fit));
                    break;
                }
            }
        }
        return value;
    }

    @Override
    public Object casePowerOfExpression(PowerOfExpression object) {
        BiFunction<Properties, Properties, Object> value = (BiFunction<Properties, Properties, Object>) doSwitch(object.getLeftOperand());

        if(object.getRightOperand() != null) {
            final BiFunction<Properties, Properties, Object> lOp = value;
            final BiFunction<Properties, Properties, Object> rOp = (BiFunction<Properties, Properties, Object>) doSwitch(object.getRightOperand());

            value = (gen, fit) -> ArithmeticNumberOperations.pow(lOp.apply(gen, fit), rOp.apply(gen, fit));
        }
        return value;
    }

    @Override
    public Object caseUnaryAddOrSubtractExpression(UnaryAddOrSubtractExpression object) {
        BiFunction<Properties, Properties, Object> value = (BiFunction<Properties, Properties, Object>) doSwitch(object.getSubExpression());

        for(final AddOrSubtractOperator operator : object.getOperators()) {
            switch (operator) {
                case ADD: {
                    value = value;
                    break;
                }

                case SUBTRACT: {
                    final BiFunction<Properties, Properties, Object> lOp = value;
                    value = (gen, fit) -> ArithmeticNumberOperations.minus(0, lOp.apply(gen, fit));
                    break;
                }
            }
        }
        return value;    }

    @Override
    public Object caseIntegerLiteral(final IntegerLiteral object) {
        return (BiFunction<Properties, Properties, Object>) (gen, fit) -> (double)object.getValue();
    }

    @Override
    public Object caseDoubleLiteral(final DoubleLiteral object) {
        return (BiFunction<Properties, Properties, Object>) (gen, fit) -> object.getValue();
    }

    @Override
    public Object caseStringLiteral(final StringLiteral object) {
        return (BiFunction<Properties, Properties, Object>) (gen, fit) -> Double.parseDouble(object.getValue());
    }

    @Override
    public Object caseValueReference(final ValueReference object) {
        if(object instanceof SelfReference) {
            Requirements.requireNotNull(context);
            final String propertyName = context.getName();
            if(fitnessSpec.contains(new PropertySpecification(context.getName(), context))) {
                final int propertyIndex = fitnessSpec.indexOf(propertyName);

                usedProperties.add(fitnessSpec.getProperties().get(propertyIndex));

                return (BiFunction<Properties, Properties, Object>) (gen, fit) -> fit.get(propertyIndex);

            } else {
                final int propertyIndex = genoSpec.indexOf(propertyName);

                usedProperties.add(genoSpec.getProperties().get(propertyIndex));

                return (BiFunction<Properties, Properties, Object>) (gen, fit) -> gen.get(propertyIndex);

            }
        }

        if(!(object instanceof final DataReference reference)) {
            throw new IllegalStateException("Value reference is not a data reference.");
        }

        final DataDescription description = reference.getDefinition();
        if(fitnessSpec.contains(new PropertySpecification(description.getName(), description))) {
            final String propertyName = description.getName();
            final int propertyIndex = fitnessSpec.indexOf(propertyName);

            usedProperties.add(fitnessSpec.getProperties().get(propertyIndex));

            return (BiFunction<Properties, Properties, Object>) (gen, fit) -> fit.get(propertyIndex);
        } else {
            final String propertyName = description.getName();
            final int propertyIndex = genoSpec.indexOf(propertyName);

            usedProperties.add(genoSpec.getProperties().get(propertyIndex));

            return (BiFunction<Properties, Properties, Object>) (gen, fit) -> gen.get(propertyIndex);

        }
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

    public BiFunction<Properties, Properties, Object> getFunction() {
        return function;
    }

    public List<PropertySpecification> getUsedProperties() {
        return Collections.unmodifiableList(usedProperties);
    }

    public ConstraintType getType() {
        return type;
    }
}
