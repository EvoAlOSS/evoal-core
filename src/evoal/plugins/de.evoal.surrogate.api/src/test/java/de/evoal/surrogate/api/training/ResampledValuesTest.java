package de.evoal.surrogate.api.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

/**
 * The summary of the values of a resampling scheme (#334) and its pooled value (#351).
 */
public class ResampledValuesTest {
    @Test
    public void theSummaryHasTheMeanAndTheSampleStandardDeviation() {
        // when
        final ResampledValues values = ResampledValues.of(List.of(1.0, 2.0, 3.0, 4.0), OptionalDouble.of(2.0));

        // then: variance (2.25 + 0.25 + 0.25 + 2.25) / 3
        Assertions.assertEquals(2.5, values.mean().getAsDouble(), 1e-12);
        Assertions.assertEquals(Math.sqrt(5.0 / 3.0), values.standardDeviation().getAsDouble(), 1e-12);
        Assertions.assertEquals(List.of(1.0, 2.0, 3.0, 4.0), values.values());
        Assertions.assertEquals(OptionalDouble.of(2.0), values.pooled());
    }

    @Test
    public void oneValueHasNoSpread() {
        // when
        final ResampledValues values = ResampledValues.of(List.of(7.0), OptionalDouble.empty());

        // then
        Assertions.assertEquals(OptionalDouble.of(7.0), values.mean());
        Assertions.assertEquals(OptionalDouble.of(0.0), values.standardDeviation());
    }

    @Test
    public void onlyAPooledValueHasNoSummary() {
        // when
        final ResampledValues values = ResampledValues.of(List.of(), OptionalDouble.of(0.9));

        // then
        Assertions.assertTrue(values.mean().isEmpty());
        Assertions.assertTrue(values.standardDeviation().isEmpty());
        Assertions.assertEquals(OptionalDouble.of(0.9), values.pooled());
    }

    @Test
    public void neitherAValueNorAPooledValueIsRejected() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ResampledValues.of(List.of(), OptionalDouble.empty()));
    }

    @Test
    public void theStoredFormNamesTheParts() {
        // when
        final Map<String, Object> stored = ResampledValues.of(List.of(1.0, 3.0), OptionalDouble.of(2.5)).asMap();

        // then
        Assertions.assertEquals(List.of("mean", "standard-deviation", "pooled", "values"), List.copyOf(stored.keySet()));
        Assertions.assertArrayEquals(new double[]{1.0, 3.0}, (double[]) stored.get("values"));
    }

    @Test
    public void theStoredFormLeavesOutWhatIsUndefined() {
        // when
        final Map<String, Object> withoutParts = ResampledValues.of(List.of(), OptionalDouble.of(0.9)).asMap();
        final Map<String, Object> withoutPooled = ResampledValues.of(List.of(1.0), OptionalDouble.empty()).asMap();

        // then
        Assertions.assertEquals(List.of("pooled", "values"), List.copyOf(withoutParts.keySet()));
        Assertions.assertArrayEquals(new double[0], (double[]) withoutParts.get("values"));
        Assertions.assertEquals(List.of("mean", "standard-deviation", "values"), List.copyOf(withoutPooled.keySet()));
    }

    @Test
    public void aSchemeIsADataSetBesideTheTrainingData() {
        // given
        final GoodnessOfFit goodnessOfFit = new GoodnessOfFit();
        final org.eclipse.emf.ecore.EAttribute y = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
        y.setName("y:0");

        // when
        goodnessOfFit.record(y, "rmse", GoodnessOfFit.TRAINING, 0.5);
        goodnessOfFit.record(y, "rmse", "bootstrap", ResampledValues.of(List.of(1.0, 3.0), OptionalDouble.empty()));

        // then
        Assertions.assertEquals(List.of(GoodnessOfFit.TRAINING, "bootstrap"), List.copyOf(goodnessOfFit.values().get(y).get("rmse").keySet()));
        Assertions.assertEquals(OptionalDouble.of(2.0), ((ResampledValues) goodnessOfFit.values().get(y).get("rmse").get("bootstrap")).mean());
    }
}
