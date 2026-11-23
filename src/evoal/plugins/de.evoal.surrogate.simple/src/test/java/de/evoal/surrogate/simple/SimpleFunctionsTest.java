package de.evoal.surrogate.simple;

import de.evoal.models.core.ecore.Space;
import de.evoal.surrogate.simple.identity.IdentityFunction;
import de.evoal.surrogate.simple.linear.LinearFunction;
import de.evoal.surrogate.simple.quadratic.SimpleQuadraticFunction;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * The simple surrogate functions predict from final parameters only, so several threads may
 *   use them at once (#293).
 */
public class SimpleFunctionsTest {
    private final EAttribute x = attribute("x");
    private final EAttribute y = attribute("y");
    private final Space data = space(x, y);
    private final Space input = data.subSpace(List.of(x));
    private final Space output = data.subSpace(List.of(y));

    @Test
    public void theIdentityIsThreadSafe() {
        Assertions.assertTrue(new IdentityFunction(input, output).isThreadSafe());
    }

    @Test
    public void theLinearFunctionIsThreadSafe() {
        Assertions.assertTrue(new LinearFunction(input, output, 2.0, 1.0).isThreadSafe());
    }

    @Test
    public void theQuadraticFunctionIsThreadSafe() {
        Assertions.assertTrue(new SimpleQuadraticFunction(input, output, 2.0, 1.0).isThreadSafe());
    }

    private static EAttribute attribute(final String name) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);

        return attribute;
    }

    private static Space space(final EAttribute... attributes) {
        final EClass type = EcoreFactory.eINSTANCE.createEClass();
        type.setName("data");
        type.getEStructuralFeatures().addAll(List.of(attributes));
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(type);

        return new Space(type);
    }
}
