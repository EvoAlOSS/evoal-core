/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol.impl;

import de.evoal.languages.model.ol.Direction;
import de.evoal.languages.model.ol.MaximiseGoal;
import de.evoal.languages.model.ol.OLPackage;

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
		return OLPackage.Literals.MAXIMISE_GOAL;
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
