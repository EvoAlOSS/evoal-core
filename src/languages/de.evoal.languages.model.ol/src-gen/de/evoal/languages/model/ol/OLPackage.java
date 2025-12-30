/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol;

import de.evoal.languages.model.base.expressions.ExpressionsPackage;

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
 * @see de.evoal.languages.model.ol.OLFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ddl='platform:/resource/de.evoal.languages.model.ddl/model/model.ecore#/' el='platform:/resource/de.evoal.languages.model.base/model/model.ecore#/' expr='platform:/resource/de.evoal.languages.model.base/model/expressions.ecore#/'"
 * @generated
 */
public interface OLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ol";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.evoal.de/languages/ol/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ol";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OLPackage eINSTANCE = de.evoal.languages.model.ol.impl.OLPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ol.impl.OptimisationModuleImpl <em>Optimisation Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ol.impl.OptimisationModuleImpl
	 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getOptimisationModule()
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
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_MODULE__IMPORTS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_MODULE__NAME = 2;

	/**
	 * The feature id for the '<em><b>Problem</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_MODULE__PROBLEM = 3;

	/**
	 * The number of structural features of the '<em>Optimisation Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_MODULE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ol.impl.ProblemInstanceImpl <em>Problem Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ol.impl.ProblemInstanceImpl
	 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getProblemInstance()
	 * @generated
	 */
	int PROBLEM_INSTANCE = 1;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_INSTANCE__DEFINITION = ExpressionsPackage.INSTANCE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_INSTANCE__ATTRIBUTES = ExpressionsPackage.INSTANCE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_INSTANCE__DOCUMENTATION = ExpressionsPackage.INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_INSTANCE__NAME = ExpressionsPackage.INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Optimisation Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_INSTANCE__OPTIMISATION_FUNCTION = ExpressionsPackage.INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Optimisation Space</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_INSTANCE__OPTIMISATION_SPACE = ExpressionsPackage.INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Search Space</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_INSTANCE__SEARCH_SPACE = ExpressionsPackage.INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Problem Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_INSTANCE_FEATURE_COUNT = ExpressionsPackage.INSTANCE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ol.impl.OptimisationGoalImpl <em>Optimisation Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ol.impl.OptimisationGoalImpl
	 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getOptimisationGoal()
	 * @generated
	 */
	int OPTIMISATION_GOAL = 2;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
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
	 * The meta object id for the '{@link de.evoal.languages.model.ol.impl.MaximiseGoalImpl <em>Maximise Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ol.impl.MaximiseGoalImpl
	 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getMaximiseGoal()
	 * @generated
	 */
	int MAXIMISE_GOAL = 3;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
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
	 * The meta object id for the '{@link de.evoal.languages.model.ol.impl.MinimiseGoalImpl <em>Minimise Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ol.impl.MinimiseGoalImpl
	 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getMinimiseGoal()
	 * @generated
	 */
	int MINIMISE_GOAL = 4;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
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
	 * The meta object id for the '{@link de.evoal.languages.model.ol.impl.TargetGoalImpl <em>Target Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ol.impl.TargetGoalImpl
	 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getTargetGoal()
	 * @generated
	 */
	int TARGET_GOAL = 5;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_GOAL__DATA = OPTIMISATION_GOAL__DATA;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
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
	 * The meta object id for the '{@link de.evoal.languages.model.ol.impl.AlgorithmInstanceImpl <em>Algorithm Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ol.impl.AlgorithmInstanceImpl
	 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getAlgorithmInstance()
	 * @generated
	 */
	int ALGORITHM_INSTANCE = 6;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_INSTANCE__DEFINITION = ExpressionsPackage.INSTANCE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_INSTANCE__ATTRIBUTES = ExpressionsPackage.INSTANCE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Problem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_INSTANCE__PROBLEM = ExpressionsPackage.INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_INSTANCE__DOCUMENTATION = ExpressionsPackage.INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Algorithm Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_INSTANCE_FEATURE_COUNT = ExpressionsPackage.INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ol.Direction <em>Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ol.Direction
	 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getDirection()
	 * @generated
	 */
	int DIRECTION = 7;


	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ol.OptimisationModule <em>Optimisation Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optimisation Module</em>'.
	 * @see de.evoal.languages.model.ol.OptimisationModule
	 * @generated
	 */
	EClass getOptimisationModule();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.ol.OptimisationModule#getAlgorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Algorithm</em>'.
	 * @see de.evoal.languages.model.ol.OptimisationModule#getAlgorithm()
	 * @see #getOptimisationModule()
	 * @generated
	 */
	EReference getOptimisationModule_Algorithm();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ol.OptimisationModule#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see de.evoal.languages.model.ol.OptimisationModule#getImports()
	 * @see #getOptimisationModule()
	 * @generated
	 */
	EReference getOptimisationModule_Imports();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ol.OptimisationModule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.ol.OptimisationModule#getName()
	 * @see #getOptimisationModule()
	 * @generated
	 */
	EAttribute getOptimisationModule_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.ol.OptimisationModule#getProblem <em>Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Problem</em>'.
	 * @see de.evoal.languages.model.ol.OptimisationModule#getProblem()
	 * @see #getOptimisationModule()
	 * @generated
	 */
	EReference getOptimisationModule_Problem();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ol.ProblemInstance <em>Problem Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Problem Instance</em>'.
	 * @see de.evoal.languages.model.ol.ProblemInstance
	 * @generated
	 */
	EClass getProblemInstance();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.ol.ProblemInstance#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Documentation</em>'.
	 * @see de.evoal.languages.model.ol.ProblemInstance#getDocumentation()
	 * @see #getProblemInstance()
	 * @generated
	 */
	EReference getProblemInstance_Documentation();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ol.ProblemInstance#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.ol.ProblemInstance#getName()
	 * @see #getProblemInstance()
	 * @generated
	 */
	EAttribute getProblemInstance_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.ol.ProblemInstance#getOptimisationFunction <em>Optimisation Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Optimisation Function</em>'.
	 * @see de.evoal.languages.model.ol.ProblemInstance#getOptimisationFunction()
	 * @see #getProblemInstance()
	 * @generated
	 */
	EReference getProblemInstance_OptimisationFunction();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ol.ProblemInstance#getOptimisationSpace <em>Optimisation Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Optimisation Space</em>'.
	 * @see de.evoal.languages.model.ol.ProblemInstance#getOptimisationSpace()
	 * @see #getProblemInstance()
	 * @generated
	 */
	EReference getProblemInstance_OptimisationSpace();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ol.ProblemInstance#getSearchSpace <em>Search Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Search Space</em>'.
	 * @see de.evoal.languages.model.ol.ProblemInstance#getSearchSpace()
	 * @see #getProblemInstance()
	 * @generated
	 */
	EReference getProblemInstance_SearchSpace();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ol.OptimisationGoal <em>Optimisation Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optimisation Goal</em>'.
	 * @see de.evoal.languages.model.ol.OptimisationGoal
	 * @generated
	 */
	EClass getOptimisationGoal();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.ol.OptimisationGoal#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see de.evoal.languages.model.ol.OptimisationGoal#getData()
	 * @see #getOptimisationGoal()
	 * @generated
	 */
	EReference getOptimisationGoal_Data();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ol.MaximiseGoal <em>Maximise Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Maximise Goal</em>'.
	 * @see de.evoal.languages.model.ol.MaximiseGoal
	 * @generated
	 */
	EClass getMaximiseGoal();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ol.MinimiseGoal <em>Minimise Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Minimise Goal</em>'.
	 * @see de.evoal.languages.model.ol.MinimiseGoal
	 * @generated
	 */
	EClass getMinimiseGoal();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ol.TargetGoal <em>Target Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Goal</em>'.
	 * @see de.evoal.languages.model.ol.TargetGoal
	 * @generated
	 */
	EClass getTargetGoal();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.ol.TargetGoal#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see de.evoal.languages.model.ol.TargetGoal#getValue()
	 * @see #getTargetGoal()
	 * @generated
	 */
	EReference getTargetGoal_Value();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ol.AlgorithmInstance <em>Algorithm Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Algorithm Instance</em>'.
	 * @see de.evoal.languages.model.ol.AlgorithmInstance
	 * @generated
	 */
	EClass getAlgorithmInstance();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.ol.AlgorithmInstance#getProblem <em>Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Problem</em>'.
	 * @see de.evoal.languages.model.ol.AlgorithmInstance#getProblem()
	 * @see #getAlgorithmInstance()
	 * @generated
	 */
	EReference getAlgorithmInstance_Problem();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.ol.AlgorithmInstance#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Documentation</em>'.
	 * @see de.evoal.languages.model.ol.AlgorithmInstance#getDocumentation()
	 * @see #getAlgorithmInstance()
	 * @generated
	 */
	EReference getAlgorithmInstance_Documentation();

	/**
	 * Returns the meta object for enum '{@link de.evoal.languages.model.ol.Direction <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Direction</em>'.
	 * @see de.evoal.languages.model.ol.Direction
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
	OLFactory getOLFactory();

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
		 * The meta object literal for the '{@link de.evoal.languages.model.ol.impl.OptimisationModuleImpl <em>Optimisation Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ol.impl.OptimisationModuleImpl
		 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getOptimisationModule()
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
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMISATION_MODULE__IMPORTS = eINSTANCE.getOptimisationModule_Imports();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTIMISATION_MODULE__NAME = eINSTANCE.getOptimisationModule_Name();

		/**
		 * The meta object literal for the '<em><b>Problem</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMISATION_MODULE__PROBLEM = eINSTANCE.getOptimisationModule_Problem();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ol.impl.ProblemInstanceImpl <em>Problem Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ol.impl.ProblemInstanceImpl
		 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getProblemInstance()
		 * @generated
		 */
		EClass PROBLEM_INSTANCE = eINSTANCE.getProblemInstance();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM_INSTANCE__DOCUMENTATION = eINSTANCE.getProblemInstance_Documentation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM_INSTANCE__NAME = eINSTANCE.getProblemInstance_Name();

		/**
		 * The meta object literal for the '<em><b>Optimisation Function</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM_INSTANCE__OPTIMISATION_FUNCTION = eINSTANCE.getProblemInstance_OptimisationFunction();

		/**
		 * The meta object literal for the '<em><b>Optimisation Space</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM_INSTANCE__OPTIMISATION_SPACE = eINSTANCE.getProblemInstance_OptimisationSpace();

		/**
		 * The meta object literal for the '<em><b>Search Space</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM_INSTANCE__SEARCH_SPACE = eINSTANCE.getProblemInstance_SearchSpace();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ol.impl.OptimisationGoalImpl <em>Optimisation Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ol.impl.OptimisationGoalImpl
		 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getOptimisationGoal()
		 * @generated
		 */
		EClass OPTIMISATION_GOAL = eINSTANCE.getOptimisationGoal();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMISATION_GOAL__DATA = eINSTANCE.getOptimisationGoal_Data();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ol.impl.MaximiseGoalImpl <em>Maximise Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ol.impl.MaximiseGoalImpl
		 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getMaximiseGoal()
		 * @generated
		 */
		EClass MAXIMISE_GOAL = eINSTANCE.getMaximiseGoal();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ol.impl.MinimiseGoalImpl <em>Minimise Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ol.impl.MinimiseGoalImpl
		 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getMinimiseGoal()
		 * @generated
		 */
		EClass MINIMISE_GOAL = eINSTANCE.getMinimiseGoal();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ol.impl.TargetGoalImpl <em>Target Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ol.impl.TargetGoalImpl
		 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getTargetGoal()
		 * @generated
		 */
		EClass TARGET_GOAL = eINSTANCE.getTargetGoal();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_GOAL__VALUE = eINSTANCE.getTargetGoal_Value();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ol.impl.AlgorithmInstanceImpl <em>Algorithm Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ol.impl.AlgorithmInstanceImpl
		 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getAlgorithmInstance()
		 * @generated
		 */
		EClass ALGORITHM_INSTANCE = eINSTANCE.getAlgorithmInstance();

		/**
		 * The meta object literal for the '<em><b>Problem</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALGORITHM_INSTANCE__PROBLEM = eINSTANCE.getAlgorithmInstance_Problem();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALGORITHM_INSTANCE__DOCUMENTATION = eINSTANCE.getAlgorithmInstance_Documentation();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ol.Direction <em>Direction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ol.Direction
		 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getDirection()
		 * @generated
		 */
		EEnum DIRECTION = eINSTANCE.getDirection();

	}

} //OLPackage
