package de.evoal.languages.model.mll.dsl.scoping;

import com.google.inject.Singleton;

import de.evoal.languages.model.mll.MllPackage;
import de.evoal.languages.model.utils.scoping.FilteringResourceDescriptionsStrategy;

@Singleton
public class MachineLearningLanguageResourceDescriptionStrategy extends FilteringResourceDescriptionsStrategy {
	public MachineLearningLanguageResourceDescriptionStrategy() {
		super(
				MllPackage.eINSTANCE.getMachineLearningModule(),
				MllPackage.eINSTANCE.getSurrogateDefinition()
			 );
	}
}