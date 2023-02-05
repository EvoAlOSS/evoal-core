/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol;

import de.evoal.languages.model.el.ELPackage;

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
 *        annotation="http://www.eclipse.org/OCL/Import ddl='platform:/resource/de.evoal.languages.model.ddl/model/model.ecore#/' dl='platform:/resource/de.evoal.languages.model.dl/model/model.ecore#/' el='platform:/resource/de.evoal.languages.model.el/model/model.ecore#/' instance='platform:/resource/de.evoal.languages.model.instance/model/model.ecore#/'"
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
	 * The meta object id for the '{@link de.evoal.languages.model.ol.impl.OptimisationModelImpl <em>Optimisation Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ol.impl.OptimisationModelImpl
	 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getOptimisationModel()
	 * @generated
	 */
	int OPTIMISATION_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_MODEL__USES = 0;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_MODEL__INSTANCE = 1;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_MODEL__CONSTRAINTS = 2;

	/**
	 * The number of structural features of the '<em>Optimisation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMISATION_MODEL_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ol.impl.UseImpl <em>Use</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ol.impl.UseImpl
	 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getUse()
	 * @generated
	 */
	int USE = 1;

	/**
	 * The feature id for the '<em><b>Import URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE__IMPORT_URI = 0;

	/**
	 * The number of structural features of the '<em>Use</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ol.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ol.impl.ConstraintImpl
	 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__STATEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ol.impl.ConstraintStatementImpl <em>Constraint Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ol.impl.ConstraintStatementImpl
	 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getConstraintStatement()
	 * @generated
	 */
	int CONSTRAINT_STATEMENT = 3;

	/**
	 * The feature id for the '<em><b>Constraint Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_STATEMENT__CONSTRAINT_EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Constraint Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_STATEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ol.impl.FunctionNameImpl <em>Function Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ol.impl.FunctionNameImpl
	 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getFunctionName()
	 * @generated
	 */
	int FUNCTION_NAME = 4;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_NAME__DEFINITION = ELPackage.FUNCTION_NAME_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Function Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_NAME_FEATURE_COUNT = ELPackage.FUNCTION_NAME_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ol.impl.DataReferenceImpl <em>Data Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ol.impl.DataReferenceImpl
	 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getDataReference()
	 * @generated
	 */
	int DATA_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_REFERENCE__DEFINITION = ELPackage.VALUE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_REFERENCE_FEATURE_COUNT = ELPackage.VALUE_REFERENCE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ol.OptimisationModel <em>Optimisation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optimisation Model</em>'.
	 * @see de.evoal.languages.model.ol.OptimisationModel
	 * @generated
	 */
	EClass getOptimisationModel();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ol.OptimisationModel#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Uses</em>'.
	 * @see de.evoal.languages.model.ol.OptimisationModel#getUses()
	 * @see #getOptimisationModel()
	 * @generated
	 */
	EReference getOptimisationModel_Uses();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.ol.OptimisationModel#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Instance</em>'.
	 * @see de.evoal.languages.model.ol.OptimisationModel#getInstance()
	 * @see #getOptimisationModel()
	 * @generated
	 */
	EReference getOptimisationModel_Instance();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.ol.OptimisationModel#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraints</em>'.
	 * @see de.evoal.languages.model.ol.OptimisationModel#getConstraints()
	 * @see #getOptimisationModel()
	 * @generated
	 */
	EReference getOptimisationModel_Constraints();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ol.Use <em>Use</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use</em>'.
	 * @see de.evoal.languages.model.ol.Use
	 * @generated
	 */
	EClass getUse();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ol.Use#getImportURI <em>Import URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import URI</em>'.
	 * @see de.evoal.languages.model.ol.Use#getImportURI()
	 * @see #getUse()
	 * @generated
	 */
	EAttribute getUse_ImportURI();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ol.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see de.evoal.languages.model.ol.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ol.Constraint#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see de.evoal.languages.model.ol.Constraint#getStatements()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Statements();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ol.ConstraintStatement <em>Constraint Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Statement</em>'.
	 * @see de.evoal.languages.model.ol.ConstraintStatement
	 * @generated
	 */
	EClass getConstraintStatement();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.ol.ConstraintStatement#getConstraintExpression <em>Constraint Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint Expression</em>'.
	 * @see de.evoal.languages.model.ol.ConstraintStatement#getConstraintExpression()
	 * @see #getConstraintStatement()
	 * @generated
	 */
	EReference getConstraintStatement_ConstraintExpression();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ol.FunctionName <em>Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Name</em>'.
	 * @see de.evoal.languages.model.ol.FunctionName
	 * @generated
	 */
	EClass getFunctionName();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.ol.FunctionName#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.ol.FunctionName#getDefinition()
	 * @see #getFunctionName()
	 * @generated
	 */
	EReference getFunctionName_Definition();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ol.DataReference <em>Data Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Reference</em>'.
	 * @see de.evoal.languages.model.ol.DataReference
	 * @generated
	 */
	EClass getDataReference();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.ol.DataReference#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.ol.DataReference#getDefinition()
	 * @see #getDataReference()
	 * @generated
	 */
	EReference getDataReference_Definition();

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
		 * The meta object literal for the '{@link de.evoal.languages.model.ol.impl.OptimisationModelImpl <em>Optimisation Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ol.impl.OptimisationModelImpl
		 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getOptimisationModel()
		 * @generated
		 */
		EClass OPTIMISATION_MODEL = eINSTANCE.getOptimisationModel();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMISATION_MODEL__USES = eINSTANCE.getOptimisationModel_Uses();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMISATION_MODEL__INSTANCE = eINSTANCE.getOptimisationModel_Instance();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMISATION_MODEL__CONSTRAINTS = eINSTANCE.getOptimisationModel_Constraints();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ol.impl.UseImpl <em>Use</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ol.impl.UseImpl
		 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getUse()
		 * @generated
		 */
		EClass USE = eINSTANCE.getUse();

		/**
		 * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE__IMPORT_URI = eINSTANCE.getUse_ImportURI();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ol.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ol.impl.ConstraintImpl
		 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__STATEMENTS = eINSTANCE.getConstraint_Statements();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ol.impl.ConstraintStatementImpl <em>Constraint Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ol.impl.ConstraintStatementImpl
		 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getConstraintStatement()
		 * @generated
		 */
		EClass CONSTRAINT_STATEMENT = eINSTANCE.getConstraintStatement();

		/**
		 * The meta object literal for the '<em><b>Constraint Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_STATEMENT__CONSTRAINT_EXPRESSION = eINSTANCE.getConstraintStatement_ConstraintExpression();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ol.impl.FunctionNameImpl <em>Function Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ol.impl.FunctionNameImpl
		 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getFunctionName()
		 * @generated
		 */
		EClass FUNCTION_NAME = eINSTANCE.getFunctionName();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_NAME__DEFINITION = eINSTANCE.getFunctionName_Definition();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ol.impl.DataReferenceImpl <em>Data Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ol.impl.DataReferenceImpl
		 * @see de.evoal.languages.model.ol.impl.OLPackageImpl#getDataReference()
		 * @generated
		 */
		EClass DATA_REFERENCE = eINSTANCE.getDataReference();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_REFERENCE__DEFINITION = eINSTANCE.getDataReference_Definition();

	}

} //OLPackage
