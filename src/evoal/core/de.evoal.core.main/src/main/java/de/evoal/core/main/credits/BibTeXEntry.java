package de.evoal.core.main.credits;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * One BibTeX entry, e.g. {@code @article{hall2009, title = {...}, year = 2009}}.
 *
 * @param type The entry type in lower case, e.g. {@code article}.
 * @param key The citation key.
 * @param fields The fields with lower-case names, in the order of the file. The values have
 *   their outer braces or quotes removed and their whitespace collapsed.
 */
public record BibTeXEntry(String type, String key, Map<String, String> fields) {
    public BibTeXEntry {
        final Map<String, String> orderedFields = new LinkedHashMap<>(fields);
        fields = Collections.unmodifiableMap(orderedFields);
    }
}
