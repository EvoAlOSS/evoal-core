/**
 */
package de.evoal.languages.model.ddl;

import de.evoal.languages.model.base.Expression;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ddl.DataDescription#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.DataDescription#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.DataDescription#getRepresentation <em>Representation</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ddl.DdlPackage#getDataDescription()
 * @model abstract="true"
 * @generated
 */
public interface DataDescription extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of the described data.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataDescription_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ddl.DataDescription#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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

	/**
	 * Returns the value of the '<em><b>Representation</b></em>' attribute.
	 * The default value is <code>"real"</code>.
	 * The literals are from the enumeration {@link de.evoal.languages.model.ddl.RepresentationType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representation</em>' attribute.
	 * @see de.evoal.languages.model.ddl.RepresentationType
	 * @see #setRepresentation(RepresentationType)
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataDescription_Representation()
	 * @model default="real" required="true"
	 * @generated
	 */
	RepresentationType getRepresentation();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ddl.DataDescription#getRepresentation <em>Representation</em>}' attribute.
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

} // DataDescription
