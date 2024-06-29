package de.evoal.core.api.properties.info;

import de.evoal.core.api.properties.PropertySpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesRangesTest {

    @Test
    void testPutAndGet() {
        final PropertySpecification property = new PropertySpecification("property", null);
        final PropertiesRanges testee = new PropertiesRanges();

        testee.put(property, 10.5);

        final Double result = testee.get(property);
        assertNotNull(result);
        assertEquals(10.5, result);
    }

    @Test
    void testGetNonExistentProperty() {
        final PropertySpecification property = new PropertySpecification("property", null);
        final PropertiesRanges testee = new PropertiesRanges();

        Double result = testee.get(property);
        assertNull(result);
    }

    @Test
    void testUpdateValue() {
        final PropertySpecification property = new PropertySpecification("property", null);
        final PropertiesRanges testee = new PropertiesRanges();

        testee.put(property, 10.5);
        testee.put(property, 20.5);

        Double result = testee.get(property);
        assertNotNull(result);
        assertEquals(20.5, result);
    }
}
