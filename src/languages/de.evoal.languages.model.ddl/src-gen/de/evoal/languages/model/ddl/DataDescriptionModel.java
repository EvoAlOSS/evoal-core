/**
 */
package de.evoal.languages.model.ddl;

import de.evoal.languages.model.base.Expression;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Description Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ddl.DataDescriptionModel#getUses <em>Uses</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.DataDescriptionModel#getTypes <em>Types</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.DataDescriptionModel#getDescriptions <em>Descriptions</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.DataDescriptionModel#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ddl.DdlPackage#getDataDescriptionModel()
 * @model
 * @generated
 */
public interface DataDescriptionModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Uses</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.ddl.Use}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uses</em>' containment reference list.
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataDescriptionModel_Uses()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Use> getUses();

	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.ddl.DataTypeDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataDescriptionModel_Types()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<DataTypeDefinition> getTypes();

	/**
	 * Returns the value of the '<em><b>Descriptions</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.ddl.DataDescription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptions</em>' containment reference list.
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataDescriptionModel_Descriptions()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<DataDescription> getDescriptions();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of global constraints
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataDescriptionModel_Constraints()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Expression> getConstraints();

} // DataDescriptionModel
