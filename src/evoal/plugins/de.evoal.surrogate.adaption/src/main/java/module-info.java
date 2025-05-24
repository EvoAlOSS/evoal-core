module de.evoal.surrogate.adaption {
    requires lombok;

    requires org.slf4j;

    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;

    requires smile.base;
    requires commons.math3;

    requires de.evoal.languages.model.base;

    requires de.evoal.core.main;
    requires de.evoal.optimisation.api;
    requires de.evoal.surrogate.api;
    requires de.evoal.surrogate.smile;
    requires de.evoal.core.interpreter;
    requires org.eclipse.emf.ecore;

    exports de.evoal.surrogate.adaption.interval.model;
    exports de.evoal.surrogate.adaption.density.model;

    opens de.evoal.surrogate.adaption.density;
    opens de.evoal.surrogate.adaption.interval;

    opens de.evoal.surrogate.adaption.density.ea.fitness to weld.core.impl;
    opens de.evoal.surrogate.adaption.density.ea.surrogate.gof to weld.core.impl;
    opens de.evoal.surrogate.adaption.interval.ea.fitness to weld.core.impl;
    opens de.evoal.surrogate.adaption.interval.ea.surrogate.gof to weld.core.impl;
}





