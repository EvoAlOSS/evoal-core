/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see de.evoal.models.v202704.optimisation.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://evoal.de/v202704/models/optimisation/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "opt";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = de.evoal.models.v202704.optimisation.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.model.impl.OptimisationModuleImpl <em>Optimisation Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.model.impl.OptimisationModuleImpl
	 * @see de.evoal.models.v202704.optimisation.model.impl.ModelPackageImpl#getOptimisationModule()
	 * @generated
	 */
	int OPTIMISATION_MODULE = 0;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_MODULE__ALGORITHM = 0;

	/**
	 * The feature id for the '<em><b>Problem</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_MODULE__PROBLEM = 1;

	/**
	 * The number of structural features of the '<em>Optimisation Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_MODULE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.model.impl.ProblemImpl <em>Problem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.model.impl.ProblemImpl
	 * @see de.evoal.models.v202704.optimisation.model.impl.ModelPackageImpl#getProblem()
	 * @generated
	 */
	int PROBLEM = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Optimisation Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__OPTIMISATION_FUNCTION = 1;

	/**
	 * The feature id for the '<em><b>Optimisation Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__OPTIMISATION_SPACE = 2;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__GOALS = 3;

	/**
	 * The feature id for the '<em><b>Search Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__SEARCH_SPACE = 4;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__DOCUMENTATION = 5;

	/**
	 * The number of structural features of the '<em>Problem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.model.impl.OptimisationGoalImpl <em>Optimisation Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.model.impl.OptimisationGoalImpl
	 * @see de.evoal.models.v202704.optimisation.model.impl.ModelPackageImpl#getOptimisationGoal()
	 * @generated
	 */
	int OPTIMISATION_GOAL = 2;

	/**
	 * The feature id for the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_GOAL__DATA = 0;

	/**
	 * The number of structural features of the '<em>Optimisation Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_GOAL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.model.impl.MaximiseGoalImpl <em>Maximise Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.model.impl.MaximiseGoalImpl
	 * @see de.evoal.models.v202704.optimisation.model.impl.ModelPackageImpl#getMaximiseGoal()
	 * @generated
	 */
	int MAXIMISE_GOAL = 3;

	/**
	 * The feature id for the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAXIMISE_GOAL__DATA = OPTIMISATION_GOAL__DATA;

	/**
	 * The number of structural features of the '<em>Maximise Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAXIMISE_GOAL_FEATURE_COUNT = OPTIMISATION_GOAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.model.impl.MinimiseGoalImpl <em>Minimise Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.model.impl.MinimiseGoalImpl
	 * @see de.evoal.models.v202704.optimisation.model.impl.ModelPackageImpl#getMinimiseGoal()
	 * @generated
	 */
	int MINIMISE_GOAL = 4;

	/**
	 * The feature id for the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINIMISE_GOAL__DATA = OPTIMISATION_GOAL__DATA;

	/**
	 * The number of structural features of the '<em>Minimise Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINIMISE_GOAL_FEATURE_COUNT = OPTIMISATION_GOAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.model.impl.TargetGoalImpl <em>Target Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.model.impl.TargetGoalImpl
	 * @see de.evoal.models.v202704.optimisation.model.impl.ModelPackageImpl#getTargetGoal()
	 * @generated
	 */
	int TARGET_GOAL = 5;

	/**
	 * The feature id for the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_GOAL__DATA = OPTIMISATION_GOAL__DATA;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_GOAL__VALUE = OPTIMISATION_GOAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Target Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_GOAL_FEATURE_COUNT = OPTIMISATION_GOAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.model.Direction <em>Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.model.Direction
	 * @see de.evoal.models.v202704.optimisation.model.impl.ModelPackageImpl#getDirection()
	 * @generated
	 */
	int DIRECTION = 6;


	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.model.OptimisationModule <em>Optimisation Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optimisation Module</em>'.
	 * @see de.evoal.models.v202704.optimisation.model.OptimisationModule
	 * @generated
	 */
	EClass getOptimisationModule();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.models.v202704.optimisation.model.OptimisationModule#getAlgorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Algorithm</em>'.
	 * @see de.evoal.models.v202704.optimisation.model.OptimisationModule#getAlgorithm()
	 * @see #getOptimisationModule()
	 * @generated
	 */
	EReference getOptimisationModule_Algorithm();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.models.v202704.optimisation.model.OptimisationModule#getProblem <em>Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Problem</em>'.
	 * @see de.evoal.models.v202704.optimisation.model.OptimisationModule#getProblem()
	 * @see #getOptimisationModule()
	 * @generated
	 */
	EReference getOptimisationModule_Problem();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.model.Problem <em>Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Problem</em>'.
	 * @see de.evoal.models.v202704.optimisation.model.Problem
	 * @generated
	 */
	EClass getProblem();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.models.v202704.optimisation.model.Problem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.models.v202704.optimisation.model.Problem#getName()
	 * @see #getProblem()
	 * @generated
	 */
	EAttribute getProblem_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.models.v202704.optimisation.model.Problem#getOptimisationFunction <em>Optimisation Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Optimisation Function</em>'.
	 * @see de.evoal.models.v202704.optimisation.model.Problem#getOptimisationFunction()
	 * @see #getProblem()
	 * @generated
	 */
	EReference getProblem_OptimisationFunction();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.models.v202704.optimisation.model.Problem#getOptimisationSpace <em>Optimisation Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Optimisation Space</em>'.
	 * @see de.evoal.models.v202704.optimisation.model.Problem#getOptimisationSpace()
	 * @see #getProblem()
	 * @generated
	 */
	EReference getProblem_OptimisationSpace();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.models.v202704.optimisation.model.Problem#getGoals <em>Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Goals</em>'.
	 * @see de.evoal.models.v202704.optimisation.model.Problem#getGoals()
	 * @see #getProblem()
	 * @generated
	 */
	EReference getProblem_Goals();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.models.v202704.optimisation.model.Problem#getSearchSpace <em>Search Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Search Space</em>'.
	 * @see de.evoal.models.v202704.optimisation.model.Problem#getSearchSpace()
	 * @see #getProblem()
	 * @generated
	 */
	EReference getProblem_SearchSpace();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.models.v202704.optimisation.model.Problem#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Documentation</em>'.
	 * @see de.evoal.models.v202704.optimisation.model.Problem#getDocumentation()
	 * @see #getProblem()
	 * @generated
	 */
	EReference getProblem_Documentation();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.model.OptimisationGoal <em>Optimisation Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optimisation Goal</em>'.
	 * @see de.evoal.models.v202704.optimisation.model.OptimisationGoal
	 * @generated
	 */
	EClass getOptimisationGoal();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.models.v202704.optimisation.model.OptimisationGoal#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data</em>'.
	 * @see de.evoal.models.v202704.optimisation.model.OptimisationGoal#getData()
	 * @see #getOptimisationGoal()
	 * @generated
	 */
	EReference getOptimisationGoal_Data();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.model.MaximiseGoal <em>Maximise Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Maximise Goal</em>'.
	 * @see de.evoal.models.v202704.optimisation.model.MaximiseGoal
	 * @generated
	 */
	EClass getMaximiseGoal();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.model.MinimiseGoal <em>Minimise Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Minimise Goal</em>'.
	 * @see de.evoal.models.v202704.optimisation.model.MinimiseGoal
	 * @generated
	 */
	EClass getMinimiseGoal();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.model.TargetGoal <em>Target Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Goal</em>'.
	 * @see de.evoal.models.v202704.optimisation.model.TargetGoal
	 * @generated
	 */
	EClass getTargetGoal();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.models.v202704.optimisation.model.TargetGoal#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.evoal.models.v202704.optimisation.model.TargetGoal#getValue()
	 * @see #getTargetGoal()
	 * @generated
	 */
	EAttribute getTargetGoal_Value();

	/**
	 * Returns the meta object for enum '{@link de.evoal.models.v202704.optimisation.model.Direction <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Direction</em>'.
	 * @see de.evoal.models.v202704.optimisation.model.Direction
	 * @generated
	 */
	EEnum getDirection();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

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
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.model.impl.OptimisationModuleImpl <em>Optimisation Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.model.impl.OptimisationModuleImpl
		 * @see de.evoal.models.v202704.optimisation.model.impl.ModelPackageImpl#getOptimisationModule()
		 * @generated
		 */
		EClass OPTIMISATION_MODULE = eINSTANCE.getOptimisationModule();

		/**
		 * The meta object literal for the '<em><b>Algorithm</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMISATION_MODULE__ALGORITHM = eINSTANCE.getOptimisationModule_Algorithm();

		/**
		 * The meta object literal for the '<em><b>Problem</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMISATION_MODULE__PROBLEM = eINSTANCE.getOptimisationModule_Problem();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.model.impl.ProblemImpl <em>Problem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.model.impl.ProblemImpl
		 * @see de.evoal.models.v202704.optimisation.model.impl.ModelPackageImpl#getProblem()
		 * @generated
		 */
		EClass PROBLEM = eINSTANCE.getProblem();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM__NAME = eINSTANCE.getProblem_Name();

		/**
		 * The meta object literal for the '<em><b>Optimisation Function</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM__OPTIMISATION_FUNCTION = eINSTANCE.getProblem_OptimisationFunction();

		/**
		 * The meta object literal for the '<em><b>Optimisation Space</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM__OPTIMISATION_SPACE = eINSTANCE.getProblem_OptimisationSpace();

		/**
		 * The meta object literal for the '<em><b>Goals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM__GOALS = eINSTANCE.getProblem_Goals();

		/**
		 * The meta object literal for the '<em><b>Search Space</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM__SEARCH_SPACE = eINSTANCE.getProblem_SearchSpace();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM__DOCUMENTATION = eINSTANCE.getProblem_Documentation();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.model.impl.OptimisationGoalImpl <em>Optimisation Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.model.impl.OptimisationGoalImpl
		 * @see de.evoal.models.v202704.optimisation.model.impl.ModelPackageImpl#getOptimisationGoal()
		 * @generated
		 */
		EClass OPTIMISATION_GOAL = eINSTANCE.getOptimisationGoal();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMISATION_GOAL__DATA = eINSTANCE.getOptimisationGoal_Data();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.model.impl.MaximiseGoalImpl <em>Maximise Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.model.impl.MaximiseGoalImpl
		 * @see de.evoal.models.v202704.optimisation.model.impl.ModelPackageImpl#getMaximiseGoal()
		 * @generated
		 */
		EClass MAXIMISE_GOAL = eINSTANCE.getMaximiseGoal();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.model.impl.MinimiseGoalImpl <em>Minimise Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.model.impl.MinimiseGoalImpl
		 * @see de.evoal.models.v202704.optimisation.model.impl.ModelPackageImpl#getMinimiseGoal()
		 * @generated
		 */
		EClass MINIMISE_GOAL = eINSTANCE.getMinimiseGoal();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.model.impl.TargetGoalImpl <em>Target Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.model.impl.TargetGoalImpl
		 * @see de.evoal.models.v202704.optimisation.model.impl.ModelPackageImpl#getTargetGoal()
		 * @generated
		 */
		EClass TARGET_GOAL = eINSTANCE.getTargetGoal();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET_GOAL__VALUE = eINSTANCE.getTargetGoal_Value();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.model.Direction <em>Direction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.model.Direction
		 * @see de.evoal.models.v202704.optimisation.model.impl.ModelPackageImpl#getDirection()
		 * @generated
		 */
		EEnum DIRECTION = eINSTANCE.getDirection();

	}

} //ModelPackage
