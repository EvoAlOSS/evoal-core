package de.evoal.core.api.properties;

import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.definitions.DataDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PropertiesSpecification {
	/**
	 * Logger instance.
	 */
	private static final Logger log = LoggerFactory.getLogger(PropertiesSpecification.class);

    public static class Builder {

		private final Set<PropertySpecification> properties = new TreeSet<>();


		private final List<PropertySpecification> orderedProperties = new ArrayList<>(20);

		public Builder() {
		}

		public Builder add(final Stream<? extends Definition> data) {
			data.map(d -> new PropertySpecification(d.getName(), d))
				.filter(s -> !properties.contains(s))
				.peek(properties::add)
				.forEach(orderedProperties::add);


			return this;
		}

		public Builder addDescriptions(final Stream<DataDescription> data) {
			data.map(d -> new PropertySpecification(d.getName(), d))
					.filter(s -> !properties.contains(s))
					.peek(properties::add)
					.forEach(orderedProperties::add);


			return this;
		}

		public Builder add(final PropertiesSpecification specification) {
			specification.getProperties()
							.stream()
							.filter(s -> !properties.contains(s))
							.peek(properties::add)
							.forEach(orderedProperties::add);

			return this;
		}

		public Builder add(final PropertySpecification specification) {
			if(!properties.contains(specification)) {
				properties.add(specification);
				orderedProperties.add(specification);
			}

			return this;
		}

		public Builder add(final Collection<PropertySpecification> data) {
			data.stream()
				.filter(s -> !properties.contains(s))
				.peek(properties::add)
				.forEach(orderedProperties::add);

			return this;
		}

		public PropertiesSpecification build() {
			return new PropertiesSpecification(orderedProperties);
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

	public boolean contains(final String name) {
		return this.properties.stream().anyMatch(p -> p.name().equals(name));
	}


	public PropertySpecification find(final String name) {
		return properties.get(indexOf(name));
	}

	public PropertySpecification get(final int i) {
		return properties.get(i);
	}

	public List<PropertySpecification> getProperties() {
		return Collections.unmodifiableList(properties);
	}

	public int indexOf(final PropertySpecification spec) {
		final int index = indices.get(spec);

		if(index == -1) {
			log.error("Cannot find {} in {}.", spec, this);
			throw new RuntimeException("Cannot find " + spec + " in " + this);
		}

		return index;
	}

	public int indexOf(final String name) {
		return indices.get(new PropertySpecification(name, null));
	}

	public int size() {
		return properties.size();
	}

	public String toString() {
		return "PropertiesSpecification ["
				+ properties
					.stream()
					.map(PropertySpecification::name)
					.collect(Collectors.joining(", "))
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
