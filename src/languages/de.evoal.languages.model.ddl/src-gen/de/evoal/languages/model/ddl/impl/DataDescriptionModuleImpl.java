/**
 */
package de.evoal.languages.model.ddl.impl;

import de.evoal.languages.model.base.Import;

import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.expressions.Expression;

import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.languages.model.ddl.DdlPackage;

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
 * An implementation of the model object '<em><b>Data Description Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ddl.impl.DataDescriptionModuleImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.impl.DataDescriptionModuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.impl.DataDescriptionModuleImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.impl.DataDescriptionModuleImpl#getDescriptions <em>Descriptions</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.impl.DataDescriptionModuleImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataDescriptionModuleImpl extends MinimalEObjectImpl.Container implements DataDescriptionModule {
	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<Import> imports;

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
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Definition> types;

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
	protected DataDescriptionModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DdlPackage.Literals.DATA_DESCRIPTION_MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Import> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<Import>(Import.class, this, DdlPackage.DATA_DESCRIPTION_MODULE__IMPORTS);
		}
		return imports;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DdlPackage.DATA_DESCRIPTION_MODULE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Definition> getTypes() {
		if (types == null) {
			types = new EObjectContainmentEList<Definition>(Definition.class, this, DdlPackage.DATA_DESCRIPTION_MODULE__TYPES);
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
			descriptions = new EObjectContainmentEList<DataDescription>(DataDescription.class, this, DdlPackage.DATA_DESCRIPTION_MODULE__DESCRIPTIONS);
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
			constraints = new EObjectContainmentEList<Expression>(Expression.class, this, DdlPackage.DATA_DESCRIPTION_MODULE__CONSTRAINTS);
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
			case DdlPackage.DATA_DESCRIPTION_MODULE__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case DdlPackage.DATA_DESCRIPTION_MODULE__TYPES:
				return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
			case DdlPackage.DATA_DESCRIPTION_MODULE__DESCRIPTIONS:
				return ((InternalEList<?>)getDescriptions()).basicRemove(otherEnd, msgs);
			case DdlPackage.DATA_DESCRIPTION_MODULE__CONSTRAINTS:
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
			case DdlPackage.DATA_DESCRIPTION_MODULE__IMPORTS:
				return getImports();
			case DdlPackage.DATA_DESCRIPTION_MODULE__NAME:
				return getName();
			case DdlPackage.DATA_DESCRIPTION_MODULE__TYPES:
				return getTypes();
			case DdlPackage.DATA_DESCRIPTION_MODULE__DESCRIPTIONS:
				return getDescriptions();
			case DdlPackage.DATA_DESCRIPTION_MODULE__CONSTRAINTS:
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
			case DdlPackage.DATA_DESCRIPTION_MODULE__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends Import>)newValue);
				return;
			case DdlPackage.DATA_DESCRIPTION_MODULE__NAME:
				setName((String)newValue);
				return;
			case DdlPackage.DATA_DESCRIPTION_MODULE__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends Definition>)newValue);
				return;
			case DdlPackage.DATA_DESCRIPTION_MODULE__DESCRIPTIONS:
				getDescriptions().clear();
				getDescriptions().addAll((Collection<? extends DataDescription>)newValue);
				return;
			case DdlPackage.DATA_DESCRIPTION_MODULE__CONSTRAINTS:
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
			case DdlPackage.DATA_DESCRIPTION_MODULE__IMPORTS:
				getImports().clear();
				return;
			case DdlPackage.DATA_DESCRIPTION_MODULE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DdlPackage.DATA_DESCRIPTION_MODULE__TYPES:
				getTypes().clear();
				return;
			case DdlPackage.DATA_DESCRIPTION_MODULE__DESCRIPTIONS:
				getDescriptions().clear();
				return;
			case DdlPackage.DATA_DESCRIPTION_MODULE__CONSTRAINTS:
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
			case DdlPackage.DATA_DESCRIPTION_MODULE__IMPORTS:
				return imports != null && !imports.isEmpty();
			case DdlPackage.DATA_DESCRIPTION_MODULE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DdlPackage.DATA_DESCRIPTION_MODULE__TYPES:
				return types != null && !types.isEmpty();
			case DdlPackage.DATA_DESCRIPTION_MODULE__DESCRIPTIONS:
				return descriptions != null && !descriptions.isEmpty();
			case DdlPackage.DATA_DESCRIPTION_MODULE__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
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

} //DataDescriptionModuleImpl
