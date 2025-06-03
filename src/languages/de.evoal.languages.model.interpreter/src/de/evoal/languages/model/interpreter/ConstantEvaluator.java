package de.evoal.languages.model.interpreter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.evoal.languages.model.base.definitions.ConstantDefinition;
import de.evoal.languages.model.base.expressions.DefinitionReference;
import de.evoal.languages.model.base.expressions.LiteralDefinitionReference;


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
	public Object caseLiteralDefinitionReference(final LiteralDefinitionReference object) {
		if(!(object.getDefinition() instanceof ConstantDefinition)) {
			return super.caseLiteralDefinitionReference(object);
		}

		final ConstantDefinition definition = (ConstantDefinition)object.getDefinition();

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

	public Object evaluate(final LiteralDefinitionReference object) {
		if(!(object.getDefinition() instanceof ConstantDefinition)) {
			log.warn("Not a definition reference. Returning null.");
			return null;
		}

		final ConstantDefinition definition = (ConstantDefinition)object.getDefinition();

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
