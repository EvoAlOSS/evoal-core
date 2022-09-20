package de.evoal.languages.model.generator.dsl.converter;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;

public class ValueConverterService extends DefaultTerminalConverters {
    @ValueConverter(rule = "StringOrId")
    public IValueConverter<String> StringOrId() {
            return new StringStripperConverter();
    }
}
