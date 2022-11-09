open module de.evoal.core.api {
    requires java.base;

    requires jakarta.enterprise.cdi.api;
    requires jakarta.inject.api;
    requires deltaspike.core.api;

    requires lombok;

    requires org.slf4j;

    requires io.jenetics.base;
    requires commons.math3;
    requires smile.math;

    requires com.fasterxml.jackson.databind;

    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore;

    requires de.evoal.languages.model.dl;
    requires de.evoal.languages.model.el;
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
}