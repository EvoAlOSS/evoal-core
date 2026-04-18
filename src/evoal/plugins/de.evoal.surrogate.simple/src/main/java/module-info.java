module de.evoal.surrogate.simple {
    requires jakarta.inject;
    requires jakarta.cdi;
    requires lombok;

    requires org.slf4j;

    requires commons.math3;

    requires de.evoal.languages.model.ddl;

    requires de.evoal.core.main;
    requires de.evoal.surrogate.api;
    requires de.evoal.languages.model.base;
    requires org.eclipse.emf.ecore;
    requires de.evoal.languages.models;

    opens de.evoal.surrogate.simple;

    opens de.evoal.surrogate.simple.identity to weld.core.impl;
    opens de.evoal.surrogate.simple.linear to weld.core.impl;
    opens de.evoal.surrogate.simple.quadratic to weld.core.impl;
}
