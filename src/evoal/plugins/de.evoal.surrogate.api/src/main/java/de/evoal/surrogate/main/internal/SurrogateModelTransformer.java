package de.evoal.surrogate.main.internal;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.dynamic.ModelTransformer;
import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.core.CorePackage;
import de.evoal.models.v202704.pipeline.PipelineModule;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NonNull;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Collection;
import java.util.List;

/**
 * Creates the runtime configurations of the surrogate plugin: the pipeline steps of a
 *   machine-learning module and the steps of a pipeline that is read from a PSON file.
 */
@ApplicationScoped
public class SurrogateModelTransformer extends ModelTransformer {
    @Override
    protected Collection<EPackage> mappedPackages() {
        return List.of(CorePackage.eINSTANCE);
    }

    /**
     * Converts the use case of a machine-learning module into a pipeline module.
     *
     * @param module The parsed machine-learning module.
     * @param space The space of the pipeline.
     * @param useCase The use case attribute of the module to convert.
     * @param loader For loading definition modules.
     * @param helper For mapping between data descriptions and features.
     * @return The runtime pipeline module.
     */
    public PipelineModule transform(final @NonNull MachineLearningModule module,
                                    final @NonNull Space space,
                                    final @NonNull EStructuralFeature useCase,
                                    final @NonNull DefinitionModuleLoader loader,
                                    final @NonNull EAnnotationHelper helper) {
        this.space = space;

        return checkConfiguredBy(new MLLModelConverter(loader, helper, space, useCase, this).convert(module));
    }

    /**
     * Sets the space used for creating runtime configurations without a parsed module,
     *   e.g., when reading a pipeline from a PSON file.
     *
     * @param space The space of the pipeline.
     * @return The transformer itself.
     */
    public SurrogateModelTransformer setSpace(final @NonNull Space space) {
        this.space = space;

        return this;
    }
}
