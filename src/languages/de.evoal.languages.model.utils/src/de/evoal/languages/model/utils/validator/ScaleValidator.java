package de.evoal.languages.model.utils.validator;


import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.base.expressions.util.ExpressionsSwitch;

public class ScaleValidator extends ExpressionsSwitch<ScaleType> {
	private static final Logger log = LoggerFactory.getLogger(ScaleValidator.class);
	private final ValidationMessageAcceptor acceptor;
	private final ScaleType scaleTypeOfValue;
	
	public ScaleValidator(final ValidationMessageAcceptor acceptor, final ScaleType scaleTypeOfValue) {
		this.acceptor = acceptor;
		this.scaleTypeOfValue = scaleTypeOfValue;
	}

	public static void check(final Expression expression, final ScaleType scaleTypeOfValue, final ValidationMessageAcceptor acceptor) {
		new ScaleValidator(acceptor, scaleTypeOfValue).doSwitch(expression);
	}

	@Override
	public ScaleType caseOrExpression(final OrExpression object) {
		object.getSubExpressions().forEach(this::caseXorExpression);

		return ScaleType.NOMINAL;
	}

	@Override
	public ScaleType caseXorExpression(final XorExpression object) {
		object.getSubExpressions().forEach(this::caseAndExpression);

		return ScaleType.NOMINAL;
	}

	@Override
	public ScaleType caseAndExpression(final AndExpression object) {
		object.getSubExpressions().forEach(this::caseNotExpression);

		return ScaleType.NOMINAL;
	}

	@Override
	public ScaleType caseNotExpression(final NotExpression object) {
		return caseComparisonExpression(object.getOperand());	
	}

	@Override
	public ScaleType caseComparisonExpression(final ComparisonExpression object) {
		ScaleType lastScale = this.caseAddOrSubtractExpression(object.getLeftOperand());
		AddOrSubtractExpression lastExpr = object.getLeftOperand();

		if(object.getComparison().isEmpty()) {
			return lastScale;
		}
		
		for(final PartialComparisonExpression expr : object.getComparison()) {
			switch(expr.getOperator()) {
			/*
			case EQUAL:
			case UNEQUAL:
			{
				if(!ScaleType.CARDINAL.equals(lastScale)
						&& !ScaleType.NOMINAL.equals(lastScale)
						&& !ScaleType.ORDINAL.equals(lastScale)
						&& !ScaleType.QUOTIENT.equals(lastScale)
						) {
					//validator.a(Tuples.create("No scale exist for left-hand operand.", lastExpr, BasePackage.Literals.PARTIAL_COMPARISON_EXPRESSION__OPERATOR));
					// error for last expression
					
				}
				
				final AddOrSubtractExpression currentExpression = expr.getSubExpression();
				final ScaleType currentScale = this.caseAddOrSubtractExpression(currentExpression);
				if(!ScaleType.CARDINAL.equals(currentScale)
						&& !ScaleType.NOMINAL.equals(currentScale)
						&& !ScaleType.ORDINAL.equals(currentScale)
						&& !ScaleType.QUOTIENT.equals(currentScale)
						) {
					// error for current expression
					//error.accept(Tuples.create("No scale exist for right-hand operand.", expr, BasePackage.Literals.ADD_OR_SUBTRACT_EXPRESSION));
					
				}

				lastExpr = null;
				lastScale = ScaleType.NOMINAL;
				break;
			}	
			*/
				
			case GREATER_EQUAL:
			case GREATER_THAN:
			case LESS_EQUAL:
			case LESS_THAN:
			{
				if(ScaleType.NOMINAL.equals(lastScale)) {
					acceptor.acceptError("Nominal scale for comparison is not allowed.", lastExpr, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);
				}
				
				final AddOrSubtractExpression currentExpression = expr.getSubExpression();
				final ScaleType currentScale = this.caseAddOrSubtractExpression(currentExpression);
				if(ScaleType.NOMINAL.equals(currentScale)) {
					acceptor.acceptError("Nominal scale for comparison is not allowed.", currentExpression, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);
				}

				lastExpr = null;
				lastScale = ScaleType.NOMINAL;
				break;
			}
				
			default:
				log.info("Unknown comparison operator: {}", expr.getOperator());
				break;
			}
		}
		
		return lastScale;
	}

	@Override
	public ScaleType caseAddOrSubtractExpression(final AddOrSubtractExpression object) {
		ScaleType lastScale = caseMultiplyDivideModuloExpression(object.getLeftOperand());
		
		if(object.getOperands().isEmpty()) {
			return lastScale;
		}
		
		if(ScaleType.ORDINAL.equals(lastScale) || ScaleType.NOMINAL.equals(lastScale)) {
			acceptor.acceptError("Ordinal and nominal scales are not allowed in add or substract.", object.getLeftOperand(), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);			
		}

		for(int i = 0; i < object.getOperands().size(); ++i) {
			final ScaleType scale = caseMultiplyDivideModuloExpression(object.getOperands().get(i));
			
			if(ScaleType.ORDINAL.equals(scale) || ScaleType.NOMINAL.equals(scale)) {
				acceptor.acceptError("Ordinal and nominal scales are not allowed in add or substract.", object.getOperands().get(i), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);			
			}
			
			lastScale = scale.equals(ScaleType.QUOTIENT) && lastScale.equals(ScaleType.QUOTIENT)? ScaleType.QUOTIENT : scale;
		}
		
		return lastScale;
	}

