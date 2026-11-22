package de.evoal.core.api.cdi;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.enterprise.inject.spi.Bean;

/**
 * Tests the order in which {@link BeanFactory#createComponents(Class)} returns validators.
 */
public class BeanFactoryTest {
    private static Bean<?> beanOf(final Class<?> beanClass) {
        final Bean<?> bean = mock(Bean.class);
        doReturn(beanClass).when(bean).getBeanClass();
        return bean;
    }

    @Test
    public void beansAreOrderedByTheFullyQualifiedNameOfTheirClass() {
        // given
        final Bean<?> string = beanOf(String.class);
        final Bean<?> list = beanOf(List.class);
        final Bean<?> integer = beanOf(Integer.class);
        final List<Bean<?>> beans = new ArrayList<>(List.of(string, list, integer));

        // when
        beans.sort(BeanFactory.BY_CLASS_NAME);

        // then: java.lang.Integer, java.lang.String, java.util.List
        Assertions.assertEquals(List.of(integer, string, list), beans);
    }
}
