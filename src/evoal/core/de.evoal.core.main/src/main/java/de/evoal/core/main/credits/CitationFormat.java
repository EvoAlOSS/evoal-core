package de.evoal.core.main.credits;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Writes a BibTeX entry as a readable reference or as BibTeX.
 */
public final class CitationFormat {
    /**
     * The fields that name where a work appeared, in the order of preference.
     */
    private static final List<String> CONTAINER_FIELDS = List.of("booktitle", "journal", "howpublished");

    private CitationFormat() {
    }

    /**
     * @return The value of the field without BibTeX markup, empty if the entry has no such field.
     */
    private static Optional<String> plainField(final BibTeXEntry entry, final String field) {
        return Optional.ofNullable(entry.fields().get(field))
                       .map(CitationFormat::toPlainText);
    }

    /**
     * Writes the entry as BibTeX, one field per line, every value in braces.
     */
    public static String toBibTeX(final BibTeXEntry entry) {
        final StringBuilder bibtex = new StringBuilder();
        bibtex.append('@')
              .append(entry.type())
              .append('{')
              .append(entry.key())
              .append(",\n");

        for(final Map.Entry<String, String> field : entry.fields().entrySet()) {
            bibtex.append("    ")
                  .append(field.getKey())
                  .append(" = {")
                  .append(field.getValue())
                  .append("},\n");
        }

        bibtex.append("}\n");

        return bibtex.toString();
    }

    /**
     * Removes BibTeX markup: braces, LaTeX quotes, {@code --} for ranges and escaped ampersands.
     */
    private static String toPlainText(final String value) {
        return value.replace("{", "")
                    .replace("}", "")
                    .replace("``", "\"")
                    .replace("''", "\"")
                    .replace("--", "-")
                    .replace("\\&", "&");
    }

    /**
     * Writes the entry as a readable reference, e.g. {@code Eibe Frank, Mark A. Hall, Ian H.
     *   Witten. The WEKA Workbench. Online Appendix ..., 2016.} The parts are authors, title,
     *   where it appeared, publisher, pages, year and finally the DOI or URL, as far as the
     *   entry has them.
     */
    public static String toText(final BibTeXEntry entry) {
        final List<String> sentences = new ArrayList<>();

        plainField(entry, "author").map(authors -> authors.replace(" and ", ", "))
                                   .ifPresent(sentences::add);
        plainField(entry, "title").ifPresent(sentences::add);

        final List<String> publication = new ArrayList<>();
        CONTAINER_FIELDS.stream()
                        .map(field -> plainField(entry, field))
                        .flatMap(Optional::stream)
                        .findFirst()
                        .ifPresent(publication::add);
        plainField(entry, "publisher").ifPresent(publication::add);
        plainField(entry, "pages").map(pages -> "pp. " + pages)
                                  .ifPresent(publication::add);
        plainField(entry, "year").ifPresent(publication::add);
        if(!publication.isEmpty()) {
            sentences.add(String.join(", ", publication));
        }

        final String text = String.join(". ", sentences) + ".";

        // the link stands after the full stop, so it can be copied without the dot
        final Optional<String> doi = plainField(entry, "doi").map(identifier -> "https://doi.org/" + identifier);
        final Optional<String> link = doi.or(() -> plainField(entry, "url"));

        return link.map(url -> text + " " + url)
                   .orElse(text);
    }
}
