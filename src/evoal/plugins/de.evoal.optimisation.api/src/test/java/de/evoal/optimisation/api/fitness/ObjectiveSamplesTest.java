package de.evoal.optimisation.api.fitness;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.evaluation.SampleAggregation;

public class ObjectiveSamplesTest {
    /**
     * An optimisation space with the real objectives {@code y} and {@code z}.
     */
    static final Space SPACE = space("y", "z");

    static final EAttribute Y = (EAttribute) SPACE.getEClass().getEStructuralFeature("y");

    static final EAttribute Z = (EAttribute) SPACE.getEClass().getEStructuralFeature("z");

    private static Space space(final String... names) {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.setName("Objectives");
        for(final String name : names) {
            final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
            attribute.setName(name);
            attribute.setEType(EcorePackage.Literals.EDOUBLE);
            eClass.getEStructuralFeatures().add(attribute);
        }
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    /**
     * @return Objectives with the values of {@code y} and {@code z}.
     */
    static TypedEObject objectives(final double y, final double z) {
        final TypedEObject objectives = SPACE.newEObject();
        objectives.eSet(Y, y);
        objectives.eSet(Z, z);

        return objectives;
    }

    @Nested
    @DisplayName("given the aggregations")
    class Aggregations {
        @Test
        public void theMeanIsTheArithmeticMean() {
            Assertions.assertEquals(2.0, SampleAggregation.MEAN.apply(new double[] { 1.0, 2.0, 3.0 }));
        }

        @Test
        public void theMedianOfAnOddNumberIsTheMiddleSample() {
            Assertions.assertEquals(2.0, SampleAggregation.MEDIAN.apply(new double[] { 9.0, 1.0, 2.0 }));
        }

        @Test
        public void theMedianOfAnEvenNumberIsTheMeanOfTheMiddleSamples() {
            Assertions.assertEquals(2.5, SampleAggregation.MEDIAN.apply(new double[] { 9.0, 1.0, 2.0, 3.0 }));
        }

        @Test
        public void theStandardDeviationUsesNMinusOne() {
            Assertions.assertEquals(1.0, ObjectiveSamples.standardDeviation(new double[] { 1.0, 2.0, 3.0 }), 1e-12);
        }
    }

    @Nested
    @DisplayName("given a single evaluation")
    class SingleEvaluation {
        @Test
        public void theAggregateIsTheOutputAndNothingIsRecorded() {
            // given
            final TypedEObject output = objectives(1.0, 2.0);

            // when
            final ObjectiveSamples samples = ObjectiveSamples.single(output);

            // then
            Assertions.assertSame(output, samples.aggregate());
            Assertions.assertEquals(Map.of(), samples.toProperties());
        }

        @Test
        public void itHasNoFurtherSamples() {
            final ObjectiveSamples samples = ObjectiveSamples.single(objectives(1.0, 2.0));

            Assertions.assertThrows(IllegalStateException.class, () -> samples.with(List.of(objectives(3.0, 4.0))));
        }
    }

    @Nested
    @DisplayName("given several samples")
    class SeveralSamples {
        private final List<TypedEObject> outputs = List.of(objectives(1.0, 10.0), objectives(2.0, 30.0), objectives(6.0, 20.0));

        @Test
        public void everyObjectiveIsAggregatedAndTheSamplesStayUnchanged() {
            // when
            final ObjectiveSamples mean = ObjectiveSamples.of(outputs, SampleAggregation.MEAN);
            final ObjectiveSamples median = ObjectiveSamples.of(outputs, SampleAggregation.MEDIAN);

            // then
            Assertions.assertEquals(3.0, mean.aggregate().eGet(Y));
            Assertions.assertEquals(20.0, mean.aggregate().eGet(Z));
            Assertions.assertEquals(2.0, median.aggregate().eGet(Y));
            Assertions.assertEquals(20.0, median.aggregate().eGet(Z));
            Assertions.assertEquals(1.0, outputs.get(0).eGet(Y));
            Assertions.assertSame(SPACE, mean.aggregate().eSpace());
        }

        @Test
        public void theNumberAndTheStandardDeviationsAreRecorded() {
            // when
            final Map<String, Object> properties = ObjectiveSamples.of(outputs, SampleAggregation.MEAN).toProperties();

            // then
            Assertions.assertEquals(List.of(ObjectiveSamples.SAMPLES, ObjectiveSamples.STANDARD_DEVIATIONS), List.copyOf(properties.keySet()));
            Assertions.assertEquals(3L, properties.get(ObjectiveSamples.SAMPLES));
            Assertions.assertEquals(List.of(Math.sqrt(7.0), 10.0), properties.get(ObjectiveSamples.STANDARD_DEVIATIONS));
        }

        @Test
        public void furtherSamplesAreAggregatedWithTheEarlierOnes() {
            // given
            final ObjectiveSamples first = ObjectiveSamples.of(outputs.subList(0, 1), SampleAggregation.MEAN);

            // when
            final ObjectiveSamples all = first.with(outputs.subList(1, 3));

            // then
            Assertions.assertEquals(1, first.size());
            Assertions.assertEquals(3, all.size());
            Assertions.assertEquals(3.0, all.aggregate().eGet(Y));
        }

        @Test
        public void oneSampleWithAnAggregationRecordsOnlyItsNumber() {
            // when
            final ObjectiveSamples samples = ObjectiveSamples.of(outputs.subList(0, 1), SampleAggregation.MEAN);

            // then
            Assertions.assertSame(outputs.get(0), samples.aggregate());
            Assertions.assertEquals(Map.of(ObjectiveSamples.SAMPLES, 1L), samples.toProperties());
        }
    }
}
