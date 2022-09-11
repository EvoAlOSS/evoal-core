/**
 */
package de.evoal.languages.model.el;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.evoal.languages.model.el.ELFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface ELPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "el";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.evoal.de/languages/el/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "el";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ELPackage eINSTANCE = de.evoal.languages.model.el.impl.ELPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.ExpressionImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.OrExpressionImpl <em>Or Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.OrExpressionImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getOrExpression()
	 * @generated
	 */
	int OR_EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>Sub Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION__SUB_EXPRESSIONS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Or Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Or Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.XorExpressionImpl <em>Xor Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.XorExpressionImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getXorExpression()
	 * @generated
	 */
	int XOR_EXPRESSION = 2;

	/**
	 * The feature id for the '<em><b>Sub Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_EXPRESSION__SUB_EXPRESSIONS = 0;

	/**
	 * The number of structural features of the '<em>Xor Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_EXPRESSION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Xor Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.AndExpressionImpl <em>And Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.AndExpressionImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getAndExpression()
	 * @generated
	 */
	int AND_EXPRESSION = 3;

	/**
	 * The feature id for the '<em><b>Sub Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION__SUB_EXPRESSIONS = 0;

	/**
	 * The number of structural features of the '<em>And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.NotExpressionImpl <em>Not Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.NotExpressionImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getNotExpression()
	 * @generated
	 */
	int NOT_EXPRESSION = 4;

	/**
	 * The feature id for the '<em><b>Negated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION__NEGATED = 0;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION__OPERAND = 1;

	/**
	 * The number of structural features of the '<em>Not Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Not Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.ComparisonExpressionImpl <em>Comparison Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.ComparisonExpressionImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getComparisonExpression()
	 * @generated
	 */
	int COMPARISON_EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON_EXPRESSION__LEFT_OPERAND = 0;

	/**
	 * The feature id for the '<em><b>Comparison</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON_EXPRESSION__COMPARISON = 1;

	/**
	 * The number of structural features of the '<em>Comparison Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON_EXPRESSION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Comparison Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.PartialComparisonExpressionImpl <em>Partial Comparison Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.PartialComparisonExpressionImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getPartialComparisonExpression()
	 * @generated
	 */
	int PARTIAL_COMPARISON_EXPRESSION = 6;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_COMPARISON_EXPRESSION__OPERATOR = 0;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_COMPARISON_EXPRESSION__SUB_EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Partial Comparison Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_COMPARISON_EXPRESSION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Partial Comparison Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_COMPARISON_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.AddOrSubtractExpressionImpl <em>Add Or Subtract Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.AddOrSubtractExpressionImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getAddOrSubtractExpression()
	 * @generated
	 */
	int ADD_OR_SUBTRACT_EXPRESSION = 7;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OR_SUBTRACT_EXPRESSION__LEFT_OPERAND = 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OR_SUBTRACT_EXPRESSION__OPERATORS = 1;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OR_SUBTRACT_EXPRESSION__OPERANDS = 2;

	/**
	 * The number of structural features of the '<em>Add Or Subtract Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OR_SUBTRACT_EXPRESSION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Add Or Subtract Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OR_SUBTRACT_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.MultiplyDivideModuloExpressionImpl <em>Multiply Divide Modulo Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.MultiplyDivideModuloExpressionImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getMultiplyDivideModuloExpression()
	 * @generated
	 */
	int MULTIPLY_DIVIDE_MODULO_EXPRESSION = 8;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_DIVIDE_MODULO_EXPRESSION__LEFT_OPERAND = 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERATORS = 1;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERANDS = 2;

	/**
	 * The number of structural features of the '<em>Multiply Divide Modulo Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_DIVIDE_MODULO_EXPRESSION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Multiply Divide Modulo Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_DIVIDE_MODULO_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.PowerOfExpressionImpl <em>Power Of Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.PowerOfExpressionImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getPowerOfExpression()
	 * @generated
	 */
	int POWER_OF_EXPRESSION = 9;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_OF_EXPRESSION__LEFT_OPERAND = 0;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_OF_EXPRESSION__RIGHT_OPERAND = 1;

	/**
	 * The number of structural features of the '<em>Power Of Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_OF_EXPRESSION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Power Of Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_OF_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.UnaryAddOrSubtractExpressionImpl <em>Unary Add Or Subtract Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.UnaryAddOrSubtractExpressionImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getUnaryAddOrSubtractExpression()
	 * @generated
	 */
	int UNARY_ADD_OR_SUBTRACT_EXPRESSION = 10;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_ADD_OR_SUBTRACT_EXPRESSION__OPERATORS = 0;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_ADD_OR_SUBTRACT_EXPRESSION__SUB_EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Unary Add Or Subtract Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_ADD_OR_SUBTRACT_EXPRESSION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Unary Add Or Subtract Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_ADD_OR_SUBTRACT_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.CallOrLiteralOrReferenceOrParanthesesImpl <em>Call Or Literal Or Reference Or Parantheses</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.CallOrLiteralOrReferenceOrParanthesesImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getCallOrLiteralOrReferenceOrParantheses()
	 * @generated
	 */
	int CALL_OR_LITERAL_OR_REFERENCE_OR_PARANTHESES = 11;

	/**
	 * The number of structural features of the '<em>Call Or Literal Or Reference Or Parantheses</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OR_LITERAL_OR_REFERENCE_OR_PARANTHESES_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Call Or Literal Or Reference Or Parantheses</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OR_LITERAL_OR_REFERENCE_OR_PARANTHESES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.LiteralImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getLiteral()
	 * @generated
	 */
	int LITERAL = 12;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FEATURE_COUNT = CALL_OR_LITERAL_OR_REFERENCE_OR_PARANTHESES_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_OPERATION_COUNT = CALL_OR_LITERAL_OR_REFERENCE_OR_PARANTHESES_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.NumberLiteralImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getNumberLiteral()
	 * @generated
	 */
	int NUMBER_LITERAL = 13;

	/**
	 * The number of structural features of the '<em>Number Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Number Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_OPERATION_COUNT = LITERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.IntegerLiteralImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getIntegerLiteral()
	 * @generated
	 */
	int INTEGER_LITERAL = 14;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__VALUE = NUMBER_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_FEATURE_COUNT = NUMBER_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_OPERATION_COUNT = NUMBER_LITERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.DoubleLiteralImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getDoubleLiteral()
	 * @generated
	 */
	int DOUBLE_LITERAL = 15;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL__VALUE = NUMBER_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL_FEATURE_COUNT = NUMBER_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Double Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL_OPERATION_COUNT = NUMBER_LITERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.StringLiteralImpl <em>String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.StringLiteralImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getStringLiteral()
	 * @generated
	 */
	int STRING_LITERAL = 16;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_OPERATION_COUNT = LITERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.BooleanLiteralImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getBooleanLiteral()
	 * @generated
	 */
	int BOOLEAN_LITERAL = 17;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_OPERATION_COUNT = LITERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.CallImpl <em>Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.CallImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getCall()
	 * @generated
	 */
	int CALL = 18;

	/**
	 * The feature id for the '<em><b>Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__FUNCTION = CALL_OR_LITERAL_OR_REFERENCE_OR_PARANTHESES_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__PARAMETERS = CALL_OR_LITERAL_OR_REFERENCE_OR_PARANTHESES_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FEATURE_COUNT = CALL_OR_LITERAL_OR_REFERENCE_OR_PARANTHESES_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_COUNT = CALL_OR_LITERAL_OR_REFERENCE_OR_PARANTHESES_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.ParanthesesImpl <em>Parantheses</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.ParanthesesImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getParantheses()
	 * @generated
	 */
	int PARANTHESES = 19;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARANTHESES__SUB_EXPRESSION = CALL_OR_LITERAL_OR_REFERENCE_OR_PARANTHESES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parantheses</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARANTHESES_FEATURE_COUNT = CALL_OR_LITERAL_OR_REFERENCE_OR_PARANTHESES_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Parantheses</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARANTHESES_OPERATION_COUNT = CALL_OR_LITERAL_OR_REFERENCE_OR_PARANTHESES_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.FunctionNameImpl <em>Function Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.FunctionNameImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getFunctionName()
	 * @generated
	 */
	int FUNCTION_NAME = 20;

	/**
	 * The number of structural features of the '<em>Function Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_NAME_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Function Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_NAME_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.impl.ValueReferenceImpl <em>Value Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.impl.ValueReferenceImpl
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getValueReference()
	 * @generated
	 */
	int VALUE_REFERENCE = 21;

	/**
	 * The number of structural features of the '<em>Value Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_REFERENCE_FEATURE_COUNT = CALL_OR_LITERAL_OR_REFERENCE_OR_PARANTHESES_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Value Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_REFERENCE_OPERATION_COUNT = CALL_OR_LITERAL_OR_REFERENCE_OR_PARANTHESES_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.ComparisonOperator <em>Comparison Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.ComparisonOperator
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getComparisonOperator()
	 * @generated
	 */
	int COMPARISON_OPERATOR = 22;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.AddOrSubtractOperator <em>Add Or Subtract Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.AddOrSubtractOperator
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getAddOrSubtractOperator()
	 * @generated
	 */
	int ADD_OR_SUBTRACT_OPERATOR = 23;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.el.MultiplyDivideModuloOperator <em>Multiply Divide Modulo Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.el.MultiplyDivideModuloOperator
	 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getMultiplyDivideModuloOperator()
	 * @generated
	 */
	int MULTIPLY_DIVIDE_MODULO_OPERATOR = 24;


	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see de.evoal.languages.model.el.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.OrExpression <em>Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Expression</em>'.
	 * @see de.evoal.languages.model.el.OrExpression
	 * @generated
	 */
	EClass getOrExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.el.OrExpression#getSubExpressions <em>Sub Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Expressions</em>'.
	 * @see de.evoal.languages.model.el.OrExpression#getSubExpressions()
	 * @see #getOrExpression()
	 * @generated
	 */
	EReference getOrExpression_SubExpressions();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.XorExpression <em>Xor Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xor Expression</em>'.
	 * @see de.evoal.languages.model.el.XorExpression
	 * @generated
	 */
	EClass getXorExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.el.XorExpression#getSubExpressions <em>Sub Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Expressions</em>'.
	 * @see de.evoal.languages.model.el.XorExpression#getSubExpressions()
	 * @see #getXorExpression()
	 * @generated
	 */
	EReference getXorExpression_SubExpressions();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.AndExpression <em>And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Expression</em>'.
	 * @see de.evoal.languages.model.el.AndExpression
	 * @generated
	 */
	EClass getAndExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.el.AndExpression#getSubExpressions <em>Sub Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Expressions</em>'.
	 * @see de.evoal.languages.model.el.AndExpression#getSubExpressions()
	 * @see #getAndExpression()
	 * @generated
	 */
	EReference getAndExpression_SubExpressions();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.NotExpression <em>Not Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Expression</em>'.
	 * @see de.evoal.languages.model.el.NotExpression
	 * @generated
	 */
	EClass getNotExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.el.NotExpression#isNegated <em>Negated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Negated</em>'.
	 * @see de.evoal.languages.model.el.NotExpression#isNegated()
	 * @see #getNotExpression()
	 * @generated
	 */
	EAttribute getNotExpression_Negated();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.el.NotExpression#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see de.evoal.languages.model.el.NotExpression#getOperand()
	 * @see #getNotExpression()
	 * @generated
	 */
	EReference getNotExpression_Operand();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.ComparisonExpression <em>Comparison Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comparison Expression</em>'.
	 * @see de.evoal.languages.model.el.ComparisonExpression
	 * @generated
	 */
	EClass getComparisonExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.el.ComparisonExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see de.evoal.languages.model.el.ComparisonExpression#getLeftOperand()
	 * @see #getComparisonExpression()
	 * @generated
	 */
	EReference getComparisonExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.el.ComparisonExpression#getComparison <em>Comparison</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Comparison</em>'.
	 * @see de.evoal.languages.model.el.ComparisonExpression#getComparison()
	 * @see #getComparisonExpression()
	 * @generated
	 */
	EReference getComparisonExpression_Comparison();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.PartialComparisonExpression <em>Partial Comparison Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partial Comparison Expression</em>'.
	 * @see de.evoal.languages.model.el.PartialComparisonExpression
	 * @generated
	 */
	EClass getPartialComparisonExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.el.PartialComparisonExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see de.evoal.languages.model.el.PartialComparisonExpression#getOperator()
	 * @see #getPartialComparisonExpression()
	 * @generated
	 */
	EAttribute getPartialComparisonExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.el.PartialComparisonExpression#getSubExpression <em>Sub Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Expression</em>'.
	 * @see de.evoal.languages.model.el.PartialComparisonExpression#getSubExpression()
	 * @see #getPartialComparisonExpression()
	 * @generated
	 */
	EReference getPartialComparisonExpression_SubExpression();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.AddOrSubtractExpression <em>Add Or Subtract Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Or Subtract Expression</em>'.
	 * @see de.evoal.languages.model.el.AddOrSubtractExpression
	 * @generated
	 */
	EClass getAddOrSubtractExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.el.AddOrSubtractExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see de.evoal.languages.model.el.AddOrSubtractExpression#getLeftOperand()
	 * @see #getAddOrSubtractExpression()
	 * @generated
	 */
	EReference getAddOrSubtractExpression_LeftOperand();

	/**
	 * Returns the meta object for the attribute list '{@link de.evoal.languages.model.el.AddOrSubtractExpression#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see de.evoal.languages.model.el.AddOrSubtractExpression#getOperators()
	 * @see #getAddOrSubtractExpression()
	 * @generated
	 */
	EAttribute getAddOrSubtractExpression_Operators();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.el.AddOrSubtractExpression#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see de.evoal.languages.model.el.AddOrSubtractExpression#getOperands()
	 * @see #getAddOrSubtractExpression()
	 * @generated
	 */
	EReference getAddOrSubtractExpression_Operands();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.MultiplyDivideModuloExpression <em>Multiply Divide Modulo Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiply Divide Modulo Expression</em>'.
	 * @see de.evoal.languages.model.el.MultiplyDivideModuloExpression
	 * @generated
	 */
	EClass getMultiplyDivideModuloExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.el.MultiplyDivideModuloExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see de.evoal.languages.model.el.MultiplyDivideModuloExpression#getLeftOperand()
	 * @see #getMultiplyDivideModuloExpression()
	 * @generated
	 */
	EReference getMultiplyDivideModuloExpression_LeftOperand();

	/**
	 * Returns the meta object for the attribute list '{@link de.evoal.languages.model.el.MultiplyDivideModuloExpression#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see de.evoal.languages.model.el.MultiplyDivideModuloExpression#getOperators()
	 * @see #getMultiplyDivideModuloExpression()
	 * @generated
	 */
	EAttribute getMultiplyDivideModuloExpression_Operators();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.el.MultiplyDivideModuloExpression#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see de.evoal.languages.model.el.MultiplyDivideModuloExpression#getOperands()
	 * @see #getMultiplyDivideModuloExpression()
	 * @generated
	 */
	EReference getMultiplyDivideModuloExpression_Operands();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.PowerOfExpression <em>Power Of Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Power Of Expression</em>'.
	 * @see de.evoal.languages.model.el.PowerOfExpression
	 * @generated
	 */
	EClass getPowerOfExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.el.PowerOfExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see de.evoal.languages.model.el.PowerOfExpression#getLeftOperand()
	 * @see #getPowerOfExpression()
	 * @generated
	 */
	EReference getPowerOfExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.el.PowerOfExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see de.evoal.languages.model.el.PowerOfExpression#getRightOperand()
	 * @see #getPowerOfExpression()
	 * @generated
	 */
	EReference getPowerOfExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.UnaryAddOrSubtractExpression <em>Unary Add Or Subtract Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Add Or Subtract Expression</em>'.
	 * @see de.evoal.languages.model.el.UnaryAddOrSubtractExpression
	 * @generated
	 */
	EClass getUnaryAddOrSubtractExpression();

	/**
	 * Returns the meta object for the attribute list '{@link de.evoal.languages.model.el.UnaryAddOrSubtractExpression#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see de.evoal.languages.model.el.UnaryAddOrSubtractExpression#getOperators()
	 * @see #getUnaryAddOrSubtractExpression()
	 * @generated
	 */
	EAttribute getUnaryAddOrSubtractExpression_Operators();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.el.UnaryAddOrSubtractExpression#getSubExpression <em>Sub Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Expression</em>'.
	 * @see de.evoal.languages.model.el.UnaryAddOrSubtractExpression#getSubExpression()
	 * @see #getUnaryAddOrSubtractExpression()
	 * @generated
	 */
	EReference getUnaryAddOrSubtractExpression_SubExpression();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.CallOrLiteralOrReferenceOrParantheses <em>Call Or Literal Or Reference Or Parantheses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Or Literal Or Reference Or Parantheses</em>'.
	 * @see de.evoal.languages.model.el.CallOrLiteralOrReferenceOrParantheses
	 * @generated
	 */
	EClass getCallOrLiteralOrReferenceOrParantheses();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see de.evoal.languages.model.el.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.NumberLiteral <em>Number Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Literal</em>'.
	 * @see de.evoal.languages.model.el.NumberLiteral
	 * @generated
	 */
	EClass getNumberLiteral();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal</em>'.
	 * @see de.evoal.languages.model.el.IntegerLiteral
	 * @generated
	 */
	EClass getIntegerLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.el.IntegerLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.evoal.languages.model.el.IntegerLiteral#getValue()
	 * @see #getIntegerLiteral()
	 * @generated
	 */
	EAttribute getIntegerLiteral_Value();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.DoubleLiteral <em>Double Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Literal</em>'.
	 * @see de.evoal.languages.model.el.DoubleLiteral
	 * @generated
	 */
	EClass getDoubleLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.el.DoubleLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.evoal.languages.model.el.DoubleLiteral#getValue()
	 * @see #getDoubleLiteral()
	 * @generated
	 */
	EAttribute getDoubleLiteral_Value();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal</em>'.
	 * @see de.evoal.languages.model.el.StringLiteral
	 * @generated
	 */
	EClass getStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.el.StringLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.evoal.languages.model.el.StringLiteral#getValue()
	 * @see #getStringLiteral()
	 * @generated
	 */
	EAttribute getStringLiteral_Value();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal</em>'.
	 * @see de.evoal.languages.model.el.BooleanLiteral
	 * @generated
	 */
	EClass getBooleanLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.el.BooleanLiteral#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.evoal.languages.model.el.BooleanLiteral#isValue()
	 * @see #getBooleanLiteral()
	 * @generated
	 */
	EAttribute getBooleanLiteral_Value();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.Call <em>Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call</em>'.
	 * @see de.evoal.languages.model.el.Call
	 * @generated
	 */
	EClass getCall();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.el.Call#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Function</em>'.
	 * @see de.evoal.languages.model.el.Call#getFunction()
	 * @see #getCall()
	 * @generated
	 */
	EReference getCall_Function();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.el.Call#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.evoal.languages.model.el.Call#getParameters()
	 * @see #getCall()
	 * @generated
	 */
	EReference getCall_Parameters();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.Parantheses <em>Parantheses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parantheses</em>'.
	 * @see de.evoal.languages.model.el.Parantheses
	 * @generated
	 */
	EClass getParantheses();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.el.Parantheses#getSubExpression <em>Sub Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Expression</em>'.
	 * @see de.evoal.languages.model.el.Parantheses#getSubExpression()
	 * @see #getParantheses()
	 * @generated
	 */
	EReference getParantheses_SubExpression();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.FunctionName <em>Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Name</em>'.
	 * @see de.evoal.languages.model.el.FunctionName
	 * @generated
	 */
	EClass getFunctionName();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.el.ValueReference <em>Value Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Reference</em>'.
	 * @see de.evoal.languages.model.el.ValueReference
	 * @generated
	 */
	EClass getValueReference();

	/**
	 * Returns the meta object for enum '{@link de.evoal.languages.model.el.ComparisonOperator <em>Comparison Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Comparison Operator</em>'.
	 * @see de.evoal.languages.model.el.ComparisonOperator
	 * @generated
	 */
	EEnum getComparisonOperator();

	/**
	 * Returns the meta object for enum '{@link de.evoal.languages.model.el.AddOrSubtractOperator <em>Add Or Subtract Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Add Or Subtract Operator</em>'.
	 * @see de.evoal.languages.model.el.AddOrSubtractOperator
	 * @generated
	 */
	EEnum getAddOrSubtractOperator();

	/**
	 * Returns the meta object for enum '{@link de.evoal.languages.model.el.MultiplyDivideModuloOperator <em>Multiply Divide Modulo Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Multiply Divide Modulo Operator</em>'.
	 * @see de.evoal.languages.model.el.MultiplyDivideModuloOperator
	 * @generated
	 */
	EEnum getMultiplyDivideModuloOperator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ELFactory getELFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.ExpressionImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.OrExpressionImpl <em>Or Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.OrExpressionImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getOrExpression()
		 * @generated
		 */
		EClass OR_EXPRESSION = eINSTANCE.getOrExpression();

		/**
		 * The meta object literal for the '<em><b>Sub Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OR_EXPRESSION__SUB_EXPRESSIONS = eINSTANCE.getOrExpression_SubExpressions();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.XorExpressionImpl <em>Xor Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.XorExpressionImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getXorExpression()
		 * @generated
		 */
		EClass XOR_EXPRESSION = eINSTANCE.getXorExpression();

		/**
		 * The meta object literal for the '<em><b>Sub Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XOR_EXPRESSION__SUB_EXPRESSIONS = eINSTANCE.getXorExpression_SubExpressions();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.AndExpressionImpl <em>And Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.AndExpressionImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getAndExpression()
		 * @generated
		 */
		EClass AND_EXPRESSION = eINSTANCE.getAndExpression();

		/**
		 * The meta object literal for the '<em><b>Sub Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AND_EXPRESSION__SUB_EXPRESSIONS = eINSTANCE.getAndExpression_SubExpressions();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.NotExpressionImpl <em>Not Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.NotExpressionImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getNotExpression()
		 * @generated
		 */
		EClass NOT_EXPRESSION = eINSTANCE.getNotExpression();

		/**
		 * The meta object literal for the '<em><b>Negated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOT_EXPRESSION__NEGATED = eINSTANCE.getNotExpression_Negated();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT_EXPRESSION__OPERAND = eINSTANCE.getNotExpression_Operand();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.ComparisonExpressionImpl <em>Comparison Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.ComparisonExpressionImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getComparisonExpression()
		 * @generated
		 */
		EClass COMPARISON_EXPRESSION = eINSTANCE.getComparisonExpression();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPARISON_EXPRESSION__LEFT_OPERAND = eINSTANCE.getComparisonExpression_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Comparison</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPARISON_EXPRESSION__COMPARISON = eINSTANCE.getComparisonExpression_Comparison();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.PartialComparisonExpressionImpl <em>Partial Comparison Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.PartialComparisonExpressionImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getPartialComparisonExpression()
		 * @generated
		 */
		EClass PARTIAL_COMPARISON_EXPRESSION = eINSTANCE.getPartialComparisonExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTIAL_COMPARISON_EXPRESSION__OPERATOR = eINSTANCE.getPartialComparisonExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Sub Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTIAL_COMPARISON_EXPRESSION__SUB_EXPRESSION = eINSTANCE.getPartialComparisonExpression_SubExpression();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.AddOrSubtractExpressionImpl <em>Add Or Subtract Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.AddOrSubtractExpressionImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getAddOrSubtractExpression()
		 * @generated
		 */
		EClass ADD_OR_SUBTRACT_EXPRESSION = eINSTANCE.getAddOrSubtractExpression();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_OR_SUBTRACT_EXPRESSION__LEFT_OPERAND = eINSTANCE.getAddOrSubtractExpression_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_OR_SUBTRACT_EXPRESSION__OPERATORS = eINSTANCE.getAddOrSubtractExpression_Operators();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_OR_SUBTRACT_EXPRESSION__OPERANDS = eINSTANCE.getAddOrSubtractExpression_Operands();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.MultiplyDivideModuloExpressionImpl <em>Multiply Divide Modulo Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.MultiplyDivideModuloExpressionImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getMultiplyDivideModuloExpression()
		 * @generated
		 */
		EClass MULTIPLY_DIVIDE_MODULO_EXPRESSION = eINSTANCE.getMultiplyDivideModuloExpression();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLY_DIVIDE_MODULO_EXPRESSION__LEFT_OPERAND = eINSTANCE.getMultiplyDivideModuloExpression_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERATORS = eINSTANCE.getMultiplyDivideModuloExpression_Operators();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERANDS = eINSTANCE.getMultiplyDivideModuloExpression_Operands();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.PowerOfExpressionImpl <em>Power Of Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.PowerOfExpressionImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getPowerOfExpression()
		 * @generated
		 */
		EClass POWER_OF_EXPRESSION = eINSTANCE.getPowerOfExpression();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER_OF_EXPRESSION__LEFT_OPERAND = eINSTANCE.getPowerOfExpression_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER_OF_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getPowerOfExpression_RightOperand();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.UnaryAddOrSubtractExpressionImpl <em>Unary Add Or Subtract Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.UnaryAddOrSubtractExpressionImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getUnaryAddOrSubtractExpression()
		 * @generated
		 */
		EClass UNARY_ADD_OR_SUBTRACT_EXPRESSION = eINSTANCE.getUnaryAddOrSubtractExpression();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNARY_ADD_OR_SUBTRACT_EXPRESSION__OPERATORS = eINSTANCE.getUnaryAddOrSubtractExpression_Operators();

		/**
		 * The meta object literal for the '<em><b>Sub Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_ADD_OR_SUBTRACT_EXPRESSION__SUB_EXPRESSION = eINSTANCE.getUnaryAddOrSubtractExpression_SubExpression();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.CallOrLiteralOrReferenceOrParanthesesImpl <em>Call Or Literal Or Reference Or Parantheses</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.CallOrLiteralOrReferenceOrParanthesesImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getCallOrLiteralOrReferenceOrParantheses()
		 * @generated
		 */
		EClass CALL_OR_LITERAL_OR_REFERENCE_OR_PARANTHESES = eINSTANCE.getCallOrLiteralOrReferenceOrParantheses();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.LiteralImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getLiteral()
		 * @generated
		 */
		EClass LITERAL = eINSTANCE.getLiteral();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.NumberLiteralImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getNumberLiteral()
		 * @generated
		 */
		EClass NUMBER_LITERAL = eINSTANCE.getNumberLiteral();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.IntegerLiteralImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getIntegerLiteral()
		 * @generated
		 */
		EClass INTEGER_LITERAL = eINSTANCE.getIntegerLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL__VALUE = eINSTANCE.getIntegerLiteral_Value();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.DoubleLiteralImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getDoubleLiteral()
		 * @generated
		 */
		EClass DOUBLE_LITERAL = eINSTANCE.getDoubleLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_LITERAL__VALUE = eINSTANCE.getDoubleLiteral_Value();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.StringLiteralImpl <em>String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.StringLiteralImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getStringLiteral()
		 * @generated
		 */
		EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.BooleanLiteralImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getBooleanLiteral()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL__VALUE = eINSTANCE.getBooleanLiteral_Value();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.CallImpl <em>Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.CallImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getCall()
		 * @generated
		 */
		EClass CALL = eINSTANCE.getCall();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL__FUNCTION = eINSTANCE.getCall_Function();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL__PARAMETERS = eINSTANCE.getCall_Parameters();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.ParanthesesImpl <em>Parantheses</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.ParanthesesImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getParantheses()
		 * @generated
		 */
		EClass PARANTHESES = eINSTANCE.getParantheses();

		/**
		 * The meta object literal for the '<em><b>Sub Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARANTHESES__SUB_EXPRESSION = eINSTANCE.getParantheses_SubExpression();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.FunctionNameImpl <em>Function Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.FunctionNameImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getFunctionName()
		 * @generated
		 */
		EClass FUNCTION_NAME = eINSTANCE.getFunctionName();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.impl.ValueReferenceImpl <em>Value Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.impl.ValueReferenceImpl
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getValueReference()
		 * @generated
		 */
		EClass VALUE_REFERENCE = eINSTANCE.getValueReference();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.ComparisonOperator <em>Comparison Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.ComparisonOperator
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getComparisonOperator()
		 * @generated
		 */
		EEnum COMPARISON_OPERATOR = eINSTANCE.getComparisonOperator();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.AddOrSubtractOperator <em>Add Or Subtract Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.AddOrSubtractOperator
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getAddOrSubtractOperator()
		 * @generated
		 */
		EEnum ADD_OR_SUBTRACT_OPERATOR = eINSTANCE.getAddOrSubtractOperator();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.el.MultiplyDivideModuloOperator <em>Multiply Divide Modulo Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.el.MultiplyDivideModuloOperator
		 * @see de.evoal.languages.model.el.impl.ELPackageImpl#getMultiplyDivideModuloOperator()
		 * @generated
		 */
		EEnum MULTIPLY_DIVIDE_MODULO_OPERATOR = eINSTANCE.getMultiplyDivideModuloOperator();

	}

} //ELPackage
