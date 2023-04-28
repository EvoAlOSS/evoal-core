package de.evoal.languages.model.ddl.dsl.scoping;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.DescriptionAddingContainer;
import org.eclipse.xtext.resource.containers.FilterUriContainer;
import org.eclipse.xtext.resource.containers.IAllContainersState.Provider;
import org.eclipse.xtext.resource.containers.ResourceSetBasedAllContainersStateProvider;
import org.eclipse.xtext.resource.containers.StateBasedContainerManager;

public class EvoAlReleaseStateBasedContainerManager extends StateBasedContainerManager {
	public EvoAlReleaseStateBasedContainerManager() {
		System.err.println("xxx");
	}
	/*
	@Override
	public IContainer getContainer(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		Provider p = getStateProvider();
		if(!(p instanceof EvoAlResourceSetBasedAllContainersStateProvider)) {
			setStateProvider(new EvoAlResourceSetBasedAllContainersStateProvider(p));
		}
		
		System.err.println("EvoAlReleaseStateBasedContainerManager.getContainer(" + desc + ", " + resourceDescriptions + ")");
		final IContainer container = super.getContainer(desc, resourceDescriptions);
		System.err.println("EvoAlReleaseStateBasedContainerManager.gerContainer() --> " + container);
		return container;
	}

	@Override
	public List<IContainer> getVisibleContainers(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		Provider p = getStateProvider();
		if(!(p instanceof EvoAlResourceSetBasedAllContainersStateProvider)) {
			setStateProvider(new EvoAlResourceSetBasedAllContainersStateProvider(p));
		}
		
		System.err.println("EvoAlReleaseStateBasedContainerManager.getVisibleContainers(" + desc + ", " + resourceDescriptions + ")");
		final List<IContainer> containers = super.getVisibleContainers(desc, resourceDescriptions);
		
		final URI uri = URI.createURI("/Users/berber/repositories/evoal/source--evoal-core/src/core/de.evoal.core.main/target/core.main/core.main-0.9.0-SNAPSHOT.jar#/de/evoal/core/constraint.dl");
		
		System.err.println("EvoAlReleaseStateBasedContainerManager.getVisibleContainers() --> " + containers);
		return containers;
	}
*/
}