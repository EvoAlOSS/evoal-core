/**
 */
package de.evoal.languages.model.mll;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.evoal.languages.model.mll.MllPackage
 * @generated
 */
public interface MllFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MllFactory eINSTANCE = de.evoal.languages.model.mll.impl.MllFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Machine Learning Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Machine Learning Module</em>'.
	 * @generated
	 */
	MachineLearningModule createMachineLearningModule();

	/**
	 * Returns a new object of class '<em>Surrogate Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Surrogate Definition</em>'.
	 * @generated
	 */
	SurrogateDefinition createSurrogateDefinition();

	/**
	 * Returns a new object of class '<em>Surrogate Layer Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Surrogate Layer Definition</em>'.
	 * @generated
	 */
	SurrogateLayerDefinition createSurrogateLayerDefinition();

	/**
	 * Returns a new object of class '<em>Partial Surrogate Function Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Partial Surrogate Function Definition</em>'.
	 * @generated
	 */
	PartialSurrogateFunctionDefinition createPartialSurrogateFunctionDefinition();

	/**
	 * Returns a new object of class '<em>Prediction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Prediction</em>'.
	 * @generated
	 */
	Prediction createPrediction();

	/**
	 * Returns a new object of class '<em>Call Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Statement</em>'.
	 * @generated
	 */
	CallStatement createCallStatement();

	/**
	 * Returns a new object of class '<em>Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Statement</em>'.
	 * @generated
	 */
	BlockStatement createBlockStatement();

	/**
	 * Returns a new object of class '<em>Predict Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Predict Statement</em>'.
	 * @generated
	 */
	PredictStatement createPredictStatement();

	/**
	 * Returns a new object of class '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Statement</em>'.
	 * @generated
	 */
	ForStatement createForStatement();

	/**
	 * Returns a new object of class '<em>Counter Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Counter Range</em>'.
	 * @generated
	 */
	CounterRange createCounterRange();

	/**
	 * Returns a new object of class '<em>Literal Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Range</em>'.
	 * @generated
	 */
	LiteralRange createLiteralRange();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MllPackage getMllPackage();

} //MllFactory
