/**
 * EvoAl Project
 */
package de.evoal.languages.model.dynamic;

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
 * <!-- begin-model-doc -->
 * 
 * Model for annotating information on dynamically generated data models based on EvoAl's DDL.
 * 
 * <!-- end-model-doc -->
 * @see de.evoal.languages.model.dynamic.DynamicFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import base='platform:/resource/de.evoal.languages.model.base/model/model.ecore#/' defs='platform:/resource/de.evoal.languages.model.base/model/definitions.ecore#/' ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface DynamicPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dynamic";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.evoal.de/languages/dynamic/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dynamic";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DynamicPackage eINSTANCE = de.evoal.languages.model.dynamic.impl.DynamicPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.dynamic.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.dynamic.impl.MappingImpl
	 * @see de.evoal.languages.model.dynamic.impl.DynamicPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 0;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.dynamic.impl.DefinitionMappingImpl <em>Definition Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.dynamic.impl.DefinitionMappingImpl
	 * @see de.evoal.languages.model.dynamic.impl.DynamicPackageImpl#getDefinitionMapping()
	 * @generated
	 */
	int DEFINITION_MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_MAPPING__SOURCE = MAPPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_MAPPING__TARGET = MAPPING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Definition Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_MAPPING_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.dynamic.impl.ClassMappingImpl <em>Class Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.dynamic.impl.ClassMappingImpl
	 * @see de.evoal.languages.model.dynamic.impl.DynamicPackageImpl#getClassMapping()
	 * @generated
	 */
	int CLASS_MAPPING = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MAPPING__SOURCE = MAPPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MAPPING__TARGET = MAPPING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Class Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MAPPING_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.dynamic.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.dynamic.impl.AttributeMappingImpl
	 * @see de.evoal.languages.model.dynamic.impl.DynamicPackageImpl#getAttributeMapping()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__SOURCE = MAPPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__TARGET = MAPPING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.dynamic.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see de.evoal.languages.model.dynamic.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.dynamic.DefinitionMapping <em>Definition Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Definition Mapping</em>'.
	 * @see de.evoal.languages.model.dynamic.DefinitionMapping
	 * @generated
	 */
	EClass getDefinitionMapping();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.dynamic.DefinitionMapping#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.evoal.languages.model.dynamic.DefinitionMapping#getSource()
	 * @see #getDefinitionMapping()
	 * @generated
	 */
	EReference getDefinitionMapping_Source();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.dynamic.DefinitionMapping#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see de.evoal.languages.model.dynamic.DefinitionMapping#getTarget()
	 * @see #getDefinitionMapping()
	 * @generated
	 */
	EReference getDefinitionMapping_Target();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.dynamic.ClassMapping <em>Class Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Mapping</em>'.
	 * @see de.evoal.languages.model.dynamic.ClassMapping
	 * @generated
	 */
	EClass getClassMapping();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.dynamic.ClassMapping#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.evoal.languages.model.dynamic.ClassMapping#getSource()
	 * @see #getClassMapping()
	 * @generated
	 */
	EReference getClassMapping_Source();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.dynamic.ClassMapping#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see de.evoal.languages.model.dynamic.ClassMapping#getTarget()
	 * @see #getClassMapping()
	 * @generated
	 */
	EReference getClassMapping_Target();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.dynamic.AttributeMapping <em>Attribute Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Mapping</em>'.
	 * @see de.evoal.languages.model.dynamic.AttributeMapping
	 * @generated
	 */
	EClass getAttributeMapping();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.dynamic.AttributeMapping#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.evoal.languages.model.dynamic.AttributeMapping#getSource()
	 * @see #getAttributeMapping()
	 * @generated
	 */
	EReference getAttributeMapping_Source();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.dynamic.AttributeMapping#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see de.evoal.languages.model.dynamic.AttributeMapping#getTarget()
	 * @see #getAttributeMapping()
	 * @generated
	 */
	EReference getAttributeMapping_Target();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DynamicFactory getDynamicFactory();

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
		 * The meta object literal for the '{@link de.evoal.languages.model.dynamic.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.dynamic.impl.MappingImpl
		 * @see de.evoal.languages.model.dynamic.impl.DynamicPackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.dynamic.impl.DefinitionMappingImpl <em>Definition Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.dynamic.impl.DefinitionMappingImpl
		 * @see de.evoal.languages.model.dynamic.impl.DynamicPackageImpl#getDefinitionMapping()
		 * @generated
		 */
		EClass DEFINITION_MAPPING = eINSTANCE.getDefinitionMapping();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFINITION_MAPPING__SOURCE = eINSTANCE.getDefinitionMapping_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFINITION_MAPPING__TARGET = eINSTANCE.getDefinitionMapping_Target();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.dynamic.impl.ClassMappingImpl <em>Class Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.dynamic.impl.ClassMappingImpl
		 * @see de.evoal.languages.model.dynamic.impl.DynamicPackageImpl#getClassMapping()
		 * @generated
		 */
		EClass CLASS_MAPPING = eINSTANCE.getClassMapping();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_MAPPING__SOURCE = eINSTANCE.getClassMapping_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_MAPPING__TARGET = eINSTANCE.getClassMapping_Target();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.dynamic.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.dynamic.impl.AttributeMappingImpl
		 * @see de.evoal.languages.model.dynamic.impl.DynamicPackageImpl#getAttributeMapping()
		 * @generated
		 */
		EClass ATTRIBUTE_MAPPING = eINSTANCE.getAttributeMapping();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_MAPPING__SOURCE = eINSTANCE.getAttributeMapping_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_MAPPING__TARGET = eINSTANCE.getAttributeMapping_Target();

	}

} //DynamicPackage
