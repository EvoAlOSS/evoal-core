package de.evoal.languages.model.dl.dsl.scoping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;

import com.google.inject.Inject;

import de.evoal.languages.model.base.BasePackage;
import de.evoal.languages.model.base.dsl.scoping.BaseLanguageLocalScopeProvider;
import de.evoal.languages.model.utils.scoping.WildcardEnabledLocalScopeProvider;

public class DefinitionLanguageLocalScopeProvider extends WildcardEnabledLocalScopeProvider {
	//private static EClass typeDefinition = BasePackage.eINSTANCE.getTypeDefinition();
	//private static EReference attributes = BasePackage.eINSTANCE.getTypeDefinition_Attributes();

	private final static EReference attributeDefinition = BasePackage.eINSTANCE.getAttribute_Definition();
	private final static EClass instance = BasePackage.eINSTANCE.getInstance();
	
	@Inject
	private BaseLanguageLocalScopeProvider provider;
	
	@Override
	public IScope getScope(final EObject context, final EReference reference) {
		//System.err.println("[DL] Asking for " + context.eClass().getName() + " --> " + reference.getEContainingClass().getName() + "." + reference.getName());
		
		/*
		if(typeDefinition.equals(context.eClass()) && (attributes.equals(reference))) {
			// inject fields of types
			final TypeDefinition definition = (TypeDefinition)context;
			IScope typeScope = IScope.NULLSCOPE;
			if(definition.getSuperType() != null) {
				typeScope = super.getScope(definition.getSuperType(), reference);
			}
			
			return getLocalElementsScope(typeScope, context, reference);
		}
*/
		if(instance.equals(context.eClass()) && attributeDefinition.equals(reference)) {
			return provider.getScope(context, reference);
		}
		
		return super.getScope(context, reference);
	}	
}
