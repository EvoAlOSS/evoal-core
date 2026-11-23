package de.evoal.surrogate.main.internal;

import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.util.ExpressionsSwitch;
import de.evoal.languages.model.generator.Step;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A copy converter for expressions. The implementation is similar to {@link org.eclipse.emf.ecore.util.EcoreUtil#copy}
 *   with the exception that it converts {@link Step} using the {@link MLLModelConverter}. It
 *   also copies the elements of an expression that are no expressions themselves, e.g. the
 *   attributes of an instance passed to a function.
 */
@Slf4j
public class ExpressionConverter extends ExpressionsSwitch<Expression> {
    /**
     * Factory for creating expression instances.
     */
    private final static ExpressionsFactory exprFactory = ExpressionsFactory.eINSTANCE;

    /**
     * Factory for creating pipeline instances.
     */
    private final MLLModelConverter mllConverter;

    public ExpressionConverter(final @NonNull MLLModelConverter converter) {
        mllConverter = converter;
    }

    @Override
    public Expression defaultCase(final EObject object) {
        return (Expression) copyElement(object);
    }

    /**
     * Copies an element of an expression, e.g. an expression or an attribute of an instance.
     */
    private EObject copyElement(final EObject object) {
        final EObject result = exprFactory.create(object.eClass());

        for(final EStructuralFeature feature : object.eClass().getEAllStructuralFeatures()) {
//            log.info("  copying '{}'.", feature.getName());
            final Object value = object.eGet(feature);

            if(value == null) {
                continue;
            }

            final boolean isCrossReference = feature instanceof EReference reference && !reference.isContainment();

            if(feature.isMany()) {
                final EList<?> sourceList = (EList<?>) value;
                final EList targetList = (EList) result.eGet(feature);

                sourceList.stream()
                        .map(obj -> copy(obj, isCrossReference))
                        .forEach(targetList::add);
            } else {
                result.eSet(feature, copy(value, isCrossReference));
            }

        }

        return result;
    }

    private @NonNull Object copy(final @NonNull Object value, final boolean isCrossReference) {
        if(value instanceof Step step) {
            return mllConverter.doSwitch(step);
        } else if(value instanceof Expression expression && !isCrossReference) {
            return doSwitch(expression);
        } else if(value instanceof EObject eValue && !isCrossReference) {
            return copyElement(eValue);
        } else {
            return value;
        }
    }
}
