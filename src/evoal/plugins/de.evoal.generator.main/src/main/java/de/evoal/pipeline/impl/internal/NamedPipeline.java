package de.evoal.pipeline.impl.internal;

import de.evoal.languages.model.generator.Step;

import java.util.Collection;

public record NamedPipeline(String name, Collection<Step> steps) {
}
