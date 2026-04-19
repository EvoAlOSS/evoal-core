package de.evoal.surrogate.api.io.pson;

import lombok.*;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.base.expressions.Attribute;

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

	public static Parameter from(final Attribute attribute, final AttributeEvaluator evaluator) {
		final Parameter parameter = new Parameter();
		parameter.setName(attribute.getDefinition().getName());
		parameter.setValue(evaluator.attributeToObject(attribute));

		return parameter;
	}

	public static Parameter from(final Parameter config) {
		final Parameter parameter = new Parameter();
		parameter.setName(config.getName());
		parameter.setValue(config.getValue());

		return parameter;
	}
}
