/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.execution;

import de.evoal.models.v202704.core.CorePackage;

import de.evoal.models.v202704.optimisation.OptimisationPackage;

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
 * @see de.evoal.models.v202704.optimisation.execution.ExecutionFactory
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
	String eNS_URI = "https://evoal.de/v202704/models/optimisation/execution";

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
	ExecutionPackage eINSTANCE = de.evoal.models.v202704.optimisation.execution.impl.ExecutionPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl <em>Optimisation Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl
	 * @see de.evoal.models.v202704.optimisation.execution.impl.ExecutionPackageImpl#getOptimisationFunction()
	 * @generated
	 */
	int OPTIMISATION_FUNCTION = 0;

	/**
	 * The number of structural features of the '<em>Optimisation Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_FUNCTION_FEATURE_COUNT = CorePackage.EVOAL_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.execution.impl.TerminationCriterionImpl <em>Termination Criterion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.execution.impl.TerminationCriterionImpl
	 * @see de.evoal.models.v202704.optimisation.execution.impl.ExecutionPackageImpl#getTerminationCriterion()
	 * @generated
	 */
	int TERMINATION_CRITERION = 1;

	/**
	 * The number of structural features of the '<em>Termination Criterion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATION_CRITERION_FEATURE_COUNT = CorePackage.EVOAL_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.execution.impl.SelectionImpl <em>Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.execution.impl.SelectionImpl
	 * @see de.evoal.models.v202704.optimisation.execution.impl.ExecutionPackageImpl#getSelection()
	 * @generated
	 */
	int SELECTION = 2;

	/**
	 * The number of structural features of the '<em>Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.execution.impl.OptimisationValueImpl <em>Optimisation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.execution.impl.OptimisationValueImpl
	 * @see de.evoal.models.v202704.optimisation.execution.impl.ExecutionPackageImpl#getOptimisationValue()
	 * @generated
	 */
	int OPTIMISATION_VALUE = 3;

	/**
	 * The number of structural features of the '<em>Optimisation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_VALUE_FEATURE_COUNT = OptimisationPackage.COMPARABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.execution.impl.OptimisationValueWithDistanceImpl <em>Optimisation Value With Distance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.execution.impl.OptimisationValueWithDistanceImpl
	 * @see de.evoal.models.v202704.optimisation.execution.impl.ExecutionPackageImpl#getOptimisationValueWithDistance()
	 * @generated
	 */
	int OPTIMISATION_VALUE_WITH_DISTANCE = 4;

	/**
	 * The number of structural features of the '<em>Optimisation Value With Distance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_VALUE_WITH_DISTANCE_FEATURE_COUNT = OPTIMISATION_VALUE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.execution.OptimisationFunction <em>Optimisation Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optimisation Function</em>'.
	 * @see de.evoal.models.v202704.optimisation.execution.OptimisationFunction
	 * @generated
	 */
	EClass getOptimisationFunction();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.execution.TerminationCriterion <em>Termination Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Termination Criterion</em>'.
	 * @see de.evoal.models.v202704.optimisation.execution.TerminationCriterion
	 * @generated
	 */
	EClass getTerminationCriterion();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.execution.Selection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection</em>'.
	 * @see de.evoal.models.v202704.optimisation.execution.Selection
	 * @generated
	 */
	EClass getSelection();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.execution.OptimisationValue <em>Optimisation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optimisation Value</em>'.
	 * @see de.evoal.models.v202704.optimisation.execution.OptimisationValue
	 * @generated
	 */
	EClass getOptimisationValue();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.execution.OptimisationValueWithDistance <em>Optimisation Value With Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optimisation Value With Distance</em>'.
	 * @see de.evoal.models.v202704.optimisation.execution.OptimisationValueWithDistance
	 * @generated
	 */
	EClass getOptimisationValueWithDistance();

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
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl <em>Optimisation Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl
		 * @see de.evoal.models.v202704.optimisation.execution.impl.ExecutionPackageImpl#getOptimisationFunction()
		 * @generated
		 */
		EClass OPTIMISATION_FUNCTION = eINSTANCE.getOptimisationFunction();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.execution.impl.TerminationCriterionImpl <em>Termination Criterion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.execution.impl.TerminationCriterionImpl
		 * @see de.evoal.models.v202704.optimisation.execution.impl.ExecutionPackageImpl#getTerminationCriterion()
		 * @generated
		 */
		EClass TERMINATION_CRITERION = eINSTANCE.getTerminationCriterion();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.execution.impl.SelectionImpl <em>Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.execution.impl.SelectionImpl
		 * @see de.evoal.models.v202704.optimisation.execution.impl.ExecutionPackageImpl#getSelection()
		 * @generated
		 */
		EClass SELECTION = eINSTANCE.getSelection();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.execution.impl.OptimisationValueImpl <em>Optimisation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.execution.impl.OptimisationValueImpl
		 * @see de.evoal.models.v202704.optimisation.execution.impl.ExecutionPackageImpl#getOptimisationValue()
		 * @generated
		 */
		EClass OPTIMISATION_VALUE = eINSTANCE.getOptimisationValue();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.execution.impl.OptimisationValueWithDistanceImpl <em>Optimisation Value With Distance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.execution.impl.OptimisationValueWithDistanceImpl
		 * @see de.evoal.models.v202704.optimisation.execution.impl.ExecutionPackageImpl#getOptimisationValueWithDistance()
		 * @generated
		 */
		EClass OPTIMISATION_VALUE_WITH_DISTANCE = eINSTANCE.getOptimisationValueWithDistance();

	}

} //ExecutionPackage
