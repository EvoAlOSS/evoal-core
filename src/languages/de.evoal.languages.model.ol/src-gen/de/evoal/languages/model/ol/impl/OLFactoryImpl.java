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
			case OLPackage.PROBLEM_INSTANCE: return createProblemInstance();
			case OLPackage.ALGORITHM_INSTANCE: return createAlgorithmInstance();
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
	public ProblemInstance createProblemInstance() {
		ProblemInstanceImpl problemInstance = new ProblemInstanceImpl();
		return problemInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AlgorithmInstance createAlgorithmInstance() {
		AlgorithmInstanceImpl algorithmInstance = new AlgorithmInstanceImpl();
		return algorithmInstance;
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
