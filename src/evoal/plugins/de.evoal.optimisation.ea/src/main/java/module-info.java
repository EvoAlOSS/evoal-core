module de.evoal.optimisation.ea {
    // declare dependencies to EvoAl
    requires de.evoal.core.main;
    requires de.evoal.languages.models;
    requires de.evoal.languages.model.base;
    requires de.evoal.optimisation.api;

    // CDI related dependencies
    requires jakarta.inject;
    requires jakarta.cdi;

    // logging
    requires org.slf4j;
    requires lombok;
    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore;

    exports de.evoal.optimisation.ea.api.genotype;
    exports de.evoal.optimisation.ea.api.operators;
    exports de.evoal.optimisation.ea.api.replacement;
    exports de.evoal.optimisation.ea.api.selection;
    exports de.evoal.optimisation.ea.main;

    // Opening packages to CDI
    opens de.evoal.optimisation.ea;
    opens de.evoal.optimisation.ea.api.operators to weld.core.impl;
    opens de.evoal.optimisation.ea.api.replacement to weld.core.impl;
    opens de.evoal.optimisation.ea.main to weld.core.impl;
    opens de.evoal.optimisation.ea.main.comparator to weld.core.impl;
    opens de.evoal.optimisation.ea.main.genotype to weld.core.impl;
    opens de.evoal.optimisation.ea.main.operators to weld.core.impl;
    opens de.evoal.optimisation.ea.main.replacement to weld.core.impl;
    opens de.evoal.optimisation.ea.main.selection to weld.core.impl;
}
