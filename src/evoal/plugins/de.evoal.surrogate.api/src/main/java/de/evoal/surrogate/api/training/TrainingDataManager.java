package de.evoal.surrogate.api.training;

import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.ecore.stream.EObjectStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import lombok.Getter;
import lombok.Setter;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TrainingDataManager {
    @Getter
    @Setter
    private EObjectPairStreamSupplier trainingStream;
}
