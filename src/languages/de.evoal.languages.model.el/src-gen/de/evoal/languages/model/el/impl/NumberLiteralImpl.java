/**
 */
package de.evoal.languages.model.el.impl;

import de.evoal.languages.model.el.ELPackage;
import de.evoal.languages.model.el.NumberLiteral;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Number Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class NumberLiteralImpl extends LiteralImpl implements NumberLiteral {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumberLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ELPackage.Literals.NUMBER_LITERAL;
	}

} //NumberLiteralImpl
