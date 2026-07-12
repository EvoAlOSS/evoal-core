/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.languages.model.optimization.execution;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * *
 * Package containing interfaces for a common execution of all algorithms.
 * 
 * <!-- end-model-doc -->
 * @see de.evoal.languages.model.optimization.execution.ExecutionFactory
 * @model kind="package"
 * @generated
 */
public interface ExecutionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "execution";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.evoal.de/languages/execution/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "exec";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionPackage eINSTANCE = de.evoal.languages.model.optimization.execution.impl.ExecutionPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.optimization.execution.impl.TerminationCriterionImpl <em>Termination Criterion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.optimization.execution.impl.TerminationCriterionImpl
	 * @see de.evoal.languages.model.optimization.execution.impl.ExecutionPackageImpl#getTerminationCriterion()
	 * @generated
	 */
	int TERMINATION_CRITERION = 0;

	/**
	 * The number of structural features of the '<em>Termination Criterion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATION_CRITERION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.optimization.execution.impl.SelectionImpl <em>Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.optimization.execution.impl.SelectionImpl
	 * @see de.evoal.languages.model.optimization.execution.impl.ExecutionPackageImpl#getSelection()
	 * @generated
	 */
	int SELECTION = 1;

	/**
	 * The number of structural features of the '<em>Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.optimization.execution.TerminationCriterion <em>Termination Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Termination Criterion</em>'.
	 * @see de.evoal.languages.model.optimization.execution.TerminationCriterion
	 * @generated
	 */
	EClass getTerminationCriterion();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.optimization.execution.Selection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection</em>'.
	 * @see de.evoal.languages.model.optimization.execution.Selection
	 * @generated
	 */
	EClass getSelection();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExecutionFactory getExecutionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.optimization.execution.impl.TerminationCriterionImpl <em>Termination Criterion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.optimization.execution.impl.TerminationCriterionImpl
		 * @see de.evoal.languages.model.optimization.execution.impl.ExecutionPackageImpl#getTerminationCriterion()
		 * @generated
		 */
		EClass TERMINATION_CRITERION = eINSTANCE.getTerminationCriterion();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.optimization.execution.impl.SelectionImpl <em>Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.optimization.execution.impl.SelectionImpl
		 * @see de.evoal.languages.model.optimization.execution.impl.ExecutionPackageImpl#getSelection()
		 * @generated
		 */
		EClass SELECTION = eINSTANCE.getSelection();

	}

} //ExecutionPackage
