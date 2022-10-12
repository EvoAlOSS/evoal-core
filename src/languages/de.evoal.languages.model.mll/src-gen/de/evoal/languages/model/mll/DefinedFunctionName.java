/**
 */
package de.evoal.languages.model.mll;

import de.evoal.languages.model.dl.FunctionDefinition;

import de.evoal.languages.model.el.FunctionName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Defined Function Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * EL integration to allow calls to defined functions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.DefinedFunctionName#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.mll.MllPackage#getDefinedFunctionName()
 * @model
 * @generated
 */
public interface DefinedFunctionName extends FunctionName {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to the actual function.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(FunctionDefinition)
	 * @see de.evoal.languages.model.mll.MllPackage#getDefinedFunctionName_Definition()
	 * @model required="true"
	 * @generated
	 */
	FunctionDefinition getDefinition();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.DefinedFunctionName#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(FunctionDefinition value);

} // DefinedFunctionName
