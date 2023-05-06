/**
 */
package de.evoal.languages.model.mll.impl;

import de.evoal.languages.model.mll.*;

import org.eclipse.emf.ecore.EClass;
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
public class MllFactoryImpl extends EFactoryImpl implements MllFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MllFactory init() {
		try {
			MllFactory theMllFactory = (MllFactory)EPackage.Registry.INSTANCE.getEFactory(MllPackage.eNS_URI);
			if (theMllFactory != null) {
				return theMllFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MllFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MllFactoryImpl() {
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
			case MllPackage.MACHINE_LEARNING_CONFIGURATION: return createMachineLearningConfiguration();
			case MllPackage.SURROGATE_DEFINITION: return createSurrogateDefinition();
			case MllPackage.SURROGATE_LAYER_DEFINITION: return createSurrogateLayerDefinition();
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION: return createPartialSurrogateFunctionDefinition();
			case MllPackage.PREDICTION: return createPrediction();
			case MllPackage.CALL_STATEMENT: return createCallStatement();
			case MllPackage.BLOCK_STATEMENT: return createBlockStatement();
			case MllPackage.PREDICT_STATEMENT: return createPredictStatement();
			case MllPackage.FOR_STATEMENT: return createForStatement();
			case MllPackage.COUNTER_RANGE: return createCounterRange();
			case MllPackage.STRING_LITERAL_RANGE: return createStringLiteralRange();
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
	public MachineLearningConfiguration createMachineLearningConfiguration() {
		MachineLearningConfigurationImpl machineLearningConfiguration = new MachineLearningConfigurationImpl();
		return machineLearningConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SurrogateDefinition createSurrogateDefinition() {
		SurrogateDefinitionImpl surrogateDefinition = new SurrogateDefinitionImpl();
		return surrogateDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SurrogateLayerDefinition createSurrogateLayerDefinition() {
		SurrogateLayerDefinitionImpl surrogateLayerDefinition = new SurrogateLayerDefinitionImpl();
		return surrogateLayerDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PartialSurrogateFunctionDefinition createPartialSurrogateFunctionDefinition() {
		PartialSurrogateFunctionDefinitionImpl partialSurrogateFunctionDefinition = new PartialSurrogateFunctionDefinitionImpl();
		return partialSurrogateFunctionDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Prediction createPrediction() {
		PredictionImpl prediction = new PredictionImpl();
		return prediction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CallStatement createCallStatement() {
		CallStatementImpl callStatement = new CallStatementImpl();
		return callStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BlockStatement createBlockStatement() {
		BlockStatementImpl blockStatement = new BlockStatementImpl();
		return blockStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PredictStatement createPredictStatement() {
		PredictStatementImpl predictStatement = new PredictStatementImpl();
		return predictStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForStatement createForStatement() {
		ForStatementImpl forStatement = new ForStatementImpl();
		return forStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CounterRange createCounterRange() {
		CounterRangeImpl counterRange = new CounterRangeImpl();
		return counterRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StringLiteralRange createStringLiteralRange() {
		StringLiteralRangeImpl stringLiteralRange = new StringLiteralRangeImpl();
		return stringLiteralRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MllPackage getMllPackage() {
		return (MllPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MllPackage getPackage() {
		return MllPackage.eINSTANCE;
	}

} //MllFactoryImpl
