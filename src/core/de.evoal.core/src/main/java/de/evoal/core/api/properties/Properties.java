package de.evoal.core.api.properties;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class Properties {
    private final PropertiesSpecification specification;

    private final double[] values;

    public Properties(final PropertiesSpecification specification) {
        this.specification = specification;
        this.values = new double[specification.properties.size()];
    }

    public Properties(final PropertiesSpecification specification, final double[] data) {
        this(specification);

        System.arraycopy(data, 0, this.values, 0, data.length);
    }

    public Properties(final Properties other) {
        this(other.specification, other.values);
    }

    public static Properties create(final PropertiesSpecification spec, final Properties source) {
        final Properties result = new Properties(spec);

        for(final PropertySpecification ps : spec.getProperties()) {
            result.put(ps, source.get(ps));
        }

        return result;
    }

    public double get(int i) {
        return values[i];
    }

    public double get(final PropertySpecification spec) {
        return values[specification.indexOf(spec)];
    }

    public PropertiesSpecification getSpecification() {
        return specification;
    }

    public double[] getValues() {
        return values;
    }

    public final double put(final PropertySpecification property, double d) {
        final Integer index = specification.indices.get(property);

        if(index == null) {
            throw new IllegalStateException("Property is not registered.");
        }

        return put(index, d);
    }

    public final double put(final int index, double d) {
        return values[index] = d;
    }

    public void set(final int index, final double value) {
        values[index] = value;
    }

    public int size() {
        return values.length;
    }

    public String toString() {
        boolean notFirst = false;

        final StringBuilder builder = new StringBuilder();
        builder.append("<");

        for(int i = 0; i < values.length; ++i) {
            if(notFirst) {
                builder.append(", ");
            } else {
                notFirst = true;
            }

            builder.append(specification.properties.get(i));
            builder.append(" -> ");
            builder.append(values[i]);
        }

        builder.append(">");

        return builder.toString();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(values);
		result = prime * result + Objects.hash(specification);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Properties other = (Properties) obj;
		return Objects.equals(specification, other.specification) && Arrays.equals(values, other.values);
	}

    public boolean contains(final PropertiesSpecification otherSpec) {
        return specification.contains(otherSpec);
    }

    public Properties putAll(final Properties properties) {
        for(final PropertySpecification spec : getSpecification().getProperties()) {
            put(spec, properties.get(spec));
        }

        return this;
    }


    public Properties putAll(final Map<String, Double> values) {
        for(final PropertySpecification spec : getSpecification().getProperties()) {
            put(spec, values.get(spec.name()));
        }

        return this;
    }
}
