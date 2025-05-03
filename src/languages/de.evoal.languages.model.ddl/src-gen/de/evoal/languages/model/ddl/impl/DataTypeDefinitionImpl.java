/**
 */
package de.evoal.languages.model.ddl.impl;

import de.evoal.languages.model.base.Expression;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.ddl.DataTypeDefinition;
import de.evoal.languages.model.ddl.DdlPackage;
import de.evoal.languages.model.ddl.ScaleType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ddl.impl.DataTypeDefinitionImpl#getScale <em>Scale</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.impl.DataTypeDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.impl.DataTypeDefinitionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.impl.DataTypeDefinitionImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.impl.DataTypeDefinitionImpl#getConstraints2 <em>Constraints2</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DataTypeDefinitionImpl extends MinimalEObjectImpl.Container implements DataTypeDefinition {
	/**
	 * The default value of the '{@link #getScale() <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScale()
	 * @generated
	 * @ordered
	 */
	protected static final ScaleType SCALE_EDEFAULT = ScaleType.NOMINAL;

	/**
	 * The cached value of the '{@link #getScale() <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScale()
	 * @generated
	 * @ordered
	 */
	protected ScaleType scale = SCALE_EDEFAULT;

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
	protected DataTypeDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DdlPackage.Literals.DATA_TYPE_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScaleType getScale() {
		return scale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScale(ScaleType newScale) {
		ScaleType oldScale = scale;
		scale = newScale == null ? SCALE_EDEFAULT : newScale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DdlPackage.DATA_TYPE_DEFINITION__SCALE, oldScale, scale));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DdlPackage.DATA_TYPE_DEFINITION__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DdlPackage.DATA_TYPE_DEFINITION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Expression> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<Expression>(Expression.class, this, DdlPackage.DATA_TYPE_DEFINITION__CONSTRAINTS);
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
			constraints2 = new EObjectContainmentEList<Instance>(Instance.class, this, DdlPackage.DATA_TYPE_DEFINITION__CONSTRAINTS2);
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
			case DdlPackage.DATA_TYPE_DEFINITION__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case DdlPackage.DATA_TYPE_DEFINITION__CONSTRAINTS2:
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
			case DdlPackage.DATA_TYPE_DEFINITION__SCALE:
				return getScale();
			case DdlPackage.DATA_TYPE_DEFINITION__NAME:
				return getName();
			case DdlPackage.DATA_TYPE_DEFINITION__DESCRIPTION:
				return getDescription();
			case DdlPackage.DATA_TYPE_DEFINITION__CONSTRAINTS:
				return getConstraints();
			case DdlPackage.DATA_TYPE_DEFINITION__CONSTRAINTS2:
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
			case DdlPackage.DATA_TYPE_DEFINITION__SCALE:
				setScale((ScaleType)newValue);
				return;
			case DdlPackage.DATA_TYPE_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case DdlPackage.DATA_TYPE_DEFINITION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case DdlPackage.DATA_TYPE_DEFINITION__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Expression>)newValue);
				return;
			case DdlPackage.DATA_TYPE_DEFINITION__CONSTRAINTS2:
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
			case DdlPackage.DATA_TYPE_DEFINITION__SCALE:
				setScale(SCALE_EDEFAULT);
				return;
			case DdlPackage.DATA_TYPE_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DdlPackage.DATA_TYPE_DEFINITION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case DdlPackage.DATA_TYPE_DEFINITION__CONSTRAINTS:
				getConstraints().clear();
				return;
			case DdlPackage.DATA_TYPE_DEFINITION__CONSTRAINTS2:
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
			case DdlPackage.DATA_TYPE_DEFINITION__SCALE:
				return scale != SCALE_EDEFAULT;
			case DdlPackage.DATA_TYPE_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DdlPackage.DATA_TYPE_DEFINITION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case DdlPackage.DATA_TYPE_DEFINITION__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case DdlPackage.DATA_TYPE_DEFINITION__CONSTRAINTS2:
				return constraints2 != null && !constraints2.isEmpty();
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
		result.append(" (scale: ");
		result.append(scale);
		result.append(", name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //DataTypeDefinitionImpl
