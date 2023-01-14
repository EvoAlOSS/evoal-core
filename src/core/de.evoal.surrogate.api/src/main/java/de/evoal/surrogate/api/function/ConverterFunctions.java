package de.evoal.surrogate.api.function;

import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.ddl.RepresentationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

/**
 * Helper class for creating dynamic converter functions that requires casting of
 */
public final class ConverterFunctions {
    private final static Logger log = LoggerFactory.getLogger(ConverterFunctions.class);

    private ConverterFunctions() {}

    public static Function<Properties, Object> convert(final RepresentationType iType, final RepresentationType oType, final int index) {
        if(RepresentationType.REAL.equals(iType)) {
            return o -> convertDoubleTo(oType).apply((Double)o.get(index));
        } else if(RepresentationType.INTEGER.equals(iType)) {
            return o -> convertIntegerTo(oType).apply((Integer)o.get(index));
        } else if(RepresentationType.BOOLEAN.equals(iType)) {
            return o -> convertBooleanTo(oType).apply((Boolean)o.get(index));
        } else {
            log.error("Cannot create converter from {} to {}.", iType, oType);
            throw new IllegalArgumentException("Cannot create converter from " + iType + " to " + oType);
        }

    }

    public static Function<Double, Object> convertDoubleTo(final RepresentationType type) {
        if(RepresentationType.REAL.equals(type)) {
            return v -> v;
        } else if(RepresentationType.INTEGER.equals(type)) {
            return v -> v.intValue();
        } else if(RepresentationType.BOOLEAN.equals(type)) {
            return v -> v.intValue() != 0;
        } else {
            log.error("Cannot create cast from double to {}.", type);
            throw new IllegalArgumentException("Cannot create cast from double to " + type);
        }
    }

    public static Function<Integer, Object> convertIntegerTo(final RepresentationType type) {
        if(RepresentationType.REAL.equals(type)) {
            return v -> v.doubleValue();
        } else if(RepresentationType.INTEGER.equals(type)) {
            return v -> v;
        } else if(RepresentationType.BOOLEAN.equals(type)) {
            return v -> v != 0;
        } else {
            log.error("Cannot create cast from int to {}.", type);
            throw new IllegalArgumentException("Cannot create cast from double to " + type);
        }
    }

    public static Function<Boolean, Object> convertBooleanTo(final RepresentationType type) {
        if(RepresentationType.REAL.equals(type)) {
            return v -> v ? 1.0 : 0.0;
        } else if(RepresentationType.INTEGER.equals(type)) {
            return v -> v ? 1 : 0;
        } else if(RepresentationType.BOOLEAN.equals(type)) {
            return v -> v;
        } else {
            log.error("Cannot create cast from boolean to {}.", type);
            throw new IllegalArgumentException("Cannot create cast from double to " + type);
        }
    }

    public static Function<Properties, Double> convertToDouble(final RepresentationType type, final int index) {
        if(RepresentationType.REAL.equals(type)) {
            return p -> p.getAsDouble(index);
        } else if(RepresentationType.INTEGER.equals(type)) {
            return p -> ((Number)p.get(index)).doubleValue();
        } else if(RepresentationType.BOOLEAN.equals(type)) {
            return p -> ((Boolean)p.get(index)) ? 1.0 : 0.0;
        } else {
            log.error("Cannot create cast from {} to double.", type);
            throw new IllegalArgumentException("Cannot create cast from " + type + " to double");
        }
    }
}
