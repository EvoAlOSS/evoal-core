package de.evoal.languages.model.base.eval;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.evoal.languages.model.base.AddOrSubtractExpression;
import de.evoal.languages.model.base.AndExpression;
import de.evoal.languages.model.base.Array;
import de.evoal.languages.model.base.Attribute;
import de.evoal.languages.model.base.Call;
import de.evoal.languages.model.base.ComparisonExpression;
import de.evoal.languages.model.base.ConstantDefinition;
import de.evoal.languages.model.base.ConstantReference;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.base.Literal;
import de.evoal.languages.model.base.MultiplyDivideModuloExpression;
import de.evoal.languages.model.base.NotExpression;
import de.evoal.languages.model.base.OrExpression;
import de.evoal.languages.model.base.Parantheses;
import de.evoal.languages.model.base.PartialComparisonExpression;
import de.evoal.languages.model.base.PowerOfExpression;
import de.evoal.languages.model.base.UnaryAddOrSubtractExpression;
import de.evoal.languages.model.base.ValueReference;
import de.evoal.languages.model.base.XorExpression;
import de.evoal.languages.model.base.util.BaseSwitch;

public class ConstantExpressionEvaluator extends BaseSwitch<Object> {
	/**
	 * Logger instance.
	 */
	private final static Logger log = LoggerFactory.getLogger(ConstantExpressionEvaluator.class);
	
	/**
	 * Cache for calculated constants.
	 * 
	 * TODO Should we register a single cache for each resource to reduce calculation time?
	 */
	private Map<EObject, Object> constantCache = new HashMap<>();

	@Override
	public Object caseAddOrSubtractExpression(final AddOrSubtractExpression object) {
		Object result = doSwitch(object.getLeftOperand());
		
		for(int i = 0; i < object.getOperands().size(); i++) {
			throw new IllegalStateException("Not yet implemented");
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
	public Object caseArray(Array object) {
		throw new IllegalStateException("Not yet implemented");			
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
			throw new IllegalStateException("Not yet implemented");
		}
	
		return result;
	}

	@Override
	public Object caseConstantReference(ConstantReference object) {
		final ConstantDefinition definition = object.getDefinition();
		
		if(constantCache.containsKey(definition)) {
			return constantCache.get(definition);
		}
		
		final Object value = doSwitch(definition.getValue());
		constantCache.put(definition, value);

		return value;
	}

	@Override
	public Object caseInstance(Instance object) {
		throw new IllegalStateException("Not yet implemented");			
	}

	@Override
	public Object caseLiteral(Literal object) {
		return object.getValue();
	}

	@Override
	public Object caseMultiplyDivideModuloExpression(MultiplyDivideModuloExpression object) {
		Object result = doSwitch(object.getLeftOperand());
		
		for(int i = 0; i < object.getOperands().size(); ++i) {
			final Object rOp = doSwitch(object.getOperands().get(i));
			
			switch(object.getOperators().get(i)) {
			case DIVIDE:
				result = ArithmeticNumberOperations.divide(result, rOp);
				break;
			case MODULO:
				result = ArithmeticNumberOperations.modulo(result, rOp);
				break;
			case MULTIPLY:
				result = ArithmeticNumberOperations.multiply(result, rOp);
				break;
			}
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
			throw new IllegalStateException("Not yet implemented");			
		}

		return result;
	}

	@Override
	public Object caseUnaryAddOrSubtractExpression(UnaryAddOrSubtractExpression object) {
		Object result = doSwitch(object.getSubExpression());
		
		if(!object.getOperators().isEmpty()) {
			throw new IllegalStateException("Not yet implemented");			
		}

		return result;
	}

	@Override
	public Object caseValueReference(final ValueReference object) {
		throw new IllegalStateException("Not yet implemented");			
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
