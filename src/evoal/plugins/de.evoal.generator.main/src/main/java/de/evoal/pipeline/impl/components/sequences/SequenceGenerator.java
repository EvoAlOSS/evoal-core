package de.evoal.pipeline.impl.components.sequences;

import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.pipeline.api.sequence.Sequence;
import de.evoal.pipeline.api.sequence.SequenceFactory;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.*;


@Named("de.evoal.pipeline.sequences.sequence-generator")
@Dependent
@Slf4j
public class SequenceGenerator extends PipelineComponentImpl {

    @Inject
    private EAnnotationHelper helper;

    @Inject
    private SequenceFactory factory;

    /**
     * The sequence that generates each feature.
     */
    private final Map<EStructuralFeature, Sequence> valueProviders = new HashMap<>();

    /**
     * A symbol table for the evaluation (current value of each generated feature).
     */
    private final Map<EStructuralFeature, Object> symbolToValueMapping = new HashMap<>();

    @Override
    public SequenceGenerator init(final EObject configuration) {
        final List<Sequence> sequences = factory.readSequence(configuration, "sequences");

        for(Sequence sequence : sequences) {
            final EStructuralFeature variable = sequence.getVariable();

            sequence.setSymbolTable(symbolToValueMapping, helper.featuresOf(variable.getEContainingClass()));
            valueProviders.put(variable, sequence);
            symbolToValueMapping.put(variable, sequence.getInitialValue());
        }

        return this;
    }

    @Override
    public @NonNull TypedEObject apply(@NonNull TypedEObject object) {
        for(final EStructuralFeature feature : getWrites()) {
            final Sequence sequence = valueProviders.get(feature);

            if(sequence == null) {
                throw new IllegalStateException("No sequence generates the written data '" + feature.getName() + "'.");
            }

            object.eSet(feature, NumericConversions.toType(sequence.next(), feature.getEType()));
        }

        return object;
    }
}
