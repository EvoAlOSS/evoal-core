package de.evoal.core.main.validation;

import static de.evoal.core.main.validation.ValidationModels.array;
import static de.evoal.core.main.validation.ValidationModels.assignment;
import static de.evoal.core.main.validation.ValidationModels.instance;
import static de.evoal.core.main.validation.ValidationModels.type;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.nio.file.Paths;

import jakarta.enterprise.event.Event;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.DefinitionsFactory;
import de.evoal.languages.model.base.definitions.EnumDefinition;
import de.evoal.languages.model.base.definitions.EnumLiteralDefinition;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.StringLiteral;
import de.evoal.languages.model.base.expressions.ValueDefinitionReference;
import de.evoal.languages.model.base.types.ArrayType;
import de.evoal.languages.model.base.types.ClassDefinitionReference;
import de.evoal.languages.model.base.types.EnumDefinitionReference;
import de.evoal.languages.model.base.types.Type;
import de.evoal.languages.model.base.types.TypesFactory;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.dl.DlFactory;
import de.evoal.languages.model.ol.AlgorithmInstance;
import de.evoal.languages.model.ol.OLFactory;
import de.evoal.languages.model.ol.OptimisationModule;

/**
 * Tests that the {@link AttributeTypeValidator} reports values that do not fit the type of
 *   their attribute, with their path.
 */
@ExtendWith(MockitoExtension.class)
public class AttributeTypeValidatorTest {
    @Mock
    private Event<Diagnostics> events;

    @Captor
    private ArgumentCaptor<Diagnostics> diagnostics;

    @InjectMocks
    private AttributeTypeValidator validator;

    /**
     * {@code abstract type recombination}.
     */
    private final ClassDefinition recombination = type("recombination");

    /**
     * {@code abstract type 'gene-exchange' extends recombination}.
     */
    private final ClassDefinition geneExchange = subtype("gene-exchange", recombination);

    /**
     * {@code type 'uniform-crossover' extends 'gene-exchange'}.
     */
    private final ClassDefinition uniform = subtype("uniform-crossover", geneExchange);

    /**
     * {@code type 'sbx-crossover' extends recombination}.
     */
    private final ClassDefinition sbx = subtype("sbx-crossover", recombination);

    /**
     * {@code nominal enum 'density-kind' ( 'source-based', both )}.
     */
    private final EnumDefinition densityKind = enumeration("density-kind", "source-based", "both");

    @Test
    public void anInstanceOfASubtypeIsAccepted() {
        // given: algorithm := linkage { crossover := 'uniform-crossover' {}; };
        final AttributeDefinition crossover = typed("crossover", instanceOf(geneExchange));

        // when
        validator.validate(configuration(crossover, instance(uniform)));

        // then
        verify(events, never()).fire(any());
    }

    @Test
    public void anInstanceOfAnotherTypeIsReportedWithItsPath() {
        // given: algorithm := linkage { crossover := 'sbx-crossover' {}; };
        final AttributeDefinition crossover = typed("crossover", instanceOf(geneExchange));

        // when
        validator.validate(configuration(crossover, instance(sbx)));

        // then
        final Diagnostics diagnostic = reported();
        Assertions.assertEquals(Diagnostics.Level.Error, diagnostic.level());
        Assertions.assertEquals("'crossover' expects an instance of 'gene-exchange', but 'sbx-crossover' is not a subtype of it.", diagnostic.message());
        Assertions.assertEquals("File: \"search.ol\" Path: \"algorithm.crossover\"", diagnostic.context().toString());
    }

    @Test
    public void aStringForAnInstanceIsReported() {
        // given: algorithm := linkage { crossover := "uniform"; };
        final AttributeDefinition crossover = typed("crossover", instanceOf(geneExchange));

        // when
        validator.validate(configuration(crossover, string("uniform")));

        // then
        Assertions.assertEquals("'crossover' expects an instance of 'gene-exchange', but the value is the string \"uniform\".", reported().message());
    }

    @Test
    public void everyElementOfAnArrayIsChecked() {
        // given: algorithm := linkage { crossovers := ['uniform-crossover' {}, 'sbx-crossover' {}]; };
        final ArrayType arrayType = TypesFactory.eINSTANCE.createArrayType();
        arrayType.setElements(instanceOf(geneExchange));
        final AttributeDefinition crossovers = typed("crossovers", arrayType);

        // when
        validator.validate(configuration(crossovers, array(instance(uniform), instance(sbx))));

        // then
        final Diagnostics diagnostic = reported();
        Assertions.assertEquals("'crossovers' expects an instance of 'gene-exchange', but 'sbx-crossover' is not a subtype of it.", diagnostic.message());
        Assertions.assertEquals("File: \"search.ol\" Path: \"algorithm.crossovers[1]\"", diagnostic.context().toString());
    }

    @Test
    public void aLiteralOfTheEnumIsAccepted() {
        // given: algorithm := density { kind := 'density-kind.both'; };
        final AttributeDefinition kind = typed("kind", enumOf(densityKind));

        // when
        validator.validate(configuration(kind, literal(densityKind, "both")));

        // then
        verify(events, never()).fire(any());
    }

