package de.evoal.surrogate.main.internal;

import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.languages.model.pipeline.PipelineModule;
import org.eclipse.emf.ecore.EClass;

public class DSLConverter {
    private final EClass space;

    public DSLConverter(final EClass space) {
        this.space = space;
    }

    public PipelineModule convert(final MachineLearningModule module) {
        return null;
    }
}
