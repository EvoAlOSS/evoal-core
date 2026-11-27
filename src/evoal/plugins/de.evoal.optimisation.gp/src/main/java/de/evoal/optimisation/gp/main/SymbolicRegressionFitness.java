package de.evoal.optimisation.gp.main;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl;

import de.evoal.optimisation.gp.api.ExpressionEvaluator;
import de.evoal.optimisation.gp.api.ExpressionEvaluator.CompiledExpression;
import de.evoal.optimisation.gp.api.ExpressionFunctions;
import de.evoal.optimisation.gp.api.ExpressionTypes;

/**
 * The error of an expression on a reference table (DL type {@code 'symbolic-regression-fitness'},
 *   symbolic regression): the expression of a candidate is evaluated on every row with the values
 *   of its variables, and the error measure compares the predictions with the targets. The
 *   function checks when it is loaded that every tree of the search data can be evaluated and
 *   that the table has every value. It is deterministic and only reads the candidate.
 */
@Dependent
@Named("de.evoal.optimisation.gp.genetic-programming.symbolic-regression-fitness")
@Slf4j
public class SymbolicRegressionFitness extends OptimisationFunctionImpl {
    /**
     * The name of the DL type for messages.
     */
    private static final String NAME = "'symbolic-regression-fitness'";

    @Inject
    private DynamicEClassProvider dynamicClasses;

    /**
     * The objective that gets the error.
     */
    private EStructuralFeature error;

    /**
     * Evaluates the expressions.
     */
    private ExpressionEvaluator evaluator;

    /**
     * The search data with the expression.
     */
    private EReference function;

    @Inject
    private AttributeHelper helper;

    /**
     * The error measure.
     */
    private RegressionError measure;

    @Inject @Named("optimisation-space")
    private Space optimisationSpace;

    @Inject @Named("search-space")
    private Space searchSpace;

    /**
     * The rows of the reference table.
     */
    private ReferenceTable table;

    /**
     * Adds the variable type of a binding with the position of its value, and its data.
     */
    private void bind(final EObject binding, final Map<EClass, Integer> variables,
                      final List<EStructuralFeature> inputs) {
        final EObject variable = helper.lookup(binding, "variable");
        final EClass type = variable.eClass();
        if(variables.containsKey(type)) {
            throw new IllegalArgumentException("The variable type " + DynamicEClassProvider.dlTypeOf(type)
                                               + " has more than one binding in " + NAME + ".");
        }

        final EStructuralFeature bound = helper.lookup(binding, "data");
        final EStructuralFeature data = numericData(bound, "data");
        variables.put(type, inputs.size());
        inputs.add(data);
    }

    /**
     * Reads and checks the configuration except the reference table.
     *
     * @return The file of the reference table and the data of its columns.
     * @throws IllegalArgumentException if the configuration cannot be used.
     */
    TableColumns configure(final EObject configuration) {
        function = functionOf(configuration);

        final Map<EClass, Integer> variables = new LinkedHashMap<>();
        final List<EStructuralFeature> inputs = new ArrayList<>();
        final List<EObject> bindings = helper.lookup(configuration, "input");
        for(final EObject binding : bindings) {
            bind(binding, variables, inputs);
        }

        final EStructuralFeature outputData = helper.lookup(configuration, "output");
        final EStructuralFeature output = numericData(outputData, "output");
        error = objectiveOf(configuration);
        final EEnumLiteral measureLiteral = helper.lookup(configuration, "measure");
        measure = RegressionError.of(measureLiteral);

        evaluator = new ExpressionEvaluator(ExpressionFunctions.standard(), variables);
        final List<EClass> types = dynamicClasses.concreteSubclassesOf(function.getEReferenceType());
        final List<String> problems = evaluator.problemsOf(types);
        if(!problems.isEmpty()) {
            throw new IllegalArgumentException("The expressions of '" + function.getName() + "' cannot be evaluated by "
                                               + NAME + ": " + String.join("; ", problems) + ".");
        }

        final String reference = helper.lookup(configuration, "reference");

        return new TableColumns(new File(reference), inputs, output);
    }

    /**
     * @param root The root of an expression.
     * @return The error of the expression on the reference table.
     */
    double errorOf(final EObject root) {
        final CompiledExpression expression = evaluator.compile(root);
        final double[] predictions = new double[table.size()];
        for(int i = 0; i < predictions.length; ++i) {
            predictions[i] = expression.evaluate(table.inputs()[i]);
        }

        return measure.of(table.targets(), predictions);
    }

    @Override
    public TypedEObject evaluate(final TypedEObject candidate) {
        final EObject root = (EObject) candidate.eGet(function);
        final double value = errorOf(root);

        final Object converted = NumericConversions.toType(value, error.getEType());
        final TypedEObject result = optimisationSpace.newEObject();
        result.eSet(error, converted);

        return result;
    }

    private EReference functionOf(final EObject configuration) {
        final EStructuralFeature data = helper.lookup(configuration, "function");
        final EStructuralFeature found = searchSpace.find(data.getName()).orElse(null);
        if(!(found instanceof EReference reference)) {
            throw new IllegalArgumentException("The 'function' of " + NAME + " has to be structured search data, but '"
                                               + data.getName() + "' is not.");
        }

        final EClass rootType = reference.getEReferenceType();
        if(!ExpressionTypes.isExpression(rootType)) {
            throw new IllegalArgumentException("The 'function' of " + NAME + " has to be an 'expression', but '"
                                               + data.getName() + "' is " + rootType.getName() + ".");
        }

        return reference;
    }

    @Override
    public OptimisationFunction init(final EObject configuration) {
        final TableColumns columns = configure(configuration);
        table = ReferenceTable.read(columns.file(), columns.inputs(), columns.output());
        log.info("Symbolic regression of '{}' on the {} rows of '{}'.", function.getName(), table.size(),
                 columns.file());

        return this;
    }

    /**
     * {@inheritDoc}
     * <p>
     * The function only reads the candidate and the table.
     */
    @Override
    public boolean isThreadSafe() {
        return true;
    }

    private static EStructuralFeature numericData(final EStructuralFeature data, final String attribute) {
        if(!EClassifierHelper.isNumeric(data.getEType())) {
            throw new IllegalArgumentException("The '" + attribute + "' of " + NAME + " has to be numeric data, but '"
                                               + data.getName() + "' is " + data.getEType().getName() + ".");
        }

        return data;
    }

    private EStructuralFeature objectiveOf(final EObject configuration) {
        final EStructuralFeature data = helper.lookup(configuration, "error");
        final String message = "The 'error' of " + NAME + " has to be optimisation data, but '" + data.getName()
                               + "' is not.";
        final EStructuralFeature objective = optimisationSpace.find(data.getName())
                                                              .orElseThrow(() -> new IllegalArgumentException(message));

        return numericData(objective, "error");
    }

    /**
     * The reference table of the configuration.
     *
     * @param file The file of the table.
     * @param inputs The data of the variables, by the positions of the variable types.
     * @param output The data of the target.
     */
    record TableColumns(File file, List<EStructuralFeature> inputs, EStructuralFeature output) {
    }
}
