package de.evoal.optimisation.ea.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The result of the example {@code ea-nsga2}: the first front of the last generation in the
 *   reference output lies close to the Pareto-optimal front of ZDT1, f2 = 1 - sqrt(f1), and
 *   covers f1 in [0, 1]. Close means: on average at most {@value #MEAN_TOLERANCE} above it
 *   (similar to the generational distance), and no point more than {@value #TOLERANCE}
 *   above it. Single sparse points can lie above the front for many generations, since
 *   their large crowding distance keeps them until a better neighbour appears.
 * <p>
 * The test reads the stored reference, so it does not run the algorithm; the regression
 *   runner keeps the reference up to date.
 */
class Nsga2FrontTest {
    private static final Path FRONTS = Path.of("src/main/examples/ea-nsga2/expected/search/best-candidate-per-iteration.csv");

    /**
     * The largest allowed distance f2 - (1 - sqrt(f1)) of a point of the front.
     */
    private static final double TOLERANCE = 0.02;

    /**
     * The largest allowed mean distance f2 - (1 - sqrt(f1)) of the points of the front.
     */
    private static final double MEAN_TOLERANCE = 0.005;

    @Test
    @DisplayName("the last first front of ea-nsga2 lies within the tolerances of f2 = 1 - sqrt(f1) and covers [0, 1]")
    void lastFrontIsCloseToTheParetoFront() throws IOException {
        final List<String> lines = Files.readAllLines(FRONTS);
        final List<String> header = List.of(lines.getFirst().split(","));
        final int generationColumn = header.indexOf("generation");
        final int f1Column = header.indexOf("f:1");
        final int f2Column = header.indexOf("f:2");

        final List<double[]> rows = new ArrayList<>();
        for(final String line : lines.subList(1, lines.size())) {
            final String[] cells = line.split(",");
            rows.add(new double[] {Double.parseDouble(cells[generationColumn]), Double.parseDouble(cells[f1Column]),
                                   Double.parseDouble(cells[f2Column])});
        }

        final double last = rows.stream().mapToDouble(row -> row[0]).max().orElseThrow();
        final List<double[]> front = rows.stream().filter(row -> row[0] == last).toList();

        double sum = 0.0;
        for(final double[] point : front) {
            final double distance = point[2] - (1.0 - Math.sqrt(point[1]));
            Assertions.assertTrue(distance <= TOLERANCE, "f1 = " + point[1] + ", f2 = " + point[2] + " is " + distance
                                                         + " above the Pareto-optimal front.");
            sum += distance;
        }

        final double mean = sum / front.size();
        Assertions.assertTrue(mean <= MEAN_TOLERANCE, "The front is on average " + mean + " above the Pareto-optimal front.");

        Assertions.assertTrue(front.stream().anyMatch(point -> point[1] <= 0.05), "no point with f1 <= 0.05");
        Assertions.assertTrue(front.stream().anyMatch(point -> point[1] >= 0.95), "no point with f1 >= 0.95");
    }
}
