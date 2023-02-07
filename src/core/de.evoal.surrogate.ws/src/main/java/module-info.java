module de.evoal.surrogate.ws {
    requires lombok;
    requires org.slf4j;

    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;

    requires de.evoal.languages.model.instance;

    requires de.evoal.core.main;
    requires de.evoal.surrogate.api;

    opens de.evoal.surrogate.ws to  weld.core.impl;
}
