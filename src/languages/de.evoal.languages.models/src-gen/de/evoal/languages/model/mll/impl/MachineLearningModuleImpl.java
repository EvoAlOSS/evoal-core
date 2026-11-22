/**
 */
package de.evoal.languages.model.mll.impl;

import de.evoal.languages.model.base.expressions.Instance;

import de.evoal.languages.model.base.impl.ModuleImpl;
import de.evoal.languages.model.execution.Block;

import de.evoal.languages.model.generator.PipelineDefinition;

import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.languages.model.mll.MllPackage;
import de.evoal.languages.model.mll.TaskDescription;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Machine Learning Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.impl.MachineLearningModuleImpl#getTask <em>Task</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.MachineLearningModuleImpl#getValidation <em>Validation</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.MachineLearningModuleImpl#getPreparation <em>Preparation</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.MachineLearningModuleImpl#getModel <em>Model</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.MachineLearningModuleImpl#getGof <em>Gof</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.MachineLearningModuleImpl#getLearningUseCase <em>Learning Use Case</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.MachineLearningModuleImpl#getPredictionUseCase <em>Prediction Use Case</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.MachineLearningModuleImpl#getTestingUseCase <em>Testing Use Case</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MachineLearningModuleImpl extends ModuleImpl implements MachineLearningModule {
	/**
	 * The cached value of the '{@link #getTask() <em>Task</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTask()
	 * @generated
	 * @ordered
	 */
	protected TaskDescription task;

	/**
	 * The cached value of the '{@link #getValidation() <em>Validation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidation()
	 * @generated
	 * @ordered
	 */
	protected PipelineDefinition validation;

	/**
	 * The cached value of the '{@link #getPreparation() <em>Preparation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreparation()
	 * @generated
	 * @ordered
	 */
	protected PipelineDefinition preparation;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected Instance model;

	/**
	 * The cached value of the '{@link #getGof() <em>Gof</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGof()
	 * @generated
	 * @ordered
	 */
	protected Block gof;

	/**
	 * The cached value of the '{@link #getLearningUseCase() <em>Learning Use Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLearningUseCase()
	 * @generated
	 * @ordered
	 */
	protected Block learningUseCase;

	/**
	 * The cached value of the '{@link #getPredictionUseCase() <em>Prediction Use Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredictionUseCase()
	 * @generated
	 * @ordered
	 */
	protected PipelineDefinition predictionUseCase;

	/**
	 * The cached value of the '{@link #getTestingUseCase() <em>Testing Use Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestingUseCase()
	 * @generated
	 * @ordered
	 */
	protected Block testingUseCase;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MachineLearningModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MllPackage.Literals.MACHINE_LEARNING_MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TaskDescription getTask() {
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTask(TaskDescription newTask, NotificationChain msgs) {
		TaskDescription oldTask = task;
		task = newTask;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MllPackage.MACHINE_LEARNING_MODULE__TASK, oldTask, newTask);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTask(TaskDescription newTask) {
		if (newTask != task) {
			NotificationChain msgs = null;
			if (task != null)
				msgs = ((InternalEObject)task).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MllPackage.MACHINE_LEARNING_MODULE__TASK, null, msgs);
			if (newTask != null)
				msgs = ((InternalEObject)newTask).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MllPackage.MACHINE_LEARNING_MODULE__TASK, null, msgs);
			msgs = basicSetTask(newTask, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MllPackage.MACHINE_LEARNING_MODULE__TASK, newTask, newTask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PipelineDefinition getValidation() {
		return validation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValidation(PipelineDefinition newValidation, NotificationChain msgs) {
		PipelineDefinition oldValidation = validation;
		validation = newValidation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MllPackage.MACHINE_LEARNING_MODULE__VALIDATION, oldValidation, newValidation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValidation(PipelineDefinition newValidation) {
		if (newValidation != validation) {
			NotificationChain msgs = null;
			if (validation != null)
				msgs = ((InternalEObject)validation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MllPackage.MACHINE_LEARNING_MODULE__VALIDATION, null, msgs);
			if (newValidation != null)
				msgs = ((InternalEObject)newValidation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MllPackage.MACHINE_LEARNING_MODULE__VALIDATION, null, msgs);
			msgs = basicSetValidation(newValidation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MllPackage.MACHINE_LEARNING_MODULE__VALIDATION, newValidation, newValidation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PipelineDefinition getPreparation() {
		return preparation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPreparation(PipelineDefinition newPreparation, NotificationChain msgs) {
		PipelineDefinition oldPreparation = preparation;
		preparation = newPreparation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MllPackage.MACHINE_LEARNING_MODULE__PREPARATION, oldPreparation, newPreparation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPreparation(PipelineDefinition newPreparation) {
		if (newPreparation != preparation) {
			NotificationChain msgs = null;
			if (preparation != null)
				msgs = ((InternalEObject)preparation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MllPackage.MACHINE_LEARNING_MODULE__PREPARATION, null, msgs);
			if (newPreparation != null)
				msgs = ((InternalEObject)newPreparation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MllPackage.MACHINE_LEARNING_MODULE__PREPARATION, null, msgs);
			msgs = basicSetPreparation(newPreparation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MllPackage.MACHINE_LEARNING_MODULE__PREPARATION, newPreparation, newPreparation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Instance getModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModel(Instance newModel, NotificationChain msgs) {
		Instance oldModel = model;
		model = newModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MllPackage.MACHINE_LEARNING_MODULE__MODEL, oldModel, newModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModel(Instance newModel) {
		if (newModel != model) {
			NotificationChain msgs = null;
			if (model != null)
				msgs = ((InternalEObject)model).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MllPackage.MACHINE_LEARNING_MODULE__MODEL, null, msgs);
			if (newModel != null)
				msgs = ((InternalEObject)newModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MllPackage.MACHINE_LEARNING_MODULE__MODEL, null, msgs);
			msgs = basicSetModel(newModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MllPackage.MACHINE_LEARNING_MODULE__MODEL, newModel, newModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Block getGof() {
		return gof;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGof(Block newGof, NotificationChain msgs) {
		Block oldGof = gof;
		gof = newGof;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MllPackage.MACHINE_LEARNING_MODULE__GOF, oldGof, newGof);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGof(Block newGof) {
		if (newGof != gof) {
			NotificationChain msgs = null;
			if (gof != null)
				msgs = ((InternalEObject)gof).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MllPackage.MACHINE_LEARNING_MODULE__GOF, null, msgs);
			if (newGof != null)
				msgs = ((InternalEObject)newGof).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MllPackage.MACHINE_LEARNING_MODULE__GOF, null, msgs);
			msgs = basicSetGof(newGof, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MllPackage.MACHINE_LEARNING_MODULE__GOF, newGof, newGof));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Block getLearningUseCase() {
		return learningUseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLearningUseCase(Block newLearningUseCase, NotificationChain msgs) {
		Block oldLearningUseCase = learningUseCase;
		learningUseCase = newLearningUseCase;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MllPackage.MACHINE_LEARNING_MODULE__LEARNING_USE_CASE, oldLearningUseCase, newLearningUseCase);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLearningUseCase(Block newLearningUseCase) {
		if (newLearningUseCase != learningUseCase) {
			NotificationChain msgs = null;
			if (learningUseCase != null)
				msgs = ((InternalEObject)learningUseCase).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MllPackage.MACHINE_LEARNING_MODULE__LEARNING_USE_CASE, null, msgs);
			if (newLearningUseCase != null)
				msgs = ((InternalEObject)newLearningUseCase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MllPackage.MACHINE_LEARNING_MODULE__LEARNING_USE_CASE, null, msgs);
			msgs = basicSetLearningUseCase(newLearningUseCase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MllPackage.MACHINE_LEARNING_MODULE__LEARNING_USE_CASE, newLearningUseCase, newLearningUseCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PipelineDefinition getPredictionUseCase() {
		return predictionUseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPredictionUseCase(PipelineDefinition newPredictionUseCase, NotificationChain msgs) {
		PipelineDefinition oldPredictionUseCase = predictionUseCase;
		predictionUseCase = newPredictionUseCase;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MllPackage.MACHINE_LEARNING_MODULE__PREDICTION_USE_CASE, oldPredictionUseCase, newPredictionUseCase);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredictionUseCase(PipelineDefinition newPredictionUseCase) {
		if (newPredictionUseCase != predictionUseCase) {
			NotificationChain msgs = null;
			if (predictionUseCase != null)
				msgs = ((InternalEObject)predictionUseCase).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MllPackage.MACHINE_LEARNING_MODULE__PREDICTION_USE_CASE, null, msgs);
			if (newPredictionUseCase != null)
				msgs = ((InternalEObject)newPredictionUseCase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MllPackage.MACHINE_LEARNING_MODULE__PREDICTION_USE_CASE, null, msgs);
			msgs = basicSetPredictionUseCase(newPredictionUseCase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MllPackage.MACHINE_LEARNING_MODULE__PREDICTION_USE_CASE, newPredictionUseCase, newPredictionUseCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Block getTestingUseCase() {
		return testingUseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTestingUseCase(Block newTestingUseCase, NotificationChain msgs) {
		Block oldTestingUseCase = testingUseCase;
		testingUseCase = newTestingUseCase;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MllPackage.MACHINE_LEARNING_MODULE__TESTING_USE_CASE, oldTestingUseCase, newTestingUseCase);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestingUseCase(Block newTestingUseCase) {
		if (newTestingUseCase != testingUseCase) {
			NotificationChain msgs = null;
			if (testingUseCase != null)
				msgs = ((InternalEObject)testingUseCase).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MllPackage.MACHINE_LEARNING_MODULE__TESTING_USE_CASE, null, msgs);
			if (newTestingUseCase != null)
				msgs = ((InternalEObject)newTestingUseCase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MllPackage.MACHINE_LEARNING_MODULE__TESTING_USE_CASE, null, msgs);
			msgs = basicSetTestingUseCase(newTestingUseCase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MllPackage.MACHINE_LEARNING_MODULE__TESTING_USE_CASE, newTestingUseCase, newTestingUseCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MllPackage.MACHINE_LEARNING_MODULE__TASK:
				return basicSetTask(null, msgs);
			case MllPackage.MACHINE_LEARNING_MODULE__VALIDATION:
				return basicSetValidation(null, msgs);
			case MllPackage.MACHINE_LEARNING_MODULE__PREPARATION:
				return basicSetPreparation(null, msgs);
			case MllPackage.MACHINE_LEARNING_MODULE__MODEL:
				return basicSetModel(null, msgs);
			case MllPackage.MACHINE_LEARNING_MODULE__GOF:
				return basicSetGof(null, msgs);
			case MllPackage.MACHINE_LEARNING_MODULE__LEARNING_USE_CASE:
				return basicSetLearningUseCase(null, msgs);
			case MllPackage.MACHINE_LEARNING_MODULE__PREDICTION_USE_CASE:
				return basicSetPredictionUseCase(null, msgs);
			case MllPackage.MACHINE_LEARNING_MODULE__TESTING_USE_CASE:
				return basicSetTestingUseCase(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MllPackage.MACHINE_LEARNING_MODULE__TASK:
				return getTask();
			case MllPackage.MACHINE_LEARNING_MODULE__VALIDATION:
				return getValidation();
			case MllPackage.MACHINE_LEARNING_MODULE__PREPARATION:
				return getPreparation();
			case MllPackage.MACHINE_LEARNING_MODULE__MODEL:
				return getModel();
			case MllPackage.MACHINE_LEARNING_MODULE__GOF:
				return getGof();
			case MllPackage.MACHINE_LEARNING_MODULE__LEARNING_USE_CASE:
				return getLearningUseCase();
			case MllPackage.MACHINE_LEARNING_MODULE__PREDICTION_USE_CASE:
				return getPredictionUseCase();
			case MllPackage.MACHINE_LEARNING_MODULE__TESTING_USE_CASE:
				return getTestingUseCase();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MllPackage.MACHINE_LEARNING_MODULE__TASK:
				setTask((TaskDescription)newValue);
				return;
			case MllPackage.MACHINE_LEARNING_MODULE__VALIDATION:
				setValidation((PipelineDefinition)newValue);
				return;
			case MllPackage.MACHINE_LEARNING_MODULE__PREPARATION:
				setPreparation((PipelineDefinition)newValue);
				return;
			case MllPackage.MACHINE_LEARNING_MODULE__MODEL:
				setModel((Instance)newValue);
				return;
			case MllPackage.MACHINE_LEARNING_MODULE__GOF:
				setGof((Block)newValue);
				return;
			case MllPackage.MACHINE_LEARNING_MODULE__LEARNING_USE_CASE:
				setLearningUseCase((Block)newValue);
				return;
			case MllPackage.MACHINE_LEARNING_MODULE__PREDICTION_USE_CASE:
				setPredictionUseCase((PipelineDefinition)newValue);
				return;
			case MllPackage.MACHINE_LEARNING_MODULE__TESTING_USE_CASE:
				setTestingUseCase((Block)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MllPackage.MACHINE_LEARNING_MODULE__TASK:
				setTask((TaskDescription)null);
				return;
			case MllPackage.MACHINE_LEARNING_MODULE__VALIDATION:
				setValidation((PipelineDefinition)null);
				return;
			case MllPackage.MACHINE_LEARNING_MODULE__PREPARATION:
				setPreparation((PipelineDefinition)null);
				return;
			case MllPackage.MACHINE_LEARNING_MODULE__MODEL:
				setModel((Instance)null);
				return;
			case MllPackage.MACHINE_LEARNING_MODULE__GOF:
				setGof((Block)null);
				return;
			case MllPackage.MACHINE_LEARNING_MODULE__LEARNING_USE_CASE:
				setLearningUseCase((Block)null);
				return;
			case MllPackage.MACHINE_LEARNING_MODULE__PREDICTION_USE_CASE:
				setPredictionUseCase((PipelineDefinition)null);
				return;
			case MllPackage.MACHINE_LEARNING_MODULE__TESTING_USE_CASE:
				setTestingUseCase((Block)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MllPackage.MACHINE_LEARNING_MODULE__TASK:
				return task != null;
			case MllPackage.MACHINE_LEARNING_MODULE__VALIDATION:
				return validation != null;
			case MllPackage.MACHINE_LEARNING_MODULE__PREPARATION:
				return preparation != null;
			case MllPackage.MACHINE_LEARNING_MODULE__MODEL:
				return model != null;
			case MllPackage.MACHINE_LEARNING_MODULE__GOF:
				return gof != null;
			case MllPackage.MACHINE_LEARNING_MODULE__LEARNING_USE_CASE:
				return learningUseCase != null;
			case MllPackage.MACHINE_LEARNING_MODULE__PREDICTION_USE_CASE:
				return predictionUseCase != null;
			case MllPackage.MACHINE_LEARNING_MODULE__TESTING_USE_CASE:
				return testingUseCase != null;
		}
		return super.eIsSet(featureID);
	}

} //MachineLearningModuleImpl
