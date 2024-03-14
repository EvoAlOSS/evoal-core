package de.evoal.core.ea.main.codec.program.validators;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.core.ea.api.codec.program.TreeValidator;
import de.evoal.languages.model.base.Instance;
import io.jenetics.ext.util.TreeNode;
import io.jenetics.prog.ProgramChromosome;
import io.jenetics.prog.ProgramGene;
import io.jenetics.prog.op.Const;
import io.jenetics.prog.op.Var;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;


@Dependent
@Named("de.evoal.core.ea.genetic-programming.must-use-variable")
public class MustUseVariableValidator implements TreeValidator {

    @Inject
    private LanguageHelper helper;

    private int requiredCount;

    @Override
    public EvoalComponent init(Instance configuration) throws InitializationException {
        requiredCount = helper.lookup(configuration, "count");

        return TreeValidator.super.init(configuration);
    }

    @Override
    public boolean validate(final ProgramChromosome program) {

         return program.root()
                       .breadthFirstStream()
                       .map(e -> ((ProgramGene)e).toTreeNode().value())
                       .filter(Var.class::isInstance)
                       .count() >= requiredCount;
   }
}
