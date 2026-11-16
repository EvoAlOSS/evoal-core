package de.evoal.pipeline.impl.components.benchmarks;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.math.EvoalMath;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.models.core.ecore.TypedEObject;
import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Dependent
@Named("de.evoal.pipeline.benchmarks.rastrigin")
public class Rastrigin extends PipelineComponentImpl {
    @Inject
    private AttributeEvaluator evaluator;

    private double a;

    @Override
    public @NonNull TypedEObject apply(final @NonNull TypedEObject obj) {

        final double n = getReads().size();
        double value = a * n;

        for(final EStructuralFeature ef : getReads()) {
            double read_i = obj.eGetAsDouble(ef);

            value += (read_i * read_i - a * EvoalMath.cos(2 * Math.PI * read_i));
        }

        obj.eSet(getWrites().iterator().next(), value);

        return obj;
    }

    @Override
    public PipelineComponentImpl init(final EObject instance) throws InitializationException {
        a = evaluator.attributeToDouble(instance, "a");

        return this;
    }
}
