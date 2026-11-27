module de.evoal.optimisation.gp {
    // EvoAl
    requires de.evoal.core.main;
    requires de.evoal.languages.models;
    requires de.evoal.languages.model.base;
    requires de.evoal.languages.model.interpreter;
    requires de.evoal.optimisation.api;

    // CDI
    requires jakarta.inject;
    requires jakarta.cdi;

    // logging
    requires org.slf4j;
    requires static lombok;

    // EMF
    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore;

    // exports
    exports de.evoal.optimisation.gp.api;
    exports de.evoal.optimisation.gp.main;

    // opens: the DL file and the beans
    opens de.evoal.optimisation.gp;
    opens de.evoal.optimisation.gp.main to weld.core.impl;
}
