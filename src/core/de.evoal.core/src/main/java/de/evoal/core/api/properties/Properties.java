package de.evoal.core.api.properties;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class Properties {
    private final PropertiesSpecification specification;

    private final Object[] values;

    public Properties(final PropertiesSpecification specification) {
        this.specification = specification;
        this.values = new Object[specification.properties.size()];
    }

    public Properties(final PropertiesSpecification specification, final Object[] data) {
        this(specification);

        System.arraycopy(data, 0, this.values, 0, data.length);
    }

    public Properties(final PropertiesSpecification specification, final double[] data) {
        this(specification);

        for(int i = 0; i < data.length; ++i) {
            this.values[i] = data[i];
        }
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

    public Object get(int i) {
        return values[i];
    }

    public Double getAsDouble(int i) {
        return (Double)values[i];
    }

    public Integer getAsInteger(int i) {
        return (Integer)values[i];
    }

    public Object get(final PropertySpecification spec) {
        return values[specification.indexOf(spec)];
    }

    public Double getAsDouble(final PropertySpecification spec) {
        return (Double)values[specification.indexOf(spec)];
    }

    public Integer getAsInteger(final PropertySpecification spec) {
        return (Integer)values[specification.indexOf(spec)];
    }

    public PropertiesSpecification getSpecification() {
        return specification;
    }

    public Object[] getValues() {
        return values;
    }

    public double[] getValuesAsDouble() {
        final double [] values = new double[this.values.length];

        for(int i = 0; i < values.length; ++i) {
            // TODO I think we should link the properties to the corresponding data and use the type information we have to cast this correctly.
            values[i] = ((Number)this.values[i]).doubleValue();
        }

        return values;
    }

    public final Object put(final PropertySpecification property, Object d) {
        final Integer index = specification.indices.get(property);

        if(index == null) {
            throw new IllegalStateException("Property is not registered.");
        }

        return put(index, d);
    }

    public final Object put(final int index, Object d) {
        return values[index] = d;
    }

    public void set(final int index, final Object value) {
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


    public Properties putAll(final Map<String, Object> values) {
        for(final PropertySpecification spec : getSpecification().getProperties()) {
            put(spec, values.get(spec.name()));
        }

        return this;
    }
}
