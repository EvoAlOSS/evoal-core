package de.evoal.languages.model.interpreter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.evoal.languages.model.base.definitions.ConstantDefinition;
import de.evoal.languages.model.base.expressions.ConstantReference;


public class ConstantEvaluator extends AbstractExpressionEvaluator {
	/**
	 * Logger instance.
	 */
	private final static Logger log = LoggerFactory.getLogger(ConstantEvaluator.class);

	/**
	 * Cache for calculated constants.
	 * 
	 * TODO Should we register a single cache for each resource to reduce calculation time?
	 */
	private Map<EObject, Object> constantCache = new HashMap<>();
	
	public ConstantEvaluator() {
		setConstantEvaluator(this);
	}
	
	@Override
	public Object caseConstantReference(final ConstantReference object) {
		final ConstantDefinition definition = object.getDefinition();

		if(definition == null) {
			log.warn("Definition of constant is null.");
			return null;
		}

		if(constantCache.containsKey(definition)) {
			return constantCache.get(definition);
		}
		
		final Object value = doSwitch(definition.getValue());
		constantCache.put(definition, value);

		return value;
	}

	public Object evaluate(final ConstantReference object) {
		final ConstantDefinition definition = object.getDefinition();

		if(definition == null) {
			log.warn("Definition of constant is null.");
			return null;
		}

		if(constantCache.containsKey(definition)) {
			return constantCache.get(definition);
		}
		
		final Object value = doSwitch(definition.getValue());
		constantCache.put(definition, value);
		
		return value;
	}
}
