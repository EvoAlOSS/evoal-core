package de.evoal.surrogate.api.function;

import de.evoal.core.api.properties.PropertiesSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class SurrogateFunctionTest {

    @Test
    public void testGetMappings() {
        final List<FunctionCombiner> combiners = Mockito.mock(List.class);
        final FunctionCombiner combiner = Mockito.mock(FunctionCombiner.class);
        final PropertiesSpecification inputSpecification = Mockito.mock(PropertiesSpecification.class);
        final PropertiesSpecification outputSpecification = Mockito.mock(PropertiesSpecification.class);

        Mockito.when(combiners.size())
               .thenReturn(1);

        Mockito.when(combiners.get(Mockito.eq(0)))
               .thenReturn(combiner);

        Mockito.when(combiner.getInputSpecification())
               .thenReturn(inputSpecification);

        Mockito.when(combiner.getOutputSpecification())
               .thenReturn(outputSpecification);

        SurrogateFunction testee = new SurrogateFunction(combiners);

        Assertions.assertSame(combiners, testee.getMappings());
    }

    @Test
    public void testGetInputSpecification() {
        final List<FunctionCombiner> combiners = Mockito.mock(List.class);
        final FunctionCombiner combiner = Mockito.mock(FunctionCombiner.class);
        final PropertiesSpecification inputSpecification = Mockito.mock(PropertiesSpecification.class);
        final PropertiesSpecification outputSpecification = Mockito.mock(PropertiesSpecification.class);

        Mockito.when(combiners.size())
                .thenReturn(1);

        Mockito.when(combiners.get(Mockito.eq(0)))
                .thenReturn(combiner);

        Mockito.when(combiner.getInputSpecification())
                .thenReturn(inputSpecification);

        Mockito.when(combiner.getOutputSpecification())
                .thenReturn(outputSpecification);

        SurrogateFunction testee = new SurrogateFunction(combiners);

        Assertions.assertSame(inputSpecification, testee.getInputSpecification());
    }

    @Test
    public void testGetOutputSpecification() {
        final List<FunctionCombiner> combiners = Mockito.mock(List.class);
        final FunctionCombiner combiner = Mockito.mock(FunctionCombiner.class);
        final PropertiesSpecification inputSpecification = Mockito.mock(PropertiesSpecification.class);
        final PropertiesSpecification outputSpecification = Mockito.mock(PropertiesSpecification.class);

        Mockito.when(combiners.size())
                .thenReturn(1);

        Mockito.when(combiners.get(Mockito.eq(0)))
                .thenReturn(combiner);

        Mockito.when(combiner.getInputSpecification())
                .thenReturn(inputSpecification);

        Mockito.when(combiner.getOutputSpecification())
                .thenReturn(outputSpecification);

        SurrogateFunction testee = new SurrogateFunction(combiners);

        Assertions.assertSame(outputSpecification, testee.getOutputSpecification());
    }
}
