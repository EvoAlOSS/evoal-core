package de.evoal.optimisation.gp.main;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.gp.Expressions;

/**
 * The fitness on the terminals x0, x1 and c: the configuration checks of the DL configuration and
 *   both error measures on a small table.
 */
public class SymbolicRegressionFitnessTest {
    private final EClass data = EcoreFactory.eINSTANCE.createEClass();

    private EAttribute error;

    private final Expressions expressions = new Expressions("de/evoal/optimisation/gp/test/terms.dl");

    private EReference function;

    private final SymbolicRegressionFitness fitness = new SymbolicRegressionFitness();

    private Space optimisationSpace;

    private Space searchSpace;

    private EAttribute x0;

    private EAttribute x1;

    private EAttribute y;

    @BeforeEach
    public void createTheSpaces() throws ReflectiveOperationException {
        final EClass search = EcoreFactory.eINSTANCE.createEClass();
        function = EcoreFactory.eINSTANCE.createEReference();
        function.setName("f");
        function.setContainment(true);
        function.setEType(expressions.library("expression"));
        search.getEStructuralFeatures().add(function);
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(search);
        searchSpace = new Space(search);

        final EClass objectives = EcoreFactory.eINSTANCE.createEClass();
        error = attribute(objectives, "error");
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(objectives);
        optimisationSpace = new Space(objectives);

        x0 = attribute(data, "x0");
        x1 = attribute(data, "x1");
        y = attribute(data, "y");
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(data);

        final AttributeHelper helper = new AttributeHelper();
        inject(AttributeHelper.class, helper, "evaluator", new AttributeEvaluator());
        inject(SymbolicRegressionFitness.class, fitness, "helper", helper);
        inject(SymbolicRegressionFitness.class, fitness, "dynamicClasses", expressions.dynamicClasses());
        inject(SymbolicRegressionFitness.class, fitness, "searchSpace", searchSpace);
        inject(SymbolicRegressionFitness.class, fitness, "optimisationSpace", optimisationSpace);
    }

