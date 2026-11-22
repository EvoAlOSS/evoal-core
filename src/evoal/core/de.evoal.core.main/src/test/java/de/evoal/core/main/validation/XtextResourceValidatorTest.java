package de.evoal.core.main.validation;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.core.api.validation.context.XtextResourceContext;
import de.evoal.core.api.validation.model.Diagnostics;
import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import jakarta.enterprise.event.Event;

/**
 * Tests that the {@link XtextResourceValidator} runs the Xtext validation of the languages, not
 *   only the parser, and reports its errors with the line.
 */
@ExtendWith(MockitoExtension.class)
public class XtextResourceValidatorTest {
    @Mock
    private Event<Diagnostics> events;

    @Captor
    private ArgumentCaptor<Diagnostics> diagnostics;

    @InjectMocks
    private XtextResourceValidator validator;

    /**
     * @return The DDL text, parsed as a resource with the given file name.
     */
    private static Resource parse(final String fileName, final String text) throws IOException {
        final XtextResourceSet resourceSet = new DataDescriptionLanguageStandaloneSetup()
                .createInjectorAndDoEMFRegistration()
                .getInstance(XtextResourceSet.class);
        final URI uri = URI.createURI(fileName);
        final Resource resource = resourceSet.createResource(uri);
        final byte[] content = text.getBytes(StandardCharsets.UTF_8);
        resource.load(new ByteArrayInputStream(content), Map.of());

        return resource;
    }

    /**
     * @return The diagnostics that the validator fired.
     */
    private List<Diagnostics> firedDiagnostics() {
        verify(events, atLeastOnce()).fire(diagnostics.capture());

        return diagnostics.getAllValues();
    }

    private static int lineOf(final Diagnostics diagnostic) {
        return ((XtextResourceContext) diagnostic.context()).getLine();
    }

    @Test
    public void aModuleNameThatDoesNotMatchTheFileNameIsAnError() throws IOException {
        // given
        final Resource resource = parse("renamed.ddl", """
                module other {
                    data:
                        quotient real data 'x';
                }
                """);

        // when
        Assertions.assertThrows(EvoalIOException.class, () -> validator.validate(resource));

        // then
        final List<Diagnostics> fired = firedDiagnostics();
        Assertions.assertEquals(1, fired.size());

        final Diagnostics diagnostic = fired.getFirst();
        Assertions.assertEquals(Diagnostics.Level.Error, diagnostic.level());
        Assertions.assertEquals("The filename is expected to be 'other.ddl'.", diagnostic.message());
        Assertions.assertEquals(1, lineOf(diagnostic));
    }

    @Test
    public void aComparisonOfANominalValueIsAnError() throws IOException {
        // given
        final Resource resource = parse("scale.ddl", """
                module scale {
                    data:
                        quotient real data 'x'
                            with constraints: "a" < 1.0;
                        ;
                }
                """);

        // when
        Assertions.assertThrows(EvoalIOException.class, () -> validator.validate(resource));

        // then
        final List<Diagnostics> fired = firedDiagnostics();
        Assertions.assertEquals(1, fired.size());

        final Diagnostics diagnostic = fired.getFirst();
        Assertions.assertEquals(Diagnostics.Level.Error, diagnostic.level());
        Assertions.assertEquals("Nominal scale for comparison is not allowed.", diagnostic.message());
        Assertions.assertEquals(4, lineOf(diagnostic));
    }

    @Test
    public void aParserErrorIsStillAnError() throws IOException {
        // given
        final Resource resource = parse("broken.ddl", """
                module broken {
                    data:
                        quotient real 'x';
                }
                """);

        // when
        Assertions.assertThrows(EvoalIOException.class, () -> validator.validate(resource));

        // then
        final List<Diagnostics> fired = firedDiagnostics();
        Assertions.assertTrue(fired.stream().anyMatch(d -> Diagnostics.Level.Error.equals(d.level())));
        Assertions.assertTrue(fired.stream().allMatch(d -> lineOf(d) == 3), fired.toString());
    }

    @Test
    public void aValidResourceHasNoDiagnostics() throws IOException {
        // given
        final Resource resource = parse("valid.ddl", """
                module valid {
                    data:
                        quotient real data 'x'
                            with constraints: 1.0 < 2.0;
                        ;
                }
                """);

        // when
        validator.validate(resource);

        // then
        verify(events, never()).fire(diagnostics.capture());
    }
}
