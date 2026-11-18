package de.evoal.core.api.ecore.stream;

import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import de.evoal.core.api.utils.Requirements;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Stream;

/**
 * Factory for creating the perfect EObjectPair stream.
 *
 * Working with two EObjects is tricky as the EStructuralFeatures of these
 *   EStructuralFeatures are not equal (what we want).
 */
@Slf4j
public class EObjectPairStreamFactory {
    public static EObjectPairStreamSupplier createFromList(final @NonNull Space first, final @NonNull Space second, final @NonNull EObjectStreamSupplier base) {
        log.info("Creating supplier for {} and {}.", first, second);

        if(first.getEClass() == second.getEClass()) {
            return new EObjectPairStreamSupplier() {
                @Override
                public Stream<EObjectPair> get() {
                    return base.get()
                            .filter(obj -> first.stream().allMatch(obj::eIsSet))
                            .filter(obj -> second.stream().allMatch(obj::eIsSet))
                            .map(obj -> new EObjectPair(obj, obj));
                }
            };
        }

        // no eIsSet filter as above: EMF reports a value equal to the default (e.g. 0.0) as
        //   unset, which would drop such points
        return () -> base.get()
                         .map(point -> new EObjectPair(project(point, first), project(point, second)));
    }

    public static EObjectPairStreamSupplier createFromList(final @NonNull Space first, final @NonNull Space second, final @NonNull EObjectPairStreamSupplier base) {
        log.info("Creating supplier for {} and {}.", first, second);

        if(first.getEClass() == second.getEClass()) {
            return new EObjectPairStreamSupplier() {
                @Override
                public Stream<EObjectPair> get() {
                    return base.get()
                            .filter(obj -> first.stream().allMatch(f -> obj.getFirst().eIsSet(f)))
                            .filter(obj -> second.stream().allMatch(f -> obj.getSecond().eIsSet(f)));
                }
            };
        }
        throw new UnsupportedOperationException();
    }

    public static EObjectPairStreamSupplier createFromList(final @NonNull Space first, final @NonNull Space second, final @NonNull List<EObjectPair> base) {
        log.info("Creating supplier for {} and {}.", first, second);

        if(first.getEClass() == second.getEClass()) {
            return new EObjectPairStreamSupplier() {
                @Override
                public Stream<EObjectPair> get() {
                    return base.stream()
                            .filter(obj -> first.stream().allMatch(obj.getFirst()::eIsSet))
                            .filter(obj -> second.stream().allMatch(obj.getSecond()::eIsSet));
                }
            };
        } else {

        }


        throw new UnsupportedOperationException();
    }

    /**
     * @param point An object whose class contains the features of the space by name (e.g.
     *   an object of a merged space).
     * @param space The space to project to.
     * @return A new object of the space with the values of the point.
     */
    private static TypedEObject project(final EObject point, final Space space) {
        final TypedEObject projection = space.newEObject();

        for(final EStructuralFeature feature : space) {
            final EStructuralFeature pointFeature = point.eClass().getEStructuralFeature(feature.getName());
            final Object value = point.eGet(pointFeature);
            projection.eSet(feature, value);
        }

        return projection;
    }
}
