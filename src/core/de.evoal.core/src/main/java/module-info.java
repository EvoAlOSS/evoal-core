module de.evoal.core {
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

    requires io.jenetics.base;
    requires io.jenetics.ext;
    requires commons.math3;
    requires commons.csv;
    requires smile.math;

    requires decimal4j;
    requires guice;

    requires com.fasterxml.jackson.databind;

    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore;
    requires org.eclipse.xtext;

    requires de.evoal.languages.model.ddl;
    requires de.evoal.languages.model.dl.dsl;
    requires de.evoal.languages.model.dl;
    requires de.evoal.languages.model.eal;
    requires de.evoal.languages.model.eal.dsl;
    requires de.evoal.languages.model.el;
    requires de.evoal.languages.model.el.dsl;
    requires de.evoal.languages.model.instance;

    exports de.evoal.core.api.board;
    exports de.evoal.core.api.cdi;
    exports de.evoal.core.api.ea.codec;
    exports de.evoal.core.api.ea.constraints.model;
    exports de.evoal.core.api.ea.constraints.strategies;
    exports de.evoal.core.api.ea.constraints.strategies.fitness;
    exports de.evoal.core.api.ea.fitness;
    exports de.evoal.core.api.ea.fitness.type;
    exports de.evoal.core.api.properties;
    exports de.evoal.core.api.properties.io;
    exports de.evoal.core.api.properties.stream;
    exports de.evoal.core.api.statistics;
    exports de.evoal.core.api.utils;

//    opens de.evoal.core.api to weld.core.impl;
    opens de.evoal.core.api.board to weld.core.impl;
    opens de.evoal.core.api.cdi to weld.core.impl;
    opens de.evoal.core.api.ea to weld.core.impl;
    opens de.evoal.core.api.ea.codec to weld.core.impl;
    opens de.evoal.core.api.ea.constraints to weld.core.impl;
    opens de.evoal.core.api.ea.fitness to weld.core.impl;
    opens de.evoal.core.api.properties to weld.core.impl;
    opens de.evoal.core.api.properties.io to weld.core.impl;
    opens de.evoal.core.api.properties.stream to weld.core.impl;
    opens de.evoal.core.api.statistics to weld.core.impl;
    opens de.evoal.core.api.utils to weld.core.impl;
    opens de.evoal.core.main.producer to weld.core.impl;
/*
    opens de.evoal.core.main.ddl.correlation to weld.core.impl;
    opens de.evoal.core.main.ddl.constraint to weld.core.impl;
    opens de.evoal.core.main.ddl.constraint.strategies to weld.core.impl;
    opens de.evoal.core.main.ddl.constraint.strategies.calculations to weld.core.impl;
    opens de.evoal.core.main.ddl.constraint.strategies.constraint to weld.core.impl;
    opens de.evoal.core.main.ddl.constraint.strategies.fitness to weld.core.impl;
    opens de.evoal.core.main.ddl.deviation to weld.core.impl;
    opens de.evoal.core.main.ea.alterer to weld.core.impl;
    opens de.evoal.core.main.ea.alterer.mutator to weld.core.impl;
    opens de.evoal.core.main.search to weld.core.impl;
    opens de.evoal.core.main.statistics to weld.core.impl;
    opens de.evoal.core.main.statistics.constraint to weld.core.impl;
    opens de.evoal.core.main.statistics.fitness to weld.core.impl;
    opens de.evoal.core.main.statistics.individuals to weld.core.impl;
    opens de.evoal.core.main.statistics.nop to weld.core.impl;
    opens de.evoal.core.main.statistics.rangeCorrelated to weld.core.impl;
    opens de.evoal.core.main.statistics.writer.csv to weld.core.impl;
*/
}
