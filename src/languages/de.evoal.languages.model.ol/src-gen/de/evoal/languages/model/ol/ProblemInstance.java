/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol;

import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.TypeDefinitionReference;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Problem Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * A problem definition.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ol.ProblemInstance#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.ProblemInstance#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.ProblemInstance#getOptimisationFunction <em>Optimisation Function</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.ProblemInstance#getOptimisationSpace <em>Optimisation Space</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.ProblemInstance#getSearchSpace <em>Search Space</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ol.OLPackage#getProblemInstance()
 * @model
 * @generated
 */
public interface ProblemInstance extends Instance {
	/**
	 * Returns the value of the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The information to protocol.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Documentation</em>' containment reference.
	 * @see #setDocumentation(Array)
	 * @see de.evoal.languages.model.ol.OLPackage#getProblemInstance_Documentation()
	 * @model containment="true"
	 * @generated
	 */
	Array getDocumentation();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.ProblemInstance#getDocumentation <em>Documentation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Documentation</em>' containment reference.
	 * @see #getDocumentation()
	 * @generated
	 */
	void setDocumentation(Array value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * Name of the problem.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.evoal.languages.model.ol.OLPackage#getProblemInstance_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.ProblemInstance#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Optimisation Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The function for mapping from search to optimisation space.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Optimisation Function</em>' containment reference.
	 * @see #setOptimisationFunction(Instance)
	 * @see de.evoal.languages.model.ol.OLPackage#getProblemInstance_OptimisationFunction()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Instance getOptimisationFunction();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.ProblemInstance#getOptimisationFunction <em>Optimisation Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optimisation Function</em>' containment reference.
	 * @see #getOptimisationFunction()
	 * @generated
	 */
	void setOptimisationFunction(Instance value);

	/**
	 * Returns the value of the '<em><b>Optimisation Space</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.ol.OptimisationGoal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The optimisation goals, specifying the optimisation space.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Optimisation Space</em>' containment reference list.
	 * @see de.evoal.languages.model.ol.OLPackage#getProblemInstance_OptimisationSpace()
	 * @model containment="true" required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<OptimisationGoal> getOptimisationSpace();

	/**
	 * Returns the value of the '<em><b>Search Space</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.expressions.TypeDefinitionReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The search space.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Search Space</em>' containment reference list.
	 * @see de.evoal.languages.model.ol.OLPackage#getProblemInstance_SearchSpace()
	 * @model containment="true" required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<TypeDefinitionReference> getSearchSpace();

} // ProblemInstance
