package de.evoal.languages.model.ddl.dsl.scoping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;

import de.evoal.languages.model.base.BasePackage;
import de.evoal.languages.model.base.TypeDefinition;
import de.evoal.languages.model.utils.scoping.WildcardEnabledLocalScopeProvider;

public class DataDescriptionLanguageLocalScopeProvider extends WildcardEnabledLocalScopeProvider {
	private static EClass typeDefinition = BasePackage.eINSTANCE.getTypeDefinition();
	private static EReference attributes = BasePackage.eINSTANCE.getTypeDefinition_Attributes();
	
	@Override
	public IScope getScope(final EObject context, final EReference reference) {
		if(typeDefinition.equals(context.eClass()) && (attributes.equals(reference))) {
			// inject fields of types
			final TypeDefinition definition = (TypeDefinition)context;
			IScope typeScope = IScope.NULLSCOPE;
			if(definition.getSuperType() != null) {
				typeScope = super.getScope(definition.getSuperType(), reference);
			}
			
			return getLocalElementsScope(typeScope, context, reference);
		}

		return super.getScope(context, reference);
	}	
}
