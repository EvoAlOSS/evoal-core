package de.evoal.core.arff.main;

import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.core.arff.cdi.ArffBlackboardEntries;
import jakarta.enterprise.context.ApplicationScoped;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import jakarta.inject.Inject;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * Writes a DDL module for the attributes of an ARFF file: the module is named after the
 *   relation, a numeric attribute becomes {@code cardinal real data}, a nominal or string
 *   attribute {@code nominal string data}. The scale types are estimates to review.
 */
@ApplicationScoped
@Application(
        name = ExtractDataDefinition.NAME,
        documentation = "Application to automatically create a data definition file (output) based on an arff file (input)."
)
public class ExtractDataDefinition implements MainClass {
    /**
     * The name of the application, the value of {@code -Bcore:main}.
     */
    public static final String NAME = "extract-data-definition-from-arff";


    @Inject
    @BlackboardValue(ArffBlackboardEntries.ARFF_INPUT)
    private String arffFile;

    @Inject
    @BlackboardValue(ArffBlackboardEntries.OUTPUT_FILE)
    private File ddlFile;

    /**
     * Writes the DDL file.
     *
     * @throws IllegalStateException if the ARFF file cannot be read or has an attribute that a
     *   DDL file cannot describe, so the application ends with an error code. No DDL file is
     *   written then.
     */
    @Override
    public void run() {
        try {
            final ConverterUtils.DataSource source = new ConverterUtils.DataSource(arffFile);
            final Instances structure = source.getStructure();

            final ByteArrayOutputStream ddl = new ByteArrayOutputStream();
            try(final PrintStream ddlPrinter = new PrintStream(ddl, true, StandardCharsets.UTF_8)) {
                extractDDL(ddlPrinter, structure);
            }

            Files.write(ddlFile.toPath(), ddl.toByteArray());
        } catch(final Exception e) {
            throw new IllegalStateException("Failed to extract a DDL file " + ddlFile + " from " + arffFile + ".", e);
        }
    }

    /**
     * Writes the DDL module of the attributes of an ARFF file.
     *
     * @param writer The DDL file.
     * @param structure The attributes of the ARFF file.
     * @throws IllegalArgumentException if an attribute has a type that a DDL file cannot describe
     *   or a name that a DDL file cannot write.
     */
    public static void extractDDL(final PrintStream writer, final Instances structure) {
        writer.println("module " + quoted(structure.relationName()) + " {");
        writer.println("\tdata:");

        for(int i = 0; i < structure.numAttributes(); ++i) {
            final Attribute attr = structure.attribute(i);

            writer.println("\t\t" + toType(attr) + " " + toStorage(attr) + " data " + quoted(attr.name()) + ";");
        }

        writer.println("}");
    }

    /**
     * @return The name in single quotes, so a name such as {@code data} or {@code x:0} is a
     *   valid DDL name.
     */
    private static String quoted(final String name) {
        if(name.contains("'") || name.contains("\\")) {
            throw new IllegalArgumentException("The name " + name + " contains ' or \\, which a DDL name cannot contain.");
        }

        return "'" + name + "'";
    }

    private static String toStorage(final Attribute attr) {
        return switch (attr.type()) {
            case Attribute.NOMINAL, Attribute.STRING -> "string";
            case Attribute.NUMERIC -> "real";
            default -> throw unsupported(attr);
        };
    }

    private static String toType(final Attribute attr) {
        return switch (attr.type()) {
            case Attribute.NOMINAL, Attribute.STRING -> "nominal";
            case Attribute.NUMERIC -> "cardinal";
            default -> throw unsupported(attr);
        };
    }

    private static IllegalArgumentException unsupported(final Attribute attr) {
        return new IllegalArgumentException("The " + Attribute.typeToString(attr) + " attribute '" + attr.name()
                                            + "' has no DDL type; only numeric, nominal and string attributes have one.");
    }
}
