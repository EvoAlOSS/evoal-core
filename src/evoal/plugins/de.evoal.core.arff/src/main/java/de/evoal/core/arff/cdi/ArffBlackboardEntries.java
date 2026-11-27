package de.evoal.core.arff.cdi;

import de.evoal.core.api.board.BlackboardEntries;
import de.evoal.core.api.cdi.Commandline;
import de.evoal.core.arff.main.ConvertArff;
import de.evoal.core.arff.main.ExtractDataDefinition;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("arff-entries")
public class ArffBlackboardEntries implements BlackboardEntries {
    /**
     * The arff file to read.
     */
    @Commandline(main = {ConvertArff.NAME, ExtractDataDefinition.NAME}, name="arff:input", doc = "The input file used by arff utility applications.")
    public static final String ARFF_INPUT = "arff:input";

    /**
     * An DDL specification for converting an arff file into JSON.
     */
    @Commandline(main = ConvertArff.NAME, name="arff:ddl-specification", doc = "The DDL specification of attributes to read from a arff file.")
    public static final String DDL_SPECIFICATION = "arff:ddl-specification";

    /**
     * Output file for either a DDL or an JSON file (depending on the use case).
     */
    @Commandline(main = {ConvertArff.NAME, ExtractDataDefinition.NAME} , name="arff:output", doc = "The output file used by arff utility applications.")
    public static final String OUTPUT_FILE = "arff:output";

    private ArffBlackboardEntries() {}
}
