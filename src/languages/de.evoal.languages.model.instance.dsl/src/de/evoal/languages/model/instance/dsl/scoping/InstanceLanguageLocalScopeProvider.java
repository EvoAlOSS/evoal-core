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
	
	private final static EClass dataReference = ExpressionsPackage.eINSTANCE.getDataReference();
	private final static EReference dataDefinition = ExpressionsPackage.eINSTANCE.getDataReference_Definition();
	private final static EClass instance = ExpressionsPackage.eINSTANCE.getInstance();
	private final static EReference instanceDefinition = ExpressionsPackage.eINSTANCE.getInstance_Definition();
	private final static EReference attributeDefinition = ExpressionsPackage.eINSTANCE.getAttribute_Definition();

	@Inject
	private BaseLanguageLocalScopeProvider provider;

	@Override
	public IScope getScope(EObject context, EReference reference) {
		if(instance.isSuperTypeOf(context.eClass()) && attributeDefinition.equals(reference)) {
			return provider.getScope(context, reference);
		} else if(dataReference.equals(context.eClass()) && dataDefinition.equals(reference)) {
			return getResourceScope(IScope.NULLSCOPE, context, reference);
		} else if(instanceDefinition.equals(reference)) {
			return provider.getScope(context, reference);
		}

		return super.getScope(context, reference);
	}
}
