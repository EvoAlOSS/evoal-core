package de.evoal.surrogate.knn;

import java.util.Comparator;

import org.apache.commons.math3.util.Pair;

/**
 * Comparator implementation for pairs of doubles.</br>
 *
 * The first element is the Euclidean distance and the second value is the y-value.
 *   Thus, this comparator compares the distances.
 */
public class DistanceComparator implements Comparator<Pair<Double, Double>> {
    @Override
    public int compare(Pair<Double, Double> pair1, Pair<Double, Double> pair2){
        return Double.compare(pair1.getKey(), pair2.getKey());
    }
}
