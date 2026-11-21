package de.evoal.optimisation.api.run;

import java.util.List;
import java.util.Objects;

/**
 * A step that the search procedure executed in an iteration, with the candidates it produced.
 *   The kernel records the outputs as the individuals of the step in the memory model.
 *
 * @param kind The kind of the step in the meta-algorithm model, e.g., {@code Selection}.
 * @param description What the step did, e.g., "select 10 parents by tournament-selection".
 * @param outputs The candidates the step created or evaluated, in its order: e.g., the selected
 *   members of a selection, the children of a variation, the evaluated candidates of a fitness
 *   calculation, or the new population of an acceptance; none for a parameter adjustment. A
 *   candidate may occur several times, e.g., a member that a selection chose twice.
 */
public record ExecutedStep(String kind, String description, List<Candidate> outputs) {
    public ExecutedStep {
        Objects.requireNonNull(kind);
        Objects.requireNonNull(description);
        outputs.forEach(Objects::requireNonNull);
        outputs = List.copyOf(outputs);
    }
}
