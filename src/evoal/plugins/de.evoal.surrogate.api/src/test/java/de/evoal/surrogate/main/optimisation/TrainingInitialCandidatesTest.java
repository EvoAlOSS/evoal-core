package de.evoal.surrogate.main.optimisation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import de.evoal.core.api.board.Blackboard;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.surrogate.api.SurrogateBlackboardEntries;

/**
 * Where the 'training-population' takes its training data from.
 */
class TrainingInitialCandidatesTest {
    @Mock
    private Blackboard board;

    @InjectMocks
    private TrainingInitialCandidates population;

    private AutoCloseable mocks;

    @BeforeEach
    void setUp() {
        mocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        mocks.close();
    }

    /**
     * @return A 'training-population' configuration without 'training-file'.
     */
    private static EObject withoutTrainingFile() {
        final EAttribute file = EcoreFactory.eINSTANCE.createEAttribute();
        file.setName("training-file");
        file.setEType(EcorePackage.Literals.ESTRING);

        final EClass type = EcoreFactory.eINSTANCE.createEClass();
        type.setName("training-population");
        type.getEStructuralFeatures().add(file);

        final EPackage pkg = EcoreFactory.eINSTANCE.createEPackage();
        pkg.setName("test");
        pkg.setNsURI("http://www.evoal.de/test/training-population");
        pkg.getEClassifiers().add(type);

        return EcoreUtil.create(type);
    }

    @Test
    void withoutTrainingFileAndRunDataThePopulationIsRejected() {
        final InitializationException e = Assertions.assertThrows(InitializationException.class,
                                                                  () -> population.init(withoutTrainingFile()));

        Assertions.assertTrue(e.getMessage().contains("-Bsurrogate:training-data-file=<file>"), e.getMessage());
    }

    @Test
    void withoutTrainingFileThePopulationUsesTheRunData() {
        Mockito.when(board.getOrNull(SurrogateBlackboardEntries.SURROGATE_TRAINING_DATA_FILE)).thenReturn("training.json");

        Assertions.assertDoesNotThrow(() -> population.init(withoutTrainingFile()));
    }
}
