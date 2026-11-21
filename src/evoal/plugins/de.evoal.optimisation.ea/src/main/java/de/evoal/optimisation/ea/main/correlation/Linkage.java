package de.evoal.optimisation.ea.main.correlation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.correlations.BuildingBlock;
import de.evoal.optimisation.api.correlations.Correlation;
import de.evoal.optimisation.api.correlations.Correlations;
import de.evoal.optimisation.api.correlations.LinkageGroup;

/**
 * Keeps the features of a group together after a crossover (linkage), at the level of
 *   features and independent of the representation of the genes. The groups are building
 *   blocks and correlated pairs of the DDL. The linkage of a building block is the
 *   probability that crossover preserves it (G. R. Harik, D. E. Goldberg: Learning linkage.
 *   Foundations of Genetic Algorithms 4, 1996, pp. 247-262, section 2).
 */
public final class Linkage {
    /**
     * The features of the groups.
     */
    private final Set<EStructuralFeature> features;

    /**
     * The groups, in the order of the DDL.
     */
    private final List<LinkageGroup> groups;

    /**
     * @param groups The groups, in the order of the DDL.
     */
    public Linkage(final List<? extends LinkageGroup> groups) {
        this.groups = List.copyOf(groups);

        final Set<EStructuralFeature> all = new LinkedHashSet<>();
        groups.forEach(group -> all.addAll(group.features()));
        this.features = Set.copyOf(all);
    }

    /**
     * @param declared The correlations and the building blocks of the problem.
     * @param transfer Selects the used correlations ({@link CorrelationTransfer#correlations()}).
     * @return The linkage of every building block and of every used correlation, in the order
     *   of the DDL.
     */
    public static Linkage of(final Correlations declared, final CorrelationTransfer transfer) {
        final Set<Correlation> used = Set.copyOf(transfer.correlations());

        return new Linkage(declared.linkageGroups()
                                   .stream()
                                   .filter(group -> group instanceof BuildingBlock || used.contains(group))
                                   .toList());
    }

    /**
     * @return The features of the groups.
     */
    public Set<EStructuralFeature> features() {
        return features;
    }

    /**
     * @return The groups, in the order of the DDL.
     */
    public List<LinkageGroup> groups() {
        return groups;
    }

    /**
     * Keeps the features of every group together after a crossover. The groups are taken in
     *   the order of the DDL:
     * <ol>
     *   <li>A ranged correlation applies only if the values of both parents lie in its
     *     ranges.</li>
     *   <li>The anchor is the first feature of the group that an earlier group already set.
     *     If there is none, it is the first feature that child A inherited from one parent (its
     *     value equals the value of this parent); a feature whose value comes from neither
     *     parent (e.g., its bits come from both) is no anchor. A group without an anchor is
     *     skipped.</li>
     *   <li>Child A gets every feature of the group that is not set yet from the parent of the
     *     anchor, and child B from the other parent. The features of the group are set
     *     afterwards, so every feature is set at most once. If two features of a group were
     *     already set from different parents, the group is not preserved completely.</li>
     * </ol>
     * Values are compared as numbers if both are numbers, otherwise with {@code equals}.
     *
     * @param parentA The parent whose place the first child takes.
     * @param parentB The other parent.
     * @param childA The first child; its values are changed.
     * @param childB The second child; its values are changed.
     * @return For every group, the features that changed with the anchor, e.g.
     *   {@code x:7, x:12 with x:0}, in the order of the groups; empty if nothing changed.
     */
    public List<String> link(final TypedEObject parentA, final TypedEObject parentB, final TypedEObject childA,
                             final TypedEObject childB) {
        final Set<EStructuralFeature> set = new HashSet<>();
        final List<String> linked = new ArrayList<>();

        for(final LinkageGroup group : groups) {
            if(!appliesTo(group, parentA, parentB)) {
                continue;
            }

            final List<EStructuralFeature> members = group.features();
            final Optional<EStructuralFeature> anchor = members.stream()
                                                               .filter(set::contains)
                                                               .findFirst()
                                                               .or(() -> members.stream()
                                                                                .filter(feature -> inheritedFrom(feature, parentA, parentB, childA) != null)
                                                                                .findFirst());
            if(anchor.isEmpty()) {
                continue;
            }

            final TypedEObject source = inheritedFrom(anchor.get(), parentA, parentB, childA);
            final TypedEObject other = source == parentA ? parentB : parentA;
            final List<String> changed = new ArrayList<>();

            for(final EStructuralFeature target : members) {
                if(set.contains(target) || target == anchor.get()) {
                    continue;
                }

                final boolean changesA = !sameValue(childA.eGet(target), source.eGet(target));
                final boolean changesB = !sameValue(childB.eGet(target), other.eGet(target));
                if(changesA || changesB) {
                    childA.eSet(target, source.eGet(target));
                    childB.eSet(target, other.eGet(target));
                    changed.add(target.getName());
                }
            }

            set.addAll(members);
            if(!changed.isEmpty()) {
                linked.add(String.join(", ", changed) + " with " + anchor.get().getName());
            }
        }

        return linked;
    }

    /**
     * @param group A building block or a correlation.
     * @param parentA One parent.
     * @param parentB The other parent.
     * @return Whether the group applies to the parents: always for a building block and a
     *   correlation without ranges, otherwise if both parents lie in the ranges.
     */
    public static boolean appliesTo(final LinkageGroup group, final TypedEObject parentA, final TypedEObject parentB) {
        return !(group instanceof Correlation correlation) || appliesTo(correlation, parentA) && appliesTo(correlation, parentB);
    }

    private static boolean appliesTo(final Correlation correlation, final TypedEObject candidate) {
        return correlation.appliesTo(((Number) candidate.eGet(correlation.first())).doubleValue(),
                                     ((Number) candidate.eGet(correlation.second())).doubleValue());
    }

    /**
     * @param group A building block or a correlation.
     * @param child A child of the two parents.
     * @param parentA One parent.
     * @param parentB The other parent.
     * @return Whether the child preserves the group: all its features have the values of one
     *   parent (a value both parents share fits both).
     */
    public static boolean isPreserved(final LinkageGroup group, final TypedEObject child, final TypedEObject parentA,
                                      final TypedEObject parentB) {
        return hasValuesOf(group, child, parentA) || hasValuesOf(group, child, parentB);
    }

    private static boolean hasValuesOf(final LinkageGroup group, final TypedEObject child, final TypedEObject parent) {
        return group.features().stream().allMatch(feature -> sameValue(child.eGet(feature), parent.eGet(feature)));
    }

    /**
     * @return The parent whose value child A has for the feature (parent A if both have it),
     *   {@code null} if the value comes from neither parent.
     */
    private static TypedEObject inheritedFrom(final EStructuralFeature feature, final TypedEObject parentA,
                                              final TypedEObject parentB, final TypedEObject childA) {
        final Object value = childA.eGet(feature);

        if(sameValue(value, parentA.eGet(feature))) {
            return parentA;
        }
        if(sameValue(value, parentB.eGet(feature))) {
            return parentB;
        }

        return null;
    }

    private static boolean sameValue(final Object first, final Object second) {
        if(first instanceof Number a && second instanceof Number b) {
            return a.doubleValue() == b.doubleValue();
        }

        return Objects.equals(first, second);
    }
}
