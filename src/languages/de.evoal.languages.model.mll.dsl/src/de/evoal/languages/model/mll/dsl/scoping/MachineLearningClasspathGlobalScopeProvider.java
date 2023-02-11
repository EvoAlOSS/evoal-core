package de.evoal.languages.model.mll.dsl.scoping;


import de.evoal.languages.model.utils.scoping.ClasspathGlobalScopeProvider;

public class MachineLearningClasspathGlobalScopeProvider extends ClasspathGlobalScopeProvider {
	public MachineLearningClasspathGlobalScopeProvider() {
		super("surrogate");
	}
}
