package de.evoal.surrogate.api.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

/**
 * The summary of the values of a resampling scheme (#334).
 */
public class ResampledValuesTest {
    @Test
    public void theSummaryHasTheMeanAndTheSampleStandardDeviation() {
        // when
        final ResampledValues values = ResampledValues.of(List.of(1.0, 2.0, 3.0, 4.0));

        // then: variance (2.25 + 0.25 + 0.25 + 2.25) / 3
        Assertions.assertEquals(2.5, values.mean(), 1e-12);
        Assertions.assertEquals(Math.sqrt(5.0 / 3.0), values.standardDeviation(), 1e-12);
        Assertions.assertEquals(List.of(1.0, 2.0, 3.0, 4.0), values.values());
    }

    @Test
    public void oneValueHasNoSpread() {
        // when
        final ResampledValues values = ResampledValues.of(List.of(7.0));

        // then
        Assertions.assertEquals(7.0, values.mean());
        Assertions.assertEquals(0.0, values.standardDeviation());
    }

    @Test
    public void noValueIsRejected() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ResampledValues.of(List.of()));
    }

    @Test
    public void theStoredFormNamesTheParts() {
        // when
        final Map<String, Object> stored = ResampledValues.of(List.of(1.0, 3.0)).asMap();

        // then
        Assertions.assertEquals(List.of("mean", "standard-deviation", "values"), List.copyOf(stored.keySet()));
        Assertions.assertArrayEquals(new double[]{1.0, 3.0}, (double[]) stored.get("values"));
    }

    @Test
    public void aSchemeIsADataSetBesideTheTrainingData() {
        // given
        final GoodnessOfFit goodnessOfFit = new GoodnessOfFit();
        final org.eclipse.emf.ecore.EAttribute y = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
        y.setName("y:0");

        // when
        goodnessOfFit.record(y, "rmse", GoodnessOfFit.TRAINING, 0.5);
        goodnessOfFit.record(y, "rmse", "bootstrap", ResampledValues.of(List.of(1.0, 3.0)));

        // then
        Assertions.assertEquals(List.of(GoodnessOfFit.TRAINING, "bootstrap"), List.copyOf(goodnessOfFit.values().get(y).get("rmse").keySet()));
        Assertions.assertEquals(2.0, ((ResampledValues) goodnessOfFit.values().get(y).get("rmse").get("bootstrap")).mean());
    }
}
