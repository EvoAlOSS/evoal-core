/**
 */
package de.evoal.languages.model.ddl;

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
 * @see de.evoal.languages.model.ddl.DdlFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import base='platform:/resource/de.evoal.languages.model.base/model/model.ecore#/' defs='platform:/resource/de.evoal.languages.model.base/model/definitions.ecore#/' dl='platform:/resource/de.evoal.languages.model.dl/model/model.ecore#/' ecore='http://www.eclipse.org/emf/2002/Ecore' exprs='platform:/resource/de.evoal.languages.model.base/model/expressions.ecore#/'"
 * @generated
 */
public interface DdlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ddl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.evoal.de/languages/ddl/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ddl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DdlPackage eINSTANCE = de.evoal.languages.model.ddl.impl.DdlPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.DataDescriptionModuleImpl <em>Data Description Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.DataDescriptionModuleImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataDescriptionModule()
	 * @generated
	 */
	int DATA_DESCRIPTION_MODULE = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODULE__IMPORTS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODULE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODULE__TYPES = 2;

	/**
	 * The feature id for the '<em><b>Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODULE__DESCRIPTIONS = 3;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODULE__CONSTRAINTS = 4;

	/**
	 * The number of structural features of the '<em>Data Description Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODULE_FEATURE_COUNT = 5;


	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.DataDescriptionModule <em>Data Description Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Description Module</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModule
	 * @generated
	 */
	EClass getDataDescriptionModule();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.DataDescriptionModule#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModule#getImports()
	 * @see #getDataDescriptionModule()
	 * @generated
	 */
	EReference getDataDescriptionModule_Imports();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ddl.DataDescriptionModule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModule#getName()
	 * @see #getDataDescriptionModule()
	 * @generated
	 */
	EAttribute getDataDescriptionModule_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.DataDescriptionModule#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModule#getTypes()
	 * @see #getDataDescriptionModule()
	 * @generated
	 */
	EReference getDataDescriptionModule_Types();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.DataDescriptionModule#getDescriptions <em>Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Descriptions</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModule#getDescriptions()
	 * @see #getDataDescriptionModule()
	 * @generated
	 */
	EReference getDataDescriptionModule_Descriptions();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.DataDescriptionModule#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModule#getConstraints()
	 * @see #getDataDescriptionModule()
	 * @generated
	 */
	EReference getDataDescriptionModule_Constraints();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DdlFactory getDdlFactory();

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
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.DataDescriptionModuleImpl <em>Data Description Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.DataDescriptionModuleImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataDescriptionModule()
		 * @generated
		 */
		EClass DATA_DESCRIPTION_MODULE = eINSTANCE.getDataDescriptionModule();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DESCRIPTION_MODULE__IMPORTS = eINSTANCE.getDataDescriptionModule_Imports();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_DESCRIPTION_MODULE__NAME = eINSTANCE.getDataDescriptionModule_Name();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DESCRIPTION_MODULE__TYPES = eINSTANCE.getDataDescriptionModule_Types();

		/**
		 * The meta object literal for the '<em><b>Descriptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DESCRIPTION_MODULE__DESCRIPTIONS = eINSTANCE.getDataDescriptionModule_Descriptions();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DESCRIPTION_MODULE__CONSTRAINTS = eINSTANCE.getDataDescriptionModule_Constraints();

	}

} //DdlPackage
