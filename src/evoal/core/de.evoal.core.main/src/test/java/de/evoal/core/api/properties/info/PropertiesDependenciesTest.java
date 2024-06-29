package de.evoal.core.api.properties.info;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesDependenciesTest {

    private PropertySpecification property1;
    private PropertySpecification property2;
    private PropertySpecification property3;
    private PropertiesSpecification propertiesSpecification;

    @BeforeEach
    void setUp() {
        property1 = new PropertySpecification("property1", null);
        property2 = new PropertySpecification("property2", null);
        property3 = new PropertySpecification("property3", null);

        Set<PropertySpecification> propertySet = new HashSet<>();
        propertySet.add(property1);
        propertySet.add(property2);

        propertiesSpecification = new PropertiesSpecification(propertySet);
    }

    @Test
    void testConstructorInitializesDependencies() {
        PropertiesDependencies propertiesDependencies = new PropertiesDependencies(propertiesSpecification);

        assertNotNull(propertiesDependencies.get(property1));
        assertNotNull(propertiesDependencies.get(property2));
        assertTrue(propertiesDependencies.get(property1).isEmpty());
        assertTrue(propertiesDependencies.get(property2).isEmpty());
    }

    @Test
    void testAddDependencies() {
        PropertiesDependencies propertiesDependencies = new PropertiesDependencies(propertiesSpecification);

        Set<PropertySpecification> deps = new HashSet<>();
        deps.add(property3);
        PropertiesSpecification dependenciesSpecification = new PropertiesSpecification(deps);

        propertiesDependencies.add(property1, dependenciesSpecification);

        assertTrue(propertiesDependencies.get(property1).contains(property3));
    }

    @Test
    void testGetDependencies() {
        PropertiesDependencies propertiesDependencies = new PropertiesDependencies(propertiesSpecification);

        Set<PropertySpecification> deps = new HashSet<>();
        deps.add(property3);
        PropertiesSpecification dependenciesSpecification = new PropertiesSpecification(deps);

        propertiesDependencies.add(property2, dependenciesSpecification);

        Set<PropertySpecification> result = propertiesDependencies.get(property2);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.contains(property3));
    }
}