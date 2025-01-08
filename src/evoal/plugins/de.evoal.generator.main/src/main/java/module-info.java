module de.evoal.generator.main {
    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;

    requires com.google.guice;

    requires lombok;

    requires org.slf4j;

    requires commons.math3;

    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore;
    requires org.eclipse.xtext;

    requires de.evoal.languages.model.ddl;
    requires de.evoal.languages.model.dl;
    requires de.evoal.languages.model.base;
    requires de.evoal.languages.model.generator;
    requires de.evoal.languages.model.pipeline;
    requires de.evoal.languages.model.dynamic;
    requires de.evoal.languages.model.instance;

    requires de.evoal.languages.model.ddl.dsl;
    requires de.evoal.languages.model.dl.dsl;
    requires de.evoal.languages.model.base.dsl;
    requires de.evoal.languages.model.generator.dsl;

    requires de.evoal.languages.model.utils;

    requires de.evoal.core.main;
    requires de.evoal.optimisation.api;
    requires com.google.common;

    opens de.evoal.generator;
    opens de.evoal.pipeline;

    opens de.evoal.generator.main;
    opens de.evoal.generator.main.benchmarks;
    opens de.evoal.generator.main.cdi;
    opens de.evoal.generator.main.functions;
    opens de.evoal.generator.main.generators;

    exports de.evoal.generator.api;
    opens de.evoal.generator.api to weld.core.impl;
    opens de.evoal.generator.main.functions.distributions;


    opens de.evoal.pipeline.api.board to weld.core.impl;
    opens de.evoal.pipeline.api.cdi to weld.core.impl;
    opens de.evoal.pipeline.api.distribution to weld.core.impl;

    opens de.evoal.pipeline.impl to weld.core.impl;
    opens de.evoal.pipeline.impl.components.benchmarks to weld.core.impl;
    opens de.evoal.pipeline.impl.components.io to weld.core.impl;
    opens de.evoal.pipeline.impl.components.misc to weld.core.impl;
    opens de.evoal.pipeline.impl.components.distributions to weld.core.impl;
    opens de.evoal.pipeline.impl.internal to weld.core.impl;
}
