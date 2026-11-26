package de.evoal.core.arff;

import de.evoal.core.arff.main.ExtractDataDefinition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import weka.core.Attribute;
import weka.core.Instances;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * The DDL module that is derived from the attributes of an ARFF file (#356).
 */
public class ExtractDataDefinitionTest {
    private static String ddlOf(final Attribute... attributes) {
        final Instances structure = new Instances("demo", new ArrayList<>(List.of(attributes)), 0);
        final ByteArrayOutputStream ddl = new ByteArrayOutputStream();

        try(final PrintStream printer = new PrintStream(ddl, true, StandardCharsets.UTF_8)) {
            ExtractDataDefinition.extractDDL(printer, structure);
        }

        return ddl.toString(StandardCharsets.UTF_8);
    }

    @Test
    public void theAttributesBecomeAModuleNamedAfterTheRelation() {
        // when
        final String ddl = ddlOf(new Attribute("x:0"),
                                 new Attribute("data", List.of("a", "b")),
                                 new Attribute("s", (List<String>) null));

        // then: quoted names, also the keyword data
        Assertions.assertEquals("""
                                module 'demo' {
                                \tdata:
                                \t\tcardinal real data 'x:0';
                                \t\tnominal string data 'data';
                                \t\tnominal string data 's';
                                }
                                """, ddl);
    }

    @Test
    public void aNameWithAQuoteIsRejected() {
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                                                                   () -> ddlOf(new Attribute("it's")));

        Assertions.assertTrue(e.getMessage().contains("it's"), e.getMessage());
    }

    @Test
    public void aDateAttributeIsRejected() {
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                                                                   () -> ddlOf(new Attribute("when", "yyyy-MM-dd")));

        Assertions.assertTrue(e.getMessage().contains("The date attribute 'when' has no DDL type"), e.getMessage());
    }
}
