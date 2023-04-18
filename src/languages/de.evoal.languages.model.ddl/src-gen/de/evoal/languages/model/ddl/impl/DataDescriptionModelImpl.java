/**
 */
package de.evoal.languages.model.ddl.impl;

import de.evoal.languages.model.base.Expression;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.DataDescriptionModel;
import de.evoal.languages.model.ddl.DataTypeDefinition;
import de.evoal.languages.model.ddl.DdlPackage;

import de.evoal.languages.model.ddl.Use;
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
 * An implementation of the model object '<em><b>Data Description Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ddl.impl.DataDescriptionModelImpl#getUses <em>Uses</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.impl.DataDescriptionModelImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.impl.DataDescriptionModelImpl#getDescriptions <em>Descriptions</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.impl.DataDescriptionModelImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataDescriptionModelImpl extends MinimalEObjectImpl.Container implements DataDescriptionModel {
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
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<DataTypeDefinition> types;

	/**
	 * The cached value of the '{@link #getDescriptions() <em>Descriptions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptions()
	 * @generated
	 * @ordered
	 */
	protected EList<DataDescription> descriptions;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> constraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataDescriptionModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DdlPackage.Literals.DATA_DESCRIPTION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Use> getUses() {
		if (uses == null) {
			uses = new EObjectContainmentEList<Use>(Use.class, this, DdlPackage.DATA_DESCRIPTION_MODEL__USES);
		}
		return uses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataTypeDefinition> getTypes() {
		if (types == null) {
			types = new EObjectContainmentEList<DataTypeDefinition>(DataTypeDefinition.class, this, DdlPackage.DATA_DESCRIPTION_MODEL__TYPES);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataDescription> getDescriptions() {
		if (descriptions == null) {
			descriptions = new EObjectContainmentEList<DataDescription>(DataDescription.class, this, DdlPackage.DATA_DESCRIPTION_MODEL__DESCRIPTIONS);
		}
		return descriptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Expression> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<Expression>(Expression.class, this, DdlPackage.DATA_DESCRIPTION_MODEL__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DdlPackage.DATA_DESCRIPTION_MODEL__USES:
				return ((InternalEList<?>)getUses()).basicRemove(otherEnd, msgs);
			case DdlPackage.DATA_DESCRIPTION_MODEL__TYPES:
				return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
			case DdlPackage.DATA_DESCRIPTION_MODEL__DESCRIPTIONS:
				return ((InternalEList<?>)getDescriptions()).basicRemove(otherEnd, msgs);
			case DdlPackage.DATA_DESCRIPTION_MODEL__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
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
			case DdlPackage.DATA_DESCRIPTION_MODEL__USES:
				return getUses();
			case DdlPackage.DATA_DESCRIPTION_MODEL__TYPES:
				return getTypes();
			case DdlPackage.DATA_DESCRIPTION_MODEL__DESCRIPTIONS:
				return getDescriptions();
			case DdlPackage.DATA_DESCRIPTION_MODEL__CONSTRAINTS:
				return getConstraints();
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
			case DdlPackage.DATA_DESCRIPTION_MODEL__USES:
				getUses().clear();
				getUses().addAll((Collection<? extends Use>)newValue);
				return;
			case DdlPackage.DATA_DESCRIPTION_MODEL__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends DataTypeDefinition>)newValue);
				return;
			case DdlPackage.DATA_DESCRIPTION_MODEL__DESCRIPTIONS:
				getDescriptions().clear();
				getDescriptions().addAll((Collection<? extends DataDescription>)newValue);
				return;
			case DdlPackage.DATA_DESCRIPTION_MODEL__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Expression>)newValue);
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
			case DdlPackage.DATA_DESCRIPTION_MODEL__USES:
				getUses().clear();
				return;
			case DdlPackage.DATA_DESCRIPTION_MODEL__TYPES:
				getTypes().clear();
				return;
			case DdlPackage.DATA_DESCRIPTION_MODEL__DESCRIPTIONS:
				getDescriptions().clear();
				return;
			case DdlPackage.DATA_DESCRIPTION_MODEL__CONSTRAINTS:
				getConstraints().clear();
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
			case DdlPackage.DATA_DESCRIPTION_MODEL__USES:
				return uses != null && !uses.isEmpty();
			case DdlPackage.DATA_DESCRIPTION_MODEL__TYPES:
				return types != null && !types.isEmpty();
			case DdlPackage.DATA_DESCRIPTION_MODEL__DESCRIPTIONS:
				return descriptions != null && !descriptions.isEmpty();
			case DdlPackage.DATA_DESCRIPTION_MODEL__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataDescriptionModelImpl
