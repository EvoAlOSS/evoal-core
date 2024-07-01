module de.evoal.optimisation.pso {
    requires jakarta.enterprise.cdi.api;
    requires jakarta.inject.api;

    requires java.annotation;

    requires lombok;

    requires org.slf4j;

    requires org.eclipse.emf.ecore;
    requires org.eclipse.emf.common;

    requires de.evoal.languages.model.base;
    requires de.evoal.languages.model.ddl;
    requires de.evoal.languages.model.instance;
    requires de.evoal.languages.model.ol;

    requires de.evoal.core.main;
    requires de.evoal.optimisation.api;

    exports de.evoal.optimisation.pso.api.optimiser;
    exports de.evoal.optimisation.pso.api.swarm;

    opens de.evoal.optimisation.pso;
    opens de.evoal.optimisation.pso.main.impl to weld.core.impl;
    opens de.evoal.optimisation.pso.main.mover to weld.core.impl;
    opens de.evoal.optimisation.pso.main.producer to weld.core.impl;
    opens de.evoal.optimisation.pso.api.swarm to weld.core.impl;
}
