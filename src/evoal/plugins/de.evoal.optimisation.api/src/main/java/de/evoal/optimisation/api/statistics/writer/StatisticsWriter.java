package de.evoal.optimisation.api.statistics.writer;

import org.eclipse.emf.ecore.EObject;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.core.cdi.EvoalComponent;

/**
 * Evaluation-specific data writer for evaluation results. The information
 * may be individual-, generation-, or run-specific and may be specific to
 * a certain technique under investigation. What all writer have in common
 * is the table-like structure of data (think of a CSV file).
 *
 * The framework will call {@link #init(EObject)} once before the optimisation
 * algorithm starts. While the algorithm runs, it will call {@link #add(Iteration)}
 * for each generation step. When the algorithm terminates, the framework calls
 * {@link #write()} once to force data serialization.
 */
public interface StatisticsWriter extends EvoalComponent<StatisticsWriter> {
    /**
     * Adds an optimisation result to the statistics.
     */
    void add(final Iteration result);

    /**
     * Write the statistics since the run is completed.
     */
    void write();
}
