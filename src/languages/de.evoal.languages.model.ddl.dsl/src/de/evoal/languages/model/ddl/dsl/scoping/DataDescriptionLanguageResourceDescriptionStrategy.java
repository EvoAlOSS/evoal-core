package de.evoal.languages.model.ddl.dsl.scoping;

import com.google.inject.Singleton;

import de.evoal.languages.model.base.definitions.DefinitionsPackage;
import de.evoal.languages.model.ddl.DdlPackage;
import de.evoal.languages.model.utils.scoping.FilteringResourceDescriptionsStrategy;

@Singleton
public class DataDescriptionLanguageResourceDescriptionStrategy extends FilteringResourceDescriptionsStrategy {
	public DataDescriptionLanguageResourceDescriptionStrategy() {
		super(
				DdlPackage.eINSTANCE.getDataDescriptionModule(),
				DefinitionsPackage.eINSTANCE.getDataTypeDefinition(),
				DefinitionsPackage.eINSTANCE.getDataTypeTypeDefinition(),
				DefinitionsPackage.eINSTANCE.getDataDescription(),
				DefinitionsPackage.eINSTANCE.getTypedBaseDataDescription(),
				DefinitionsPackage.eINSTANCE.getUntypedBaseDataDescription(),
				DefinitionsPackage.eINSTANCE.getStructuredDataDescription(),
				DefinitionsPackage.eINSTANCE.getEnumDefinition(),
				DefinitionsPackage.eINSTANCE.getEnumLiteralDefinition()
			 );
	}
}