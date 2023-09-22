module de.evoal.surrogate.svr {
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

    opens de.evoal.surrogate.svr;

    exports de.evoal.surrogate.svr to de.evoal.approximative.interval;
}
