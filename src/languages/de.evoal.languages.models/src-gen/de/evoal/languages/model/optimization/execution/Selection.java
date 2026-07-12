/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.languages.model.optimization.execution;

import de.evoal.languages.model.optimization.memory.IterationStep;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * In several situations an optimisation algorithm selects a subset of
 *   a given set of individuals (there are different strategies of how
 *   to select these individuals.
 * 
 * Please note that the input and output of this operation are not
 *   necessarily sets. Several selections strategies allow selecting an
 *   individual multiple times. Thus, in- and output are bags (without
 *   order and allowing elements to be contained multiple times).
 * 
 * <!-- end-model-doc -->
 *
 *
 * @see de.evoal.languages.model.optimization.execution.ExecutionPackage#getSelection()
 * @model
 * @generated
 */
public interface Selection extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The actual selection operation.
	 * 
	 * @param input A bag of individuals.
	 * 
	 * @return A bag of selected individuals.
	 * 
	 * <!-- end-model-doc -->
	 * @model required="true" inputRequired="true"
	 * @generated
	 */
	IterationStep select(IterationStep input);

} // Selection
