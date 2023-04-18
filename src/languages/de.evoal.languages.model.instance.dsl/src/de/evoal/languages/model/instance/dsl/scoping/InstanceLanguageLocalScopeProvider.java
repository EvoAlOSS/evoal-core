package de.evoal.languages.model.instance.dsl.scoping;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;

import de.evoal.languages.model.base.AttributeDefinition;
import de.evoal.languages.model.base.TypeDefinition;
import de.evoal.languages.model.instance.Instance;
import de.evoal.languages.model.instance.InstancePackage;
import de.evoal.languages.model.utils.scoping.WildcardEnabledLocalScopeProvider;

public class InstanceLanguageLocalScopeProvider extends WildcardEnabledLocalScopeProvider {
	
	private static EClass instance = InstancePackage.eINSTANCE.getInstance();
	private static EReference instanceDefinition = InstancePackage.eINSTANCE.getInstance_Definition();
 	
	@Override
	public IScope getScope(final EObject context, final EReference reference) {
		System.err.println("[Ins] Asking for " + context.eClass().getName() + " --> " + reference.getEContainingClass().getName() + "." + reference.getName());
		
		if(instance.equals(context.eClass()) && instanceDefinition.equals(reference)) {
			// inject fields of types
			final Instance instance = (Instance)context;
			IScope typeScope = IScope.NULLSCOPE;
			if(instance.getDefinition() != null) {
				typeScope = this.getScope(instance.getDefinition(), reference);
			}
			
			System.err.println("[Ins]  --> dispatching");

			return getLocalElementsScope(typeScope, context, reference);
		}  else if(instance.equals(context.eClass()) && InstancePackage.eINSTANCE.getAttribute_Definition().equals(reference)) {
			return scopeOf(((Instance)context).getDefinition());
		}

		return super.getScope(context, reference);
	}

	private IScope scopeOf(final TypeDefinition definition) {
		List<AttributeDefinition> attributes = new LinkedList<>();
		TypeDefinition current = definition;
		
		while(current != null) {
			attributes.addAll(current.getAttributes());
			current = current.getSuperType();
		}
				
		System.err.println("[Ins]  --> " + attributes);
		return Scopes.scopeFor(attributes);
	}	

}
