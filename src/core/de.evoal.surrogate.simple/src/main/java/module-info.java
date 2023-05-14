module de.evoal.surrogate.simple {
    requires commons.math3;
    requires jakarta.enterprise.cdi.api;
    requires lombok;
    requires org.slf4j;

    requires de.evoal.core.main;
    requires de.evoal.surrogate.api;
    requires jakarta.inject.api;

    exports de.evoal.surrogate.simple.identity to weld.core.impl;
    exports de.evoal.surrogate.simple.linear to weld.core.impl;
    exports de.evoal.surrogate.simple.quadratic to weld.core.impl;
}
