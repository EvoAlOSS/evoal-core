module de.evoal.core.main {
    requires java.base;
    requires java.annotation;
    requires com.google.guice;

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

    requires org.fusesource.jansi;

    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore;
    requires org.eclipse.xtext;

    requires de.evoal.languages.model.base;
    requires de.evoal.languages.model.base.dsl;
    requires de.evoal.languages.model.ddl;
    requires de.evoal.languages.model.ddl.dsl;
    requires de.evoal.languages.model.dl;
    requires de.evoal.languages.model.dl.dsl;
    requires de.evoal.languages.models;
    requires de.evoal.languages.model.ol;
    requires de.evoal.languages.model.ol.dsl;
    requires de.evoal.languages.model.interpreter;
    requires de.evoal.languages.model.utils;
    requires commons.math3;
    requires jakarta.ejb.api;
    opens de.evoal.core; // export dl files.

    exports de.evoal.core.api.board;
    exports de.evoal.core.api.cdi;
    exports de.evoal.core.api.dynamic;
    exports de.evoal.core.api.interpreter;
    exports de.evoal.core.api.languages;
    exports de.evoal.core.api.languages.base;
    exports de.evoal.core.api.properties;
    exports de.evoal.core.api.properties.info;
    exports de.evoal.core.api.properties.io;
    exports de.evoal.core.api.properties.stream;

    exports de.evoal.core.api.ecore;
    exports de.evoal.core.api.ecore.info;
    exports de.evoal.core.api.ecore.io;
    exports de.evoal.core.api.ecore.misc;
    exports de.evoal.core.api.ecore.stream;
    exports de.evoal.core.api.utils;
    exports de.evoal.core.api.validation.context;

    opens de.evoal.core.api.board to weld.core.impl;
    opens de.evoal.core.api.cdi to weld.core.impl;
    opens de.evoal.core.api.dynamic to weld.core.impl;
    opens de.evoal.core.api.ecore to weld.core.impl;
    opens de.evoal.core.api.ecore.info to weld.core.impl;
    opens de.evoal.core.api.ecore.io to weld.core.impl;
    opens de.evoal.core.api.ecore.stream to weld.core.impl;
    opens de.evoal.core.api.languages to weld.core.impl;
    opens de.evoal.core.api.properties to weld.core.impl;
    opens de.evoal.core.api.properties.info to weld.core.impl;
    opens de.evoal.core.api.properties.io to weld.core.impl;
    opens de.evoal.core.api.properties.stream to weld.core.impl;
    opens de.evoal.core.api.utils to weld.core.impl;

    opens de.evoal.core.main to weld.core.impl;
    opens de.evoal.core.main.ecore to weld.core.impl;
    opens de.evoal.core.main.language to weld.core.impl;
    opens de.evoal.core.main.properties to weld.core.impl;
    opens de.evoal.core.main.validation to weld.core.impl;
    opens de.evoal.core.api.validation.context to weld.core.impl;
    exports de.evoal.core.main.validation;
    exports de.evoal.core.main.validation.constraints;
    exports de.evoal.core.api.validation.components;
    opens de.evoal.core.api.validation.components to weld.core.impl;
    exports de.evoal.core.api.validation.model;
    opens de.evoal.core.api.validation.model to weld.core.impl;
    opens de.evoal.core.main.validation.constraints to weld.core.impl;
}
