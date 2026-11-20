package de.evoal.optimisation.ea.main.correlation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.correlations.Correlation;
import de.evoal.optimisation.api.correlations.CorrelationKind;

/**
 * Transfers changes along the correlations of the DDL, at the level of features and
 *   independent of the representation of the genes.
 * <p>
 * A correlation is used if its absolute coefficient is at least the minimum, its features
 *   have an order (not nominal, not boolean) and both have a finite range: the bounds of the
 *   DDL; an integer feature without bounds uses the range of its type (reported as a
 *   warning), a pair with an unbounded real feature is skipped (reported as a warning).
 * <p>
 * The change of a feature f is normalised by its range, Δf / range(f), and transferred to a
 *   correlated feature g as Δg = rho · Δf / range(f) · range(g). For a pair with an ordinal
 *   feature, the normalised position is used as the normalised rank, so the shift is the same
 *   and integer features are rounded to whole ranks. A written value is rounded for integer
 *   features and clamped to the bounds (one step inside an exclusive bound of an integer
 *   feature).
 */
@Slf4j
public final class CorrelationTransfer {
    /**
     * The normalisation range and the clamping bounds of a feature.
     *
     * @param lower The lower bound.
     * @param upper The upper bound.
     * @param lowest The smallest value that may be written.
     * @param highest The largest value that may be written.
     * @param integer Whether the feature has integer values.
     */
    private record FeatureRange(double lower, double upper, double lowest, double highest, boolean integer) {
        double width() {
            return upper - lower;
        }

        double fit(final double value) {
            final double rounded = integer ? Math.rint(value) : value;

            return Math.min(Math.max(rounded, lowest), highest);
        }
    }

    /**
     * The used correlations, in the order of the DDL.
     */
    private final List<Correlation> correlations;

    /**
     * The range of every feature of a used correlation.
     */
    private final Map<EStructuralFeature, FeatureRange> ranges = new HashMap<>();

    /**
     * @param all The correlations of the problem, in the order of the DDL.
     * @param minimum The smallest absolute coefficient that is used, in [0, 1].
     * @param boundaries The bounds of the features in the DDL.
     * @param operator The name of the operator, for the warnings.
     */
    public CorrelationTransfer(final List<Correlation> all, final double minimum, final FeatureBoundaries boundaries,
                               final String operator) {
        final List<Correlation> used = new ArrayList<>();

        for(final Correlation correlation : all) {
            if(Math.abs(correlation.coefficient()) < minimum || correlation.kind() == CorrelationKind.NOMINAL) {
                continue;
            }

            final Optional<FeatureRange> first = rangeOf(correlation.first(), boundaries, correlation, operator);
            final Optional<FeatureRange> second = rangeOf(correlation.second(), boundaries, correlation, operator);
            if(first.isEmpty() || second.isEmpty()) {
                continue;
            }

            ranges.put(correlation.first(), first.get());
            ranges.put(correlation.second(), second.get());
            used.add(correlation);
        }

        this.correlations = List.copyOf(used);
    }

    /**
     * @return The features of the used correlations.
     */
    public Set<EStructuralFeature> features() {
        return Set.copyOf(ranges.keySet());
    }

    /**
     * @return The used correlations, in the order of the DDL.
     */
    public List<Correlation> correlations() {
        return correlations;
    }

    /**
     * Keeps correlated features together after a crossover (linkage): for every correlation,
     *   in the order of the DDL, a feature that a child inherited from one parent (its value
     *   equals the value of this parent) is the anchor; the child gets the other feature from
     *   the same parent, and its sibling from the other parent. A feature whose value comes from
     *   neither parent (e.g., its bits come from both) is no anchor. Every feature is set at most
     *   once. A ranged correlation applies if the values of both parents lie in its ranges.
     *
     * @param parentA The parent whose place the first child takes.
     * @param parentB The other parent.
     * @param childA The first child; its values are changed.
     * @param childB The second child; its values are changed.
     * @return The set features, e.g. {@code x:2 with x:1}, in their order; empty if nothing
     *   changed.
     */
    public List<String> link(final TypedEObject parentA, final TypedEObject parentB, final TypedEObject childA,
                             final TypedEObject childB) {
        final Set<EStructuralFeature> set = new LinkedHashSet<>();
        final List<String> linked = new ArrayList<>();

        for(final Correlation correlation : correlations) {
            if(!appliesTo(correlation, parentA) || !appliesTo(correlation, parentB)) {
                continue;
            }

            for(final EStructuralFeature anchor : List.of(correlation.first(), correlation.second())) {
                final EStructuralFeature target = correlation.partnerOf(anchor).orElseThrow();
                if(set.contains(target)) {
                    continue;
                }

                final double anchorValue = valueOf(childA, anchor);
                final TypedEObject source;
                final TypedEObject other;
                if(anchorValue == valueOf(parentA, anchor)) {
                    source = parentA;
                    other = parentB;
                } else if(anchorValue == valueOf(parentB, anchor)) {
                    source = parentB;
                    other = parentA;
                } else {
                    continue;
                }

                final boolean changesA = valueOf(childA, target) != valueOf(source, target);
                final boolean changesB = valueOf(childB, target) != valueOf(other, target);
                set.add(anchor);
                set.add(target);
                if(changesA || changesB) {
                    write(childA, target, valueOf(source, target));
                    write(childB, target, valueOf(other, target));
                    linked.add(target.getName() + " with " + anchor.getName());
                }
                break;
            }
        }

        return linked;
    }

