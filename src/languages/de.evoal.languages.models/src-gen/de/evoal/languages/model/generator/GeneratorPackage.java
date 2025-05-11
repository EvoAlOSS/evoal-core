/**
 * EvoAl Project
 */
package de.evoal.languages.model.generator;

import de.evoal.languages.model.execution.ExecutionPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.evoal.languages.model.generator.GeneratorFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import base='platform:/resource/de.evoal.languages.model.base/model/model.ecore#/' exec='execution.ecore#/' expr='platform:/resource/de.evoal.languages.model.base/model/expressions.ecore#/'"
 * @generated
 */
public interface GeneratorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "generator";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.evoal.de/languages/generator/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "generator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneratorPackage eINSTANCE = de.evoal.languages.model.generator.impl.GeneratorPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.generator.impl.GeneratorModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.generator.impl.GeneratorModuleImpl
	 * @see de.evoal.languages.model.generator.impl.GeneratorPackageImpl#getGeneratorModule()
	 * @generated
	 */
	int GENERATOR_MODULE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_MODULE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_MODULE__IMPORTS = 1;

	/**
	 * The feature id for the '<em><b>Pipelines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_MODULE__PIPELINES = 2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_MODULE__BODY = 3;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_MODULE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.generator.impl.PipelineDefinitionImpl <em>Pipeline Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.generator.impl.PipelineDefinitionImpl
	 * @see de.evoal.languages.model.generator.impl.GeneratorPackageImpl#getPipelineDefinition()
	 * @generated
	 */
	int PIPELINE_DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_DEFINITION__NAME = ExecutionPackage.NAMED_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_DEFINITION__STEPS = ExecutionPackage.NAMED_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pipeline Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_DEFINITION_FEATURE_COUNT = ExecutionPackage.NAMED_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.generator.impl.StepImpl <em>Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.generator.impl.StepImpl
	 * @see de.evoal.languages.model.generator.impl.GeneratorPackageImpl#getStep()
	 * @generated
	 */
	int STEP = 2;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__INSTANCE = 0;

	/**
	 * The feature id for the '<em><b>Reads</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__READS = 1;

	/**
	 * The feature id for the '<em><b>Writes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__WRITES = 2;

	/**
	 * The number of structural features of the '<em>Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.generator.impl.ApplyStatementImpl <em>Apply Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.generator.impl.ApplyStatementImpl
	 * @see de.evoal.languages.model.generator.impl.GeneratorPackageImpl#getApplyStatement()
	 * @generated
	 */
	int APPLY_STATEMENT = 3;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_STATEMENT__FILE = ExecutionPackage.STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Count</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_STATEMENT__COUNT = ExecutionPackage.STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Pipelines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_STATEMENT__PIPELINES = ExecutionPackage.STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Apply Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_STATEMENT_FEATURE_COUNT = ExecutionPackage.STATEMENT_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.generator.GeneratorModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see de.evoal.languages.model.generator.GeneratorModule
	 * @generated
	 */
	EClass getGeneratorModule();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.generator.GeneratorModule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.generator.GeneratorModule#getName()
	 * @see #getGeneratorModule()
	 * @generated
	 */
	EAttribute getGeneratorModule_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.generator.GeneratorModule#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see de.evoal.languages.model.generator.GeneratorModule#getImports()
	 * @see #getGeneratorModule()
	 * @generated
	 */
	EReference getGeneratorModule_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.generator.GeneratorModule#getPipelines <em>Pipelines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pipelines</em>'.
	 * @see de.evoal.languages.model.generator.GeneratorModule#getPipelines()
	 * @see #getGeneratorModule()
	 * @generated
	 */
	EReference getGeneratorModule_Pipelines();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.generator.GeneratorModule#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see de.evoal.languages.model.generator.GeneratorModule#getBody()
	 * @see #getGeneratorModule()
	 * @generated
	 */
	EReference getGeneratorModule_Body();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.generator.PipelineDefinition <em>Pipeline Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipeline Definition</em>'.
	 * @see de.evoal.languages.model.generator.PipelineDefinition
	 * @generated
	 */
	EClass getPipelineDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.generator.PipelineDefinition#getSteps <em>Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Steps</em>'.
	 * @see de.evoal.languages.model.generator.PipelineDefinition#getSteps()
	 * @see #getPipelineDefinition()
	 * @generated
	 */
	EReference getPipelineDefinition_Steps();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.generator.Step <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step</em>'.
	 * @see de.evoal.languages.model.generator.Step
	 * @generated
	 */
	EClass getStep();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.generator.Step#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Instance</em>'.
	 * @see de.evoal.languages.model.generator.Step#getInstance()
	 * @see #getStep()
	 * @generated
	 */
	EReference getStep_Instance();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.generator.Step#getReads <em>Reads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reads</em>'.
	 * @see de.evoal.languages.model.generator.Step#getReads()
	 * @see #getStep()
	 * @generated
	 */
	EReference getStep_Reads();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.generator.Step#getWrites <em>Writes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Writes</em>'.
	 * @see de.evoal.languages.model.generator.Step#getWrites()
	 * @see #getStep()
	 * @generated
	 */
	EReference getStep_Writes();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.generator.ApplyStatement <em>Apply Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Apply Statement</em>'.
	 * @see de.evoal.languages.model.generator.ApplyStatement
	 * @generated
	 */
	EClass getApplyStatement();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.generator.ApplyStatement#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see de.evoal.languages.model.generator.ApplyStatement#getFile()
	 * @see #getApplyStatement()
	 * @generated
	 */
	EAttribute getApplyStatement_File();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.generator.ApplyStatement#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Count</em>'.
	 * @see de.evoal.languages.model.generator.ApplyStatement#getCount()
	 * @see #getApplyStatement()
	 * @generated
	 */
	EReference getApplyStatement_Count();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.generator.ApplyStatement#getPipelines <em>Pipelines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pipelines</em>'.
	 * @see de.evoal.languages.model.generator.ApplyStatement#getPipelines()
	 * @see #getApplyStatement()
	 * @generated
	 */
	EReference getApplyStatement_Pipelines();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GeneratorFactory getGeneratorFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.generator.impl.GeneratorModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.generator.impl.GeneratorModuleImpl
		 * @see de.evoal.languages.model.generator.impl.GeneratorPackageImpl#getGeneratorModule()
		 * @generated
		 */
		EClass GENERATOR_MODULE = eINSTANCE.getGeneratorModule();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATOR_MODULE__NAME = eINSTANCE.getGeneratorModule_Name();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR_MODULE__IMPORTS = eINSTANCE.getGeneratorModule_Imports();

		/**
		 * The meta object literal for the '<em><b>Pipelines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR_MODULE__PIPELINES = eINSTANCE.getGeneratorModule_Pipelines();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR_MODULE__BODY = eINSTANCE.getGeneratorModule_Body();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.generator.impl.PipelineDefinitionImpl <em>Pipeline Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.generator.impl.PipelineDefinitionImpl
		 * @see de.evoal.languages.model.generator.impl.GeneratorPackageImpl#getPipelineDefinition()
		 * @generated
		 */
		EClass PIPELINE_DEFINITION = eINSTANCE.getPipelineDefinition();

		/**
		 * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIPELINE_DEFINITION__STEPS = eINSTANCE.getPipelineDefinition_Steps();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.generator.impl.StepImpl <em>Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.generator.impl.StepImpl
		 * @see de.evoal.languages.model.generator.impl.GeneratorPackageImpl#getStep()
		 * @generated
		 */
		EClass STEP = eINSTANCE.getStep();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEP__INSTANCE = eINSTANCE.getStep_Instance();

		/**
		 * The meta object literal for the '<em><b>Reads</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEP__READS = eINSTANCE.getStep_Reads();

		/**
		 * The meta object literal for the '<em><b>Writes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEP__WRITES = eINSTANCE.getStep_Writes();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.generator.impl.ApplyStatementImpl <em>Apply Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.generator.impl.ApplyStatementImpl
		 * @see de.evoal.languages.model.generator.impl.GeneratorPackageImpl#getApplyStatement()
		 * @generated
		 */
		EClass APPLY_STATEMENT = eINSTANCE.getApplyStatement();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLY_STATEMENT__FILE = eINSTANCE.getApplyStatement_File();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLY_STATEMENT__COUNT = eINSTANCE.getApplyStatement_Count();

		/**
		 * The meta object literal for the '<em><b>Pipelines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLY_STATEMENT__PIPELINES = eINSTANCE.getApplyStatement_Pipelines();

	}

} //GeneratorPackage
