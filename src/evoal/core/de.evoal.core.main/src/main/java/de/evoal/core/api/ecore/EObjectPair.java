package de.evoal.core.api.ecore;

import de.evoal.core.api.properties.Properties;
import org.apache.commons.math3.util.Pair;

/**
 * A pair of properties.
 */
public class EObjectPair extends Pair<TypedEObject, TypedEObject> {
    public EObjectPair(TypedEObject first, TypedEObject second) {
        super(first, second);
    }

    public EObjectPair(Pair<? extends TypedEObject, ? extends TypedEObject> entry) {
        super(entry);
    }
}
