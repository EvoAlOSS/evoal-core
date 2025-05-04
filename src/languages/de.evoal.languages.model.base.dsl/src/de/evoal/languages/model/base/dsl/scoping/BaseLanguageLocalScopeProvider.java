package de.evoal.languages.model.base.dsl.scoping;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;

import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.definitions.TypeDefinition;
import de.evoal.languages.model.base.expressions.ExpressionsPackage;
import de.evoal.languages.model.utils.scoping.WildcardEnabledLocalScopeProvider;

public class BaseLanguageLocalScopeProvider extends WildcardEnabledLocalScopeProvider {
	
	private static EClass instance = ExpressionsPackage.eINSTANCE.getInstance();
	private static EReference instanceDefinition = ExpressionsPackage.eINSTANCE.getInstance_Definition();
 	
	@Override
	public IScope getScope(final EObject context, final EReference reference) {
		if(instance.isSuperTypeOf(context.eClass()) && instanceDefinition.equals(reference)) {
			// inject fields of types
			final Instance instance = (Instance)context;
			IScope typeScope = IScope.NULLSCOPE;
			if(instance.getDefinition() != null) {
				typeScope = this.getScope(instance.getDefinition(), reference);
			}
			
			return getLocalElementsScope(typeScope, context, reference);
		}  else if(instance.isSuperTypeOf(context.eClass()) && ExpressionsPackage.eINSTANCE.getAttribute_Definition().equals(reference)) {
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

		return Scopes.scopeFor(attributes);
	}	

}
