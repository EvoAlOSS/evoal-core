package de.evoal.languages.model.interpreter;

import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.evoal.languages.model.base.definitions.ConstantDefinition;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.base.expressions.util.ExpressionsSwitch;

public abstract class AbstractExpressionEvaluator extends ExpressionsSwitch<Object> {
	/**
	 * Logger instance.
	 */
	private final static Logger log = LoggerFactory.getLogger(AbstractExpressionEvaluator.class);
	
	/**
	 * For evaluating constants.
	 */
	private ConstantEvaluator constants = null;
	
	protected void setConstantEvaluator(final ConstantEvaluator constants) {
		this.constants = constants;
	}

	@Override
	public Object caseAddOrSubtractExpression(final AddOrSubtractExpression object) {
        Object result = this.doSwitch(object.getLeftOperand());

        for(int i = 0; i < object.getOperands().size(); ++i) {
            final Object rOp = doSwitch(object.getOperands().get(i));
 
            result = switch(object.getOperators().get(i)) {
                case ADD:
                	if(result instanceof Number && rOp instanceof Number) {
                		yield ArithmeticNumberOperations.add(result, rOp);
                	} else if(result instanceof String || rOp instanceof String) {
                		yield Objects.toString(result) + Objects.toString(rOp);
                	} else {
                		throw new IllegalStateException("Failed to add values " + Objects.toString(result) + " and " + Objects.toString(rOp));
                	}
                	
                case SUBTRACT:
                	if(result instanceof Number && rOp instanceof Number) {
                		yield ArithmeticNumberOperations.minus(result, rOp);
                	} else {
                		throw new IllegalStateException("Failed to subtract values " + Objects.toString(result) + " and " + Objects.toString(rOp));
                	}
            };
        }

        return result;
	}

	@Override
	public Object caseAndExpression(AndExpression object) {
		if(object.getSubExpressions().size() == 1) {
			return doSwitch(object.getSubExpressions().get(0));
		}
		
		boolean result = true;

		for(final NotExpression sub : object.getSubExpressions()) {
			Object subResult = doSwitch(sub);
			
			if(!(subResult instanceof Boolean)) {
				log.warn("Subexpression of 'and' did not return a boolean value: {}. Testing it for null and continue.", subResult);
				subResult = subResult != null;
			}
			
			result = result && (Boolean)subResult;
			
			if(!result) {
				// short-circuit 
				break;
			}
		}

		return result;
	}

	@Override
	public Object caseArray(final Array object) {
		return object.getValues()
					 .stream()
					 .map(this::doSwitch)
					 .collect(Collectors.toList());
	}

	@Override
	public Object caseAttribute(Attribute object) {
		throw new IllegalStateException("Not yet implemented");			
	}

	@Override
	public Object caseCall(Call object) {
		throw new IllegalStateException("Not yet implemented");			
	}

	@Override
	public Object caseComparisonExpression(final ComparisonExpression object) {
		Object result = doSwitch(object.getLeftOperand());
		
		for(final PartialComparisonExpression subExpression : object.getComparison()) {
			final Object rOp = doSwitch(subExpression.getSubExpression());

			result = switch(subExpression.getOperator()) {
				case EQUAL: 	    yield Objects.equals(result, rOp);
				case UNEQUAL:       yield !Objects.equals(result, rOp);
				case GREATER_EQUAL: yield BooleanNumberOperations.isGreaterThanOrEqualTo(result, rOp);
				case GREATER_THAN:  yield BooleanNumberOperations.isGreaterThan(result, rOp);
				case LESS_EQUAL:    yield BooleanNumberOperations.isLesserThanOrEqualTo(result, rOp);
				case LESS_THAN:	    yield BooleanNumberOperations.isLesserThan(result, rOp);
				default: 			throw new IllegalStateException("Not yet implemented: " + subExpression.getOperator().getName());
			};
		}
	
		return result;
	}

	@Override
	public Object caseLiteralDefinitionReference(final LiteralDefinitionReference object) {
		if(object.getDefinition() instanceof ConstantDefinition) {
			if(constants == null) {
				throw new IllegalStateException("There is no constant evaluator");
			}
			
			return constants.evaluate(object);			
		}
		
		return super.caseLiteralDefinitionReference(object);
	}

