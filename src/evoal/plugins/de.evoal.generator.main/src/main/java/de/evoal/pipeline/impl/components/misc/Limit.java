package de.evoal.pipeline.impl.components.misc;

import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import lombok.Getter;
import lombok.NonNull;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Iterator;

@Dependent
@Named("de.evoal.pipeline.misc.limit")
public class Limit extends PipelineComponentImpl {

	@Getter
	private int limit;

	@Inject
	private AttributeEvaluator evaluator;

	@Override
	public @NonNull TypedEObject apply(final @NonNull TypedEObject obj) {
		return obj;
	}

	@Override
	public PipelineComponentImpl init(final Instance configuration) throws InitializationException {
		super.init(configuration);

		limit = evaluator.attributeToInteger(configuration, "count");

		return this;
	}
}
