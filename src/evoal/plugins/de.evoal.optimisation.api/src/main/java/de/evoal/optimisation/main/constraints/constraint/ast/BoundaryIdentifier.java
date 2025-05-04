package de.evoal.optimisation.main.constraints.constraint.ast;

import de.evoal.optimisation.api.constraints.model.DataConstraints;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.languages.model.base.definitions.BaseDataDescription;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.RepresentationType;
import de.evoal.languages.model.base.expressions.*;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class BoundaryIdentifier {

    public static PropertiesBoundaries run(final DataConstraints constraints) {
        log.info("Searching for properties boundaries");

        final Map<DataDescription, Number> lowerBounds = new HashMap<>();
        final Map<DataDescription, Number> upperBounds = new HashMap<>();

        constraints.stream()
                   .filter(p -> p.getKey() != null)
                   .forEach(p -> p.getValue()
                                  .stream()
                                  .forEach(l -> processConstraint(l, p.getKey(), lowerBounds, upperBounds)));

        final PropertiesBoundaries boundaries = new PropertiesBoundaries();
        lowerBounds.keySet()
                .stream()
                .forEach(k -> boundaries.add(new PropertySpecification(k.getName(), k), new PropertiesBoundaries.Boundaries(lowerBounds.get(k), upperBounds.get(k))));

        return boundaries;
    }

    private static void processConstraint(final Expression constraint, final DataDescription context, final Map<DataDescription, Number> lowerBounds, final Map<DataDescription, Number> upperBounds) {
        log.info("Processing constraint for {}", context);
        if(!(context instanceof BaseDataDescription)) {
            log.info("Context is not a BaseDataDescription. Skipping.");
            return;
        }

        final UnaryBoundaryIdentifier identifier = new UnaryBoundaryIdentifier(context);

        UnaryBoundaryIdentifier.Boundary result = (UnaryBoundaryIdentifier.Boundary)identifier.doSwitch(constraint);
        if(result == null) {
            return;
        }

        final DataDescription description = result.data();

        if(result.isLowerBoundary()) {
            addDefaultConstraints((BaseDataDescription)description, lowerBounds, upperBounds);

            final Number oldLower = lowerBounds.get(description);
            if(result.boundary().doubleValue() > oldLower.doubleValue()) {
                lowerBounds.put(description, result.boundary());
            }
        } else {
            addDefaultConstraints((BaseDataDescription)description, lowerBounds, upperBounds);

            final Number oldUpper = upperBounds.get(description);
            if(result.boundary().doubleValue() < oldUpper.doubleValue()) {
                upperBounds.put(description, result.boundary());
            }
        }
    }

    private static void addDefaultConstraints(BaseDataDescription description, Map<DataDescription, Number> lowerBounds, Map<DataDescription, Number> upperBounds) {
        if(!lowerBounds.containsKey(description)) {
            if(RepresentationType.REAL.equals(description.getRepresentation())) {
                lowerBounds.put(description, -Double.MAX_VALUE);
                upperBounds.put(description, Double.MAX_VALUE);
            } else if(RepresentationType.INTEGER.equals(description.getRepresentation())) {
                lowerBounds.put(description, Integer.MIN_VALUE);
                upperBounds.put(description, Integer.MAX_VALUE);
            } else {
                log.warn("Unsupported data type: {}", description.getRepresentation());
            }
        }
    }
}
