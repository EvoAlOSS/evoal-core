package de.evoal.core.api.languages;

import lombok.NonNull;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * The source text of parsed language elements, e.g., of an expression in a configuration.
 */
public final class ExpressionText {
    private ExpressionText() {
    }

    /**
     * @param element A parsed element, e.g., an expression.
     * @return The element as written in its file, without comments, or its {@code toString()}
     *   if the element was not parsed from a file (no node model).
     */
    public static String of(final @NonNull EObject element) {
        final ICompositeNode node = NodeModelUtils.getNode(element);
        if(node == null) {
            return element.toString();
        }

        return NodeModelUtils.getTokenText(node);
    }
}
