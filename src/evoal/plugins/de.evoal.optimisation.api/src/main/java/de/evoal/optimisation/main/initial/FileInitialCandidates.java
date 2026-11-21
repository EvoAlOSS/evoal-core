package de.evoal.optimisation.main.initial;

import java.io.File;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.ecore.stream.EObjectStreamSupplier;
import de.evoal.core.api.ecore.stream.FileBasedEObjectStreamSupplier;

/**
 * The candidates of the file {@code 'candidate-file'} (DL type {@code 'candidates-from-file'}).
 */
@Slf4j
@Named("de.evoal.optimisation.core.candidates-from-file")
@Dependent
public class FileInitialCandidates extends GivenInitialCandidates {
    @Override
    protected EObjectStreamSupplier supplier(final EObject configuration) {
        final String filename = helper.lookup(configuration, "candidate-file");
        log.info("Taking the candidates of the file {}.", filename);

        return new FileBasedEObjectStreamSupplier(new File(filename), searchSpace);
    }

    @Override
    protected String stream() {
        return "de.evoal.optimisation.core.candidates-from-file";
    }
}
