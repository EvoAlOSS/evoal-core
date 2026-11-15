/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.evoal.models.v202704.optimisation.optimisationPackage
 * @generated
 */
public interface optimisationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	optimisationFactory eINSTANCE = de.evoal.models.v202704.optimisation.impl.optimisationFactoryImpl.init();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	optimisationPackage getoptimisationPackage();

} //optimisationFactory
