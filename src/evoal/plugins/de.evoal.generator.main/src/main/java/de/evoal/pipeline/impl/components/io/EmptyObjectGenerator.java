package de.evoal.pipeline.impl.components.io;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.pipeline.api.model.PipelineSource;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.stream.Stream;

@Slf4j
@Dependent
@Named("de.evoal.pipeline.io.empty")
public class EmptyObjectGenerator extends PipelineComponentImpl implements PipelineSource {
    @Override
    public @NonNull TypedEObject apply(@NonNull TypedEObject object) {
        return object;
    }

    @Override
    public @NonNull Stream<@NonNull TypedEObject> toStream() {
        return Stream.generate(getPipelineSpace()::newEObject);
    }
}

    /*
            Stream<TypedEObject> stream = Stream.generate(space::newEObject);
            if(limiter.isPresent()) {
                stream = limiter.get().apply(stream);
            }


        private final int limit;
        private int count = 0;

     */