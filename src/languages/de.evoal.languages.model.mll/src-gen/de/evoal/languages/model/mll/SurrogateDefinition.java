/**
 */
package de.evoal.languages.model.mll;

import de.evoal.languages.model.ddl.DataDescription;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Surrogate Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.SurrogateDefinition#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.SurrogateDefinition#getInputs <em>Inputs</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.SurrogateDefinition#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.SurrogateDefinition#getLayers <em>Layers</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.mll.MllPackage#getSurrogateDefinition()
 * @model
 * @generated
 */
public interface SurrogateDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.evoal.languages.model.mll.MllPackage#getSurrogateDefinition_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.SurrogateDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link de.evoal.languages.model.ddl.DataDescription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getSurrogateDefinition_Inputs()
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
	 * @see de.evoal.languages.model.mll.MllPackage#getSurrogateDefinition_Outputs()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<DataDescription> getOutputs();

	/**
	 * Returns the value of the '<em><b>Layers</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.mll.SurrogateLayer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layers</em>' containment reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getSurrogateDefinition_Layers()
	 * @model containment="true" required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<SurrogateLayer> getLayers();

} // SurrogateDefinition
