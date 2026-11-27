package de.evoal.optimisation.api.builder;

import de.evoal.core.api.utils.Requirements;

/**
 * The method that builds a random model candidate: one of the initialisation methods of
 *   tree-based genetic programming (Koza 1992; Poli, Langdon and McPhee 2008, sec. 2.2) applied
 *   to models. A method gives every candidate a {@link Plan}: the shape (full or grow) and the
 *   depth limit of its tree.
 */
public sealed interface TreeMethod {
    /**
     * How a tree is built.
     */
    enum Shape {
        /**
         * As long as the depth limit can be reached, only objects that can reach it are chosen,
         *   optional containments are set and arrays get at least one element.
         */
        FULL,

        /**
         * Every object that fits the depth limit may be chosen, so branches may end early.
         */
        GROW
    }

    /**
     * The shape and the depth limit of one tree.
     *
     * @param shape How the tree is built.
     * @param depthLimit The largest depth of an object of the tree; the root has depth 0.
     */
    record Plan(Shape shape, int depthLimit) {
        public Plan {
            Requirements.requireTrue(depthLimit >= 0, "The depth limit must not be negative.");
        }
    }

    /**
     * Full with a fixed depth limit.
     *
     * @param maximumDepth The depth limit of the trees.
     */
    record Full(int maximumDepth) implements TreeMethod {
        @Override
        public Plan planFor(final int index) {
            return new Plan(Shape.FULL, maximumDepth);
        }

        @Override
        public int smallestDepthLimit() {
            return maximumDepth;
        }
    }

    /**
     * Grow with a fixed depth limit.
     *
     * @param maximumDepth The depth limit of the trees.
     */
    record Grow(int maximumDepth) implements TreeMethod {
        @Override
        public Plan planFor(final int index) {
            return new Plan(Shape.GROW, maximumDepth);
        }

        @Override
        public int smallestDepthLimit() {
            return maximumDepth;
        }
    }

    /**
     * Ramped half-and-half (Koza 1992): the depth limits from {@code minimumDepth} to
     *   {@code maximumDepth} are used in turn, each for one full and one grow tree. Candidate
     *   {@code i} has the depth limit {@code minimumDepth + (i / 2) mod (maximumDepth -
     *   minimumDepth + 1)}; even candidates are full, odd ones grow.
     *
     * @param minimumDepth The smallest depth limit.
     * @param maximumDepth The largest depth limit.
     */
    record RampedHalfAndHalf(int minimumDepth, int maximumDepth) implements TreeMethod {
        public RampedHalfAndHalf {
            Requirements.requireTrue(minimumDepth <= maximumDepth, "The minimum depth must not exceed the maximum depth.");
        }

        @Override
        public Plan planFor(final int index) {
            final int numberOfDepths = maximumDepth - minimumDepth + 1;
            final int depthLimit = minimumDepth + (index / 2) % numberOfDepths;
            final Shape shape = index % 2 == 0 ? Shape.FULL : Shape.GROW;

            return new Plan(shape, depthLimit);
        }

        @Override
        public int smallestDepthLimit() {
            return minimumDepth;
        }
    }

    /**
     * @param index The number of the candidate in the stream of the population, starting at 0.
     * @return The shape and the depth limit of the candidate's tree.
     */
    Plan planFor(int index);

    /**
     * @return The smallest depth limit the method uses.
     */
    int smallestDepthLimit();
}
