module de.evoal.surrogate.svr {
    requires commons.math3;
    requires jakarta.enterprise.cdi.api;
    requires lombok;
    requires org.slf4j;

    requires de.evoal.core;
    requires de.evoal.surrogate.api;
    requires smile.core;
    requires smile.math;
    requires jakarta.inject.api;

    opens de.evoal.surrogate.svr;
}
