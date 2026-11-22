package de.evoal.surrogate.api.io.pson;

import de.evoal.models.core.ecore.Space;
import de.evoal.surrogate.api.function.ModelFunction;
import lombok.NonNull;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.List;

/**
 * The information that a PSON writer stores per feature (#234).
 */
public class AbstractPSONWriterTest {
    @Test
    public void aValueWithTheNameOfAnEarlierOneReplacesIt() {
        // given
        final EAttribute y = EcoreFactory.eINSTANCE.createEAttribute();
        y.setName("y");
        y.setEType(EcorePackage.Literals.EDOUBLE);

        final EClass type = EcoreFactory.eINSTANCE.createEClass();
        type.setName("data");
        type.getEStructuralFeatures().add(y);

        final EPackage pkg = EcoreFactory.eINSTANCE.createEPackage();
        pkg.setName("test");
        pkg.setNsURI("http://www.evoal.de/test/pson-writer");
        pkg.getEClassifiers().add(type);

        final Space space = new Space(type);
        final ModelFunction function = new ModelFunction("model", space, space) {
            @Override
            public void apply(final @NonNull de.evoal.models.core.ecore.TypedEObject input, final @NonNull de.evoal.models.core.ecore.TypedEObject output) {
            }
        };

        final PSONModelStorage storage = Mockito.mock(PSONModelStorage.class);
        final AbstractPSONWriter writer = new AbstractPSONWriter() {
            @Override
            protected void toConfiguration(final @NonNull ModelFunction function, final @NonNull SurrogateConfiguration configuration) {
            }
        };
        writer.setStorage(storage);

        // when
        writer.addOutputFeatureInformation(y, Parameter.from("rmse", 1.0));
        writer.addOutputFeatureInformation(y, Parameter.from("density", 3.0));
        writer.addOutputFeatureInformation(y, Parameter.from("rmse", 2.0));
        writer.store(function);

        // then
        final ArgumentCaptor<SurrogateConfiguration> stored = ArgumentCaptor.forClass(SurrogateConfiguration.class);
        Mockito.verify(storage).store(stored.capture());

        Assertions.assertEquals(List.of(Parameter.from("density", 3.0), Parameter.from("rmse", 2.0)),
                                stored.getValue().getOutputParameters().get("y"));
    }
}
