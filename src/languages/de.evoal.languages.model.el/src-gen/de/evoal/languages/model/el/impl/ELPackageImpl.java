/**
 */
package de.evoal.languages.model.el.impl;

import de.evoal.languages.model.el.AddOrSubtractExpression;
import de.evoal.languages.model.el.AddOrSubtractOperator;
import de.evoal.languages.model.el.AndExpression;
import de.evoal.languages.model.el.BooleanLiteral;
import de.evoal.languages.model.el.Call;
import de.evoal.languages.model.el.CallOrLiteralOrReferenceOrParantheses;
import de.evoal.languages.model.el.ComparisonExpression;
import de.evoal.languages.model.el.ComparisonOperator;
import de.evoal.languages.model.el.DoubleLiteral;
import de.evoal.languages.model.el.ELFactory;
import de.evoal.languages.model.el.ELPackage;
import de.evoal.languages.model.el.Expression;
import de.evoal.languages.model.el.Factor;
import de.evoal.languages.model.el.FunctionName;
import de.evoal.languages.model.el.IntegerLiteral;
import de.evoal.languages.model.el.Literal;
import de.evoal.languages.model.el.MultiplyDivideModuloExpression;
import de.evoal.languages.model.el.MultiplyDivideModuloOperator;
import de.evoal.languages.model.el.NotExpression;
import de.evoal.languages.model.el.NumberLiteral;
import de.evoal.languages.model.el.OrExpression;
import de.evoal.languages.model.el.Parantheses;
import de.evoal.languages.model.el.PartialComparisonExpression;
import de.evoal.languages.model.el.PowerOfExpression;
import de.evoal.languages.model.el.StringLiteral;
import de.evoal.languages.model.el.UnaryAddOrSubtractExpression;
import de.evoal.languages.model.el.ValueReference;
import de.evoal.languages.model.el.XorExpression;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ELPackageImpl extends EPackageImpl implements ELPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xorExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comparisonExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partialComparisonExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addOrSubtractExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplyDivideModuloExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerOfExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryAddOrSubtractExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callOrLiteralOrReferenceOrParanthesesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paranthesesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum comparisonOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum addOrSubtractOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum multiplyDivideModuloOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum factorEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.evoal.languages.model.el.ELPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ELPackageImpl() {
		super(eNS_URI, ELFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ELPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ELPackage init() {
		if (isInited) return (ELPackage)EPackage.Registry.INSTANCE.getEPackage(ELPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredELPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ELPackageImpl theELPackage = registeredELPackage instanceof ELPackageImpl ? (ELPackageImpl)registeredELPackage : new ELPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theELPackage.createPackageContents();

		// Initialize created meta-data
		theELPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theELPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ELPackage.eNS_URI, theELPackage);
		return theELPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOrExpression() {
		return orExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOrExpression_SubExpressions() {
		return (EReference)orExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXorExpression() {
		return xorExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXorExpression_SubExpressions() {
		return (EReference)xorExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAndExpression() {
		return andExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAndExpression_SubExpressions() {
		return (EReference)andExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNotExpression() {
		return notExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNotExpression_Negated() {
		return (EAttribute)notExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNotExpression_Operand() {
		return (EReference)notExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComparisonExpression() {
		return comparisonExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComparisonExpression_LeftOperand() {
		return (EReference)comparisonExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComparisonExpression_Comparison() {
		return (EReference)comparisonExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPartialComparisonExpression() {
		return partialComparisonExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPartialComparisonExpression_Operator() {
		return (EAttribute)partialComparisonExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPartialComparisonExpression_SubExpression() {
		return (EReference)partialComparisonExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAddOrSubtractExpression() {
		return addOrSubtractExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAddOrSubtractExpression_LeftOperand() {
		return (EReference)addOrSubtractExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAddOrSubtractExpression_Operators() {
		return (EAttribute)addOrSubtractExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAddOrSubtractExpression_Operands() {
		return (EReference)addOrSubtractExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMultiplyDivideModuloExpression() {
		return multiplyDivideModuloExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMultiplyDivideModuloExpression_LeftOperand() {
		return (EReference)multiplyDivideModuloExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMultiplyDivideModuloExpression_Operators() {
		return (EAttribute)multiplyDivideModuloExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMultiplyDivideModuloExpression_Operands() {
		return (EReference)multiplyDivideModuloExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPowerOfExpression() {
		return powerOfExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPowerOfExpression_LeftOperand() {
		return (EReference)powerOfExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPowerOfExpression_RightOperand() {
		return (EReference)powerOfExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUnaryAddOrSubtractExpression() {
		return unaryAddOrSubtractExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnaryAddOrSubtractExpression_Operators() {
		return (EAttribute)unaryAddOrSubtractExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUnaryAddOrSubtractExpression_SubExpression() {
		return (EReference)unaryAddOrSubtractExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCallOrLiteralOrReferenceOrParantheses() {
		return callOrLiteralOrReferenceOrParanthesesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteral() {
		return literalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getLiteral__GetValue() {
		return literalEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNumberLiteral() {
		return numberLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNumberLiteral_Factor() {
		return (EAttribute)numberLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNumberLiteral__GetValue() {
		return numberLiteralEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntegerLiteral() {
		return integerLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntegerLiteral_Literal() {
		return (EAttribute)integerLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getIntegerLiteral__GetValue() {
		return integerLiteralEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDoubleLiteral() {
		return doubleLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDoubleLiteral_Literal() {
		return (EAttribute)doubleLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDoubleLiteral__GetValue() {
		return doubleLiteralEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringLiteral() {
		return stringLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringLiteral_Value() {
		return (EAttribute)stringLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBooleanLiteral() {
		return booleanLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBooleanLiteral_Value() {
		return (EAttribute)booleanLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCall() {
		return callEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCall_Function() {
		return (EReference)callEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCall_Parameters() {
		return (EReference)callEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParantheses() {
		return paranthesesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParantheses_SubExpression() {
		return (EReference)paranthesesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunctionName() {
		return functionNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValueReference() {
		return valueReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getComparisonOperator() {
		return comparisonOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getAddOrSubtractOperator() {
		return addOrSubtractOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getMultiplyDivideModuloOperator() {
		return multiplyDivideModuloOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getFactor() {
		return factorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ELFactory getELFactory() {
		return (ELFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		expressionEClass = createEClass(EXPRESSION);

		orExpressionEClass = createEClass(OR_EXPRESSION);
		createEReference(orExpressionEClass, OR_EXPRESSION__SUB_EXPRESSIONS);

		xorExpressionEClass = createEClass(XOR_EXPRESSION);
		createEReference(xorExpressionEClass, XOR_EXPRESSION__SUB_EXPRESSIONS);

		andExpressionEClass = createEClass(AND_EXPRESSION);
		createEReference(andExpressionEClass, AND_EXPRESSION__SUB_EXPRESSIONS);

		notExpressionEClass = createEClass(NOT_EXPRESSION);
		createEAttribute(notExpressionEClass, NOT_EXPRESSION__NEGATED);
		createEReference(notExpressionEClass, NOT_EXPRESSION__OPERAND);

		comparisonExpressionEClass = createEClass(COMPARISON_EXPRESSION);
		createEReference(comparisonExpressionEClass, COMPARISON_EXPRESSION__LEFT_OPERAND);
		createEReference(comparisonExpressionEClass, COMPARISON_EXPRESSION__COMPARISON);

		partialComparisonExpressionEClass = createEClass(PARTIAL_COMPARISON_EXPRESSION);
		createEAttribute(partialComparisonExpressionEClass, PARTIAL_COMPARISON_EXPRESSION__OPERATOR);
		createEReference(partialComparisonExpressionEClass, PARTIAL_COMPARISON_EXPRESSION__SUB_EXPRESSION);

		addOrSubtractExpressionEClass = createEClass(ADD_OR_SUBTRACT_EXPRESSION);
		createEReference(addOrSubtractExpressionEClass, ADD_OR_SUBTRACT_EXPRESSION__LEFT_OPERAND);
		createEAttribute(addOrSubtractExpressionEClass, ADD_OR_SUBTRACT_EXPRESSION__OPERATORS);
		createEReference(addOrSubtractExpressionEClass, ADD_OR_SUBTRACT_EXPRESSION__OPERANDS);

		multiplyDivideModuloExpressionEClass = createEClass(MULTIPLY_DIVIDE_MODULO_EXPRESSION);
		createEReference(multiplyDivideModuloExpressionEClass, MULTIPLY_DIVIDE_MODULO_EXPRESSION__LEFT_OPERAND);
		createEAttribute(multiplyDivideModuloExpressionEClass, MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERATORS);
		createEReference(multiplyDivideModuloExpressionEClass, MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERANDS);

		powerOfExpressionEClass = createEClass(POWER_OF_EXPRESSION);
		createEReference(powerOfExpressionEClass, POWER_OF_EXPRESSION__LEFT_OPERAND);
		createEReference(powerOfExpressionEClass, POWER_OF_EXPRESSION__RIGHT_OPERAND);

		unaryAddOrSubtractExpressionEClass = createEClass(UNARY_ADD_OR_SUBTRACT_EXPRESSION);
		createEAttribute(unaryAddOrSubtractExpressionEClass, UNARY_ADD_OR_SUBTRACT_EXPRESSION__OPERATORS);
		createEReference(unaryAddOrSubtractExpressionEClass, UNARY_ADD_OR_SUBTRACT_EXPRESSION__SUB_EXPRESSION);

		callOrLiteralOrReferenceOrParanthesesEClass = createEClass(CALL_OR_LITERAL_OR_REFERENCE_OR_PARANTHESES);

		literalEClass = createEClass(LITERAL);
		createEOperation(literalEClass, LITERAL___GET_VALUE);

		numberLiteralEClass = createEClass(NUMBER_LITERAL);
		createEAttribute(numberLiteralEClass, NUMBER_LITERAL__FACTOR);
		createEOperation(numberLiteralEClass, NUMBER_LITERAL___GET_VALUE);

		integerLiteralEClass = createEClass(INTEGER_LITERAL);
		createEAttribute(integerLiteralEClass, INTEGER_LITERAL__LITERAL);
		createEOperation(integerLiteralEClass, INTEGER_LITERAL___GET_VALUE);

		doubleLiteralEClass = createEClass(DOUBLE_LITERAL);
		createEAttribute(doubleLiteralEClass, DOUBLE_LITERAL__LITERAL);
		createEOperation(doubleLiteralEClass, DOUBLE_LITERAL___GET_VALUE);

		stringLiteralEClass = createEClass(STRING_LITERAL);
		createEAttribute(stringLiteralEClass, STRING_LITERAL__VALUE);

		booleanLiteralEClass = createEClass(BOOLEAN_LITERAL);
		createEAttribute(booleanLiteralEClass, BOOLEAN_LITERAL__VALUE);

		callEClass = createEClass(CALL);
		createEReference(callEClass, CALL__FUNCTION);
		createEReference(callEClass, CALL__PARAMETERS);

		paranthesesEClass = createEClass(PARANTHESES);
		createEReference(paranthesesEClass, PARANTHESES__SUB_EXPRESSION);

		functionNameEClass = createEClass(FUNCTION_NAME);

		valueReferenceEClass = createEClass(VALUE_REFERENCE);

		// Create enums
		comparisonOperatorEEnum = createEEnum(COMPARISON_OPERATOR);
		addOrSubtractOperatorEEnum = createEEnum(ADD_OR_SUBTRACT_OPERATOR);
		multiplyDivideModuloOperatorEEnum = createEEnum(MULTIPLY_DIVIDE_MODULO_OPERATOR);
		factorEEnum = createEEnum(FACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		orExpressionEClass.getESuperTypes().add(this.getExpression());
		literalEClass.getESuperTypes().add(this.getCallOrLiteralOrReferenceOrParantheses());
		numberLiteralEClass.getESuperTypes().add(this.getLiteral());
		integerLiteralEClass.getESuperTypes().add(this.getNumberLiteral());
		doubleLiteralEClass.getESuperTypes().add(this.getNumberLiteral());
		stringLiteralEClass.getESuperTypes().add(this.getLiteral());
		booleanLiteralEClass.getESuperTypes().add(this.getLiteral());
		callEClass.getESuperTypes().add(this.getCallOrLiteralOrReferenceOrParantheses());
		paranthesesEClass.getESuperTypes().add(this.getCallOrLiteralOrReferenceOrParantheses());
		valueReferenceEClass.getESuperTypes().add(this.getCallOrLiteralOrReferenceOrParantheses());

		// Initialize classes, features, and operations; add parameters
		initEClass(expressionEClass, Expression.class, "Expression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orExpressionEClass, OrExpression.class, "OrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOrExpression_SubExpressions(), this.getXorExpression(), null, "subExpressions", null, 1, -1, OrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xorExpressionEClass, XorExpression.class, "XorExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXorExpression_SubExpressions(), this.getAndExpression(), null, "subExpressions", null, 1, -1, XorExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andExpressionEClass, AndExpression.class, "AndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAndExpression_SubExpressions(), this.getNotExpression(), null, "subExpressions", null, 1, -1, AndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notExpressionEClass, NotExpression.class, "NotExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNotExpression_Negated(), ecorePackage.getEBoolean(), "negated", "false", 1, 1, NotExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNotExpression_Operand(), this.getComparisonExpression(), null, "operand", null, 1, 1, NotExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(comparisonExpressionEClass, ComparisonExpression.class, "ComparisonExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComparisonExpression_LeftOperand(), this.getAddOrSubtractExpression(), null, "leftOperand", null, 1, 1, ComparisonExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComparisonExpression_Comparison(), this.getPartialComparisonExpression(), null, "comparison", null, 0, -1, ComparisonExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partialComparisonExpressionEClass, PartialComparisonExpression.class, "PartialComparisonExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPartialComparisonExpression_Operator(), this.getComparisonOperator(), "operator", null, 1, 1, PartialComparisonExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartialComparisonExpression_SubExpression(), this.getAddOrSubtractExpression(), null, "subExpression", null, 1, 1, PartialComparisonExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addOrSubtractExpressionEClass, AddOrSubtractExpression.class, "AddOrSubtractExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAddOrSubtractExpression_LeftOperand(), this.getMultiplyDivideModuloExpression(), null, "leftOperand", null, 1, 1, AddOrSubtractExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddOrSubtractExpression_Operators(), this.getAddOrSubtractOperator(), "operators", null, 0, -1, AddOrSubtractExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddOrSubtractExpression_Operands(), this.getMultiplyDivideModuloExpression(), null, "operands", null, 0, -1, AddOrSubtractExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiplyDivideModuloExpressionEClass, MultiplyDivideModuloExpression.class, "MultiplyDivideModuloExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiplyDivideModuloExpression_LeftOperand(), this.getPowerOfExpression(), null, "leftOperand", null, 1, 1, MultiplyDivideModuloExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiplyDivideModuloExpression_Operators(), this.getMultiplyDivideModuloOperator(), "operators", null, 0, -1, MultiplyDivideModuloExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiplyDivideModuloExpression_Operands(), this.getPowerOfExpression(), null, "operands", null, 0, -1, MultiplyDivideModuloExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(powerOfExpressionEClass, PowerOfExpression.class, "PowerOfExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPowerOfExpression_LeftOperand(), this.getUnaryAddOrSubtractExpression(), null, "leftOperand", null, 1, 1, PowerOfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPowerOfExpression_RightOperand(), this.getPowerOfExpression(), null, "rightOperand", null, 0, 1, PowerOfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unaryAddOrSubtractExpressionEClass, UnaryAddOrSubtractExpression.class, "UnaryAddOrSubtractExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnaryAddOrSubtractExpression_Operators(), this.getAddOrSubtractOperator(), "operators", null, 0, -1, UnaryAddOrSubtractExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnaryAddOrSubtractExpression_SubExpression(), this.getCallOrLiteralOrReferenceOrParantheses(), null, "subExpression", null, 1, 1, UnaryAddOrSubtractExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callOrLiteralOrReferenceOrParanthesesEClass, CallOrLiteralOrReferenceOrParantheses.class, "CallOrLiteralOrReferenceOrParantheses", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalEClass, Literal.class, "Literal", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getLiteral__GetValue(), ecorePackage.getEJavaObject(), "getValue", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(numberLiteralEClass, NumberLiteral.class, "NumberLiteral", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNumberLiteral_Factor(), this.getFactor(), "factor", "None", 1, 1, NumberLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getNumberLiteral__GetValue(), ecorePackage.getEJavaObject(), "getValue", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(integerLiteralEClass, IntegerLiteral.class, "IntegerLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerLiteral_Literal(), ecorePackage.getEInt(), "literal", null, 1, 1, IntegerLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getIntegerLiteral__GetValue(), ecorePackage.getEIntegerObject(), "getValue", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(doubleLiteralEClass, DoubleLiteral.class, "DoubleLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleLiteral_Literal(), ecorePackage.getEDouble(), "literal", null, 1, 1, DoubleLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getDoubleLiteral__GetValue(), ecorePackage.getEDoubleObject(), "getValue", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(stringLiteralEClass, StringLiteral.class, "StringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringLiteral_Value(), ecorePackage.getEString(), "value", null, 1, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanLiteralEClass, BooleanLiteral.class, "BooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanLiteral_Value(), ecorePackage.getEBoolean(), "value", null, 1, 1, BooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callEClass, Call.class, "Call", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCall_Function(), this.getFunctionName(), null, "function", null, 1, 1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCall_Parameters(), this.getExpression(), null, "parameters", null, 0, -1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paranthesesEClass, Parantheses.class, "Parantheses", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParantheses_SubExpression(), this.getExpression(), null, "subExpression", null, 1, 1, Parantheses.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionNameEClass, FunctionName.class, "FunctionName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueReferenceEClass, ValueReference.class, "ValueReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(comparisonOperatorEEnum, ComparisonOperator.class, "ComparisonOperator");
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.GREATER_THAN);
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.GREATER_EQUAL);
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.EQUAL);
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.UNEQUAL);
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.LESS_EQUAL);
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.LESS_THAN);

		initEEnum(addOrSubtractOperatorEEnum, AddOrSubtractOperator.class, "AddOrSubtractOperator");
		addEEnumLiteral(addOrSubtractOperatorEEnum, AddOrSubtractOperator.ADD);
		addEEnumLiteral(addOrSubtractOperatorEEnum, AddOrSubtractOperator.SUBTRACT);

		initEEnum(multiplyDivideModuloOperatorEEnum, MultiplyDivideModuloOperator.class, "MultiplyDivideModuloOperator");
		addEEnumLiteral(multiplyDivideModuloOperatorEEnum, MultiplyDivideModuloOperator.MULTIPLY);
		addEEnumLiteral(multiplyDivideModuloOperatorEEnum, MultiplyDivideModuloOperator.DIVIDE);
		addEEnumLiteral(multiplyDivideModuloOperatorEEnum, MultiplyDivideModuloOperator.MODULO);

		initEEnum(factorEEnum, Factor.class, "Factor");
		addEEnumLiteral(factorEEnum, Factor.YOTTA);
		addEEnumLiteral(factorEEnum, Factor.ZETTA);
		addEEnumLiteral(factorEEnum, Factor.EXA);
		addEEnumLiteral(factorEEnum, Factor.PETA);
		addEEnumLiteral(factorEEnum, Factor.TERA);
		addEEnumLiteral(factorEEnum, Factor.GIGA);
		addEEnumLiteral(factorEEnum, Factor.MEGA);
		addEEnumLiteral(factorEEnum, Factor.KILO);
		addEEnumLiteral(factorEEnum, Factor.HECTO);
		addEEnumLiteral(factorEEnum, Factor.DEKA);
		addEEnumLiteral(factorEEnum, Factor.NONE);
		addEEnumLiteral(factorEEnum, Factor.DECI);
		addEEnumLiteral(factorEEnum, Factor.CENTI);
		addEEnumLiteral(factorEEnum, Factor.MILLI);
		addEEnumLiteral(factorEEnum, Factor.MICRO);
		addEEnumLiteral(factorEEnum, Factor.NANO);
		addEEnumLiteral(factorEEnum, Factor.PIKO);
		addEEnumLiteral(factorEEnum, Factor.FEMTO);
		addEEnumLiteral(factorEEnum, Factor.ATTO);
		addEEnumLiteral(factorEEnum, Factor.ZEPTO);
		addEEnumLiteral(factorEEnum, Factor.YOCTO);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/OCL/Collection
		createCollectionAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "ecore", "http://www.eclipse.org/emf/2002/Ecore"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Collection</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createCollectionAnnotations() {
		String source = "http://www.eclipse.org/OCL/Collection";
		addAnnotation
		  (getOrExpression_SubExpressions(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getXorExpression_SubExpressions(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getAndExpression_SubExpressions(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getComparisonExpression_Comparison(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getAddOrSubtractExpression_Operators(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getAddOrSubtractExpression_Operands(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getMultiplyDivideModuloExpression_Operators(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getMultiplyDivideModuloExpression_Operands(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getUnaryAddOrSubtractExpression_Operators(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getCall_Parameters(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
	}

} //ELPackageImpl
