package de.evoal.core.main.validation;

import static de.evoal.core.main.validation.ValidationModels.assignment;
import static de.evoal.core.main.validation.ValidationModels.attribute;
import static de.evoal.core.main.validation.ValidationModels.instance;
import static de.evoal.core.main.validation.ValidationModels.type;
import static org.mockito.Mockito.verify;

import java.nio.file.Paths;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.evoal.core.api.validation.model.Diagnostics;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.ol.AlgorithmInstance;
import de.evoal.languages.model.ol.OLFactory;
import de.evoal.languages.model.ol.OptimisationModule;
import jakarta.enterprise.event.Event;

/**
 * Tests that the {@link AttributeExistsValidator} reports a missing required attribute with its
 *   path.
 */
@ExtendWith(MockitoExtension.class)
public class AttributeExistsValidatorTest {
    @Mock
    private Event<Diagnostics> events;

    @Captor
    private ArgumentCaptor<Diagnostics> diagnostics;

    @InjectMocks
    private AttributeExistsValidator validator;

    @Test
    public void aMissingRequiredAttributeIsReportedWithItsPath() {
        // given: algorithm := ea { given := 1; }; with the attributes given, optional and required
        final AttributeDefinition given = attribute("given");
        final AttributeDefinition optional = attribute("optional");
        optional.setOptional(true);
        final AttributeDefinition required = attribute("required");
        final AlgorithmInstance algorithm = instance(OLFactory.eINSTANCE.createAlgorithmInstance(), type("ea", given, optional, required), assignment(given, ExpressionsFactory.eINSTANCE.createIntegerLiteral()));
        final OptimisationModule module = OLFactory.eINSTANCE.createOptimisationModule();
        module.setAlgorithm(algorithm);
        final Resource resource = new ResourceImpl(URI.createFileURI(Paths.get("search.ol").toAbsolutePath().toString()));
        resource.getContents().add(module);

        // when
        validator.validate(resource);

        // then
        verify(events).fire(diagnostics.capture());
        final Diagnostics diagnostic = diagnostics.getValue();
        Assertions.assertEquals(Diagnostics.Level.Error, diagnostic.level());
        Assertions.assertEquals("Required attribute 'required' not specified.", diagnostic.message());
        Assertions.assertEquals("File: \"search.ol\" Path: \"algorithm.required\"", diagnostic.context().toString());
    }
}
