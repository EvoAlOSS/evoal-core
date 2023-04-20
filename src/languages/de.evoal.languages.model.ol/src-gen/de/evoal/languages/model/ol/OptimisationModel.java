/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol;

import de.evoal.languages.model.base.Import;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Optimisation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ol.OptimisationModel#getImports <em>Imports</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.OptimisationModel#getProblem <em>Problem</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.OptimisationModel#getAlgorithm <em>Algorithm</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ol.OLPackage#getOptimisationModel()
 * @model
 * @generated
 */
public interface OptimisationModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.Import}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see de.evoal.languages.model.ol.OLPackage#getOptimisationModel_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Import> getImports();

	/**
	 * Returns the value of the '<em><b>Problem</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Problem</em>' containment reference.
	 * @see #setProblem(Problem)
	 * @see de.evoal.languages.model.ol.OLPackage#getOptimisationModel_Problem()
	 * @model containment="true"
	 * @generated
	 */
	Problem getProblem();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.OptimisationModel#getProblem <em>Problem</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Problem</em>' containment reference.
	 * @see #getProblem()
	 * @generated
	 */
	void setProblem(Problem value);

	/**
	 * Returns the value of the '<em><b>Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm</em>' containment reference.
	 * @see #setAlgorithm(AlgorithmInstance)
	 * @see de.evoal.languages.model.ol.OLPackage#getOptimisationModel_Algorithm()
	 * @model containment="true"
	 * @generated
	 */
	AlgorithmInstance getAlgorithm();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.OptimisationModel#getAlgorithm <em>Algorithm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm</em>' containment reference.
	 * @see #getAlgorithm()
	 * @generated
	 */
	void setAlgorithm(AlgorithmInstance value);

} // OptimisationModel
