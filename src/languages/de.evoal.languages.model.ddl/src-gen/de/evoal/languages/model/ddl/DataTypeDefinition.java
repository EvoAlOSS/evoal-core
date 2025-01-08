/**
 */
package de.evoal.languages.model.ddl;

import de.evoal.languages.model.base.Expression;

import de.evoal.languages.model.base.Instance;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A data type that allows reuse of information.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ddl.DataTypeDefinition#getScale <em>Scale</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.DataTypeDefinition#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.DataTypeDefinition#getDescription <em>Description</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.DataTypeDefinition#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.DataTypeDefinition#getConstraints2 <em>Constraints2</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ddl.DdlPackage#getDataTypeDefinition()
 * @model
 * @generated
 */
public interface DataTypeDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * The literals are from the enumeration {@link de.evoal.languages.model.ddl.ScaleType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Scale of the data type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see de.evoal.languages.model.ddl.ScaleType
	 * @see #setScale(ScaleType)
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataTypeDefinition_Scale()
	 * @model transient="true"
	 * @generated
	 */
	ScaleType getScale();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ddl.DataTypeDefinition#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see de.evoal.languages.model.ddl.ScaleType
	 * @see #getScale()
	 * @generated
	 */
	void setScale(ScaleType value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of the data type, e.g., Newton.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataTypeDefinition_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ddl.DataTypeDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optional description of the data type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataTypeDefinition_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ddl.DataTypeDefinition#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of constraints for this data type
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataTypeDefinition_Constraints()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Expression> getConstraints();

	/**
	 * Returns the value of the '<em><b>Constraints2</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.Instance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of constraints for this data type
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constraints2</em>' containment reference list.
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataTypeDefinition_Constraints2()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Instance> getConstraints2();

} // DataTypeDefinition
