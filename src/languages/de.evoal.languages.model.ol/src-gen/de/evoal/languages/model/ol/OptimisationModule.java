/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Optimisation Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * Root model element for the optimisation model.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ol.OptimisationModule#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.OptimisationModule#getProblem <em>Problem</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ol.OLPackage#getOptimisationModule()
 * @model
 * @generated
 */
public interface OptimisationModule extends de.evoal.languages.model.base.Module {
	/**
	 * Returns the value of the '<em><b>Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * An algorithm specification.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Algorithm</em>' containment reference.
	 * @see #setAlgorithm(AlgorithmInstance)
	 * @see de.evoal.languages.model.ol.OLPackage#getOptimisationModule_Algorithm()
	 * @model containment="true"
	 * @generated
	 */
	AlgorithmInstance getAlgorithm();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.OptimisationModule#getAlgorithm <em>Algorithm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm</em>' containment reference.
	 * @see #getAlgorithm()
	 * @generated
	 */
	void setAlgorithm(AlgorithmInstance value);

	/**
	 * Returns the value of the '<em><b>Problem</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The problem specification.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Problem</em>' containment reference.
	 * @see #setProblem(ProblemInstance)
	 * @see de.evoal.languages.model.ol.OLPackage#getOptimisationModule_Problem()
	 * @model containment="true"
	 * @generated
	 */
	ProblemInstance getProblem();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.OptimisationModule#getProblem <em>Problem</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Problem</em>' containment reference.
	 * @see #getProblem()
	 * @generated
	 */
	void setProblem(ProblemInstance value);

} // OptimisationModule
