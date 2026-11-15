package de.evoal.surrogate.api.training;

import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import lombok.Getter;
import lombok.Setter;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TrainingDataManager {
    @Getter
    @Setter
    private EObjectPairStreamSupplier trainingStream;
}
