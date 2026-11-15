/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.model;

import de.evoal.models.v202704.core.Configuration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Optimisation Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *  * Root model element for the optimisation model.
 *  
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.OptimisationModule#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.OptimisationModule#getProblem <em>Problem</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.optimisation.model.ModelPackage#getOptimisationModule()
 * @model
 * @generated
 */
public interface OptimisationModule extends EObject {
	/**
	 * Returns the value of the '<em><b>Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *  * The algorithm configuration for solving the problem.
	 *  
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Algorithm</em>' containment reference.
	 * @see #setAlgorithm(Configuration)
	 * @see de.evoal.models.v202704.optimisation.model.ModelPackage#getOptimisationModule_Algorithm()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Configuration getAlgorithm();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.model.OptimisationModule#getAlgorithm <em>Algorithm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm</em>' containment reference.
	 * @see #getAlgorithm()
	 * @generated
	 */
	void setAlgorithm(Configuration value);

	/**
	 * Returns the value of the '<em><b>Problem</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *  * The actual problem to solve.
	 *  
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Problem</em>' containment reference.
	 * @see #setProblem(Problem)
	 * @see de.evoal.models.v202704.optimisation.model.ModelPackage#getOptimisationModule_Problem()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Problem getProblem();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.model.OptimisationModule#getProblem <em>Problem</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Problem</em>' containment reference.
	 * @see #getProblem()
	 * @generated
	 */
	void setProblem(Problem value);

} // OptimisationModule