	@Override
	public ScaleType caseMultiplyDivideModuloExpression(MultiplyDivideModuloExpression object) {
		ScaleType scale = casePowerOfExpression(object.getLeftOperand());
		
		if(object.getOperands().isEmpty()) {
			return scale;
		}
		
		if(ScaleType.CARDINAL.equals(scale) || ScaleType.NOMINAL.equals(scale) || ScaleType.ORDINAL.equals(scale)) {
			acceptor.acceptError("Cardinal, ordinal and nominal scales are not allowed in multiplication or division.", object.getLeftOperand(), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);			
		}

		for(int i = 0; i < object.getOperands().size(); ++i) {
			scale = casePowerOfExpression(object.getOperands().get(i));
			
			if(ScaleType.CARDINAL.equals(scale) || ScaleType.NOMINAL.equals(scale) || ScaleType.ORDINAL.equals(scale)) {
				acceptor.acceptError("Cardinal, ordinal and nominal scales are not allowed in multiplication or division.", object.getOperands().get(i), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);			
			}
		}
		
		return scale;
	}

	@Override
	public ScaleType casePowerOfExpression(final PowerOfExpression object) {
		ScaleType scale = caseUnaryAddOrSubtractExpression(object.getLeftOperand());
		
		if(object.getRightOperand() == null) {
			return scale;
		}

		if(!ScaleType.QUOTIENT.equals(scale)) {
			if(ScaleType.CARDINAL.equals(scale) || ScaleType.NOMINAL.equals(scale) || ScaleType.ORDINAL.equals(scale)) {
				acceptor.acceptError("Cardinal, ordinal and nominal scales are not allowed in power of operation.", object.getLeftOperand(), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);			
			}
		}

		scale = casePowerOfExpression(object.getRightOperand());
		if(ScaleType.NOMINAL.equals(scale) || ScaleType.ORDINAL.equals(scale)) {
			acceptor.acceptError("Ordinal and nominal scales are not allowed in power of operation.", object.getLeftOperand(), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);			
		}

		return ScaleType.QUOTIENT;
	}

	@Override
	public ScaleType caseUnaryAddOrSubtractExpression(final UnaryAddOrSubtractExpression object) {
		final ScaleType scale = doSwitch(object.getSubExpression());
		
		if(!object.getOperators().isEmpty()) {
			if(ScaleType.NOMINAL.equals(scale) || ScaleType.ORDINAL.equals(scale)) {
				acceptor.acceptError("Ordinal and nominal scales are not allowed in unary add or subtract expression.", object.getSubExpression(), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);			
			}
		}

		return scale;
	}

	@Override
	public ScaleType caseIntegerLiteral(final IntegerLiteral object) {
		return ScaleType.UNKNOWN;
	}

	@Override
	public ScaleType caseRealLiteral(final RealLiteral object) {
		return ScaleType.UNKNOWN;
	}

	@Override
	public ScaleType caseStringLiteral(final StringLiteral object) {
		return ScaleType.NOMINAL;
	}

	@Override
	public ScaleType caseBooleanLiteral(final BooleanLiteral object) {
		return ScaleType.NOMINAL;
	}

	@Override
	public ScaleType caseCall(final Call object) {
		log.info("Scale of function is unknown");

		return ScaleType.UNKNOWN;
	}

	@Override
	public ScaleType caseParantheses(final Parantheses object) {
		return doSwitch(object.getSubExpression());
	}

	/*
	@Override
	public ScaleType caseValueReference(final ValueReference object) {
		DataDescription description = null;

		if(object instanceof SelfReference) {
			return scaleTypeOfValue;
		} else if(object instanceof DataTypeReference) {
			DataTypeReference reference = (DataTypeReference)object;
			
			description = reference.getDefinition();
		}
		
		if(description != null && description instanceof BaseDataDescription) {
			return ((BaseDataDescription)description).getScale();
		}
	
		return doSwitch(object);
	}

	@Override
	public ScaleType caseDefinitionReference(final DefinitionReference object) {
		return doSwitch(object.getDefinition().getType());
	}
	*/

	@Override
	public ScaleType caseArray(Array object) {
		log.info("Scale of array is unknown");

		return ScaleType.UNKNOWN;
	}

	@Override
	public ScaleType caseInstance(Instance object) {
		log.info("Scale of instance is unknown");

		return ScaleType.UNKNOWN;
	}

	@Override
	public ScaleType caseAttribute(final Attribute object) {
		log.info("Scale of attribute is unknown");

		return ScaleType.UNKNOWN;
	}
}
