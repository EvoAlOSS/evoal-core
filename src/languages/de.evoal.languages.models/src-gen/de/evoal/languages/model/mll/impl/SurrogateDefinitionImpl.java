/**
 */
package de.evoal.languages.model.mll.impl;

import de.evoal.languages.model.base.definitions.DataDescription;

import de.evoal.languages.model.execution.impl.NamedVariableImpl;
import de.evoal.languages.model.mll.MllPackage;
import de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition;
import de.evoal.languages.model.mll.SurrogateDefinition;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Surrogate Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.impl.SurrogateDefinitionImpl#getFunctions <em>Functions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SurrogateDefinitionImpl extends NamedVariableImpl implements SurrogateDefinition {
	/**
	 * The cached value of the '{@link #getFunctions() <em>Functions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<PartialSurrogateFunctionDefinition> functions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SurrogateDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MllPackage.Literals.SURROGATE_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PartialSurrogateFunctionDefinition> getFunctions() {
		if (functions == null) {
			functions = new EObjectContainmentEList<PartialSurrogateFunctionDefinition>(PartialSurrogateFunctionDefinition.class, this, MllPackage.SURROGATE_DEFINITION__FUNCTIONS);
		}
		return functions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataDescription> getInputs() {
				final EList<DataDescription> result = new BasicEList<>();
				final Set<DataDescription> collection = new HashSet<>();
				
				getFunctions().stream()
					.flatMap(d -> d.getInputs().stream())
					.filter(d -> !collection.contains(d))
					.peek(collection::add)
					.forEach(result::add);
				
				return result;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataDescription> getOutputs() {
				final EList<DataDescription> result = new BasicEList<>();
				final Set<DataDescription> collection = new HashSet<>();
				
				getFunctions().stream()
					.flatMap(d -> d.getOutputs().stream())
					.filter(d -> !collection.contains(d))
					.peek(collection::add)
					.forEach(result::add);
				
				return result;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MllPackage.SURROGATE_DEFINITION__FUNCTIONS:
				return ((InternalEList<?>)getFunctions()).basicRemove(otherEnd, msgs);
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
			case MllPackage.SURROGATE_DEFINITION__FUNCTIONS:
				return getFunctions();
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
			case MllPackage.SURROGATE_DEFINITION__FUNCTIONS:
				getFunctions().clear();
				getFunctions().addAll((Collection<? extends PartialSurrogateFunctionDefinition>)newValue);
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
			case MllPackage.SURROGATE_DEFINITION__FUNCTIONS:
				getFunctions().clear();
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
			case MllPackage.SURROGATE_DEFINITION__FUNCTIONS:
				return functions != null && !functions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SurrogateDefinitionImpl
