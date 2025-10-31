package de.evoal.surrogate.simple.identity;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.surrogate.api.function.ModelFunction;

@Slf4j
public class IdentityFunction extends ModelFunction {
	public IdentityFunction(final Space input, final Space output) {
		super("de.evoal.surrogate.simple.ml.identity-learner", input, output);

		log.info("Using identity mapping from {} to {}.", input, output);
	}

	@Override
	public void apply(final @NonNull TypedEObject input, final @NonNull TypedEObject output) {
		for(final EStructuralFeature feature : output.eClass().getEAllStructuralFeatures()) {
			output.eSet(feature, input.eGet(feature));
		}
	}
}
