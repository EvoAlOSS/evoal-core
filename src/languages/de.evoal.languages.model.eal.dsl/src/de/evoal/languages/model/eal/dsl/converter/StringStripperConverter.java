package de.evoal.languages.model.eal.dsl.converter;

import java.util.regex.Pattern;

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
	private final static Pattern ID_PATTERN = Pattern.compile("[^a-zA-Z0-9]");
	
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

		if (isID(value)) {
			return value;
		} else {
			return String.format("'%s'", value);
		}
	}

	private boolean isID(final String value) {
		return !ID_PATTERN.matcher(value).find();
	}
}