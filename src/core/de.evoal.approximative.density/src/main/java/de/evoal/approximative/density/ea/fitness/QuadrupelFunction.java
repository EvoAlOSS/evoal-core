package de.evoal.approximative.density.ea.fitness;

@FunctionalInterface
interface QuadrupelFunction<S, U, V, W, T> {
    T apply(S first, U second, V third, W fourth);
}
