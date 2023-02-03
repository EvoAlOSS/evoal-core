package de.evoal.core.arff.cdi;

public final class ArffBlackboardEntry {
    /**
     * The arff file to read.
     */
    public static final String ARFF_INPUT = "arff:input";


    /**
     * An DDL specification for converting an arff file into JSON.
     */
    public static final String DDL_SPECIFICATION = "arff:ddl-specification";

    /**
     * Output file for either a DDL or an JSON file (depending on the use case).
     */
    public static final String OUTPUT_FILE = "arff:output";

    private ArffBlackboardEntry() {}
}
