package de.evoal.languages.model.utils.converter;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.nodemodel.INode;

/**
 * A Xtext value converter that is applicable for rules, such as:
 *
 * <pre>
 * MyRule returns ecore::EString:
 *   ID | STRING;
 * </pre>
 *
 * The converter will strip the quotes or apostrophes in the String case.
 *
 * @author Bernhard J. Berger
 */
public class StringStripperConverter implements IValueConverter<String> {

	@Override
	public String toValue(final String string, final INode node) {
		if (string == null) {
			return null;
		}

		if (string.startsWith("'")) {
			return string.substring(1, string.length() - 1);
		} else {
			return string;
		}
	}

	@Override
	public String toString(final String value) {
		if (value == null) {
			return null;
		}

		return String.format("'%s'", value);
	}
}