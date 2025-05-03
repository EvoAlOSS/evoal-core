/**
 */
package de.evoal.languages.model.ddl;

import de.evoal.languages.model.base.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * Make defined data to types of the type hierarchy.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ddl.DataType#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ddl.DdlPackage#getDataType()
 * @model
 * @generated
 */
public interface DataType extends Type {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(DataDescription)
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataType_Definition()
	 * @model required="true"
	 * @generated
	 */
	DataDescription getDefinition();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ddl.DataType#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(DataDescription value);

} // DataType
