package de.evoal.languages.model.generator.dsl.scoping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;

import com.google.inject.Inject;

import de.evoal.languages.model.base.BasePackage;
import de.evoal.languages.model.instance.InstancePackage;
import de.evoal.languages.model.instance.dsl.scoping.InstanceLanguageLocalScopeProvider;
import de.evoal.languages.model.utils.scoping.WildcardEnabledLocalScopeProvider;

public class GeneratorDSLLocalScopeProvider extends WildcardEnabledLocalScopeProvider {
	private static EReference dataDefinition = InstancePackage.eINSTANCE.getDataReference_Definition();
	private static EClass dataReference = InstancePackage.eINSTANCE.getDataReference();
	private static EClass instance = BasePackage.eINSTANCE.getInstance();
	private static EReference attributeDefinition = BasePackage.eINSTANCE.getAttribute_Definition();
	
	@Inject
	private InstanceLanguageLocalScopeProvider instanceScopes;
	
	@Override
	public IScope getScope(final EObject context, final EReference reference) {
		try {
			System.err.println("[Gene Local ] --> " + context.eClass().getName() + " --> " + reference.getEContainingClass().getName() + "." + reference.getName());
	
			if(instance.equals(context.eClass()) && (attributeDefinition.equals(reference))) {
				// inject fields of types
				IScope typeScope = IScope.NULLSCOPE;
				try {
					typeScope = instanceScopes.getScope(context, reference);
				} catch(final NullPointerException e) {
					System.err.println(e);
				}
				
				return getLocalElementsScope(typeScope, context, reference);
			} else/* if(dataReference.equals(context.eClass()) && dataDefinition.equals(reference)) {
				// inject fields of types
				IScope typeScope = IScope.NULLSCOPE;
				try {
					typeScope = instanceScopes.getScope(context, reference);
				} catch(final NullPointerException e) {
					System.err.println(e);
				}
				
				return getLocalElementsScope(typeScope, context, reference);
			}*/
		/*else if(context instanceof Problem && instanceDefinition.equals(reference)) {
			IScope result = super.getScope(context, reference);;
			 
			System.err.println(result);
		}
*/
			return super.getScope(context, reference);
		} finally {
			System.err.println("[Gene Local ] --< " + context.eClass().getName() + " --> " + reference.getEContainingClass().getName() + "." + reference.getName());			
		}
	}	

}
