/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.model;

import de.evoal.models.v202704.core.Configuration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Problem</b></em>'.
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
 *   <li>{@link de.evoal.models.v202704.optimisation.model.Problem#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.Problem#getOptimisationFunction <em>Optimisation Function</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.Problem#getOptimisationSpace <em>Optimisation Space</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.Problem#getGoals <em>Goals</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.Problem#getSearchSpace <em>Search Space</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.Problem#getDocumentation <em>Documentation</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.optimisation.model.ModelPackage#getProblem()
 * @model
 * @generated
 */
public interface Problem extends EObject {
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
	 * @see de.evoal.models.v202704.optimisation.model.ModelPackage#getProblem_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.model.Problem#getName <em>Name</em>}' attribute.
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
	 * @see #setOptimisationFunction(Configuration)
	 * @see de.evoal.models.v202704.optimisation.model.ModelPackage#getProblem_OptimisationFunction()
	 * @model containment="true" required="true"
	 *        annotation="https://evoal.de/v202610/models/core/configured-by type='de.evoal.optimisation.core.optimisation-function'"
	 * @generated
	 */
	Configuration getOptimisationFunction();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.model.Problem#getOptimisationFunction <em>Optimisation Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optimisation Function</em>' containment reference.
	 * @see #getOptimisationFunction()
	 * @generated
	 */
	void setOptimisationFunction(Configuration value);

	/**
	 * Returns the value of the '<em><b>Optimisation Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The optimisation goals, specifying the optimisation space.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Optimisation Space</em>' reference.
	 * @see #setOptimisationSpace(EClass)
	 * @see de.evoal.models.v202704.optimisation.model.ModelPackage#getProblem_OptimisationSpace()
	 * @model required="true"
	 * @generated
	 */
	EClass getOptimisationSpace();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.model.Problem#getOptimisationSpace <em>Optimisation Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optimisation Space</em>' reference.
	 * @see #getOptimisationSpace()
	 * @generated
	 */
	void setOptimisationSpace(EClass value);

	/**
	 * Returns the value of the '<em><b>Goals</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.models.v202704.optimisation.model.OptimisationGoal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The optimisation goals, specifying the optimisation space.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Goals</em>' containment reference list.
	 * @see de.evoal.models.v202704.optimisation.model.ModelPackage#getProblem_Goals()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<OptimisationGoal> getGoals();

	/**
	 * Returns the value of the '<em><b>Search Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The search space.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Search Space</em>' reference.
	 * @see #setSearchSpace(EClass)
	 * @see de.evoal.models.v202704.optimisation.model.ModelPackage#getProblem_SearchSpace()
	 * @model required="true"
	 * @generated
	 */
	EClass getSearchSpace();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.model.Problem#getSearchSpace <em>Search Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Search Space</em>' reference.
	 * @see #getSearchSpace()
	 * @generated
	 */
	void setSearchSpace(EClass value);

	/**
	 * Returns the value of the '<em><b>Documentation</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.models.v202704.core.Configuration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * What to document.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Documentation</em>' containment reference list.
	 * @see de.evoal.models.v202704.optimisation.model.ModelPackage#getProblem_Documentation()
	 * @model containment="true"
	 *        annotation="https://evoal.de/v202610/models/core/configured-by type='de.evoal.optimisation.core.statistics-writer'"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Configuration> getDocumentation();

} // Problem
