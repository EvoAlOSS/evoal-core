package de.evoal.core.main.validation;

import de.evoal.core.api.validation.components.InstanceValidationComponent;
import de.evoal.core.api.validation.components.MetaValidationComponent;
import de.evoal.core.api.validation.context.EObjectContext;
import de.evoal.core.api.validation.context.ResourceContext;
import de.evoal.core.api.validation.model.MetaValidator;
import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Instance;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Slf4j
@ApplicationScoped
public class InstanceValidator implements MetaValidator {
    @Inject
    private InstanceValidationComponent instanceValidator;

    @Override
    public void validate(@NonNull Resource resource) {
        final TreeIterator<EObject> treeIterator = resource.getAllContents();

        while (treeIterator.hasNext()) {
            final EObject object = treeIterator.next();

            if (object instanceof Instance instance) {
                instanceValidator.validate(new EObjectContext(new ResourceContext(resource), toPath(instance), instance), instance);
            }
        }
    }

    private String toPath(final Instance instance) {
        EObject child = instance;
        EObject current = instance.eContainer();
        String path = "";

        while(current != null) {
            if(current instanceof Attribute attr) {
                path = "." + attr.getDefinition().getName() + path;
            } else if(current instanceof Array arr) {
                for(int index = 0; index < arr.getValues().size(); ++index) {
                    if(child == arr.getValues().get(index)) {
                        path = "[" + index + "]" + path;
                        break;
                    }
                }
            } else if(current.eClass().getName().endsWith("Module")) {
                for(final EStructuralFeature feature : current.eClass().getEAllStructuralFeatures()) {
                    if(current.eGet(feature) == child) {
                        path = feature.getName() + path;
                        return path;
                    }
                }
            }


            child = current;
            current = current.eContainer();
        }

        return path;
    }

    @Override
    public int priority() {
        return 300;
    }
}
