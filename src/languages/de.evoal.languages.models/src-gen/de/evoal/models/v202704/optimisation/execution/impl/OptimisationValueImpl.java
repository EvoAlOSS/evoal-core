/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.execution.impl;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.models.v202704.optimisation.execution.ExecutionPackage;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.models.v202704.optimisation.impl.ComparableImpl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Optimisation Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class OptimisationValueImpl extends ComparableImpl<OptimisationValue> implements OptimisationValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptimisationValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionPackage.Literals.OPTIMISATION_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isBetter(final OptimisationValue other) {
		return this.compareTo(other) > 0;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEqual(final OptimisationValue other) {
		return this.compareTo(other) == 0;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isWorse(final OptimisationValue other) {
		return this.compareTo(other) < 0;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedEObject toOptmisationSpace() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Object> toStatistics() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //OptimisationValueImpl
