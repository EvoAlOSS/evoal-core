package de.evoal.surrogate.smile.svr.pearson;

import de.evoal.surrogate.smile.svr.AbstractSVRPSONWriter;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.surrogate.smile.ml.pearson-svr-writer-pson")
@Slf4j
public class PearsonKernelPSONWriter extends AbstractSVRPSONWriter {
	public PearsonKernelPSONWriter() {
		super("de.evoal.surrogate.smile.ml.pearson-svr");
	}
}
