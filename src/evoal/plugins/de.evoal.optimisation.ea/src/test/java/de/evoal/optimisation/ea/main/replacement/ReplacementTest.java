package de.evoal.optimisation.ea.main.replacement;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;
import de.evoal.optimisation.ea.Candidates;
import de.evoal.optimisation.ea.main.selection.EliteSelection;
import de.evoal.optimisation.ea.main.selection.RandomSelection;

public class ReplacementTest {
    private final RandomGenerator random = RandomGeneratorFactory.of("L64X128MixRandom").create(1);

    /**
     * Selects the best candidates.
     */
    private final EliteSelection best = new EliteSelection(100, new RandomSelection());

    private final List<Candidate> parents = Candidates.withFitness(5.0, 1.0, 3.0, 7.0);

    private final List<Candidate> children = Candidates.withFitness(2.0, 6.0);

    @Test
    public void survivorReplacementKeepsAllChildrenAndTheSelectedParents() {
        final List<Candidate> next = new SurvivorReplacement(best).replace(parents, children, 4, CandidateOrder.BY_VALUE, random);

        Assertions.assertEquals(List.of(parents.get(1), parents.get(2), children.get(0), children.get(1)), next);
    }

    @Test
    public void plusReplacementSelectsFromParentsAndChildren() {
        final List<Candidate> next = new PlusReplacement(best).replace(parents, children, 4, CandidateOrder.BY_VALUE, random);

        Assertions.assertEquals(List.of(parents.get(1), children.get(0), parents.get(2), parents.get(0)), next);
    }

    @Test
    public void commaReplacementSelectsFromTheChildrenOnly() {
        final List<Candidate> next = new CommaReplacement(best).replace(parents, children, 2, CandidateOrder.BY_VALUE, random);

        Assertions.assertEquals(List.of(children.get(0), children.get(1)), next);
    }

    @Test
    public void theNumberOfChildrenMustFitTheReplacement() {
        Assertions.assertThrows(InitializationException.class, () -> new SurvivorReplacement(best).check(4, 5));
        Assertions.assertDoesNotThrow(() -> new SurvivorReplacement(best).check(4, 4));
        Assertions.assertThrows(InitializationException.class, () -> new CommaReplacement(best).check(4, 3));
        Assertions.assertDoesNotThrow(() -> new CommaReplacement(best).check(4, 4));
        Assertions.assertDoesNotThrow(() -> new PlusReplacement(best).check(4, 1));
    }
}
