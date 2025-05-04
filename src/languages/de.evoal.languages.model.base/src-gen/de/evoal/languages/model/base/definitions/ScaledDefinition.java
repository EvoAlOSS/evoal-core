/**
 */
package de.evoal.languages.model.base.definitions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scaled Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.definitions.ScaledDefinition#getScale <em>Scale</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.definitions.DefinitionsPackage#getScaledDefinition()
 * @model
 * @generated
 */
public interface ScaledDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * The literals are from the enumeration {@link de.evoal.languages.model.base.definitions.ScaleType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Scale of the data type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see de.evoal.languages.model.base.definitions.ScaleType
	 * @see #setScale(ScaleType)
	 * @see de.evoal.languages.model.base.definitions.DefinitionsPackage#getScaledDefinition_Scale()
	 * @model transient="true"
	 * @generated
	 */
	ScaleType getScale();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.definitions.ScaledDefinition#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see de.evoal.languages.model.base.definitions.ScaleType
	 * @see #getScale()
	 * @generated
	 */
	void setScale(ScaleType value);

} // ScaledDefinition
