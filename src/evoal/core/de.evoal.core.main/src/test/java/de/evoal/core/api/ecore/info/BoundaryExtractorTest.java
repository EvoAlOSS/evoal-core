package de.evoal.core.api.ecore.info;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.ecore.info.BoundaryExtractor.Bound;
import de.evoal.core.api.ecore.info.BoundaryExtractor.Extracted;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.DataTypeTypeDefinition;
import de.evoal.languages.model.base.definitions.DefinitionsFactory;
import de.evoal.languages.model.base.definitions.TypedBaseDataDescription;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.BooleanLiteral;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.RealLiteral;
import de.evoal.languages.model.base.types.TypesFactory;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.dl.DlFactory;

public class BoundaryExtractorTest {
    private static final DefinitionsFactory definitions = DefinitionsFactory.eINSTANCE;
    private static final ExpressionsFactory expressions = ExpressionsFactory.eINSTANCE;

    /** The DL module de.evoal.core.constraints with LowerBoundary and UpperBoundary. */
    private final DefinitionModule constraints = constraintsModule(BoundaryExtractor.CONSTRAINTS_MODULE);

    private static DefinitionModule constraintsModule(final String name) {
        final DefinitionModule module = DlFactory.eINSTANCE.createDefinitionModule();
        module.setName(name);

        for(final String type : new String[] {BoundaryExtractor.LOWER_BOUNDARY, BoundaryExtractor.UPPER_BOUNDARY}) {
            final ClassDefinition definition = definitions.createClassDefinition();
            definition.setName(type);

            final AttributeDefinition boundary = definitions.createAttributeDefinition();
            boundary.setName("boundary");
            boundary.setType(TypesFactory.eINSTANCE.createLiteralType());
            definition.getAttributes().add(boundary);

            final AttributeDefinition inclusive = definitions.createAttributeDefinition();
            inclusive.setName("inclusive");
            inclusive.setType(TypesFactory.eINSTANCE.createBooleanType());
            final BooleanLiteral defaultValue = expressions.createBooleanLiteral();
            defaultValue.setLiteral(true);
            inclusive.setInitialisation(defaultValue);
            definition.getAttributes().add(inclusive);

            module.getTypes().add(definition);
        }

        return module;
    }

    private static Instance boundary(final DefinitionModule module, final String type, final double value, final Boolean inclusive) {
        final ClassDefinition definition = module.getTypes().stream().filter(t -> type.equals(t.getName())).findFirst().get();

        final Instance instance = expressions.createInstance();
        instance.setDefinition(definition);

        final RealLiteral literal = expressions.createRealLiteral();
        literal.setLiteral(value);
        instance.getAttributes().add(attribute(definition.findAttribute("boundary"), literal));

        if(inclusive != null) {
            final BooleanLiteral flag = expressions.createBooleanLiteral();
            flag.setLiteral(inclusive);
            instance.getAttributes().add(attribute(definition.findAttribute("inclusive"), flag));
        }

        return instance;
    }

    private static Attribute attribute(final AttributeDefinition definition, final de.evoal.languages.model.base.expressions.Expression value) {
        final Attribute attribute = expressions.createAttribute();
        attribute.setDefinition(definition);
        attribute.setValue(value);
        return attribute;
    }

    private Instance lower(final double value, final Boolean inclusive) {
        return boundary(constraints, BoundaryExtractor.LOWER_BOUNDARY, value, inclusive);
    }

    private Instance upper(final double value, final Boolean inclusive) {
        return boundary(constraints, BoundaryExtractor.UPPER_BOUNDARY, value, inclusive);
    }

    private static DataDescription data(final Instance... constraints) {
        final DataDescription description = definitions.createUntypedBaseDataDescription();
        description.setName("x");
        for(final Instance constraint : constraints) {
            description.getConstraints().add(constraint);
        }
        return description;
    }

    @Test
    public void noBoundaries() {
        Assertions.assertTrue(BoundaryExtractor.extract(data()).isEmpty());
    }

    @Test
    public void lowerAndUpperWithDefaultAndExplicitInclusion() {
        final Extracted result = BoundaryExtractor.extract(data(lower(-5.12, null), upper(5.12, false)));

        Assertions.assertEquals(new Bound(-5.12, true), result.lower().get());
        Assertions.assertEquals(new Bound(5.12, false), result.upper().get());
    }

