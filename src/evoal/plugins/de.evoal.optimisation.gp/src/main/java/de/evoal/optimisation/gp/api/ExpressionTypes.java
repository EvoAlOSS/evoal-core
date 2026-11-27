package de.evoal.optimisation.gp.api;

import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.ecore.misc.EClassifierHelper;

/**
 * The DL types of the module {@value #MODULE} as classes: which class of a tree is a variable,
 *   a constant or a function.
 */
public final class ExpressionTypes {
    /**
     * The DL type of the constants.
     */
    public static final String CONSTANT = ExpressionTypes.MODULE + ".constant";

    /**
     * The DL type of the nodes of an expression.
     */
    public static final String EXPRESSION = ExpressionTypes.MODULE + ".expression";

    /**
     * The name of the DL module of genetic programming.
     */
    public static final String MODULE = "de.evoal.optimisation.gp.genetic-programming";

    /**
     * The name of the attribute with the value of a constant.
     */
    public static final String VALUE = "value";

    /**
     * The DL type of the variables.
     */
    public static final String VARIABLE = ExpressionTypes.MODULE + ".variable";

    private ExpressionTypes() {
    }

    /**
     * @return Whether the class is a subtype of {@code constant}.
     */
    public static boolean isConstant(final EClass type) {
        return isOfType(type, CONSTANT);
    }

    /**
     * @return Whether the class is {@code 'expression'} or one of its subtypes.
     */
    public static boolean isExpression(final EClass type) {
        return isOfType(type, EXPRESSION);
    }

    /**
     * @return Whether the class is the DL type or one of its subtypes.
     */
    public static boolean isOfType(final EClass type, final String dlType) {
        final boolean isTheType = dlType.equals(DynamicEClassProvider.dlTypeOf(type));

        return isTheType || type.getEAllSuperTypes()
                                .stream()
                                .map(DynamicEClassProvider::dlTypeOf)
                                .anyMatch(dlType::equals);
    }

    /**
     * @return Whether the class is a subtype of {@code variable}.
     */
    public static boolean isVariable(final EClass type) {
        return isOfType(type, VARIABLE);
    }

    /**
     * @return The attribute {@code 'value'} of a constant type, empty if the type does not have
     *   exactly one attribute, a single real {@code 'value'}.
     */
    public static Optional<EAttribute> valueAttributeOf(final EClass constantType) {
        final List<EStructuralFeature> features = constantType.getEAllStructuralFeatures();
        if(features.size() != 1 || !(features.getFirst() instanceof EAttribute attribute)) {
            return Optional.empty();
        }

        final boolean isSingleReal = VALUE.equals(attribute.getName())
                                     && !attribute.isMany()
                                     && EClassifierHelper.isReal(attribute.getEType());

        return isSingleReal ? Optional.of(attribute) : Optional.empty();
    }
}
