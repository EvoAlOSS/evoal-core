package de.evoal.core.arff.cdi;

import de.evoal.core.api.board.BlackboardEntries;
import de.evoal.core.api.cdi.Commandline;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("arff-entries")
public class ArffBlackboardEntries implements BlackboardEntries {
    /**
     * The arff file to read.
     */
    @Commandline(main = {"convert-arff-to-json", "extract-data-definition-from-arff"}, name="arff:input", doc = "The input file used by arff utility applications.")
    public static final String ARFF_INPUT = "arff:input";

    /**
     * An DDL specification for converting an arff file into JSON.
     */
    @Commandline(main = "convert-arff-to-json", name="arff:ddl-specification", doc = "The DDL specification of attributes to read from a arff file.")
    public static final String DDL_SPECIFICATION = "arff:ddl-specification";

    /**
     * Output file for either a DDL or an JSON file (depending on the use case).
     */
    @Commandline(main = {"convert-arff-to-json", "extract-data-definition-from-arff"} , name="arff:output", doc = "The output file used by arff utility applications.")
    public static final String OUTPUT_FILE = "arff:output";

    private ArffBlackboardEntries() {}
}
