/**
 */
package de.evoal.languages.model.base.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partial Comparison Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.expressions.PartialComparisonExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.expressions.PartialComparisonExpression#getSubExpression <em>Sub Expression</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getPartialComparisonExpression()
 * @model
 * @generated
 */
public interface PartialComparisonExpression extends Value {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link de.evoal.languages.model.base.expressions.ComparisonOperator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see de.evoal.languages.model.base.expressions.ComparisonOperator
	 * @see #setOperator(ComparisonOperator)
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getPartialComparisonExpression_Operator()
	 * @model required="true"
	 * @generated
	 */
	ComparisonOperator getOperator();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.expressions.PartialComparisonExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see de.evoal.languages.model.base.expressions.ComparisonOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(ComparisonOperator value);

	/**
	 * Returns the value of the '<em><b>Sub Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Expression</em>' containment reference.
	 * @see #setSubExpression(AddOrSubtractExpression)
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getPartialComparisonExpression_SubExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AddOrSubtractExpression getSubExpression();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.expressions.PartialComparisonExpression#getSubExpression <em>Sub Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Expression</em>' containment reference.
	 * @see #getSubExpression()
	 * @generated
	 */
	void setSubExpression(AddOrSubtractExpression value);

} // PartialComparisonExpression
