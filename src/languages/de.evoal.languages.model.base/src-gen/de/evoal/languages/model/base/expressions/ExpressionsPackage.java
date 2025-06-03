/**
 */
package de.evoal.languages.model.base.expressions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * <!-- begin-model-doc -->
 * 
 * Package for all expression-like model elements.
 * 
 * <!-- end-model-doc -->
 * @see de.evoal.languages.model.base.expressions.ExpressionsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import defs='definitions.ecore#/' ecore='http://www.eclipse.org/emf/2002/Ecore' types='types.ecore#/'"
 * @generated
 */
public interface ExpressionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "expressions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.evoal.de/languages/base/expressions/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "expr";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionsPackage eINSTANCE = de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getExpression()
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
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.ReadExpressionImpl <em>Read Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.ReadExpressionImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getReadExpression()
	 * @generated
	 */
	int READ_EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Read Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Read Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.ConstantExpressionImpl <em>Constant Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.ConstantExpressionImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getConstantExpression()
	 * @generated
	 */
	int CONSTANT_EXPRESSION = 2;

	/**
	 * The number of structural features of the '<em>Constant Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_EXPRESSION_FEATURE_COUNT = READ_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Constant Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_EXPRESSION_OPERATION_COUNT = READ_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.WriteExpressionImpl <em>Write Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.WriteExpressionImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getWriteExpression()
	 * @generated
	 */
	int WRITE_EXPRESSION = 3;

	/**
	 * The number of structural features of the '<em>Write Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Write Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.OrExpressionImpl <em>Or Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.OrExpressionImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getOrExpression()
	 * @generated
	 */
	int OR_EXPRESSION = 4;

	/**
	 * The feature id for the '<em><b>Sub Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION__SUB_EXPRESSIONS = READ_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Or Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION_FEATURE_COUNT = READ_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Or Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION_OPERATION_COUNT = READ_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.XorExpressionImpl <em>Xor Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.XorExpressionImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getXorExpression()
	 * @generated
	 */
	int XOR_EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Sub Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_EXPRESSION__SUB_EXPRESSIONS = READ_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Xor Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_EXPRESSION_FEATURE_COUNT = READ_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Xor Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_EXPRESSION_OPERATION_COUNT = READ_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.AndExpressionImpl <em>And Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.AndExpressionImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getAndExpression()
	 * @generated
	 */
	int AND_EXPRESSION = 6;

	/**
	 * The feature id for the '<em><b>Sub Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION__SUB_EXPRESSIONS = READ_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION_FEATURE_COUNT = READ_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION_OPERATION_COUNT = READ_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.NotExpressionImpl <em>Not Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.NotExpressionImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getNotExpression()
	 * @generated
	 */
	int NOT_EXPRESSION = 7;

	/**
	 * The feature id for the '<em><b>Negated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION__NEGATED = READ_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION__OPERAND = READ_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Not Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION_FEATURE_COUNT = READ_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Not Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION_OPERATION_COUNT = READ_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.ComparisonExpressionImpl <em>Comparison Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.ComparisonExpressionImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getComparisonExpression()
	 * @generated
	 */
	int COMPARISON_EXPRESSION = 8;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON_EXPRESSION__LEFT_OPERAND = READ_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comparison</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON_EXPRESSION__COMPARISON = READ_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Comparison Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON_EXPRESSION_FEATURE_COUNT = READ_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Comparison Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON_EXPRESSION_OPERATION_COUNT = READ_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.PartialComparisonExpressionImpl <em>Partial Comparison Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.PartialComparisonExpressionImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getPartialComparisonExpression()
	 * @generated
	 */
	int PARTIAL_COMPARISON_EXPRESSION = 9;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_COMPARISON_EXPRESSION__OPERATOR = READ_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_COMPARISON_EXPRESSION__SUB_EXPRESSION = READ_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Partial Comparison Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_COMPARISON_EXPRESSION_FEATURE_COUNT = READ_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Partial Comparison Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_COMPARISON_EXPRESSION_OPERATION_COUNT = READ_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.AddOrSubtractExpressionImpl <em>Add Or Subtract Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.AddOrSubtractExpressionImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getAddOrSubtractExpression()
	 * @generated
	 */
	int ADD_OR_SUBTRACT_EXPRESSION = 10;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OR_SUBTRACT_EXPRESSION__LEFT_OPERAND = READ_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OR_SUBTRACT_EXPRESSION__OPERATORS = READ_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OR_SUBTRACT_EXPRESSION__OPERANDS = READ_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Add Or Subtract Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OR_SUBTRACT_EXPRESSION_FEATURE_COUNT = READ_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Add Or Subtract Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OR_SUBTRACT_EXPRESSION_OPERATION_COUNT = READ_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.MultiplyDivideModuloExpressionImpl <em>Multiply Divide Modulo Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.MultiplyDivideModuloExpressionImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getMultiplyDivideModuloExpression()
	 * @generated
	 */
	int MULTIPLY_DIVIDE_MODULO_EXPRESSION = 11;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_DIVIDE_MODULO_EXPRESSION__LEFT_OPERAND = READ_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERATORS = READ_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERANDS = READ_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Multiply Divide Modulo Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_DIVIDE_MODULO_EXPRESSION_FEATURE_COUNT = READ_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Multiply Divide Modulo Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_DIVIDE_MODULO_EXPRESSION_OPERATION_COUNT = READ_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.PowerOfExpressionImpl <em>Power Of Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.PowerOfExpressionImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getPowerOfExpression()
	 * @generated
	 */
	int POWER_OF_EXPRESSION = 12;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_OF_EXPRESSION__LEFT_OPERAND = READ_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_OF_EXPRESSION__RIGHT_OPERAND = READ_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Power Of Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_OF_EXPRESSION_FEATURE_COUNT = READ_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Power Of Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_OF_EXPRESSION_OPERATION_COUNT = READ_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.UnaryAddOrSubtractExpressionImpl <em>Unary Add Or Subtract Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.UnaryAddOrSubtractExpressionImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getUnaryAddOrSubtractExpression()
	 * @generated
	 */
	int UNARY_ADD_OR_SUBTRACT_EXPRESSION = 13;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_ADD_OR_SUBTRACT_EXPRESSION__OPERATORS = READ_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_ADD_OR_SUBTRACT_EXPRESSION__SUB_EXPRESSION = READ_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unary Add Or Subtract Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_ADD_OR_SUBTRACT_EXPRESSION_FEATURE_COUNT = READ_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Unary Add Or Subtract Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_ADD_OR_SUBTRACT_EXPRESSION_OPERATION_COUNT = READ_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.LiteralImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getLiteral()
	 * @generated
	 */
	int LITERAL = 14;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FEATURE_COUNT = CONSTANT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL___GET_VALUE = CONSTANT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_OPERATION_COUNT = CONSTANT_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.NumberLiteralImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getNumberLiteral()
	 * @generated
	 */
	int NUMBER_LITERAL = 15;

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
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.IntegerLiteralImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getIntegerLiteral()
	 * @generated
	 */
	int INTEGER_LITERAL = 16;

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
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.RealLiteralImpl <em>Real Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.RealLiteralImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getRealLiteral()
	 * @generated
	 */
	int REAL_LITERAL = 17;

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
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.StringLiteralImpl <em>String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.StringLiteralImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getStringLiteral()
	 * @generated
	 */
	int STRING_LITERAL = 18;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__LITERAL = LITERAL_FEATURE_COUNT + 0;

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
	int STRING_LITERAL___GET_VALUE = LITERAL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_OPERATION_COUNT = LITERAL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.InstanceImpl <em>Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.InstanceImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getInstance()
	 * @generated
	 */
	int INSTANCE = 19;

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
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.AttributeImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 20;

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
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.ValueReferenceImpl <em>Value Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.ValueReferenceImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getValueReference()
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
	int VALUE_REFERENCE_FEATURE_COUNT = CONSTANT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Value Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_REFERENCE_OPERATION_COUNT = CONSTANT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.SelfReferenceImpl <em>Self Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.SelfReferenceImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getSelfReference()
	 * @generated
	 */
	int SELF_REFERENCE = 22;

	/**
	 * The number of structural features of the '<em>Self Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_REFERENCE_FEATURE_COUNT = VALUE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Self Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_REFERENCE_OPERATION_COUNT = VALUE_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.LiteralDefinitionReferenceImpl <em>Literal Definition Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.LiteralDefinitionReferenceImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getLiteralDefinitionReference()
	 * @generated
	 */
	int LITERAL_DEFINITION_REFERENCE = 23;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DEFINITION_REFERENCE__DEFINITION = VALUE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Definition Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DEFINITION_REFERENCE_FEATURE_COUNT = VALUE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Definition Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DEFINITION_REFERENCE_OPERATION_COUNT = VALUE_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.TypeDefinitionReferenceImpl <em>Type Definition Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.TypeDefinitionReferenceImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getTypeDefinitionReference()
	 * @generated
	 */
	int TYPE_DEFINITION_REFERENCE = 24;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITION_REFERENCE__DEFINITION = VALUE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Definition Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITION_REFERENCE_FEATURE_COUNT = VALUE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Type Definition Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITION_REFERENCE_OPERATION_COUNT = VALUE_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.BooleanLiteralImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getBooleanLiteral()
	 * @generated
	 */
	int BOOLEAN_LITERAL = 25;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__LITERAL = LITERAL_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.CallImpl <em>Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.CallImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getCall()
	 * @generated
	 */
	int CALL = 26;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__FUNCTION = READ_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__PARAMETERS = READ_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FEATURE_COUNT = READ_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_COUNT = READ_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.ParanthesesImpl <em>Parantheses</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.ParanthesesImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getParantheses()
	 * @generated
	 */
	int PARANTHESES = 27;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARANTHESES__SUB_EXPRESSION = READ_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parantheses</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARANTHESES_FEATURE_COUNT = READ_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Parantheses</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARANTHESES_OPERATION_COUNT = READ_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.impl.ArrayImpl <em>Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.impl.ArrayImpl
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getArray()
	 * @generated
	 */
	int ARRAY = 28;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY__VALUES = READ_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_FEATURE_COUNT = READ_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_OPERATION_COUNT = READ_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.ComparisonOperator <em>Comparison Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.ComparisonOperator
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getComparisonOperator()
	 * @generated
	 */
	int COMPARISON_OPERATOR = 29;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.AddOrSubtractOperator <em>Add Or Subtract Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.AddOrSubtractOperator
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getAddOrSubtractOperator()
	 * @generated
	 */
	int ADD_OR_SUBTRACT_OPERATOR = 30;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.MultiplyDivideModuloOperator <em>Multiply Divide Modulo Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.MultiplyDivideModuloOperator
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getMultiplyDivideModuloOperator()
	 * @generated
	 */
	int MULTIPLY_DIVIDE_MODULO_OPERATOR = 31;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.expressions.Factor <em>Factor</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.expressions.Factor
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getFactor()
	 * @generated
	 */
	int FACTOR = 32;

	/**
	 * The meta object id for the '<em>Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Number
	 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getNumber()
	 * @generated
	 */
	int NUMBER = 33;


	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see de.evoal.languages.model.base.expressions.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.ReadExpression <em>Read Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Read Expression</em>'.
	 * @see de.evoal.languages.model.base.expressions.ReadExpression
	 * @generated
	 */
	EClass getReadExpression();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.ConstantExpression <em>Constant Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Expression</em>'.
	 * @see de.evoal.languages.model.base.expressions.ConstantExpression
	 * @generated
	 */
	EClass getConstantExpression();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.WriteExpression <em>Write Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Write Expression</em>'.
	 * @see de.evoal.languages.model.base.expressions.WriteExpression
	 * @generated
	 */
	EClass getWriteExpression();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.OrExpression <em>Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Expression</em>'.
	 * @see de.evoal.languages.model.base.expressions.OrExpression
	 * @generated
	 */
	EClass getOrExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.expressions.OrExpression#getSubExpressions <em>Sub Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Expressions</em>'.
	 * @see de.evoal.languages.model.base.expressions.OrExpression#getSubExpressions()
	 * @see #getOrExpression()
	 * @generated
	 */
	EReference getOrExpression_SubExpressions();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.XorExpression <em>Xor Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xor Expression</em>'.
	 * @see de.evoal.languages.model.base.expressions.XorExpression
	 * @generated
	 */
	EClass getXorExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.expressions.XorExpression#getSubExpressions <em>Sub Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Expressions</em>'.
	 * @see de.evoal.languages.model.base.expressions.XorExpression#getSubExpressions()
	 * @see #getXorExpression()
	 * @generated
	 */
	EReference getXorExpression_SubExpressions();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.AndExpression <em>And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Expression</em>'.
	 * @see de.evoal.languages.model.base.expressions.AndExpression
	 * @generated
	 */
	EClass getAndExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.expressions.AndExpression#getSubExpressions <em>Sub Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Expressions</em>'.
	 * @see de.evoal.languages.model.base.expressions.AndExpression#getSubExpressions()
	 * @see #getAndExpression()
	 * @generated
	 */
	EReference getAndExpression_SubExpressions();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.NotExpression <em>Not Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Expression</em>'.
	 * @see de.evoal.languages.model.base.expressions.NotExpression
	 * @generated
	 */
	EClass getNotExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.expressions.NotExpression#isNegated <em>Negated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Negated</em>'.
	 * @see de.evoal.languages.model.base.expressions.NotExpression#isNegated()
	 * @see #getNotExpression()
	 * @generated
	 */
	EAttribute getNotExpression_Negated();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.expressions.NotExpression#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see de.evoal.languages.model.base.expressions.NotExpression#getOperand()
	 * @see #getNotExpression()
	 * @generated
	 */
	EReference getNotExpression_Operand();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.ComparisonExpression <em>Comparison Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comparison Expression</em>'.
	 * @see de.evoal.languages.model.base.expressions.ComparisonExpression
	 * @generated
	 */
	EClass getComparisonExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.expressions.ComparisonExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see de.evoal.languages.model.base.expressions.ComparisonExpression#getLeftOperand()
	 * @see #getComparisonExpression()
	 * @generated
	 */
	EReference getComparisonExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.expressions.ComparisonExpression#getComparison <em>Comparison</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Comparison</em>'.
	 * @see de.evoal.languages.model.base.expressions.ComparisonExpression#getComparison()
	 * @see #getComparisonExpression()
	 * @generated
	 */
	EReference getComparisonExpression_Comparison();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.PartialComparisonExpression <em>Partial Comparison Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partial Comparison Expression</em>'.
	 * @see de.evoal.languages.model.base.expressions.PartialComparisonExpression
	 * @generated
	 */
	EClass getPartialComparisonExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.expressions.PartialComparisonExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see de.evoal.languages.model.base.expressions.PartialComparisonExpression#getOperator()
	 * @see #getPartialComparisonExpression()
	 * @generated
	 */
	EAttribute getPartialComparisonExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.expressions.PartialComparisonExpression#getSubExpression <em>Sub Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Expression</em>'.
	 * @see de.evoal.languages.model.base.expressions.PartialComparisonExpression#getSubExpression()
	 * @see #getPartialComparisonExpression()
	 * @generated
	 */
	EReference getPartialComparisonExpression_SubExpression();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.AddOrSubtractExpression <em>Add Or Subtract Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Or Subtract Expression</em>'.
	 * @see de.evoal.languages.model.base.expressions.AddOrSubtractExpression
	 * @generated
	 */
	EClass getAddOrSubtractExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.expressions.AddOrSubtractExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see de.evoal.languages.model.base.expressions.AddOrSubtractExpression#getLeftOperand()
	 * @see #getAddOrSubtractExpression()
	 * @generated
	 */
	EReference getAddOrSubtractExpression_LeftOperand();

	/**
	 * Returns the meta object for the attribute list '{@link de.evoal.languages.model.base.expressions.AddOrSubtractExpression#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see de.evoal.languages.model.base.expressions.AddOrSubtractExpression#getOperators()
	 * @see #getAddOrSubtractExpression()
	 * @generated
	 */
	EAttribute getAddOrSubtractExpression_Operators();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.expressions.AddOrSubtractExpression#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see de.evoal.languages.model.base.expressions.AddOrSubtractExpression#getOperands()
	 * @see #getAddOrSubtractExpression()
	 * @generated
	 */
	EReference getAddOrSubtractExpression_Operands();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression <em>Multiply Divide Modulo Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiply Divide Modulo Expression</em>'.
	 * @see de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression
	 * @generated
	 */
	EClass getMultiplyDivideModuloExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression#getLeftOperand()
	 * @see #getMultiplyDivideModuloExpression()
	 * @generated
	 */
	EReference getMultiplyDivideModuloExpression_LeftOperand();

	/**
	 * Returns the meta object for the attribute list '{@link de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression#getOperators()
	 * @see #getMultiplyDivideModuloExpression()
	 * @generated
	 */
	EAttribute getMultiplyDivideModuloExpression_Operators();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression#getOperands()
	 * @see #getMultiplyDivideModuloExpression()
	 * @generated
	 */
	EReference getMultiplyDivideModuloExpression_Operands();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.PowerOfExpression <em>Power Of Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Power Of Expression</em>'.
	 * @see de.evoal.languages.model.base.expressions.PowerOfExpression
	 * @generated
	 */
	EClass getPowerOfExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.expressions.PowerOfExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see de.evoal.languages.model.base.expressions.PowerOfExpression#getLeftOperand()
	 * @see #getPowerOfExpression()
	 * @generated
	 */
	EReference getPowerOfExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.expressions.PowerOfExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see de.evoal.languages.model.base.expressions.PowerOfExpression#getRightOperand()
	 * @see #getPowerOfExpression()
	 * @generated
	 */
	EReference getPowerOfExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.UnaryAddOrSubtractExpression <em>Unary Add Or Subtract Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Add Or Subtract Expression</em>'.
	 * @see de.evoal.languages.model.base.expressions.UnaryAddOrSubtractExpression
	 * @generated
	 */
	EClass getUnaryAddOrSubtractExpression();

	/**
	 * Returns the meta object for the attribute list '{@link de.evoal.languages.model.base.expressions.UnaryAddOrSubtractExpression#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see de.evoal.languages.model.base.expressions.UnaryAddOrSubtractExpression#getOperators()
	 * @see #getUnaryAddOrSubtractExpression()
	 * @generated
	 */
	EAttribute getUnaryAddOrSubtractExpression_Operators();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.expressions.UnaryAddOrSubtractExpression#getSubExpression <em>Sub Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Expression</em>'.
	 * @see de.evoal.languages.model.base.expressions.UnaryAddOrSubtractExpression#getSubExpression()
	 * @see #getUnaryAddOrSubtractExpression()
	 * @generated
	 */
	EReference getUnaryAddOrSubtractExpression_SubExpression();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see de.evoal.languages.model.base.expressions.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.expressions.Literal#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see de.evoal.languages.model.base.expressions.Literal#getValue()
	 * @generated
	 */
	EOperation getLiteral__GetValue();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.NumberLiteral <em>Number Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Literal</em>'.
	 * @see de.evoal.languages.model.base.expressions.NumberLiteral
	 * @generated
	 */
	EClass getNumberLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.expressions.NumberLiteral#getFactor <em>Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factor</em>'.
	 * @see de.evoal.languages.model.base.expressions.NumberLiteral#getFactor()
	 * @see #getNumberLiteral()
	 * @generated
	 */
	EAttribute getNumberLiteral_Factor();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.expressions.NumberLiteral#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see de.evoal.languages.model.base.expressions.NumberLiteral#getValue()
	 * @generated
	 */
	EOperation getNumberLiteral__GetValue();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal</em>'.
	 * @see de.evoal.languages.model.base.expressions.IntegerLiteral
	 * @generated
	 */
	EClass getIntegerLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.expressions.IntegerLiteral#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal</em>'.
	 * @see de.evoal.languages.model.base.expressions.IntegerLiteral#getLiteral()
	 * @see #getIntegerLiteral()
	 * @generated
	 */
	EAttribute getIntegerLiteral_Literal();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.expressions.IntegerLiteral#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see de.evoal.languages.model.base.expressions.IntegerLiteral#getValue()
	 * @generated
	 */
	EOperation getIntegerLiteral__GetValue();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.RealLiteral <em>Real Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Literal</em>'.
	 * @see de.evoal.languages.model.base.expressions.RealLiteral
	 * @generated
	 */
	EClass getRealLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.expressions.RealLiteral#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal</em>'.
	 * @see de.evoal.languages.model.base.expressions.RealLiteral#getLiteral()
	 * @see #getRealLiteral()
	 * @generated
	 */
	EAttribute getRealLiteral_Literal();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.expressions.RealLiteral#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see de.evoal.languages.model.base.expressions.RealLiteral#getValue()
	 * @generated
	 */
	EOperation getRealLiteral__GetValue();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal</em>'.
	 * @see de.evoal.languages.model.base.expressions.StringLiteral
	 * @generated
	 */
	EClass getStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.expressions.StringLiteral#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal</em>'.
	 * @see de.evoal.languages.model.base.expressions.StringLiteral#getLiteral()
	 * @see #getStringLiteral()
	 * @generated
	 */
	EAttribute getStringLiteral_Literal();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.expressions.StringLiteral#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see de.evoal.languages.model.base.expressions.StringLiteral#getValue()
	 * @generated
	 */
	EOperation getStringLiteral__GetValue();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.Instance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance</em>'.
	 * @see de.evoal.languages.model.base.expressions.Instance
	 * @generated
	 */
	EClass getInstance();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.base.expressions.Instance#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.base.expressions.Instance#getDefinition()
	 * @see #getInstance()
	 * @generated
	 */
	EReference getInstance_Definition();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.expressions.Instance#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see de.evoal.languages.model.base.expressions.Instance#getAttributes()
	 * @see #getInstance()
	 * @generated
	 */
	EReference getInstance_Attributes();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.expressions.Instance#findAttribute(java.lang.String) <em>Find Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Find Attribute</em>' operation.
	 * @see de.evoal.languages.model.base.expressions.Instance#findAttribute(java.lang.String)
	 * @generated
	 */
	EOperation getInstance__FindAttribute__String();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see de.evoal.languages.model.base.expressions.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.base.expressions.Attribute#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.base.expressions.Attribute#getDefinition()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Definition();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.expressions.Attribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see de.evoal.languages.model.base.expressions.Attribute#getValue()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Value();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.ValueReference <em>Value Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Reference</em>'.
	 * @see de.evoal.languages.model.base.expressions.ValueReference
	 * @generated
	 */
	EClass getValueReference();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.SelfReference <em>Self Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Self Reference</em>'.
	 * @see de.evoal.languages.model.base.expressions.SelfReference
	 * @generated
	 */
	EClass getSelfReference();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.LiteralDefinitionReference <em>Literal Definition Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Definition Reference</em>'.
	 * @see de.evoal.languages.model.base.expressions.LiteralDefinitionReference
	 * @generated
	 */
	EClass getLiteralDefinitionReference();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.base.expressions.LiteralDefinitionReference#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.base.expressions.LiteralDefinitionReference#getDefinition()
	 * @see #getLiteralDefinitionReference()
	 * @generated
	 */
	EReference getLiteralDefinitionReference_Definition();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.TypeDefinitionReference <em>Type Definition Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Definition Reference</em>'.
	 * @see de.evoal.languages.model.base.expressions.TypeDefinitionReference
	 * @generated
	 */
	EClass getTypeDefinitionReference();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.base.expressions.TypeDefinitionReference#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.base.expressions.TypeDefinitionReference#getDefinition()
	 * @see #getTypeDefinitionReference()
	 * @generated
	 */
	EReference getTypeDefinitionReference_Definition();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal</em>'.
	 * @see de.evoal.languages.model.base.expressions.BooleanLiteral
	 * @generated
	 */
	EClass getBooleanLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.expressions.BooleanLiteral#isLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal</em>'.
	 * @see de.evoal.languages.model.base.expressions.BooleanLiteral#isLiteral()
	 * @see #getBooleanLiteral()
	 * @generated
	 */
	EAttribute getBooleanLiteral_Literal();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.expressions.BooleanLiteral#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see de.evoal.languages.model.base.expressions.BooleanLiteral#getValue()
	 * @generated
	 */
	EOperation getBooleanLiteral__GetValue();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.Call <em>Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call</em>'.
	 * @see de.evoal.languages.model.base.expressions.Call
	 * @generated
	 */
	EClass getCall();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.base.expressions.Call#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see de.evoal.languages.model.base.expressions.Call#getFunction()
	 * @see #getCall()
	 * @generated
	 */
	EReference getCall_Function();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.expressions.Call#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.evoal.languages.model.base.expressions.Call#getParameters()
	 * @see #getCall()
	 * @generated
	 */
	EReference getCall_Parameters();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.Parantheses <em>Parantheses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parantheses</em>'.
	 * @see de.evoal.languages.model.base.expressions.Parantheses
	 * @generated
	 */
	EClass getParantheses();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.expressions.Parantheses#getSubExpression <em>Sub Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Expression</em>'.
	 * @see de.evoal.languages.model.base.expressions.Parantheses#getSubExpression()
	 * @see #getParantheses()
	 * @generated
	 */
	EReference getParantheses_SubExpression();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.expressions.Array <em>Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array</em>'.
	 * @see de.evoal.languages.model.base.expressions.Array
	 * @generated
	 */
	EClass getArray();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.expressions.Array#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see de.evoal.languages.model.base.expressions.Array#getValues()
	 * @see #getArray()
	 * @generated
	 */
	EReference getArray_Values();

	/**
	 * Returns the meta object for enum '{@link de.evoal.languages.model.base.expressions.ComparisonOperator <em>Comparison Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Comparison Operator</em>'.
	 * @see de.evoal.languages.model.base.expressions.ComparisonOperator
	 * @generated
	 */
	EEnum getComparisonOperator();

	/**
	 * Returns the meta object for enum '{@link de.evoal.languages.model.base.expressions.AddOrSubtractOperator <em>Add Or Subtract Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Add Or Subtract Operator</em>'.
	 * @see de.evoal.languages.model.base.expressions.AddOrSubtractOperator
	 * @generated
	 */
	EEnum getAddOrSubtractOperator();

	/**
	 * Returns the meta object for enum '{@link de.evoal.languages.model.base.expressions.MultiplyDivideModuloOperator <em>Multiply Divide Modulo Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Multiply Divide Modulo Operator</em>'.
	 * @see de.evoal.languages.model.base.expressions.MultiplyDivideModuloOperator
	 * @generated
	 */
	EEnum getMultiplyDivideModuloOperator();

	/**
	 * Returns the meta object for enum '{@link de.evoal.languages.model.base.expressions.Factor <em>Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Factor</em>'.
	 * @see de.evoal.languages.model.base.expressions.Factor
	 * @generated
	 */
	EEnum getFactor();

	/**
	 * Returns the meta object for data type '{@link java.lang.Number <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Number</em>'.
	 * @see java.lang.Number
	 * @model instanceClass="java.lang.Number" serializeable="false"
	 * @generated
	 */
	EDataType getNumber();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExpressionsFactory getExpressionsFactory();

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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.ReadExpressionImpl <em>Read Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.ReadExpressionImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getReadExpression()
		 * @generated
		 */
		EClass READ_EXPRESSION = eINSTANCE.getReadExpression();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.ConstantExpressionImpl <em>Constant Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.ConstantExpressionImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getConstantExpression()
		 * @generated
		 */
		EClass CONSTANT_EXPRESSION = eINSTANCE.getConstantExpression();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.WriteExpressionImpl <em>Write Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.WriteExpressionImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getWriteExpression()
		 * @generated
		 */
		EClass WRITE_EXPRESSION = eINSTANCE.getWriteExpression();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.OrExpressionImpl <em>Or Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.OrExpressionImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getOrExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.XorExpressionImpl <em>Xor Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.XorExpressionImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getXorExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.AndExpressionImpl <em>And Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.AndExpressionImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getAndExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.NotExpressionImpl <em>Not Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.NotExpressionImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getNotExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.ComparisonExpressionImpl <em>Comparison Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.ComparisonExpressionImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getComparisonExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.PartialComparisonExpressionImpl <em>Partial Comparison Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.PartialComparisonExpressionImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getPartialComparisonExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.AddOrSubtractExpressionImpl <em>Add Or Subtract Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.AddOrSubtractExpressionImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getAddOrSubtractExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.MultiplyDivideModuloExpressionImpl <em>Multiply Divide Modulo Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.MultiplyDivideModuloExpressionImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getMultiplyDivideModuloExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.PowerOfExpressionImpl <em>Power Of Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.PowerOfExpressionImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getPowerOfExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.UnaryAddOrSubtractExpressionImpl <em>Unary Add Or Subtract Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.UnaryAddOrSubtractExpressionImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getUnaryAddOrSubtractExpression()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.LiteralImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getLiteral()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.NumberLiteralImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getNumberLiteral()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.IntegerLiteralImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getIntegerLiteral()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.RealLiteralImpl <em>Real Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.RealLiteralImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getRealLiteral()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.StringLiteralImpl <em>String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.StringLiteralImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getStringLiteral()
		 * @generated
		 */
		EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL__LITERAL = eINSTANCE.getStringLiteral_Literal();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STRING_LITERAL___GET_VALUE = eINSTANCE.getStringLiteral__GetValue();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.InstanceImpl <em>Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.InstanceImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getInstance()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.AttributeImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getAttribute()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.ValueReferenceImpl <em>Value Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.ValueReferenceImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getValueReference()
		 * @generated
		 */
		EClass VALUE_REFERENCE = eINSTANCE.getValueReference();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.SelfReferenceImpl <em>Self Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.SelfReferenceImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getSelfReference()
		 * @generated
		 */
		EClass SELF_REFERENCE = eINSTANCE.getSelfReference();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.LiteralDefinitionReferenceImpl <em>Literal Definition Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.LiteralDefinitionReferenceImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getLiteralDefinitionReference()
		 * @generated
		 */
		EClass LITERAL_DEFINITION_REFERENCE = eINSTANCE.getLiteralDefinitionReference();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_DEFINITION_REFERENCE__DEFINITION = eINSTANCE.getLiteralDefinitionReference_Definition();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.TypeDefinitionReferenceImpl <em>Type Definition Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.TypeDefinitionReferenceImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getTypeDefinitionReference()
		 * @generated
		 */
		EClass TYPE_DEFINITION_REFERENCE = eINSTANCE.getTypeDefinitionReference();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_DEFINITION_REFERENCE__DEFINITION = eINSTANCE.getTypeDefinitionReference_Definition();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.BooleanLiteralImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getBooleanLiteral()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL__LITERAL = eINSTANCE.getBooleanLiteral_Literal();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOOLEAN_LITERAL___GET_VALUE = eINSTANCE.getBooleanLiteral__GetValue();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.CallImpl <em>Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.CallImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getCall()
		 * @generated
		 */
		EClass CALL = eINSTANCE.getCall();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.ParanthesesImpl <em>Parantheses</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.ParanthesesImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getParantheses()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.impl.ArrayImpl <em>Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.impl.ArrayImpl
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getArray()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.ComparisonOperator <em>Comparison Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.ComparisonOperator
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getComparisonOperator()
		 * @generated
		 */
		EEnum COMPARISON_OPERATOR = eINSTANCE.getComparisonOperator();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.AddOrSubtractOperator <em>Add Or Subtract Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.AddOrSubtractOperator
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getAddOrSubtractOperator()
		 * @generated
		 */
		EEnum ADD_OR_SUBTRACT_OPERATOR = eINSTANCE.getAddOrSubtractOperator();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.MultiplyDivideModuloOperator <em>Multiply Divide Modulo Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.MultiplyDivideModuloOperator
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getMultiplyDivideModuloOperator()
		 * @generated
		 */
		EEnum MULTIPLY_DIVIDE_MODULO_OPERATOR = eINSTANCE.getMultiplyDivideModuloOperator();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.expressions.Factor <em>Factor</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.expressions.Factor
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getFactor()
		 * @generated
		 */
		EEnum FACTOR = eINSTANCE.getFactor();

		/**
		 * The meta object literal for the '<em>Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl#getNumber()
		 * @generated
		 */
		EDataType NUMBER = eINSTANCE.getNumber();

	}

} //ExpressionsPackage
