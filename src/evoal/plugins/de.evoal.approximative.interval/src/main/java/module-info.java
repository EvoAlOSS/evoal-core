module de.evoal.approximative.interval {
    requires lombok;

    requires org.slf4j;

    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;

    requires smile.math;

    requires de.evoal.core.main;
    requires de.evoal.surrogate.api;
    requires de.evoal.surrogate.svr;
    requires commons.math3;
    requires de.evoal.languages.model.instance;

    opens de.evoal.approximative.interval;
}
