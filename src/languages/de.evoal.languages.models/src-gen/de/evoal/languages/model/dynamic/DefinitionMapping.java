/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.dynamic;

import de.evoal.languages.model.base.definitions.Definition;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definition Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * Link to the definition of a EStructuralFeature.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.dynamic.DefinitionMapping#getSource <em>Source</em>}</li>
 *   <li>{@link de.evoal.languages.model.dynamic.DefinitionMapping#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.dynamic.DynamicPackage#getDefinitionMapping()
 * @model
 * @generated
 */
public interface DefinitionMapping extends Mapping {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The definition (located in a .ddl file).
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Definition)
	 * @see de.evoal.languages.model.dynamic.DynamicPackage#getDefinitionMapping_Source()
	 * @model required="true"
	 * @generated
	 */
	Definition getSource();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.dynamic.DefinitionMapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Definition value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EStructuralFeature)
	 * @see de.evoal.languages.model.dynamic.DynamicPackage#getDefinitionMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getTarget();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.dynamic.DefinitionMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EStructuralFeature value);

} // DefinitionMapping
