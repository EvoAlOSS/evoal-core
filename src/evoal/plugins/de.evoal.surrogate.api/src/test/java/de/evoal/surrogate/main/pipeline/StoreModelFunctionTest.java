package de.evoal.surrogate.main.pipeline;

import de.evoal.surrogate.main.literature.SurrogateLiterature;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.languages.model.execution.ExecutionFactory;
import de.evoal.languages.model.execution.NamedVariable;
import de.evoal.languages.model.mll.MllFactory;
import de.evoal.languages.model.mll.TaskDescription;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.function.ModelFunctionData;
import de.evoal.surrogate.api.function.PredictionPipeline;
import de.evoal.models.v202704.pipeline.PipelineFactory;
import de.evoal.surrogate.api.io.ModelWriter;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.training.GoodnessOfFit;
import de.evoal.surrogate.api.training.ResampledValues;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mockito;
import tools.jackson.databind.json.JsonMapper;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * How {@code 'store-model'} stores the goodness-of-fit values (#234).
 */
public class StoreModelFunctionTest {
    private static final String RMSE = "de.evoal.surrogate.ml.rmse";
    private static final String R_SQUARE = "de.evoal.surrogate.ml.R²";

    private EAttribute y;
    private InterpreterState context;
    private ModelWriter writer;
    private TaskDescription task;

    private void bind(final String name, final Object value) {
        final NamedVariable variable = ExecutionFactory.eINSTANCE.createNamedVariable();
        variable.setName(name);
        context.put(variable, value);
    }

    private final SurrogateLiterature literature = new SurrogateLiterature();

    @BeforeEach
    void setUp() {
        y = EcoreFactory.eINSTANCE.createEAttribute();
        y.setName("y:0");
        y.setEType(EcorePackage.Literals.EDOUBLE);

        context = new InterpreterState();

        writer = Mockito.mock(ModelWriter.class);
        Mockito.when(writer.addPredictionPipeline(Mockito.any())).thenReturn(writer);
        Mockito.when(writer.addTrainingDefinitions(Mockito.any())).thenReturn(writer);
        final PredictionPipeline pipeline = Mockito.mock(PredictionPipeline.class);
        Mockito.when(pipeline.definition()).thenReturn(Optional.of(PipelineFactory.eINSTANCE.createPipelineDefinition()));
        bind("model-function", new ModelFunctionData(Mockito.mock(ModelFunction.class), Optional.empty(), Optional.of(writer), pipeline));

        task = MllFactory.eINSTANCE.createTaskDescription();
        task.setName("learning-task");
        context.put(task, task);

        final GoodnessOfFit goodnessOfFit = GoodnessOfFit.of(context);
        goodnessOfFit.record(y, RMSE, GoodnessOfFit.TRAINING, 0.0);
        goodnessOfFit.record(y, R_SQUARE, GoodnessOfFit.TRAINING, 1.0);
        goodnessOfFit.record(y, RMSE, GoodnessOfFit.TEST, 0.5);
    }

    @Test
    public void everyMeasureIsStoredWithTheValuesOfAllDataSets() {
        // when
        new StoreModelFunction(literature).call(context, new Object[0]);

        // then
        Mockito.verify(writer).addOutputFeatureInformation(y, Parameter.from(RMSE, Map.of(GoodnessOfFit.TRAINING, 0.0, GoodnessOfFit.TEST, 0.5)));
        Mockito.verify(writer).addOutputFeatureInformation(y, Parameter.from(R_SQUARE, Map.of(GoodnessOfFit.TRAINING, 1.0)));
        Mockito.verify(writer).addTrainingDefinitions(List.of());
        Mockito.verify(writer).store(Mockito.any());
    }

    @Test
    public void theGoodnessOfFitFileHoldsTheValuesPerFeatureMeasureAndDataSet(@TempDir final File directory) {
        // given
        final File file = new File(directory, "output/gof.json");
        task.setGofFile(file.getPath());

        // when
        new StoreModelFunction(literature).call(context, new Object[0]);

        // then
        final Map<?, ?> content = JsonMapper.builder().build().readValue(file, Map.class);
        Assertions.assertEquals(Map.of("y:0", Map.of(RMSE, Map.of("training", 0.0, "test", 0.5),
                                                     R_SQUARE, Map.of("training", 1.0))),
                                content);
    }

    @Test
    public void theValuesOfAResamplingSchemeAreStoredWithTheirSummary(@TempDir final File directory) {
        // given
        final File file = new File(directory, "gof.json");
        task.setGofFile(file.getPath());
        GoodnessOfFit.of(context).record(y, RMSE, "bootstrap", ResampledValues.of(List.of(1.0, 3.0)));

        // when
        new StoreModelFunction(literature).call(context, new Object[0]);

        // then
        final Map<?, ?> content = JsonMapper.builder().build().readValue(file, Map.class);
        Assertions.assertEquals(Map.of("mean", 2.0, "standard-deviation", Math.sqrt(2.0), "values", List.of(1.0, 3.0)),
                                ((Map<?, ?>) ((Map<?, ?>) content.get("y:0")).get(RMSE)).get("bootstrap"));
        Mockito.verify(writer).addOutputFeatureInformation(Mockito.eq(y), Mockito.argThat(parameter ->
                RMSE.equals(parameter.getName())
                && ((Map<?, ?>) parameter.getValue()).get("bootstrap") instanceof Map<?, ?> stored
                && Double.valueOf(2.0).equals(stored.get("mean"))));
    }
}
