package de.evoal.pipeline.api.model;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.pipeline.api.model.dynamic.SubSpace;
import lombok.Getter;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Collection;
import java.util.LinkedHashSet;

public abstract class ComponentImpl implements Component, EvoalComponent<ComponentImpl> {

    @Getter
    private SubSpace reads;

    @Getter
    private SubSpace writes;

    public void setFeatures(final Collection<EStructuralFeature> reads, final Collection<EStructuralFeature> writes) {
        this.reads = new SubSpace(reads);
        this.writes = new SubSpace(writes);
    }

    @Override
    public void close() {
    }
}
