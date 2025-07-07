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
	 * Returns a new object of class '<em>Optimisation Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Optimisation Module</em>'.
	 * @generated
	 */
	OptimisationModule createOptimisationModule();

	/**
	 * Returns a new object of class '<em>Problem Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Problem Instance</em>'.
	 * @generated
	 */
	ProblemInstance createProblemInstance();

	/**
	 * Returns a new object of class '<em>Maximise Goal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Maximise Goal</em>'.
	 * @generated
	 */
	MaximiseGoal createMaximiseGoal();

	/**
	 * Returns a new object of class '<em>Minimise Goal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Minimise Goal</em>'.
	 * @generated
	 */
	MinimiseGoal createMinimiseGoal();

	/**
	 * Returns a new object of class '<em>Target Goal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Goal</em>'.
	 * @generated
	 */
	TargetGoal createTargetGoal();

	/**
	 * Returns a new object of class '<em>Algorithm Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Algorithm Instance</em>'.
	 * @generated
	 */
	AlgorithmInstance createAlgorithmInstance();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OLPackage getOLPackage();

} //OLFactory
