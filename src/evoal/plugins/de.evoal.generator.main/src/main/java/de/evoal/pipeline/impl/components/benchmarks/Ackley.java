package de.evoal.pipeline.impl.components.benchmarks;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.math.EvoalMath;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.models.core.ecore.TypedEObject;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Dependent
@Named("de.evoal.pipeline.benchmarks.ackley")
@Slf4j
public class Ackley extends PipelineComponentImpl {
    private double a = 20;

    private double b = 0.2;

    private double c = 6.283185307179586;

    @Inject
    private AttributeEvaluator evaluator;

    @Override
    public @NonNull TypedEObject apply(final @NonNull TypedEObject obj) {

        final double n = getReads().size();

        double sum1 = 0.0;
        double sum2 = 0.0;

        for(final EStructuralFeature ef : getReads()) {
            double read_i = obj.eGetAsDouble(ef);

        	sum1 += EvoalMath.square(read_i);
        	sum2 += EvoalMath.cos(c * read_i);
        }

        double value = -a * EvoalMath.exp(-b * Math.sqrt((1 / n) * sum1)) - EvoalMath.exp((1 / n) * sum2) + a + Math.E;

        obj.eSet(getWrites().iterator().next(), value);

        return obj;
    }

    @Override
    public PipelineComponentImpl init(final EObject instance) throws InitializationException {
        super.init(instance);

        a = evaluator.attributeToDouble(instance, "a");
        b = evaluator.attributeToDouble(instance, "b");
        c = evaluator.attributeToDouble(instance, "c");

        log.info("Creating Ackley function with parameter a={}, b={} and c={}.", a, b, c);

        return this;
    }
}
