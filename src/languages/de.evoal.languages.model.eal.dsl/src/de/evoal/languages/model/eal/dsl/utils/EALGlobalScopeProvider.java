package de.evoal.languages.model.eal.dsl.utils;

public class EALGlobalScopeProvider extends ClasspathDefaultGlobalScopeProvider {
	public EALGlobalScopeProvider() {
		super(new EvoalReleaseBuiltinDSLProvider());
		
		getProvider().setBasePath("definitions/ea");
		getProvider().setExtension(".dl");
	}
}
