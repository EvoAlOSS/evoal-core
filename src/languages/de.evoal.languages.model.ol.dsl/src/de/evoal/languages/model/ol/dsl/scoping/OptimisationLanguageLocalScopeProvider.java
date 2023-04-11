package de.evoal.languages.model.ol.dsl.scoping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;

import com.google.inject.Inject;

import de.evoal.languages.model.instance.Instance;
import de.evoal.languages.model.instance.InstancePackage;
import de.evoal.languages.model.instance.dsl.scoping.InstanceLanguageLocalScopeProvider;
import de.evoal.languages.model.utils.scoping.WildcardEnabledLocalScopeProvider;

public class OptimisationLanguageLocalScopeProvider extends WildcardEnabledLocalScopeProvider {
	private static EClass instance = InstancePackage.eINSTANCE.getInstance();
	private static EReference instanceDefinition = InstancePackage.eINSTANCE.getInstance_Definition();
	private static EReference attributeDefinition = InstancePackage.eINSTANCE.getAttribute_Definition();
	
	@Inject
	private InstanceLanguageLocalScopeProvider scopeProvider;
	
	@Override
	public IScope getScope(final EObject context, final EReference reference) {
		System.err.println("[Opt] Asking for " + context.eClass().getName() + " --> " + reference.getEContainingClass().getName() + "." + reference.getName());
		
		if(instance.equals(context.eClass()) && (attributeDefinition.equals(reference))) {
			// inject fields of types
			final Instance instance = (Instance)context;
			IScope typeScope = IScope.NULLSCOPE;
				try {
					typeScope = scopeProvider.getScope(instance, reference);
				} catch(final NullPointerException e) {
					
				}
			
			return getLocalElementsScope(typeScope, context, reference);
		}

		return super.getScope(context, reference);
	}	

}
