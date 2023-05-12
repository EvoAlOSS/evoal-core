package de.evoal.core.api.utils;

import org.junit.jupiter.api.*;
import org.jboss.weld.junit5.EnableWeld;

import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.ol.OptimisationModel;

import javax.inject.Inject;


@EnableWeld
public class LanguageHelperUnitTest {
    /*
    @Inject
    private LanguageHelper helper;

    @Order(1)
    @Test
    public void testLoading() {
        final OptimisationModel model = de.evoal.core.junit.dsl.LanguageHelper.loadFromClasspath("de/evoal/core/api/utils/LanguageHelperTest.ol");
        final Instance instance = model.getProblem();

        Assertions.assertNotNull(instance);
    }

    @Test
    public void testLookupForNullInstance() {
        Assertions.assertThrows(IllegalStateException.class, () -> helper.lookup((Instance)null, "child"));
    }

    @Test
    public void testLookupForNullPath() {
        final OptimisationModel model = de.evoal.core.junit.dsl.LanguageHelper.loadFromClasspath("de/evoal/core/api/utils/LanguageHelperTest.ol");
        final Instance instance = model.getProblem();

        Assertions.assertThrows(IllegalArgumentException.class, () -> helper.lookup(instance, null));
    }

    @Test
    public void testLookupForEmptyPath() {
        final OptimisationModel model = de.evoal.core.junit.dsl.LanguageHelper.loadFromClasspath("de/evoal/core/api/utils/LanguageHelperTest.ol");
        final Instance instance = model.getProblem();

        final Object result = helper.lookup(instance, "");

        Assertions.assertNotNull(result);
        Assertions.assertSame(instance, result);
    }

    @Test
    public void testLookupForExistingChild() {
        final OptimisationModel model = de.evoal.core.junit.dsl.LanguageHelper.loadFromClasspath("de/evoal/core/api/utils/LanguageHelperTest.ol");
        final Instance instance = model.getProblem();

        final Object result = helper.lookup(instance, "child");

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result instanceof Instance);

        final Instance child = (Instance)result;
        Assertions.assertEquals("A", child.getDefinition().getName());
    }

    @Test
    public void testLookupName() {
        final OptimisationModel model = de.evoal.core.junit.dsl.LanguageHelper.loadFromClasspath("de/evoal/core/api/utils/LanguageHelperTest.ol");
        final Instance instance = model.getProblem();

        final Object result = helper.lookup(instance, "name");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("parent", result);
   }

    @Test
    public void testLookupChildOfLiteral() {
        final OptimisationModel model = de.evoal.core.junit.dsl.LanguageHelper.loadFromClasspath("de/evoal/core/api/utils/LanguageHelperTest.ol");
        final Instance instance = model.getProblem();

        Assertions.assertThrows(IllegalStateException.class, () -> helper.lookup(instance, "child.string-field.non-existing"));
    }

    @Test
    public void testLookupNonExistingChild() {
        final OptimisationModel model = de.evoal.core.junit.dsl.LanguageHelper.loadFromClasspath("de/evoal/core/api/utils/LanguageHelperTest.ol");
        final Instance instance = model.getProblem();

        Assertions.assertThrows(IllegalStateException.class, () -> helper.lookup(instance, "child.non-existing"));
    }

    @Test
    public void testLookupBooleanField() {
        final OptimisationModel model = de.evoal.core.junit.dsl.LanguageHelper.loadFromClasspath("de/evoal/core/api/utils/LanguageHelperTest.ol");
        final Instance instance = model.getProblem();

        final Object result = helper.lookup(instance, "child.boolean-field");

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result instanceof Boolean);
        Assertions.assertEquals(true, result);
    }

    @Test
    public void testLookupFlotField() {
        final OptimisationModel model = de.evoal.core.junit.dsl.LanguageHelper.loadFromClasspath("de/evoal/core/api/utils/LanguageHelperTest.ol");
        final Instance instance = model.getProblem();

        final Object result = helper.lookup(instance, "child.float-field");

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result instanceof Double);
        Assertions.assertEquals(1.3, result);
    }

    @Test
    public void testLookupIntegerField() {
        final OptimisationModel model = de.evoal.core.junit.dsl.LanguageHelper.loadFromClasspath("de/evoal/core/api/utils/LanguageHelperTest.ol");
        final Instance instance = model.getProblem();

        final Object result = helper.lookup(instance, "child.integer-field");

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result instanceof Integer);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void testLookupStringField() {
        final OptimisationModel model = de.evoal.core.junit.dsl.LanguageHelper.loadFromClasspath("de/evoal/core/api/utils/LanguageHelperTest.ol");
        final Instance instance = model.getProblem();

        final Object result = helper.lookup(instance, "child.string-field");

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result instanceof String);
        Assertions.assertEquals("FOOBAR", result);
    }

    @Test
    public void testLookup1DArrayField() {
        final OptimisationModel model = de.evoal.core.junit.dsl.LanguageHelper.loadFromClasspath("de/evoal/core/api/utils/LanguageHelperTest.ol");
        final Instance instance = model.getProblem();

        final Object result = helper.lookup(instance, "child.array-1D-float");

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result instanceof Object []);

        final Object [] array = (Object[]) result;
        Assertions.assertEquals(3, array.length);
        Assertions.assertEquals(4.2, array[0]);
        Assertions.assertEquals(3.1, array[1]);
        Assertions.assertEquals(1.0, array[2]);
    }

    @Test
    public void testLookup2DArrayField() {
        final OptimisationModel model = de.evoal.core.junit.dsl.LanguageHelper.loadFromClasspath("de/evoal/core/api/utils/LanguageHelperTest.ol");
        final Instance instance = model.getProblem();

        final Object result = helper.lookup(instance, "child.array-2D-int");

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result instanceof Object []);

        final Object [] array = (Object[]) result;
        Assertions.assertEquals(3, array.length);

        final Object [] array0 = (Object[]) array[0];
        final Object [] array1 = (Object[]) array[1];
        final Object [] array2 = (Object[]) array[2];

        Assertions.assertEquals(5, array0.length);
        Assertions.assertEquals(3, array1.length);
        Assertions.assertEquals(1, array2.length);

        Assertions.assertEquals(1, array0[0]);
        Assertions.assertEquals(2, array0[1]);
        Assertions.assertEquals(3, array0[2]);
        Assertions.assertEquals(4, array0[3]);
        Assertions.assertEquals(5, array0[4]);

        Assertions.assertEquals(3, array1[0]);
        Assertions.assertEquals(2, array1[1]);
        Assertions.assertEquals(1, array1[2]);

        Assertions.assertEquals(42, array2[0]);
    }
     */
}
