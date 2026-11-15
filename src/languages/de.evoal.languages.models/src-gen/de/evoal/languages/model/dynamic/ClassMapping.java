/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.dynamic;

import de.evoal.languages.model.base.definitions.ClassDefinition;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.dynamic.ClassMapping#getSource <em>Source</em>}</li>
 *   <li>{@link de.evoal.languages.model.dynamic.ClassMapping#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.dynamic.DynamicPackage#getClassMapping()
 * @model
 * @generated
 */
public interface ClassMapping extends Mapping {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ClassDefinition)
	 * @see de.evoal.languages.model.dynamic.DynamicPackage#getClassMapping_Source()
	 * @model required="true"
	 * @generated
	 */
	ClassDefinition getSource();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.dynamic.ClassMapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ClassDefinition value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EClass)
	 * @see de.evoal.languages.model.dynamic.DynamicPackage#getClassMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	EClass getTarget();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.dynamic.ClassMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EClass value);

} // ClassMapping
