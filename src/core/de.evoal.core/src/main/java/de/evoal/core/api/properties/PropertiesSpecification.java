package de.evoal.core.api.properties;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PropertiesSpecification {
	public static class Builder {
		private final Set<PropertySpecification> properties = new TreeSet<>();

		public Builder() {
		}
		
		public Builder add(final Stream<String> names) {
			names.forEach(n -> properties.add(new PropertySpecification(n)));

			return this;
		}

		public Builder add(final PropertiesSpecification specification) {
			properties.addAll(specification.getProperties());

			return this;
		}

		public PropertiesSpecification build() {
			return new PropertiesSpecification(properties);
		}
	}

	final Map<PropertySpecification, Integer> indices = new HashMap<>();

	final List<PropertySpecification> properties;

	public PropertiesSpecification(final Collection<PropertySpecification> properties) {
		this.properties = new ArrayList<>(properties);

		for(int i = 0; i < this.properties.size(); ++i) {
			indices.put(this.properties.get(i), i);
		}
	}

	public PropertiesSpecification(final PropertySpecification property) {
		properties = new ArrayList<>();
		properties.add(property);

		for(int i = 0; i < properties.size(); ++i) {
			indices.put(properties.get(i), i);
		}
	}

	public PropertiesSpecification(final PropertiesSpecification other) {
		this(other.properties);
	}

	public static Builder builder() {
		return new Builder();
	}

	public boolean contains(final PropertiesSpecification spec) {
		return spec.properties
				.stream()
				.allMatch(indices::containsKey);
	}

	public boolean contains(final PropertySpecification spec) {
		return this.indices.containsKey(spec);
	}

	public PropertySpecification get(final int i) {
		return properties.get(i);
	}

	public List<PropertySpecification> getProperties() {
		return Collections.unmodifiableList(properties);
	}

	public int indexOf(final PropertySpecification spec) {
		return indices.get(spec);
	}

	public int size() {
		return properties.size();
	}

	public String toString() {
		return "PropertiesSpecification ["
				+ properties
					.stream()
					.map(PropertySpecification::name)
					.collect(Collectors.joining(","))
				+ "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PropertiesSpecification that = (PropertiesSpecification) o;
		return properties.equals(that.properties);
	}

	@Override
	public int hashCode() {
		return Objects.hash(properties);
	}
}