    private static EAttribute attribute(final EClass owner, final String name) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);
        owner.getEStructuralFeatures().add(attribute);

        return attribute;
    }

    private static void inject(final Class<?> type, final Object target, final String name, final Object value)
            throws ReflectiveOperationException {
        final Field field = type.getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }

    private EObject binding(final String variable, final EStructuralFeature column) {
        final EObject binding = expressions.node(expressions.library("variable-binding"));
        set(binding, "variable", expressions.variable(variable));
        set(binding, "data", column);

        return binding;
    }

    @SuppressWarnings("unchecked")
    private EObject configuration(final String measure, final EStructuralFeature functionData, final EObject... bindings) {
        final EObject configuration = expressions.node(expressions.library("symbolic-regression-fitness"));
        set(configuration, "function", functionData);
        final EList<EObject> input = (EList<EObject>) configuration.eGet(configuration.eClass().getEStructuralFeature("input"));
        input.addAll(List.of(bindings));
        set(configuration, "output", y);
        set(configuration, "reference", "table.csv");
        set(configuration, "error", error);

        final EStructuralFeature measureAttribute = configuration.eClass().getEStructuralFeature("measure");
        final EEnum measures = (EEnum) measureAttribute.getEType();
        configuration.eSet(measureAttribute, measures.getEEnumLiteral(measure));

        return configuration;
    }

    private static void set(final EObject object, final String name, final Object value) {
        object.eSet(object.eClass().getEStructuralFeature(name), value);
    }

    /**
     * @return x0 + 2 * x1.
     */
    private EObject expression() {
        final EObject product = expressions.function("multiply", expressions.constant("c", 2.0), expressions.variable("x1"));

        return expressions.function("plus", expressions.variable("x0"), product);
    }

    private IllegalArgumentException rejected(final EObject configuration) {
        return Assertions.assertThrows(IllegalArgumentException.class, () -> fitness.configure(configuration));
    }

    private void useTable(final double[][] inputs, final double[] targets) throws ReflectiveOperationException {
        inject(SymbolicRegressionFitness.class, fitness, "table", new ReferenceTable(inputs, targets));
    }

    @Test
    public void theConfigurationNamesTheTableAndItsColumns() {
        // when
        final SymbolicRegressionFitness.TableColumns columns = fitness.configure(
                configuration("mean-squared-error", function, binding("x1", x1), binding("x0", x0)));

        // then: the inputs follow the bindings
        Assertions.assertEquals(new File("table.csv"), columns.file());
        Assertions.assertEquals(List.of(x1, x0), columns.inputs());
        Assertions.assertSame(y, columns.output());
    }

    @Test
    public void bothMeasuresCompareThePredictionsWithTheTargets() throws ReflectiveOperationException {
        // given: the predictions of x0 + 2 * x1 are 5, 4 and 0
        final double[][] rows = {{1.0, 2.0}, {4.0, 0.0}, {-2.0, 1.0}};
        final double[] targets = {5.0, 6.0, 3.0};

        // when
        fitness.configure(configuration("sum-of-absolute-errors", function, binding("x0", x0), binding("x1", x1)));
        useTable(rows, targets);
        final double sumOfAbsoluteErrors = fitness.errorOf(expression());

        fitness.configure(configuration("mean-squared-error", function, binding("x0", x0), binding("x1", x1)));
        useTable(rows, targets);
        final double meanSquaredError = fitness.errorOf(expression());

        // then
        Assertions.assertEquals(5.0, sumOfAbsoluteErrors);
        Assertions.assertEquals(13.0 / 3.0, meanSquaredError, 1e-12);
    }

    @Test
    public void theErrorIsTheObjective() throws ReflectiveOperationException {
        // given
        fitness.configure(configuration("sum-of-absolute-errors", function, binding("x0", x0), binding("x1", x1)));
        useTable(new double[][] {{1.0, 1.0}}, new double[] {10.0});
        final TypedEObject candidate = searchSpace.newEObject();
        candidate.eSet(function, expression());

        // when
        final TypedEObject result = fitness.evaluate(candidate);

        // then
        Assertions.assertEquals(7.0, result.eGet(error));
    }

    @Test
    public void aNonFinitePredictionGivesANonFiniteError() throws ReflectiveOperationException {
        // given
        fitness.configure(configuration("mean-squared-error", function, binding("x0", x0), binding("x1", x1)));
        useTable(new double[][] {{1e200, 1e200}}, new double[] {0.0});
        final EObject product = expressions.function("multiply", expressions.variable("x0"), expressions.variable("x1"));

        // then
        Assertions.assertEquals(Double.POSITIVE_INFINITY, fitness.errorOf(product));
    }

    @Test
    public void everyVariableTypeNeedsABinding() {
        // when
        final IllegalArgumentException failure = rejected(configuration("mean-squared-error", function, binding("x0", x0)));

        // then
        Assertions.assertEquals("The expressions of 'f' cannot be evaluated by 'symbolic-regression-fitness': the variable "
                                + "type de.evoal.optimisation.gp.test.terms.x1 has no binding.", failure.getMessage());
    }

    @Test
    public void aVariableTypeHasOneBinding() {
        // when
        final IllegalArgumentException failure = rejected(configuration("mean-squared-error", function, binding("x0", x0),
                                                                         binding("x1", x1), binding("x0", y)));

        // then
        Assertions.assertEquals("The variable type de.evoal.optimisation.gp.test.terms.x0 has more than one binding in "
                                + "'symbolic-regression-fitness'.", failure.getMessage());
    }

    @Test
    public void theFunctionIsStructuredSearchData() {
        // when
        final IllegalArgumentException failure = rejected(configuration("mean-squared-error", x0, binding("x0", x0),
                                                                         binding("x1", x1)));

        // then
        Assertions.assertEquals("The 'function' of 'symbolic-regression-fitness' has to be structured search data, but 'x0' "
                                + "is not.", failure.getMessage());
    }

    @Test
    public void theErrorIsOptimisationData() {
        // given
        final EObject configuration = configuration("mean-squared-error", function, binding("x0", x0), binding("x1", x1));
        set(configuration, "error", y);

        // when
        final IllegalArgumentException failure = rejected(configuration);

        // then
        Assertions.assertEquals("The 'error' of 'symbolic-regression-fitness' has to be optimisation data, but 'y' is not.",
                                failure.getMessage());
    }

    @Test
    public void everyRowHasEveryValue() {
        // given
        final Space columns = ReferenceTable.columnsOf(List.of(x0, x1), y);
        final List<EStructuralFeature> features = List.copyOf(columns);
        final TypedEObject complete = columns.newEObject();
        final TypedEObject withoutX1 = columns.newEObject();
        for(final EStructuralFeature feature : features) {
            complete.eSet(feature, 1.0);
            if(!"x1".equals(feature.getName())) {
                withoutX1.eSet(feature, 2.0);
            }
        }
        final File file = new File("table.csv");

        // when
        final ReferenceTable table = ReferenceTable.of(file, columns, List.of(complete));
        final IllegalArgumentException missing = Assertions.assertThrows(IllegalArgumentException.class,
                () -> ReferenceTable.of(file, columns, List.of(complete, withoutX1)));
        final IllegalArgumentException empty = Assertions.assertThrows(IllegalArgumentException.class,
                () -> ReferenceTable.of(file, columns, List.of()));

        // then
        Assertions.assertEquals(List.of("x0", "x1", "y"), features.stream().map(EStructuralFeature::getName).toList());
        Assertions.assertEquals(1, table.size());
        Assertions.assertArrayEquals(new double[] {1.0, 1.0}, table.inputs()[0]);
        Assertions.assertEquals("Row 2 of the reference table 'table.csv' has no value of 'x1'.", missing.getMessage());
        Assertions.assertEquals("The reference table 'table.csv' has no rows.", empty.getMessage());
    }
}
