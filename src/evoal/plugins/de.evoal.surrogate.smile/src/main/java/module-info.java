module de.evoal.surrogate.smile {
    requires lombok;

    requires org.slf4j;

    requires jakarta.inject;
    requires jakarta.cdi;

    requires smile.core;
    requires smile.base;
    requires commons.math3;

    requires de.evoal.languages.model.ddl;

    requires de.evoal.core.main;
    requires de.evoal.surrogate.api;
    requires org.eclipse.emf.ecore;
    requires de.evoal.languages.model.base;
    requires de.evoal.languages.models;
    requires de.evoal.languages.model.dl;
    requires de.evoal.languages.model.interpreter;

    // export API for down-stream plugins
    exports de.evoal.surrogate.smile.api;

    // TODO limit export to the Xtext component that resolves imports
    opens de.evoal.surrogate.smile;

    opens de.evoal.surrogate.smile.gaussian to weld.core.impl;
    opens de.evoal.surrogate.smile.svr to weld.core.impl;
}
