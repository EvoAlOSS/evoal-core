/**
 */
package de.evoal.languages.model.base.expressions.impl;

import de.evoal.languages.model.base.expressions.*;

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
public class ExpressionsFactoryImpl extends EFactoryImpl implements ExpressionsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExpressionsFactory init() {
		try {
			ExpressionsFactory theExpressionsFactory = (ExpressionsFactory)EPackage.Registry.INSTANCE.getEFactory(ExpressionsPackage.eNS_URI);
			if (theExpressionsFactory != null) {
				return theExpressionsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExpressionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsFactoryImpl() {
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
			case ExpressionsPackage.OR_EXPRESSION: return createOrExpression();
			case ExpressionsPackage.XOR_EXPRESSION: return createXorExpression();
			case ExpressionsPackage.AND_EXPRESSION: return createAndExpression();
			case ExpressionsPackage.NOT_EXPRESSION: return createNotExpression();
			case ExpressionsPackage.COMPARISON_EXPRESSION: return createComparisonExpression();
			case ExpressionsPackage.PARTIAL_COMPARISON_EXPRESSION: return createPartialComparisonExpression();
			case ExpressionsPackage.ADD_OR_SUBTRACT_EXPRESSION: return createAddOrSubtractExpression();
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION: return createMultiplyDivideModuloExpression();
			case ExpressionsPackage.POWER_OF_EXPRESSION: return createPowerOfExpression();
			case ExpressionsPackage.UNARY_ADD_OR_SUBTRACT_EXPRESSION: return createUnaryAddOrSubtractExpression();
			case ExpressionsPackage.INTEGER_LITERAL: return createIntegerLiteral();
			case ExpressionsPackage.REAL_LITERAL: return createRealLiteral();
			case ExpressionsPackage.STRING_LITERAL: return createStringLiteral();
			case ExpressionsPackage.INSTANCE: return createInstance();
			case ExpressionsPackage.ATTRIBUTE: return createAttribute();
			case ExpressionsPackage.VALUE_REFERENCE: return createValueReference();
			case ExpressionsPackage.SELF_REFERENCE: return createSelfReference();
			case ExpressionsPackage.CONFIGURATION_REFERENCE: return createConfigurationReference();
			case ExpressionsPackage.VALUE_DEFINITION_REFERENCE: return createValueDefinitionReference();
			case ExpressionsPackage.ATTRIBUTE_DEFINITION_REFERENCE: return createAttributeDefinitionReference();
			case ExpressionsPackage.LITERAL_DEFINITION_REFERENCE: return createLiteralDefinitionReference();
			case ExpressionsPackage.TYPE_DEFINITION_REFERENCE: return createTypeDefinitionReference();
			case ExpressionsPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
			case ExpressionsPackage.CALL: return createCall();
			case ExpressionsPackage.PARANTHESES: return createParantheses();
			case ExpressionsPackage.ARRAY: return createArray();
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
			case ExpressionsPackage.COMPARISON_OPERATOR:
				return createComparisonOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.ADD_OR_SUBTRACT_OPERATOR:
				return createAddOrSubtractOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_OPERATOR:
				return createMultiplyDivideModuloOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.FACTOR:
				return createFactorFromString(eDataType, initialValue);
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
			case ExpressionsPackage.COMPARISON_OPERATOR:
				return convertComparisonOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.ADD_OR_SUBTRACT_OPERATOR:
				return convertAddOrSubtractOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_OPERATOR:
				return convertMultiplyDivideModuloOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.FACTOR:
				return convertFactorToString(eDataType, instanceValue);
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
	public RealLiteral createRealLiteral() {
		RealLiteralImpl realLiteral = new RealLiteralImpl();
		return realLiteral;
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
	public Instance createInstance() {
		InstanceImpl instance = new InstanceImpl();
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
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
	@Override
	public SelfReference createSelfReference() {
		SelfReferenceImpl selfReference = new SelfReferenceImpl();
		return selfReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConfigurationReference createConfigurationReference() {
		ConfigurationReferenceImpl configurationReference = new ConfigurationReferenceImpl();
		return configurationReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueDefinitionReference createValueDefinitionReference() {
		ValueDefinitionReferenceImpl valueDefinitionReference = new ValueDefinitionReferenceImpl();
		return valueDefinitionReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeDefinitionReference createAttributeDefinitionReference() {
		AttributeDefinitionReferenceImpl attributeDefinitionReference = new AttributeDefinitionReferenceImpl();
		return attributeDefinitionReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralDefinitionReference createLiteralDefinitionReference() {
		LiteralDefinitionReferenceImpl literalDefinitionReference = new LiteralDefinitionReferenceImpl();
		return literalDefinitionReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeDefinitionReference createTypeDefinitionReference() {
		TypeDefinitionReferenceImpl typeDefinitionReference = new TypeDefinitionReferenceImpl();
		return typeDefinitionReference;
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
	public Array createArray() {
		ArrayImpl array = new ArrayImpl();
		return array;
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
	public Factor createFactorFromString(EDataType eDataType, String initialValue) {
		Factor result = Factor.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFactorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpressionsPackage getExpressionsPackage() {
		return (ExpressionsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExpressionsPackage getPackage() {
		return ExpressionsPackage.eINSTANCE;
	}

} //ExpressionsFactoryImpl
