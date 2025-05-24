package de.evoal.pipeline.api.model;

import lombok.Getter;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.ecore.Space;

public abstract class ComponentImpl implements Component, EvoalComponent<ComponentImpl> {

    @Getter
    private Space reads;

    @Getter
    private Space writes;

    public void setFeatures(final Space reads, final Space writes) {
        this.reads = reads;
        this.writes = writes;
    }

    @Override
    public void close() {
    }
}
