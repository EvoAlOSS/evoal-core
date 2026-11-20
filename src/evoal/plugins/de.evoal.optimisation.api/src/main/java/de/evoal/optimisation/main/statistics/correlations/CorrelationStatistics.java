package de.evoal.optimisation.main.statistics.correlations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;

import de.evoal.optimisation.api.correlations.Correlation;
import de.evoal.optimisation.api.correlations.CorrelationKind;
import de.evoal.optimisation.api.correlations.ProblemCorrelations;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;

/**
 * Compares the correlations of the DDL with the population of every iteration (DL type
 *   {@code 'correlation-statistics'}) and writes {@code correlation-statistics.csv}: the
 *   iteration number, then for every correlation n of the DDL, in its order, the members of
 *   the population that lie in its ranges (all members for a correlation without ranges):
 * <ul>
 *   <li>with {@code 'empirical-correlation'}: {@code n-<n>}, their number,
 *     {@code correlation-<n>}, the empirical correlation of the two features (Pearson for a
 *     linear correlation, K. Pearson: Mathematical contributions to the theory of evolution.
 *     III. Regression, heredity, and panmixia. Philosophical Transactions A 187, 1896,
 *     pp. 253-318; Spearman with average ranks for ties if a feature is ordinal, C. Spearman:
 *     The proof and measurement of association between two things. American Journal of
 *     Psychology 15(1), 1904, pp. 72-101), and {@code deviation-<n>}, the empirical minus
 *     the declared coefficient;</li>
 *   <li>with {@code 'covariance-difference'}: {@code covariance-difference-<n>}, the
 *     covariance of the two features in the population minus the one in the initial
 *     population.</li>
 * </ul>
 * A value that cannot be computed (fewer than two members, a constant feature) is empty.
 *   Correlations with a nominal feature have no columns. A problem without correlations or a
 *   configuration without any output is rejected.
 */
@Dependent
@Named("de.evoal.optimisation.core.correlation-statistics")
@Slf4j
public class CorrelationStatistics implements StatisticsWriter {
    @Inject
    private AttributeEvaluator attributes;

    /**
     * The measured correlations, without the nominal ones.
     */
    private List<Correlation> correlations;

    /**
     * Whether the covariance difference is written.
     */
    private boolean covariance;

    /**
     * Whether the empirical correlation is written.
     */
    private boolean empirical = true;

    /**
     * The covariance of every correlation in the initial population, {@code null} before.
     */
    private double[] initialCovariances;

    @Inject
    private ProblemCorrelations problemCorrelations;

    /**
     * Creates the output the rows are written to.
     */
    @Inject
    private WriterStrategy strategy;

    /**
     * The output, created at the start of the run. {@code null} before.
     */
    private Writer writer;

    /**
     * Creates a writer that is configured by {@link #init(EObject)}.
     */
    public CorrelationStatistics() {
    }

    /**
     * Creates a writer for the given correlations, e.g., for tests.
     *
     * @param correlations The correlations of the problem.
     * @param empirical Whether the empirical correlation is written.
     * @param covariance Whether the covariance difference is written.
     */
    CorrelationStatistics(final List<Correlation> correlations, final boolean empirical, final boolean covariance) {
        this.correlations = measured(correlations);
        this.empirical = empirical;
        this.covariance = covariance;
    }

    /**
     * Writes the row of the iteration and flushes the output. A failure is logged and does not
     *   stop the run.
     */
    @Override
    public void add(final Iteration result) {
        if(writer == null) {
            start();
        }

        try {
            writer.addRecord(toRecord(result));
        } catch(final WriterException e) {
            log.warn("Failed to write the correlation statistics of iteration {}.", result.getNumber(), e);
        }

        writer.flush();
    }

    /**
     * @throws InitializationException if the problem has no correlations or no output is
     *   configured.
     */
    @Override
    public StatisticsWriter init(final EObject configuration) throws InitializationException {
        empirical = attributes.attributeToBoolean(configuration, "empirical-correlation");
        covariance = attributes.attributeToBoolean(configuration, "covariance-difference");
        if(!empirical && !covariance) {
            throw new InitializationException("'correlation-statistics' needs 'empirical-correlation' or "
                                              + "'covariance-difference'.");
        }

        if(problemCorrelations.correlations().isEmpty()) {
            throw new InitializationException("'correlation-statistics' needs correlations, but the DDL of the problem "
                                              + "declares none.");
        }

        correlations = measured(problemCorrelations.correlations().all());

        return this;
    }

    /**
     * Creates the output.
     */
    @Override
    public void start() {
        if(writer != null) {
            return;
        }

        final List<Column> columns = new ArrayList<>();
        columns.add(new Column("iteration", ColumnType.Integer));
        for(final Correlation correlation : correlations) {
            final int n = correlation.number();
            if(empirical) {
                columns.add(new Column("n-" + n, ColumnType.Integer));
                columns.add(new Column("correlation-" + n, ColumnType.Double));
                columns.add(new Column("deviation-" + n, ColumnType.Double));
            }
            if(covariance) {
                columns.add(new Column("covariance-difference-" + n, ColumnType.Double));
            }
        }

        try {
            writer = strategy.create("correlation-statistics", columns);
        } catch(final WriterException e) {
            throw new IllegalStateException("Cannot create the output 'correlation-statistics'.", e);
        }
    }

