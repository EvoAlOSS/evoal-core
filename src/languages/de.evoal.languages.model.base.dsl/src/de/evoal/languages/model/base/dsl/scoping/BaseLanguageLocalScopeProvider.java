package de.evoal.languages.model.base.dsl.scoping;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;

import de.evoal.languages.model.base.AttributeDefinition;
import de.evoal.languages.model.base.BasePackage;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.base.TypeDefinition;
import de.evoal.languages.model.utils.scoping.WildcardEnabledLocalScopeProvider;

public class BaseLanguageLocalScopeProvider extends WildcardEnabledLocalScopeProvider {
	
	private static EClass instance = BasePackage.eINSTANCE.getInstance();
	private static EReference instanceDefinition = BasePackage.eINSTANCE.getInstance_Definition();
 	
	@Override
	public IScope getScope(final EObject context, final EReference reference) {
		if(instance.equals(context.eClass()) && instanceDefinition.equals(reference)) {
			// inject fields of types
			final Instance instance = (Instance)context;
			IScope typeScope = IScope.NULLSCOPE;
			if(instance.getDefinition() != null) {
				typeScope = this.getScope(instance.getDefinition(), reference);
			}
			
			return getLocalElementsScope(typeScope, context, reference);
		}  else if(instance.equals(context.eClass()) && BasePackage.eINSTANCE.getAttribute_Definition().equals(reference)) {
			return scopeOf(((Instance)context).getDefinition());
		}

		System.err.println("[Base]  --> " + context + "." + reference);
		return super.getScope(context, reference);
	}

	private IScope scopeOf(final TypeDefinition definition) {
		List<AttributeDefinition> attributes = new LinkedList<>();
		TypeDefinition current = definition;
		
		while(current != null) {
			attributes.addAll(current.getAttributes());
			current = current.getSuperType();
		}

		return Scopes.scopeFor(attributes);
	}	

}
