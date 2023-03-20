package de.evoal.core.api.constraints.model;

import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.DataDescriptionModel;
import de.evoal.languages.model.ddl.TypedDataDescription;
import de.evoal.languages.model.el.Expression;
import org.apache.commons.math3.util.Pair;

import java.util.*;
import java.util.stream.Stream;

public class DataConstraints {
    private final List<Expression> globalConstraints = new LinkedList<>();
    private final Map<DataDescription, List<Expression>> dataConstraints = new HashMap<>();

    public DataConstraints(final Collection<DataDescriptionModel> models) {
        // collect global constraints
        models.stream()
              .map(DataDescriptionModel::getConstraints)
              .forEach(globalConstraints::addAll);

        models.stream()
              .flatMap(m -> m.getDescriptions().stream())
              .forEach(d -> {
                  final List<Expression> constraints = new LinkedList<>();
                  constraints.addAll(d.getConstraints());

                  if(d instanceof TypedDataDescription) {
                      constraints.addAll(((TypedDataDescription)d).getType().getConstraints());
                  }

                  dataConstraints.put(d, constraints);
              });
    }

    public Collection<Expression> getGlobalConstraints() {
        return globalConstraints;
    }

    public Collection<Map.Entry<DataDescription, List<Expression>>> getContextConstraints() {
        return dataConstraints.entrySet();
    }

    public Stream<Pair<DataDescription, List<Expression>>> stream() {
        return Stream.concat(
                Stream.of(new Pair<DataDescription, List<Expression>>(null, globalConstraints)),
                dataConstraints.entrySet().stream().map(e -> new Pair<>(e.getKey(), e.getValue()))
                );
    }
}
