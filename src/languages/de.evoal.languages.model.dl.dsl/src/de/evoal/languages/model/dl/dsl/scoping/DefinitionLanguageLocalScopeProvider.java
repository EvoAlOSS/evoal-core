package de.evoal.languages.model.dl.dsl.scoping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;

import com.google.inject.Inject;

import de.evoal.languages.model.base.dsl.scoping.BaseLanguageLocalScopeProvider;
import de.evoal.languages.model.base.expressions.ExpressionsPackage;
import de.evoal.languages.model.utils.scoping.WildcardEnabledLocalScopeProvider;

public class DefinitionLanguageLocalScopeProvider extends WildcardEnabledLocalScopeProvider {
	private final static EReference attributeDefinition = ExpressionsPackage.eINSTANCE.getAttribute_Definition();
	private final static EClass instance = ExpressionsPackage.eINSTANCE.getInstance();
	
	@Inject
	private BaseLanguageLocalScopeProvider provider;
	
	@Override
	public IScope getScope(final EObject context, final EReference reference) {
		if(instance.equals(context.eClass()) && attributeDefinition.equals(reference)) {
			return provider.getScope(context, reference);
		}
		
		return super.getScope(context, reference);
	}	
}
