/**
 */
package de.evoal.languages.model.base;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An attribute (similar to a Java field).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.AttributeDefinition#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.AttributeDefinition#getType <em>Type</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.AttributeDefinition#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.AttributeDefinition#getInitialisation <em>Initialisation</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.BasePackage#getAttributeDefinition()
 * @model
 * @generated
 */
public interface AttributeDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.Instance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Possible constraints for the attribute
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see de.evoal.languages.model.base.BasePackage#getAttributeDefinition_Constraints()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Instance> getConstraints();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Type of the attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(Type)
	 * @see de.evoal.languages.model.base.BasePackage#getAttributeDefinition_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.AttributeDefinition#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The actual attribute name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.evoal.languages.model.base.BasePackage#getAttributeDefinition_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.AttributeDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Initialisation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A default value for the attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Initialisation</em>' containment reference.
	 * @see #setInitialisation(Expression)
	 * @see de.evoal.languages.model.base.BasePackage#getAttributeDefinition_Initialisation()
	 * @model containment="true"
	 * @generated
	 */
	Expression getInitialisation();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.AttributeDefinition#getInitialisation <em>Initialisation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialisation</em>' containment reference.
	 * @see #getInitialisation()
	 * @generated
	 */
	void setInitialisation(Expression value);

} // AttributeDefinition
