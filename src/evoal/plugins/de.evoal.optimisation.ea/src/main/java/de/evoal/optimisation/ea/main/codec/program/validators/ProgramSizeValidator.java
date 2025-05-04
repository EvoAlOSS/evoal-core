package de.evoal.optimisation.ea.main.codec.program.validators;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.optimisation.ea.api.codec.program.TreeValidator;
import de.evoal.languages.model.base.expressions.Instance;
import io.jenetics.prog.ProgramChromosome;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;


@Dependent
@Named("de.evoal.optimisation.ea.genetic-programming.program-size")
public class ProgramSizeValidator implements TreeValidator {

    @Inject
    private AttributeHelper helper;

    private int maximumSize;

    @Override
    public EvoalComponent init(Instance configuration) throws InitializationException {
        maximumSize = helper.lookup(configuration, "max-size");

        return TreeValidator.super.init(configuration);
    }

    @Override
    public boolean validate(final ProgramChromosome program) {
         return program.root().size() <= maximumSize;
   }
}
