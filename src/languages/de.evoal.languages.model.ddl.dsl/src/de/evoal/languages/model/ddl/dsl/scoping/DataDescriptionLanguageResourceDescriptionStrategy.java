package de.evoal.languages.model.ddl.dsl.scoping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.util.IAcceptor;

import de.evoal.languages.model.ddl.DataDescriptionModel;

import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;

public class DataDescriptionLanguageResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {
	public static final String USES = "uses";
			
	@Inject
	private ImportUriResolver uriResolver;
	
	@Override
	public boolean createEObjectDescriptions(final EObject eObject, final IAcceptor<IEObjectDescription> acceptor) {
		if(eObject instanceof DataDescriptionModel) {
			this.createEObjectDescriptionForModel((DataDescriptionModel)eObject, acceptor);
			return true;
		} else {
			return super.createEObjectDescriptions(eObject, acceptor);
		}
	}

	private void createEObjectDescriptionForModel(final DataDescriptionModel model, final IAcceptor<IEObjectDescription> acceptor) {
		final List<String> uris = new ArrayList<>();

		model.getUses().forEach(it -> uris.add(uriResolver.apply(it)));
		
		final Map<String, String> userData = new HashMap<>();
		userData.put(USES, String.join(",", uris));

		acceptor.accept(EObjectDescription.create(QualifiedName.create(model.eResource().getURI().toString()), model, userData));
	}

}
