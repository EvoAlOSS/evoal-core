package de.evoal.core.api.ecore.stream;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Finds the rows of a data set that have no value for a feature, i.e. the feature is unset
 *   (e.g. a missing value of an ARFF file), and reports them once per data set. A value equal
 *   to the default (0, 0.0, false) is a value: the data attributes are unsettable (#355).
 */
@Slf4j
final class MissingValues {
    private MissingValues() {
    }

    /**
     * @return {@code true} if the object has a value for every feature.
     */
    static boolean complete(final EObject object, final Collection<EStructuralFeature> features) {
        return features.stream().allMatch(object::eIsSet);
    }

    /**
     * @return The features that the object has no value for, in the order of the features.
     */
    static List<EStructuralFeature> missing(final EObject object, final Collection<EStructuralFeature> features) {
        return features.stream()
                       .filter(feature -> !object.eIsSet(feature))
                       .toList();
    }

    /**
     * Logs one warning for the rows that are left out because they have no value for a feature,
     *   with their number, the number of rows and the features without a value.
     *
     * @param rows The rows of the data set.
     * @param missing The features without a value of a row.
     */
    static <T> void report(final Supplier<Stream<T>> rows, final Function<T, List<EStructuralFeature>> missing) {
        final Set<String> names = new LinkedHashSet<>();
        final int[] counts = new int[2];

        try(final Stream<T> stream = rows.get()) {
            stream.forEach(row -> {
                ++counts[0];
                final List<EStructuralFeature> features = missing.apply(row);
                if(!features.isEmpty()) {
                    ++counts[1];
                    features.forEach(feature -> names.add(feature.getName()));
                }
            });
        }

        if(counts[1] > 0) {
            log.warn("Leaving out {} of {} rows that have no value for {}.", counts[1], counts[0],
                     names.stream().map(name -> "'" + name + "'").collect(Collectors.joining(", ")));
        }
    }
}
