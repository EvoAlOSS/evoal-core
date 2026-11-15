package de.evoal.pipeline.api.sequence;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.emf.ecore.EObject;

import java.util.List;

@ApplicationScoped
public class SequenceFactory {

    @Inject
    private AttributeHelper helper;

    public List<Sequence> readSequence(final EObject instance, final String name) {

        final List<EObject> sequences = helper.lookup(instance, name);

        return sequences.stream()
                .map(i -> BeanFactory.createComponent(Sequence.class, i))
                .toList();
    }
}
