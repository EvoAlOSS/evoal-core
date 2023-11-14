package de.evoal.languages.model.utils.validator;


import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.evoal.languages.model.base.AddOrSubtractExpression;
import de.evoal.languages.model.base.AndExpression;
import de.evoal.languages.model.base.Array;
import de.evoal.languages.model.base.Attribute;
import de.evoal.languages.model.base.BasePackage;
import de.evoal.languages.model.base.BooleanLiteral;
import de.evoal.languages.model.base.Call;
import de.evoal.languages.model.base.ComparisonExpression;
import de.evoal.languages.model.base.ConstantReference;
import de.evoal.languages.model.base.Expression;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.base.IntegerLiteral;
import de.evoal.languages.model.base.MultiplyDivideModuloExpression;
import de.evoal.languages.model.base.NotExpression;
import de.evoal.languages.model.base.OrExpression;
import de.evoal.languages.model.base.Parameter;
import de.evoal.languages.model.base.Parantheses;
import de.evoal.languages.model.base.PartialComparisonExpression;
import de.evoal.languages.model.base.PowerOfExpression;
import de.evoal.languages.model.base.RealLiteral;
import de.evoal.languages.model.base.StringLiteral;
import de.evoal.languages.model.base.UnaryAddOrSubtractExpression;
import de.evoal.languages.model.base.ValueReference;
import de.evoal.languages.model.base.XorExpression;
import de.evoal.languages.model.base.util.BaseSwitch;
import de.evoal.languages.model.ddl.ScaleType;

public class ScaleValidator extends BaseSwitch<ScaleType> {
	private static final Logger log = LoggerFactory.getLogger(ScaleValidator.class);
	private final Consumer<Triple<String, EObject, EStructuralFeature>> error;
	
	public ScaleValidator(final Consumer<Triple<String, EObject, EStructuralFeature>> error) {
		this.error = error;
	}

	public static void check(final Expression expression, Consumer<Triple<String, EObject, EStructuralFeature>> error) {
		new ScaleValidator(error).doSwitch(expression);
	}

	@Override
	public ScaleType caseOrExpression(final OrExpression object) {
		object.getSubExpressions().forEach(this::caseXorExpression);

		return null;
	}

	@Override
	public ScaleType caseXorExpression(final XorExpression object) {
		object.getSubExpressions().forEach(this::caseAndExpression);

		return null;
	}

