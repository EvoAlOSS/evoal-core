module de.evoal.surrogate.smile {
    requires lombok;

    requires org.slf4j;

    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;

    requires smile.core;
    requires smile.math;
    requires commons.math3;

    requires de.evoal.languages.model.ddl;

    requires de.evoal.core.main;
    requires de.evoal.surrogate.api;

    // export API for down-stream plugins
    exports de.evoal.surrogate.smile.api;

    // TODO limit export to the Xtext component that resolves imports
    opens de.evoal.surrogate.smile;

    opens de.evoal.surrogate.smile.svr to weld.core.impl;
}
