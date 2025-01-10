package de.evoal.pipeline.api.model;

import de.evoal.core.api.cdi.EvoalComponent;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.*;

public abstract class ComponentImpl implements Component, EvoalComponent<ComponentImpl> {

    private LinkedHashSet<EStructuralFeature> reads;
    private LinkedHashSet<EStructuralFeature> writes;

    public void setFeatures(final Collection<EStructuralFeature> reads, final Collection<EStructuralFeature> writes) {
        this.reads = new LinkedHashSet<>(reads);
        this.writes = new LinkedHashSet<>(writes);
    }

    @Override
    public @NonNull LinkedHashSet<EStructuralFeature> getReads() {
        return reads;
    }

    @Override
    public @NonNull LinkedHashSet<EStructuralFeature> getWrites() {
        return writes;
    }

    @Override
    public void close() {
    }
}
