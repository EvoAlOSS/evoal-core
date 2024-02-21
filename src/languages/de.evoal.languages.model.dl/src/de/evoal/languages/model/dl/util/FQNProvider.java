package de.evoal.languages.model.dl.util;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;

import de.evoal.languages.model.base.ConstantDefinition;
import de.evoal.languages.model.base.FunctionDefinition;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.base.TypeDefinition;
import de.evoal.languages.model.dl.DefinitionModule;

public class FQNProvider {
	/**
	 * Returns the FQN of the passed type definition.
	 */
	public String get(final TypeDefinition def) {
		final EObject module = def.eContainer();
		
		Objects.requireNonNull(module);
		
		if(!(module instanceof DefinitionModule)) {
			throw new IllegalArgumentException("Passed definition is not part of a definition module");
		}
		
		final DefinitionModule defModule = (DefinitionModule)module;
		
		return defModule.getName() + "." + def.getName();
	}

	/**
	 * Returns the FQN of the passed function definition.
	 */
	public String get(final FunctionDefinition def) {
		final EObject module = def.eContainer();
		
		Objects.requireNonNull(module);
		
		if(!(module instanceof DefinitionModule)) {
			throw new IllegalArgumentException("Passed definition is not part of a definition module");
		}
		
		final DefinitionModule defModule = (DefinitionModule)module;
		
		return defModule.getName() + "." + def.getName();
	}

	/**
	 * Returns the FQN of the passed constant definition.
	 */
	public String get(final ConstantDefinition def) {
		final EObject module = def.eContainer();
		
		Objects.requireNonNull(module);
		
		if(!(module instanceof DefinitionModule)) {
			throw new IllegalArgumentException("Passed definition is not part of a definition module");
		}
		
		final DefinitionModule defModule = (DefinitionModule)module;
		
		return defModule.getName() + "." + def.getName();
	}
	
	/**
	 * Returns the FQN of the passed instance.
	 */
	public String get(final Instance instance) {
		return get(instance.getDefinition());
	}
}
