/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.evoal.languages.model.ol.OLPackage
 * @generated
 */
public interface OLFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OLFactory eINSTANCE = de.evoal.languages.model.ol.impl.OLFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Optimisation Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Optimisation Model</em>'.
	 * @generated
	 */
	OptimisationModel createOptimisationModel();

	/**
	 * Returns a new object of class '<em>Use</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Use</em>'.
	 * @generated
	 */
	Use createUse();

	/**
	 * Returns a new object of class '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint</em>'.
	 * @generated
	 */
	Constraint createConstraint();

	/**
	 * Returns a new object of class '<em>Constraint Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint Statement</em>'.
	 * @generated
	 */
	ConstraintStatement createConstraintStatement();

	/**
	 * Returns a new object of class '<em>Function Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Name</em>'.
	 * @generated
	 */
	FunctionName createFunctionName();

	/**
	 * Returns a new object of class '<em>Data Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Reference</em>'.
	 * @generated
	 */
	DataReference createDataReference();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OLPackage getOLPackage();

} //OLFactory
