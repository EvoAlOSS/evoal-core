package de.evoal.surrogates.neural;

import de.evoal.surrogate.api.configuration.Parameter;
import lombok.NonNull;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.util.ModelSerializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class NeuralNetworkHelper {
    private NeuralNetworkHelper() {
    }

    static List<Parameter> toParameters(final @NonNull MultiLayerNetwork nn) {
        final List<Parameter> parameters = new ArrayList<>();
        parameters.add(toNetworkConfig(nn));

        return parameters;
    }

    private static Parameter toNetworkConfig(final MultiLayerNetwork nn) {
        try (final ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            ModelSerializer.writeModel(nn, bos, true);

            return Parameter.builder()
                    .name("model")
                    .value(bos.toString("UTF8"))
                    .build();
        } catch (final IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed");
        }
    }
}
