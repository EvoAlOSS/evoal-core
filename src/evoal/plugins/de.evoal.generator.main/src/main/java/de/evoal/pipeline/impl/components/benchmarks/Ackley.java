package de.evoal.pipeline.impl.components.benchmarks;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.core.api.ecore.TypedEObject;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
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

        	sum1 += Math.pow(read_i, 2.0);
        	sum2 += Math.cos(c * read_i);
        }

        double value = -a * Math.exp(-b * Math.sqrt((1 / n) * sum1)) - Math.exp((1 / n) * sum2) + a + Math.E;

        obj.eSet(getWrites().iterator().next(), value);

        return obj;
    }

    @Override
    public PipelineComponentImpl init(final Instance instance) throws InitializationException {
        super.init(instance);

        a = evaluator.attributeToDouble(instance, "a");
        b = evaluator.attributeToDouble(instance, "b");
        c = evaluator.attributeToDouble(instance, "c");

        log.info("Creating Ackley function with parameter a={}, b={} and c={}.", a, b, c);

        return this;
    }
}
