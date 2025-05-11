module de.evoal.core.interpreter {
    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;

    requires lombok;
    requires org.slf4j;

    requires com.google.guice;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore;
    requires org.eclipse.xtext;

    requires de.evoal.languages.models;
    requires de.evoal.languages.model.base;
    requires de.evoal.languages.model.dl;

    requires de.evoal.core.main;
    requires de.evoal.languages.model.interpreter;
    exports de.evoal.core.interpreter.api;
    exports de.evoal.core.interpreter.api.cdi;

    opens de.evoal.core.interpreter.api.cdi to weld.cdi.core;
}