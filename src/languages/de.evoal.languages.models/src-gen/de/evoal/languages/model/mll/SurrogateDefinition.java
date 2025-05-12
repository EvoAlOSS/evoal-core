/**
 */
package de.evoal.languages.model.mll;

import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.execution.NamedVariable;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Surrogate Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.SurrogateDefinition#getFunctions <em>Functions</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.mll.MllPackage#getSurrogateDefinition()
 * @model
 * @generated
 */
public interface SurrogateDefinition extends NamedVariable {
	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getSurrogateDefinition_Functions()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<PartialSurrogateFunctionDefinition> getFunctions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<DataDescription> getInputs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<DataDescription> getOutputs();

} // SurrogateDefinition
