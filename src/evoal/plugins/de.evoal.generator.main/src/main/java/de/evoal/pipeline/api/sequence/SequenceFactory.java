package de.evoal.pipeline.api.sequence;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.expressions.Instance;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class SequenceFactory {

    @Inject
    private AttributeHelper helper;

    public List<Sequence> readSequence(final Instance instance, final String name) {

        final List<Instance> sequences = helper.lookup(instance, name);

        return sequences.stream()
                .map(i -> BeanFactory.createComponent(Sequence.class, i))
                .toList();
    }
}
