package de.evoal.core.api.correlations;

import de.evoal.core.api.properties.Properties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CorrelationsTest {

    @Mock
    private Properties properties;

    @Mock
    private Correlation correlation1;

    @Mock
    private Correlation correlation2;

    @InjectMocks
    private Correlations correlations;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Setup Correlations list
        correlations.getCorrelations().add(correlation1);
        correlations.getCorrelations().add(correlation2);
    }

    @Test
    void testFindCorrelations() {
        int chromosomeIndex = 1;
        Number candidateValue = 42;

        when(properties.get(chromosomeIndex)).thenReturn(candidateValue);
        when(correlation1.matchesSource(chromosomeIndex, candidateValue)).thenReturn(true);
        when(correlation2.matchesSource(chromosomeIndex, candidateValue)).thenReturn(false);

        List<Correlation> result = correlations.find(properties, chromosomeIndex);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.contains(correlation1));
        assertFalse(result.contains(correlation2));
    }

    @Test
    void testFindCorrelationRootNoMatch() {
        int chromosomeIndex = 1;
        double candidateValue = 42.0;

        when(properties.getAsDouble(chromosomeIndex)).thenReturn(candidateValue);
        when(correlation1.matchesTarget(chromosomeIndex, candidateValue)).thenReturn(false);
        when(correlation2.matchesTarget(chromosomeIndex, candidateValue)).thenReturn(false);

        int result = correlations.findCorrelationRoot(properties, chromosomeIndex);

        assertEquals(chromosomeIndex, result);
    }

    @Test
    void testFindCorrelationRootWithMatch() {
        int chromosomeIndex = 1;
        int sourceIndex = 0;
        double candidateValue = 42.0;
        double sourceValue = 24.0;

        when(properties.getAsDouble(chromosomeIndex)).thenReturn(candidateValue);
        when(properties.getAsDouble(sourceIndex)).thenReturn(sourceValue);
        when(correlation1.matchesTarget(chromosomeIndex, candidateValue)).thenReturn(true);
        when(correlation1.getChromosomeOne()).thenReturn(sourceIndex);
        when(correlation1.matchesSource(sourceIndex, sourceValue)).thenReturn(true);

        int result = correlations.findCorrelationRoot(properties, chromosomeIndex);

        assertEquals(sourceIndex, result);
    }

    @Test
    void testFindCorrelationRootRecursive() {
        int chromosomeIndex = 1;
        int intermediateIndex = 2;
        int sourceIndex = 0;
        double candidateValue = 42.0;
        double intermediateValue = 36.0;
        double sourceValue = 24.0;

        when(properties.getAsDouble(chromosomeIndex)).thenReturn(candidateValue);
        when(properties.getAsDouble(intermediateIndex)).thenReturn(intermediateValue);
        when(properties.getAsDouble(sourceIndex)).thenReturn(sourceValue);

        when(correlation1.matchesTarget(chromosomeIndex, candidateValue)).thenReturn(true);
        when(correlation1.getChromosomeOne()).thenReturn(intermediateIndex);
        when(correlation1.matchesSource(intermediateIndex, intermediateValue)).thenReturn(true);

        when(correlation2.matchesTarget(intermediateIndex, intermediateValue)).thenReturn(true);
        when(correlation2.getChromosomeOne()).thenReturn(sourceIndex);
        when(correlation2.matchesSource(sourceIndex, sourceValue)).thenReturn(true);

        int result = correlations.findCorrelationRoot(properties, chromosomeIndex);

        assertEquals(sourceIndex, result);
    }
}