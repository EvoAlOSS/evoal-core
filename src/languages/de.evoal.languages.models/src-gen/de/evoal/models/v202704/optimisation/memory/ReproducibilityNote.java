/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.memory;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reproducibility Note</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A part of an execution whose results may not be reproducible on other
 *   platforms.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.ReproducibilityNote#getComponent <em>Component</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.ReproducibilityNote#getReason <em>Reason</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getReproducibilityNote()
 * @model
 * @generated
 */
public interface ReproducibilityNote extends EObject {
	/**
	 * Returns the value of the '<em><b>Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The name of the component, e.g. a fitness step.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Component</em>' attribute.
	 * @see #setComponent(String)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getReproducibilityNote_Component()
	 * @model required="true"
	 * @generated
	 */
	String getComponent();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.ReproducibilityNote#getComponent <em>Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' attribute.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(String value);

	/**
	 * Returns the value of the '<em><b>Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Why the results of the component may differ between platforms.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reason</em>' attribute.
	 * @see #setReason(String)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getReproducibilityNote_Reason()
	 * @model required="true"
	 * @generated
	 */
	String getReason();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.ReproducibilityNote#getReason <em>Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reason</em>' attribute.
	 * @see #getReason()
	 * @generated
	 */
	void setReason(String value);

} // ReproducibilityNote
