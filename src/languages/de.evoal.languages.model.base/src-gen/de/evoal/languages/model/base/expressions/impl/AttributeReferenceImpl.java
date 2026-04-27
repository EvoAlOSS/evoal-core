/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.base.expressions.impl;

import de.evoal.languages.model.base.expressions.AttributeReference;
import de.evoal.languages.model.base.expressions.ExpressionsPackage;
import de.evoal.languages.model.base.expressions.SelfReference;
import de.evoal.languages.model.base.expressions.ValueDefinitionReference;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.expressions.impl.AttributeReferenceImpl#getSelf <em>Self</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.expressions.impl.AttributeReferenceImpl#getChain <em>Chain</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeReferenceImpl extends ReadExpressionImpl implements AttributeReference {
	/**
	 * The cached value of the '{@link #getSelf() <em>Self</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelf()
	 * @generated
	 * @ordered
	 */
	protected SelfReference self;

	/**
	 * The cached value of the '{@link #getChain() <em>Chain</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChain()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueDefinitionReference> chain;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.ATTRIBUTE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SelfReference getSelf() {
		return self;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSelf(SelfReference newSelf, NotificationChain msgs) {
		SelfReference oldSelf = self;
		self = newSelf;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.ATTRIBUTE_REFERENCE__SELF, oldSelf, newSelf);
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
	public void setSelf(SelfReference newSelf) {
		if (newSelf != self) {
			NotificationChain msgs = null;
			if (self != null)
				msgs = ((InternalEObject)self).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.ATTRIBUTE_REFERENCE__SELF, null, msgs);
			if (newSelf != null)
				msgs = ((InternalEObject)newSelf).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.ATTRIBUTE_REFERENCE__SELF, null, msgs);
			msgs = basicSetSelf(newSelf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.ATTRIBUTE_REFERENCE__SELF, newSelf, newSelf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ValueDefinitionReference> getChain() {
		if (chain == null) {
			chain = new EObjectContainmentEList<ValueDefinitionReference>(ValueDefinitionReference.class, this, ExpressionsPackage.ATTRIBUTE_REFERENCE__CHAIN);
		}
		return chain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.ATTRIBUTE_REFERENCE__SELF:
				return basicSetSelf(null, msgs);
			case ExpressionsPackage.ATTRIBUTE_REFERENCE__CHAIN:
				return ((InternalEList<?>)getChain()).basicRemove(otherEnd, msgs);
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
			case ExpressionsPackage.ATTRIBUTE_REFERENCE__SELF:
				return getSelf();
			case ExpressionsPackage.ATTRIBUTE_REFERENCE__CHAIN:
				return getChain();
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
			case ExpressionsPackage.ATTRIBUTE_REFERENCE__SELF:
				setSelf((SelfReference)newValue);
				return;
			case ExpressionsPackage.ATTRIBUTE_REFERENCE__CHAIN:
				getChain().clear();
				getChain().addAll((Collection<? extends ValueDefinitionReference>)newValue);
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
			case ExpressionsPackage.ATTRIBUTE_REFERENCE__SELF:
				setSelf((SelfReference)null);
				return;
			case ExpressionsPackage.ATTRIBUTE_REFERENCE__CHAIN:
				getChain().clear();
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
			case ExpressionsPackage.ATTRIBUTE_REFERENCE__SELF:
				return self != null;
			case ExpressionsPackage.ATTRIBUTE_REFERENCE__CHAIN:
				return chain != null && !chain.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AttributeReferenceImpl
