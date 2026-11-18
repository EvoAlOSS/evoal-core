/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.model;

import de.evoal.models.v202704.core.Configuration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *  * Optimisation goal for target-based optimisation.
 *  
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.TargetGoal#getValue <em>Value</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.TargetGoal#isFromEvaluation <em>From Evaluation</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.TargetGoal#getDistance <em>Distance</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.optimisation.model.ModelPackage#getTargetGoal()
 * @model
 * @generated
 */
public interface TargetGoal extends OptimisationGoal {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * Constant target to optimise to. Unset if the target is taken from the evaluation.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see de.evoal.models.v202704.optimisation.model.ModelPackage#getTargetGoal_Value()
	 * @model
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.model.TargetGoal#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

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
	 * @see de.evoal.models.v202704.optimisation.model.ModelPackage#getTargetGoal_FromEvaluation()
	 * @model
	 * @generated
	 */
	boolean isFromEvaluation();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.model.TargetGoal#isFromEvaluation <em>From Evaluation</em>}' attribute.
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
	 * @see #setDistance(Configuration)
	 * @see de.evoal.models.v202704.optimisation.model.ModelPackage#getTargetGoal_Distance()
	 * @model containment="true" required="true"
	 *        annotation="https://evoal.de/v202610/models/core/configured-by type='de.evoal.optimisation.core.target-distance'"
	 * @generated
	 */
	Configuration getDistance();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.model.TargetGoal#getDistance <em>Distance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance</em>' containment reference.
	 * @see #getDistance()
	 * @generated
	 */
	void setDistance(Configuration value);

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
