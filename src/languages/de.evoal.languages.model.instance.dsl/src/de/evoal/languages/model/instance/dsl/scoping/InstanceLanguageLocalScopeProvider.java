package de.evoal.languages.model.instance.dsl.scoping;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;

import com.google.inject.Inject;

import de.evoal.languages.model.base.AttributeDefinition;
import de.evoal.languages.model.base.BasePackage;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.base.TypeDefinition;
import de.evoal.languages.model.base.dsl.scoping.BaseLanguageLocalScopeProvider;
import de.evoal.languages.model.instance.InstancePackage;
import de.evoal.languages.model.utils.scoping.WildcardEnabledLocalScopeProvider;

public class InstanceLanguageLocalScopeProvider extends WildcardEnabledLocalScopeProvider {
	
	private final static EClass instance = BasePackage.eINSTANCE.getInstance();
	private final static EReference attributeDefinition = BasePackage.eINSTANCE.getAttribute_Definition();
	private static EReference dataDefinition = InstancePackage.eINSTANCE.getDataReference_Definition();
	private static EClass dataReference = InstancePackage.eINSTANCE.getDataReference();

	@Inject
	private BaseLanguageLocalScopeProvider provider;

	@Override
	public IScope getScope(EObject context, EReference reference) {
		try {
			System.err.println("[Inst Local] --> " + context.eClass().getName() + " --> " + reference.getEContainingClass().getName() + "." + reference.getName());
			
			if(instance.equals(context.eClass()) && attributeDefinition.equals(reference)) {
				return provider.getScope(context, reference);
			} else if(dataReference.equals(context.eClass()) && dataDefinition.equals(reference)) {
				return getResourceScope(IScope.NULLSCOPE, context, reference);
			}

			return super.getScope(context, reference);
		} finally {
			System.err.println("[Inst Local] --< " + context.eClass().getName() + " --> " + reference.getEContainingClass().getName() + "." + reference.getName());

		}
	}

}
