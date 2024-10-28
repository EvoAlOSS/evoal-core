module de.evoal.optimisation.hc {
    // declare dependencies to EvoAl
    requires de.evoal.core.main;
    requires de.evoal.generator.main;
    requires de.evoal.languages.model.generator;
    requires de.evoal.languages.model.instance;
    requires de.evoal.languages.model.base;
    requires de.evoal.languages.model.ddl;
    requires de.evoal.languages.model.utils;
    requires de.evoal.optimisation.api;

    // CDI related dependencies
    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;

    // logging
    requires org.slf4j;
    requires lombok;
    requires de.evoal.languages.model.interpreter;

    exports de.evoal.optimisation.hc.api.neighbour;
    exports de.evoal.optimisation.hc.main;

    // Opening packages to CDI
    opens de.evoal.optimisation.hc;
    opens de.evoal.optimisation.hc.main to weld.core.impl;
    opens de.evoal.optimisation.hc.main.neighbour to weld.core.impl;
    opens de.evoal.optimisation.hc.api.neighbour to weld.core.impl;
}
