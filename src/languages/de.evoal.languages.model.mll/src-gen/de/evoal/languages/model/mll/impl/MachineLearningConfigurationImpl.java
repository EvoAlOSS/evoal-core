/**
 */
package de.evoal.languages.model.mll.impl;

import de.evoal.languages.model.mll.MachineLearningConfiguration;
import de.evoal.languages.model.mll.MllPackage;
import de.evoal.languages.model.mll.Prediction;
import de.evoal.languages.model.mll.SurrogateDefinition;
import de.evoal.languages.model.mll.Use;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Machine Learning Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.impl.MachineLearningConfigurationImpl#getUses <em>Uses</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.MachineLearningConfigurationImpl#getDefinitions <em>Definitions</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.MachineLearningConfigurationImpl#getPredictions <em>Predictions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MachineLearningConfigurationImpl extends MinimalEObjectImpl.Container implements MachineLearningConfiguration {
	/**
	 * The cached value of the '{@link #getUses() <em>Uses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUses()
	 * @generated
	 * @ordered
	 */
	protected EList<Use> uses;

	/**
	 * The cached value of the '{@link #getDefinitions() <em>Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<SurrogateDefinition> definitions;

	/**
	 * The cached value of the '{@link #getPredictions() <em>Predictions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredictions()
	 * @generated
	 * @ordered
	 */
	protected EList<Prediction> predictions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MachineLearningConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MllPackage.Literals.MACHINE_LEARNING_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Use> getUses() {
		if (uses == null) {
			uses = new EObjectContainmentEList<Use>(Use.class, this, MllPackage.MACHINE_LEARNING_CONFIGURATION__USES);
		}
		return uses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SurrogateDefinition> getDefinitions() {
		if (definitions == null) {
			definitions = new EObjectContainmentEList<SurrogateDefinition>(SurrogateDefinition.class, this, MllPackage.MACHINE_LEARNING_CONFIGURATION__DEFINITIONS);
		}
		return definitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Prediction> getPredictions() {
		if (predictions == null) {
			predictions = new EObjectContainmentEList<Prediction>(Prediction.class, this, MllPackage.MACHINE_LEARNING_CONFIGURATION__PREDICTIONS);
		}
		return predictions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__USES:
				return ((InternalEList<?>)getUses()).basicRemove(otherEnd, msgs);
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__DEFINITIONS:
				return ((InternalEList<?>)getDefinitions()).basicRemove(otherEnd, msgs);
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__PREDICTIONS:
				return ((InternalEList<?>)getPredictions()).basicRemove(otherEnd, msgs);
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
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__USES:
				return getUses();
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__DEFINITIONS:
				return getDefinitions();
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__PREDICTIONS:
				return getPredictions();
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
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__USES:
				getUses().clear();
				getUses().addAll((Collection<? extends Use>)newValue);
				return;
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__DEFINITIONS:
				getDefinitions().clear();
				getDefinitions().addAll((Collection<? extends SurrogateDefinition>)newValue);
				return;
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__PREDICTIONS:
				getPredictions().clear();
				getPredictions().addAll((Collection<? extends Prediction>)newValue);
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
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__USES:
				getUses().clear();
				return;
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__DEFINITIONS:
				getDefinitions().clear();
				return;
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__PREDICTIONS:
				getPredictions().clear();
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
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__USES:
				return uses != null && !uses.isEmpty();
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__DEFINITIONS:
				return definitions != null && !definitions.isEmpty();
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__PREDICTIONS:
				return predictions != null && !predictions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MachineLearningConfigurationImpl
