package de.evoal.core.arff;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.ecore.io.EObjectIOFactory;
import de.evoal.core.api.ecore.io.EObjectReader;
import de.evoal.core.api.ecore.io.EObjectWriter;
import de.evoal.core.arff.io.ArffEObjectReader;
import de.evoal.core.arff.io.ArffEObjectWriter;
import de.evoal.models.core.ecore.Space;
import jakarta.inject.Named;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.File;

/**
 * {@link EObjectIOFactory} finds the ARFF reader and writer by the extension of a file, so
 *   their bean names must be the names it looks up (#356).
 */
public class ArffBeanNamesTest {
    private static final File FILE = new File("data.arff");

    private static <T> String lookedUpName(final Class<T> type, final T bean, final FactoryCall call) throws Exception {
        try(final MockedStatic<BeanFactory> factory = Mockito.mockStatic(BeanFactory.class)) {
            final ArgumentCaptor<String> name = ArgumentCaptor.forClass(String.class);
            factory.when(() -> BeanFactory.create(name.capture(), ArgumentMatchers.eq(type))).thenReturn(bean);

            call.run();

            return name.getValue();
        }
    }

    @FunctionalInterface
    private interface FactoryCall {
        void run() throws Exception;
    }

    @Test
    public void theFactoryFindsTheReader() throws Exception {
        // given
        final EObjectReader reader = Mockito.mock(EObjectReader.class);
        Mockito.when(reader.init(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(reader);

        // when
        final String name = lookedUpName(EObjectReader.class, reader, () -> EObjectIOFactory.reader(FILE, Mockito.mock(Space.class)));

        // then
        Assertions.assertEquals(name, ArffEObjectReader.class.getAnnotation(Named.class).value());
    }

    @Test
    public void theFactoryFindsTheWriter() throws Exception {
        // given
        final EObjectWriter writer = Mockito.mock(EObjectWriter.class);
        Mockito.when(writer.init(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(writer);

        // when
        final String name = lookedUpName(EObjectWriter.class, writer, () -> EObjectIOFactory.writer(FILE, Mockito.mock(Space.class)));

        // then
        Assertions.assertEquals(name, ArffEObjectWriter.class.getAnnotation(Named.class).value());
    }
}
