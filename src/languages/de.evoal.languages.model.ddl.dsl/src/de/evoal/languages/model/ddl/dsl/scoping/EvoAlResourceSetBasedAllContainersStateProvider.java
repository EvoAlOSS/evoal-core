package de.evoal.languages.model.ddl.dsl.scoping;

import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.containers.IAllContainersState.Provider;
import org.eclipse.xtext.resource.containers.ResourceSetBasedAllContainersStateProvider;

public class EvoAlResourceSetBasedAllContainersStateProvider extends ResourceSetBasedAllContainersStateProvider{
	private final Provider delegate;

	public EvoAlResourceSetBasedAllContainersStateProvider(final Provider delegate) {
		this.delegate = delegate;
	}

	@Override
	public IAllContainersState get(final IResourceDescriptions context) {
		System.err.println("EvoAlResourceSetBasedAllContainersStateProvider.get(" + context + ")");
		IAllContainersState result = delegate.get(context);
		System.err.println("EvoAlResourceSetBasedAllContainersStateProvider.get() --> " + result);
		return result;
	}

}
