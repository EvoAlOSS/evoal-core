module de.evoal.approximative.density {
    requires lombok;

    requires org.slf4j;

    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;

    requires de.evoal.languages.model.instance;

    requires de.evoal.core.main;
    requires de.evoal.surrogate.api;

    requires smile.math;
    requires de.evoal.optimisation.api;
    requires de.evoal.languages.model.base;

    opens de.evoal.approximative.density;

    opens de.evoal.approximative.density.ea.fitness to weld.core.impl;
    opens de.evoal.approximative.density.ea.surrogate.gof to weld.core.impl;
}
