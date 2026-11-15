package de.evoal.surrogate.api.io.pson;

import lombok.*;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Parameter {
	private @NonNull String name;

	private @NonNull Object value;

	public static Parameter from(final String name, final Object value) {
		final Parameter parameter = new Parameter();
		parameter.setName(name);
		parameter.setValue(value);

		return parameter;
	}

	/*
	public static Parameter from(final EObject configuration, final EStructuralFeature feature, final AttributeEvaluator evaluator) {
    return from(feature.getName(), evaluator.attributeToObject(configuration, feature.getName()));
}
	 */

	public static Parameter from(final Parameter config) {
		final Parameter parameter = new Parameter();
		parameter.setName(config.getName());
		parameter.setValue(config.getValue());

		return parameter;
	}
}
