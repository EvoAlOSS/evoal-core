package de.evoal.surrogate.main.internal;

import de.evoal.languages.model.base.BaseFactory;
import de.evoal.languages.model.base.Import;
import de.evoal.languages.model.execution.*;
import de.evoal.languages.model.mll.*;
import de.evoal.languages.model.mll.util.MllSwitch;
import de.evoal.languages.model.pipeline.PipelineFactory;
import de.evoal.languages.model.pipeline.PipelineModule;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.HashMap;
import java.util.Map;

public class MLLModelConverter extends MllSwitch<Object> {
    private final static BaseFactory baseFactory = BaseFactory.eINSTANCE;
    private final static ExecutionFactory execFactory = ExecutionFactory.eINSTANCE;
    private final static PipelineFactory pipeFactory = PipelineFactory.eINSTANCE;

    private Map<Variable, Variable> variableMapping = new HashMap<>();

    private final EClass space;
    private final ExecutionModelConverter converter;

    public MLLModelConverter(final EClass space) {
        this.space = space;
        this.converter = new ExecutionModelConverter(space, variableMapping,this);
    }

    public PipelineModule convert(final MachineLearningModule module) {
        final PipelineModule result = pipeFactory.createPipelineModule();

        result.setName(module.getName());

        // copy imports
        module.getImports()
              .stream()
              .map(this::caseImport)
              .forEachOrdered(result.getImports()::add);

        final ModelFunction main = execFactory.createModelFunction();
        main.setName("main");
        final Program program = execFactory.createProgram();
        program.setMain(main);
        program.getFunctions().add(main);
        result.setProgram(program);

        // copy types
        module.getDefinitions()
              .stream()
              .map(this::caseSurrogateDefinition)
              .forEachOrdered(program.getVariables()::add);

        main.setBody(
                converter.caseBlock(module.getBody()));

        return result;
    }

    private Import caseImport(final Import _import) {
        final Import result = baseFactory.createImport();
        result.setImportedNamespace(_import.getImportedNamespace());
        result.setLanguage(_import.getLanguage());

        return result;
    }

    @Override
    public Object caseMachineLearningModule(MachineLearningModule object) {
        return super.caseMachineLearningModule(object);
    }

    @Override
    public SurrogateDefinition caseSurrogateDefinition(final SurrogateDefinition definition) {
        final SurrogateDefinition result = EcoreUtil.copy(definition);

        variableMapping.put(definition, result);

        return result;
    }

    @Override
    public PredictStatement casePredictStatement(final PredictStatement stmt) {
        final PredictStatement result = MllFactory.eINSTANCE.createPredictStatement();
        result.setModelFilename(stmt.getModelFilename());
        result.setTrainingData(stmt.getTrainingData());
        result.setMeasurements(converter.caseBlock(stmt.getMeasurements()));
        result.setSurrogate((SurrogateDefinition) variableMapping.get(stmt.getSurrogate()));

        return result;
    }

    @Override
    public Object defaultCase(EObject object) {
        throw new UnsupportedOperationException("Not supported yet: " + object);
    }

    @Override
    public NamedVariable caseNamedVariable(final NamedVariable object) {
        return (NamedVariable) variableMapping.get(object);
    }
}
