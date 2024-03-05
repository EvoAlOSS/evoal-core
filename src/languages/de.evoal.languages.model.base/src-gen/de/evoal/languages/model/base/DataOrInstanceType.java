/**
 */
package de.evoal.languages.model.base;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Or Instance Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * For rules where it is allowed to specify data or an instance type.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.DataOrInstanceType#getInstance <em>Instance</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.BasePackage#getDataOrInstanceType()
 * @model
 * @generated
 */
public interface DataOrInstanceType extends Type {
	/**
	 * Returns the value of the '<em><b>Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance</em>' containment reference.
	 * @see #setInstance(InstanceType)
	 * @see de.evoal.languages.model.base.BasePackage#getDataOrInstanceType_Instance()
	 * @model containment="true"
	 * @generated
	 */
	InstanceType getInstance();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.DataOrInstanceType#getInstance <em>Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' containment reference.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(InstanceType value);

} // DataOrInstanceType
