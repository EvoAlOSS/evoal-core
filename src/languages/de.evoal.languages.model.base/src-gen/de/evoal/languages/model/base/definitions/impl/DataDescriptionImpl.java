/**
 */
package de.evoal.languages.model.base.definitions.impl;

import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.DefinitionsPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class DataDescriptionImpl extends DataTypeDefinitionImpl implements DataDescription {
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
		return DefinitionsPackage.Literals.DATA_DESCRIPTION;
	}

} //DataDescriptionImpl
