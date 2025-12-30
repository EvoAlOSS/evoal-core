/**
 * EvoAl Project
 */
package de.evoal.languages.model.generator.impl;

import de.evoal.languages.model.base.expressions.impl.LiteralImpl;

import de.evoal.languages.model.generator.GeneratorPackage;
import de.evoal.languages.model.generator.Step;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class StepImpl extends LiteralImpl implements Step {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Step getValue() {
		return this;
		
	}

} //StepImpl
