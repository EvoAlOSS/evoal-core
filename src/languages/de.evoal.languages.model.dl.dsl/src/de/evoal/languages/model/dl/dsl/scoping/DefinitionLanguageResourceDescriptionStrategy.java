package de.evoal.languages.model.dl.dsl.scoping;

import com.google.inject.Singleton;

import de.evoal.languages.model.base.BasePackage;
import de.evoal.languages.model.dl.DlPackage;
import de.evoal.languages.model.utils.scoping.FilteringResourceDescriptionsStrategy;

@Singleton
public class DefinitionLanguageResourceDescriptionStrategy extends FilteringResourceDescriptionsStrategy {
	public DefinitionLanguageResourceDescriptionStrategy() {
		super(
				DlPackage.eINSTANCE.getDefinitionModel(),
				BasePackage.eINSTANCE.getConstantDefinition(),
				BasePackage.eINSTANCE.getTypeDefinition(),
				BasePackage.eINSTANCE.getAttributeDefinition(),
				BasePackage.eINSTANCE.getFunctionDefinition()
			 );
	}
}