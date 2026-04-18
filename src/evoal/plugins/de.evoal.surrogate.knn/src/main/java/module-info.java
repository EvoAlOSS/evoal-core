module de.evoal.surrogate.knn {
    // declare dependencies to evoal
    requires de.evoal.core.main;
    requires de.evoal.surrogate.api;

    // CDI related dependencies
    //requires jakarta.inject.api;
    //requires jakarta.enterprise.cdi.api;

    // logging
    requires org.slf4j;
    requires lombok;

    requires commons.math3;
    requires tools.jackson.core;
    requires tools.jackson.databind;
    requires org.eclipse.emf.ecore;
    requires de.evoal.languages.model.base;
    requires jakarta.cdi;

    // open the package to CDI allowing CDI to create instances using reflection.
    // Additionally, we have to open the folder to allow EvoAl to access the .dl file
    opens de.evoal.surrogate.knn;

    exports de.evoal.surrogate.knn to weld.core.impl;
}