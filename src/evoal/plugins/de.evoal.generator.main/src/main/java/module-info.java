module de.evoal.generator.main {
    requires java.base;

    requires lombok;

    requires org.slf4j;

    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;

    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore;
    requires org.eclipse.xtext;

    requires de.evoal.languages.model.ddl;
    requires de.evoal.languages.model.dl;
    requires de.evoal.languages.model.base;
    requires de.evoal.languages.model.generator;
    requires de.evoal.languages.model.instance;

    requires de.evoal.languages.model.ddl.dsl;
    requires de.evoal.languages.model.dl.dsl;
    requires de.evoal.languages.model.base.dsl;
    requires de.evoal.languages.model.generator.dsl;

    requires de.evoal.core.main;
    requires commons.math3;
    requires com.google.guice;
    requires de.evoal.languages.model.utils;

    opens de.evoal.generator;

    opens de.evoal.generator.main;
    opens de.evoal.generator.main.benchmarks;
    opens de.evoal.generator.main.cdi;
    opens de.evoal.generator.main.functions;
    opens de.evoal.generator.main.generators;

    exports de.evoal.generator.api;
    opens de.evoal.generator.api to weld.core.impl;
}
