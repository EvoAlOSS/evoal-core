package de.evoal.core.main.ea.constraints.constraint.ast;

import de.evoal.core.api.ea.constraints.model.DataConstraints;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.DataReference;
import de.evoal.languages.model.ddl.RepresentationType;
import de.evoal.languages.model.ddl.SelfReference;
import de.evoal.languages.model.el.*;
import de.evoal.languages.model.el.util.ELSwitch;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class BoundaryIdentifier extends ELSwitch<Object> {

    private final DataDescription context;

    public BoundaryIdentifier(final DataDescription context) {
        this.context = context;
    }

    public static PropertiesBoundaries run(final DataConstraints constraints) {
        final Map<DataDescription, Number> lowerBounds = new HashMap<>();
        final Map<DataDescription, Number> upperBounds = new HashMap<>();

        constraints.stream()
                   .forEach(p -> p.getValue()
                                  .stream()
                                  .forEach(l -> processConstraint(l, p.getKey(), lowerBounds, upperBounds)));

        final PropertiesBoundaries boundaries = new PropertiesBoundaries();
        lowerBounds.keySet()
                .stream()
                .forEach(k -> boundaries.add(new PropertySpecification(k.getName(), k), new PropertiesBoundaries.Boundaries(lowerBounds.get(k), upperBounds.get(k))));

        return boundaries;
    }

    private static void processConstraint(final Expression constraint, final DataDescription context, final Map<DataDescription, Number> lowerBounds, final Map<DataDescription, Number> upperBounds) {
        final BoundaryIdentifier identifier = new BoundaryIdentifier(context);

        Object result = identifier.doSwitch(constraint);
        if(result == null) {
            return;
        }

        final Object [] llc = (Object[]) result;
        System.err.println(Arrays.toString(llc));

        if(llc[0] instanceof Number) {
            final DataDescription descr = (DataDescription) llc[1];
            final Number value = (Number)llc[0];

            if(!lowerBounds.containsKey(descr)) {
                if(RepresentationType.REAL.equals(descr.getRepresentation())) {
                    lowerBounds.put(descr, -Double.MAX_VALUE);
                    upperBounds.put(descr, Double.MAX_VALUE);
                } else if(RepresentationType.INTEGER.equals(descr.getRepresentation())) {
                    lowerBounds.put(descr, Integer.MIN_VALUE);
                    upperBounds.put(descr, Integer.MAX_VALUE);
                }
            }

            final Number oldLower = lowerBounds.get(descr);
            if(value.doubleValue() > oldLower.doubleValue()) {
                lowerBounds.put(descr, value);
            }
        } else {
            final DataDescription descr = (DataDescription) llc[0];
            final Number value = (Number)llc[1];

            if(!lowerBounds.containsKey(descr)) {
                if(RepresentationType.REAL.equals(descr.getRepresentation())) {
                    lowerBounds.put(descr, -Double.MAX_VALUE);
                    upperBounds.put(descr, Double.MAX_VALUE);
                } else if(RepresentationType.INTEGER.equals(descr.getRepresentation())) {
                    lowerBounds.put(descr, Integer.MIN_VALUE);
                    upperBounds.put(descr, Integer.MAX_VALUE);
                }
            }

            final Number oldUpper = upperBounds.get(descr);
            if(value.doubleValue() < oldUpper.doubleValue()) {
                upperBounds.put(descr, value);
            }
        }
    }


    @Override

    public Object caseOrExpression(OrExpression object) {
        Requirements.requireSize(object.getSubExpressions(), 1);

        return doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Object caseXorExpression(XorExpression object) {
        Requirements.requireSize(object.getSubExpressions(), 1);

        return doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Object caseAndExpression(final AndExpression object) {
        Requirements.requireSize(object.getSubExpressions(), 1);

        return doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Object caseNotExpression(NotExpression object) {
        Requirements.requireFalse(object.isNegated());

        return doSwitch(object.getOperand());
    }

    @Override
    public Object caseComparisonExpression(final ComparisonExpression object) {
        Requirements.requireSize(object.getComparison(), 1);

        final Object leftValue = doSwitch(object.getLeftOperand());
        final Object rightValue = doSwitch(object.getComparison().get(0).getSubExpression());

        if(!((leftValue instanceof DataDescription && rightValue instanceof Number) ||
             (rightValue instanceof DataDescription && leftValue instanceof Number))) {
            // not a supported relation
            return null;
        }

        switch (object.getComparison().get(0).getOperator()) {
            case GREATER_EQUAL:
            case GREATER_THAN: {
                if(leftValue instanceof DataDescription) {
                    // lower
                    return new Object[] {rightValue, leftValue};
                } else {
                    // upper
                    return new Object[] {leftValue, rightValue};
                }
            }
            case LESS_EQUAL:
            case LESS_THAN:
            {
                if(leftValue instanceof DataDescription) {
                    // upper
                    return new Object[] {leftValue, rightValue};
                } else {
                    // lower
                    return new Object[] {rightValue, leftValue};
                }
            }
            case EQUAL:
            case UNEQUAL: {
                throw new IllegalArgumentException("(Un)equal is not allowed");
            }
        }

        return null;
    }


    @Override
    public Object caseAddOrSubtractExpression(final AddOrSubtractExpression object) {
        Requirements.requireEmpty(object.getOperators());
        return doSwitch(object.getLeftOperand());
    }

    @Override
    public Object caseMultiplyDivideModuloExpression(final MultiplyDivideModuloExpression object) {
        Requirements.requireEmpty(object.getOperators());
        return doSwitch(object.getLeftOperand());
    }

    @Override
    public Object casePowerOfExpression(final PowerOfExpression object) {
        Requirements.requireNull(object.getRightOperand());

        return doSwitch(object.getLeftOperand());
    }

    @Override
    public Object caseUnaryAddOrSubtractExpression(UnaryAddOrSubtractExpression object) {
        Object value = doSwitch(object.getSubExpression());

        for(final AddOrSubtractOperator operator : object.getOperators()) {
            switch (operator) {
                case ADD: {
                    value = value;
                    break;
                }

                case SUBTRACT: {
                    if(value instanceof Double) {
                        value = -(Double)value;
                    } else if(value instanceof Integer) {
                        value = -(Integer)value;
                    } else {
                        throw new IllegalStateException("Unsupported");
                    }
                    break;
                }
            }
        }

        return value;
    }

    @Override
    public Object caseIntegerLiteral(final IntegerLiteral object) {
        return object.getValue();
    }

    @Override
    public Object caseDoubleLiteral(final DoubleLiteral object) {
        return object.getValue();
    }

    @Override
    public Object caseStringLiteral(final StringLiteral object) {
        return null;
    }

    @Override
    public Object caseValueReference(final ValueReference object) {
        if(object instanceof SelfReference) {
            Requirements.requireNotNull(context);
            return context;
        }

        if(!(object instanceof DataReference)) {
            throw new IllegalStateException("Value reference is not a data reference: " + object.eClass());
        }

        final DataReference reference = (DataReference)object;
        return reference.getDefinition();
    }

    @Override
    public Object caseBooleanLiteral(final BooleanLiteral object) {
        return null;
    }

    @Override
    public Object caseCall(Call object) {
        return null;
    }

    @Override
    public Object caseParantheses(final Parantheses object) {
        return doSwitch(object.getSubExpression());
    }
}
