/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol;

import de.evoal.languages.model.base.expressions.ExpressionsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 *        annotation="http://www.eclipse.org/OCL/Import ddl='platform:/resource/de.evoal.languages.model.ddl/model/model.ecore#/' el='platform:/resource/de.evoal.languages.model.base/model/model.ecore#/' instance='platform:/resource/de.evoal.languages.model.instance/model/model.ecore#/'"
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
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_MODULE__IMPORTS = 0;

	/**
	 * The feature id for the '<em><b>Problem</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_MODULE__PROBLEM = 1;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_MODULE__ALGORITHM = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_MODULE__NAME = 3;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_INSTANCE__NAME = ExpressionsPackage.INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_INSTANCE__DOCUMENTATION = ExpressionsPackage.INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Problem Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_INSTANCE_FEATURE_COUNT = ExpressionsPackage.INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ol.impl.AlgorithmInstanceImpl <em>Algorithm Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ol.impl.AlgorithmInstanceImpl
	 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getAlgorithmInstance()
	 * @generated
	 */
	int ALGORITHM_INSTANCE = 2;

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
	 * Returns the meta object for class '{@link de.evoal.languages.model.ol.OptimisationModule <em>Optimisation Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optimisation Module</em>'.
	 * @see de.evoal.languages.model.ol.OptimisationModule
	 * @generated
	 */
	EClass getOptimisationModule();

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
	 * Returns the meta object for class '{@link de.evoal.languages.model.ol.ProblemInstance <em>Problem Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Problem Instance</em>'.
	 * @see de.evoal.languages.model.ol.ProblemInstance
	 * @generated
	 */
	EClass getProblemInstance();

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
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMISATION_MODULE__IMPORTS = eINSTANCE.getOptimisationModule_Imports();

		/**
		 * The meta object literal for the '<em><b>Problem</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMISATION_MODULE__PROBLEM = eINSTANCE.getOptimisationModule_Problem();

		/**
		 * The meta object literal for the '<em><b>Algorithm</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMISATION_MODULE__ALGORITHM = eINSTANCE.getOptimisationModule_Algorithm();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTIMISATION_MODULE__NAME = eINSTANCE.getOptimisationModule_Name();

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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM_INSTANCE__NAME = eINSTANCE.getProblemInstance_Name();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM_INSTANCE__DOCUMENTATION = eINSTANCE.getProblemInstance_Documentation();

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

	}

} //OLPackage
