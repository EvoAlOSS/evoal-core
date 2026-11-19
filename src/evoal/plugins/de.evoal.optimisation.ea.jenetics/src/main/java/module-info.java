module de.evoal.optimisation.ea {
    requires jakarta.cdi;
    requires jakarta.inject;

    requires lombok;

    requires org.slf4j;

    requires decimal4j;
    requires commons.math3;

    requires io.jenetics.ext;
    requires io.jenetics.prog;

    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore;

    requires de.evoal.languages.model.dl;
    requires de.evoal.languages.model.ddl;
    requires de.evoal.languages.model.base;
    requires de.evoal.languages.model.ol;

    requires de.evoal.core.main;
    requires de.evoal.optimisation.api;

    exports de.evoal.optimisation.ea.api.alterer;
    exports de.evoal.optimisation.ea.api.cdi;
    exports de.evoal.optimisation.ea.api.codec.model;
    exports de.evoal.optimisation.ea.api.codec.program;
    exports de.evoal.optimisation.ea.api.codec;
    exports de.evoal.optimisation.ea.api.initial;
    exports de.evoal.optimisation.ea.api.operators;
    exports de.evoal.optimisation.ea.main.fitness;

    opens de.evoal.optimisation.ea;
    opens de.evoal.optimisation.ea.main.alterer to weld.core.impl;
    opens de.evoal.optimisation.ea.main.alterer.model to weld.core.impl;
    opens de.evoal.optimisation.ea.main.alterer.mutator to weld.core.impl;
    opens de.evoal.optimisation.ea.main.codec to weld.core.impl;
    opens de.evoal.optimisation.ea.main.codec.model to weld.core.impl;
    opens de.evoal.optimisation.ea.main.codec.vector to weld.core.impl;
    opens de.evoal.optimisation.ea.main.codec.vector.chromosome to weld.core.impl;
    opens de.evoal.optimisation.ea.main.codec.program to weld.core.impl;
    opens de.evoal.optimisation.ea.main.codec.program.operations to weld.core.impl;
    opens de.evoal.optimisation.ea.main.codec.program.validators to weld.core.impl;
    opens de.evoal.optimisation.ea.api.alterer to weld.core.impl;
    opens de.evoal.optimisation.ea.api.codec to weld.core.impl;
    opens de.evoal.optimisation.ea.api.operators to weld.core.impl;
    opens de.evoal.optimisation.ea.main.statistics to weld.core.impl;
    opens de.evoal.optimisation.ea.main.selector to weld.core.impl;
    opens de.evoal.optimisation.ea.main.search to weld.core.impl;
    opens de.evoal.optimisation.ea.main.producer to weld.core.impl;
    opens de.evoal.optimisation.ea.main.initial to weld.core.impl;
    opens de.evoal.optimisation.ea.main.fitness to weld.core.impl;
    opens de.evoal.optimisation.ea.main.fitness.gof to weld.core.impl;
    opens de.evoal.optimisation.ea.main.constraint to weld.core.impl;
    opens de.evoal.optimisation.ea.main.comparator to weld.core.impl;
}
