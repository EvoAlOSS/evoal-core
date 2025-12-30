/**
 * EvoAl Project
 */
package de.evoal.languages.model.generator.util;

import de.evoal.languages.model.base.expressions.ConstantExpression;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Literal;
import de.evoal.languages.model.base.expressions.ReadExpression;

import de.evoal.languages.model.execution.NamedVariable;
import de.evoal.languages.model.execution.Statement;
import de.evoal.languages.model.execution.Variable;

import de.evoal.languages.model.generator.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.evoal.languages.model.generator.GeneratorPackage
 * @generated
 */
public class GeneratorAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GeneratorPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GeneratorPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneratorSwitch<Adapter> modelSwitch =
		new GeneratorSwitch<Adapter>() {
			@Override
			public Adapter caseGeneratorModule(GeneratorModule object) {
				return createGeneratorModuleAdapter();
			}
			@Override
			public Adapter casePipelineDefinition(PipelineDefinition object) {
				return createPipelineDefinitionAdapter();
			}
			@Override
			public Adapter caseStep(Step object) {
				return createStepAdapter();
			}
			@Override
			public Adapter casePipelineStep(PipelineStep object) {
				return createPipelineStepAdapter();
			}
			@Override
			public Adapter caseConcreteStep(ConcreteStep object) {
				return createConcreteStepAdapter();
			}
			@Override
			public Adapter caseApplyStatement(ApplyStatement object) {
				return createApplyStatementAdapter();
			}
			@Override
			public Adapter caseVariable(Variable object) {
				return createVariableAdapter();
			}
			@Override
			public Adapter caseNamedVariable(NamedVariable object) {
				return createNamedVariableAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseReadExpression(ReadExpression object) {
				return createReadExpressionAdapter();
			}
			@Override
			public Adapter caseConstantExpression(ConstantExpression object) {
				return createConstantExpressionAdapter();
			}
			@Override
			public Adapter caseLiteral(Literal object) {
				return createLiteralAdapter();
			}
			@Override
			public Adapter caseStatement(Statement object) {
				return createStatementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.generator.GeneratorModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.generator.GeneratorModule
	 * @generated
	 */
	public Adapter createGeneratorModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.generator.PipelineDefinition <em>Pipeline Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.generator.PipelineDefinition
	 * @generated
	 */
	public Adapter createPipelineDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.generator.Step <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.generator.Step
	 * @generated
	 */
	public Adapter createStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.generator.PipelineStep <em>Pipeline Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.generator.PipelineStep
	 * @generated
	 */
	public Adapter createPipelineStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.generator.ConcreteStep <em>Concrete Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.generator.ConcreteStep
	 * @generated
	 */
	public Adapter createConcreteStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.generator.ApplyStatement <em>Apply Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.generator.ApplyStatement
	 * @generated
	 */
	public Adapter createApplyStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.execution.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.execution.Variable
	 * @generated
	 */
	public Adapter createVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.execution.NamedVariable <em>Named Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.execution.NamedVariable
	 * @generated
	 */
	public Adapter createNamedVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.base.expressions.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.base.expressions.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.base.expressions.ReadExpression <em>Read Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.base.expressions.ReadExpression
	 * @generated
	 */
	public Adapter createReadExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.base.expressions.ConstantExpression <em>Constant Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.base.expressions.ConstantExpression
	 * @generated
	 */
	public Adapter createConstantExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.base.expressions.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.base.expressions.Literal
	 * @generated
	 */
	public Adapter createLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.execution.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.execution.Statement
	 * @generated
	 */
	public Adapter createStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GeneratorAdapterFactory
