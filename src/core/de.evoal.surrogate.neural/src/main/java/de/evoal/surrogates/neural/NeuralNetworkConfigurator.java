package de.evoal.surrogates.neural;

import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.inputs.InputType;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.Layer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.learning.config.AdaGrad;
import org.nd4j.linalg.learning.config.IUpdater;
import org.nd4j.linalg.lossfunctions.LossFunctions;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

public final class NeuralNetworkConfigurator {
    private final Map<String, Object> parameters;

    public NeuralNetworkConfigurator(final Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public MultiLayerNetwork create() {
        final NeuralNetConfiguration.ListBuilder builder =
                new NeuralNetConfiguration.Builder()
                        .seed(seed())
                        .weightInit(weightInit())
                        .updater(updater())
                        .activation(activation())
                        .optimizationAlgo(optimizationAlgorithm())
                        .l2(regularizationCoefficient())
                        .list();

        final List<Map<String, Object>> layers = parameter("layers");
        for (int index = 0; index < layers.size(); ++index) {
            final Map<String, Object> configuration = layers.get(index);

            builder.layer(index, createLayer(index, configuration, index == layers.size() - 1));
        }

        builder.setInputType(InputType.feedForward((int)layers.get(0).get("in")));
        final MultiLayerNetwork nn = new MultiLayerNetwork(builder.build());
        nn.init();

        return nn;
    }

    private Layer createLayer(final int index, final Map<String, Object> configuration, boolean isOutputLayer) {
        if (isOutputLayer) {
            final OutputLayer.Builder builder = new OutputLayer.Builder();
            builder.nIn(value(configuration, "in"));
            builder.nOut(value(configuration, "out"));

            if (configuration.containsKey("weight-init")) {
                builder.weightInit(weightInit(configuration));
            }

            if (configuration.containsKey("activation")) {
                builder.activation(activation(configuration));
            }

            if (configuration.containsKey("loss-function")) {
                builder.lossFunction(lossFunction(configuration));
            }

            return builder.build();
        } else {
            final DenseLayer.Builder builder = new DenseLayer.Builder();
            builder.nIn(value(configuration, "in"));
            builder.nOut(value(configuration, "out"));

            if (configuration.containsKey("weight-init")) {
                builder.weightInit(weightInit(configuration));
            }

            if (configuration.containsKey("activation")) {
                builder.activation(activation(configuration));
            }

            return builder.build();
        }
    }

    private LossFunctions.LossFunction lossFunction(final Map<String, Object> configuration) {
        return LossFunctions.LossFunction.valueOf(value(configuration, "loss-function"));
    }

    private double regularizationCoefficient() {
        return parameter("l2-regularization-coefficient");
    }

    private OptimizationAlgorithm optimizationAlgorithm() {
        final String name = parameter("optimisation-algorithm");

        return OptimizationAlgorithm.valueOf(name);
    }

    private Activation activation() {
        return activation(parameters);
    }

    private Activation activation(final Map<String, Object> configuration) {
        final String name = value(configuration, "activation");

        return Activation.valueOf(name);
    }

    private IUpdater updater() {
        final Map<String, Object> updaterConfig = parameter("updater");

        if (NeuralNetworkConfigurator.<String>value(updaterConfig, "name").equals("ada-grad")) {
            final double learningRate = value(updaterConfig, "learning-rate");

            return new AdaGrad(learningRate);
        }
        throw new IllegalArgumentException("updater unknown: " + value(updaterConfig, "name"));
    }

    private WeightInit weightInit() {
        return weightInit(parameters);
    }

    private WeightInit weightInit(final Map<String, Object> configuration) {
        final String name = value(configuration, "weight-init");

        return WeightInit.valueOf(name);
    }

    private long seed() {
        final Object seed = parameter("seed");

        if (seed instanceof Number) {
            return ((Number) seed).longValue();
        } else {
            return new SecureRandom().nextLong();
        }
    }

    private <T> T parameter(final String name) {
        return value(parameters, name);
    }

    private static <T> T value(final Map<String, Object> map, final String name) {
        return (T) map.get(name);
    }
}