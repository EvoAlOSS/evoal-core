package de.evoal.core.api.languages.paths;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.languages.base.ElementSwitch;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.core.main.validation.constraints.MultiVariateChecker;
import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.ol.AlgorithmInstance;
import de.evoal.languages.model.ol.OptimisationModule;

/**
 * Path expressions on {@code configuration.ol} in {@code de/evoal/core/test/paths}: a
 *   {@code 'test-algorithm'} for the problem {@code 'p'} of another module (search variables
 *   {@code x} and {@code y}), with a swarm, a {@code 'special-mover'} (a {@code 'basic-mover'}),
 *   the criteria {@code 'count-criterion'} (maximum 100), {@code 'any-of'} [count 50,
 *   {@code 'any-of'} [count with the default 10]] and {@code 'all-of'} [count 1], the features
 *   [x, y] and two {@code 'decrease'}s with 10 and 11 iterations.
 */
public class PathEvaluatorTest {
    private final OptimisationModule module = LanguageHelper.loadFromClasspath("de/evoal/core/test/paths/configuration.ol");

    private final AlgorithmInstance algorithm = module.getAlgorithm();

    private final Instance mover = attribute(algorithm, "mover");

    private static Instance attribute(final Instance instance, final String name) {
        final Expression value = instance.findAttribute(name).getValue();

        return (Instance) ElementSwitch.elementOf(value).orElseThrow();
    }

    private List<Object> evaluate(final String path) {
        return PathEvaluator.evaluate(path, mover);
    }

    private static List<String> namesOf(final List<Object> selection) {
        return selection.stream()
                        .map(PathEvaluatorTest::nameOf)
                        .toList();
    }

    private static String nameOf(final Object node) {
        return switch(node) {
            case Instance instance -> instance.getDefinition().getName();
            case DataDescription data -> data.getName();
            default -> String.valueOf(node);
        };
    }

    private Instance decrease(final int index) {
        final Array decreases = (Array) ElementSwitch.elementOf(algorithm.findAttribute("decreases").getValue()).orElseThrow();

        return (Instance) ElementSwitch.elementOf(decreases.getValues().get(index)).orElseThrow();
    }

    @Test
    public void allChildrenAreTheAttributesOfAnInstance() {
        Assertions.assertEquals(List.of("count-criterion", "any-of", "all-of"), namesOf(evaluate("../*[criterion]")));
    }

    @Test
    public void anAttributeNotSetHasItsDefault() {
        Assertions.assertEquals(List.of(5), evaluate("../swarm/size"));
    }

    @Test
    public void anUnknownTypeIsRejectedWithItsPosition() {
        final PathException e = Assertions.assertThrows(PathException.class, () -> evaluate("..[unknown-mover]"));

        Assertions.assertEquals(3, e.getOffset());
        Assertions.assertTrue(e.getMessage().contains("unknown type 'unknown-mover'"), e.getMessage());
    }

    @Test
    public void aRepetitionAtLeastOnceStartsBelowTheSelection() {
        Assertions.assertEquals(List.of(50, 10), evaluate("/algorithm/criteria([any-of]/criteria)+[count-criterion]/maximum"));
    }

    @Test
    public void aRepetitionDescendsOnlyThroughTheRepeatedPath() {
        Assertions.assertEquals(List.of(100, 50, 10), evaluate("/algorithm/criteria([any-of]/criteria)*[count-criterion]/maximum"));
    }

    @Test
    public void arraysSelectTheirElementsAndDataReferencesTheData() {
        Assertions.assertEquals(List.of("x", "y"), namesOf(evaluate("../features")));
    }

    @Test
    public void descendantsIncludeEveryLevel() {
        Assertions.assertEquals(4, evaluate("//[count-criterion]").size());
    }

    @Test
    public void exactlyExcludesSubtypes() {
        Assertions.assertEquals(List.of(), evaluate("../mover[exactly basic-mover]"));
        Assertions.assertEquals(List.of("special-mover"), namesOf(evaluate("../mover[exactly special-mover]")));
    }

    @Test
    public void aTypeFilterIncludesSubtypes() {
        Assertions.assertEquals(List.of("special-mover"), namesOf(evaluate("../mover[basic-mover]")));
        Assertions.assertEquals(List.of("special-mover"), namesOf(evaluate("../mover[mover]")));
    }

    @Test
    public void theBoundProblemIsReachedAlsoInAnotherModule() {
        Assertions.assertEquals(List.of("x", "y"), namesOf(evaluate("/algorithm/problem/searchSpace")));
    }

    @Test
    public void theParentIsTheContainingInstance() {
        Assertions.assertEquals(List.of(algorithm), evaluate(".."));
    }

    @Test
    public void theRootIsTheModule() {
        Assertions.assertEquals(List.of(module), evaluate("/"));
        Assertions.assertEquals(List.of(algorithm), evaluate("/algorithm"));
    }

    @Test
    public void theSelfIsTheStart() {
        Assertions.assertEquals(List.of(mover), evaluate("."));
    }

    @Test
    public void typeFiltersOnTheConfigureBlockUseItsDlType() {
        final ClassDefinition type = algorithm.getDefinition();

        Assertions.assertEquals("test-algorithm", type.getName());
        Assertions.assertEquals(List.of(algorithm), evaluate("..[test-algorithm]"));
    }

    @Test
    public void unionsSelectEveryObjectOnce() {
        Assertions.assertEquals(List.of("special-mover", "swarm"), namesOf(evaluate("../mover | ../swarm | ../mover")));
    }

    @Test
    public void unknownNamesSelectNothing() {
        Assertions.assertEquals(List.of(), evaluate("../unknown"));
    }

    @Test
    public void valuesHaveNoParent() {
        Assertions.assertEquals(List.of(), evaluate("../swarm/size/.."));
    }

    @Test
    public void constraintsUseTheSelectionsOfPaths() {
        final ClassDefinition type = decrease(0).getDefinition();
        final Instance annotation = (Instance) ElementSwitch.elementOf(type.getConstraints().getFirst()).orElseThrow();
        final MultiVariateChecker checker = new MultiVariateChecker(annotation.findAttribute("expression").getValue());

        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, checker.check(decrease(0)));
        Assertions.assertInstanceOf(ConstraintCheck.Violated.class, checker.check(decrease(1)));
    }
}
