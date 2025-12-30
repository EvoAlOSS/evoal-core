package de.evoal.core.arff.main;

import com.google.inject.Injector;
import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.io.PropertiesIOFactory;
import de.evoal.core.api.properties.io.PropertiesReader;
import de.evoal.core.api.properties.io.PropertiesWriter;
import de.evoal.core.arff.cdi.ArffBlackboardEntries;
import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import de.evoal.languages.model.ddl.impl.DdlPackageImpl;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import jakarta.inject.Inject;
import java.io.File;

@Slf4j
@ApplicationScoped
@Application(
        name = "convert-arff-to-json",
        documentation = """
Application to extract specific data (specified in a ddl file) from an arff
file (input) and store it in an output file (output).
"""
)
public class ConvertArff implements MainClass {

    @Inject
    @BlackboardValue(ArffBlackboardEntries.ARFF_INPUT)
    private File arffFile;

    @Inject
    @BlackboardValue(ArffBlackboardEntries.DDL_SPECIFICATION)
    private File ddlFile;

    @Inject
    @BlackboardValue(ArffBlackboardEntries.OUTPUT_FILE)
    private File jsonFile;

    @Override
    public void run() {
        final PropertiesSpecification specification = readSpecification();

        try (final PropertiesReader reader = PropertiesIOFactory.reader(arffFile, specification);
             final PropertiesWriter writer = PropertiesIOFactory.writer(jsonFile, specification)
        ) {

            while(reader.hasNext()) {
                writer.add(reader.next());
            }
        } catch(final Exception e) {
            log.error("Failed to convert from {} to {}.", arffFile, jsonFile, e);
        }
    }

    private PropertiesSpecification readSpecification() {
        final DataDescriptionModule model = loadSpecificationFile();

        return PropertiesSpecification
                    .builder()
                    .addDescriptions(model.getDescriptions().stream())
                    .build();
    }

    private DataDescriptionModule loadSpecificationFile() {
        log.info("Loading data description configuration from {}.",  ddlFile);

        if(!ddlFile.exists() || ! ddlFile.canRead()) {
            log.error("Unable to read data description configuration file '{}'", ddlFile);
            throw new IllegalArgumentException("Unable to read data description configuration file: " + ddlFile);
        }

        // init EMF + Xtext
        DdlPackageImpl.init();
        DataDescriptionLanguageStandaloneSetup.doSetup();
        final Injector dlInjector = new DataDescriptionLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();

        final XtextResourceSet resourceSet = dlInjector.getInstance(XtextResourceSet.class);
        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        resourceSet.addLoadOption(XtextResource.OPTION_ENCODING, "UTF-8");

        try {
            log.info("Continue by loading the DL file.");
            final URI modelURI = URI.createFileURI(ddlFile.getAbsolutePath());

            log.info("Loading data description model from URI {}.", modelURI);

            final Resource resource = resourceSet.getResource(modelURI, true);
            resource.load(resourceSet.getLoadOptions());

            if(!resource.getErrors().isEmpty()) {
                for(Resource.Diagnostic diagnostic : resource.getErrors()) {
                    log.error("Error while processing rule '{}': {}", ddlFile, diagnostic);
                }
            }
            if(!resource.getWarnings().isEmpty()) {
                for(Resource.Diagnostic diagnostic : resource.getWarnings()) {
                    log.error("Warning while processing rule '{}': {}", ddlFile, diagnostic);
                }
            }

            if(!resource.getErrors().isEmpty()) {
                throw new IllegalArgumentException("DL file contains errors. Please fix the file.");
            }

            return (DataDescriptionModule) resource.getContents().get(0);
        } catch (final Exception e) {
            log.error("Unable to load data description configuration file '{}'.", ddlFile, e);
            throw new RuntimeException("Unable to load data description configuration file: " + ddlFile, e);
        }
    }
}
