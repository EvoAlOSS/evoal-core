/**
 */
package de.evoal.languages.model.mll.impl;

import de.evoal.languages.model.base.definitions.DataDescription;

import de.evoal.languages.model.base.expressions.impl.InstanceImpl;

import de.evoal.languages.model.mll.MllPackage;
import de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partial Surrogate Function Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.impl.PartialSurrogateFunctionDefinitionImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.PartialSurrogateFunctionDefinitionImpl#getOutputs <em>Outputs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PartialSurrogateFunctionDefinitionImpl extends InstanceImpl implements PartialSurrogateFunctionDefinition {
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__INPUTS:
				return getInputs();
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__OUTPUTS:
				return getOutputs();
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
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends DataDescription>)newValue);
				return;
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends DataDescription>)newValue);
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
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__INPUTS:
				getInputs().clear();
				return;
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__OUTPUTS:
				getOutputs().clear();
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
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PartialSurrogateFunctionDefinitionImpl
