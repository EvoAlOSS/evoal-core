package de.evoal.core.api.literature;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import de.evoal.core.api.languages.LiteratureReader;
import de.evoal.languages.model.base.definitions.Definition;

/**
 * The literature of an application run, e.g. of an optimisation: the citations of core.main
 *   (the EvoAl paper) first, then, in the order the definitions are added, the keys of every
 *   DL type and declaration it uses ({@code @Literature}, with those of the super types) and
 *   the citations of the modules declaring them and of their libraries. Every key appears
 *   once.
 */
@Slf4j
public final class CitationList {
    /**
     * The entries of the keys.
     */
    private final LiteratureIndex index;

    /**
     * The keys with the definition that added them first ({@code null} for core.main's).
     */
    private final Map<String, Definition> keys = new LinkedHashMap<>();

    /**
     * @param index The entries of the installed modules.
     */
    public CitationList(final @NonNull LiteratureIndex index) {
        this.index = index;
        index.coreCitations()
             .forEach(key -> keys.putIfAbsent(key, null));
    }

    /**
     * Adds the literature of a DL type or declaration that the run uses.
     */
    public void add(final @NonNull Definition definition) {
        LiteratureReader.keysOf(definition)
                        .forEach(key -> keys.putIfAbsent(key, definition));
        index.moduleCitationsOf(definition)
             .forEach(key -> keys.putIfAbsent(key, definition));
    }

    /**
     * @return The keys, in their order.
     */
    public List<String> keys() {
        return List.copyOf(keys.keySet());
    }

    /**
     * @return The entries of the keys as BibTeX, separated by an empty line. A key without
     *   entry is left out with a warning (the build check of the module reports it).
     */
    public String toBibTeX() {
        final List<String> entries = new ArrayList<>();
        keys.forEach((key, owner) -> {
            final Optional<String> entry = index.bibtexOf(key, owner);
            if(entry.isEmpty()) {
                log.warn("No module defines the BibTeX entry '{}'; it is left out of the citations.", key);
            }

            entry.ifPresent(entries::add);
        });

        return String.join("\n", entries);
    }
}
