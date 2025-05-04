package de.evoal.optimisation.pso.main.impl;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.pso.api.optimiser.Swarm;
import de.evoal.languages.model.base.expressions.Instance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Slf4j
@Dependent
@Named("de.evoal.optimisation.pso.optimisation.particle-swarm-optimisation")
public class ParticleSwarmAlgorithm implements OptimisationAlgorithm {

    private Swarm swarm;

    @Inject
    private AttributeHelper helper;

    @Override
    public OptimisationAlgorithm init(final Instance configuration) {
        final Instance swarmConfiguration = helper.lookup(configuration, "swarm");
        swarm = BeanFactory.createComponent(Swarm.class, swarmConfiguration);

        return this;
    }

    @Override
    public void run() {
        swarm.run();
    }
}