    /**
     * Propagates the changes of a mutation along the correlations.
     * <p>
     * The primary changes are the features of the used correlations whose values differ
     *   between {@code before} and {@code after}. In every step, the correlations are visited in
     *   the order of the DDL; a correlation with a feature changed in the previous step
     *   transfers its change to the other feature, unless that one already changed in this
     *   operation. A feature with several changed partners therefore takes the change of the
     *   first correlation. Step 1 transfers the primary changes; step n the changes of step
     *   n - 1. A ranged correlation applies if the source (before its change) and the target
     *   (before the transfer) lie in its ranges.
     *
     * @param before The candidate before the mutation.
     * @param after The candidate after the mutation; the propagated values are written into it.
     * @param depth The number of steps, at least 1.
     * @return The propagated changes, e.g. {@code x:2 from x:1 (0.9)}, in their order; empty if
     *   nothing was propagated.
     */
    public List<String> propagate(final TypedEObject before, final TypedEObject after, final int depth) {
        final Map<EStructuralFeature, Double> changes = new LinkedHashMap<>();
        for(final EStructuralFeature feature : ranges.keySet().stream().sorted(this::byDdlOrder).toList()) {
            final double change = valueOf(after, feature) - valueOf(before, feature);
            if(change != 0.0) {
                changes.put(feature, change);
            }
        }

        final Set<EStructuralFeature> changed = new LinkedHashSet<>(changes.keySet());
        final List<String> propagated = new ArrayList<>();

        Map<EStructuralFeature, Double> frontier = changes;
        for(int step = 1; step <= depth && !frontier.isEmpty(); ++step) {
            final Map<EStructuralFeature, Double> next = new LinkedHashMap<>();

            for(final Correlation correlation : correlations) {
                for(final EStructuralFeature source : List.of(correlation.first(), correlation.second())) {
                    final EStructuralFeature target = correlation.partnerOf(source).orElseThrow();
                    if(!frontier.containsKey(source) || changed.contains(target)) {
                        continue;
                    }

                    final double sourceBefore = valueOf(after, source) - frontier.get(source);
                    final double targetBefore = valueOf(after, target);
                    final double firstValue = source == correlation.first() ? sourceBefore : targetBefore;
                    final double secondValue = source == correlation.first() ? targetBefore : sourceBefore;
                    if(!correlation.appliesTo(firstValue, secondValue)) {
                        continue;
                    }

                    final FeatureRange sourceRange = ranges.get(source);
                    final FeatureRange targetRange = ranges.get(target);
                    final double shift = correlation.coefficient() * frontier.get(source) / sourceRange.width()
                                         * targetRange.width();
                    final double written = targetRange.fit(targetBefore + shift);

                    changed.add(target);
                    if(written != targetBefore) {
                        write(after, target, written);
                        next.put(target, written - targetBefore);
                        propagated.add(target.getName() + " from " + source.getName() + " (" + correlation.coefficient() + ")");
                    }
                }
            }

            frontier = next;
        }

        return propagated;
    }

    private static boolean appliesTo(final Correlation correlation, final TypedEObject candidate) {
        return correlation.appliesTo(valueOf(candidate, correlation.first()), valueOf(candidate, correlation.second()));
    }

    private int byDdlOrder(final EStructuralFeature first, final EStructuralFeature second) {
        return Integer.compare(firstUse(first), firstUse(second));
    }

    private int firstUse(final EStructuralFeature feature) {
        for(int i = 0; i < correlations.size(); ++i) {
            final Correlation correlation = correlations.get(i);
            if(correlation.first() == feature) {
                return 2 * i;
            }
            if(correlation.second() == feature) {
                return 2 * i + 1;
            }
        }

        return Integer.MAX_VALUE;
    }

    private static Optional<FeatureRange> rangeOf(final EStructuralFeature feature, final FeatureBoundaries boundaries,
                                                  final Correlation correlation, final String operator) {
        if(!EClassifierHelper.isNumeric(feature.getEType())) {
            log.warn("The '{}' skips the {}: '{}' is not numeric.", operator, correlation, feature.getName());
            return Optional.empty();
        }

        final boolean integer = EClassifierHelper.isLongOrShorter(feature.getEType());
        if(!FeatureBoundaries.isBounded(feature)) {
            if(!integer) {
                log.warn("The '{}' skips the {}: the real feature '{}' has no lower and upper bound in the DDL.", operator,
                         correlation, feature.getName());
                return Optional.empty();
            }

            log.warn("The '{}' normalises the changes of '{}' by the range of its type, since it has no lower and upper "
                     + "bound in the DDL.", operator, feature.getName());
        }

        final FeatureBoundaries.Boundaries bounds = boundaries.get(feature);
        final double lower = bounds.lower().doubleValue();
        final double upper = bounds.upper().doubleValue();
        final double lowest = integer && !bounds.lowerIncluded() ? lower + 1.0 : lower;
        final double highest = integer && !bounds.UpperIncluded() ? upper - 1.0 : upper;

        if(!(upper > lower) || Double.isInfinite(upper - lower)) {
            log.warn("The '{}' skips the {}: '{}' has no finite range.", operator, correlation, feature.getName());
            return Optional.empty();
        }

        return Optional.of(new FeatureRange(lower, upper, lowest, highest, integer));
    }

    private static double valueOf(final TypedEObject candidate, final EStructuralFeature feature) {
        return ((Number) candidate.eGet(feature)).doubleValue();
    }

    private static void write(final TypedEObject candidate, final EStructuralFeature feature, final double value) {
        candidate.eSet(feature, NumericConversions.toType(value, feature.getEType()));
    }
}
