/**
 */
package de.evoal.languages.model.mll.impl;

import de.evoal.languages.model.base.TypeDefinition;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.mll.MllPackage;
import de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partial Surrogate Function Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.impl.PartialSurrogateFunctionDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.PartialSurrogateFunctionDefinitionImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.PartialSurrogateFunctionDefinitionImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.PartialSurrogateFunctionDefinitionImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PartialSurrogateFunctionDefinitionImpl extends MinimalEObjectImpl.Container implements PartialSurrogateFunctionDefinition {
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected TypeDefinition name;

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
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<de.evoal.languages.model.base.Attribute> parameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartialSurrogateFunctionDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MllPackage.Literals.PARTIAL_SURROGATE_FUNCTION_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeDefinition getName() {
		if (name != null && name.eIsProxy()) {
			InternalEObject oldName = (InternalEObject)name;
			name = (TypeDefinition)eResolveProxy(oldName);
			if (name != oldName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__NAME, oldName, name));
			}
		}
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeDefinition basicGetName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(TypeDefinition newName) {
		TypeDefinition oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataDescription> getInputs() {
		if (inputs == null) {
			inputs = new EObjectResolvingEList<DataDescription>(DataDescription.class, this, MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__INPUTS);
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
			outputs = new EObjectResolvingEList<DataDescription>(DataDescription.class, this, MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<de.evoal.languages.model.base.Attribute> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<de.evoal.languages.model.base.Attribute>(de.evoal.languages.model.base.Attribute.class, this, MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__NAME:
				if (resolve) return getName();
				return basicGetName();
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__INPUTS:
				return getInputs();
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__OUTPUTS:
				return getOutputs();
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__PARAMETERS:
				return getParameters();
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
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__NAME:
				setName((TypeDefinition)newValue);
				return;
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends DataDescription>)newValue);
				return;
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends DataDescription>)newValue);
				return;
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends de.evoal.languages.model.base.Attribute>)newValue);
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
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__NAME:
				setName((TypeDefinition)null);
				return;
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__INPUTS:
				getInputs().clear();
				return;
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__OUTPUTS:
				getOutputs().clear();
				return;
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__PARAMETERS:
				getParameters().clear();
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
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__NAME:
				return name != null;
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PartialSurrogateFunctionDefinitionImpl
