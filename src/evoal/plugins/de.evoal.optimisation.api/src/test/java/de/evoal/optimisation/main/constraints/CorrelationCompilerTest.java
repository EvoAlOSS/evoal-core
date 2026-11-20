package de.evoal.optimisation.main.constraints;

import java.util.List;

import org.apache.commons.math3.util.Pair;
import org.eclipse.emf.ecore.EClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.DefinitionsFactory;
import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.base.definitions.RepresentationType;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.languages.model.base.definitions.UntypedBaseDataDescription;
import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.Call;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.RealLiteral;
import de.evoal.languages.model.base.expressions.TypeDefinitionReference;
import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.languages.model.ddl.DdlFactory;
import de.evoal.languages.model.ol.MinimiseGoal;
import de.evoal.languages.model.ol.OLFactory;
import de.evoal.languages.model.ol.ProblemInstance;

import de.evoal.optimisation.api.correlations.BuildingBlock;
import de.evoal.optimisation.api.correlations.Correlation;
import de.evoal.optimisation.api.correlations.CorrelationKind;
import de.evoal.optimisation.api.correlations.CorrelationRange;
import de.evoal.optimisation.api.correlations.Correlations;
import de.evoal.optimisation.api.correlations.LinkageGroup;

/**
 * The {@link CorrelationCompiler} on DDL correlations and building blocks built as syntax
 *   trees: a problem searches
 *   for the quotient features {@code x0}, {@code x1}, the ordinal feature {@code o} and the
 *   nominal feature {@code n}, and minimises {@code y}.
 */
public class CorrelationCompilerTest {
    private static final ExpressionsFactory EXPRESSIONS = ExpressionsFactory.eINSTANCE;

    private final CorrelationCompiler compiler = new CorrelationCompiler(new EAnnotationHelper());

    private final DataDescriptionModule module = DdlFactory.eINSTANCE.createDataDescriptionModule();

    private final DataDescription x0 = description("x0", ScaleType.QUOTIENT);

    private final DataDescription x1 = description("x1", ScaleType.QUOTIENT);

    private final DataDescription o = description("o", ScaleType.ORDINAL);

    private final DataDescription n = description("n", ScaleType.NOMINAL);

    private final DataDescription y = description("y", ScaleType.QUOTIENT);

    private EClass objectiveClass;

    private EClass searchClass;

    private static Array array(final TypeDefinitionReference... values) {
        final Array array = EXPRESSIONS.createArray();
        array.getValues().addAll(List.of(values));

        return array;
    }

    private static Call call(final String function, final Expression... parameters) {
        final FunctionDefinition definition = DefinitionsFactory.eINSTANCE.createFunctionDefinition();
        definition.setName(function);

        final Call call = EXPRESSIONS.createCall();
        call.setFunction(definition);
        call.getParameters().addAll(List.of(parameters));

        return call;
    }

    private void declare(final Call call) {
        module.getConstraints().add(call);
    }

    private static TypeDefinitionReference data(final DataDescription description) {
        final TypeDefinitionReference reference = EXPRESSIONS.createTypeDefinitionReference();
        reference.setDefinition(description);

        return reference;
    }

    private DataDescription description(final String name, final ScaleType scale) {
        final UntypedBaseDataDescription description = DefinitionsFactory.eINSTANCE.createUntypedBaseDataDescription();
        description.setName(name);
        description.setScale(scale);
        description.setRepresentation(RepresentationType.REAL);
        module.getDescriptions().add(description);

        return description;
    }

    private static RealLiteral number(final double value) {
        final RealLiteral literal = EXPRESSIONS.createRealLiteral();
        literal.setLiteral(value);

        return literal;
    }

    private Correlations compile() {
        return compiler.compile(searchClass.getEAllStructuralFeatures(), objectiveClass.getEAllStructuralFeatures());
    }

    @BeforeEach
    public void createProblem() {
        final ProblemInstance problem = OLFactory.eINSTANCE.createProblemInstance();
        for(final DataDescription searched : List.of(x0, x1, o, n)) {
            problem.getSearchSpace().add(data(searched));
        }

        final MinimiseGoal goal = OLFactory.eINSTANCE.createMinimiseGoal();
        goal.setData(data(y));
        problem.getOptimisationSpace().add(goal);

        final Pair<EClass, EClass> spaces = new EClassProvider().eClassFor(problem);
        searchClass = spaces.getFirst();
        objectiveClass = spaces.getSecond();
    }

    @Test
    public void correlationsAreNumberedInTheOrderOfTheDdlWithTheirKind() {
        // given
        declare(call("correlation", data(x0), data(x1), number(0.9)));
        declare(call("constraint", data(x0), data(x1)));
        declare(call("correlation", data(x0), data(o), number(-0.5)));
        declare(call("correlation", data(o), data(n), number(0.2)));

        // when
        final List<Correlation> correlations = compile().all();

        // then
        Assertions.assertEquals(3, correlations.size());
        final Correlation first = correlations.getFirst();
        Assertions.assertEquals(1, first.number());
        Assertions.assertEquals(searchClass.getEStructuralFeature("x0"), first.first());
        Assertions.assertEquals(searchClass.getEStructuralFeature("x1"), first.second());
        Assertions.assertEquals(0.9, first.coefficient());
        Assertions.assertFalse(first.isRanged());
        Assertions.assertEquals(List.of(CorrelationKind.LINEAR, CorrelationKind.RANK, CorrelationKind.NOMINAL),
                                correlations.stream().map(Correlation::kind).toList());
    }

