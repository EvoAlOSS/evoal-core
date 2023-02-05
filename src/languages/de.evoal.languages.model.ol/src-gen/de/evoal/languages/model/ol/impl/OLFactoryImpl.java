/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol.impl;

import de.evoal.languages.model.ol.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OLFactoryImpl extends EFactoryImpl implements OLFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OLFactory init() {
		try {
			OLFactory theOLFactory = (OLFactory)EPackage.Registry.INSTANCE.getEFactory(OLPackage.eNS_URI);
			if (theOLFactory != null) {
				return theOLFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OLFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OLFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OLPackage.OPTIMISATION_MODEL: return createOptimisationModel();
			case OLPackage.USE: return createUse();
			case OLPackage.CONSTRAINT: return createConstraint();
			case OLPackage.CONSTRAINT_STATEMENT: return createConstraintStatement();
			case OLPackage.FUNCTION_NAME: return createFunctionName();
			case OLPackage.DATA_REFERENCE: return createDataReference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OptimisationModel createOptimisationModel() {
		OptimisationModelImpl optimisationModel = new OptimisationModelImpl();
		return optimisationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Use createUse() {
		UseImpl use = new UseImpl();
		return use;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Constraint createConstraint() {
		ConstraintImpl constraint = new ConstraintImpl();
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstraintStatement createConstraintStatement() {
		ConstraintStatementImpl constraintStatement = new ConstraintStatementImpl();
		return constraintStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionName createFunctionName() {
		FunctionNameImpl functionName = new FunctionNameImpl();
		return functionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataReference createDataReference() {
		DataReferenceImpl dataReference = new DataReferenceImpl();
		return dataReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OLPackage getOLPackage() {
		return (OLPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OLPackage getPackage() {
		return OLPackage.eINSTANCE;
	}

} //OLFactoryImpl
