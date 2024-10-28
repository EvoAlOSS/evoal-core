module de.evoal.optimisation.sa {
    // declare dependencies to EvoAl
    requires de.evoal.core.main;
    requires de.evoal.generator.main;
    requires de.evoal.languages.model.generator;
    requires de.evoal.languages.model.instance;
    requires de.evoal.languages.model.base;
    requires de.evoal.languages.model.ddl;
    requires de.evoal.languages.model.utils;
    requires de.evoal.optimisation.api;
    requires de.evoal.optimisation.hc;

    // CDI related dependencies
    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;

    // logging
    requires org.slf4j;
    requires lombok;
    requires de.evoal.languages.model.interpreter;

    exports de.evoal.optimisation.sa.api.cooling;
    exports de.evoal.optimisation.sa.api.probability;
    exports de.evoal.optimisation.sa.main;

    // Opening packages to CDI
    opens de.evoal.optimisation.sa;
    opens de.evoal.optimisation.sa.main to weld.core.impl;
    opens de.evoal.optimisation.sa.api.cooling to weld.core.impl;
    opens de.evoal.optimisation.sa.api.probability to weld.core.impl;
    opens de.evoal.optimisation.sa.main.cooling to weld.core.impl;
    opens de.evoal.optimisation.sa.main.probability to weld.core.impl;
}
