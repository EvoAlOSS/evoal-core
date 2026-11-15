package de.evoal.surrogate.main.training;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.models.core.ecore.Space;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.surrogate.api.training.ModelLearner;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import org.eclipse.emf.ecore.EObject;

@ApplicationScoped
@Slf4j
public class ModelLearnerFactory {
    public ModelLearner create(final EObject configuration, final Space inputFeatures, final Space outputFeatures) {
      log.info("Creating model learner for '{}'.", configuration.eClass().getName());

      return BeanFactory.createComponent(ModelLearner.class, configuration, "-learner", learner -> learner.setFeatureSpaces(inputFeatures, outputFeatures));
    }
}
