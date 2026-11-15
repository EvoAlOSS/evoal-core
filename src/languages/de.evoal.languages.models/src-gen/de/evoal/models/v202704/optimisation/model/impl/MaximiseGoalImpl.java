/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.model.impl;

import de.evoal.models.v202704.optimisation.model.Direction;
import de.evoal.models.v202704.optimisation.model.MaximiseGoal;
import de.evoal.models.v202704.optimisation.model.ModelPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Maximise Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MaximiseGoalImpl extends OptimisationGoalImpl implements MaximiseGoal {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MaximiseGoalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MAXIMISE_GOAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Direction getDirection() {
		return Direction.MAXIMISE;
	}

} //MaximiseGoalImpl
