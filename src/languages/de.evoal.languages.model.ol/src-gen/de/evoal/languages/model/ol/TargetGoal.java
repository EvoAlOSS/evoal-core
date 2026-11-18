/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol;

import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.Literal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * Optimisation goal for target-based optimisation.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ol.TargetGoal#getValue <em>Value</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.TargetGoal#isFromEvaluation <em>From Evaluation</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.TargetGoal#getDistance <em>Distance</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ol.OLPackage#getTargetGoal()
 * @model
 * @generated
 */
public interface TargetGoal extends OptimisationGoal {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * Constant target to optimise to. Unset if the target is taken from the evaluation.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Literal)
	 * @see de.evoal.languages.model.ol.OLPackage#getTargetGoal_Value()
	 * @model containment="true"
	 * @generated
	 */
	Literal getValue();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.TargetGoal#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Literal value);

	/**
	 * Returns the value of the '<em><b>From Evaluation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * If set, the target is the current target point of the evaluation instead of a constant value.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>From Evaluation</em>' attribute.
	 * @see #setFromEvaluation(boolean)
	 * @see de.evoal.languages.model.ol.OLPackage#getTargetGoal_FromEvaluation()
	 * @model
	 * @generated
	 */
	boolean isFromEvaluation();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.TargetGoal#isFromEvaluation <em>From Evaluation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Evaluation</em>' attribute.
	 * @see #isFromEvaluation()
	 * @generated
	 */
	void setFromEvaluation(boolean value);

	/**
	 * Returns the value of the '<em><b>Distance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The target distance that measures how far an objective value is from the target.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Distance</em>' containment reference.
	 * @see #setDistance(Instance)
	 * @see de.evoal.languages.model.ol.OLPackage#getTargetGoal_Distance()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Instance getDistance();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.TargetGoal#getDistance <em>Distance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance</em>' containment reference.
	 * @see #getDistance()
	 * @generated
	 */
	void setDistance(Instance value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * Returns the optimisation direction
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Direction getDirection();

} // TargetGoal
