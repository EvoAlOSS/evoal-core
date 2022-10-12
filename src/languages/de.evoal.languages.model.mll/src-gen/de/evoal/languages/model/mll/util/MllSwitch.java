/**
 */
package de.evoal.languages.model.mll.util;

import de.evoal.languages.model.el.FunctionName;

import de.evoal.languages.model.mll.*;

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
 * @see de.evoal.languages.model.mll.MllPackage
 * @generated
 */
public class MllSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MllPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MllSwitch() {
		if (modelPackage == null) {
			modelPackage = MllPackage.eINSTANCE;
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
			case MllPackage.MACHINE_LEARNING_CONFIGURATION: {
				MachineLearningConfiguration machineLearningConfiguration = (MachineLearningConfiguration)theEObject;
				T result = caseMachineLearningConfiguration(machineLearningConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MllPackage.SURROGATE_DEFINITION: {
				SurrogateDefinition surrogateDefinition = (SurrogateDefinition)theEObject;
				T result = caseSurrogateDefinition(surrogateDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MllPackage.SURROGATE_LAYER_DEFINITION: {
				SurrogateLayerDefinition surrogateLayerDefinition = (SurrogateLayerDefinition)theEObject;
				T result = caseSurrogateLayerDefinition(surrogateLayerDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MllPackage.PARTIAL_SURROGATE_FUNCTION_DEFINITION: {
				PartialSurrogateFunctionDefinition partialSurrogateFunctionDefinition = (PartialSurrogateFunctionDefinition)theEObject;
				T result = casePartialSurrogateFunctionDefinition(partialSurrogateFunctionDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MllPackage.PREDICTION: {
				Prediction prediction = (Prediction)theEObject;
				T result = casePrediction(prediction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MllPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MllPackage.CALL_STATEMENT: {
				CallStatement callStatement = (CallStatement)theEObject;
				T result = caseCallStatement(callStatement);
				if (result == null) result = caseStatement(callStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MllPackage.BLOCK_STATEMENT: {
				BlockStatement blockStatement = (BlockStatement)theEObject;
				T result = caseBlockStatement(blockStatement);
				if (result == null) result = caseStatement(blockStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MllPackage.PREDICT_STATEMENT: {
				PredictStatement predictStatement = (PredictStatement)theEObject;
				T result = casePredictStatement(predictStatement);
				if (result == null) result = caseStatement(predictStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MllPackage.FOR_STATEMENT: {
				ForStatement forStatement = (ForStatement)theEObject;
				T result = caseForStatement(forStatement);
				if (result == null) result = caseStatement(forStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MllPackage.RANGE: {
				Range range = (Range)theEObject;
				T result = caseRange(range);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MllPackage.COUNTER_RANGE: {
				CounterRange counterRange = (CounterRange)theEObject;
				T result = caseCounterRange(counterRange);
				if (result == null) result = caseRange(counterRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MllPackage.STRING_LITERAL_RANGE: {
				StringLiteralRange stringLiteralRange = (StringLiteralRange)theEObject;
				T result = caseStringLiteralRange(stringLiteralRange);
				if (result == null) result = caseRange(stringLiteralRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MllPackage.DEFINED_FUNCTION_NAME: {
				DefinedFunctionName definedFunctionName = (DefinedFunctionName)theEObject;
				T result = caseDefinedFunctionName(definedFunctionName);
				if (result == null) result = caseFunctionName(definedFunctionName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MllPackage.USE: {
				Use use = (Use)theEObject;
				T result = caseUse(use);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Machine Learning Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Machine Learning Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMachineLearningConfiguration(MachineLearningConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Surrogate Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Surrogate Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSurrogateDefinition(SurrogateDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Surrogate Layer Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Surrogate Layer Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSurrogateLayerDefinition(SurrogateLayerDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partial Surrogate Function Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partial Surrogate Function Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartialSurrogateFunctionDefinition(PartialSurrogateFunctionDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prediction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prediction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrediction(Prediction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatement(Statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallStatement(CallStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockStatement(BlockStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Predict Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predict Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePredictStatement(PredictStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForStatement(ForStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRange(Range object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Counter Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Counter Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCounterRange(CounterRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteralRange(StringLiteralRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Defined Function Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Defined Function Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefinedFunctionName(DefinedFunctionName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Use</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Use</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUse(Use object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionName(FunctionName object) {
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

} //MllSwitch
