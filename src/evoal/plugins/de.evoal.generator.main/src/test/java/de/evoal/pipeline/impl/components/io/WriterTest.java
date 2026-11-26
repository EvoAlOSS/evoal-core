package de.evoal.pipeline.impl.components.io;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * The step {@code writer} writes the features of its {@code reads} (#357).
 */
class WriterTest {
    @Test
    void aStepWithoutReadsIsAnError() {
        // given
        final EAttribute x = EcoreFactory.eINSTANCE.createEAttribute();
        x.setName("x:0");
        x.setEType(EcorePackage.Literals.EDOUBLE);
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.getEStructuralFeatures().add(x);
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);
        final Space space = new Space(eClass);

        final Writer writer = new Writer();
        writer.setFeatures(space, space.subSpace(List.of()), space.subSpace(List.of()));

        // when
        final InitializationException e = Assertions.assertThrows(InitializationException.class, () -> writer.init(null));

        // then
        Assertions.assertTrue(e.getMessage().contains("add reads"), e.getMessage());
    }
}
