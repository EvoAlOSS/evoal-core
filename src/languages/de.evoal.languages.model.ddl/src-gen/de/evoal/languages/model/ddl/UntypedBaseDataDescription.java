/**
 */
package de.evoal.languages.model.ddl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Untyped Base Data Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An untyped data description.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ddl.UntypedBaseDataDescription#getScale <em>Scale</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ddl.DdlPackage#getUntypedBaseDataDescription()
 * @model
 * @generated
 */
public interface UntypedBaseDataDescription extends BaseDataDescription {
	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * The literals are from the enumeration {@link de.evoal.languages.model.ddl.ScaleType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Scale of the data description.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see de.evoal.languages.model.ddl.ScaleType
	 * @see #setScale(ScaleType)
	 * @see de.evoal.languages.model.ddl.DdlPackage#getUntypedBaseDataDescription_Scale()
	 * @model transient="true"
	 * @generated
	 */
	ScaleType getScale();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ddl.UntypedBaseDataDescription#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see de.evoal.languages.model.ddl.ScaleType
	 * @see #getScale()
	 * @generated
	 */
	void setScale(ScaleType value);

} // UntypedBaseDataDescription
