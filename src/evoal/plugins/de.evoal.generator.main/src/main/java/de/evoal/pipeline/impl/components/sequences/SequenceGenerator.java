package de.evoal.pipeline.impl.components.sequences;

import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.ddl.DataDescription;

import de.evoal.pipeline.api.model.dynamic.EAnnotationHelper;
import de.evoal.pipeline.api.sequence.Sequence;
import de.evoal.pipeline.api.sequence.SequenceFactory;
import de.evoal.pipeline.api.model.ComponentImpl;
import de.evoal.pipeline.api.model.TypedEObject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.NonNull;

import java.util.*;


@Named("de.evoal.pipeline.sequences.sequence-generator")
@Dependent
@Slf4j
public class SequenceGenerator extends ComponentImpl {

    @Inject
    private EAnnotationHelper helper;

    @Inject
    private SequenceFactory factory;

    /**
     * List of Sequences to be used to create new points.
     */
    private final Map<DataDescription, Sequence> valueProviders = new HashMap<>();

    /**
     * A symbol table for the evaluation.
     */
    private final HashMap<DataDescription, Object> symbolToValueMapping = new HashMap<DataDescription, Object>();

    @Override
    public SequenceGenerator init(final Instance configuration) {
        final List<Sequence> sequences = factory.readSequence(configuration, "sequences");

        for(Sequence sequence : sequences) {
            sequence.setSymbolTable(symbolToValueMapping);
            valueProviders.put(sequence.getVariable(), sequence);
            symbolToValueMapping.put(sequence.getVariable(), sequence.getInitialValue());
        }

        return this;
    }

    //Needs testing! I am unsure if this works as I believe it does.
    @Override
    public @NonNull TypedEObject apply(@NonNull TypedEObject object) {
        final Iterator<EStructuralFeature> iterator = getWrites().iterator();

        while(iterator.hasNext()) {
            final EStructuralFeature feature = iterator.next();
            final Optional<DataDescription> description = helper.dataDescriptionOf(feature);

            if (description.isPresent()) {
                final Object value = valueProviders.get(description.get()).next();

                object.eSet(feature, value);
            } else {
                throw new RuntimeException("No DataDescription found for feature " + feature);
            }
        }

        return object;
    }
}

