package de.evoal.core.arff.main;

import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.core.arff.cdi.ArffBlackboardEntry;
import lombok.extern.slf4j.Slf4j;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.*;
import java.util.Enumeration;

@Slf4j
@Dependent
@Named("extract-data-definition-from-arff")
public class ExtractDataDefinition implements MainClass {

    @Inject
    @BlackboardValue(ArffBlackboardEntry.ARFF_INPUT)
    private String arffFile;

    @Inject
    @BlackboardValue(ArffBlackboardEntry.OUTPUT_FILE)
    private File ddlFile;

    @Override
    public void run() {
        try {
            final ConverterUtils.DataSource source = new ConverterUtils.DataSource(arffFile);
            final Instances structure = source.getStructure();

            try(final OutputStream ddlStream = new FileOutputStream(ddlFile)) {
                try(final PrintStream ddlPrinter = new PrintStream(ddlStream)) {
                    extractDDL(ddlPrinter, structure);
                }
            }
        } catch(final Exception e) {
            log.error("Failed to extract ddl from {}. {} might be corrupt.", arffFile, ddlFile, e);
        }
    }

    public static void extractDDL(final PrintStream writer, final Instances structure) {
        final Enumeration<Attribute> attributes = structure.enumerateAttributes();
        writer.println("data:");

        while(attributes.hasMoreElements()) {
            final Attribute attr = attributes.nextElement();

            writer.print("    ");
            writer.print(toType(attr.type()));
            writer.print(" ");
            writer.print(toStorage(attr.type()));
            writer.print(" ");
            writer.print("data");
            writer.print(" ");
            writer.print("'");
            writer.print(attr.name());
            writer.print("'");
            writer.println(";");
        }
    }

    private static String toStorage(int type) {
        switch (type) {
            case Attribute.NOMINAL:
            case Attribute.STRING:
                return "string";

            case Attribute.NUMERIC:
                return "real";

            default:
                log.error("Unsupported storage type: {}", type);
        }

        return "???";
    }

    private static String toType(int type) {
        switch (type) {
            case Attribute.NOMINAL:
            case Attribute.STRING:
                return "nominal";

            case Attribute.NUMERIC:
                return "cardinal";

            default:
                log.error("Unsupported type: {}", type);
        }

        return "???";
    }
}
