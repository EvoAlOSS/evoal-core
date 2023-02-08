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

    requires io.jenetics.base;
    requires io.jenetics.ext;
    requires commons.math3;
    requires commons.csv;
    requires smile.math;

    requires decimal4j;

    requires com.fasterxml.jackson.databind;

    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore;
    requires org.eclipse.xtext;

    requires de.evoal.languages.model.ddl;
    requires de.evoal.languages.model.ddl.dsl;
    requires de.evoal.languages.model.dl;
    requires de.evoal.languages.model.dl.dsl;
    requires de.evoal.languages.model.ol;
    requires de.evoal.languages.model.ol.dsl;
    requires de.evoal.languages.model.el;
    requires de.evoal.languages.model.el.dsl;
    requires de.evoal.languages.model.instance;
    requires com.google.guice;

    exports de.evoal.core.api.board;
    exports de.evoal.core.api.cdi;
    exports de.evoal.core.api.ea.codec;
    exports de.evoal.core.api.ea.constraints.model;
    exports de.evoal.core.api.ea.constraints.strategies;
    exports de.evoal.core.api.ea.constraints.calculation;
    exports de.evoal.core.api.ea.constraints.strategies.fitness;
    exports de.evoal.core.api.ea.correlations;
    exports de.evoal.core.api.ea.fitness;
    exports de.evoal.core.api.ea.fitness.comparator;
    exports de.evoal.core.api.ea.initial;
    exports de.evoal.core.api.properties;
    exports de.evoal.core.api.properties.info;
    exports de.evoal.core.api.properties.io;
    exports de.evoal.core.api.properties.stream;
    exports de.evoal.core.api.search;
    exports de.evoal.core.api.statistics;
    exports de.evoal.core.api.utils;

    opens de.evoal.core.api.board to weld.core.impl;
    opens de.evoal.core.api.cdi to weld.core.impl;
    opens de.evoal.core.api.ea to weld.core.impl;
    opens de.evoal.core.api.ea.constraints to weld.core.impl;
    opens de.evoal.core.api.ea.constraints.model to weld.core.impl;
    opens de.evoal.core.api.ea.constraints.strategies.fitness to weld.core.impl;
    opens de.evoal.core.api.ea.fitness to weld.core.impl;
    opens de.evoal.core.api.properties to weld.core.impl;
    opens de.evoal.core.api.properties.io to weld.core.impl;
    opens de.evoal.core.api.properties.stream to weld.core.impl;
    opens de.evoal.core.api.statistics to weld.core.impl;
    opens de.evoal.core.api.utils to weld.core.impl;

    opens de.evoal.core.main.ea.alterer to weld.core.impl;
    opens de.evoal.core.main.ea.alterer.mutator to weld.core.impl;
    opens de.evoal.core.main.ea.codec to weld.core.impl;
    opens de.evoal.core.main.ea.codec.chromosome to weld.core.impl;
    opens de.evoal.core.main.ea.comparator to weld.core.impl;
    opens de.evoal.core.main.ea.constraints.deviation to weld.core.impl;
    opens de.evoal.core.main.ea.constraints.constraint to weld.core.impl;
    opens de.evoal.core.main.ea.constraints.constraint.strategies.calculations to weld.core.impl;
    opens de.evoal.core.main.ea.constraints.constraint.strategies.constraint to weld.core.impl;
    opens de.evoal.core.main.ea.constraints.constraint.strategies.fitness to weld.core.impl;
    opens de.evoal.core.main.ea.constraints.correlation to weld.core.impl;
    opens de.evoal.core.main.ea.fitness to weld.core.impl;
    opens de.evoal.core.main.ea.initial to weld.core.impl;
    opens de.evoal.core.main.ea.producer to weld.core.impl;
    opens de.evoal.core.main.producer to weld.core.impl;
    opens de.evoal.core.main.search to weld.core.impl;
    opens de.evoal.core.main.statistics to weld.core.impl;
    opens de.evoal.core.main.statistics.fitness to weld.core.impl;
    opens de.evoal.core.main.statistics.individuals to weld.core.impl;
    opens de.evoal.core.main.statistics.nop to weld.core.impl;
    opens de.evoal.core.main.statistics.writer.csv to weld.core.impl;
    opens de.evoal.core.api.ea.correlations to weld.core.impl;
    opens de.evoal.core.api.ea.constraints.calculation to weld.core.impl;
    opens de.evoal.core.api.properties.info to weld.core.impl;
    opens de.evoal.core.api.ea.constraints.strategies to weld.core.impl;
    opens de.evoal.core.main.properties to weld.core.impl;
    opens de.evoal.core.main.ea.search to weld.core.impl;
}
