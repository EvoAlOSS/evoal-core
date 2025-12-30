package de.evoal.pipeline.impl.components.misc;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.core.api.ecore.TypedEObject;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Iterator;

@Dependent
@Named("de.evoal.pipeline.misc.constants")
public class ConstantFunction extends PipelineComponentImpl {

	private double [] constants = {};

	@Inject
	private AttributeEvaluator evaluator;

	@Override
	public @NonNull TypedEObject apply(final @NonNull TypedEObject obj) {
		final Iterator<EStructuralFeature> iterator = getWrites().iterator();
		int constantIndex = 0;

		while(iterator.hasNext()) {
			obj.eSet(iterator.next(), constants[constantIndex++]);
		}

		return obj;
	}

	@Override
	public PipelineComponentImpl init(final Instance configuration) throws InitializationException {
		super.init(configuration);

		constants = evaluator.attributeToDoubleArray(configuration, "constants");

		Requirements.requireSize(getWrites(), constants.length);

		return this;
	}
}
