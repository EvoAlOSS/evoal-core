module de.evoal.surrogate.simple {
    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;
    requires lombok;

    requires org.slf4j;

    requires commons.math3;

    requires de.evoal.languages.model.ddl;

    requires de.evoal.core.main;
    requires de.evoal.surrogate.api;

    exports de.evoal.surrogate.simple.identity to weld.core.impl;
    exports de.evoal.surrogate.simple.linear to weld.core.impl;
    exports de.evoal.surrogate.simple.quadratic to weld.core.impl;
}
