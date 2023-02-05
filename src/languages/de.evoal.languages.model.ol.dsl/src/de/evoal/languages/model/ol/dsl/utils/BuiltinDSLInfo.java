package de.evoal.languages.model.ol.dsl.utils;

import java.io.File;

import org.eclipse.emf.common.util.URI;

public class BuiltinDSLInfo {
	private final File module;
	private final String fileName;
	
	public BuiltinDSLInfo(final File module, final String fileName) {
		this.module = module;
		this.fileName = fileName;
	}

	public File getModule() {
		return module;
	}

	public String getFileName() {
		return fileName;
	}
	
	public URI getImportURI() {
	    return URI.createURI(String.format("zip:file://%s!/%s", module.toString(), fileName));
	}
}
