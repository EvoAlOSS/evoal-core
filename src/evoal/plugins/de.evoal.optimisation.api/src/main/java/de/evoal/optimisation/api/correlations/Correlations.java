package de.evoal.optimisation.api.correlations;

import java.util.ArrayList;
import java.util.List;

/**
 * The correlations and the building blocks of an optimisation problem in the order of the DDL.
 */
public final class Correlations {
    /**
     * A problem without correlations and building blocks.
     */
    public static final Correlations NONE = new Correlations(List.of());

    /**
     * The correlations in the order of the DDL.
     */
    private final List<Correlation> all;

    /**
     * The building blocks in the order of the DDL.
     */
    private final List<BuildingBlock> buildingBlocks;

    /**
     * The correlations and the building blocks together, in the order of the DDL.
     */
    private final List<LinkageGroup> groups;

    /**
     * @param groups The correlations and the building blocks in the order of the DDL; the
     *   numbers of the correlations are their positions among the correlations, from 1, and
     *   the same holds for the building blocks.
     * @throws IllegalArgumentException if a number does not match the position.
     */
    public Correlations(final List<? extends LinkageGroup> groups) {
        final List<Correlation> correlations = new ArrayList<>();
        final List<BuildingBlock> blocks = new ArrayList<>();

        for(final LinkageGroup group : groups) {
            switch(group) {
                case Correlation correlation -> {
                    correlations.add(correlation);
                    requireNumber(correlation, correlation.number(), correlations.size());
                }
                case BuildingBlock block -> {
                    blocks.add(block);
                    requireNumber(block, block.number(), blocks.size());
                }
            }
        }

        this.all = List.copyOf(correlations);
        this.buildingBlocks = List.copyOf(blocks);
        this.groups = List.copyOf(groups);
    }

    /**
     * @return The correlations in the order of the DDL.
     */
    public List<Correlation> all() {
        return all;
    }

    /**
     * @param minimum The smallest absolute coefficient, in [0, 1].
     * @return The correlations whose absolute coefficient is at least the minimum, in the order
     *   of the DDL.
     */
    public List<Correlation> atLeast(final double minimum) {
        return all.stream()
                  .filter(correlation -> Math.abs(correlation.coefficient()) >= minimum)
                  .toList();
    }

    /**
     * @return The building blocks in the order of the DDL.
     */
    public List<BuildingBlock> buildingBlocks() {
        return buildingBlocks;
    }

    /**
     * @return Whether the problem has neither correlations nor building blocks.
     */
    public boolean isEmpty() {
        return groups.isEmpty();
    }

    /**
     * @return The correlations and the building blocks together, in the order of the DDL.
     */
    public List<LinkageGroup> linkageGroups() {
        return groups;
    }

    private static void requireNumber(final LinkageGroup group, final int number, final int position) {
        if(number != position) {
            throw new IllegalArgumentException("The " + group + " has the number " + number + " at position " + position
                                               + ".");
        }
    }

    /**
     * @return The number of correlations.
     */
    public int size() {
        return all.size();
    }

    @Override
    public String toString() {
        return groups.toString();
    }
}
