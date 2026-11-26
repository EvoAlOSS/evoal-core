package de.evoal.core.api.ecore.stream;

import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import de.evoal.core.api.utils.Requirements;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

/**
 * Factory for creating the perfect EObjectPair stream.
 *
 * Working with two EObjects is tricky as the EStructuralFeatures of these
 *   EStructuralFeatures are not equal (what we want).
 * <p>
 * If both spaces share one class, a row without a value for a feature of either space (an
 *   unset feature, e.g. a missing value of an ARFF file) is left out; a supplier reports the
 *   left-out rows once, when it is used first. A value equal to the default (0, 0.0, false) is
 *   a value, since the data attributes are unsettable (#355).
 */
@Slf4j
public class EObjectPairStreamFactory {
    public static EObjectPairStreamSupplier createFromList(final @NonNull Space first, final @NonNull Space second, final @NonNull EObjectStreamSupplier base) {
        log.info("Creating supplier for {} and {}.", first, second);

        if(first.getEClass() == second.getEClass()) {
            final List<EStructuralFeature> features = featuresOf(first, second);
            final AtomicBoolean reported = new AtomicBoolean();

            return () -> {
                if(!reported.getAndSet(true)) {
                    MissingValues.report(base, obj -> MissingValues.missing(obj, features));
                }

                return base.get()
                           .filter(obj -> MissingValues.complete(obj, features))
                           .map(obj -> new EObjectPair(obj, obj));
            };
        }

        // the projection copies every value; a feature without a value gets its default
        return () -> base.get()
                         .map(point -> new EObjectPair(project(point, first), project(point, second)));
    }

    public static EObjectPairStreamSupplier createFromList(final @NonNull Space first, final @NonNull Space second, final @NonNull EObjectPairStreamSupplier base) {
        log.info("Creating supplier for {} and {}.", first, second);

        if(first.getEClass() == second.getEClass()) {
            final AtomicBoolean reported = new AtomicBoolean();

            return () -> {
                if(!reported.getAndSet(true)) {
                    MissingValues.report(base, pair -> missing(pair, first, second));
                }

                return base.get()
                           .filter(pair -> complete(pair, first, second));
            };
        }
        throw new UnsupportedOperationException();
    }

    public static EObjectPairStreamSupplier createFromList(final @NonNull Space first, final @NonNull Space second, final @NonNull List<EObjectPair> base) {
        log.info("Creating supplier for {} and {}.", first, second);

        if(first.getEClass() == second.getEClass()) {
            final AtomicBoolean reported = new AtomicBoolean();

            return () -> {
                if(!reported.getAndSet(true)) {
                    MissingValues.report(base::stream, pair -> missing(pair, first, second));
                }

                return base.stream()
                           .filter(pair -> complete(pair, first, second));
            };
        }

        throw new UnsupportedOperationException();
    }

    /**
     * @return The features of both spaces, each once, in the order of the spaces.
     */
    private static List<EStructuralFeature> featuresOf(final Space first, final Space second) {
        final List<EStructuralFeature> features = new ArrayList<>(first);
        second.stream()
              .filter(feature -> !features.contains(feature))
              .forEach(features::add);

        return features;
    }

    /**
     * @return {@code true} if the first object of the pair has a value for every feature of the
     *   first space and the second object for every feature of the second space.
     */
    private static boolean complete(final EObjectPair pair, final Space first, final Space second) {
        return MissingValues.complete(pair.getFirst(), first) && MissingValues.complete(pair.getSecond(), second);
    }

    /**
     * @return The features of the pair without a value, those of the first object first.
     */
    private static List<EStructuralFeature> missing(final EObjectPair pair, final Space first, final Space second) {
        final List<EStructuralFeature> missing = new ArrayList<>(MissingValues.missing(pair.getFirst(), first));
        MissingValues.missing(pair.getSecond(), second)
                     .stream()
                     .filter(feature -> !missing.contains(feature))
                     .forEach(missing::add);

        return missing;
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
