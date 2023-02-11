module de.evoal.surrogate.api {
    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;

    requires java.annotation;

    requires lombok;

    requires org.slf4j;

    requires org.eclipse.emf.ecore;
    requires org.eclipse.emf.common;
    requires org.eclipse.xtext;
    requires com.fasterxml.jackson.databind;
    requires smile.math;
    requires commons.math3;
    requires io.jenetics.base;


    requires de.evoal.core.main;
    requires de.evoal.languages.model.ddl;
    requires de.evoal.languages.model.dl;
    requires de.evoal.languages.model.el;
    requires de.evoal.languages.model.mll;
    requires de.evoal.languages.model.ddl.dsl;
    requires de.evoal.languages.model.dl.dsl;
    requires de.evoal.languages.model.el.dsl;
    requires de.evoal.languages.model.mll.dsl;
    requires de.evoal.languages.model.instance;

    exports de.evoal.surrogate.api;
    exports de.evoal.surrogate.api.function;
    exports de.evoal.surrogate.api.configuration;

    // open packages for CDI
    opens de.evoal.surrogate.api to weld.core.impl;
    opens de.evoal.surrogate.api.configuration to com.fasterxml.jackson.databind;
    opens de.evoal.surrogate.api.training to weld.core.impl;

    opens de.evoal.surrogate.main to weld.core.impl;
    opens de.evoal.surrogate.main.cdi to weld.core.impl;
    opens de.evoal.surrogate.main.ea to weld.core.impl;
    opens de.evoal.surrogate.main.internal to weld.core.impl;
    opens de.evoal.surrogate.main.jackson to weld.core.impl, com.fasterxml.jackson.databind;
    opens de.evoal.surrogate.main.gof.cross to weld.core.impl;
    opens de.evoal.surrogate.main.gof.rmse to weld.core.impl;
    opens de.evoal.surrogate.main.gof.rsquare to weld.core.impl;
    opens de.evoal.surrogate.main.statistics.constraint to weld.core.impl;
    opens de.evoal.surrogate.main.statistics.correlated to weld.core.impl;
    opens de.evoal.surrogate.main.statistics.ranged to weld.core.impl;
    opens de.evoal.surrogate.main.statistics.surrogate to weld.core.impl;
}