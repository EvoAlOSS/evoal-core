package de.evoal.core.api.ecore.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConcurrentEClassAccessTest {
    /**
     * @return A new class with 50 double attributes {@code f0}, ..., {@code f49}.
     */
    private static EClass createClass() {
        final EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        ePackage.setName("test");
        ePackage.setNsURI("urn:test:concurrent-access");
        ePackage.setNsPrefix("test");

        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.setName("Point");
        ePackage.getEClassifiers().add(eClass);

        for(int i = 0; i < 50; ++i) {
            final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
            attribute.setName("f" + i);
            attribute.setEType(EcorePackage.eINSTANCE.getEDouble());
            eClass.getEStructuralFeatures().add(attribute);
        }

        return eClass;
    }

    @Test
    public void preparedClassesCanBeUsedConcurrently() throws Exception {
        final ExecutorService executor = Executors.newFixedThreadPool(8);

        try {
            for(int round = 0; round < 20; ++round) {
                // given
                final EClass eClass = createClass();
                ConcurrentEClassAccess.prepare(eClass);

                // when
                final List<Future<Double>> results = new ArrayList<>();
                for(int task = 0; task < 32; ++task) {
                    final double value = task;
                    results.add(executor.submit(() -> {
                        final EObject object = EcoreUtil.create(eClass);
                        for(final EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
                            object.eSet(eClass.getEStructuralFeature(feature.getName()), value);
                        }
                        return (Double) object.eGet(eClass.getEStructuralFeature("f49"));
                    }));
                }

                // then
                for(int task = 0; task < results.size(); ++task) {
                    Assertions.assertEquals(task, results.get(task).get());
                }
            }
        } finally {
            executor.shutdownNow();
        }
    }

    @Test
    public void abstractClassesArePreparedWithoutInstances() {
        final EClass eClass = createClass();
        eClass.setAbstract(true);

        Assertions.assertDoesNotThrow(() -> ConcurrentEClassAccess.prepare(eClass));
    }
}
