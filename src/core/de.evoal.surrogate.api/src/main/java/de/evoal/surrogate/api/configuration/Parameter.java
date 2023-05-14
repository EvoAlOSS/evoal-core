package de.evoal.surrogate.api.configuration;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.languages.model.base.Literal;
import de.evoal.surrogate.main.jackson.ReflectiveDeserializer;
import de.evoal.surrogate.main.jackson.ReflectiveSerializer;
import de.evoal.languages.model.base.Attribute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Parameter {
	private String name;

	@JsonDeserialize(using = ReflectiveDeserializer.class)
	@JsonSerialize(using = ReflectiveSerializer.class)
	private Object value;

	public static Parameter from(final Attribute attribute, final ExpressionEvaluator evaluator) {
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
