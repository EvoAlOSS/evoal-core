/**
 */
package de.evoal.languages.model.base.impl;

import de.evoal.languages.model.base.AttributeDefinition;
import de.evoal.languages.model.base.BasePackage;
import de.evoal.languages.model.base.Expression;
import de.evoal.languages.model.base.Type;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.impl.AttributeDefinitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.impl.AttributeDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.impl.AttributeDefinitionImpl#getInitialisation <em>Initialisation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeDefinitionImpl extends MinimalEObjectImpl.Container implements AttributeDefinition {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

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
	 * The cached value of the '{@link #getInitialisation() <em>Initialisation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialisation()
	 * @generated
	 * @ordered
	 */
	protected Expression initialisation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.ATTRIBUTE_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(Type newType, NotificationChain msgs) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BasePackage.ATTRIBUTE_DEFINITION__TYPE, oldType, newType);
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
	public void setType(Type newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BasePackage.ATTRIBUTE_DEFINITION__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BasePackage.ATTRIBUTE_DEFINITION__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasePackage.ATTRIBUTE_DEFINITION__TYPE, newType, newType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BasePackage.ATTRIBUTE_DEFINITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getInitialisation() {
		return initialisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialisation(Expression newInitialisation, NotificationChain msgs) {
		Expression oldInitialisation = initialisation;
		initialisation = newInitialisation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BasePackage.ATTRIBUTE_DEFINITION__INITIALISATION, oldInitialisation, newInitialisation);
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
	public void setInitialisation(Expression newInitialisation) {
		if (newInitialisation != initialisation) {
			NotificationChain msgs = null;
			if (initialisation != null)
				msgs = ((InternalEObject)initialisation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BasePackage.ATTRIBUTE_DEFINITION__INITIALISATION, null, msgs);
			if (newInitialisation != null)
				msgs = ((InternalEObject)newInitialisation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BasePackage.ATTRIBUTE_DEFINITION__INITIALISATION, null, msgs);
			msgs = basicSetInitialisation(newInitialisation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasePackage.ATTRIBUTE_DEFINITION__INITIALISATION, newInitialisation, newInitialisation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BasePackage.ATTRIBUTE_DEFINITION__TYPE:
				return basicSetType(null, msgs);
			case BasePackage.ATTRIBUTE_DEFINITION__INITIALISATION:
				return basicSetInitialisation(null, msgs);
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
			case BasePackage.ATTRIBUTE_DEFINITION__TYPE:
				return getType();
			case BasePackage.ATTRIBUTE_DEFINITION__NAME:
				return getName();
			case BasePackage.ATTRIBUTE_DEFINITION__INITIALISATION:
				return getInitialisation();
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
			case BasePackage.ATTRIBUTE_DEFINITION__TYPE:
				setType((Type)newValue);
				return;
			case BasePackage.ATTRIBUTE_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case BasePackage.ATTRIBUTE_DEFINITION__INITIALISATION:
				setInitialisation((Expression)newValue);
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
			case BasePackage.ATTRIBUTE_DEFINITION__TYPE:
				setType((Type)null);
				return;
			case BasePackage.ATTRIBUTE_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BasePackage.ATTRIBUTE_DEFINITION__INITIALISATION:
				setInitialisation((Expression)null);
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
			case BasePackage.ATTRIBUTE_DEFINITION__TYPE:
				return type != null;
			case BasePackage.ATTRIBUTE_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BasePackage.ATTRIBUTE_DEFINITION__INITIALISATION:
				return initialisation != null;
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
		result.append(')');
		return result.toString();
	}

} //AttributeDefinitionImpl
