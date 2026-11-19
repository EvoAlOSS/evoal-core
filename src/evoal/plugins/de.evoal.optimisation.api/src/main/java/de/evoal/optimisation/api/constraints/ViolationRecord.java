package de.evoal.optimisation.api.constraints;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * How far a candidate violates the constraints of the problem: the degree of violation of
 *   every constraint (see {@link de.evoal.optimisation.api.constraints.ConstraintMeasure}).
 *   A degree is never negative and 0 exactly if the constraint is satisfied. The violation of
 *   a group is the sum of the degrees of its constraints.
 */
public final class ViolationRecord {
    /**
     * The record of a problem without constraints.
     */
    public static final ViolationRecord NONE = new ViolationRecord(Constraints.NONE, new double[0]);

    /**
     * The prefix of the memory model properties with the degrees, followed by the number of
     *   the constraint.
     */
    public static final String PROPERTY_PREFIX = "violation-";

    /**
     * The measured constraints.
     */
    private final Constraints constraints;

    /**
     * The degree of violation of every constraint, in the order of the constraints.
     */
    private final double[] degrees;

    /**
     * @param constraints The measured constraints.
     * @param degrees The degree of violation of every constraint, in their order.
     * @throws IllegalArgumentException if the number of degrees differs from the number of
     *   constraints, or a degree is negative or NaN.
     */
    public ViolationRecord(final Constraints constraints, final double[] degrees) {
        this.constraints = Objects.requireNonNull(constraints, "constraints");

        if(degrees.length != constraints.size()) {
            throw new IllegalArgumentException("The record has " + degrees.length + " degrees for " + constraints.size()
                                               + " constraints.");
        }

        for(final double degree : degrees) {
            // also rejects NaN
            if(!(degree >= 0.0)) {
                throw new IllegalArgumentException("A degree of violation must not be negative, but is " + degree
                                                   + ".");
            }
        }

        this.degrees = degrees.clone();
    }

    /**
     * @return The measured constraints.
     */
    public Constraints constraints() {
        return constraints;
    }

    /**
     * @param constraint A constraint of the problem.
     * @return The degree of violation of the constraint.
     */
    public double degree(final Constraint constraint) {
        return degrees[constraint.number() - 1];
    }

    /**
     * @return Whether every constraint is satisfied.
     */
    public boolean isFeasible() {
        return Arrays.stream(degrees)
                     .allMatch(degree -> degree == 0.0);
    }

    /**
     * @param group The name of a group.
     * @return Whether every constraint of the group is satisfied.
     * @throws IllegalArgumentException if the problem has no constraint in the group.
     */
    public boolean isFeasible(final String group) {
        return violation(group) == 0.0;
    }

    /**
     * @param constraint A constraint of the problem.
     * @return The name of the memory model property with the degree of the constraint.
     */
    public static String propertyName(final Constraint constraint) {
        return PROPERTY_PREFIX + constraint.number();
    }

    /**
     * @return The degree of every constraint as memory model property, by the property name
     *   {@value #PROPERTY_PREFIX}{@code <number>}, in the order of the constraints.
     */
    public Map<String, Double> toProperties() {
        final Map<String, Double> properties = new LinkedHashMap<>();

        for(final Constraint constraint : constraints.all()) {
            properties.put(propertyName(constraint), degree(constraint));
        }

        return properties;
    }

    @Override
    public String toString() {
        return "ViolationRecord" + Arrays.toString(degrees);
    }

    /**
     * @param group The name of a group.
     * @return The sum of the degrees of the constraints of the group.
     * @throws IllegalArgumentException if the problem has no constraint in the group.
     */
    public double violation(final String group) {
        return constraints.inGroup(group)
                          .stream()
                          .mapToDouble(this::degree)
                          .sum();
    }
}
