/**
 */
package de.evoal.languages.model.base.expressions.util;

import de.evoal.languages.model.base.expressions.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExpressionsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsSwitch() {
		if (modelPackage == null) {
			modelPackage = ExpressionsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ExpressionsPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.READ_EXPRESSION: {
				ReadExpression readExpression = (ReadExpression)theEObject;
				T result = caseReadExpression(readExpression);
				if (result == null) result = caseExpression(readExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.CONSTANT_EXPRESSION: {
				ConstantExpression constantExpression = (ConstantExpression)theEObject;
				T result = caseConstantExpression(constantExpression);
				if (result == null) result = caseReadExpression(constantExpression);
				if (result == null) result = caseExpression(constantExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.WRITE_EXPRESSION: {
				WriteExpression writeExpression = (WriteExpression)theEObject;
				T result = caseWriteExpression(writeExpression);
				if (result == null) result = caseExpression(writeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OR_EXPRESSION: {
				OrExpression orExpression = (OrExpression)theEObject;
				T result = caseOrExpression(orExpression);
				if (result == null) result = caseReadExpression(orExpression);
				if (result == null) result = caseExpression(orExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.XOR_EXPRESSION: {
				XorExpression xorExpression = (XorExpression)theEObject;
				T result = caseXorExpression(xorExpression);
				if (result == null) result = caseReadExpression(xorExpression);
				if (result == null) result = caseExpression(xorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.AND_EXPRESSION: {
				AndExpression andExpression = (AndExpression)theEObject;
				T result = caseAndExpression(andExpression);
				if (result == null) result = caseReadExpression(andExpression);
				if (result == null) result = caseExpression(andExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.NOT_EXPRESSION: {
				NotExpression notExpression = (NotExpression)theEObject;
				T result = caseNotExpression(notExpression);
				if (result == null) result = caseReadExpression(notExpression);
				if (result == null) result = caseExpression(notExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.COMPARISON_EXPRESSION: {
				ComparisonExpression comparisonExpression = (ComparisonExpression)theEObject;
				T result = caseComparisonExpression(comparisonExpression);
				if (result == null) result = caseReadExpression(comparisonExpression);
				if (result == null) result = caseExpression(comparisonExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.PARTIAL_COMPARISON_EXPRESSION: {
				PartialComparisonExpression partialComparisonExpression = (PartialComparisonExpression)theEObject;
				T result = casePartialComparisonExpression(partialComparisonExpression);
				if (result == null) result = caseReadExpression(partialComparisonExpression);
				if (result == null) result = caseExpression(partialComparisonExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ADD_OR_SUBTRACT_EXPRESSION: {
				AddOrSubtractExpression addOrSubtractExpression = (AddOrSubtractExpression)theEObject;
				T result = caseAddOrSubtractExpression(addOrSubtractExpression);
				if (result == null) result = caseReadExpression(addOrSubtractExpression);
				if (result == null) result = caseExpression(addOrSubtractExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION: {
				MultiplyDivideModuloExpression multiplyDivideModuloExpression = (MultiplyDivideModuloExpression)theEObject;
				T result = caseMultiplyDivideModuloExpression(multiplyDivideModuloExpression);
				if (result == null) result = caseReadExpression(multiplyDivideModuloExpression);
				if (result == null) result = caseExpression(multiplyDivideModuloExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.POWER_OF_EXPRESSION: {
				PowerOfExpression powerOfExpression = (PowerOfExpression)theEObject;
				T result = casePowerOfExpression(powerOfExpression);
				if (result == null) result = caseReadExpression(powerOfExpression);
				if (result == null) result = caseExpression(powerOfExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.UNARY_ADD_OR_SUBTRACT_EXPRESSION: {
				UnaryAddOrSubtractExpression unaryAddOrSubtractExpression = (UnaryAddOrSubtractExpression)theEObject;
				T result = caseUnaryAddOrSubtractExpression(unaryAddOrSubtractExpression);
				if (result == null) result = caseReadExpression(unaryAddOrSubtractExpression);
				if (result == null) result = caseExpression(unaryAddOrSubtractExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.LITERAL: {
				Literal literal = (Literal)theEObject;
				T result = caseLiteral(literal);
				if (result == null) result = caseConstantExpression(literal);
				if (result == null) result = caseReadExpression(literal);
				if (result == null) result = caseExpression(literal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.NUMBER_LITERAL: {
				NumberLiteral numberLiteral = (NumberLiteral)theEObject;
				T result = caseNumberLiteral(numberLiteral);
				if (result == null) result = caseLiteral(numberLiteral);
				if (result == null) result = caseConstantExpression(numberLiteral);
				if (result == null) result = caseReadExpression(numberLiteral);
				if (result == null) result = caseExpression(numberLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.INTEGER_LITERAL: {
				IntegerLiteral integerLiteral = (IntegerLiteral)theEObject;
				T result = caseIntegerLiteral(integerLiteral);
				if (result == null) result = caseNumberLiteral(integerLiteral);
				if (result == null) result = caseLiteral(integerLiteral);
				if (result == null) result = caseConstantExpression(integerLiteral);
				if (result == null) result = caseReadExpression(integerLiteral);
				if (result == null) result = caseExpression(integerLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.REAL_LITERAL: {
				RealLiteral realLiteral = (RealLiteral)theEObject;
				T result = caseRealLiteral(realLiteral);
				if (result == null) result = caseNumberLiteral(realLiteral);
				if (result == null) result = caseLiteral(realLiteral);
				if (result == null) result = caseConstantExpression(realLiteral);
				if (result == null) result = caseReadExpression(realLiteral);
				if (result == null) result = caseExpression(realLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.STRING_LITERAL: {
				StringLiteral stringLiteral = (StringLiteral)theEObject;
				T result = caseStringLiteral(stringLiteral);
				if (result == null) result = caseLiteral(stringLiteral);
				if (result == null) result = caseConstantExpression(stringLiteral);
				if (result == null) result = caseReadExpression(stringLiteral);
				if (result == null) result = caseExpression(stringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.INSTANCE: {
				Instance instance = (Instance)theEObject;
				T result = caseInstance(instance);
				if (result == null) result = caseLiteral(instance);
				if (result == null) result = caseConstantExpression(instance);
				if (result == null) result = caseReadExpression(instance);
				if (result == null) result = caseExpression(instance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ATTRIBUTE: {
				Attribute attribute = (Attribute)theEObject;
				T result = caseAttribute(attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.VALUE_REFERENCE: {
				ValueReference valueReference = (ValueReference)theEObject;
				T result = caseValueReference(valueReference);
				if (result == null) result = caseConstantExpression(valueReference);
				if (result == null) result = caseReadExpression(valueReference);
				if (result == null) result = caseExpression(valueReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.SELF_REFERENCE: {
				SelfReference selfReference = (SelfReference)theEObject;
				T result = caseSelfReference(selfReference);
				if (result == null) result = caseValueReference(selfReference);
				if (result == null) result = caseConstantExpression(selfReference);
				if (result == null) result = caseReadExpression(selfReference);
				if (result == null) result = caseExpression(selfReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.VALUE_DEFINITION_REFERENCE: {
				ValueDefinitionReference valueDefinitionReference = (ValueDefinitionReference)theEObject;
				T result = caseValueDefinitionReference(valueDefinitionReference);
				if (result == null) result = caseValueReference(valueDefinitionReference);
				if (result == null) result = caseConstantExpression(valueDefinitionReference);
				if (result == null) result = caseReadExpression(valueDefinitionReference);
				if (result == null) result = caseExpression(valueDefinitionReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ATTRIBUTE_DEFINITION_REFERENCE: {
				AttributeDefinitionReference attributeDefinitionReference = (AttributeDefinitionReference)theEObject;
				T result = caseAttributeDefinitionReference(attributeDefinitionReference);
				if (result == null) result = caseValueDefinitionReference(attributeDefinitionReference);
				if (result == null) result = caseValueReference(attributeDefinitionReference);
				if (result == null) result = caseConstantExpression(attributeDefinitionReference);
				if (result == null) result = caseReadExpression(attributeDefinitionReference);
				if (result == null) result = caseExpression(attributeDefinitionReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.LITERAL_DEFINITION_REFERENCE: {
				LiteralDefinitionReference literalDefinitionReference = (LiteralDefinitionReference)theEObject;
				T result = caseLiteralDefinitionReference(literalDefinitionReference);
				if (result == null) result = caseValueDefinitionReference(literalDefinitionReference);
				if (result == null) result = caseValueReference(literalDefinitionReference);
				if (result == null) result = caseConstantExpression(literalDefinitionReference);
				if (result == null) result = caseReadExpression(literalDefinitionReference);
				if (result == null) result = caseExpression(literalDefinitionReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.TYPE_DEFINITION_REFERENCE: {
				TypeDefinitionReference typeDefinitionReference = (TypeDefinitionReference)theEObject;
				T result = caseTypeDefinitionReference(typeDefinitionReference);
				if (result == null) result = caseValueReference(typeDefinitionReference);
				if (result == null) result = caseConstantExpression(typeDefinitionReference);
				if (result == null) result = caseReadExpression(typeDefinitionReference);
				if (result == null) result = caseExpression(typeDefinitionReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.BOOLEAN_LITERAL: {
				BooleanLiteral booleanLiteral = (BooleanLiteral)theEObject;
				T result = caseBooleanLiteral(booleanLiteral);
				if (result == null) result = caseLiteral(booleanLiteral);
				if (result == null) result = caseConstantExpression(booleanLiteral);
				if (result == null) result = caseReadExpression(booleanLiteral);
				if (result == null) result = caseExpression(booleanLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.CALL: {
				Call call = (Call)theEObject;
				T result = caseCall(call);
				if (result == null) result = caseReadExpression(call);
				if (result == null) result = caseExpression(call);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.PARANTHESES: {
				Parantheses parantheses = (Parantheses)theEObject;
				T result = caseParantheses(parantheses);
				if (result == null) result = caseReadExpression(parantheses);
				if (result == null) result = caseExpression(parantheses);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ARRAY: {
				Array array = (Array)theEObject;
				T result = caseArray(array);
				if (result == null) result = caseReadExpression(array);
				if (result == null) result = caseExpression(array);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Read Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Read Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReadExpression(ReadExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constant Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constant Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstantExpression(ConstantExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Write Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Write Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWriteExpression(WriteExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrExpression(OrExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xor Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xor Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXorExpression(XorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndExpression(AndExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotExpression(NotExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comparison Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comparison Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComparisonExpression(ComparisonExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partial Comparison Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partial Comparison Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartialComparisonExpression(PartialComparisonExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Or Subtract Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Or Subtract Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddOrSubtractExpression(AddOrSubtractExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiply Divide Modulo Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiply Divide Modulo Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplyDivideModuloExpression(MultiplyDivideModuloExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Power Of Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Power Of Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePowerOfExpression(PowerOfExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Add Or Subtract Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Add Or Subtract Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryAddOrSubtractExpression(UnaryAddOrSubtractExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteral(Literal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Number Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Number Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumberLiteral(NumberLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerLiteral(IntegerLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealLiteral(RealLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteral(StringLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstance(Instance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttribute(Attribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueReference(ValueReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Self Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Self Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelfReference(SelfReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Definition Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Definition Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueDefinitionReference(ValueDefinitionReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Definition Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Definition Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeDefinitionReference(AttributeDefinitionReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Definition Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Definition Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralDefinitionReference(LiteralDefinitionReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Definition Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Definition Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeDefinitionReference(TypeDefinitionReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteral(BooleanLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCall(Call object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parantheses</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parantheses</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParantheses(Parantheses object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArray(Array object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ExpressionsSwitch
