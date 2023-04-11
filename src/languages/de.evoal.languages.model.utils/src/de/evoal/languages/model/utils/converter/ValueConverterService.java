package de.evoal.languages.model.utils.converter;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;

public class ValueConverterService extends DefaultTerminalConverters {
    @ValueConverter(rule = "StringOrId")
    public IValueConverter<String> StringOrId() {
            return new StringStripperConverter();
    }

    @ValueConverter(rule = "QualifiedName")
    public IValueConverter<String> QualifiedName() {
            return new QualifiedNameConverter();
    }
}
