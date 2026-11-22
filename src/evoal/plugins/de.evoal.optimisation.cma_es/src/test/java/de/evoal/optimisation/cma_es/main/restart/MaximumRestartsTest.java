package de.evoal.optimisation.cma_es.main.restart;

import java.lang.reflect.Field;
import java.util.SplittableRandom;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.DefinitionsFactory;
import de.evoal.languages.model.base.types.TypesFactory;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.dl.DlFactory;

/**
 * Tests how IPOP and BIPOP read the optional attribute {@code 'maximum-restarts'} from a
 *   configuration whose class is created from the DL type, as in a run: unset means no limit,
 *   0 means no restart.
 */
public class MaximumRestartsTest {
    /**
     * The number of restarts that is taken as "no limit" by the tests.
     */
    private static final int MANY = 1000;

    private final DynamicEClassProvider provider = new DynamicEClassProvider();

    private final EClass restartType = provider.toEClass(createRestartType());

    /**
     * Creates {@code type 'restart' { 'population-factor' : real; 'maximum-restarts' : optional int; }}.
     */
    private static ClassDefinition createRestartType() {
        final DefinitionModule module = DlFactory.eINSTANCE.createDefinitionModule();
        module.setName("com.example.restarts");
        final ClassDefinition type = DefinitionsFactory.eINSTANCE.createClassDefinition();
        type.setName("restart");
        module.getTypes().add(type);

        final AttributeDefinition factor = DefinitionsFactory.eINSTANCE.createAttributeDefinition();
        factor.setName("population-factor");
        factor.setType(TypesFactory.eINSTANCE.createRealType());
        type.getAttributes().add(factor);

        final AttributeDefinition maximum = DefinitionsFactory.eINSTANCE.createAttributeDefinition();
        maximum.setName("maximum-restarts");
        maximum.setType(TypesFactory.eINSTANCE.createIntType());
        maximum.setOptional(true);
        type.getAttributes().add(maximum);

        return type;
    }

    /**
     * @param maximum The value of {@code 'maximum-restarts'}, {@code null} to leave it unset.
     */
    private EObject configuration(final Integer maximum) {
        final EObject configuration = provider.getEObject(restartType);
        configuration.eSet(restartType.getEStructuralFeature("population-factor"), 2.0);
        if(maximum != null) {
            configuration.eSet(restartType.getEStructuralFeature("maximum-restarts"), maximum);
        }
        return configuration;
    }

    private static <T extends RestartStrategy> T init(final T strategy, final EObject configuration) throws Exception {
        final AttributeHelper helper = new AttributeHelper();
        inject(AttributeHelper.class, helper, "evaluator", new AttributeEvaluator());
        inject(strategy.getClass(), strategy, "helper", helper);
        strategy.init(configuration);
        return strategy;
    }

    private static void inject(final Class<?> type, final Object target, final String fieldName, final Object value)
            throws Exception {
        final Field field = type.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    /**
     * @return The number of restarts the schedule allows, at most {@link #MANY}.
     */
    private static int restarts(final RestartStrategy strategy) {
        final RestartSchedule schedule = strategy.schedule(4);
        final SplittableRandom random = new SplittableRandom(1);
        schedule.first();

        int restarts = 0;
        while(restarts < MANY && schedule.next(100, random).isPresent()) {
            ++restarts;
        }
        return restarts;
    }

    @Test
    public void unsetMaximumMeansNoLimitForIpop() throws Exception {
        Assertions.assertEquals(MANY, restarts(init(new IpopRestart(), configuration(null))));
    }

    @Test
    public void zeroMaximumMeansNoRestartForIpop() throws Exception {
        Assertions.assertEquals(0, restarts(init(new IpopRestart(), configuration(0))));
    }

    @Test
    public void configuredMaximumIsUsedByIpop() throws Exception {
        Assertions.assertEquals(3, restarts(init(new IpopRestart(), configuration(3))));
    }

    @Test
    public void unsetMaximumMeansNoLimitForBipop() throws Exception {
        Assertions.assertEquals(MANY, restarts(init(new BipopRestart(), configuration(null))));
    }

    @Test
    public void zeroMaximumMeansNoRestartForBipop() throws Exception {
        Assertions.assertEquals(0, restarts(init(new BipopRestart(), configuration(0))));
    }
}
