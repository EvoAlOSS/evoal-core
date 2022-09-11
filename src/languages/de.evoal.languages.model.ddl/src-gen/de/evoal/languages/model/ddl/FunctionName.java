/**
 */
package de.evoal.languages.model.ddl;

import de.evoal.languages.model.dl.FunctionDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ddl.FunctionName#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ddl.DdlPackage#getFunctionName()
 * @model
 * @generated
 */
public interface FunctionName extends de.evoal.languages.model.el.FunctionName {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(FunctionDefinition)
	 * @see de.evoal.languages.model.ddl.DdlPackage#getFunctionName_Definition()
	 * @model required="true"
	 * @generated
	 */
	FunctionDefinition getDefinition();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ddl.FunctionName#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(FunctionDefinition value);

} // FunctionName
