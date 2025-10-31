package de.evoal.optimisation.main.constraints.constraint.ast;

import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.properties.info.PropertyBoundaries;
import de.evoal.core.api.utils.ArithmeticOperations;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.interpreter.BooleanNumberOperations;
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

    public static PropertiesBoundaries run(final AttributeHelper helper, final DataConstraints constraints) {
        log.info("Searching for properties' boundaries.");

        final PropertiesBoundaries boundaries = new PropertiesBoundaries();
        final Map<DataDescription, Boundary> lowerBounds = new HashMap<>();
        final Map<DataDescription, Boundary> upperBounds = new HashMap<>();

        // process all constraints
        constraints.stream()
                   .filter(p -> p.getKey() != null)
                   .forEach(p -> p.getValue()
                                  .forEach(l -> processConstraint(helper, l, p.getKey(), lowerBounds, upperBounds)));

        // turn them into proper boundaries
        lowerBounds.keySet()
                   .forEach(k -> {
                       final Boundary lower = lowerBounds.get(k);
                       final Boundary upper = upperBounds.get(k);
                       boundaries.add(new PropertySpecification(k.getName(), k), new PropertyBoundaries(lower.boundary(), lower.inclusive(), upper.boundary(), upper.inclusive()));
                   });

        return boundaries;
    }

    private static void processConstraint(final AttributeHelper helper, final Expression constraint, final DataDescription context, final Map<DataDescription, Boundary> lowerBounds, final Map<DataDescription, Boundary> upperBounds) {
        log.info("Processing constraint for {}", context);
        if(!(context instanceof BaseDataDescription)) {
            log.info("Context is not a BaseDataDescription. Skipping.");
            return;
        }

        final UnaryBoundaryIdentifier unary = new UnaryBoundaryIdentifier(context);
        final AnnotationBoundaryIdentifier  annotation = new AnnotationBoundaryIdentifier(helper, context);

        Optional<Boundary> result = annotation.doSwitch(constraint);

        if(!result.isEmpty()) {
            log.info("Found annotation-based boundary for {}", context);
        } else {
            result = (Optional<Boundary>)unary.doSwitch(constraint);

            if(result.isEmpty()) {
                log.info("No boundary for {} found", context);
                return;
            }
            log.info("Found expression-based boundary for {}", context);
        }

        final Boundary boundary = result.get();
        final BaseDataDescription description = (BaseDataDescription)boundary.data();;

        if(boundary.isLowerBoundary()) {
            addDefaultConstraints(description, lowerBounds, upperBounds);

            final Boundary oldLower = lowerBounds.get(description);
            if(
                    // if new boundary is greater
                    BooleanNumberOperations.isGreaterThan(boundary.boundary(), oldLower.boundary())

                    // or the numbers are equal and the new version is not inclusive
                    || (BooleanNumberOperations.isEqualTo(boundary.boundary(), oldLower.boundary()) && !boundary.inclusive())) {
                lowerBounds.put(description, boundary);
            }
        } else {
            addDefaultConstraints(description, lowerBounds, upperBounds);

            final Boundary oldUpper = upperBounds.get(description);
            if(
                // if new boundary is greater
                    BooleanNumberOperations.isLesserThan(boundary.boundary(), oldUpper.boundary())

                    // or the numbers are equal and the new version is not inclusive
                    || (BooleanNumberOperations.isEqualTo(boundary.boundary(), oldUpper.boundary()) && !boundary.inclusive())) {
                upperBounds.put(description, boundary);
            }
        }
    }

    private static void addDefaultConstraints(final BaseDataDescription description, final Map<DataDescription, Boundary> lowerBounds, final Map<DataDescription, Boundary> upperBounds) {
        if(!lowerBounds.containsKey(description)) {
            if(RepresentationType.REAL.equals(description.getRepresentation())) {
                lowerBounds.put(description, new Boundary(true, description, -Double.MAX_VALUE, true));
            } else if(RepresentationType.INTEGER.equals(description.getRepresentation())) {
                lowerBounds.put(description, new Boundary(true, description, Integer.MIN_VALUE, true));
            } else {
                log.warn("Unsupported data type: {}", description.getRepresentation());
            }
        }

        if(!upperBounds.containsKey(description)) {
            if(RepresentationType.REAL.equals(description.getRepresentation())) {
                upperBounds.put(description, new Boundary(false, description, Double.MAX_VALUE, true));
            } else if(RepresentationType.INTEGER.equals(description.getRepresentation())) {
                upperBounds.put(description, new Boundary(false, description,  Integer.MAX_VALUE, true));
            } else {
                log.warn("Unsupported data type: {}", description.getRepresentation());
            }
        }
    }
}
