/**
 */
package de.evoal.languages.model.mll.impl;

import de.evoal.languages.model.execution.Block;
import de.evoal.languages.model.execution.impl.StatementImpl;
import de.evoal.languages.model.mll.MllPackage;
import de.evoal.languages.model.mll.PredictStatement;
import de.evoal.languages.model.mll.SurrogateDefinition;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predict Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.impl.PredictStatementImpl#getSurrogate <em>Surrogate</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.PredictStatementImpl#getModelFilename <em>Model Filename</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.PredictStatementImpl#getTrainingData <em>Training Data</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.PredictStatementImpl#getMeasurements <em>Measurements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PredictStatementImpl extends StatementImpl implements PredictStatement {
	/**
	 * The cached value of the '{@link #getSurrogate() <em>Surrogate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSurrogate()
	 * @generated
	 * @ordered
	 */
	protected SurrogateDefinition surrogate;

	/**
	 * The default value of the '{@link #getModelFilename() <em>Model Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelFilename()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelFilename() <em>Model Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelFilename()
	 * @generated
	 * @ordered
	 */
	protected String modelFilename = MODEL_FILENAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTrainingData() <em>Training Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrainingData()
	 * @generated
	 * @ordered
	 */
	protected static final String TRAINING_DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTrainingData() <em>Training Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrainingData()
	 * @generated
	 * @ordered
	 */
	protected String trainingData = TRAINING_DATA_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMeasurements() <em>Measurements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasurements()
	 * @generated
	 * @ordered
	 */
	protected Block measurements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PredictStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MllPackage.Literals.PREDICT_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SurrogateDefinition getSurrogate() {
		if (surrogate != null && surrogate.eIsProxy()) {
			InternalEObject oldSurrogate = (InternalEObject)surrogate;
			surrogate = (SurrogateDefinition)eResolveProxy(oldSurrogate);
			if (surrogate != oldSurrogate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MllPackage.PREDICT_STATEMENT__SURROGATE, oldSurrogate, surrogate));
			}
		}
		return surrogate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SurrogateDefinition basicGetSurrogate() {
		return surrogate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSurrogate(SurrogateDefinition newSurrogate) {
		SurrogateDefinition oldSurrogate = surrogate;
		surrogate = newSurrogate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MllPackage.PREDICT_STATEMENT__SURROGATE, oldSurrogate, surrogate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getModelFilename() {
		return modelFilename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelFilename(String newModelFilename) {
		String oldModelFilename = modelFilename;
		modelFilename = newModelFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MllPackage.PREDICT_STATEMENT__MODEL_FILENAME, oldModelFilename, modelFilename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTrainingData() {
		return trainingData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTrainingData(String newTrainingData) {
		String oldTrainingData = trainingData;
		trainingData = newTrainingData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MllPackage.PREDICT_STATEMENT__TRAINING_DATA, oldTrainingData, trainingData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Block getMeasurements() {
		return measurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMeasurements(Block newMeasurements, NotificationChain msgs) {
		Block oldMeasurements = measurements;
		measurements = newMeasurements;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MllPackage.PREDICT_STATEMENT__MEASUREMENTS, oldMeasurements, newMeasurements);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMeasurements(Block newMeasurements) {
		if (newMeasurements != measurements) {
			NotificationChain msgs = null;
			if (measurements != null)
				msgs = ((InternalEObject)measurements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MllPackage.PREDICT_STATEMENT__MEASUREMENTS, null, msgs);
			if (newMeasurements != null)
				msgs = ((InternalEObject)newMeasurements).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MllPackage.PREDICT_STATEMENT__MEASUREMENTS, null, msgs);
			msgs = basicSetMeasurements(newMeasurements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MllPackage.PREDICT_STATEMENT__MEASUREMENTS, newMeasurements, newMeasurements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MllPackage.PREDICT_STATEMENT__MEASUREMENTS:
				return basicSetMeasurements(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MllPackage.PREDICT_STATEMENT__SURROGATE:
				if (resolve) return getSurrogate();
				return basicGetSurrogate();
			case MllPackage.PREDICT_STATEMENT__MODEL_FILENAME:
				return getModelFilename();
			case MllPackage.PREDICT_STATEMENT__TRAINING_DATA:
				return getTrainingData();
			case MllPackage.PREDICT_STATEMENT__MEASUREMENTS:
				return getMeasurements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MllPackage.PREDICT_STATEMENT__SURROGATE:
				setSurrogate((SurrogateDefinition)newValue);
				return;
			case MllPackage.PREDICT_STATEMENT__MODEL_FILENAME:
				setModelFilename((String)newValue);
				return;
			case MllPackage.PREDICT_STATEMENT__TRAINING_DATA:
				setTrainingData((String)newValue);
				return;
			case MllPackage.PREDICT_STATEMENT__MEASUREMENTS:
				setMeasurements((Block)newValue);
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
			case MllPackage.PREDICT_STATEMENT__SURROGATE:
				setSurrogate((SurrogateDefinition)null);
				return;
			case MllPackage.PREDICT_STATEMENT__MODEL_FILENAME:
				setModelFilename(MODEL_FILENAME_EDEFAULT);
				return;
			case MllPackage.PREDICT_STATEMENT__TRAINING_DATA:
				setTrainingData(TRAINING_DATA_EDEFAULT);
				return;
			case MllPackage.PREDICT_STATEMENT__MEASUREMENTS:
				setMeasurements((Block)null);
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
			case MllPackage.PREDICT_STATEMENT__SURROGATE:
				return surrogate != null;
			case MllPackage.PREDICT_STATEMENT__MODEL_FILENAME:
				return MODEL_FILENAME_EDEFAULT == null ? modelFilename != null : !MODEL_FILENAME_EDEFAULT.equals(modelFilename);
			case MllPackage.PREDICT_STATEMENT__TRAINING_DATA:
				return TRAINING_DATA_EDEFAULT == null ? trainingData != null : !TRAINING_DATA_EDEFAULT.equals(trainingData);
			case MllPackage.PREDICT_STATEMENT__MEASUREMENTS:
				return measurements != null;
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
		result.append(" (modelFilename: ");
		result.append(modelFilename);
		result.append(", trainingData: ");
		result.append(trainingData);
		result.append(')');
		return result.toString();
	}

} //PredictStatementImpl
