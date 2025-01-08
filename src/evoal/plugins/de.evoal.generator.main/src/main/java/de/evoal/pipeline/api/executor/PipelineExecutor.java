package de.evoal.pipeline.api.executor;

import de.evoal.pipeline.api.model.Composite;
import de.evoal.pipeline.api.model.TypedEObject;
import org.eclipse.emf.ecore.EClass;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public interface PipelineExecutor {
    void setSpace(EClass space);

    void execute(Composite pipeline, Optional<Function<Stream<TypedEObject>, Stream<TypedEObject>>> countLimit);
}
