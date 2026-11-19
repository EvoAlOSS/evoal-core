package de.evoal.optimisation.api.constraints;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.ToDoubleFunction;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.TypedEObject;

/**
 * A constraint of the optimisation problem, declared in the DDL by
 *   {@code constraint(comparison, "group")}, in its normal form g >= 0 (inequality) or
 *   g = 0 (equality).
 */
public final class Constraint {
    /**
     * The standard deviation of every feature of the constraint that has one.
     */
    private final Map<EStructuralFeature, Double> deviations;

    /**
     * Computes g from the values of the features.
     */
    private final ToDoubleFunction<FeatureValues> function;

    /**
     * The name of the group.
     */
    private final String group;

    /**
     * Whether the constraint is an equality or an inequality.
     */
    private final ConstraintKind kind;

    /**
     * The normal form if it is affine in the search features, {@code null} otherwise.
     */
    private final LinearForm linearForm;

    /**
     * The position of the constraint in the DDL, from 1.
     */
    private final int number;

    /**
     * The objectives the constraint reads, in the order of their first use.
     */
    private final List<EStructuralFeature> objectives;

    /**
     * The search features the constraint reads, in the order of their first use.
     */
    private final List<EStructuralFeature> searchFeatures;

    /**
     * {@link #searchFeatures} for fast lookups.
     */
    private final Set<EStructuralFeature> searchFeatureSet;

    /**
     * The constraint as written in the DDL, for reports.
     */
    private final String text;

    /**
     * @param number The position of the constraint in the DDL, from 1.
     * @param group The name of the group.
     * @param text The constraint as written in the DDL.
     * @param kind Whether the constraint is an equality or an inequality.
     * @param searchFeatures The search features the constraint reads.
     * @param objectives The objectives the constraint reads.
     * @param deviations The standard deviation of every feature of the constraint that has one.
     * @param function Computes g from the values of the features.
     * @param linearForm The normal form if it is affine in the search features, {@code null}
     *   otherwise.
     */
    public Constraint(final int number,
                      final String group,
                      final String text,
                      final ConstraintKind kind,
                      final List<EStructuralFeature> searchFeatures,
                      final List<EStructuralFeature> objectives,
                      final Map<EStructuralFeature, Double> deviations,
                      final ToDoubleFunction<FeatureValues> function,
                      final LinearForm linearForm) {
        this.number = number;
        this.group = Objects.requireNonNull(group, "group");
        this.text = Objects.requireNonNull(text, "text");
        this.kind = Objects.requireNonNull(kind, "kind");
        this.searchFeatures = List.copyOf(searchFeatures);
        this.searchFeatureSet = new HashSet<>(searchFeatures);
        this.objectives = List.copyOf(objectives);
        this.deviations = Map.copyOf(deviations);
        this.function = Objects.requireNonNull(function, "function");
        this.linearForm = linearForm;
    }

    /**
     * @return The standard deviation of every feature of the constraint that has one.
     */
    public Map<EStructuralFeature, Double> deviations() {
        return deviations;
    }

    /**
     * @return The name of the group.
     */
    public String group() {
        return group;
    }

    /**
     * @return Whether the constraint is an equality or an inequality.
     */
    public ConstraintKind kind() {
        return kind;
    }

    /**
     * @return The normal form if it is affine in the search features and reads no objectives.
     */
    public Optional<LinearForm> linearForm() {
        return Optional.ofNullable(linearForm);
    }

    /**
     * @return The position of the constraint in the DDL, from 1.
     */
    public int number() {
        return number;
    }

    /**
     * @return The objectives the constraint reads, in the order of their first use.
     */
    public List<EStructuralFeature> objectives() {
        return objectives;
    }

    /**
     * @return The search features the constraint reads, in the order of their first use.
     */
    public List<EStructuralFeature> searchFeatures() {
        return searchFeatures;
    }

    /**
     * @return The constraint as written in the DDL.
     */
    public String text() {
        return text;
    }

    @Override
    public String toString() {
        return "constraint " + number + " (" + group + "): " + text;
    }

    /**
     * @return Whether the constraint reads objectives, so it can only be measured after the
     *   evaluation.
     */
    public boolean usesObjectives() {
        return !objectives.isEmpty();
    }

    /**
     * @param values The values of the features.
     * @return g, the value of the normal form.
     */
    public double valueOf(final FeatureValues values) {
        return function.applyAsDouble(values);
    }

    /**
     * @param input The candidate (a point of the search space).
     * @param objectives The result of the optimisation function for the candidate; may be
     *   {@code null} if the constraint reads no objectives.
     * @return g, the value of the normal form.
     * @throws IllegalArgumentException if the constraint reads objectives, but none are given.
     */
    public double valueOf(final TypedEObject input, final TypedEObject objectives) {
        final FeatureValues values = valuesOf(input, objectives);

        return valueOf(values);
    }

    private double valueOf(final EStructuralFeature feature, final TypedEObject input, final TypedEObject objectives) {
        final TypedEObject source = searchFeatureSet.contains(feature) ? input : objectives;
        final Number value = (Number) source.eGet(feature);

        return value.doubleValue();
    }

    /**
     * @param input The candidate (a point of the search space).
     * @param objectives The result of the optimisation function for the candidate; may be
     *   {@code null} if the constraint reads no objectives.
     * @return The values of the features of the constraint: search features from the input,
     *   objectives from the objectives.
     * @throws IllegalArgumentException if the constraint reads objectives, but none are given.
     */
    public FeatureValues valuesOf(final TypedEObject input, final TypedEObject objectives) {
        if(usesObjectives() && objectives == null) {
            throw new IllegalArgumentException("The constraint '" + text + "' reads objectives; it can only be measured"
                                               + " after the evaluation.");
        }

        return feature -> valueOf(feature, input, objectives);
    }
}
