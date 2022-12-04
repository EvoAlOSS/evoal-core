package de.evoal.surrogate.api.training;

import de.evoal.core.api.properties.stream.FileBasedPropertiesStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TrainingDataManager {
    @Getter
    @Setter
    private PropertiesStreamSupplier trainingStream;
}
