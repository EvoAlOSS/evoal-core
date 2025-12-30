/**
 */
package de.evoal.languages.model.mll.impl;

import de.evoal.languages.model.base.definitions.DataDescription;

import de.evoal.languages.model.execution.impl.NamedVariableImpl;

import de.evoal.languages.model.mll.MllPackage;
import de.evoal.languages.model.mll.TaskDescription;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.impl.TaskDescriptionImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.TaskDescriptionImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.TaskDescriptionImpl#getLearningData <em>Learning Data</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.TaskDescriptionImpl#getTestingData <em>Testing Data</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.TaskDescriptionImpl#getModelFile <em>Model File</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.TaskDescriptionImpl#getGofFile <em>Gof File</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaskDescriptionImpl extends NamedVariableImpl implements TaskDescription {
	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<DataDescription> inputs;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<DataDescription> outputs;

	/**
	 * The cached value of the '{@link #getLearningData() <em>Learning Data</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLearningData()
	 * @generated
	 * @ordered
	 */
	protected EList<String> learningData;

	/**
	 * The cached value of the '{@link #getTestingData() <em>Testing Data</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestingData()
	 * @generated
	 * @ordered
	 */
	protected EList<String> testingData;

	/**
	 * The default value of the '{@link #getModelFile() <em>Model File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelFile()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelFile() <em>Model File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelFile()
	 * @generated
	 * @ordered
	 */
	protected String modelFile = MODEL_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getGofFile() <em>Gof File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGofFile()
	 * @generated
	 * @ordered
	 */
	protected static final String GOF_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGofFile() <em>Gof File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGofFile()
	 * @generated
	 * @ordered
	 */
	protected String gofFile = GOF_FILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MllPackage.Literals.TASK_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataDescription> getInputs() {
		if (inputs == null) {
			inputs = new EObjectResolvingEList<DataDescription>(DataDescription.class, this, MllPackage.TASK_DESCRIPTION__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataDescription> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectResolvingEList<DataDescription>(DataDescription.class, this, MllPackage.TASK_DESCRIPTION__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getLearningData() {
		if (learningData == null) {
			learningData = new EDataTypeUniqueEList<String>(String.class, this, MllPackage.TASK_DESCRIPTION__LEARNING_DATA);
		}
		return learningData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getTestingData() {
		if (testingData == null) {
			testingData = new EDataTypeUniqueEList<String>(String.class, this, MllPackage.TASK_DESCRIPTION__TESTING_DATA);
		}
		return testingData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getModelFile() {
		return modelFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelFile(String newModelFile) {
		String oldModelFile = modelFile;
		modelFile = newModelFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MllPackage.TASK_DESCRIPTION__MODEL_FILE, oldModelFile, modelFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGofFile() {
		return gofFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGofFile(String newGofFile) {
		String oldGofFile = gofFile;
		gofFile = newGofFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MllPackage.TASK_DESCRIPTION__GOF_FILE, oldGofFile, gofFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MllPackage.TASK_DESCRIPTION__INPUTS:
				return getInputs();
			case MllPackage.TASK_DESCRIPTION__OUTPUTS:
				return getOutputs();
			case MllPackage.TASK_DESCRIPTION__LEARNING_DATA:
				return getLearningData();
			case MllPackage.TASK_DESCRIPTION__TESTING_DATA:
				return getTestingData();
			case MllPackage.TASK_DESCRIPTION__MODEL_FILE:
				return getModelFile();
			case MllPackage.TASK_DESCRIPTION__GOF_FILE:
				return getGofFile();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MllPackage.TASK_DESCRIPTION__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends DataDescription>)newValue);
				return;
			case MllPackage.TASK_DESCRIPTION__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends DataDescription>)newValue);
				return;
			case MllPackage.TASK_DESCRIPTION__LEARNING_DATA:
				getLearningData().clear();
				getLearningData().addAll((Collection<? extends String>)newValue);
				return;
			case MllPackage.TASK_DESCRIPTION__TESTING_DATA:
				getTestingData().clear();
				getTestingData().addAll((Collection<? extends String>)newValue);
				return;
			case MllPackage.TASK_DESCRIPTION__MODEL_FILE:
				setModelFile((String)newValue);
				return;
			case MllPackage.TASK_DESCRIPTION__GOF_FILE:
				setGofFile((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MllPackage.TASK_DESCRIPTION__INPUTS:
				getInputs().clear();
				return;
			case MllPackage.TASK_DESCRIPTION__OUTPUTS:
				getOutputs().clear();
				return;
			case MllPackage.TASK_DESCRIPTION__LEARNING_DATA:
				getLearningData().clear();
				return;
			case MllPackage.TASK_DESCRIPTION__TESTING_DATA:
				getTestingData().clear();
				return;
			case MllPackage.TASK_DESCRIPTION__MODEL_FILE:
				setModelFile(MODEL_FILE_EDEFAULT);
				return;
			case MllPackage.TASK_DESCRIPTION__GOF_FILE:
				setGofFile(GOF_FILE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MllPackage.TASK_DESCRIPTION__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case MllPackage.TASK_DESCRIPTION__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case MllPackage.TASK_DESCRIPTION__LEARNING_DATA:
				return learningData != null && !learningData.isEmpty();
			case MllPackage.TASK_DESCRIPTION__TESTING_DATA:
				return testingData != null && !testingData.isEmpty();
			case MllPackage.TASK_DESCRIPTION__MODEL_FILE:
				return MODEL_FILE_EDEFAULT == null ? modelFile != null : !MODEL_FILE_EDEFAULT.equals(modelFile);
			case MllPackage.TASK_DESCRIPTION__GOF_FILE:
				return GOF_FILE_EDEFAULT == null ? gofFile != null : !GOF_FILE_EDEFAULT.equals(gofFile);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (learningData: ");
		result.append(learningData);
		result.append(", testingData: ");
		result.append(testingData);
		result.append(", modelFile: ");
		result.append(modelFile);
		result.append(", gofFile: ");
		result.append(gofFile);
		result.append(')');
		return result.toString();
	}

} //TaskDescriptionImpl
