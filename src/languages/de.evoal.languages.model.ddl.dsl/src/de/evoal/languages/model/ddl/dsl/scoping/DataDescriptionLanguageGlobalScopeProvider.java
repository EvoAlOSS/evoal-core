package de.evoal.languages.model.ddl.dsl.scoping;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

import javax.inject.Inject;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.eclipse.xtext.util.IResourceScopeCache;

import com.google.inject.Provider;

import de.evoal.languages.model.ddl.DdlPackage;

public class DataDescriptionLanguageGlobalScopeProvider extends ImportUriGlobalScopeProvider {
	@Inject
	private IResourceDescription.Manager descriptionManager;

	@Inject
	private IResourceScopeCache cache;


	@Override
	protected LinkedHashSet<URI> getImportedUris(final Resource resource) {
		return cache.get("ddl-cache", resource, new Provider<LinkedHashSet<URI>>() {
			@Override
			public LinkedHashSet<URI> get() {
				final LinkedHashSet<URI> uniqueImportURIs = collectImportUris(resource, new LinkedHashSet<URI>(5));

				final Iterator<URI> uriIter = uniqueImportURIs.iterator();
				while(uriIter.hasNext()) {
					if(!EcoreUtil2.isValidUri(resource, uriIter.next()))
						uriIter.remove();
				}
				
				return uniqueImportURIs;
			}

			private LinkedHashSet<URI> collectImportUris(final Resource resource, final LinkedHashSet<URI> uniqueImportURIs) {
				final IResourceDescription resourceDescription = descriptionManager.getResourceDescription(resource);
				Iterable<IEObjectDescription> models = resourceDescription.getExportedObjectsByType(DdlPackage.Literals.DATA_DESCRIPTION_MODEL);
				

				models.forEach(it -> {
					String userData = it.getUserData(DataDescriptionLanguageResourceDescriptionStrategy.USES);

					if(userData != null) {
						Arrays.stream(userData.split(","))
							  .forEach(uri -> {
									URI includedUri = URI.createURI(uri);
									includedUri = includedUri.resolve(resource.getURI());
									if(uniqueImportURIs.add(includedUri)) {
										collectImportUris(resource.getResourceSet().getResource(includedUri, true), uniqueImportURIs);
									}
							  });
					}
				});

				return uniqueImportURIs;
			}
		});
	}
}
