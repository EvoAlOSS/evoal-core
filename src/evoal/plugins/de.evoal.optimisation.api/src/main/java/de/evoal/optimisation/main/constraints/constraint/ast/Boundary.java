package de.evoal.optimisation.main.constraints.constraint.ast;

import de.evoal.languages.model.base.definitions.DataDescription;

public record Boundary(boolean isLowerBoundary, DataDescription data, Number boundary, boolean inclusive) {
}