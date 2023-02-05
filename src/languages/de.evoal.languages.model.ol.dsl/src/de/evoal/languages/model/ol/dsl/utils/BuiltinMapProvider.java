package de.evoal.languages.model.ol.dsl.utils;

import java.util.function.Supplier;
import java.util.stream.Stream;

public interface BuiltinMapProvider extends Supplier<Stream<BuiltinDSLInfo>> {

	void setBasePath(String string);

	void setExtension(final String extension);
}
