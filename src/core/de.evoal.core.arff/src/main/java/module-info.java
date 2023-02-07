module de.evoal.core.arff {
    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;

    requires lombok;
    requires org.slf4j;

    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore;
    requires org.eclipse.xtext;

    requires weka.stable;

    requires de.evoal.core.main;
    requires de.evoal.languages.model.ddl;
    requires de.evoal.languages.model.ddl.dsl;

    opens de.evoal.core.arff.io to weld.core.impl;
    opens de.evoal.core.arff.main to weld.core.impl;
}