package de.evoal.core.api.board;

import de.evoal.core.api.cdi.Commandline;

public final class BlackboardEntry {
    private final String label;

    private BlackboardEntry(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public boolean isSame(final String label) {
        return this.label.equals(label);
    }

    public static BlackboardEntry of(final String label) {
        return new BlackboardEntry(label);
    }
}
