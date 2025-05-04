package de.evoal.pipeline.impl.internal;

import de.evoal.languages.model.base.expressions.IntegerLiteral;
import de.evoal.languages.model.base.expressions.Literal;
import de.evoal.languages.model.base.expressions.util.ExpressionsSwitch;
import de.evoal.languages.model.generator.PipelineDefinitionReference;
import de.evoal.languages.model.generator.VariableReference;

public class LiteralSwitch extends ExpressionsSwitch<Object> {
    private final SymbolTable symbols;

    public LiteralSwitch(final SymbolTable symbols) {
        this.symbols = symbols;
    }

    @Override
    public Object caseLiteral(final Literal object) {
        if (object instanceof PipelineDefinitionReference pdr) {
            return casePipelineDefinitionReference(pdr);
        } else if(object instanceof VariableReference vr) {
            return caseVariableReference(vr);
        }

        return super.caseLiteral(object);
    }

    @Override
    public Object caseIntegerLiteral(final IntegerLiteral literal) {
        return literal.getValue();
    }

    public Object casePipelineDefinitionReference(final PipelineDefinitionReference reference) {
        final String name = reference.getPipeline().getName();

        return symbols.get(name);
    }

    public Object caseVariableReference(final VariableReference reference) {
        final String name = reference.getLoop().getName();

        return symbols.get(name);
    }
}