	@Override
	public Object caseInstance(final Instance object) {
		return object;
	}

	@Override
	public Object caseLiteral(final Literal object) {
		log.info("Vising {}", object);
		
		return object.getValue();
	}

	@Override
	public Object caseMultiplyDivideModuloExpression(MultiplyDivideModuloExpression object) {
		Object result = doSwitch(object.getLeftOperand());
		
		for(int i = 0; i < object.getOperands().size(); ++i) {
			final Object rOp = doSwitch(object.getOperands().get(i));
			
			result = switch(object.getOperators().get(i)) {
				case DIVIDE:   yield ArithmeticNumberOperations.divide(result, rOp);
				case MODULO:   yield ArithmeticNumberOperations.modulo(result, rOp);
				case MULTIPLY: yield ArithmeticNumberOperations.multiply(result, rOp);
			};
		}
				
		return result;
	}

	@Override
	public Object caseNotExpression(final NotExpression object) {
		Object subResult = doSwitch(object.getOperand());
		
		if(object.isNegated()) {
			if(!(subResult instanceof Boolean)) {
				log.warn("Subexpression of 'not' did not return a boolean value: {}. Testing it for null and continue.", subResult);
				subResult = subResult != null;
			}
			
			subResult = !(Boolean)subResult;
		}
		
		return subResult;
	}

	@Override
	public Object caseOrExpression(final OrExpression object) {
		if(object.getSubExpressions().size() == 1) {
			return doSwitch(object.getSubExpressions().get(0));
		}
		
		boolean result = false;

		for(final XorExpression sub : object.getSubExpressions()) {
			Object subResult = doSwitch(sub);
			
			if(!(subResult instanceof Boolean)) {
				log.warn("Subexpression of 'or' did not return a boolean value: {}. Testing it for null and continue.", subResult);
				subResult = subResult != null;
			}
			
			result = result || (Boolean)subResult;
			
			if(result) {
				// short-circuit 
				break;
			}
		}

		return result;
	}

	@Override
	public Object caseParantheses(final Parantheses object) {
		return doSwitch(object.getSubExpression());
	}

	@Override
	public Object casePowerOfExpression(PowerOfExpression object) {
		Object result = doSwitch(object.getLeftOperand());
		
		if(object.getRightOperand() != null) {
			final Object rOp = doSwitch(object.getRightOperand());
			result = ArithmeticNumberOperations.pow(result, rOp);
		}

		return result;
	}

	@Override
	public Object caseUnaryAddOrSubtractExpression(final UnaryAddOrSubtractExpression object) {
		Object result = doSwitch(object.getSubExpression());
		
		if(!object.getOperators().isEmpty()) {
			if(!(result instanceof Number)) {
				throw new IllegalStateException("Cannot apply unary add/subtract to value " + result);				
			}
			
			for(final AddOrSubtractOperator op : object.getOperators()) {
				result = switch(op) {
					case ADD:      yield result;
					case SUBTRACT: yield ArithmeticNumberOperations.multiply(result, -1);
				};
			}
		}

		return result;
	}
	
	@Override
	public Object caseValueReference(final ValueReference object) {
		if(object instanceof ValueDefinitionReference reference) {
			if(reference.getDefinition() instanceof ConstantDefinition constant) {
				return doSwitch(constant.getValue());
			}

			return reference.getDefinition();
		} else if(object instanceof TypeDefinitionReference type) {
			return type.getDefinition();
		} else {
			throw new IllegalStateException("Not yet implemented: " + object.eClass() + " -- " + object);
		}
	}
	
	@Override
	public Object caseXorExpression(XorExpression object) {
		if(object.getSubExpressions().size() == 1) {
			return doSwitch(object.getSubExpressions().get(0));
		}
		
		boolean result = true;

		for(final AndExpression sub : object.getSubExpressions()) {
			Object subResult = doSwitch(sub);
			
			if(!(subResult instanceof Boolean)) {
				log.warn("Subexpression of 'xor' did not return a boolean value: {}. Testing it for null and continue.", subResult);
				subResult = subResult != null;
			}
			
			result = result ^ (Boolean)subResult;			
		}

		return result;
	}

	@Override
	public Object defaultCase(EObject object) {
		throw new IllegalStateException("Not yet implemented: " + object.eClass().getName());			
	}
}
