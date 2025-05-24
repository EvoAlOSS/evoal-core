package de.evoal.pipeline.impl.components.benchmarks;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.pipeline.api.model.ComponentImpl;
import de.evoal.core.api.ecore.TypedEObject;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("de.evoal.pipeline.benchmarks.rastrigin")
public class Rastrigin extends ComponentImpl {
    @Inject
    private AttributeEvaluator evaluator;

    private double a;

    @Override
    public @NonNull TypedEObject apply(final @NonNull TypedEObject obj) {

        final double n = getReads().size();
        double value = a * n;

        for(final EStructuralFeature ef : getReads()) {
            double read_i = obj.eGetAsDouble(ef);

            value += (Math.pow(read_i, 2.0) - a * Math.cos(2 * Math.PI * read_i));
        }

        obj.eSet(getWrites().iterator().next(), value);

        return obj;
    }

    @Override
    public ComponentImpl init(final Instance instance) throws InitializationException {
        a = evaluator.attributeToDouble(instance, "a");

        return this;
    }
}
