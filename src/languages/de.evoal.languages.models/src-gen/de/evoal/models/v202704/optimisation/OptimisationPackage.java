/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation;

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
 * @see de.evoal.models.v202704.optimisation.OptimisationFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import core='core.ecore#/' ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface OptimisationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "optimisation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://evoal.de/v202704/models/optimisation";

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
	OptimisationPackage eINSTANCE = de.evoal.models.v202704.optimisation.impl.OptimisationPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.impl.ComparableImpl <em>Comparable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.impl.ComparableImpl
	 * @see de.evoal.models.v202704.optimisation.impl.OptimisationPackageImpl#getComparable()
	 * @generated
	 */
	int COMPARABLE = 0;

	/**
	 * The number of structural features of the '<em>Comparable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.impl.StreamImpl <em>Stream</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.impl.StreamImpl
	 * @see de.evoal.models.v202704.optimisation.impl.OptimisationPackageImpl#getStream()
	 * @generated
	 */
	int STREAM = 1;

	/**
	 * The number of structural features of the '<em>Stream</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.impl.ListImpl <em>List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.impl.ListImpl
	 * @see de.evoal.models.v202704.optimisation.impl.OptimisationPackageImpl#getList()
	 * @generated
	 */
	int LIST = 2;

	/**
	 * The number of structural features of the '<em>List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '<em>Space</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.core.ecore.Space
	 * @see de.evoal.models.v202704.optimisation.impl.OptimisationPackageImpl#getSpace()
	 * @generated
	 */
	int SPACE = 3;

	/**
	 * The meta object id for the '<em>Typed EObject</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.core.ecore.TypedEObject
	 * @see de.evoal.models.v202704.optimisation.impl.OptimisationPackageImpl#getTypedEObject()
	 * @generated
	 */
	int TYPED_EOBJECT = 4;

	/**
	 * The meta object id for the '<em>Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Number
	 * @see de.evoal.models.v202704.optimisation.impl.OptimisationPackageImpl#getNumber()
	 * @generated
	 */
	int NUMBER = 5;


	/**
	 * Returns the meta object for class '{@link java.lang.Comparable <em>Comparable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comparable</em>'.
	 * @see java.lang.Comparable
	 * @model instanceClass="java.lang.Comparable" typeParameters="T"
	 * @generated
	 */
	EClass getComparable();

	/**
	 * Returns the meta object for class '{@link java.util.stream.Stream <em>Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stream</em>'.
	 * @see java.util.stream.Stream
	 * @model instanceClass="java.util.stream.Stream" typeParameters="T"
	 * @generated
	 */
	EClass getStream();

	/**
	 * Returns the meta object for class '{@link java.util.List <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List" typeParameters="T"
	 * @generated
	 */
	EClass getList();

	/**
	 * Returns the meta object for data type '{@link de.evoal.models.core.ecore.Space <em>Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Space</em>'.
	 * @see de.evoal.models.core.ecore.Space
	 * @model instanceClass="de.evoal.models.core.ecore.Space" serializeable="false"
	 * @generated
	 */
	EDataType getSpace();

	/**
	 * Returns the meta object for data type '{@link de.evoal.models.core.ecore.TypedEObject <em>Typed EObject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Typed EObject</em>'.
	 * @see de.evoal.models.core.ecore.TypedEObject
	 * @model instanceClass="de.evoal.models.core.ecore.TypedEObject"
	 * @generated
	 */
	EDataType getTypedEObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.Number <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * A metric value: a {@link Long} for integral values, a {@link Double} for real values.
     * 
     * <!-- end-model-doc -->
	 * @return the meta object for data type '<em>Number</em>'.
	 * @see java.lang.Number
	 * @model instanceClass="java.lang.Number"
	 * @generated
	 */
	EDataType getNumber();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OptimisationFactory getOptimisationFactory();

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
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.impl.ComparableImpl <em>Comparable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.impl.ComparableImpl
		 * @see de.evoal.models.v202704.optimisation.impl.OptimisationPackageImpl#getComparable()
		 * @generated
		 */
		EClass COMPARABLE = eINSTANCE.getComparable();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.impl.StreamImpl <em>Stream</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.impl.StreamImpl
		 * @see de.evoal.models.v202704.optimisation.impl.OptimisationPackageImpl#getStream()
		 * @generated
		 */
		EClass STREAM = eINSTANCE.getStream();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.impl.ListImpl <em>List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.impl.ListImpl
		 * @see de.evoal.models.v202704.optimisation.impl.OptimisationPackageImpl#getList()
		 * @generated
		 */
		EClass LIST = eINSTANCE.getList();

		/**
		 * The meta object literal for the '<em>Space</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.core.ecore.Space
		 * @see de.evoal.models.v202704.optimisation.impl.OptimisationPackageImpl#getSpace()
		 * @generated
		 */
		EDataType SPACE = eINSTANCE.getSpace();

		/**
		 * The meta object literal for the '<em>Typed EObject</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.core.ecore.TypedEObject
		 * @see de.evoal.models.v202704.optimisation.impl.OptimisationPackageImpl#getTypedEObject()
		 * @generated
		 */
		EDataType TYPED_EOBJECT = eINSTANCE.getTypedEObject();

		/**
		 * The meta object literal for the '<em>Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see de.evoal.models.v202704.optimisation.impl.OptimisationPackageImpl#getNumber()
		 * @generated
		 */
		EDataType NUMBER = eINSTANCE.getNumber();

	}

} //OptimisationPackage
