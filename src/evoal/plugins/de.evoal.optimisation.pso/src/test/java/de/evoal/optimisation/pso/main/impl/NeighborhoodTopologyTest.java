package de.evoal.optimisation.pso.main.impl;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NeighborhoodTopologyTest {
    private static List<Integer> ring(final int neighborhoodSize, final int particle) {
        final NeighborhoodTopology topology = new NeighborhoodTopology(NeighborhoodTopology.Topology.RING, 10, neighborhoodSize);

        return List.of(topology.getNeighborIDs(particle));
    }

    @Test
    public void anOddRingIsCentredOnTheParticle() {
        Assertions.assertEquals(List.of(4, 5, 6), ring(3, 5));
        Assertions.assertEquals(List.of(3, 4, 5, 6, 7), ring(5, 5));
    }

    @Test
    public void anEvenRingHasOneMoreParticleOnTheLeft() {
        Assertions.assertEquals(List.of(4, 5), ring(2, 5));
        Assertions.assertEquals(List.of(3, 4, 5, 6), ring(4, 5));
    }

    @Test
    public void theRingWrapsAroundTheSwarm() {
        Assertions.assertEquals(List.of(8, 9, 0, 1, 2), ring(5, 0));
        Assertions.assertEquals(List.of(7, 8, 9, 0, 1), ring(5, 9));
    }
}
