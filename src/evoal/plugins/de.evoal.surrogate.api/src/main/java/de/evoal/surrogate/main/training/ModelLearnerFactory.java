package de.evoal.surrogate.main.training;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.ecore.Space;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.surrogate.api.training.ModelLearner;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
@Slf4j
public class ModelLearnerFactory {
    public ModelLearner create(final Instance configuration, final Space inputFeatures, final Space outputFeatures) {
      log.info("Creating model learner for '{}'.", configuration.getDefinition().getName());

      return BeanFactory.createComponent(ModelLearner.class, configuration, "-learner", learner -> learner.setFeatureSpaces(inputFeatures, outputFeatures));
    }
}
