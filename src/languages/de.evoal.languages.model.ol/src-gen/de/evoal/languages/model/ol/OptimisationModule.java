/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol;

import de.evoal.languages.model.base.Import;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

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
 *   <li>{@link de.evoal.languages.model.ol.OptimisationModule#getImports <em>Imports</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.OptimisationModule#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.OptimisationModule#getProblem <em>Problem</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ol.OLPackage#getOptimisationModule()
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
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.Import}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * List of import statements.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see de.evoal.languages.model.ol.OLPackage#getOptimisationModule_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Import> getImports();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * Name of the module.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.evoal.languages.model.ol.OLPackage#getOptimisationModule_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.OptimisationModule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
