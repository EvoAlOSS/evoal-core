module de.evoal.optimisation.cma_es {
    // declare dependencies to EvoAl
    requires de.evoal.core.main;
    requires de.evoal.languages.models;
    requires de.evoal.optimisation.api;

    // CDI related dependencies
    requires jakarta.inject;
    requires jakarta.cdi;

    // logging
    requires org.slf4j;
    requires static lombok;
    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore;

    exports de.evoal.optimisation.cma_es.main;
    exports de.evoal.optimisation.cma_es.main.distribution;
    exports de.evoal.optimisation.cma_es.main.restart;

    // Opening packages to CDI
    opens de.evoal.optimisation.cma_es;
    opens de.evoal.optimisation.cma_es.main to weld.core.impl;
    opens de.evoal.optimisation.cma_es.main.restart to weld.core.impl;
}
