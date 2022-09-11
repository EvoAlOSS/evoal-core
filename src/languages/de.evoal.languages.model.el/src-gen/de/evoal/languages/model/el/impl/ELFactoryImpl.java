/**
 */
package de.evoal.languages.model.el.impl;

import de.evoal.languages.model.el.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ELFactoryImpl extends EFactoryImpl implements ELFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ELFactory init() {
		try {
			ELFactory theELFactory = (ELFactory)EPackage.Registry.INSTANCE.getEFactory(ELPackage.eNS_URI);
			if (theELFactory != null) {
				return theELFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ELFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ELFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ELPackage.OR_EXPRESSION: return createOrExpression();
			case ELPackage.XOR_EXPRESSION: return createXorExpression();
			case ELPackage.AND_EXPRESSION: return createAndExpression();
			case ELPackage.NOT_EXPRESSION: return createNotExpression();
			case ELPackage.COMPARISON_EXPRESSION: return createComparisonExpression();
			case ELPackage.PARTIAL_COMPARISON_EXPRESSION: return createPartialComparisonExpression();
			case ELPackage.ADD_OR_SUBTRACT_EXPRESSION: return createAddOrSubtractExpression();
			case ELPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION: return createMultiplyDivideModuloExpression();
			case ELPackage.POWER_OF_EXPRESSION: return createPowerOfExpression();
			case ELPackage.UNARY_ADD_OR_SUBTRACT_EXPRESSION: return createUnaryAddOrSubtractExpression();
			case ELPackage.INTEGER_LITERAL: return createIntegerLiteral();
			case ELPackage.DOUBLE_LITERAL: return createDoubleLiteral();
			case ELPackage.STRING_LITERAL: return createStringLiteral();
			case ELPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
			case ELPackage.CALL: return createCall();
			case ELPackage.PARANTHESES: return createParantheses();
			case ELPackage.FUNCTION_NAME: return createFunctionName();
			case ELPackage.VALUE_REFERENCE: return createValueReference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ELPackage.COMPARISON_OPERATOR:
				return createComparisonOperatorFromString(eDataType, initialValue);
			case ELPackage.ADD_OR_SUBTRACT_OPERATOR:
				return createAddOrSubtractOperatorFromString(eDataType, initialValue);
			case ELPackage.MULTIPLY_DIVIDE_MODULO_OPERATOR:
				return createMultiplyDivideModuloOperatorFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ELPackage.COMPARISON_OPERATOR:
				return convertComparisonOperatorToString(eDataType, instanceValue);
			case ELPackage.ADD_OR_SUBTRACT_OPERATOR:
				return convertAddOrSubtractOperatorToString(eDataType, instanceValue);
			case ELPackage.MULTIPLY_DIVIDE_MODULO_OPERATOR:
				return convertMultiplyDivideModuloOperatorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OrExpression createOrExpression() {
		OrExpressionImpl orExpression = new OrExpressionImpl();
		return orExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XorExpression createXorExpression() {
		XorExpressionImpl xorExpression = new XorExpressionImpl();
		return xorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AndExpression createAndExpression() {
		AndExpressionImpl andExpression = new AndExpressionImpl();
		return andExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotExpression createNotExpression() {
		NotExpressionImpl notExpression = new NotExpressionImpl();
		return notExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComparisonExpression createComparisonExpression() {
		ComparisonExpressionImpl comparisonExpression = new ComparisonExpressionImpl();
		return comparisonExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PartialComparisonExpression createPartialComparisonExpression() {
		PartialComparisonExpressionImpl partialComparisonExpression = new PartialComparisonExpressionImpl();
		return partialComparisonExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AddOrSubtractExpression createAddOrSubtractExpression() {
		AddOrSubtractExpressionImpl addOrSubtractExpression = new AddOrSubtractExpressionImpl();
		return addOrSubtractExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MultiplyDivideModuloExpression createMultiplyDivideModuloExpression() {
		MultiplyDivideModuloExpressionImpl multiplyDivideModuloExpression = new MultiplyDivideModuloExpressionImpl();
		return multiplyDivideModuloExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PowerOfExpression createPowerOfExpression() {
		PowerOfExpressionImpl powerOfExpression = new PowerOfExpressionImpl();
		return powerOfExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnaryAddOrSubtractExpression createUnaryAddOrSubtractExpression() {
		UnaryAddOrSubtractExpressionImpl unaryAddOrSubtractExpression = new UnaryAddOrSubtractExpressionImpl();
		return unaryAddOrSubtractExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntegerLiteral createIntegerLiteral() {
		IntegerLiteralImpl integerLiteral = new IntegerLiteralImpl();
		return integerLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DoubleLiteral createDoubleLiteral() {
		DoubleLiteralImpl doubleLiteral = new DoubleLiteralImpl();
		return doubleLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StringLiteral createStringLiteral() {
		StringLiteralImpl stringLiteral = new StringLiteralImpl();
		return stringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BooleanLiteral createBooleanLiteral() {
		BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
		return booleanLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Call createCall() {
		CallImpl call = new CallImpl();
		return call;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parantheses createParantheses() {
		ParanthesesImpl parantheses = new ParanthesesImpl();
		return parantheses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionName createFunctionName() {
		FunctionNameImpl functionName = new FunctionNameImpl();
		return functionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueReference createValueReference() {
		ValueReferenceImpl valueReference = new ValueReferenceImpl();
		return valueReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComparisonOperator createComparisonOperatorFromString(EDataType eDataType, String initialValue) {
		ComparisonOperator result = ComparisonOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertComparisonOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddOrSubtractOperator createAddOrSubtractOperatorFromString(EDataType eDataType, String initialValue) {
		AddOrSubtractOperator result = AddOrSubtractOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAddOrSubtractOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplyDivideModuloOperator createMultiplyDivideModuloOperatorFromString(EDataType eDataType, String initialValue) {
		MultiplyDivideModuloOperator result = MultiplyDivideModuloOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMultiplyDivideModuloOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ELPackage getELPackage() {
		return (ELPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ELPackage getPackage() {
		return ELPackage.eINSTANCE;
	}

} //ELFactoryImpl
