/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol.impl;

import de.evoal.languages.model.ol.Direction;
import de.evoal.languages.model.ol.MinimiseGoal;
import de.evoal.languages.model.ol.OLPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Minimise Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MinimiseGoalImpl extends OptimisationGoalImpl implements MinimiseGoal {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MinimiseGoalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OLPackage.Literals.MINIMISE_GOAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Direction getDirection() {
		return Direction.MINIMISE;
	}

} //MinimiseGoalImpl
