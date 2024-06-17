module de.evoal.core.ea {
    requires jakarta.enterprise.cdi.api;
    requires jakarta.inject.api;

    requires lombok;

    requires org.slf4j;

    requires commons.math3;
    requires io.jenetics.ext;
    requires io.jenetics.prog;

    requires org.eclipse.emf.common;

    requires de.evoal.languages.model.dl;
    requires de.evoal.languages.model.ddl;
    requires de.evoal.languages.model.base;
    requires de.evoal.languages.model.instance;

    requires de.evoal.core.main;
    requires java.annotation;
    requires decimal4j;
    requires de.evoal.languages.model.ol;
    requires org.eclipse.emf.ecore;

    exports de.evoal.core.ea.api.alterer;
    exports de.evoal.core.ea.api.cdi;
    exports de.evoal.core.ea.api.codec;
    exports de.evoal.core.ea.api.codec.model;
    exports de.evoal.core.ea.api.codec.program;
    exports de.evoal.core.ea.api.initial;
    exports de.evoal.core.ea.api.operators;

    opens de.evoal.core.ea;

    opens de.evoal.core.ea.api.codec to weld.core.impl;
    opens de.evoal.core.ea.main.alterer to weld.core.impl;
    opens de.evoal.core.ea.main.alterer.model to weld.core.impl;
    opens de.evoal.core.ea.main.alterer.model.crossover to weld.core.impl;
    opens de.evoal.core.ea.main.alterer.model.mutator to weld.core.impl;
    opens de.evoal.core.ea.main.alterer.mutator to weld.core.impl;
    opens de.evoal.core.ea.main.codec to weld.core.impl;
    opens de.evoal.core.ea.main.codec.model to weld.core.impl;
    opens de.evoal.core.ea.main.codec.vector to weld.core.impl;
    opens de.evoal.core.ea.main.codec.vector.chromosome to weld.core.impl;
    opens de.evoal.core.ea.main.codec.program to weld.core.impl;
    opens de.evoal.core.ea.main.codec.program.operations to weld.core.impl;
    opens de.evoal.core.ea.main.codec.program.validators to weld.core.impl;
    opens de.evoal.core.ea.main.comparator to weld.core.impl;
    opens de.evoal.core.ea.main.constraint to weld.core.impl;
    opens de.evoal.core.ea.main.fitness to weld.core.impl;
    opens de.evoal.core.ea.main.initial to weld.core.impl;
    opens de.evoal.core.ea.main.producer to weld.core.impl;
    opens de.evoal.core.ea.main.selector to weld.core.impl;
    opens de.evoal.core.ea.main.search to weld.core.impl;
    opens de.evoal.core.ea.main.statistics to weld.core.impl;
    opens de.evoal.core.ea.api.operators to weld.core.impl;
    opens de.evoal.core.ea.main.fitness.gof to weld.core.impl;
    opens de.evoal.core.ea.api.alterer to weld.core.impl;

}
