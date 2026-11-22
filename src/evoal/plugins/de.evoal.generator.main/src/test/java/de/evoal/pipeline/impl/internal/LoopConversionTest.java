package de.evoal.pipeline.impl.internal;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.api.dynamic.ModelTransformer;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.core.api.interpreter.ProgramExecutionSwitch;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.execution.ForStatement;
import de.evoal.languages.model.execution.Range;
import de.evoal.languages.model.generator.GeneratorModule;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.pipeline.PipelineModule;

/**
 * The conversion of loops ({@link ExecutionDSLConverter}): the ranges keep their bounds and
 *   their increment, whose bounds and elements are expressions (#332).
 */
public class LoopConversionTest {
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

    /**
     * @return The values of the range of the given loop of the converted main program.
     */
    @SuppressWarnings("unchecked")
    private static List<Object> valuesOfLoop(final PipelineModule module, final int index) {
        final ForStatement loop = (ForStatement) module.getProgram()
                                                      .getMain()
                                                      .getBody()
                                                      .getStatements()
                                                      .get(index);
        final Range range = loop.getRange();
        final ProgramExecutionSwitch interpreter = new ProgramExecutionSwitch(new InterpreterState());

        return ((Stream<Object>) interpreter.doSwitch(range)).toList();
    }

    @Test
    public void aCounterRangeKeepsItsIncrement() {
        final PipelineModule module = convert("counter-loop.generator");

        Assertions.assertEquals(List.of(2, 0, -2, -4), valuesOfLoop(module, 0));
    }

    @Test
    public void theElementsOfAValueRangeAreExpressions() {
        final PipelineModule module = convert("counter-loop.generator");

        Assertions.assertEquals(List.of(-1, 6, 0.5), valuesOfLoop(module, 1));
    }
}
