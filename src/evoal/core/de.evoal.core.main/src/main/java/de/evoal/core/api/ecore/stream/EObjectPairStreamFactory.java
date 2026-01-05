package de.evoal.core.api.ecore.stream;

import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.core.api.ecore.Space;
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
        } else {

        }


        throw new UnsupportedOperationException();
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
}
