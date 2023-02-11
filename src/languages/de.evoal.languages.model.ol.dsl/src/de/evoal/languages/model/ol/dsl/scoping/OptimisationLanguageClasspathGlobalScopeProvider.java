package de.evoal.languages.model.ol.dsl.scoping;


import de.evoal.languages.model.utils.scoping.ClasspathGlobalScopeProvider;

public class OptimisationLanguageClasspathGlobalScopeProvider extends ClasspathGlobalScopeProvider {
	public OptimisationLanguageClasspathGlobalScopeProvider() {
		super("optimisation");
	}
}
