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
public class QualifiedNameConverter implements IValueConverter<String> {

	@Override
	public String toValue(final String string, final INode node) {
		if (string == null) {
			return null;
		}

		System.err.println("QNC toValue " + string);
		return string.replace("'", "");
	}

	@Override
	public String toString(final String value) {
		if (value == null) {
			return null;
		}


		System.err.println("QNC toString " + value);
		return "\'" + value + "\'";
	}
}