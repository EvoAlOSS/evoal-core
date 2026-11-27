package de.evoal.models.core.utils;

import java.util.Objects;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.ConstantDefinition;
import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.dl.DefinitionModule;

public class FQNProvider {
	/**
	 * Returns the FQN of the passed type definition.
	 */
	public String get(final ClassDefinition def) {
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

	/**
	 * Returns the FQN of the passed EObject.
	 */
	public String get(final EObject object) {
		return get(object.eClass());
	}

	/**
	 * Returns the FQN of the passed EObject.
	 */
	public String get(final EClassifier object) {
		return get(object.getEPackage()) + "." + object.getName();
	}

	/**
	 * Returns the qualified name of the passed package: the names of its super packages and its
	 *   own name, separated by dots. A package carries only the last segment of its name, as EMF
	 *   names packages.
	 */
	public String get(final EPackage object) {
		final EPackage superPackage = object.getESuperPackage();

		return superPackage == null ? object.getName() : get(superPackage) + "." + object.getName();
	}
}

