package de.evoal.languages.model.utils.scoping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

public class FilteringResourceDescriptionsStrategy extends DefaultResourceDescriptionStrategy {
	
	@Inject
	private IQualifiedNameProvider nameProvider;

	
	private final EClass[] classes;
	
	public FilteringResourceDescriptionsStrategy(final EClass ... classes) {
		this.classes = classes;
	}
	
	@Override
	public boolean createEObjectDescriptions(final EObject eObject, final IAcceptor<IEObjectDescription> acceptor) {
		for(final EClass clazz : classes) {
			if (clazz.equals(eObject.eClass())) {
				final QualifiedName fqnType = nameProvider.apply(eObject);

				if (fqnType == null) {
					return false;
				}
	
				acceptor.accept(EObjectDescription.create(fqnType, eObject));
				return true;
			}
		}

		return false;
	}
}