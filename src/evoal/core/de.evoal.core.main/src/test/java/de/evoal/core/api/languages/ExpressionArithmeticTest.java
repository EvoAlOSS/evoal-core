package de.evoal.core.api.languages;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.languages.base.ElementSwitch;
import de.evoal.core.api.utils.ConstantSwitch;
import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import de.evoal.languages.model.interpreter.ConstantEvaluator;

/**
 * Tests how the languages parse and compute arithmetic (#332): numbers have no sign of their
 *   own, so {@code 4-1} is a subtraction; an operator may repeat; {@code /} divides as reals;
 *   array elements are expressions.
 */
public class ExpressionArithmeticTest {
    /**
     * @return The value of the first attribute in the DDL text, whose annotation is
     *   {@code @A { 'a' := <expression>; }}. Fails on syntax errors; unresolved references (the
     *   annotation type) do not matter here.
     */
    private static Expression parse(final String expression) throws IOException {
        final XtextResourceSet resourceSet = new DataDescriptionLanguageStandaloneSetup()
                .createInjectorAndDoEMFRegistration()
                .getInstance(XtextResourceSet.class);
        final Resource resource = resourceSet.createResource(URI.createURI("test.ddl"));
        final String text = """
                module test {
                    data:
                        @A { 'a' := %s; }
                        quotient real data 'x';
                }
                """.formatted(expression);
        resource.load(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)), Map.of());

        final List<String> syntaxErrors = resource.getErrors()
                                                  .stream()
                                                  .filter(XtextSyntaxDiagnostic.class::isInstance)
                                                  .map(Resource.Diagnostic::getMessage)
                                                  .toList();
        Assertions.assertTrue(syntaxErrors.isEmpty(), () -> expression + ": " + syntaxErrors);

        final TreeIterator<EObject> contents = resource.getAllContents();
        while(contents.hasNext()) {
            if(contents.next() instanceof Attribute attribute) {
                return attribute.getValue();
            }
        }

        throw new IllegalStateException("The text has no attribute.");
    }

    private static Object evaluate(final String expression) throws IOException {
        return new ConstantEvaluator().doSwitch(parse(expression));
    }

    @Test
    public void aSubtractionNeedsNoSpaces() throws IOException {
        Assertions.assertEquals(3, evaluate("4-1"));
        Assertions.assertEquals(3, evaluate("4 - 1"));
        Assertions.assertEquals(2.5, evaluate("4.0-1.5"));
    }

    @Test
    public void aNegativeNumberIsAUnaryMinus() throws IOException {
        Assertions.assertEquals(-4, evaluate("-4"));
        Assertions.assertEquals(-4, evaluate("- 4"));
        Assertions.assertEquals(-5.12, evaluate("-5.12"));
        Assertions.assertEquals(7, evaluate("4 - -3"));
    }

    @Test
    public void theSignOfTheExponentStaysPartOfTheNumber() throws IOException {
        Assertions.assertEquals(1.0e-4, evaluate("1.0e-4"));
        Assertions.assertEquals(-2.0e-4, evaluate("-2e-4"));
    }

    @Test
    public void aRepeatedOperatorIsKept() throws IOException {
        Assertions.assertEquals(5, evaluate("10 - 3 - 2"));
        Assertions.assertEquals(40, evaluate("2 * 5 * 4"));
        Assertions.assertEquals(0.9, (Double) evaluate("0.5 + 0.2 + 0.2"), 1.0e-12);
        Assertions.assertEquals(4, evaluate("- - 4"));
    }

    @Test
    public void aDivisionOfIntegersIsAReal() throws IOException {
        Assertions.assertEquals(0.2, evaluate("1 / 5"));
        Assertions.assertEquals(5.0, evaluate("10 / 2"));
    }

    @Test
    public void arrayElementsAreExpressions() throws IOException {
        Assertions.assertEquals(List.of(-1, 2), evaluate("[-1, 2]"));
        Assertions.assertEquals(List.of(-10.0, 0.0), evaluate("[-10.00, 0.0]"));
        Assertions.assertEquals(List.of(2, 6, 0.5), evaluate("[1 + 1, 2 * 3, 1 / 2]"));
    }

    @Test
    public void callArgumentsMayBeNegative() throws IOException {
        // only parsed: the function is not defined here
        parse("range(-5.12, -3.00)");
    }

    @Test
    public void anArrayElementWithoutOperatorIsFoundAsSuch() throws IOException {
        final Expression array = parse("[1, - 2, 1 + 2]");
        final Array arrayElement = (Array) ElementSwitch.elementOf(array).orElseThrow();
        final List<Expression> elements = List.copyOf(arrayElement.getValues());

        Assertions.assertTrue(ElementSwitch.elementOf(elements.get(0)).isPresent());
        Assertions.assertTrue(ElementSwitch.elementOf(elements.get(1)).isEmpty());
        Assertions.assertTrue(ElementSwitch.elementOf(elements.get(2)).isEmpty());
    }

    @Test
    public void aConstantMayBeNegative() throws IOException {
        Assertions.assertEquals(-4, ConstantSwitch.findConstant(parse("-4")));
        Assertions.assertEquals(-2.5, ConstantSwitch.findConstant(parse("-2.5")));
        Assertions.assertEquals(4, ConstantSwitch.findConstant(parse("- - 4")));
    }
}
