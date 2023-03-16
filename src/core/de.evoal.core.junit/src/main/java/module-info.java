module de.evoal.core.junit {
    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;

    requires lombok;

    requires org.slf4j;

    requires com.google.guice;
    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore;
    requires org.eclipse.xtext;

    requires de.evoal.languages.model.ddl;
    requires de.evoal.languages.model.dl;
    requires de.evoal.languages.model.generator;
    requires de.evoal.languages.model.mll;
    requires de.evoal.languages.model.ol;

    requires de.evoal.languages.model.ddl.dsl;
    requires de.evoal.languages.model.dl.dsl;
    requires de.evoal.languages.model.generator.dsl;
    requires de.evoal.languages.model.mll.dsl;
    requires de.evoal.languages.model.ol.dsl;
    requires de.evoal.languages.model.utils;

    exports de.evoal.core.junit.dsl;
    exports de.evoal.core.junit.resources;

    provides de.evoal.languages.model.utils.builtin.BuiltinProvider with de.evoal.core.junit.dsl.NoOpBuiltinProvider;
}