package de.evoal.languages.model.ol.dsl.utils;

public class OLGlobalScopeProvider extends ClasspathDefaultGlobalScopeProvider {
	public OLGlobalScopeProvider() {
		super(new EvoalReleaseBuiltinDSLProvider());
		
		getProvider().setBasePath("definitions/ea");
		getProvider().setExtension(".dl");
	}
}
