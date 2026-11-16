package de.evoal.optimisation.local_search.main.neighbour;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * A random order of the numbers {@code 0} to {@code size - 1}. Every order is equally
 *   likely. The numbers are drawn lazily (sparse Fisher–Yates shuffle): drawing
 *   {@code k} numbers needs {@code O(k)} time and memory, independent of {@code size}.
 */
final class RandomOrder implements PrimitiveIterator.OfInt {
    /**
     * The generator that decides the order.
     */
    private final RandomGenerator random;

    /**
     * The number of positions.
     */
    private final int size;

    /**
     * The moved entries of the conceptual array {@code [0, 1, ..., size - 1]}. A position
     *   that is missing still holds its own index.
     */
    private final Map<Integer, Integer> swapped = new HashMap<>();

    /**
     * The number of numbers drawn so far.
     */
    private int drawn = 0;

    private RandomOrder(final int size, final RandomGenerator random) {
        this.size = size;
        this.random = random;
    }

    /**
     * Creates a random order of the numbers {@code 0} to {@code size - 1}.
     *
     * @param size The number of numbers.
     * @param random The generator that decides the order.
     * @return The numbers in random order.
     */
    public static IntStream of(final int size, final RandomGenerator random) {
        final RandomOrder order = new RandomOrder(size, random);
        final int characteristics = Spliterator.ORDERED | Spliterator.DISTINCT | Spliterator.NONNULL;
        final Spliterator.OfInt spliterator = Spliterators.spliterator(order, size, characteristics);

        return StreamSupport.intStream(spliterator, false);
    }

    @Override
    public boolean hasNext() {
        return drawn < size;
    }

    @Override
    public int nextInt() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }

        // swap a random position of the rest [drawn, size) into position drawn
        final int chosen = random.nextInt(drawn, size);
        final int value = valueAt(chosen);

        swapped.put(chosen, valueAt(drawn));
        swapped.remove(drawn);
        ++drawn;

        return value;
    }

    private int valueAt(final int position) {
        return swapped.getOrDefault(position, position);
    }
}
