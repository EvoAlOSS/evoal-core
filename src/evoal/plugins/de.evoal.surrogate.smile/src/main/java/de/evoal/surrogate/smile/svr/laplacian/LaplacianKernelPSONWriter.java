package de.evoal.surrogate.smile.svr.laplacian;

import de.evoal.surrogate.smile.svr.AbstractSVRPSONWriter;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Dependent
@Named("de.evoal.surrogate.smile.ml.laplacian-svr-writer-pson")
@Slf4j
public class LaplacianKernelPSONWriter extends AbstractSVRPSONWriter {
	public LaplacianKernelPSONWriter() {
		super("de.evoal.surrogate.smile.ml.laplacian-svr");
	}
}
