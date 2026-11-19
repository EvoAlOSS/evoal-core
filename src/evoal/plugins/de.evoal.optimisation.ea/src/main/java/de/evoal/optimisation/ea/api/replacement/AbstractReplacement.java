package de.evoal.optimisation.ea.api.replacement;

import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;

import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * Base class of the replacements: creates the {@code selection}.
 */
public abstract class AbstractReplacement implements ReplacementStrategy {
    @Inject
    private AttributeHelper helper;

    /**
     * Selects the candidates that survive.
     */
    private SelectionMethod selection;

    /**
     * Creates a replacement that is configured by {@link #init(EObject)}.
     */
    protected AbstractReplacement() {
    }

    /**
     * Creates a configured replacement, e.g., for tests.
     */
    protected AbstractReplacement(final SelectionMethod selection) {
        this.selection = selection;
    }

    @Override
    public ReplacementStrategy init(final EObject configuration) {
        selection = BeanFactory.createComponent(SelectionMethod.class, helper.<EObject>lookup(configuration, "selection"));
        return this;
    }

    @Override
    public SelectionMethod selection() {
        return selection;
    }

    @Override
    public String toString() {
        return name() + "(" + selection.name() + ")";
    }
}
