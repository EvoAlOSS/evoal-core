package de.evoal.pipeline.impl.internal;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.api.dynamic.ModelTransformer;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.execution.CallBuiltinFunction;
import de.evoal.languages.model.execution.NamedVariable;
import de.evoal.languages.model.execution.VariableReference;
import de.evoal.languages.model.generator.GeneratorModule;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.pipeline.PipelineModule;

/**
 * The conversion of {@code execute("name");} statements ({@link ExecutionDSLConverter}): the
 *   name becomes a reference to the converted pipeline, an unknown name is rejected. The
 *   pipelines have no steps, so no configuration has to be transformed.
 */
public class ExecuteConversionTest {
    private static PipelineModule convert(final String file) {
        final GeneratorModule module = LanguageHelper.loadFromClasspath("de/evoal/pipeline/test/" + file);
        final Space space = new Space(new EClassProvider().eClassFor(module));
        final ModelTransformer transformer = new ModelTransformer() {
            @Override
            protected Collection<EPackage> mappedPackages() {
                return List.of();
            }
        };

        return new GeneratorDSLConverter(space, transformer).convert(module);
    }

    @Test
    public void theNameBecomesAReferenceToTheConvertedPipeline() {
        final PipelineModule module = convert("execute.generator");

        final CallBuiltinFunction call = (CallBuiltinFunction) module.getProgram()
                                                                     .getMain()
                                                                     .getBody()
                                                                     .getStatements()
                                                                     .getFirst();

        Assertions.assertEquals("execute", call.getDefinition().getName());
        Assertions.assertEquals(1, call.getParameters().size());
        final VariableReference reference = (VariableReference) call.getParameters().getFirst();
        Assertions.assertInstanceOf(de.evoal.models.v202704.pipeline.PipelineDefinition.class, reference.getVariable());
        Assertions.assertEquals("other", ((NamedVariable) reference.getVariable()).getName());
    }

    @Test
    public void anUnknownPipelineIsRejected() {
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                                                                   () -> convert("unknown-pipeline.generator"));

        Assertions.assertTrue(e.getMessage().contains("'missing'"), e.getMessage());
        Assertions.assertTrue(e.getMessage().contains("'main'"), e.getMessage());
    }
}
