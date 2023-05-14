package de.evoal.languages.model.mll.dsl.scoping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;

import com.google.inject.Inject;

import de.evoal.languages.model.base.BasePackage;
import de.evoal.languages.model.instance.dsl.scoping.InstanceLanguageLocalScopeProvider;
import de.evoal.languages.model.mll.MllPackage;
import de.evoal.languages.model.utils.scoping.WildcardEnabledLocalScopeProvider;

public class MachineLearningLanguageLocalScopeProvider extends WildcardEnabledLocalScopeProvider {
	private static EClass psfd = MllPackage.eINSTANCE.getPartialSurrogateFunctionDefinition();

	private static EReference attributeDefinition = BasePackage.eINSTANCE.getAttribute_Definition();
	
	@Inject
	private InstanceLanguageLocalScopeProvider instanceScopes;
	
	@Override
	public IScope getScope(final EObject context, final EReference reference) {
		if(psfd.equals(context.eClass()) && (attributeDefinition.equals(reference))) {
			// inject fields of types
			IScope typeScope = IScope.NULLSCOPE;
			try {
				typeScope = instanceScopes.getScope(context, reference);
			} catch(final NullPointerException e) {
				System.err.println(e);
			}
			
			return getLocalElementsScope(typeScope, context, reference);
		}// else if(psfd.equals(context.eClass()) && (psfdDefinition.equals(reference))) {
		//	return scopeProvider.getScope(context, BasePackage.eINSTANCE.getInstance_Definition());
		//}

 /*
		if(instance.equals(context.eClass()) && (attributeDefinition.equals(reference))) {
			// inject fields of types
			IScope typeScope = IScope.NULLSCOPE;
			try {
				typeScope = instanceScopes.getScope(context, reference);
			} catch(final NullPointerException e) {
				System.err.println(e);
			}
			
			return getLocalElementsScope(typeScope, context, reference);
		} 
		
		return super.getScope(context, reference);
  */
		
		
		return super.getScope(context, reference);
	}
}
