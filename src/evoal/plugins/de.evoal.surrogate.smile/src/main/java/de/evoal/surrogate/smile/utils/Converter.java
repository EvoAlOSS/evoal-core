package de.evoal.surrogate.smile.utils;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.function.Function;

public class Converter {
    private Converter() { }

    /**
     * Creates a data converter function based on the given properties specification.
     */
    public static Function<TypedEObject, double[]> create(final Space specification) {
        final Function<TypedEObject, Double>[] converters = new Function[specification.size()];

        int index = 0;
        for(final EStructuralFeature feature : specification) {
            converters[index++] = obj -> obj.eGetAsDouble(feature);
        }

        return p -> {
            double [] values = new double [converters.length];
            for(int i = 0; i < values.length; ++i) {
                values[i] = converters[i].apply(p);
            }

            return values;
        };
    }
}
