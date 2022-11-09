package de.evoal.core.api.board;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * The blackboard is a large map of {@link BlackboardEntry} to arbitrary objects.
 * For each entry change the blackboard will fire an event parametrized with the
 * entry that was changed. The board is application-scoped to allow every one to
 * access it if necessary.
 */
@Slf4j
@ApplicationScoped
public class Blackboard {

    /**
     * The internal map.
     */
    private final Map<String, Object> board = new HashMap<>();

    /**
     * Means to fire events if necessary.
     */
    @Inject
    private Event<BlackboardEntry> entryEvent;

    /**
     * Setup a clean blackboard
     */
    public Blackboard() {
        board.put("EVALUATION", "none");
    }

    /**
     * Fetches a value from the board.
     *
     * @param entry The element to fetch.
     * @param <T> The element's type.
     * @return The stored object.
     *
     * @throws IllegalStateException iff the entry is {@code null}.
     */
    public <T> @NonNull T get(final BlackboardEntry entry) {
        return get(entry.getLabel());
    }

    /**
     * Fetches a value from the board.
     *
     * @param entry The element to fetch.
     * @param <T> The element's type.
     * @return The stored object.
     *
     * @throws IllegalStateException iff the entry is {@code null}.
     */
    public <T> @NonNull T get(final String entry) {
        final T value = (T) board.get(entry);

        if(value == null) {
            throw new IllegalStateException("Value of " + entry + " is null.");
        }

        return value;
    }

    /**
     * Binds an entry to a new value. A call to this function will trigger an
     * CDI event with the passed {@code entry} to inform consumers of that
     * entry.
     *
     * @param entry The entry to bind.
     * @param element The element to bind.
     */
    public void bind(final String entry, final Object element) {
        log.info("Binding entry {} to {}.", entry, element);

        board.put(entry.toString(), element);
        entryEvent.fire(BlackboardEntry.of(entry));
    }

    /**
     * Parses all arguments from the passed command line arguments.
     *
     * @param args The command line arguments.
     */
    public void readArguments(final String[] args) {
        for(String arg : args) {
            if(!arg.startsWith("-B")) {
                continue;
            }

            log.info("Setting blackboard entry from argument: '{}'.", arg);

            arg = arg.substring(2);
            final int colonIndex = arg.indexOf('=');

            final String entry = arg.substring(0, colonIndex);
            final String value = arg.substring(colonIndex + 1);

            bind(entry, value);
        }
    }
}
