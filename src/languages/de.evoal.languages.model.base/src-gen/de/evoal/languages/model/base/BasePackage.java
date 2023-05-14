/**
 */
package de.evoal.languages.model.base;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
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
 * @see de.evoal.languages.model.base.BaseFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface BasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "base";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.evoal.de/languages/base/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "base";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BasePackage eINSTANCE = de.evoal.languages.model.base.impl.BasePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.ExpressionImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getExpression()
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
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.OrExpressionImpl <em>Or Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.OrExpressionImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getOrExpression()
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
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.XorExpressionImpl <em>Xor Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.XorExpressionImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getXorExpression()
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
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.AndExpressionImpl <em>And Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.AndExpressionImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getAndExpression()
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
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.NotExpressionImpl <em>Not Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.NotExpressionImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getNotExpression()
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
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.ComparisonExpressionImpl <em>Comparison Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.ComparisonExpressionImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getComparisonExpression()
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
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.PartialComparisonExpressionImpl <em>Partial Comparison Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.PartialComparisonExpressionImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getPartialComparisonExpression()
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
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.AddOrSubtractExpressionImpl <em>Add Or Subtract Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.AddOrSubtractExpressionImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getAddOrSubtractExpression()
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
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.MultiplyDivideModuloExpressionImpl <em>Multiply Divide Modulo Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.MultiplyDivideModuloExpressionImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getMultiplyDivideModuloExpression()
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
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.PowerOfExpressionImpl <em>Power Of Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.PowerOfExpressionImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getPowerOfExpression()
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
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.UnaryAddOrSubtractExpressionImpl <em>Unary Add Or Subtract Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.UnaryAddOrSubtractExpressionImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getUnaryAddOrSubtractExpression()
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
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.ValueImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 11;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.LiteralImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getLiteral()
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
	int LITERAL_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL___GET_VALUE = VALUE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_OPERATION_COUNT = VALUE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.NumberLiteralImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getNumberLiteral()
	 * @generated
	 */
	int NUMBER_LITERAL = 13;

	/**
	 * The feature id for the '<em><b>Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL__FACTOR = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Number Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL___GET_VALUE = LITERAL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Number Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_OPERATION_COUNT = LITERAL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.IntegerLiteralImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getIntegerLiteral()
	 * @generated
	 */
	int INTEGER_LITERAL = 14;

	/**
	 * The feature id for the '<em><b>Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__FACTOR = NUMBER_LITERAL__FACTOR;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__LITERAL = NUMBER_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_FEATURE_COUNT = NUMBER_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL___GET_VALUE = NUMBER_LITERAL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_OPERATION_COUNT = NUMBER_LITERAL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.RealLiteralImpl <em>Real Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.RealLiteralImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getRealLiteral()
	 * @generated
	 */
	int REAL_LITERAL = 15;

	/**
	 * The feature id for the '<em><b>Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL__FACTOR = NUMBER_LITERAL__FACTOR;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL__LITERAL = NUMBER_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Real Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_FEATURE_COUNT = NUMBER_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL___GET_VALUE = NUMBER_LITERAL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Real Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_OPERATION_COUNT = NUMBER_LITERAL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.StringLiteralImpl <em>String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.StringLiteralImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getStringLiteral()
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
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL___GET_VALUE = LITERAL___GET_VALUE;

	/**
	 * The number of operations of the '<em>String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_OPERATION_COUNT = LITERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.BooleanLiteralImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getBooleanLiteral()
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
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL___GET_VALUE = LITERAL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_OPERATION_COUNT = LITERAL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.CallImpl <em>Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.CallImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getCall()
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
	int CALL__FUNCTION = VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__PARAMETERS = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FEATURE_COUNT = VALUE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.ParanthesesImpl <em>Parantheses</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.ParanthesesImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getParantheses()
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
	int PARANTHESES__SUB_EXPRESSION = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parantheses</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARANTHESES_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Parantheses</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARANTHESES_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.FunctionNameImpl <em>Function Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.FunctionNameImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getFunctionName()
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
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.ValueReferenceImpl <em>Value Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.ValueReferenceImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getValueReference()
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
	int VALUE_REFERENCE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Value Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_REFERENCE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.TypeDefinitionImpl <em>Type Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.TypeDefinitionImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getTypeDefinition()
	 * @generated
	 */
	int TYPE_DEFINITION = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITION__ATTRIBUTES = 1;

	/**
	 * The feature id for the '<em><b>Super Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITION__SUPER_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITION__ABSTRACT = 3;

	/**
	 * The number of structural features of the '<em>Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITION_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Find Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITION___FIND_ATTRIBUTE__STRING = 0;

	/**
	 * The number of operations of the '<em>Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.AttributeDefinitionImpl <em>Attribute Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.AttributeDefinitionImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getAttributeDefinition()
	 * @generated
	 */
	int ATTRIBUTE_DEFINITION = 23;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Initialisation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__INITIALISATION = 2;

	/**
	 * The number of structural features of the '<em>Attribute Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Attribute Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.TypeImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getType()
	 * @generated
	 */
	int TYPE = 24;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.InstanceTypeImpl <em>Instance Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.InstanceTypeImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getInstanceType()
	 * @generated
	 */
	int INSTANCE_TYPE = 25;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_TYPE__DEFINITION = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Instance Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Instance Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.LiteralTypeImpl <em>Literal Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.LiteralTypeImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getLiteralType()
	 * @generated
	 */
	int LITERAL_TYPE = 26;

	/**
	 * The number of structural features of the '<em>Literal Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.StringTypeImpl <em>String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.StringTypeImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getStringType()
	 * @generated
	 */
	int STRING_TYPE = 27;

	/**
	 * The number of structural features of the '<em>String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_FEATURE_COUNT = LITERAL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_OPERATION_COUNT = LITERAL_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.IntTypeImpl <em>Int Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.IntTypeImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getIntType()
	 * @generated
	 */
	int INT_TYPE = 28;

	/**
	 * The number of structural features of the '<em>Int Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_TYPE_FEATURE_COUNT = LITERAL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Int Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_TYPE_OPERATION_COUNT = LITERAL_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.RealTypeImpl <em>Real Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.RealTypeImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getRealType()
	 * @generated
	 */
	int REAL_TYPE = 29;

	/**
	 * The number of structural features of the '<em>Real Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE_FEATURE_COUNT = LITERAL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Real Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE_OPERATION_COUNT = LITERAL_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.BooleanTypeImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getBooleanType()
	 * @generated
	 */
	int BOOLEAN_TYPE = 30;

	/**
	 * The number of structural features of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_FEATURE_COUNT = LITERAL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_OPERATION_COUNT = LITERAL_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.VoidTypeImpl <em>Void Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.VoidTypeImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getVoidType()
	 * @generated
	 */
	int VOID_TYPE = 31;

	/**
	 * The number of structural features of the '<em>Void Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Void Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.ExpressionTypeImpl <em>Expression Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.ExpressionTypeImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getExpressionType()
	 * @generated
	 */
	int EXPRESSION_TYPE = 32;

	/**
	 * The number of structural features of the '<em>Expression Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Expression Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.DataTypeImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 33;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.ArrayTypeImpl <em>Array Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.ArrayTypeImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getArrayType()
	 * @generated
	 */
	int ARRAY_TYPE = 34;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__ELEMENTS = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Array Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.FunctionDefinitionImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getFunctionDefinition()
	 * @generated
	 */
	int FUNCTION_DEFINITION = 35;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION__PARAMETERS = 2;

	/**
	 * The number of structural features of the '<em>Function Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Function Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.ParameterImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 36;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.DefinedFunctionNameImpl <em>Defined Function Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.DefinedFunctionNameImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getDefinedFunctionName()
	 * @generated
	 */
	int DEFINED_FUNCTION_NAME = 37;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINED_FUNCTION_NAME__DEFINITION = FUNCTION_NAME_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Defined Function Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINED_FUNCTION_NAME_FEATURE_COUNT = FUNCTION_NAME_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Defined Function Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINED_FUNCTION_NAME_OPERATION_COUNT = FUNCTION_NAME_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.ConstantDefinitionImpl <em>Constant Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.ConstantDefinitionImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getConstantDefinition()
	 * @generated
	 */
	int CONSTANT_DEFINITION = 38;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DEFINITION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DEFINITION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DEFINITION__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Constant Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DEFINITION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Constant Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.ConstantReferenceImpl <em>Constant Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.ConstantReferenceImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getConstantReference()
	 * @generated
	 */
	int CONSTANT_REFERENCE = 39;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_REFERENCE__DEFINITION = VALUE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constant Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_REFERENCE_FEATURE_COUNT = VALUE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Constant Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_REFERENCE_OPERATION_COUNT = VALUE_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.ArrayImpl <em>Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.ArrayImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getArray()
	 * @generated
	 */
	int ARRAY = 40;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY__VALUES = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.InstanceImpl <em>Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.InstanceImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getInstance()
	 * @generated
	 */
	int INSTANCE = 41;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__DEFINITION = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__ATTRIBUTES = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE___GET_VALUE = LITERAL___GET_VALUE;

	/**
	 * The operation id for the '<em>Find Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE___FIND_ATTRIBUTE__STRING = LITERAL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OPERATION_COUNT = LITERAL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.AttributeImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 42;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.impl.ImportImpl
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 43;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__LANGUAGE = 0;

	/**
	 * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__IMPORTED_NAMESPACE = 1;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.ComparisonOperator <em>Comparison Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.ComparisonOperator
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getComparisonOperator()
	 * @generated
	 */
	int COMPARISON_OPERATOR = 44;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.AddOrSubtractOperator <em>Add Or Subtract Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.AddOrSubtractOperator
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getAddOrSubtractOperator()
	 * @generated
	 */
	int ADD_OR_SUBTRACT_OPERATOR = 45;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.MultiplyDivideModuloOperator <em>Multiply Divide Modulo Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.MultiplyDivideModuloOperator
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getMultiplyDivideModuloOperator()
	 * @generated
	 */
	int MULTIPLY_DIVIDE_MODULO_OPERATOR = 46;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.Factor <em>Factor</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.Factor
	 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getFactor()
	 * @generated
	 */
	int FACTOR = 47;


	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see de.evoal.languages.model.base.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.OrExpression <em>Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Expression</em>'.
	 * @see de.evoal.languages.model.base.OrExpression
	 * @generated
	 */
	EClass getOrExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.OrExpression#getSubExpressions <em>Sub Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Expressions</em>'.
	 * @see de.evoal.languages.model.base.OrExpression#getSubExpressions()
	 * @see #getOrExpression()
	 * @generated
	 */
	EReference getOrExpression_SubExpressions();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.XorExpression <em>Xor Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xor Expression</em>'.
	 * @see de.evoal.languages.model.base.XorExpression
	 * @generated
	 */
	EClass getXorExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.XorExpression#getSubExpressions <em>Sub Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Expressions</em>'.
	 * @see de.evoal.languages.model.base.XorExpression#getSubExpressions()
	 * @see #getXorExpression()
	 * @generated
	 */
	EReference getXorExpression_SubExpressions();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.AndExpression <em>And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Expression</em>'.
	 * @see de.evoal.languages.model.base.AndExpression
	 * @generated
	 */
	EClass getAndExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.AndExpression#getSubExpressions <em>Sub Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Expressions</em>'.
	 * @see de.evoal.languages.model.base.AndExpression#getSubExpressions()
	 * @see #getAndExpression()
	 * @generated
	 */
	EReference getAndExpression_SubExpressions();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.NotExpression <em>Not Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Expression</em>'.
	 * @see de.evoal.languages.model.base.NotExpression
	 * @generated
	 */
	EClass getNotExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.NotExpression#isNegated <em>Negated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Negated</em>'.
	 * @see de.evoal.languages.model.base.NotExpression#isNegated()
	 * @see #getNotExpression()
	 * @generated
	 */
	EAttribute getNotExpression_Negated();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.NotExpression#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see de.evoal.languages.model.base.NotExpression#getOperand()
	 * @see #getNotExpression()
	 * @generated
	 */
	EReference getNotExpression_Operand();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.ComparisonExpression <em>Comparison Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comparison Expression</em>'.
	 * @see de.evoal.languages.model.base.ComparisonExpression
	 * @generated
	 */
	EClass getComparisonExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.ComparisonExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see de.evoal.languages.model.base.ComparisonExpression#getLeftOperand()
	 * @see #getComparisonExpression()
	 * @generated
	 */
	EReference getComparisonExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.ComparisonExpression#getComparison <em>Comparison</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Comparison</em>'.
	 * @see de.evoal.languages.model.base.ComparisonExpression#getComparison()
	 * @see #getComparisonExpression()
	 * @generated
	 */
	EReference getComparisonExpression_Comparison();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.PartialComparisonExpression <em>Partial Comparison Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partial Comparison Expression</em>'.
	 * @see de.evoal.languages.model.base.PartialComparisonExpression
	 * @generated
	 */
	EClass getPartialComparisonExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.PartialComparisonExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see de.evoal.languages.model.base.PartialComparisonExpression#getOperator()
	 * @see #getPartialComparisonExpression()
	 * @generated
	 */
	EAttribute getPartialComparisonExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.PartialComparisonExpression#getSubExpression <em>Sub Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Expression</em>'.
	 * @see de.evoal.languages.model.base.PartialComparisonExpression#getSubExpression()
	 * @see #getPartialComparisonExpression()
	 * @generated
	 */
	EReference getPartialComparisonExpression_SubExpression();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.AddOrSubtractExpression <em>Add Or Subtract Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Or Subtract Expression</em>'.
	 * @see de.evoal.languages.model.base.AddOrSubtractExpression
	 * @generated
	 */
	EClass getAddOrSubtractExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.AddOrSubtractExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see de.evoal.languages.model.base.AddOrSubtractExpression#getLeftOperand()
	 * @see #getAddOrSubtractExpression()
	 * @generated
	 */
	EReference getAddOrSubtractExpression_LeftOperand();

	/**
	 * Returns the meta object for the attribute list '{@link de.evoal.languages.model.base.AddOrSubtractExpression#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see de.evoal.languages.model.base.AddOrSubtractExpression#getOperators()
	 * @see #getAddOrSubtractExpression()
	 * @generated
	 */
	EAttribute getAddOrSubtractExpression_Operators();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.AddOrSubtractExpression#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see de.evoal.languages.model.base.AddOrSubtractExpression#getOperands()
	 * @see #getAddOrSubtractExpression()
	 * @generated
	 */
	EReference getAddOrSubtractExpression_Operands();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.MultiplyDivideModuloExpression <em>Multiply Divide Modulo Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiply Divide Modulo Expression</em>'.
	 * @see de.evoal.languages.model.base.MultiplyDivideModuloExpression
	 * @generated
	 */
	EClass getMultiplyDivideModuloExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.MultiplyDivideModuloExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see de.evoal.languages.model.base.MultiplyDivideModuloExpression#getLeftOperand()
	 * @see #getMultiplyDivideModuloExpression()
	 * @generated
	 */
	EReference getMultiplyDivideModuloExpression_LeftOperand();

	/**
	 * Returns the meta object for the attribute list '{@link de.evoal.languages.model.base.MultiplyDivideModuloExpression#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see de.evoal.languages.model.base.MultiplyDivideModuloExpression#getOperators()
	 * @see #getMultiplyDivideModuloExpression()
	 * @generated
	 */
	EAttribute getMultiplyDivideModuloExpression_Operators();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.MultiplyDivideModuloExpression#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see de.evoal.languages.model.base.MultiplyDivideModuloExpression#getOperands()
	 * @see #getMultiplyDivideModuloExpression()
	 * @generated
	 */
	EReference getMultiplyDivideModuloExpression_Operands();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.PowerOfExpression <em>Power Of Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Power Of Expression</em>'.
	 * @see de.evoal.languages.model.base.PowerOfExpression
	 * @generated
	 */
	EClass getPowerOfExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.PowerOfExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see de.evoal.languages.model.base.PowerOfExpression#getLeftOperand()
	 * @see #getPowerOfExpression()
	 * @generated
	 */
	EReference getPowerOfExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.PowerOfExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see de.evoal.languages.model.base.PowerOfExpression#getRightOperand()
	 * @see #getPowerOfExpression()
	 * @generated
	 */
	EReference getPowerOfExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.UnaryAddOrSubtractExpression <em>Unary Add Or Subtract Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Add Or Subtract Expression</em>'.
	 * @see de.evoal.languages.model.base.UnaryAddOrSubtractExpression
	 * @generated
	 */
	EClass getUnaryAddOrSubtractExpression();

	/**
	 * Returns the meta object for the attribute list '{@link de.evoal.languages.model.base.UnaryAddOrSubtractExpression#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see de.evoal.languages.model.base.UnaryAddOrSubtractExpression#getOperators()
	 * @see #getUnaryAddOrSubtractExpression()
	 * @generated
	 */
	EAttribute getUnaryAddOrSubtractExpression_Operators();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.UnaryAddOrSubtractExpression#getSubExpression <em>Sub Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Expression</em>'.
	 * @see de.evoal.languages.model.base.UnaryAddOrSubtractExpression#getSubExpression()
	 * @see #getUnaryAddOrSubtractExpression()
	 * @generated
	 */
	EReference getUnaryAddOrSubtractExpression_SubExpression();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see de.evoal.languages.model.base.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see de.evoal.languages.model.base.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.Literal#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see de.evoal.languages.model.base.Literal#getValue()
	 * @generated
	 */
	EOperation getLiteral__GetValue();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.NumberLiteral <em>Number Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Literal</em>'.
	 * @see de.evoal.languages.model.base.NumberLiteral
	 * @generated
	 */
	EClass getNumberLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.NumberLiteral#getFactor <em>Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factor</em>'.
	 * @see de.evoal.languages.model.base.NumberLiteral#getFactor()
	 * @see #getNumberLiteral()
	 * @generated
	 */
	EAttribute getNumberLiteral_Factor();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.NumberLiteral#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see de.evoal.languages.model.base.NumberLiteral#getValue()
	 * @generated
	 */
	EOperation getNumberLiteral__GetValue();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal</em>'.
	 * @see de.evoal.languages.model.base.IntegerLiteral
	 * @generated
	 */
	EClass getIntegerLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.IntegerLiteral#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal</em>'.
	 * @see de.evoal.languages.model.base.IntegerLiteral#getLiteral()
	 * @see #getIntegerLiteral()
	 * @generated
	 */
	EAttribute getIntegerLiteral_Literal();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.IntegerLiteral#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see de.evoal.languages.model.base.IntegerLiteral#getValue()
	 * @generated
	 */
	EOperation getIntegerLiteral__GetValue();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.RealLiteral <em>Real Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Literal</em>'.
	 * @see de.evoal.languages.model.base.RealLiteral
	 * @generated
	 */
	EClass getRealLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.RealLiteral#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal</em>'.
	 * @see de.evoal.languages.model.base.RealLiteral#getLiteral()
	 * @see #getRealLiteral()
	 * @generated
	 */
	EAttribute getRealLiteral_Literal();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.RealLiteral#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see de.evoal.languages.model.base.RealLiteral#getValue()
	 * @generated
	 */
	EOperation getRealLiteral__GetValue();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal</em>'.
	 * @see de.evoal.languages.model.base.StringLiteral
	 * @generated
	 */
	EClass getStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.StringLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.evoal.languages.model.base.StringLiteral#getValue()
	 * @see #getStringLiteral()
	 * @generated
	 */
	EAttribute getStringLiteral_Value();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal</em>'.
	 * @see de.evoal.languages.model.base.BooleanLiteral
	 * @generated
	 */
	EClass getBooleanLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.BooleanLiteral#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.evoal.languages.model.base.BooleanLiteral#isValue()
	 * @see #getBooleanLiteral()
	 * @generated
	 */
	EAttribute getBooleanLiteral_Value();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.BooleanLiteral#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see de.evoal.languages.model.base.BooleanLiteral#getValue()
	 * @generated
	 */
	EOperation getBooleanLiteral__GetValue();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.Call <em>Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call</em>'.
	 * @see de.evoal.languages.model.base.Call
	 * @generated
	 */
	EClass getCall();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.Call#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Function</em>'.
	 * @see de.evoal.languages.model.base.Call#getFunction()
	 * @see #getCall()
	 * @generated
	 */
	EReference getCall_Function();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.Call#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.evoal.languages.model.base.Call#getParameters()
	 * @see #getCall()
	 * @generated
	 */
	EReference getCall_Parameters();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.Parantheses <em>Parantheses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parantheses</em>'.
	 * @see de.evoal.languages.model.base.Parantheses
	 * @generated
	 */
	EClass getParantheses();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.Parantheses#getSubExpression <em>Sub Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Expression</em>'.
	 * @see de.evoal.languages.model.base.Parantheses#getSubExpression()
	 * @see #getParantheses()
	 * @generated
	 */
	EReference getParantheses_SubExpression();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.FunctionName <em>Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Name</em>'.
	 * @see de.evoal.languages.model.base.FunctionName
	 * @generated
	 */
	EClass getFunctionName();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.ValueReference <em>Value Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Reference</em>'.
	 * @see de.evoal.languages.model.base.ValueReference
	 * @generated
	 */
	EClass getValueReference();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.TypeDefinition <em>Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Definition</em>'.
	 * @see de.evoal.languages.model.base.TypeDefinition
	 * @generated
	 */
	EClass getTypeDefinition();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.TypeDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.base.TypeDefinition#getName()
	 * @see #getTypeDefinition()
	 * @generated
	 */
	EAttribute getTypeDefinition_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.TypeDefinition#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see de.evoal.languages.model.base.TypeDefinition#getAttributes()
	 * @see #getTypeDefinition()
	 * @generated
	 */
	EReference getTypeDefinition_Attributes();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.base.TypeDefinition#getSuperType <em>Super Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Type</em>'.
	 * @see de.evoal.languages.model.base.TypeDefinition#getSuperType()
	 * @see #getTypeDefinition()
	 * @generated
	 */
	EReference getTypeDefinition_SuperType();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.TypeDefinition#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see de.evoal.languages.model.base.TypeDefinition#isAbstract()
	 * @see #getTypeDefinition()
	 * @generated
	 */
	EAttribute getTypeDefinition_Abstract();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.TypeDefinition#findAttribute(java.lang.String) <em>Find Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Find Attribute</em>' operation.
	 * @see de.evoal.languages.model.base.TypeDefinition#findAttribute(java.lang.String)
	 * @generated
	 */
	EOperation getTypeDefinition__FindAttribute__String();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.AttributeDefinition <em>Attribute Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Definition</em>'.
	 * @see de.evoal.languages.model.base.AttributeDefinition
	 * @generated
	 */
	EClass getAttributeDefinition();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.AttributeDefinition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see de.evoal.languages.model.base.AttributeDefinition#getType()
	 * @see #getAttributeDefinition()
	 * @generated
	 */
	EReference getAttributeDefinition_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.AttributeDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.base.AttributeDefinition#getName()
	 * @see #getAttributeDefinition()
	 * @generated
	 */
	EAttribute getAttributeDefinition_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.AttributeDefinition#getInitialisation <em>Initialisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialisation</em>'.
	 * @see de.evoal.languages.model.base.AttributeDefinition#getInitialisation()
	 * @see #getAttributeDefinition()
	 * @generated
	 */
	EReference getAttributeDefinition_Initialisation();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see de.evoal.languages.model.base.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.InstanceType <em>Instance Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Type</em>'.
	 * @see de.evoal.languages.model.base.InstanceType
	 * @generated
	 */
	EClass getInstanceType();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.base.InstanceType#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.base.InstanceType#getDefinition()
	 * @see #getInstanceType()
	 * @generated
	 */
	EReference getInstanceType_Definition();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.LiteralType <em>Literal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Type</em>'.
	 * @see de.evoal.languages.model.base.LiteralType
	 * @generated
	 */
	EClass getLiteralType();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Type</em>'.
	 * @see de.evoal.languages.model.base.StringType
	 * @generated
	 */
	EClass getStringType();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.IntType <em>Int Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Type</em>'.
	 * @see de.evoal.languages.model.base.IntType
	 * @generated
	 */
	EClass getIntType();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.RealType <em>Real Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Type</em>'.
	 * @see de.evoal.languages.model.base.RealType
	 * @generated
	 */
	EClass getRealType();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Type</em>'.
	 * @see de.evoal.languages.model.base.BooleanType
	 * @generated
	 */
	EClass getBooleanType();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.VoidType <em>Void Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Void Type</em>'.
	 * @see de.evoal.languages.model.base.VoidType
	 * @generated
	 */
	EClass getVoidType();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.ExpressionType <em>Expression Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Type</em>'.
	 * @see de.evoal.languages.model.base.ExpressionType
	 * @generated
	 */
	EClass getExpressionType();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see de.evoal.languages.model.base.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.ArrayType <em>Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Type</em>'.
	 * @see de.evoal.languages.model.base.ArrayType
	 * @generated
	 */
	EClass getArrayType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.ArrayType#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see de.evoal.languages.model.base.ArrayType#getElements()
	 * @see #getArrayType()
	 * @generated
	 */
	EReference getArrayType_Elements();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.FunctionDefinition <em>Function Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Definition</em>'.
	 * @see de.evoal.languages.model.base.FunctionDefinition
	 * @generated
	 */
	EClass getFunctionDefinition();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.FunctionDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.base.FunctionDefinition#getName()
	 * @see #getFunctionDefinition()
	 * @generated
	 */
	EAttribute getFunctionDefinition_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.FunctionDefinition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see de.evoal.languages.model.base.FunctionDefinition#getType()
	 * @see #getFunctionDefinition()
	 * @generated
	 */
	EReference getFunctionDefinition_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.FunctionDefinition#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.evoal.languages.model.base.FunctionDefinition#getParameters()
	 * @see #getFunctionDefinition()
	 * @generated
	 */
	EReference getFunctionDefinition_Parameters();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see de.evoal.languages.model.base.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.base.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.Parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see de.evoal.languages.model.base.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Type();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.DefinedFunctionName <em>Defined Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Defined Function Name</em>'.
	 * @see de.evoal.languages.model.base.DefinedFunctionName
	 * @generated
	 */
	EClass getDefinedFunctionName();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.base.DefinedFunctionName#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.base.DefinedFunctionName#getDefinition()
	 * @see #getDefinedFunctionName()
	 * @generated
	 */
	EReference getDefinedFunctionName_Definition();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.ConstantDefinition <em>Constant Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Definition</em>'.
	 * @see de.evoal.languages.model.base.ConstantDefinition
	 * @generated
	 */
	EClass getConstantDefinition();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.ConstantDefinition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see de.evoal.languages.model.base.ConstantDefinition#getType()
	 * @see #getConstantDefinition()
	 * @generated
	 */
	EReference getConstantDefinition_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.ConstantDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.base.ConstantDefinition#getName()
	 * @see #getConstantDefinition()
	 * @generated
	 */
	EAttribute getConstantDefinition_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.ConstantDefinition#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see de.evoal.languages.model.base.ConstantDefinition#getValue()
	 * @see #getConstantDefinition()
	 * @generated
	 */
	EReference getConstantDefinition_Value();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.ConstantReference <em>Constant Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Reference</em>'.
	 * @see de.evoal.languages.model.base.ConstantReference
	 * @generated
	 */
	EClass getConstantReference();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.base.ConstantReference#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.base.ConstantReference#getDefinition()
	 * @see #getConstantReference()
	 * @generated
	 */
	EReference getConstantReference_Definition();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.Array <em>Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array</em>'.
	 * @see de.evoal.languages.model.base.Array
	 * @generated
	 */
	EClass getArray();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.Array#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see de.evoal.languages.model.base.Array#getValues()
	 * @see #getArray()
	 * @generated
	 */
	EReference getArray_Values();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.Instance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance</em>'.
	 * @see de.evoal.languages.model.base.Instance
	 * @generated
	 */
	EClass getInstance();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.base.Instance#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.base.Instance#getDefinition()
	 * @see #getInstance()
	 * @generated
	 */
	EReference getInstance_Definition();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.Instance#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see de.evoal.languages.model.base.Instance#getAttributes()
	 * @see #getInstance()
	 * @generated
	 */
	EReference getInstance_Attributes();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.Instance#findAttribute(java.lang.String) <em>Find Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Find Attribute</em>' operation.
	 * @see de.evoal.languages.model.base.Instance#findAttribute(java.lang.String)
	 * @generated
	 */
	EOperation getInstance__FindAttribute__String();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see de.evoal.languages.model.base.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.base.Attribute#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.base.Attribute#getDefinition()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Definition();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.Attribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see de.evoal.languages.model.base.Attribute#getValue()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Value();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see de.evoal.languages.model.base.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.Import#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see de.evoal.languages.model.base.Import#getLanguage()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_Language();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.Import#getImportedNamespace <em>Imported Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imported Namespace</em>'.
	 * @see de.evoal.languages.model.base.Import#getImportedNamespace()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_ImportedNamespace();

	/**
	 * Returns the meta object for enum '{@link de.evoal.languages.model.base.ComparisonOperator <em>Comparison Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Comparison Operator</em>'.
	 * @see de.evoal.languages.model.base.ComparisonOperator
	 * @generated
	 */
	EEnum getComparisonOperator();

	/**
	 * Returns the meta object for enum '{@link de.evoal.languages.model.base.AddOrSubtractOperator <em>Add Or Subtract Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Add Or Subtract Operator</em>'.
	 * @see de.evoal.languages.model.base.AddOrSubtractOperator
	 * @generated
	 */
	EEnum getAddOrSubtractOperator();

	/**
	 * Returns the meta object for enum '{@link de.evoal.languages.model.base.MultiplyDivideModuloOperator <em>Multiply Divide Modulo Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Multiply Divide Modulo Operator</em>'.
	 * @see de.evoal.languages.model.base.MultiplyDivideModuloOperator
	 * @generated
	 */
	EEnum getMultiplyDivideModuloOperator();

	/**
	 * Returns the meta object for enum '{@link de.evoal.languages.model.base.Factor <em>Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Factor</em>'.
	 * @see de.evoal.languages.model.base.Factor
	 * @generated
	 */
	EEnum getFactor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BaseFactory getBaseFactory();

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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.ExpressionImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.OrExpressionImpl <em>Or Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.OrExpressionImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getOrExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.XorExpressionImpl <em>Xor Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.XorExpressionImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getXorExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.AndExpressionImpl <em>And Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.AndExpressionImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getAndExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.NotExpressionImpl <em>Not Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.NotExpressionImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getNotExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.ComparisonExpressionImpl <em>Comparison Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.ComparisonExpressionImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getComparisonExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.PartialComparisonExpressionImpl <em>Partial Comparison Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.PartialComparisonExpressionImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getPartialComparisonExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.AddOrSubtractExpressionImpl <em>Add Or Subtract Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.AddOrSubtractExpressionImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getAddOrSubtractExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.MultiplyDivideModuloExpressionImpl <em>Multiply Divide Modulo Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.MultiplyDivideModuloExpressionImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getMultiplyDivideModuloExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.PowerOfExpressionImpl <em>Power Of Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.PowerOfExpressionImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getPowerOfExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.UnaryAddOrSubtractExpressionImpl <em>Unary Add Or Subtract Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.UnaryAddOrSubtractExpressionImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getUnaryAddOrSubtractExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.ValueImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.LiteralImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getLiteral()
		 * @generated
		 */
		EClass LITERAL = eINSTANCE.getLiteral();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL___GET_VALUE = eINSTANCE.getLiteral__GetValue();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.NumberLiteralImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getNumberLiteral()
		 * @generated
		 */
		EClass NUMBER_LITERAL = eINSTANCE.getNumberLiteral();

		/**
		 * The meta object literal for the '<em><b>Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_LITERAL__FACTOR = eINSTANCE.getNumberLiteral_Factor();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NUMBER_LITERAL___GET_VALUE = eINSTANCE.getNumberLiteral__GetValue();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.IntegerLiteralImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getIntegerLiteral()
		 * @generated
		 */
		EClass INTEGER_LITERAL = eINSTANCE.getIntegerLiteral();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL__LITERAL = eINSTANCE.getIntegerLiteral_Literal();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INTEGER_LITERAL___GET_VALUE = eINSTANCE.getIntegerLiteral__GetValue();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.RealLiteralImpl <em>Real Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.RealLiteralImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getRealLiteral()
		 * @generated
		 */
		EClass REAL_LITERAL = eINSTANCE.getRealLiteral();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_LITERAL__LITERAL = eINSTANCE.getRealLiteral_Literal();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REAL_LITERAL___GET_VALUE = eINSTANCE.getRealLiteral__GetValue();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.StringLiteralImpl <em>String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.StringLiteralImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getStringLiteral()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.BooleanLiteralImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getBooleanLiteral()
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
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOOLEAN_LITERAL___GET_VALUE = eINSTANCE.getBooleanLiteral__GetValue();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.CallImpl <em>Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.CallImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getCall()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.ParanthesesImpl <em>Parantheses</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.ParanthesesImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getParantheses()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.FunctionNameImpl <em>Function Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.FunctionNameImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getFunctionName()
		 * @generated
		 */
		EClass FUNCTION_NAME = eINSTANCE.getFunctionName();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.ValueReferenceImpl <em>Value Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.ValueReferenceImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getValueReference()
		 * @generated
		 */
		EClass VALUE_REFERENCE = eINSTANCE.getValueReference();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.TypeDefinitionImpl <em>Type Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.TypeDefinitionImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getTypeDefinition()
		 * @generated
		 */
		EClass TYPE_DEFINITION = eINSTANCE.getTypeDefinition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_DEFINITION__NAME = eINSTANCE.getTypeDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_DEFINITION__ATTRIBUTES = eINSTANCE.getTypeDefinition_Attributes();

		/**
		 * The meta object literal for the '<em><b>Super Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_DEFINITION__SUPER_TYPE = eINSTANCE.getTypeDefinition_SuperType();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_DEFINITION__ABSTRACT = eINSTANCE.getTypeDefinition_Abstract();

		/**
		 * The meta object literal for the '<em><b>Find Attribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_DEFINITION___FIND_ATTRIBUTE__STRING = eINSTANCE.getTypeDefinition__FindAttribute__String();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.AttributeDefinitionImpl <em>Attribute Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.AttributeDefinitionImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getAttributeDefinition()
		 * @generated
		 */
		EClass ATTRIBUTE_DEFINITION = eINSTANCE.getAttributeDefinition();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_DEFINITION__TYPE = eINSTANCE.getAttributeDefinition_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_DEFINITION__NAME = eINSTANCE.getAttributeDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Initialisation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_DEFINITION__INITIALISATION = eINSTANCE.getAttributeDefinition_Initialisation();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.TypeImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.InstanceTypeImpl <em>Instance Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.InstanceTypeImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getInstanceType()
		 * @generated
		 */
		EClass INSTANCE_TYPE = eINSTANCE.getInstanceType();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_TYPE__DEFINITION = eINSTANCE.getInstanceType_Definition();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.LiteralTypeImpl <em>Literal Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.LiteralTypeImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getLiteralType()
		 * @generated
		 */
		EClass LITERAL_TYPE = eINSTANCE.getLiteralType();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.StringTypeImpl <em>String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.StringTypeImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getStringType()
		 * @generated
		 */
		EClass STRING_TYPE = eINSTANCE.getStringType();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.IntTypeImpl <em>Int Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.IntTypeImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getIntType()
		 * @generated
		 */
		EClass INT_TYPE = eINSTANCE.getIntType();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.RealTypeImpl <em>Real Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.RealTypeImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getRealType()
		 * @generated
		 */
		EClass REAL_TYPE = eINSTANCE.getRealType();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.BooleanTypeImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getBooleanType()
		 * @generated
		 */
		EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.VoidTypeImpl <em>Void Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.VoidTypeImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getVoidType()
		 * @generated
		 */
		EClass VOID_TYPE = eINSTANCE.getVoidType();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.ExpressionTypeImpl <em>Expression Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.ExpressionTypeImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getExpressionType()
		 * @generated
		 */
		EClass EXPRESSION_TYPE = eINSTANCE.getExpressionType();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.DataTypeImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.ArrayTypeImpl <em>Array Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.ArrayTypeImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getArrayType()
		 * @generated
		 */
		EClass ARRAY_TYPE = eINSTANCE.getArrayType();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_TYPE__ELEMENTS = eINSTANCE.getArrayType_Elements();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.FunctionDefinitionImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getFunctionDefinition()
		 * @generated
		 */
		EClass FUNCTION_DEFINITION = eINSTANCE.getFunctionDefinition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_DEFINITION__NAME = eINSTANCE.getFunctionDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DEFINITION__TYPE = eINSTANCE.getFunctionDefinition_Type();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DEFINITION__PARAMETERS = eINSTANCE.getFunctionDefinition_Parameters();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.ParameterImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__TYPE = eINSTANCE.getParameter_Type();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.DefinedFunctionNameImpl <em>Defined Function Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.DefinedFunctionNameImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getDefinedFunctionName()
		 * @generated
		 */
		EClass DEFINED_FUNCTION_NAME = eINSTANCE.getDefinedFunctionName();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFINED_FUNCTION_NAME__DEFINITION = eINSTANCE.getDefinedFunctionName_Definition();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.ConstantDefinitionImpl <em>Constant Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.ConstantDefinitionImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getConstantDefinition()
		 * @generated
		 */
		EClass CONSTANT_DEFINITION = eINSTANCE.getConstantDefinition();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTANT_DEFINITION__TYPE = eINSTANCE.getConstantDefinition_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTANT_DEFINITION__NAME = eINSTANCE.getConstantDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTANT_DEFINITION__VALUE = eINSTANCE.getConstantDefinition_Value();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.ConstantReferenceImpl <em>Constant Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.ConstantReferenceImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getConstantReference()
		 * @generated
		 */
		EClass CONSTANT_REFERENCE = eINSTANCE.getConstantReference();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTANT_REFERENCE__DEFINITION = eINSTANCE.getConstantReference_Definition();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.ArrayImpl <em>Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.ArrayImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getArray()
		 * @generated
		 */
		EClass ARRAY = eINSTANCE.getArray();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY__VALUES = eINSTANCE.getArray_Values();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.InstanceImpl <em>Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.InstanceImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getInstance()
		 * @generated
		 */
		EClass INSTANCE = eINSTANCE.getInstance();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE__DEFINITION = eINSTANCE.getInstance_Definition();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE__ATTRIBUTES = eINSTANCE.getInstance_Attributes();

		/**
		 * The meta object literal for the '<em><b>Find Attribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INSTANCE___FIND_ATTRIBUTE__STRING = eINSTANCE.getInstance__FindAttribute__String();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.AttributeImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__DEFINITION = eINSTANCE.getAttribute_Definition();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.impl.ImportImpl
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__LANGUAGE = eINSTANCE.getImport_Language();

		/**
		 * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__IMPORTED_NAMESPACE = eINSTANCE.getImport_ImportedNamespace();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.ComparisonOperator <em>Comparison Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.ComparisonOperator
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getComparisonOperator()
		 * @generated
		 */
		EEnum COMPARISON_OPERATOR = eINSTANCE.getComparisonOperator();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.AddOrSubtractOperator <em>Add Or Subtract Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.AddOrSubtractOperator
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getAddOrSubtractOperator()
		 * @generated
		 */
		EEnum ADD_OR_SUBTRACT_OPERATOR = eINSTANCE.getAddOrSubtractOperator();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.MultiplyDivideModuloOperator <em>Multiply Divide Modulo Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.MultiplyDivideModuloOperator
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getMultiplyDivideModuloOperator()
		 * @generated
		 */
		EEnum MULTIPLY_DIVIDE_MODULO_OPERATOR = eINSTANCE.getMultiplyDivideModuloOperator();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.Factor <em>Factor</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.Factor
		 * @see de.evoal.languages.model.base.impl.BasePackageImpl#getFactor()
		 * @generated
		 */
		EEnum FACTOR = eINSTANCE.getFactor();

	}

} //BasePackage
