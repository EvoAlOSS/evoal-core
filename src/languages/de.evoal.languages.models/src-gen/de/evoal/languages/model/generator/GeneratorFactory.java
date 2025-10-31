/**
 * EvoAl Project
 */
package de.evoal.languages.model.generator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.evoal.languages.model.generator.GeneratorPackage
 * @generated
 */
public interface GeneratorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneratorFactory eINSTANCE = de.evoal.languages.model.generator.impl.GeneratorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module</em>'.
	 * @generated
	 */
	GeneratorModule createGeneratorModule();

	/**
	 * Returns a new object of class '<em>Pipeline Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pipeline Definition</em>'.
	 * @generated
	 */
	PipelineDefinition createPipelineDefinition();

	/**
	 * Returns a new object of class '<em>Pipeline Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pipeline Step</em>'.
	 * @generated
	 */
	PipelineStep createPipelineStep();

	/**
	 * Returns a new object of class '<em>Concrete Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Step</em>'.
	 * @generated
	 */
	ConcreteStep createConcreteStep();

	/**
	 * Returns a new object of class '<em>Apply Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Apply Statement</em>'.
	 * @generated
	 */
	ApplyStatement createApplyStatement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GeneratorPackage getGeneratorPackage();

} //GeneratorFactory
