/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.dynamic;

import de.evoal.languages.model.base.definitions.AttributeDefinition;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.dynamic.AttributeMapping#getSource <em>Source</em>}</li>
 *   <li>{@link de.evoal.languages.model.dynamic.AttributeMapping#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.dynamic.DynamicPackage#getAttributeMapping()
 * @model
 * @generated
 */
public interface AttributeMapping extends Mapping {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(AttributeDefinition)
	 * @see de.evoal.languages.model.dynamic.DynamicPackage#getAttributeMapping_Source()
	 * @model required="true"
	 * @generated
	 */
	AttributeDefinition getSource();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.dynamic.AttributeMapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(AttributeDefinition value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EStructuralFeature)
	 * @see de.evoal.languages.model.dynamic.DynamicPackage#getAttributeMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getTarget();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.dynamic.AttributeMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EStructuralFeature value);

} // AttributeMapping
