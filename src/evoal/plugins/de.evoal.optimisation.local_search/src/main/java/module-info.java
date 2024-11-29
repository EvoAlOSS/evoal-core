module de.evoal.optimisation.local_search {
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

    exports de.evoal.optimisation.local_search.api.neighbour;
    exports de.evoal.optimisation.local_search.api.probability;
    exports de.evoal.optimisation.local_search.api.cooling;
    exports de.evoal.optimisation.local_search.main;

    // Opening packages to CDI
    opens de.evoal.optimisation.local_search;
    opens de.evoal.optimisation.local_search.main to weld.core.impl;
    opens de.evoal.optimisation.local_search.main.neighbour to weld.core.impl;
    opens de.evoal.optimisation.local_search.main.cooling to weld.core.impl;
    opens de.evoal.optimisation.local_search.main.probability to weld.core.impl;
    opens de.evoal.optimisation.local_search.api.neighbour to weld.core.impl;
    opens de.evoal.optimisation.local_search.api.cooling to weld.core.impl;
    opens de.evoal.optimisation.local_search.api.probability to weld.core.impl;
}
