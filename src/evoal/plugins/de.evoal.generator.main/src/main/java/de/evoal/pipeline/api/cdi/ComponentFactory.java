package de.evoal.pipeline.api.cdi;

import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.generator.Step;
import de.evoal.pipeline.api.model.Component;
import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.ApplicationScoped;
import java.util.Set;

@ApplicationScoped
public class ComponentFactory {

    public Component create(final @NonNull Step step) throws InitializationException {
        throw new RuntimeException();
    }
}
