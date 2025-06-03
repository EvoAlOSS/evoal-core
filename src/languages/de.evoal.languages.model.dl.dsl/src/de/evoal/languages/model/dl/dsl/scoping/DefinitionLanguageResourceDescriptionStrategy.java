package de.evoal.languages.model.dl.dsl.scoping;

import com.google.inject.Singleton;

import de.evoal.languages.model.base.definitions.DefinitionsPackage;
import de.evoal.languages.model.dl.DlPackage;
import de.evoal.languages.model.utils.scoping.FilteringResourceDescriptionsStrategy;

@Singleton
public class DefinitionLanguageResourceDescriptionStrategy extends FilteringResourceDescriptionsStrategy {
	public DefinitionLanguageResourceDescriptionStrategy() {
		super(
				DlPackage.eINSTANCE.getDefinitionModule(),
				DefinitionsPackage.eINSTANCE.getAttributeDefinition(),
				DefinitionsPackage.eINSTANCE.getConstantDefinition(),
				DefinitionsPackage.eINSTANCE.getClassDefinition(),
				DefinitionsPackage.eINSTANCE.getEnumDefinition(),
				DefinitionsPackage.eINSTANCE.getEnumLiteralDefinition(),
				DefinitionsPackage.eINSTANCE.getFunctionDefinition()
			 );
	}
}