    @Test
    public void onlyOneSide() {
        final Extracted result = BoundaryExtractor.extract(data(lower(0.0, null)));

        Assertions.assertEquals(new Bound(0.0, true), result.lower().get());
        Assertions.assertTrue(result.upper().isEmpty());
    }

    @Test
    public void tightestBoundaryWins() {
        final Extracted result = BoundaryExtractor.extract(data(lower(-10.0, null), lower(-5.0, null), lower(-5.0, false),
                                                                upper(10.0, null), upper(7.0, null)));

        Assertions.assertEquals(new Bound(-5.0, false), result.lower().get());
        Assertions.assertEquals(new Bound(7.0, true), result.upper().get());
    }

    @Test
    public void constraintsOfTheDataTypeAreConsidered() {
        final DataTypeTypeDefinition type = definitions.createDataTypeTypeDefinition();
        type.setName("percentage");
        type.getConstraints().add(lower(0.0, null));
        type.getConstraints().add(upper(100.0, null));

        final TypedBaseDataDescription description = definitions.createTypedBaseDataDescription();
        description.setName("x");
        description.setType(type);
        description.getConstraints().add(upper(50.0, null));

        final Extracted result = BoundaryExtractor.extract(description);

        Assertions.assertEquals(new Bound(0.0, true), result.lower().get());
        Assertions.assertEquals(new Bound(50.0, true), result.upper().get());
    }

    @Test
    public void contradictingBoundariesAreRejected() {
        Assertions.assertThrows(IllegalStateException.class, () -> BoundaryExtractor.extract(data(lower(1.0, null), upper(0.0, null))));
        Assertions.assertThrows(IllegalStateException.class, () -> BoundaryExtractor.extract(data(lower(1.0, false), upper(1.0, null))));
        Assertions.assertDoesNotThrow(() -> BoundaryExtractor.extract(data(lower(1.0, null), upper(1.0, null))));
    }

    @Test
    public void boundariesOfOtherModulesAreIgnored() {
        final DefinitionModule other = constraintsModule("com.example.constraints");
        final DataDescription description = data(boundary(other, BoundaryExtractor.LOWER_BOUNDARY, 1.0, null));

        Assertions.assertTrue(BoundaryExtractor.extract(description).isEmpty());
    }

    @Test
    public void boundariesAreAttachedToTheFeatureAndReadBack() {
        final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
        feature.setName("x");
        feature.setEType(EcorePackage.Literals.EDOUBLE);

        FeatureBoundaries.annotate(feature, BoundaryExtractor.extract(data(lower(-5.12, null), upper(5.12, false))));

        final FeatureBoundaries.Boundaries boundaries = new FeatureBoundaries().get(feature);
        Assertions.assertEquals(-5.12, boundaries.lower());
        Assertions.assertTrue(boundaries.lowerIncluded());
        Assertions.assertEquals(5.12, boundaries.upper());
        Assertions.assertFalse(boundaries.UpperIncluded());
    }

    @Test
    public void missingSideUsesTheRangeOfTheType() {
        final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
        feature.setName("x");
        feature.setEType(EcorePackage.Literals.EDOUBLE);

        FeatureBoundaries.annotate(feature, BoundaryExtractor.extract(data(lower(0.0, null))));

        final FeatureBoundaries.Boundaries boundaries = new FeatureBoundaries().get(feature);
        Assertions.assertEquals(0.0, boundaries.lower());
        Assertions.assertEquals(Double.MAX_VALUE, boundaries.upper());

        final EAttribute unbounded = EcoreFactory.eINSTANCE.createEAttribute();
        unbounded.setName("y");
        unbounded.setEType(EcorePackage.Literals.EDOUBLE);
        Assertions.assertEquals(-Double.MAX_VALUE, new FeatureBoundaries().get(unbounded).lower());
    }

    @Test
    public void integerBoundariesAreConvertedWithoutLoss() {
        final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
        feature.setName("n");
        feature.setEType(EcorePackage.Literals.EINT);

        FeatureBoundaries.annotate(feature, BoundaryExtractor.extract(data(lower(3.0, null))));
        Assertions.assertEquals(3, new FeatureBoundaries().get(feature).lower());

        final EAttribute fractional = EcoreFactory.eINSTANCE.createEAttribute();
        fractional.setName("m");
        fractional.setEType(EcorePackage.Literals.EINT);
        Assertions.assertThrows(IllegalStateException.class,
                () -> FeatureBoundaries.annotate(fractional, BoundaryExtractor.extract(data(lower(0.5, null)))));
    }
}
