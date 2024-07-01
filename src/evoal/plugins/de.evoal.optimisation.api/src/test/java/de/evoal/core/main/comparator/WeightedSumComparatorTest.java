package de.evoal.core.main.comparator;

import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.languages.model.base.Instance;
import de.evoal.optimisation.main.comparator.WeightedSumComparator;
import de.evoal.optimisation.main.comparator.WeightedSumOptimisationValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WeightedSumComparatorTest {

    @Mock
    private ExpressionEvaluator evaluator;

    @Mock
    private Instance configuration;

    @InjectMocks
    private WeightedSumComparator testee;

    @Test
    public void testInitReturnSelf() {
        Mockito.when(evaluator.attributeToDoubleArray(Mockito.same(configuration), Mockito.eq("weights")))
               .thenReturn(new double[] {1.0});

        Assertions.assertNotNull(testee);
        Assertions.assertTrue(() -> testee == testee.init(configuration), "Init is exepected to return self.");
    }

    @Test
    public void testToValue() {
        Mockito.when(evaluator.attributeToDoubleArray(Mockito.same(configuration), Mockito.eq("weights")))
                .thenReturn(new double[] {2.0});

        double [] fitness = {42.0};

        testee.init(configuration);
        final WeightedSumOptimisationValue value = testee.toValue(fitness);

        Assertions.assertNotNull(value);
    }


}
