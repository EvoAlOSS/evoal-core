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

    opens de.evoal.surrogate.smile;

    exports de.evoal.surrogate.smile.svr to de.evoal.approximative.interval;

    opens de.evoal.surrogate.smile.svr;
}
