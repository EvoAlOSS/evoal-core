module de.evoal.surrogate.adaption {
    requires lombok;

    requires org.slf4j;

    requires jakarta.inject;
    requires jakarta.cdi;

    requires smile.base;
    requires commons.math3;

    requires de.evoal.core.main;
    requires de.evoal.optimisation.api;
    requires de.evoal.surrogate.api;
    requires de.evoal.surrogate.smile;
    requires org.eclipse.emf.ecore;
    requires de.evoal.languages.models;

    exports de.evoal.surrogate.adaption.interval.model;
    exports de.evoal.surrogate.adaption.density.model;

    opens de.evoal.surrogate.adaption.density;
    opens de.evoal.surrogate.adaption.interval;

    opens de.evoal.surrogate.adaption to weld.core.impl;
    opens de.evoal.surrogate.adaption.density.fitness to weld.core.impl;
    opens de.evoal.surrogate.adaption.density.ea.surrogate.gof to weld.core.impl;
    opens de.evoal.surrogate.adaption.interval.fitness to weld.core.impl;
    opens de.evoal.surrogate.adaption.interval.ea.surrogate.gof to weld.core.impl;
}





