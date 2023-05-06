module de.evoal.core.main {
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
    requires de.evoal.languages.model.instance;
    requires de.evoal.languages.model.utils;
    requires com.google.guice;
    requires commons.math3;

    opens de.evoal.core; // export dl files.

    exports de.evoal.core.api.board;
    exports de.evoal.core.api.cdi;
    exports de.evoal.core.api.constraints.calculation;
    exports de.evoal.core.main.constraints.constraint.utils;
    exports de.evoal.core.api.constraints.model;
    exports de.evoal.core.api.constraints.strategies;
    exports de.evoal.core.api.constraints.strategies.fitness;
    exports de.evoal.core.api.correlations;
    exports de.evoal.core.api.languages;
    exports de.evoal.core.api.properties;
    exports de.evoal.core.api.properties.info;
    exports de.evoal.core.api.properties.io;
    exports de.evoal.core.api.properties.stream;
    exports de.evoal.core.api.optimisation;
    exports de.evoal.core.api.statistics;
    exports de.evoal.core.api.statistics.io;
    exports de.evoal.core.api.statistics.writer;
    exports de.evoal.core.api.utils;

    opens de.evoal.core.api.board to weld.core.impl;
    opens de.evoal.core.api.cdi to weld.core.impl;
    opens de.evoal.core.api.constraints.calculation to weld.core.impl;
    opens de.evoal.core.api.constraints.model to weld.core.impl;
    opens de.evoal.core.api.correlations to weld.core.impl;
    opens de.evoal.core.api.languages to weld.core.impl;
    opens de.evoal.core.api.optimisation to weld.core.impl;
    opens de.evoal.core.api.properties to weld.core.impl;
    opens de.evoal.core.api.properties.info to weld.core.impl;
    opens de.evoal.core.api.properties.io to weld.core.impl;
    opens de.evoal.core.api.properties.stream to weld.core.impl;
    opens de.evoal.core.api.statistics to weld.core.impl;
    opens de.evoal.core.api.utils to weld.core.impl;

    opens de.evoal.core.main.comparator to weld.core.impl;
    opens de.evoal.core.main.constraints.constraint to weld.core.impl;
    opens de.evoal.core.main.constraints.constraint.strategies.calculations to weld.core.impl;
    opens de.evoal.core.main.constraints.constraint.strategies.constraint to weld.core.impl;
    opens de.evoal.core.main.constraints.constraint.strategies.fitness to weld.core.impl;
    opens de.evoal.core.main.constraints.correlation to weld.core.impl;
    opens de.evoal.core.main.constraints.deviation to weld.core.impl;
    opens de.evoal.core.main.initial to weld.core.impl;
    opens de.evoal.core.main.producer to weld.core.impl;
    opens de.evoal.core.main.properties to weld.core.impl;
    opens de.evoal.core.main.search to weld.core.impl;
    opens de.evoal.core.main.statistics to weld.core.impl;
    opens de.evoal.core.main.statistics.fitness to weld.core.impl;
    opens de.evoal.core.main.statistics.individuals to weld.core.impl;
    opens de.evoal.core.main.statistics.nop to weld.core.impl;
    opens de.evoal.core.main.statistics.io.csv to weld.core.impl;
    opens de.evoal.core.api.statistics.io to weld.core.impl;
    opens de.evoal.core.api.statistics.writer to weld.core.impl;


    //provides de.evoal.languages.model.utils.builtin.BuiltinProvider with ModuleBuiltinProvider;
}
