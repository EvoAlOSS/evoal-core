module de.evoal.optimisation.random_search {
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
    requires org.eclipse.emf.ecore;

    exports de.evoal.optimisation.random_search.main;

    // Opening packages to CDI
    opens de.evoal.optimisation.random_search;
    opens de.evoal.optimisation.random_search.main to weld.core.impl;
}
