package de.evoal.surrogate.main.resampling;

import de.evoal.models.core.ecore.TypedEObject;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Arrays;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

/**
 * Clusters the rows by their min-max normalised input features with k-means (Lloyd 1982):
 *   k-means++ seeding chooses the initial centres (the first uniformly, each further one with
 *   a probability proportional to the squared distance to the nearest chosen centre), and
 *   Lloyd iterations assign every row to its nearest centre and move every centre to the mean
 *   of its rows until no row changes its cluster. Each non-empty cluster is a block.
 */
@Slf4j
public final class KMeansBlocks implements BlockDefinition {
    public static final String NAME = "k-means-blocks";

    /**
     * A safeguard: Lloyd iterations end after finitely many steps, but may take long.
     */
    private static final int MAXIMUM_ITERATIONS = 1000;

    private final int k;

    private final List<EStructuralFeature> inputs;

    private final RandomGenerator random;

    /**
     * @param k The number of clusters, at least 2.
     * @param inputs The input features that span the space to cluster.
     * @param random The stream of the seeding.
     */
    public KMeansBlocks(final int k, final @NonNull List<EStructuralFeature> inputs, final @NonNull RandomGenerator random) {
        if(k < 2) {
            throw new IllegalArgumentException("'" + NAME + "' needs at least 2 clusters, but 'k' is " + k + ".");
        }

        this.k = k;
        this.inputs = List.copyOf(inputs);
        this.random = random;
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public int[] blocksOf(final @NonNull List<TypedEObject> rows) {
        if(k > rows.size()) {
            throw new IllegalArgumentException("'" + NAME + "' with 'k' = " + k + " needs at least " + k + " rows, but the training data has " + rows.size() + ".");
        }

        final double[][] points = NormalisedInputs.of(rows, inputs);
        final double[][] centres = seed(points);
        final int[] cluster = new int[points.length];
        Arrays.fill(cluster, -1);

        int iteration = 0;
        boolean changed = true;
        while(changed && iteration < MAXIMUM_ITERATIONS) {
            changed = assign(points, centres, cluster);
            move(points, centres, cluster);
            ++iteration;
        }

        if(changed) {
            log.warn("'{}' stopped after {} Lloyd iterations before the clusters were stable.", NAME, MAXIMUM_ITERATIONS);
        } else {
            log.info("'{}' converged after {} Lloyd iterations.", NAME, iteration);
        }

        final long nonEmpty = Arrays.stream(cluster).distinct().count();
        if(nonEmpty < k) {
            log.warn("'{}': {} of {} clusters are empty; there are {} blocks.", NAME, k - nonEmpty, k, nonEmpty);
        }

        return BlockDefinition.number(Arrays.stream(cluster).boxed().toList());
    }

    /**
     * k-means++ seeding.
     */
    private double[][] seed(final double[][] points) {
        final double[][] centres = new double[k][];
        centres[0] = points[random.nextInt(points.length)].clone();

        final double[] nearest = new double[points.length];
        Arrays.fill(nearest, Double.POSITIVE_INFINITY);
        for(int c = 1; c < k; ++c) {
            double total = 0.0;
            for(int i = 0; i < points.length; ++i) {
                nearest[i] = Math.min(nearest[i], distance(points[i], centres[c - 1]));
                total += nearest[i];
            }

            centres[c] = points[choose(nearest, total)].clone();
        }

        return centres;
    }

    /**
     * @return An index drawn with probability proportional to its weight; uniformly if all
     *   weights are 0 (all points coincide with centres).
     */
    private int choose(final double[] weights, final double total) {
        if(total <= 0.0) {
            return random.nextInt(weights.length);
        }

        final double target = random.nextDouble() * total;
        double sum = 0.0;
        for(int i = 0; i < weights.length; ++i) {
            sum += weights[i];
            if(target < sum) {
                return i;
            }
        }

        // rounding: the last point with a positive weight
        return IntStream.iterate(weights.length - 1, i -> i >= 0, i -> i - 1)
                        .filter(i -> weights[i] > 0.0)
                        .findFirst()
                        .orElse(weights.length - 1);
    }

    /**
     * Assigns every point to its nearest centre (the first on ties).
     *
     * @return Whether a point changed its cluster.
     */
    private static boolean assign(final double[][] points, final double[][] centres, final int[] cluster) {
        boolean changed = false;
        for(int i = 0; i < points.length; ++i) {
            int best = 0;
            double bestDistance = Double.POSITIVE_INFINITY;
            for(int c = 0; c < centres.length; ++c) {
                final double distance = distance(points[i], centres[c]);
                if(distance < bestDistance) {
                    best = c;
                    bestDistance = distance;
                }
            }

            if(cluster[i] != best) {
                cluster[i] = best;
                changed = true;
            }
        }

        return changed;
    }

    /**
     * Moves every centre to the mean of its points; the centre of an empty cluster stays.
     */
    private static void move(final double[][] points, final double[][] centres, final int[] cluster) {
        final int d = points[0].length;
        final double[][] sums = new double[centres.length][d];
        final int[] counts = new int[centres.length];
        for(int i = 0; i < points.length; ++i) {
            counts[cluster[i]]++;
            for(int f = 0; f < d; ++f) {
                sums[cluster[i]][f] += points[i][f];
            }
        }

        for(int c = 0; c < centres.length; ++c) {
            if(counts[c] == 0) {
                continue;
            }

            for(int f = 0; f < d; ++f) {
                centres[c][f] = sums[c][f] / counts[c];
            }
        }
    }

    /**
     * @return The squared Euclidean distance.
     */
    private static double distance(final double[] a, final double[] b) {
        double sum = 0.0;
        for(int f = 0; f < a.length; ++f) {
            final double difference = a[f] - b[f];
            sum += difference * difference;
        }

        return sum;
    }
}
