package de.evoal.core.api.cdi;


import de.evoal.models.core.cdi.EvoalComponent;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.emf.ecore.EObject;

@ApplicationScoped
public class ComponentProducer {
    public <T extends EvoalComponent<T>> T create(final Class<T> clazz, final EObject configuration) {
        return BeanFactory.createComponent(clazz, configuration);
    }
}
