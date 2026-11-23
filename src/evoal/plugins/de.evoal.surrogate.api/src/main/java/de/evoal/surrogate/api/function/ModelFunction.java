package de.evoal.surrogate.api.function;

import lombok.Getter;
import lombok.NonNull;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

/**
 * Base class for regression functions storing the input and output properties.
 */
public abstract class ModelFunction {

	/**
	 * Input space of the partial surrogate function.
	 */
	@Getter
	protected final Space input;

	/**
	 * The model name used for CDI.
	 */
	@Getter
	private final String modelName;

	/**
	 * Output space of the partial surrogate function.
	 */
	@Getter
	protected final Space output;

	public ModelFunction(final String name, final Space input, final Space output) {
		this.modelName = name;
		this.input = input;
		this.output = output;
	}

	/**
	 * Applies the regression to {@code input} and returns the calculated
	 *   value.
	 *
	 * @param input The input properties for the regression.
	 * @return The parameter.
	 */
	public abstract void apply(final @NonNull TypedEObject input, final @NonNull TypedEObject output);

	/**
	 * Whether several threads may {@linkplain #apply(TypedEObject, TypedEObject) apply} the
	 *   model to different objects at the same time. A surrogate whose model and prediction
	 *   pipeline are thread-safe evaluates the candidates of a batch in parallel.
	 *
	 * @return {@code true} iff {@link #apply(TypedEObject, TypedEObject)} is thread-safe;
	 *   {@code false} by default.
	 */
	public boolean isThreadSafe() {
		return false;
	}
}
