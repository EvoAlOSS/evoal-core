/**
 */
package de.evoal.languages.model.mll;

import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.ddl.DataDescription;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partial Surrogate Function Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition#getInputs <em>Inputs</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition#getOutputs <em>Outputs</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.mll.MllPackage#getPartialSurrogateFunctionDefinition()
 * @model
 * @generated
 */
public interface PartialSurrogateFunctionDefinition extends Instance {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link de.evoal.languages.model.ddl.DataDescription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getPartialSurrogateFunctionDefinition_Inputs()
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
	 * @see de.evoal.languages.model.mll.MllPackage#getPartialSurrogateFunctionDefinition_Outputs()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<DataDescription> getOutputs();

} // PartialSurrogateFunctionDefinition
