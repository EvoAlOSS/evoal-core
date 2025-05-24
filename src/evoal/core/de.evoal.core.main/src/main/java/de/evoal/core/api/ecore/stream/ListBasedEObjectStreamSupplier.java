package de.evoal.core.api.ecore.stream;

import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * A supplier of a stream of {@see TypedEObject} based on a list of {@see Properties}.
 */
@Slf4j
public class ListBasedEObjectStreamSupplier implements EObjectStreamSupplier {
    /**
     * The raw collection to stream
     */
    protected final List<TypedEObject> objects;

    /**
     * Creates a new {@see EObjectStreamSupplier} that is based on a collection of
     *   {@see TypedEObject} and a required {@see Space}.
     *
     * @param objects The collection of EObjects to stream.
     */
    public ListBasedEObjectStreamSupplier(final List<TypedEObject> objects) {
        this.objects = new ArrayList<>(objects);
    }

    @Override
    public Stream<TypedEObject> get() {
        return objects.stream();
    }

    public int size() {
        return objects.size();
    }
}
