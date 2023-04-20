/**
 */
package de.evoal.languages.model.mll.impl;

import de.evoal.languages.model.base.Import;
import de.evoal.languages.model.mll.MachineLearningConfiguration;
import de.evoal.languages.model.mll.MllPackage;
import de.evoal.languages.model.mll.Statement;
import de.evoal.languages.model.mll.SurrogateDefinition;
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
 * An implementation of the model object '<em><b>Machine Learning Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.impl.MachineLearningConfigurationImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.MachineLearningConfigurationImpl#getDefinitions <em>Definitions</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.MachineLearningConfigurationImpl#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MachineLearningConfigurationImpl extends MinimalEObjectImpl.Container implements MachineLearningConfiguration {
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
	 * The cached value of the '{@link #getDefinitions() <em>Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<SurrogateDefinition> definitions;

	/**
	 * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> statements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MachineLearningConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MllPackage.Literals.MACHINE_LEARNING_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Import> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<Import>(Import.class, this, MllPackage.MACHINE_LEARNING_CONFIGURATION__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SurrogateDefinition> getDefinitions() {
		if (definitions == null) {
			definitions = new EObjectContainmentEList<SurrogateDefinition>(SurrogateDefinition.class, this, MllPackage.MACHINE_LEARNING_CONFIGURATION__DEFINITIONS);
		}
		return definitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Statement> getStatements() {
		if (statements == null) {
			statements = new EObjectContainmentEList<Statement>(Statement.class, this, MllPackage.MACHINE_LEARNING_CONFIGURATION__STATEMENTS);
		}
		return statements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__DEFINITIONS:
				return ((InternalEList<?>)getDefinitions()).basicRemove(otherEnd, msgs);
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__STATEMENTS:
				return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
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
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__IMPORTS:
				return getImports();
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__DEFINITIONS:
				return getDefinitions();
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__STATEMENTS:
				return getStatements();
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
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends Import>)newValue);
				return;
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__DEFINITIONS:
				getDefinitions().clear();
				getDefinitions().addAll((Collection<? extends SurrogateDefinition>)newValue);
				return;
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__STATEMENTS:
				getStatements().clear();
				getStatements().addAll((Collection<? extends Statement>)newValue);
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
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__IMPORTS:
				getImports().clear();
				return;
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__DEFINITIONS:
				getDefinitions().clear();
				return;
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__STATEMENTS:
				getStatements().clear();
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
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__IMPORTS:
				return imports != null && !imports.isEmpty();
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__DEFINITIONS:
				return definitions != null && !definitions.isEmpty();
			case MllPackage.MACHINE_LEARNING_CONFIGURATION__STATEMENTS:
				return statements != null && !statements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MachineLearningConfigurationImpl
