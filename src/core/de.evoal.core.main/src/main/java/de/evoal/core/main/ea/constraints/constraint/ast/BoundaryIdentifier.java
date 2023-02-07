package de.evoal.core.main.ea.constraints.constraint.ast;

import de.evoal.core.api.ea.constraints.model.DataConstraints;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.DataReference;
import de.evoal.languages.model.ddl.RepresentationType;
import de.evoal.languages.model.ddl.SelfReference;
import de.evoal.languages.model.el.*;
import de.evoal.languages.model.el.util.ELSwitch;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class BoundaryIdentifier {

    public static PropertiesBoundaries run(final DataConstraints constraints) {
        final Map<DataDescription, Number> lowerBounds = new HashMap<>();
        final Map<DataDescription, Number> upperBounds = new HashMap<>();

        constraints.stream()
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
        final UnaryBoundaryIdentifier identifier = new UnaryBoundaryIdentifier(context);

        Object result = identifier.doSwitch(constraint);
        if(result == null) {
            return;
        }

        final Object [] llc = (Object[]) result;

        if(llc[0] instanceof Number) {
            final DataDescription descr = (DataDescription) llc[1];
            final Number value = (Number)llc[0];

            if(!lowerBounds.containsKey(descr)) {
                if(RepresentationType.REAL.equals(descr.getRepresentation())) {
                    lowerBounds.put(descr, -Double.MAX_VALUE);
                    upperBounds.put(descr, Double.MAX_VALUE);
                } else if(RepresentationType.INTEGER.equals(descr.getRepresentation())) {
                    lowerBounds.put(descr, Integer.MIN_VALUE);
                    upperBounds.put(descr, Integer.MAX_VALUE);
                }
            }

            final Number oldLower = lowerBounds.get(descr);
            if(value.doubleValue() > oldLower.doubleValue()) {
                lowerBounds.put(descr, value);
            }
        } else {
            final DataDescription descr = (DataDescription) llc[0];
            final Number value = (Number)llc[1];

            if(!lowerBounds.containsKey(descr)) {
                if(RepresentationType.REAL.equals(descr.getRepresentation())) {
                    lowerBounds.put(descr, -Double.MAX_VALUE);
                    upperBounds.put(descr, Double.MAX_VALUE);
                } else if(RepresentationType.INTEGER.equals(descr.getRepresentation())) {
                    lowerBounds.put(descr, Integer.MIN_VALUE);
                    upperBounds.put(descr, Integer.MAX_VALUE);
                }
            }

            final Number oldUpper = upperBounds.get(descr);
            if(value.doubleValue() < oldUpper.doubleValue()) {
                upperBounds.put(descr, value);
            }
        }
    }
}
