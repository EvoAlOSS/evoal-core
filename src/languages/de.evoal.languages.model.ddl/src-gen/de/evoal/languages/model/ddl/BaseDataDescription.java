/**
 */
package de.evoal.languages.model.ddl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Data Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * Base class for all data description using base types.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ddl.BaseDataDescription#getRepresentation <em>Representation</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ddl.DdlPackage#getBaseDataDescription()
 * @model abstract="true"
 * @generated
 */
public interface BaseDataDescription extends DataDescription {
	/**
	 * Returns the value of the '<em><b>Representation</b></em>' attribute.
	 * The default value is <code>"real"</code>.
	 * The literals are from the enumeration {@link de.evoal.languages.model.ddl.RepresentationType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The in-memory representation of the data.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Representation</em>' attribute.
	 * @see de.evoal.languages.model.ddl.RepresentationType
	 * @see #setRepresentation(RepresentationType)
	 * @see de.evoal.languages.model.ddl.DdlPackage#getBaseDataDescription_Representation()
	 * @model default="real" required="true"
	 * @generated
	 */
	RepresentationType getRepresentation();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ddl.BaseDataDescription#getRepresentation <em>Representation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Representation</em>' attribute.
	 * @see de.evoal.languages.model.ddl.RepresentationType
	 * @see #getRepresentation()
	 * @generated
	 */
	void setRepresentation(RepresentationType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the associated scale if existing.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	ScaleType getScale();

} // BaseDataDescription
