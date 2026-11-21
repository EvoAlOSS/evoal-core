package de.evoal.optimisation.main.initial;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.ecore.stream.EObjectStreamSupplier;
import de.evoal.core.api.ecore.stream.ListBasedEObjectStreamSupplier;
import de.evoal.core.api.utils.VariableToEObjectHelper;
import de.evoal.models.core.ecore.TypedEObject;

/**
 * The candidates of {@code 'candidate-list'} (DL type {@code 'specify-candidates'}).
 */
@Slf4j
@Named("de.evoal.optimisation.core.specify-candidates")
@Dependent
public class SpecifiedInitialCandidates extends GivenInitialCandidates {
    @Inject
    protected VariableToEObjectHelper toEObjectHelper;

    @Override
    protected EObjectStreamSupplier supplier(final EObject configuration) {
        log.info("Taking the candidates of 'candidate-list'.");

        final List<TypedEObject> candidates = new ArrayList<>();
        for(final EObject candidate : helper.<List<EObject>>lookup(configuration, "candidate-list")) {
            candidates.add(toEObjectHelper.fromCandidate(candidate, searchSpace));
        }

        return new ListBasedEObjectStreamSupplier(candidates);
    }

    @Override
    protected String stream() {
        return "de.evoal.optimisation.core.specify-candidates";
    }
}
