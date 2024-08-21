package de.evoal.core.main.comparator;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.optimisation.main.comparator.HierarchicalComparator;
import de.evoal.optimisation.main.comparator.HierarchicalValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HierarchicalComparatorTest {

    @Mock
    private PropertiesSpecification optimisationSpecification;

    @Mock
    private AttributeEvaluator evaluator;

    @Mock
    private Instance config;

    @InjectMocks
    private HierarchicalComparator comparator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testToValue() {
        int[] orderIndices = {0, 1, 2};
        double[] fitnessValues = {0.5, 0.7, 0.9};

        comparator.init(mockConfig(orderIndices));

        HierarchicalValue result = comparator.toValue(fitnessValues);

        assertArrayEquals(fitnessValues, result.getFitnessValues(), 0.0001);
    }

    @Test
    void testInit() {
        int[] orderIndices = {0, 2, 1};
        DataDescription[] order = {
                mockDataDescription("a"),
                mockDataDescription("b"),
                mockDataDescription("c")
        };

        when(evaluator.attributeToDataDescriptionArray(config, "order")).thenReturn(order);
        when(optimisationSpecification.indexOf("a")).thenReturn(0);
        when(optimisationSpecification.indexOf("b")).thenReturn(2);
        when(optimisationSpecification.indexOf("c")).thenReturn(1);

        HierarchicalComparator result = comparator.init(config);

        assertNotNull(result);
        assertSame(comparator, result);
    }

    private DataDescription mockDataDescription(String name) {
        DataDescription description = mock(DataDescription.class);
        when(description.getName()).thenReturn(name);
        return description;
    }

    private Instance mockConfig(int[] indices) {
        DataDescription[] descriptions = new DataDescription[indices.length];
        for (int i = 0; i < indices.length; i++) {
            descriptions[i] = mockDataDescription("attribute" + i);
            when(optimisationSpecification.indexOf("attribute" + i)).thenReturn(indices[i]);
        }
        when(evaluator.attributeToDataDescriptionArray(any(), eq("order"))).thenReturn(descriptions);
        return mock(Instance.class);
    }
}