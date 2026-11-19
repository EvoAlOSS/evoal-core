/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.memory.impl;

import de.evoal.models.v202704.optimisation.memory.MemoryPackage;
import de.evoal.models.v202704.optimisation.memory.PropertyDefinition;
import de.evoal.models.v202704.optimisation.memory.PropertyScope;
import de.evoal.models.v202704.optimisation.memory.PropertyValueType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.PropertyDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.PropertyDefinitionImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.PropertyDefinitionImpl#getValueType <em>Value Type</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.PropertyDefinitionImpl#isList <em>List</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.PropertyDefinitionImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyDefinitionImpl extends MinimalEObjectImpl.Container implements PropertyDefinition {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected static final PropertyScope SCOPE_EDEFAULT = PropertyScope.INDIVIDUAL;

	/**
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected PropertyScope scope = SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected static final PropertyValueType VALUE_TYPE_EDEFAULT = PropertyValueType.INTEGER;

	/**
	 * The cached value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected PropertyValueType valueType = VALUE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isList() <em>List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isList()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LIST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isList() <em>List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isList()
	 * @generated
	 * @ordered
	 */
	protected boolean list = LIST_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MemoryPackage.Literals.PROPERTY_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MemoryPackage.PROPERTY_DEFINITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyScope getScope() {
		return scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScope(PropertyScope newScope) {
		PropertyScope oldScope = scope;
		scope = newScope == null ? SCOPE_EDEFAULT : newScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MemoryPackage.PROPERTY_DEFINITION__SCOPE, oldScope, scope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyValueType getValueType() {
		return valueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValueType(PropertyValueType newValueType) {
		PropertyValueType oldValueType = valueType;
		valueType = newValueType == null ? VALUE_TYPE_EDEFAULT : newValueType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MemoryPackage.PROPERTY_DEFINITION__VALUE_TYPE, oldValueType, valueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isList() {
		return list;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setList(boolean newList) {
		boolean oldList = list;
		list = newList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MemoryPackage.PROPERTY_DEFINITION__LIST, oldList, list));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MemoryPackage.PROPERTY_DEFINITION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MemoryPackage.PROPERTY_DEFINITION__NAME:
				return getName();
			case MemoryPackage.PROPERTY_DEFINITION__SCOPE:
				return getScope();
			case MemoryPackage.PROPERTY_DEFINITION__VALUE_TYPE:
				return getValueType();
			case MemoryPackage.PROPERTY_DEFINITION__LIST:
				return isList();
			case MemoryPackage.PROPERTY_DEFINITION__DESCRIPTION:
				return getDescription();
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
			case MemoryPackage.PROPERTY_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case MemoryPackage.PROPERTY_DEFINITION__SCOPE:
				setScope((PropertyScope)newValue);
				return;
			case MemoryPackage.PROPERTY_DEFINITION__VALUE_TYPE:
				setValueType((PropertyValueType)newValue);
				return;
			case MemoryPackage.PROPERTY_DEFINITION__LIST:
				setList((Boolean)newValue);
				return;
			case MemoryPackage.PROPERTY_DEFINITION__DESCRIPTION:
				setDescription((String)newValue);
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
			case MemoryPackage.PROPERTY_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MemoryPackage.PROPERTY_DEFINITION__SCOPE:
				setScope(SCOPE_EDEFAULT);
				return;
			case MemoryPackage.PROPERTY_DEFINITION__VALUE_TYPE:
				setValueType(VALUE_TYPE_EDEFAULT);
				return;
			case MemoryPackage.PROPERTY_DEFINITION__LIST:
				setList(LIST_EDEFAULT);
				return;
			case MemoryPackage.PROPERTY_DEFINITION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
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
			case MemoryPackage.PROPERTY_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MemoryPackage.PROPERTY_DEFINITION__SCOPE:
				return scope != SCOPE_EDEFAULT;
			case MemoryPackage.PROPERTY_DEFINITION__VALUE_TYPE:
				return valueType != VALUE_TYPE_EDEFAULT;
			case MemoryPackage.PROPERTY_DEFINITION__LIST:
				return list != LIST_EDEFAULT;
			case MemoryPackage.PROPERTY_DEFINITION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", scope: ");
		result.append(scope);
		result.append(", valueType: ");
		result.append(valueType);
		result.append(", list: ");
		result.append(list);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //PropertyDefinitionImpl
