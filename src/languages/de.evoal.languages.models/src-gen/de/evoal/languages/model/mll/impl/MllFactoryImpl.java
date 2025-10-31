/**
 */
package de.evoal.languages.model.mll.impl;

import de.evoal.languages.model.mll.*;

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
public class MllFactoryImpl extends EFactoryImpl implements MllFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MllFactory init() {
		try {
			MllFactory theMllFactory = (MllFactory)EPackage.Registry.INSTANCE.getEFactory(MllPackage.eNS_URI);
			if (theMllFactory != null) {
				return theMllFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MllFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MllFactoryImpl() {
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
			case MllPackage.MACHINE_LEARNING_MODULE: return createMachineLearningModule();
			case MllPackage.TASK_DESCRIPTION: return createTaskDescription();
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
	public MachineLearningModule createMachineLearningModule() {
		MachineLearningModuleImpl machineLearningModule = new MachineLearningModuleImpl();
		return machineLearningModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TaskDescription createTaskDescription() {
		TaskDescriptionImpl taskDescription = new TaskDescriptionImpl();
		return taskDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MllPackage getMllPackage() {
		return (MllPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MllPackage getPackage() {
		return MllPackage.eINSTANCE;
	}

} //MllFactoryImpl
