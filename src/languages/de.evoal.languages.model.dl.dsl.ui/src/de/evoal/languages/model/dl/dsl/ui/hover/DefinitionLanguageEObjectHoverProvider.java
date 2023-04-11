package de.evoal.languages.model.dl.dsl.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

import de.evoal.languages.model.dl.AttributeDefinition;

public class DefinitionLanguageEObjectHoverProvider extends DefaultEObjectHoverProvider {

	@Override
	protected String getFirstLine(final EObject o) {
		if(o instanceof AttributeDefinition) {
			final StringBuilder builder = new StringBuilder();
			builder.append(o.eClass().getName());
			
			final String label = getLabel(o);

			if(label != null) {
				builder.append(" <b>");
				builder.append(getLabel(o.eContainer()));
				builder.append(".");
				builder.append(label);
				builder.append("</b>");
			}

			return builder.toString();
		}
		return super.getFirstLine(o);
	}
	
}
