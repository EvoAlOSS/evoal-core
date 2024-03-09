package de.evoal.languages.model.ddl.dsl.scoping;

import com.google.inject.Singleton;

import de.evoal.languages.model.ddl.DdlPackage;
import de.evoal.languages.model.utils.scoping.FilteringResourceDescriptionsStrategy;

@Singleton
public class DataDescriptionLanguageResourceDescriptionStrategy extends FilteringResourceDescriptionsStrategy {
	public DataDescriptionLanguageResourceDescriptionStrategy() {
		super(
				DdlPackage.eINSTANCE.getDataDescriptionModule(),
				DdlPackage.eINSTANCE.getDataTypeDefinition(),
				DdlPackage.eINSTANCE.getDataDescription(),
				DdlPackage.eINSTANCE.getTypedBaseDataDescription(),
				DdlPackage.eINSTANCE.getUntypedBaseDataDescription(),
				DdlPackage.eINSTANCE.getStructuredDataDescription()
			 );
	}
}