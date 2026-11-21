package de.evoal.core.api.languages;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;

public class ExpressionTextTest {
    /**
     * @return The first (outermost) expression of the parsed DDL text, e.g., an annotation.
     */
    private static Expression firstExpressionOf(final String text) throws Exception {
        final XtextResourceSet resourceSet = new DataDescriptionLanguageStandaloneSetup()
                .createInjectorAndDoEMFRegistration()
                .getInstance(XtextResourceSet.class);
        final Resource resource = resourceSet.createResource(URI.createURI("test.ddl"));
        resource.load(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)), Map.of());

        final TreeIterator<EObject> contents = resource.getAllContents();
        while(contents.hasNext()) {
            if(contents.next() instanceof Expression expression) {
                return expression;
            }
        }

        throw new IllegalStateException("The text has no expression.");
    }

    @Test
    public void aParsedExpressionIsItsSourceTextWithoutComments() throws Exception {
        // given
        final Expression expression = firstExpressionOf("""
                module test {
                    data:
                        @Boundary { 'boundary' := 2.5   * /* factor */ 2.0; }
                        quotient real data 'x';
                }
                """);

        // when
        final String text = ExpressionText.of(expression);

        // then
        Assertions.assertEquals("Boundary { 'boundary' := 2.5 * 2.0; }", text);
    }

    @Test
    public void anExpressionWithoutSourceIsItsToString() {
        // given
        final Expression expression = ExpressionsFactory.eINSTANCE.createIntegerLiteral();

        // when
        final String text = ExpressionText.of(expression);

        // then
        Assertions.assertEquals(expression.toString(), text);
    }
}
