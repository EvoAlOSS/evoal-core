package de.evoal.optimisation.api.constraints;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * The degrees of violation of some constraints of a candidate, measured before its
 *   evaluation, e.g., by a {@code 'constraint-check'}. The {@link ConstraintEvaluation} takes
 *   them into the {@link ViolationRecord} of the candidate and measures only the other
 *   constraints.
 */
public final class PartialViolationRecord {
    /**
     * A record without measured constraints.
     */
    public static final PartialViolationRecord EMPTY = new PartialViolationRecord(Map.of());

    /**
     * The degree of every measured constraint, by the number of the constraint.
     */
    private final Map<Integer, Double> degrees;

    private PartialViolationRecord(final Map<Integer, Double> degrees) {
        this.degrees = Collections.unmodifiableMap(new TreeMap<>(degrees));
    }

    /**
     * @param constraint A constraint of the problem.
     * @return The degree of violation of the constraint, empty if it is not measured.
     */
    public Optional<Double> degree(final Constraint constraint) {
        return Optional.ofNullable(degrees.get(constraint.number()));
    }

    /**
     * @return Whether no constraint is measured.
     */
    public boolean isEmpty() {
        return degrees.isEmpty();
    }

    /**
     * @param other Degrees of further constraints.
     * @return A record with the degrees of both; the degrees of {@code other} win.
     */
    public PartialViolationRecord merge(final PartialViolationRecord other) {
        if(other.isEmpty()) {
            return this;
        }

        final Map<Integer, Double> merged = new TreeMap<>(degrees);
        merged.putAll(other.degrees);

        return new PartialViolationRecord(merged);
    }

    /**
     * @param degrees The degree of every measured constraint, by the number of the constraint.
     * @return The record.
     * @throws IllegalArgumentException if a degree is negative or NaN.
     */
    public static PartialViolationRecord of(final Map<Integer, Double> degrees) {
        for(final double degree : degrees.values()) {
            // also rejects NaN
            if(!(degree >= 0.0)) {
                throw new IllegalArgumentException("A degree of violation must not be negative, but is " + degree
                                                   + ".");
            }
        }

        return new PartialViolationRecord(degrees);
    }

    /**
     * @param constraints Constraints of the problem.
     * @return The sum of the degrees of the given constraints.
     * @throws IllegalArgumentException if a constraint is not measured.
     */
    public double violation(final Iterable<Constraint> constraints) {
        double sum = 0.0;

        for(final Constraint constraint : constraints) {
            final Double degree = degrees.get(constraint.number());
            if(degree == null) {
                throw new IllegalArgumentException("The " + constraint + " is not measured.");
            }

            sum += degree;
        }

        return sum;
    }

    @Override
    public String toString() {
        return "PartialViolationRecord" + degrees;
    }
}
