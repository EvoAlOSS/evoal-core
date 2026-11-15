/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.core;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see de.evoal.models.v202704.core.CoreFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import expr='platform:/resource/de.evoal.languages.model.base/model/expressions.ecore#/'"
 * @generated
 */
public interface CorePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "core";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://evoal.de/v202704/models/core";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "core";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CorePackage eINSTANCE = de.evoal.models.v202704.core.impl.CorePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.core.impl.EvoalComponentImpl <em>Evoal Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.core.impl.EvoalComponentImpl
	 * @see de.evoal.models.v202704.core.impl.CorePackageImpl#getEvoalComponent()
	 * @generated
	 */
	int EVOAL_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Evoal Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVOAL_COMPONENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.core.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.core.impl.ConfigurationImpl
	 * @see de.evoal.models.v202704.core.impl.CorePackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 1;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '<em>Initialization Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.core.exceptions.InitializationException
	 * @see de.evoal.models.v202704.core.impl.CorePackageImpl#getInitializationException()
	 * @generated
	 */
	int INITIALIZATION_EXCEPTION = 2;


	/**
	 * Returns the meta object for class '{@link de.evoal.models.core.cdi.EvoalComponent <em>Evoal Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evoal Component</em>'.
	 * @see de.evoal.models.core.cdi.EvoalComponent
	 * @model instanceClass="de.evoal.models.core.cdi.EvoalComponent" typeParameters="T" TBounds="de.evoal.models.v202704.core.EvoalComponent&lt;T&gt;"
	 * @generated
	 */
	EClass getEvoalComponent();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.core.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see de.evoal.models.v202704.core.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for data type '{@link de.evoal.models.core.exceptions.InitializationException <em>Initialization Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Initialization Exception</em>'.
	 * @see de.evoal.models.core.exceptions.InitializationException
	 * @model instanceClass="de.evoal.models.core.exceptions.InitializationException" serializeable="false"
	 * @generated
	 */
	EDataType getInitializationException();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CoreFactory getCoreFactory();

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
		 * The meta object literal for the '{@link de.evoal.models.v202704.core.impl.EvoalComponentImpl <em>Evoal Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.core.impl.EvoalComponentImpl
		 * @see de.evoal.models.v202704.core.impl.CorePackageImpl#getEvoalComponent()
		 * @generated
		 */
		EClass EVOAL_COMPONENT = eINSTANCE.getEvoalComponent();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.core.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.core.impl.ConfigurationImpl
		 * @see de.evoal.models.v202704.core.impl.CorePackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em>Initialization Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.core.exceptions.InitializationException
		 * @see de.evoal.models.v202704.core.impl.CorePackageImpl#getInitializationException()
		 * @generated
		 */
		EDataType INITIALIZATION_EXCEPTION = eINSTANCE.getInitializationException();

	}

} //CorePackage
