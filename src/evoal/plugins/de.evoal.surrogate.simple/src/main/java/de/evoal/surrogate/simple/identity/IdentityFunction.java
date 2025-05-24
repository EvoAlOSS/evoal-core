package de.evoal.surrogate.simple.identity;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunction;

@Slf4j
public class IdentityFunction extends AbstractPartialSurrogateFunction {
	public IdentityFunction(final PartialFunctionConfiguration configuration, final Space input, final Space output) {
		super(configuration, Collections.emptyList(), input, output);

		log.info("Using identity mapping from {} to {}.", input, output);
	}

	@Override
	public void apply(final @NonNull TypedEObject input, final @NonNull TypedEObject output) {
		for(final EStructuralFeature feature : output.eClass().getEAllStructuralFeatures()) {
			output.eSet(feature, input.eGet(feature));
		}
	}
}
