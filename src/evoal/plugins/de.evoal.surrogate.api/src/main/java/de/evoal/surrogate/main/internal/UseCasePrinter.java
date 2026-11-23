package de.evoal.surrogate.main.internal;

import de.evoal.core.api.languages.base.ElementSwitch;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.execution.Block;
import de.evoal.languages.model.execution.CallBuiltinFunction;
import de.evoal.languages.model.execution.Statement;
import de.evoal.languages.model.generator.ConcreteStep;
import de.evoal.languages.model.generator.PipelineDefinition;
import de.evoal.languages.model.generator.PipelineStep;
import de.evoal.languages.model.generator.Step;
import de.evoal.languages.model.mll.MachineLearningModule;
import org.eclipse.emf.ecore.EObject;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Prints the use cases of an MLL module in MLL syntax, including the parts that
 *   {@link UseCaseDerivation} derived. It knows the statements and expressions that use cases
 *   consist of and prints any other element as {@code <EClass name>}.
 */
class UseCasePrinter {
    private static final String INDENT = "  ";

    private final StringBuilder out = new StringBuilder();

    /**
     * @param module The module whose use cases to print.
     * @return The {@code use cases ... end} part of the module.
     */
    String print(final MachineLearningModule module) {
        line(0, "use cases");
        block(1, "learning", module.getLearningUseCase());
        predicting(module.getPredictionUseCase());
        block(1, "testing", module.getTestingUseCase());
        block(1, "resampling", module.getResamplingUseCase());
        line(0, "end");

        return out.toString();
    }

    private void block(final int depth, final String name, final Block block) {
        if(block == null) {
            return;
        }

        line(depth, "specify " + name);
        line(depth, "begin");
        block.getStatements().forEach(statement -> statement(depth + 1, statement));
        line(depth, "end;");
    }

    private void predicting(final PipelineDefinition predicting) {
        if(predicting == null) {
            return;
        }

        line(1, "specify predicting");
        line(1, "begin");
        predicting.getSteps().forEach(step -> line(2, expression(2, step)));
        line(1, "end;");
    }

    private void statement(final int depth, final Statement statement) {
        if(statement instanceof CallBuiltinFunction call) {
            line(depth, name(call.getDefinition().getName()) + "(" + list(depth, call.getParameters()) + ");");
        } else if(statement instanceof Block block) {
            line(depth, "begin");
            block.getStatements().forEach(s -> statement(depth + 1, s));
            line(depth, "end");
        } else {
            line(depth, unknown(statement) + ";");
        }
    }

    private String expression(final int depth, final EObject expression) {
        if(expression instanceof ConcreteStep step) {
            return "step { component " + expression(depth, step.getInstance())
                   + features(" reads ", step.getReads())
                   + features(" writes ", step.getWrites())
                   + " }";
        } else if(expression instanceof PipelineStep step) {
            return "pipeline " + name(step.getDefinition().getName());
        } else if(expression instanceof Instance instance) {
            if(instance.getAttributes().isEmpty()) {
                return name(instance.getDefinition().getName()) + " {}";
            }

            return name(instance.getDefinition().getName()) + " { "
                   + instance.getAttributes()
                             .stream()
                             .map(a -> name(a.getDefinition().getName()) + " := " + expression(depth, a.getValue()) + "; ")
                             .collect(Collectors.joining())
                   + "}";
        } else if(expression instanceof Array array) {
            final boolean withSteps = array.getValues()
                                           .stream()
                                           .map(ElementSwitch::elementOf)
                                           .flatMap(Optional::stream)
                                           .anyMatch(Step.class::isInstance);
            if(withSteps) {
                final String indent = INDENT.repeat(depth + 1);
                return "[\n" + indent
                       + array.getValues()
                              .stream()
                              .map(v -> expression(depth + 1, v))
                              .collect(Collectors.joining(",\n" + indent))
                       + "\n" + INDENT.repeat(depth) + "]";
            }

            return "[" + list(depth, array.getValues()) + "]";
        } else if(expression instanceof TypeDefinitionReference reference) {
            return (reference.getDefinition() instanceof DataDescription ? "data " : "") + name(reference.getDefinition().getName());
        } else if(expression instanceof StringLiteral literal) {
            return "\"" + literal.getLiteral() + "\"";
        } else if(expression instanceof IntegerLiteral literal) {
            return Integer.toString(literal.getLiteral());
        } else if(expression instanceof RealLiteral literal) {
            return Double.toString(literal.getLiteral());
        } else if(expression instanceof BooleanLiteral literal) {
            return Boolean.toString(literal.isLiteral());
        } else if(expression instanceof Expression wrapped) {
            final Optional<ReadExpression> element = ElementSwitch.elementOf(wrapped);
            if(element.isPresent() && element.get() != expression) {
                return expression(depth, element.get());
            }
        }

        return unknown(expression);
    }

    private String features(final String keyword, final List<TypeDefinitionReference> features) {
        if(features.isEmpty()) {
            return "";
        }

        return keyword + "[" + list(0, features) + "]";
    }

    private String list(final int depth, final List<? extends EObject> expressions) {
        return expressions.stream()
                          .map(e -> expression(depth, e))
                          .collect(Collectors.joining(", "));
    }

    private static String name(final String name) {
        return "'" + name + "'";
    }

    private static String unknown(final EObject element) {
        return element == null ? "<none>" : "<" + element.eClass().getName() + ">";
    }

    private void line(final int depth, final String text) {
        out.append(INDENT.repeat(depth)).append(text).append('\n');
    }
}
