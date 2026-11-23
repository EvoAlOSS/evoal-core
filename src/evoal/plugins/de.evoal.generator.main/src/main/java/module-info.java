module de.evoal.generator.main {
    requires jakarta.inject;
    requires jakarta.cdi;

    requires com.google.common;
    requires com.google.guice;

    requires static lombok;

    requires org.slf4j;

    requires commons.math3;
    requires org.apache.commons.csv;
    requires freemarker;

    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore;
    requires org.eclipse.xtext;

    requires de.evoal.languages.model.base;
    requires de.evoal.languages.model.ddl;
    requires de.evoal.languages.model.dl;
    requires de.evoal.languages.models;
    requires de.evoal.languages.model.interpreter;

    requires de.evoal.languages.model.ddl.dsl;
    requires de.evoal.languages.model.dl.dsl;
    requires de.evoal.languages.model.base.dsl;
    requires de.evoal.languages.model.generator.dsl;

    requires de.evoal.languages.model.utils;

    requires de.evoal.core.main;
    requires de.evoal.optimisation.api;
    requires de.evoal.languages.model.ol;

    exports de.evoal.pipeline.api.board;
    exports de.evoal.pipeline.api.cdi;
    exports de.evoal.pipeline.api.distribution;
    exports de.evoal.pipeline.api.executor;
    exports de.evoal.pipeline.api.model;
    exports de.evoal.pipeline.api.sequence;
    exports de.evoal.pipeline.api.values;
    exports de.evoal.pipeline.impl.internal to de.evoal.surrogate.api;

    opens de.evoal.pipeline;
    opens de.evoal.pipeline.api.board to weld.core.impl;
    opens de.evoal.pipeline.api.cdi to weld.core.impl;
    opens de.evoal.pipeline.api.distribution to weld.core.impl;
    opens de.evoal.pipeline.api.model to weld.core.impl;
    opens de.evoal.pipeline.api.sequence to weld.core.impl;
    opens de.evoal.pipeline.impl to weld.core.impl;
    opens de.evoal.pipeline.impl.components.benchmarks to weld.core.impl;
    opens de.evoal.pipeline.impl.components.io to weld.core.impl;
    opens de.evoal.pipeline.impl.components.functions to weld.core.impl;
    opens de.evoal.pipeline.impl.components.misc to weld.core.impl;
    opens de.evoal.pipeline.impl.components.distributions to weld.core.impl;
    opens de.evoal.pipeline.impl.internal to weld.core.impl;
    opens de.evoal.pipeline.impl.optimisation to weld.core.impl;
    opens de.evoal.pipeline.impl.components.sequences to weld.core.impl;
    opens de.evoal.pipeline.impl.components.statistics to weld.core.impl;
}
