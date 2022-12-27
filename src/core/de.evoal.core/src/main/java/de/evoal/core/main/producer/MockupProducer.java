package de.evoal.core.main.producer;

import de.evoal.core.main.ea.model.Correlations;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class MockupProducer {
    @Produces @Dependent
    Correlations create() {
        return new Correlations(null);
    }
}
