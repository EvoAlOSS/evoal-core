module de.evoal.core.ea {
    requires jakarta.enterprise.cdi.api;
    requires jakarta.inject.api;

    requires lombok;

    requires org.slf4j;

    requires commons.math3;
    requires io.jenetics.ext;

    requires org.eclipse.emf.common;

    requires de.evoal.languages.model.ddl;
    requires de.evoal.languages.model.base;
    requires de.evoal.languages.model.instance;

    requires de.evoal.core.main;
    requires java.annotation;
    requires decimal4j;
    requires de.evoal.languages.model.ol;
    requires org.eclipse.emf.ecore;

    exports de.evoal.core.ea.api.cdi;
    exports de.evoal.core.ea.api.codec;
    exports de.evoal.core.ea.api.initial;
    exports de.evoal.core.ea.api.selector;

    opens de.evoal.core.ea;

    opens de.evoal.core.ea.main.alterer to weld.core.impl;
    opens de.evoal.core.ea.main.alterer.mutator to weld.core.impl;
    opens de.evoal.core.ea.main.codec to weld.core.impl;
    opens de.evoal.core.ea.main.codec.chromosome to weld.core.impl;
    opens de.evoal.core.ea.main.comparator to weld.core.impl;
    opens de.evoal.core.ea.main.constraint to weld.core.impl;
    opens de.evoal.core.ea.main.fitness to weld.core.impl;
    opens de.evoal.core.ea.main.initial to weld.core.impl;
    opens de.evoal.core.ea.main.selector to weld.core.impl;
    opens de.evoal.core.ea.main.search to weld.core.impl;
    opens de.evoal.core.ea.main.statistics to weld.core.impl;
    opens de.evoal.core.ea.api.selector to weld.core.impl;
}