    @Test
    public void aStringForAnEnumIsReported() {
        // given: algorithm := density { kind := "both"; };
        final AttributeDefinition kind = typed("kind", enumOf(densityKind));

        // when
        validator.validate(configuration(kind, string("both")));

        // then
        Assertions.assertEquals("'kind' expects a literal of the enum 'density-kind', but the value is the string \"both\".", reported().message());
    }

    @Test
    public void aLiteralOfAnotherEnumIsReported() {
        // given: algorithm := density { kind := 'check-reaction.warn'; };
        final EnumDefinition checkReaction = enumeration("check-reaction", "warn");
        final AttributeDefinition kind = typed("kind", enumOf(densityKind));

        // when
        validator.validate(configuration(kind, literal(checkReaction, "warn")));

        // then
        Assertions.assertEquals("'kind' expects a literal of the enum 'density-kind', but 'warn' is a literal of 'check-reaction'.", reported().message());
    }

    @Test
    public void aDlDefaultIsChecked() {
        // given: type linkage { crossover : instance 'gene-exchange' := 'sbx-crossover' {}; }
        final AttributeDefinition crossover = typed("crossover", instanceOf(geneExchange));
        crossover.setInitialisation(instance(sbx));
        final DefinitionModule module = DlFactory.eINSTANCE.createDefinitionModule();
        module.getTypes().add(type("linkage", crossover));

        // when
        validator.validate(resource("optimisation.dl", module));

        // then
        final Diagnostics diagnostic = reported();
        Assertions.assertEquals("'crossover' expects an instance of 'gene-exchange', but 'sbx-crossover' is not a subtype of it.", diagnostic.message());
        Assertions.assertEquals("File: \"optimisation.dl\" Path: \"linkage.crossover\"", diagnostic.context().toString());
    }

    @Test
    public void subtypesAreFoundThroughEveryLevel() {
        Assertions.assertTrue(AttributeTypeValidator.isSubtype(uniform, recombination));
        Assertions.assertTrue(AttributeTypeValidator.isSubtype(uniform, uniform));
        Assertions.assertFalse(AttributeTypeValidator.isSubtype(recombination, geneExchange));
        Assertions.assertFalse(AttributeTypeValidator.isSubtype(sbx, geneExchange));
    }

    private Diagnostics reported() {
        verify(events).fire(diagnostics.capture());
        return diagnostics.getValue();
    }

    /**
     * @return The resource of {@code algorithm := test { attribute := value; }}.
     */
    private static Resource configuration(final AttributeDefinition attribute, final Expression value) {
        final AlgorithmInstance algorithm = instance(OLFactory.eINSTANCE.createAlgorithmInstance(), type("test", attribute), assignment(attribute, value));
        final OptimisationModule module = OLFactory.eINSTANCE.createOptimisationModule();
        module.setAlgorithm(algorithm);

        return resource("search.ol", module);
    }

    private static Resource resource(final String file, final EObject module) {
        final Resource resource = new ResourceImpl(URI.createFileURI(Paths.get(file).toAbsolutePath().toString()));
        resource.getContents().add(module);
        return resource;
    }

    private static ClassDefinition subtype(final String name, final ClassDefinition superType) {
        final ClassDefinition type = type(name);
        type.setSuperType(superType);
        return type;
    }

    private static AttributeDefinition typed(final String name, final Type type) {
        final AttributeDefinition attribute = ValidationModels.attribute(name);
        attribute.setType(type);
        return attribute;
    }

    private static ClassDefinitionReference instanceOf(final ClassDefinition type) {
        final ClassDefinitionReference reference = TypesFactory.eINSTANCE.createClassDefinitionReference();
        reference.setDefinition(type);
        return reference;
    }

    private static EnumDefinitionReference enumOf(final EnumDefinition enumeration) {
        final EnumDefinitionReference reference = TypesFactory.eINSTANCE.createEnumDefinitionReference();
        reference.setDefinition(enumeration);
        return reference;
    }

    private static EnumDefinition enumeration(final String name, final String... literals) {
        final EnumDefinition enumeration = DefinitionsFactory.eINSTANCE.createEnumDefinition();
        enumeration.setName(name);
        for(final String literal : literals) {
            final EnumLiteralDefinition definition = DefinitionsFactory.eINSTANCE.createEnumLiteralDefinition();
            definition.setName(literal);
            enumeration.getLiterals().add(definition);
        }
        return enumeration;
    }

    private static ValueDefinitionReference literal(final EnumDefinition enumeration, final String name) {
        final ValueDefinitionReference reference = ExpressionsFactory.eINSTANCE.createValueDefinitionReference();
        reference.setDefinition(enumeration.getLiterals()
                                           .stream()
                                           .filter(l -> l.getName().equals(name))
                                           .findFirst()
                                           .orElseThrow());
        return reference;
    }

    private static StringLiteral string(final String value) {
        final StringLiteral literal = ExpressionsFactory.eINSTANCE.createStringLiteral();
        literal.setLiteral(value);
        return literal;
    }
}
