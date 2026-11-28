package de.evoal.core.api.ecore.models;

import java.util.Collection;

import org.eclipse.emf.ecore.EPackage;

/**
 * The generated packages of Ecore metamodels that a plugin brings, as a CDI bean of the plugin.
 *   A file named by {@code @EcoreType} whose namespace URI is the one of a generated package is
 *   only checked against the package; the models then consist of the generated classes (see
 *   {@link EcoreModels}).
 */
public interface EcorePackages {
    /**
     * @return The generated packages, e.g. {@code PolicyPackage.eINSTANCE}; their subpackages are
     *   found through them.
     */
    Collection<EPackage> packages();
}
