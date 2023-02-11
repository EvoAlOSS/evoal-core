package de.evoal.languages.model.generator.dsl.scoping;


import de.evoal.languages.model.utils.scoping.ClasspathGlobalScopeProvider;

public class GeneratorClasspathGlobalScopeProvider extends ClasspathGlobalScopeProvider {
	public GeneratorClasspathGlobalScopeProvider() {
		super("generator");
	}
}
