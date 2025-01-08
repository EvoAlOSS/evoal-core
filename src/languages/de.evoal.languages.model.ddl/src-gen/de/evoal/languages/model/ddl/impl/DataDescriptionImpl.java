/**
 */
package de.evoal.languages.model.ddl.impl;

import de.evoal.languages.model.base.Expression;

import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.base.impl.DefinitionImpl;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.DdlPackage;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ddl.impl.DataDescriptionImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.impl.DataDescriptionImpl#getConstraints2 <em>Constraints2</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DataDescriptionImpl extends DefinitionImpl implements DataDescription {
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
	 * The cached value of the '{@link #getConstraints2() <em>Constraints2</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints2()
	 * @generated
	 * @ordered
	 */
	protected EList<Instance> constraints2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DdlPackage.Literals.DATA_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Expression> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<Expression>(Expression.class, this, DdlPackage.DATA_DESCRIPTION__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Instance> getConstraints2() {
		if (constraints2 == null) {
			constraints2 = new EObjectContainmentEList<Instance>(Instance.class, this, DdlPackage.DATA_DESCRIPTION__CONSTRAINTS2);
		}
		return constraints2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DdlPackage.DATA_DESCRIPTION__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case DdlPackage.DATA_DESCRIPTION__CONSTRAINTS2:
				return ((InternalEList<?>)getConstraints2()).basicRemove(otherEnd, msgs);
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
			case DdlPackage.DATA_DESCRIPTION__CONSTRAINTS:
				return getConstraints();
			case DdlPackage.DATA_DESCRIPTION__CONSTRAINTS2:
				return getConstraints2();
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
			case DdlPackage.DATA_DESCRIPTION__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Expression>)newValue);
				return;
			case DdlPackage.DATA_DESCRIPTION__CONSTRAINTS2:
				getConstraints2().clear();
				getConstraints2().addAll((Collection<? extends Instance>)newValue);
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
			case DdlPackage.DATA_DESCRIPTION__CONSTRAINTS:
				getConstraints().clear();
				return;
			case DdlPackage.DATA_DESCRIPTION__CONSTRAINTS2:
				getConstraints2().clear();
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
			case DdlPackage.DATA_DESCRIPTION__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case DdlPackage.DATA_DESCRIPTION__CONSTRAINTS2:
				return constraints2 != null && !constraints2.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataDescriptionImpl
