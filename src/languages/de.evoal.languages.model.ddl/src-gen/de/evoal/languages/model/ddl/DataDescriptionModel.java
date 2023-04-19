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
 *   <li>{@link de.evoal.languages.model.ddl.DataDescriptionModel#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.DataDescriptionModel#getImports <em>Imports</em>}</li>
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
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataDescriptionModel_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ddl.DataDescriptionModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.ddl.Import}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataDescriptionModel_Imports()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Import> getImports();

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