    @Test
    public void aRangedCorrelationHasARangePerFeature() {
        // given
        declare(call("ranged-correlation", data(x0), call("range", number(1.0), number(4.0)),
                     data(x1), call("range", number(-5.12), number(-3.0)), number(0.9)));

        // when
        final Correlation correlation = compile().all().getFirst();

        // then
        Assertions.assertEquals(new CorrelationRange(1.0, 4.0), correlation.firstRange());
        Assertions.assertEquals(new CorrelationRange(-5.12, -3.0), correlation.secondRange());
        Assertions.assertTrue(correlation.appliesTo(2.0, -4.0));
        Assertions.assertFalse(correlation.appliesTo(0.5, -4.0));
        Assertions.assertFalse(correlation.appliesTo(2.0, 0.0));
    }

    @Test
    public void aCorrelationWithAnObjectiveIsRejected() {
        declare(call("correlation", data(x0), data(y), number(0.5)));

        Assertions.assertThrows(IllegalArgumentException.class, this::compile);
    }

    @Test
    public void aCoefficientOutsideTheUnitIntervalIsRejected() {
        declare(call("correlation", data(x0), data(x1), number(1.5)));

        Assertions.assertThrows(IllegalArgumentException.class, this::compile);
    }

    @Test
    public void aFeatureCannotBeCorrelatedWithItself() {
        declare(call("correlation", data(x0), data(x0), number(0.5)));

        Assertions.assertThrows(IllegalArgumentException.class, this::compile);
    }

    @Test
    public void anEmptyRangeIsRejected() {
        declare(call("ranged-correlation", data(x0), call("range", number(4.0), number(1.0)),
                     data(x1), call("range", number(0.0), number(1.0)), number(0.9)));

        Assertions.assertThrows(IllegalArgumentException.class, this::compile);
    }

    @Test
    public void aMissingParameterIsRejected() {
        declare(call("correlation", data(x0), data(x1)));

        Assertions.assertThrows(IllegalArgumentException.class, this::compile);
    }

    @Test
    public void aBuildingBlockHasItsFeaturesInTheOrderOfTheDdl() {
        // given
        declare(call("building-block", array(data(x1), data(o), data(x0))));

        // when
        final Correlations declared = compile();

        // then
        Assertions.assertEquals(List.of(), declared.all());
        Assertions.assertFalse(declared.isEmpty());
        final BuildingBlock block = declared.buildingBlocks().getFirst();
        Assertions.assertEquals(1, block.number());
        Assertions.assertEquals(List.of(searchClass.getEStructuralFeature("x1"), searchClass.getEStructuralFeature("o"),
                                        searchClass.getEStructuralFeature("x0")),
                                block.features());
    }

    @Test
    public void correlationsAndBuildingBlocksKeepTheOrderOfTheDdlAndAreNumberedSeparately() {
        // given
        declare(call("building-block", array(data(x0), data(x1))));
        declare(call("correlation", data(x0), data(o), number(0.5)));
        declare(call("building-block", array(data(x1), data(o), data(n))));

        // when
        final List<LinkageGroup> groups = compile().linkageGroups();

        // then
        Assertions.assertEquals(3, groups.size());
        Assertions.assertEquals(1, ((BuildingBlock) groups.get(0)).number());
        Assertions.assertEquals(1, ((Correlation) groups.get(1)).number());
        Assertions.assertEquals(2, ((BuildingBlock) groups.get(2)).number());
    }

    @Test
    public void buildingBlocksMayOverlap() {
        declare(call("building-block", array(data(x0), data(x1))));
        declare(call("building-block", array(data(x1), data(o))));

        Assertions.assertEquals(2, compile().buildingBlocks().size());
    }

    @Test
    public void aBuildingBlockWithOneFeatureIsRejected() {
        declare(call("building-block", array(data(x0))));

        Assertions.assertThrows(IllegalArgumentException.class, this::compile);
    }

    @Test
    public void aBuildingBlockWithAFeatureTwiceIsRejected() {
        declare(call("building-block", array(data(x0), data(x1), data(x0))));

        Assertions.assertThrows(IllegalArgumentException.class, this::compile);
    }

    @Test
    public void aBuildingBlockWithAnObjectiveIsRejected() {
        declare(call("building-block", array(data(x0), data(y))));

        Assertions.assertThrows(IllegalArgumentException.class, this::compile);
    }

    @Test
    public void aBuildingBlockWhoseParameterIsNoArrayIsRejected() {
        declare(call("building-block", data(x0), data(x1)));

        Assertions.assertThrows(IllegalArgumentException.class, this::compile);
    }

    @Test
    public void aBuildingBlockWithANumberIsRejected() {
        final Array array = array(data(x0), data(x1));
        array.getValues().add(number(1.0));
        declare(call("building-block", array));

        Assertions.assertThrows(IllegalArgumentException.class, this::compile);
    }
}
