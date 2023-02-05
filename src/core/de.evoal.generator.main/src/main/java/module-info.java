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
    requires de.evoal.languages.model.el;
    requires de.evoal.languages.model.generator;
    requires de.evoal.languages.model.instance;

    requires de.evoal.languages.model.ddl.dsl;
    requires de.evoal.languages.model.dl.dsl;
    requires de.evoal.languages.model.el.dsl;
    requires de.evoal.languages.model.generator.dsl;

    requires de.evoal.core;
    requires commons.math3;

    opens de.evoal.generator.main;
    opens de.evoal.generator.main.benchmarks;
    opens de.evoal.generator.main.cdi;
    opens de.evoal.generator.main.functions;
    opens de.evoal.generator.main.generators;

    exports de.evoal.generator.api;
}
