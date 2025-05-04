/**
 */
package de.evoal.languages.model.base.definitions.impl;

import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.DefinitionsPackage;

import de.evoal.languages.model.base.expressions.Expression;

import de.evoal.languages.model.base.types.Type;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.definitions.impl.AttributeDefinitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.definitions.impl.AttributeDefinitionImpl#getInitialisation <em>Initialisation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeDefinitionImpl extends DefinitionImpl implements AttributeDefinition {
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
		return DefinitionsPackage.Literals.ATTRIBUTE_DEFINITION;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DefinitionsPackage.ATTRIBUTE_DEFINITION__TYPE, oldType, newType);
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
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DefinitionsPackage.ATTRIBUTE_DEFINITION__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DefinitionsPackage.ATTRIBUTE_DEFINITION__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionsPackage.ATTRIBUTE_DEFINITION__TYPE, newType, newType));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DefinitionsPackage.ATTRIBUTE_DEFINITION__INITIALISATION, oldInitialisation, newInitialisation);
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
				msgs = ((InternalEObject)initialisation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DefinitionsPackage.ATTRIBUTE_DEFINITION__INITIALISATION, null, msgs);
			if (newInitialisation != null)
				msgs = ((InternalEObject)newInitialisation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DefinitionsPackage.ATTRIBUTE_DEFINITION__INITIALISATION, null, msgs);
			msgs = basicSetInitialisation(newInitialisation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionsPackage.ATTRIBUTE_DEFINITION__INITIALISATION, newInitialisation, newInitialisation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DefinitionsPackage.ATTRIBUTE_DEFINITION__TYPE:
				return basicSetType(null, msgs);
			case DefinitionsPackage.ATTRIBUTE_DEFINITION__INITIALISATION:
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
			case DefinitionsPackage.ATTRIBUTE_DEFINITION__TYPE:
				return getType();
			case DefinitionsPackage.ATTRIBUTE_DEFINITION__INITIALISATION:
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
			case DefinitionsPackage.ATTRIBUTE_DEFINITION__TYPE:
				setType((Type)newValue);
				return;
			case DefinitionsPackage.ATTRIBUTE_DEFINITION__INITIALISATION:
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
			case DefinitionsPackage.ATTRIBUTE_DEFINITION__TYPE:
				setType((Type)null);
				return;
			case DefinitionsPackage.ATTRIBUTE_DEFINITION__INITIALISATION:
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
			case DefinitionsPackage.ATTRIBUTE_DEFINITION__TYPE:
				return type != null;
			case DefinitionsPackage.ATTRIBUTE_DEFINITION__INITIALISATION:
				return initialisation != null;
		}
		return super.eIsSet(featureID);
	}

} //AttributeDefinitionImpl