    /**
     * @return The row of the iteration; the first iteration is the initial population of the
     *   covariance difference.
     */
    Object[] toRecord(final Iteration iteration) {
        final List<TypedEObject> members = iteration.survivedIndividuals()
                                                    .map(Individual::getInput)
                                                    .toList();
        final List<Object> record = new ArrayList<>();
        record.add(iteration.getNumber());

        final boolean initial = initialCovariances == null;
        if(initial) {
            initialCovariances = new double[correlations.size()];
        }

        for(int i = 0; i < correlations.size(); ++i) {
            final Correlation correlation = correlations.get(i);
            final double[][] values = valuesOf(correlation, members);
            final double[] first = values[0];
            final double[] second = values[1];

            if(empirical) {
                final Double empiricalCoefficient = correlation.kind() == CorrelationKind.RANK
                        ? pearson(ranks(first), ranks(second))
                        : pearson(first, second);
                record.add((long) first.length);
                record.add(empiricalCoefficient);
                record.add(empiricalCoefficient == null ? null : empiricalCoefficient - correlation.coefficient());
            }

            final Double currentCovariance = covariance(first, second);
            if(initial) {
                initialCovariances[i] = currentCovariance == null ? Double.NaN : currentCovariance;
            }
            if(covariance) {
                final double initialCovariance = initialCovariances[i];
                record.add(currentCovariance == null || Double.isNaN(initialCovariance)
                                   ? null
                                   : currentCovariance - initialCovariance);
            }
        }

        return record.toArray();
    }

    /**
     * @return The covariance (divided by n), {@code null} for fewer than two values.
     */
    static Double covariance(final double[] first, final double[] second) {
        final int n = first.length;
        if(n < 2) {
            return null;
        }

        final double firstMean = Arrays.stream(first).average().orElseThrow();
        final double secondMean = Arrays.stream(second).average().orElseThrow();
        double sum = 0.0;
        for(int i = 0; i < n; ++i) {
            sum += (first[i] - firstMean) * (second[i] - secondMean);
        }

        return sum / n;
    }

    private static List<Correlation> measured(final List<Correlation> all) {
        return all.stream()
                  .filter(correlation -> correlation.kind() != CorrelationKind.NOMINAL)
                  .toList();
    }

    /**
     * @return The Pearson correlation, {@code null} for fewer than two values or a constant
     *   feature.
     */
    static Double pearson(final double[] first, final double[] second) {
        final Double covariance = covariance(first, second);
        if(covariance == null) {
            return null;
        }

        final double firstDeviation = Math.sqrt(covariance(first, first));
        final double secondDeviation = Math.sqrt(covariance(second, second));
        if(firstDeviation == 0.0 || secondDeviation == 0.0) {
            return null;
        }

        return covariance / (firstDeviation * secondDeviation);
    }

    /**
     * @return The ranks of the values from 1, equal values get the average of their ranks.
     */
    static double[] ranks(final double[] values) {
        final Integer[] order = new Integer[values.length];
        for(int i = 0; i < order.length; ++i) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> Double.compare(values[a], values[b]));

        final double[] ranks = new double[values.length];
        int start = 0;
        while(start < order.length) {
            int end = start;
            while(end + 1 < order.length && values[order[end + 1]] == values[order[start]]) {
                ++end;
            }

            final double average = (start + end) / 2.0 + 1.0;
            for(int i = start; i <= end; ++i) {
                ranks[order[i]] = average;
            }
            start = end + 1;
        }

        return ranks;
    }

    /**
     * @return The values of both features of the members that lie in the ranges of the
     *   correlation.
     */
    private static double[][] valuesOf(final Correlation correlation, final List<TypedEObject> members) {
        final List<double[]> pairs = new ArrayList<>();

        for(final TypedEObject member : members) {
            final double first = valueOf(member, correlation.first());
            final double second = valueOf(member, correlation.second());
            if(correlation.appliesTo(first, second)) {
                pairs.add(new double[] {first, second});
            }
        }

        final double[][] values = new double[2][pairs.size()];
        for(int i = 0; i < pairs.size(); ++i) {
            values[0][i] = pairs.get(i)[0];
            values[1][i] = pairs.get(i)[1];
        }

        return values;
    }

    /**
     * @return The value of the feature, looked up by its name in the space of the member.
     */
    private static double valueOf(final TypedEObject member, final EStructuralFeature feature) {
        final EStructuralFeature own = member.eClass().getEStructuralFeature(feature.getName());

        return ((Number) member.eGet(own)).doubleValue();
    }

    /**
     * Flushes the output at the end of a run.
     */
    @Override
    public void write() {
        if(writer == null) {
            return;
        }

        try {
            strategy.flush(writer);
        } catch(final WriterException e) {
            log.error("Failed to write the correlation statistics.", e);
        }
    }
}
