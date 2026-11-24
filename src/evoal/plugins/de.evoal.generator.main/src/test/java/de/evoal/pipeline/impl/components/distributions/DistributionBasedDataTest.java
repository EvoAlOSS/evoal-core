package de.evoal.pipeline.impl.components.distributions;

import java.util.Arrays;
import java.util.List;
import java.util.random.RandomGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.definitions.BaseDataDescription;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.pipeline.api.distribution.Distribution;

/**
 * 'distribution-based-data' ({@link DistributionBasedData}) on the data of {@code mixed.ddl}:
 *   real 'x', quotient integer 'n', real 'y', nominal integer 'variant', 'typed-variant' of a
 *   nominal type, 'unscaled' without a scale, and 'temperature' of a cardinal type.
 */
public class DistributionBasedDataTest {
    private final Space pipeline = new Space(new EClassProvider().eClassFor(
            LanguageHelper.<DataDescriptionModule>loadFromClasspath("de/evoal/pipeline/test/mixed.ddl")));

    private static RandomGenerator seeded(final long seed) {
        return RandomStreams.of(RandomService.withSeed(seed)).forNewInstance("test");
    }

    private DistributionBasedData step(final List<Distribution> distributions, final String... writes) {
        final DistributionBasedData step = new DistributionBasedData(new EAnnotationHelper());
        step.setFeatures(pipeline, pipeline.subSpace(List.of()),
                         pipeline.subSpace(Arrays.stream(writes).map(name -> pipeline.find(name).orElseThrow())));
        step.configure(distributions, distributions.stream().map(d -> d.getClass().getSimpleName()).toList());

        return step;
    }

    @Test
    public void dataHasItsDeclaredScaleTheScaleOfItsTypeOrNominal() {
        final DataDescriptionModule module = LanguageHelper.loadFromClasspath("de/evoal/pipeline/test/mixed.ddl");

        Assertions.assertEquals(ScaleType.QUOTIENT, scaleOf(module, "x"));
        Assertions.assertEquals(ScaleType.NOMINAL, scaleOf(module, "variant"));
        Assertions.assertEquals(ScaleType.NOMINAL, scaleOf(module, "typed-variant"));
        Assertions.assertEquals(ScaleType.NOMINAL, scaleOf(module, "unscaled"));
        Assertions.assertEquals(ScaleType.CARDINAL, scaleOf(module, "temperature"));
    }

    private static ScaleType scaleOf(final DataDescriptionModule module, final String name) {
        return module.getDescriptions()
                     .stream()
                     .filter(description -> name.equals(description.getName()))
                     .map(description -> ((BaseDataDescription) description).getScale())
                     .findFirst()
                     .orElseThrow();
    }

    @Test
    public void discreteValuesAreWrittenAsIntegers() {
        final DistributionBasedData step = step(List.of(new NormalDistribution(0.0, 1.0, seeded(1)),
                                                        new PoissonDistribution(3.0, seeded(2)),
                                                        new UniformDistribution(0.0, 1.0, seeded(3))),
                                                "x", "n", "y");

        final TypedEObject row = step.apply(pipeline.newEObject());

        Assertions.assertInstanceOf(Double.class, row.eGet(pipeline.find("x").orElseThrow()));
        Assertions.assertInstanceOf(Integer.class, row.eGet(pipeline.find("n").orElseThrow()));
        Assertions.assertInstanceOf(Double.class, row.eGet(pipeline.find("y").orElseThrow()));
    }

    @Test
    public void aDifferentNumberOfValuesIsRejected() {
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> step(List.of(new NormalDistribution(0.0, 1.0, seeded(1))), "x", "y"));

        Assertions.assertTrue(e.getMessage().contains("writes 2 data, but its distributions give 1 values"), e.getMessage());
    }

    @Test
    public void discreteValuesForRealDataAreRejected() {
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> step(List.of(new PoissonDistribution(3.0, seeded(1))), "x"));

        Assertions.assertTrue(e.getMessage().contains("'x', which is not integer data"), e.getMessage());
    }

    @Test
    public void categoriesAreWrittenToNominalData() {
        final DistributionBasedData step = step(List.of(categories()), "variant");

        final TypedEObject row = step.apply(pipeline.newEObject());

        Assertions.assertInstanceOf(Integer.class, row.eGet(pipeline.find("variant").orElseThrow()));
    }

    @Test
    public void categoriesTakeTheScaleOfATypeOrTheNominalDefault() {
        Assertions.assertDoesNotThrow(() -> step(List.of(categories()), "typed-variant"));
        Assertions.assertDoesNotThrow(() -> step(List.of(categories()), "unscaled"));
    }

    @Test
    public void categoriesForQuotientDataAreRejected() {
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> step(List.of(categories()), "n"));

        Assertions.assertTrue(e.getMessage().contains("'n', whose scale is quotient; categories need nominal or ordinal data"),
                              e.getMessage());
    }

    @Test
    public void categoriesOfACopulaMarginalAreChecked() {
        final CopulaDistribution copula = new CopulaDistribution(new IndependenceCopula(),
                List.of(new NormalDistribution(0.0, 1.0, seeded(1)), categories()),
                new SobolSequence(new double[] {0.0, 0.0}, new double[] {1.0, 1.0}, new RandomShift(), seeded(2)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> step(List.of(copula), "x", "n"));
        Assertions.assertDoesNotThrow(() -> step(List.of(copula), "x", "variant"));
    }

    private static CategoricalDistribution categories() {
        return new CategoricalDistribution(new int[] {1, 2, 3}, new double[] {0.2, 0.5, 0.3}, seeded(3));
    }

    @Test
    public void continuousValuesForIntegerDataAreRejected() {
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> step(List.of(new NormalDistribution(0.0, 1.0, seeded(1))), "n"));

        Assertions.assertTrue(e.getMessage().contains("'n', which is not real data"), e.getMessage());
    }
}
