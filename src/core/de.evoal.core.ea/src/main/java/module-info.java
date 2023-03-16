module de.evoal.core.ea {
    exports de.evoal.core.ea.api.codec;
    exports de.evoal.core.ea.api.initial;
    exports de.evoal.core.ea.api.constraints.strategies;
    exports de.evoal.core.ea.api.correlations;
    exports de.evoal.core.ea.api.constraints.calculation;
    exports de.evoal.core.ea.api.constraints.model;
    requires jakarta.enterprise.cdi.api;
    requires jakarta.inject.api;

    requires lombok;

    requires org.slf4j;

    requires commons.math3;
    requires io.jenetics.ext;

    requires org.eclipse.emf.common;

    requires de.evoal.languages.model.ddl;
    requires de.evoal.languages.model.el;
    requires de.evoal.languages.model.instance;

    requires de.evoal.core.main;
    requires java.annotation;
    requires decimal4j;
    requires de.evoal.languages.model.ol;

    opens de.evoal.core.ea.api.correlations to weld.core.impl;
    opens de.evoal.core.ea.api.constraints.model to weld.core.impl;
    opens de.evoal.core.ea.api.constraints.calculation to weld.core.impl;

    opens de.evoal.core.ea.main.alterer to weld.core.impl;
    opens de.evoal.core.ea.main.alterer.mutator to weld.core.impl;
    opens de.evoal.core.ea.main.codec to weld.core.impl;
    opens de.evoal.core.ea.main.codec.chromosome to weld.core.impl;
    opens de.evoal.core.ea.main.comparator to weld.core.impl;
    opens de.evoal.core.ea.main.constraints.constraint to weld.core.impl;
    opens de.evoal.core.ea.main.constraints.constraint.strategies.constraint to weld.core.impl;
    opens de.evoal.core.ea.main.constraints.constraint.strategies.calculations to weld.core.impl;
    opens de.evoal.core.ea.main.constraints.constraint.strategies.fitness to weld.core.impl;
    opens de.evoal.core.ea.main.constraints.correlation to weld.core.impl;
    opens de.evoal.core.ea.main.constraints.deviation to weld.core.impl;
    opens de.evoal.core.ea.main.fitness to weld.core.impl;
    opens de.evoal.core.ea.main.initial to weld.core.impl;
    opens de.evoal.core.ea.main.producer to weld.core.impl;
    opens de.evoal.core.ea.main.search to weld.core.impl;
    opens de.evoal.core.ea.main.statistics to weld.core.impl;
}
