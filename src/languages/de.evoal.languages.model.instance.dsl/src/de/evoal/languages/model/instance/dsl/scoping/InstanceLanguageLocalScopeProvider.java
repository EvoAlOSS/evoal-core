package de.evoal.languages.model.instance.dsl.scoping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;

import com.google.inject.Inject;

import de.evoal.languages.model.base.dsl.scoping.BaseLanguageLocalScopeProvider;
import de.evoal.languages.model.base.expressions.ExpressionsPackage;
import de.evoal.languages.model.utils.scoping.WildcardEnabledLocalScopeProvider;

public class InstanceLanguageLocalScopeProvider extends WildcardEnabledLocalScopeProvider {
	private static EClass instance = ExpressionsPackage.eINSTANCE.getInstance();
	private static EReference attributeDefinition = ExpressionsPackage.eINSTANCE.getAttribute_Definition();

	@Inject
	private BaseLanguageLocalScopeProvider instanceScopes;


	@Override
	public IScope getScope(final EObject context, final EReference reference) {
		if(instance.isSuperTypeOf(context.eClass()) && (attributeDefinition.equals(reference))) {
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
	}
}
