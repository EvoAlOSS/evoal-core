package de.evoal.pipeline.impl.internal;

import de.evoal.core.api.dynamic.ModelTransformer;
import de.evoal.languages.model.generator.GeneratorModule;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.core.CorePackage;
import de.evoal.models.v202704.pipeline.PipelineModule;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.emf.ecore.EPackage;

import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class GeneratorModelTransformer extends ModelTransformer {
    @Override
    protected Collection<EPackage> mappedPackages() {
        return List.of(CorePackage.eINSTANCE);
    }

    public PipelineModule transform(final GeneratorModule module, final Space space) {
        this.space = space;
        return checkConfiguredBy(new GeneratorDSLConverter(space, this).convert(module));
    }
}
