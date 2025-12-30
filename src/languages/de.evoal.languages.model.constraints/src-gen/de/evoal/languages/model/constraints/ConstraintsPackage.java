/**
 * (c) EvoAl project
 */
package de.evoal.languages.model.constraints;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see de.evoal.languages.model.constraints.ConstraintsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import base='platform:/resource/de.evoal.languages.model.base/model/model.ecore#/' ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface ConstraintsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "constraints";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.evoal.de/languages/constraints/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "constraints";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConstraintsPackage eINSTANCE = de.evoal.languages.model.constraints.impl.ConstraintsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.constraints.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.constraints.impl.ConstraintImpl
	 * @see de.evoal.languages.model.constraints.impl.ConstraintsPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__FEATURES = 0;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.constraints.impl.LowerBoundaryConstraintImpl <em>Lower Boundary Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.constraints.impl.LowerBoundaryConstraintImpl
	 * @see de.evoal.languages.model.constraints.impl.ConstraintsPackageImpl#getLowerBoundaryConstraint()
	 * @generated
	 */
	int LOWER_BOUNDARY_CONSTRAINT = 1;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_BOUNDARY_CONSTRAINT__FEATURES = CONSTRAINT__FEATURES;

	/**
	 * The feature id for the '<em><b>Boundary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_BOUNDARY_CONSTRAINT__BOUNDARY = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_BOUNDARY_CONSTRAINT__INCLUSIVE = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Lower Boundary Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_BOUNDARY_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.constraints.impl.UpperBoundaryConstraintImpl <em>Upper Boundary Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.constraints.impl.UpperBoundaryConstraintImpl
	 * @see de.evoal.languages.model.constraints.impl.ConstraintsPackageImpl#getUpperBoundaryConstraint()
	 * @generated
	 */
	int UPPER_BOUNDARY_CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_BOUNDARY_CONSTRAINT__FEATURES = CONSTRAINT__FEATURES;

	/**
	 * The feature id for the '<em><b>Boundary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_BOUNDARY_CONSTRAINT__BOUNDARY = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_BOUNDARY_CONSTRAINT__INCLUSIVE = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Upper Boundary Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_BOUNDARY_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.constraints.impl.MultiVariateConstraintImpl <em>Multi Variate Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.constraints.impl.MultiVariateConstraintImpl
	 * @see de.evoal.languages.model.constraints.impl.ConstraintsPackageImpl#getMultiVariateConstraint()
	 * @generated
	 */
	int MULTI_VARIATE_CONSTRAINT = 3;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_VARIATE_CONSTRAINT__FEATURES = CONSTRAINT__FEATURES;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_VARIATE_CONSTRAINT__CONDITION = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multi Variate Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_VARIATE_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>ENumber</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Number
	 * @see de.evoal.languages.model.constraints.impl.ConstraintsPackageImpl#getENumber()
	 * @generated
	 */
	int ENUMBER = 4;

	/**
	 * The meta object id for the '<em>Diagnostic</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic
	 * @see de.evoal.languages.model.constraints.impl.ConstraintsPackageImpl#getDiagnostic()
	 * @generated
	 */
	int DIAGNOSTIC = 5;


	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.constraints.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see de.evoal.languages.model.constraints.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the reference list '{@link de.evoal.languages.model.constraints.Constraint#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see de.evoal.languages.model.constraints.Constraint#getFeatures()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Features();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.constraints.LowerBoundaryConstraint <em>Lower Boundary Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lower Boundary Constraint</em>'.
	 * @see de.evoal.languages.model.constraints.LowerBoundaryConstraint
	 * @generated
	 */
	EClass getLowerBoundaryConstraint();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.constraints.LowerBoundaryConstraint#getBoundary <em>Boundary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boundary</em>'.
	 * @see de.evoal.languages.model.constraints.LowerBoundaryConstraint#getBoundary()
	 * @see #getLowerBoundaryConstraint()
	 * @generated
	 */
	EAttribute getLowerBoundaryConstraint_Boundary();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.constraints.LowerBoundaryConstraint#isInclusive <em>Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inclusive</em>'.
	 * @see de.evoal.languages.model.constraints.LowerBoundaryConstraint#isInclusive()
	 * @see #getLowerBoundaryConstraint()
	 * @generated
	 */
	EAttribute getLowerBoundaryConstraint_Inclusive();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.constraints.UpperBoundaryConstraint <em>Upper Boundary Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Upper Boundary Constraint</em>'.
	 * @see de.evoal.languages.model.constraints.UpperBoundaryConstraint
	 * @generated
	 */
	EClass getUpperBoundaryConstraint();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.constraints.UpperBoundaryConstraint#getBoundary <em>Boundary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boundary</em>'.
	 * @see de.evoal.languages.model.constraints.UpperBoundaryConstraint#getBoundary()
	 * @see #getUpperBoundaryConstraint()
	 * @generated
	 */
	EAttribute getUpperBoundaryConstraint_Boundary();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.constraints.UpperBoundaryConstraint#isInclusive <em>Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inclusive</em>'.
	 * @see de.evoal.languages.model.constraints.UpperBoundaryConstraint#isInclusive()
	 * @see #getUpperBoundaryConstraint()
	 * @generated
	 */
	EAttribute getUpperBoundaryConstraint_Inclusive();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.constraints.MultiVariateConstraint <em>Multi Variate Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Variate Constraint</em>'.
	 * @see de.evoal.languages.model.constraints.MultiVariateConstraint
	 * @generated
	 */
	EClass getMultiVariateConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.constraints.MultiVariateConstraint#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see de.evoal.languages.model.constraints.MultiVariateConstraint#getCondition()
	 * @see #getMultiVariateConstraint()
	 * @generated
	 */
	EReference getMultiVariateConstraint_Condition();

	/**
	 * Returns the meta object for data type '{@link java.lang.Number <em>ENumber</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>ENumber</em>'.
	 * @see java.lang.Number
	 * @model instanceClass="java.lang.Number" serializeable="false"
	 * @generated
	 */
	EDataType getENumber();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.Diagnostic <em>Diagnostic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Diagnostic</em>'.
	 * @see org.eclipse.emf.common.util.Diagnostic
	 * @model instanceClass="org.eclipse.emf.common.util.Diagnostic"
	 * @generated
	 */
	EDataType getDiagnostic();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConstraintsFactory getConstraintsFactory();

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
		 * The meta object literal for the '{@link de.evoal.languages.model.constraints.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.constraints.impl.ConstraintImpl
		 * @see de.evoal.languages.model.constraints.impl.ConstraintsPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__FEATURES = eINSTANCE.getConstraint_Features();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.constraints.impl.LowerBoundaryConstraintImpl <em>Lower Boundary Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.constraints.impl.LowerBoundaryConstraintImpl
		 * @see de.evoal.languages.model.constraints.impl.ConstraintsPackageImpl#getLowerBoundaryConstraint()
		 * @generated
		 */
		EClass LOWER_BOUNDARY_CONSTRAINT = eINSTANCE.getLowerBoundaryConstraint();

		/**
		 * The meta object literal for the '<em><b>Boundary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOWER_BOUNDARY_CONSTRAINT__BOUNDARY = eINSTANCE.getLowerBoundaryConstraint_Boundary();

		/**
		 * The meta object literal for the '<em><b>Inclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOWER_BOUNDARY_CONSTRAINT__INCLUSIVE = eINSTANCE.getLowerBoundaryConstraint_Inclusive();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.constraints.impl.UpperBoundaryConstraintImpl <em>Upper Boundary Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.constraints.impl.UpperBoundaryConstraintImpl
		 * @see de.evoal.languages.model.constraints.impl.ConstraintsPackageImpl#getUpperBoundaryConstraint()
		 * @generated
		 */
		EClass UPPER_BOUNDARY_CONSTRAINT = eINSTANCE.getUpperBoundaryConstraint();

		/**
		 * The meta object literal for the '<em><b>Boundary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPPER_BOUNDARY_CONSTRAINT__BOUNDARY = eINSTANCE.getUpperBoundaryConstraint_Boundary();

		/**
		 * The meta object literal for the '<em><b>Inclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPPER_BOUNDARY_CONSTRAINT__INCLUSIVE = eINSTANCE.getUpperBoundaryConstraint_Inclusive();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.constraints.impl.MultiVariateConstraintImpl <em>Multi Variate Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.constraints.impl.MultiVariateConstraintImpl
		 * @see de.evoal.languages.model.constraints.impl.ConstraintsPackageImpl#getMultiVariateConstraint()
		 * @generated
		 */
		EClass MULTI_VARIATE_CONSTRAINT = eINSTANCE.getMultiVariateConstraint();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_VARIATE_CONSTRAINT__CONDITION = eINSTANCE.getMultiVariateConstraint_Condition();

		/**
		 * The meta object literal for the '<em>ENumber</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see de.evoal.languages.model.constraints.impl.ConstraintsPackageImpl#getENumber()
		 * @generated
		 */
		EDataType ENUMBER = eINSTANCE.getENumber();

		/**
		 * The meta object literal for the '<em>Diagnostic</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.Diagnostic
		 * @see de.evoal.languages.model.constraints.impl.ConstraintsPackageImpl#getDiagnostic()
		 * @generated
		 */
		EDataType DIAGNOSTIC = eINSTANCE.getDiagnostic();

	}

} //ConstraintsPackage
