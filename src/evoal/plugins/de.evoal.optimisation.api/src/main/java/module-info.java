module de.evoal.optimisation.api {
    requires java.base;
    requires java.annotation;

    requires jakarta.enterprise.cdi.api;
    requires jakarta.inject.api;

    requires weld.se.core;
    requires deltaspike.cdictrl.api;
    requires deltaspike.cdictrl.weld;
    requires deltaspike.core.api;

    requires lombok;

    requires org.slf4j;
    requires jul.to.slf4j;
    requires ch.qos.logback.classic;

    requires commons.csv;

    requires com.fasterxml.jackson.databind;

    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore;
    requires org.eclipse.xtext;

    requires de.evoal.languages.model.base;
    requires de.evoal.languages.model.base.dsl;
    requires de.evoal.languages.model.ddl;
    requires de.evoal.languages.model.ddl.dsl;
    requires de.evoal.languages.model.dl;
    requires de.evoal.languages.model.dl.dsl;
    requires de.evoal.languages.model.ol;
    requires de.evoal.languages.model.ol.dsl;
    requires de.evoal.languages.model.interpreter;
    requires de.evoal.languages.model.utils;
    requires com.google.guice;
    requires commons.math3;
    requires de.evoal.core.main;
    requires jakarta.ejb.api;

    opens de.evoal.optimisation; // export dl files.

    exports de.evoal.optimisation.main.constraints.constraint.utils;

    exports de.evoal.optimisation.api.board;
    exports de.evoal.optimisation.api.cdi;
    exports de.evoal.optimisation.api.constraints.calculation;
    exports de.evoal.optimisation.api.constraints.model;
    exports de.evoal.optimisation.api.constraints.strategies;
    exports de.evoal.optimisation.api.correlations;
    exports de.evoal.optimisation.api.model;
    exports de.evoal.optimisation.api.model.impl;
    exports de.evoal.optimisation.api.statistics.io;
    exports de.evoal.optimisation.api.statistics.writer;

    exports de.evoal.optimisation.main.fitness;
    exports de.evoal.optimisation.main.constraints.constraint.strategies.constraint;
    exports de.evoal.optimisation.main.constraints.constraint.strategies.calculations;

    opens de.evoal.optimisation.api.board to weld.core.impl;
    opens de.evoal.optimisation.api.cdi to weld.core.impl;
    opens de.evoal.optimisation.api.constraints.calculation to weld.core.impl;
    opens de.evoal.optimisation.api.constraints.model to weld.core.impl;
    opens de.evoal.optimisation.api.correlations to weld.core.impl;
    opens de.evoal.optimisation.api.model to weld.core.impl;
    opens de.evoal.optimisation.api.model.impl to weld.core.impl;
    opens de.evoal.optimisation.api.statistics to weld.core.impl;
    opens de.evoal.optimisation.api.statistics.io to weld.core.impl;
    opens de.evoal.optimisation.api.statistics.writer to weld.core.impl;

    opens de.evoal.optimisation.main.comparator to weld.core.impl;
    opens de.evoal.optimisation.main.constraints.constraint to weld.core.impl;
    opens de.evoal.optimisation.main.constraints.constraint.strategies.calculations to weld.core.impl;
    opens de.evoal.optimisation.main.constraints.constraint.strategies.constraint to weld.core.impl;
    opens de.evoal.optimisation.main.constraints.constraint.utils to weld.core.impl;
    opens de.evoal.optimisation.main.constraints.correlation to weld.core.impl;
    opens de.evoal.optimisation.main.constraints.deviation to weld.core.impl;
    opens de.evoal.optimisation.main.fitness to weld.core.impl;
    opens de.evoal.optimisation.main.initial to weld.core.impl;
    opens de.evoal.optimisation.main.producer to weld.core.impl;
    opens de.evoal.optimisation.main.search to weld.core.impl;
    opens de.evoal.optimisation.main.statistics to weld.core.impl;
    opens de.evoal.optimisation.main.statistics.individuals to weld.core.impl;
    opens de.evoal.optimisation.main.statistics.io.csv to weld.core.impl;
    opens de.evoal.optimisation.main.statistics.nop to weld.core.impl;
    opens de.evoal.optimisation.main.stopping to weld.core.impl;
    opens de.evoal.optimisation.main.statistics.stopping to weld.core.impl;
}
