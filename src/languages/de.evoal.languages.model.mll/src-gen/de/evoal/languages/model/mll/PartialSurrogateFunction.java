/**
 */
package de.evoal.languages.model.mll;

import de.evoal.languages.model.ddl.DataDescription;

import de.evoal.languages.model.dl.TypeDefinition;

import de.evoal.languages.model.instance.Attribute;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partial Surrogate Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.PartialSurrogateFunction#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.PartialSurrogateFunction#getInputs <em>Inputs</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.PartialSurrogateFunction#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.PartialSurrogateFunction#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.mll.MllPackage#getPartialSurrogateFunction()
 * @model
 * @generated
 */
public interface PartialSurrogateFunction extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' reference.
	 * @see #setName(TypeDefinition)
	 * @see de.evoal.languages.model.mll.MllPackage#getPartialSurrogateFunction_Name()
	 * @model required="true"
	 * @generated
	 */
	TypeDefinition getName();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.PartialSurrogateFunction#getName <em>Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(TypeDefinition value);

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link de.evoal.languages.model.ddl.DataDescription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getPartialSurrogateFunction_Inputs()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<DataDescription> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' reference list.
	 * The list contents are of type {@link de.evoal.languages.model.ddl.DataDescription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getPartialSurrogateFunction_Outputs()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<DataDescription> getOutputs();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.instance.Attribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getPartialSurrogateFunction_Parameters()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Attribute> getParameters();

} // PartialSurrogateFunction
