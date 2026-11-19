package de.evoal.optimisation.api.constraints;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * The constraints of an optimisation problem in the order of the DDL.
 */
public final class Constraints {
    /**
     * A problem without constraints.
     */
    public static final Constraints NONE = new Constraints(List.of());

    /**
     * The constraints in the order of the DDL.
     */
    private final List<Constraint> all;

    /**
     * The names of the groups in the order of their first constraint.
     */
    private final Set<String> groups;

    /**
     * @param all The constraints in the order of the DDL; their numbers are their positions,
     *   from 1.
     * @throws IllegalArgumentException if a number does not match the position.
     */
    public Constraints(final List<Constraint> all) {
        for(int index = 0; index < all.size(); ++index) {
            final Constraint constraint = all.get(index);
            final int expectedNumber = index + 1;

            if(constraint.number() != expectedNumber) {
                throw new IllegalArgumentException("The constraint " + constraint + " has the number "
                                                   + constraint.number() + " at position " + expectedNumber + ".");
            }
        }

        this.all = List.copyOf(all);
        this.groups = new LinkedHashSet<>(all.stream()
                                             .map(Constraint::group)
                                             .toList());
    }

    /**
     * @return The constraints in the order of the DDL.
     */
    public List<Constraint> all() {
        return all;
    }

    /**
     * @param number The position of a constraint in the DDL, from 1.
     * @return The constraint.
     * @throws IndexOutOfBoundsException if there is no such constraint.
     */
    public Constraint get(final int number) {
        return all.get(number - 1);
    }

    /**
     * @return The names of the groups in the order of their first constraint.
     */
    public Set<String> groups() {
        return groups;
    }

    /**
     * @param group The name of a group.
     * @return Whether the problem has constraints in the group.
     */
    public boolean hasGroup(final String group) {
        return groups.contains(group);
    }

    /**
     * @param group The name of a group.
     * @return The constraints of the group in the order of the DDL.
     * @throws IllegalArgumentException if the problem has no constraint in the group.
     */
    public List<Constraint> inGroup(final String group) {
        requireGroup(group);

        return all.stream()
                  .filter(constraint -> constraint.group().equals(group))
                  .toList();
    }

    /**
     * @return Whether the problem has no constraints.
     */
    public boolean isEmpty() {
        return all.isEmpty();
    }

    /**
     * @param group The name of a group.
     * @throws IllegalArgumentException if the problem has no constraint in the group.
     */
    public void requireGroup(final String group) {
        if(!hasGroup(group)) {
            throw new IllegalArgumentException("The constraint group '" + group + "' is not declared in the DDL; the "
                                               + "groups are " + groups + ".");
        }
    }

    /**
     * @return The number of constraints.
     */
    public int size() {
        return all.size();
    }

    @Override
    public String toString() {
        return all.toString();
    }
}
