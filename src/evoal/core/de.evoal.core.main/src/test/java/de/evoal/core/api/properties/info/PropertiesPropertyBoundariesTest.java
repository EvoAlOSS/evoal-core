package de.evoal.core.api.properties.info;

import de.evoal.core.api.properties.PropertySpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesPropertyBoundariesTest {

    private PropertySpecification property1;
    private PropertySpecification property2;
    private PropertiesBoundaries propertiesBoundaries;

    @BeforeEach
    void setUp() {
        property1 = new PropertySpecification("property1", null);
        property2 = new PropertySpecification("property2", null);
        propertiesBoundaries = new PropertiesBoundaries();
    }

    @Test
    void testAddAndContains() {
        PropertyBoundaries boundaries = new PropertyBoundaries(0, true, 100, true);
        propertiesBoundaries.add(property1, boundaries);

        assertTrue(propertiesBoundaries.contains(property1));
        assertFalse(propertiesBoundaries.contains(property2));
    }

    @Test
    void testGetBoundaries() {
        PropertyBoundaries boundaries = new PropertyBoundaries(0, true, 100, true);
        propertiesBoundaries.add(property1, boundaries);

        PropertyBoundaries result = propertiesBoundaries.get(property1);
        assertNotNull(result);
        assertEquals(boundaries.lower(), result.lower());
        assertEquals(boundaries.upper(), result.upper());
    }

    @Test
    void testGetSpecifications() {
        PropertyBoundaries boundaries1 = new PropertyBoundaries(0, true, 100, true);
        PropertyBoundaries boundaries2 = new PropertyBoundaries(10, true, 200, true);
        propertiesBoundaries.add(property1, boundaries1);
        propertiesBoundaries.add(property2, boundaries2);

        Collection<PropertySpecification> specifications = propertiesBoundaries.getSpecifications();
        assertEquals(2, specifications.size());
        assertTrue(specifications.contains(property1));
        assertTrue(specifications.contains(property2));
    }

    @Test
    void testToString() {
        PropertyBoundaries boundaries1 = new PropertyBoundaries(0, true, 100, true);
        PropertyBoundaries boundaries2 = new PropertyBoundaries(10, true, 200, true);
        propertiesBoundaries.add(property1, boundaries1);
        propertiesBoundaries.add(property2, boundaries2);

        String expected = "PropertiesBoundaries [10 <= property2 <= 200, 0 <= property1 <= 100, ]";
        assertEquals(expected, propertiesBoundaries.toString());
    }
}
