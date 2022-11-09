module de.evoal.core.main {
    requires jakarta.enterprise.cdi.api;
    requires jakarta.inject.api;

    requires java.annotation;
    requires java.base;

    requires lombok;
    requires org.slf4j;

    requires weld.se.core;
    requires deltaspike.cdictrl.api;
    requires deltaspike.cdictrl.weld;
    requires deltaspike.core.api;

    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore;
    requires org.eclipse.xtext;

    requires io.jenetics.base;
    requires commons.math3;
    requires commons.csv;
    requires smile.math;

    requires com.fasterxml.jackson.databind;
    requires io.jenetics.ext;
    requires decimal4j;
    requires guice;

    requires de.evoal.languages.model.dl.dsl;
    requires de.evoal.languages.model.dl;
    requires de.evoal.languages.model.eal;
    requires de.evoal.languages.model.eal.dsl;
    requires de.evoal.languages.model.el;
    requires de.evoal.languages.model.el.dsl;
    requires de.evoal.languages.model.instance;

    requires de.evoal.core.api;
    requires de.evoal.languages.model.ddl;

    opens de.evoal.core.main.cdi.producer to weld.core.impl;
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
}
