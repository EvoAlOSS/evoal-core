/**
 * EvoAl Project
 */
package de.evoal.languages.model.generator;

import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.TypeDefinitionReference;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.generator.ConcreteStep#getInstance <em>Instance</em>}</li>
 *   <li>{@link de.evoal.languages.model.generator.ConcreteStep#getReads <em>Reads</em>}</li>
 *   <li>{@link de.evoal.languages.model.generator.ConcreteStep#getWrites <em>Writes</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.generator.GeneratorPackage#getConcreteStep()
 * @model
 * @generated
 */
public interface ConcreteStep extends Step {
	/**
	 * Returns the value of the '<em><b>Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance</em>' containment reference.
	 * @see #setInstance(Instance)
	 * @see de.evoal.languages.model.generator.GeneratorPackage#getConcreteStep_Instance()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Instance getInstance();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.generator.ConcreteStep#getInstance <em>Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' containment reference.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(Instance value);

	/**
	 * Returns the value of the '<em><b>Reads</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.expressions.TypeDefinitionReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reads</em>' containment reference list.
	 * @see de.evoal.languages.model.generator.GeneratorPackage#getConcreteStep_Reads()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<TypeDefinitionReference> getReads();

	/**
	 * Returns the value of the '<em><b>Writes</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.expressions.TypeDefinitionReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Writes</em>' containment reference list.
	 * @see de.evoal.languages.model.generator.GeneratorPackage#getConcreteStep_Writes()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<TypeDefinitionReference> getWrites();

} // ConcreteStep
