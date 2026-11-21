package de.evoal.optimisation.main.constraints;

import java.util.List;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.optimisation.main.search.OptimisationConfigurationSetup;

/**
 * The DDL modules imported by the OL module of a problem ({@link ImportedDataModules}), loaded
 *   from {@code de/evoal/optimisation/test/imported}: {@code with-estimated.ol} imports
 *   {@code data.ddl}, which declares the features, and {@code estimated.ddl}, which declares no
 *   data and refers to the data of {@code data.ddl}.
 */
public class ImportedDataModulesTest {
    private static OptimisationModule load(final String file) {
        return LanguageHelper.loadFromClasspath("de/evoal/optimisation/test/imported/" + file);
    }

    @Test
    public void theImportedModulesComeInTheOrderOfTheImports() {
        final OptimisationModule module = load("with-estimated.ol");

        final List<DataDescriptionModule> modules = ImportedDataModules.of(OptimisationConfigurationSetup.problemOf(module));

        Assertions.assertEquals(List.of("de.evoal.optimisation.test.imported.data", "de.evoal.optimisation.test.imported.estimated"),
                                modules.stream().map(DataDescriptionModule::getName).toList());
    }

    @Test
    public void aDdlModuleRefersToTheDataOfAnImportedDdlModule() {
        final OptimisationModule module = load("with-estimated.ol");
        final List<DataDescriptionModule> modules = ImportedDataModules.of(OptimisationConfigurationSetup.problemOf(module));
        final DataDescriptionModule data = modules.get(0);
        final DataDescriptionModule estimated = modules.get(1);

        final EObject referenced = StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                                                        EcoreUtil.<EObject>getAllContents(estimated.getConstraints(), true), 0), false)
                                                .flatMap(content -> content.eCrossReferences().stream())
                                                .filter(DataDescription.class::isInstance)
                                                .findFirst()
                                                .orElseThrow();

        Assertions.assertTrue(estimated.getDescriptions().isEmpty());
        Assertions.assertSame(data.getDescriptions().getFirst(), referenced);
        Assertions.assertEquals("x", ((DataDescription) referenced).getName());
    }

    @Test
    public void aModuleWithoutImportsOfDataHasNone() {
        final OptimisationModule module = load("problem.ol");

        Assertions.assertEquals(List.of("de.evoal.optimisation.test.imported.data"),
                                ImportedDataModules.of(module.getProblem())
                                                   .stream()
                                                   .map(DataDescriptionModule::getName)
                                                   .toList());
    }
}
