package de.evoal.core.main.fitness;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.optimisation.main.fitness.RandomFitness;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RandomFitnessTest {

    @Mock
    private PropertiesSpecification specification;

    @Mock
    private Properties candidate;

    @InjectMocks
    private RandomFitness randomFitness;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(specification.size()).thenReturn(5);
    }

    @Test
    void testEvaluate() {
        double[] result = randomFitness.evaluate(candidate);

        assertNotNull(result);
        assertEquals(5, result.length);

        for (double value : result) {
            assertTrue(value >= 0.0 && value < 1.0);
        }
    }

    @Test
    void testEvaluateDifferentValues() {
        double[] result1 = randomFitness.evaluate(candidate);
        double[] result2 = randomFitness.evaluate(candidate);

        assertNotNull(result1);
        assertNotNull(result2);
        assertEquals(5, result1.length);
        assertEquals(5, result2.length);

        // Check that results are likely different
        boolean areDifferent = false;
        for (int i = 0; i < result1.length; i++) {
            if (result1[i] != result2[i]) {
                areDifferent = true;
                break;
            }
        }

        assertTrue(areDifferent, "Random values should differ between evaluations.");
    }
}