	@Override
	public ScaleType caseAndExpression(final AndExpression object) {
		object.getSubExpressions().forEach(this::caseNotExpression);

		return null;
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
			case EQUAL:
			case UNEQUAL:
			{
				if(!ScaleType.CARDINAL.equals(lastScale)
						&& !ScaleType.NOMINAL.equals(lastScale)
						&& !ScaleType.ORDINAL.equals(lastScale)
						&& !ScaleType.QUOTIENT.equals(lastScale)
						) {
					error.accept(Tuples.create("No scale exist for left-hand operand.", lastExpr, BasePackage.Literals.PARTIAL_COMPARISON_EXPRESSION__OPERATOR));
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
					error.accept(Tuples.create("No scale exist for right-hand operand.", expr, BasePackage.Literals.PARTIAL_COMPARISON_EXPRESSION__OPERATOR));
					
				}

				lastExpr = null;
				lastScale = ScaleType.NOMINAL;
				break;
			}	
				
			case GREATER_EQUAL:
			case GREATER_THAN:
			case LESS_EQUAL:
			case LESS_THAN:
			{
				if(!ScaleType.NOMINAL.equals(lastScale)
						&& !ScaleType.ORDINAL.equals(lastScale)
						&& !ScaleType.QUOTIENT.equals(lastScale)
						) {
					error.accept(Tuples.create("Cardinal scale for left-hand operand isn't allowed in order comparison.", lastExpr, BasePackage.Literals.PARTIAL_COMPARISON_EXPRESSION__OPERATOR));
					// error for last expression
					
				}
				
				final AddOrSubtractExpression currentExpression = expr.getSubExpression();
				final ScaleType currentScale = this.caseAddOrSubtractExpression(currentExpression);
				if(!ScaleType.NOMINAL.equals(currentScale)
						&& !ScaleType.ORDINAL.equals(currentScale)
						&& !ScaleType.QUOTIENT.equals(currentScale)
						) {
					error.accept(Tuples.create("Cardinal scale for right-hand operand isn't allowed in order comparison.", expr, BasePackage.Literals.PARTIAL_COMPARISON_EXPRESSION__OPERATOR));
					// error for current expression
					
				}

				lastExpr = null;
				lastScale = ScaleType.NOMINAL;
				break;
			}
				
			default:
				log.warn("Unknown comparison operator: {}", expr.getOperator());
				break;
			}
		}
		
		return lastScale;
	}

	@Override
	public ScaleType caseAddOrSubtractExpression(final AddOrSubtractExpression object) {
		ScaleType scale = caseMultiplyDivideModuloExpression(object.getLeftOperand());
		
		if(object.getOperands().isEmpty()) {
			return scale;
		}
		
		if(!ScaleType.ORDINAL.equals(scale) && !ScaleType.QUOTIENT.equals(scale)) {
			// error for last expression
			
		}

		for(int i = 0; i < object.getOperands().size(); ++i) {
			scale = caseMultiplyDivideModuloExpression(object.getOperands().get(i));
			
			if(!ScaleType.ORDINAL.equals(scale) && !ScaleType.QUOTIENT.equals(scale)) {
				// error for expression
			}
		}
		
		return scale; // TODO Perhaps we have to use the "min" value of scales?
	}

	@Override
	public ScaleType caseMultiplyDivideModuloExpression(MultiplyDivideModuloExpression object) {
		ScaleType scale = casePowerOfExpression(object.getLeftOperand());
		
		if(object.getOperands().isEmpty()) {
			return scale;
		}
		
		if(!ScaleType.QUOTIENT.equals(scale)) {
			// error for last expression
			
		}

		for(int i = 0; i < object.getOperands().size(); ++i) {
			scale = casePowerOfExpression(object.getOperands().get(i));
			
			if(!ScaleType.QUOTIENT.equals(scale)) {
				// error for expression
				
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
			// error for last expression
			
		}
		
		return scale;
	}

	@Override
	public ScaleType caseUnaryAddOrSubtractExpression(final UnaryAddOrSubtractExpression object) {
		// TODO What scale do we need here?
		return doSwitch(object.getSubExpression());
	}

	@Override
	public ScaleType caseIntegerLiteral(IntegerLiteral object) {
		return ScaleType.ORDINAL;
	}

	@Override
	public ScaleType caseRealLiteral(RealLiteral object) {
		return ScaleType.ORDINAL;
	}

	@Override
	public ScaleType caseStringLiteral(StringLiteral object) {
		return ScaleType.CARDINAL;
	}

	@Override
	public ScaleType caseBooleanLiteral(final BooleanLiteral object) {
		return ScaleType.CARDINAL;
	}

	@Override
	public ScaleType caseCall(Call object) {
		log.info("Scale of function is unknown");

		return null;
	}

	@Override
	public ScaleType caseParantheses(final Parantheses object) {
		return doSwitch(object.getSubExpression());
	}


	@Override
	public ScaleType caseValueReference(final ValueReference object) {
		if(object instanceof de.evoal.languages.model.ddl.DataReference) {
			de.evoal.languages.model.ddl.DataReference reference = (de.evoal.languages.model.ddl.DataReference)object;
			
			return reference.getDefinition().getScale();
		} else if(object instanceof de.evoal.languages.model.instance.DataReference) {
			de.evoal.languages.model.instance.DataReference reference = (de.evoal.languages.model.instance.DataReference)object;
			
			return reference.getDefinition().getScale();
			
		} else if(object instanceof ConstantReference) {
			log.info("Scale of constant is unknown");

			return null;
		}
	
		return null;
	}

	@Override
	public ScaleType caseParameter(final Parameter object) {
		log.info("Scale of parameter is unknown");

		return null;
	}

	@Override
	public ScaleType caseConstantReference(final ConstantReference object) {
		return doSwitch(object.getDefinition().getType());
	}

	@Override
	public ScaleType caseArray(Array object) {
		log.info("Scale of array is unknown");

		return null;
	}

	@Override
	public ScaleType caseInstance(Instance object) {
		log.info("Scale of instance is unknown");

		return null;
	}

	@Override
	public ScaleType caseAttribute(final Attribute object) {
		log.info("Scale of attribute is unknown");

		return null;
	}
}
