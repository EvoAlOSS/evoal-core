package de.evoal.optimisation.pso.main.impl;

import lombok.extern.slf4j.Slf4j;

import de.evoal.optimisation.api.steps.Acceptance;
import de.evoal.optimisation.api.steps.Adaption;
import de.evoal.optimisation.api.steps.Initialization;
import de.evoal.optimisation.api.steps.ParameterAdjustment;
import de.evoal.optimisation.api.steps.SearchState;
import de.evoal.optimisation.api.steps.Step;

import de.evoal.optimisation.pso.api.optimiser.Swarm;

/**
 * The steps of particle swarm optimisation. The particles of the swarm (positions,
 *   velocities, personal bests) are the strategy state of the algorithm; the steps work on
 *   the swarm, and the population of an iteration describes its particles
 *   ({@link SwarmPopulation}).
 */
@Slf4j
final class SwarmSteps {
    private SwarmSteps() {
    }

    /**
     * @return Creates the particles of the swarm at the initial positions and evaluates
     *   them, one after another. If the budget runs out, the swarm consists of the particles
     *   created so far.
     */
    static Step initialise(final Swarm swarm) {
        return new Initialization() {
            @Override
            public String description() {
                return "create and evaluate the particles";
            }

            @Override
            public void execute(final SearchState state) {
                swarm.initialise();
            }
        };
    }

    /**
     * @return Adjusts the parameters of the swarm before the particles move, e.g., the
     *   direction of ARPSO. The inertia is adjusted by the mover.
     */
    static Step adjust(final Swarm swarm) {
        return new ParameterAdjustment() {
            @Override
            public String description() {
                return "adjust the swarm";
            }

            @Override
            public void execute(final SearchState state) {
                swarm.adjust(state.getIteration());
            }
        };
    }

    /**
     * @return Moves every particle: its velocity is updated towards its personal and its
     *   neighbourhood best, then its position by the velocity.
     */
    static Step move(final Swarm swarm) {
        return new Adaption() {
            @Override
            public String description() {
                return "move the particles";
            }

            @Override
            public void execute(final SearchState state) {
                log.info("Processing generation: {}", state.getIteration());

                swarm.move(state.getIteration());
            }
        };
    }

    /**
     * @return Evaluates the new positions of the particles, one after another. If the budget
     *   runs out, the particles that are not evaluated undo their move.
     */
    static Step evaluate(final Swarm swarm) {
        return new Step() {
            @Override
            public String description() {
                return "evaluate the particles";
            }

            @Override
            public void execute(final SearchState state) {
                swarm.evaluate();
            }

            @Override
            public String kind() {
                return "FitnessCalculation";
            }
        };
    }

    /**
     * @return Accepts the new positions as personal bests of the particles where they are
     *   better.
     */
    static Step updatePersonalBests(final Swarm swarm) {
        return new Acceptance() {
            @Override
            public String description() {
                return "update the personal bests";
            }

            @Override
            public void execute(final SearchState state) {
                swarm.updatePersonalBests();
            }
        };
    }
}
