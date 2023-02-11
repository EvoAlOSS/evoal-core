package de.evoal.languages.model.ddl.dsl.scoping;


import de.evoal.languages.model.utils.scoping.ClasspathGlobalScopeProvider;

public class DataDescriptionLanguageClasspathGlobalScopeProvider extends ClasspathGlobalScopeProvider {
	public DataDescriptionLanguageClasspathGlobalScopeProvider() {
		super("data");
	}
}
