/**
 */
package de.evoal.languages.model.ddl;

import de.evoal.languages.model.base.Definition;
import de.evoal.languages.model.base.Expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * Base class for all data descriptions.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ddl.DataDescription#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ddl.DdlPackage#getDataDescription()
 * @model abstract="true"
 * @generated
 */
public interface DataDescription extends Definition {
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of constraints for this data description
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataDescription_Constraints()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Expression> getConstraints();

} // DataDescription
