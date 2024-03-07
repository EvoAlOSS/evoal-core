package de.evoal.core.api.properties;

import de.evoal.languages.model.base.Definition;
import lombok.NonNull;

import java.util.Objects;

/**
 * A property of the input or output domain is a simple label.
 */
public record PropertySpecification(@NonNull String name, Definition type) implements Comparable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertySpecification other = (PropertySpecification) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return "PropertySpecification [name=" + name + "]";
	}

	@Override
	public int compareTo(final Object other) {
		return name.compareTo(((PropertySpecification)other).name());
	}
}
