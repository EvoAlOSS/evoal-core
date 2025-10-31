package de.evoal.surrogate.main.internal;

import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.generator.ConcreteStep;
import de.evoal.languages.model.generator.GeneratorFactory;
import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * Injects the default behaviour into the module. This allows us to encapsulate this
 *   information into a single place.
 */
@Slf4j
public class DefaultBehaviourInjector {
    /**
     * For creating expression elements.
     */
    private final static ExpressionsFactory exprFactory = ExpressionsFactory.eINSTANCE;

    /**
     * For loading definition modules.
     */
    private final DefinitionModuleLoader loader;

    /**
     * The input space we are working on.
     */
    private final List<DataDescription> inputs;

    /**
     * The output space we are working on.
     */
    private final List<DataDescription> outputs;

    public DefaultBehaviourInjector(final @NonNull DefinitionModuleLoader loader,
                                    final @NonNull List<DataDescription> inputs,
                                    final @NonNull List<DataDescription> outputs) {
        this.loader = loader;
        this.inputs = inputs;
        this.outputs = outputs;
    }

    public void inject(final MachineLearningModule module) {
        log.info("Injecting default behaviour into machine learning module {}.", module.getName());

        injectDefaultPipelines(module);
        injectDefaultPipelineComponents(module);
        injectAccessedData(module);

        linkLearner(module);
    }

    private void linkLearner(final MachineLearningModule module) {
        final Instance modelConfiguration = module.getModel();

        final TreeIterator<EObject> contents = module.eAllContents();
        while (contents.hasNext()) {
            final EObject element = contents.next();

            if(element instanceof Instance instance) {
                final ClassDefinition classDefinition = instance.getDefinition();
                final DefinitionModule defModule = (DefinitionModule) classDefinition.eContainer();

                if(!"model-learner".equals(classDefinition.getName()) || !"de.evoal.surrogate.pipeline".equals(defModule.getName())) {
                    continue;
                }

                Attribute attribute = instance.findAttribute("model");
                if(attribute == null) {
                    log.info("Copying model definition to model learner.");
                    final AttributeDefinition attrDefinition = classDefinition.findAttribute("model");
                    attribute = exprFactory.createAttribute();
                    attribute.setDefinition(attrDefinition);
                    attribute.setValue(EcoreUtil.copy(modelConfiguration));

                    instance.getAttributes().add(attribute);
                }

                attribute = instance.findAttribute("model-file");
                if(attribute == null) {
                    log.info("Copying model file to model learner.");
                    final StringLiteral literal = exprFactory.createStringLiteral();
                    literal.setLiteral(module.getTask().getModelFile());


                    final AttributeDefinition attrDefinition = classDefinition.findAttribute("model-file");
                    attribute = exprFactory.createAttribute();
                    attribute.setDefinition(attrDefinition);
                    attribute.setValue(literal);

                    instance.getAttributes().add(attribute);
                }

                attribute = instance.findAttribute("input-features");
                if(attribute == null) {
                    log.info("Copying input features to model learner.");
                    final Array array = exprFactory.createArray();

                    module.getTask()
                          .getInputs()
                          .stream()
                            .map(d -> {
                                final TypeDefinitionReference ref = exprFactory.createTypeDefinitionReference();
                                ref.setDefinition(d);
                                return ref;
                            })
                          .forEach(array.getValues()::add);

                    final AttributeDefinition attrDefinition = classDefinition.findAttribute("input-features");
                    attribute = exprFactory.createAttribute();
                    attribute.setDefinition(attrDefinition);
                    attribute.setValue(array);

                    instance.getAttributes()
                            .add(attribute);
                }

                attribute = instance.findAttribute("output-features");
                if(attribute == null) {
                    log.info("Copying output features to model learner.");
                    final Array array = exprFactory.createArray();

                    module.getTask()
                            .getOutputs()
                            .stream()
                            .map(d -> {
                                final TypeDefinitionReference ref = exprFactory.createTypeDefinitionReference();
                                ref.setDefinition(d);
                                return ref;
                            })
                            .forEach(array.getValues()::add);

                    final AttributeDefinition attrDefinition = classDefinition.findAttribute("output-features");
                    attribute = exprFactory.createAttribute();
                    attribute.setDefinition(attrDefinition);
                    attribute.setValue(array);

                    instance.getAttributes()
                            .add(attribute);
                }
            }
        }
    }

    private void injectDefaultPipelineComponents(MachineLearningModule module) {
        log.info("Injecting default components pipelines into machine learning module {}.", module.getName());
        injectReaderComponentIntoLearningPipeline(module);
    }

    private void injectReaderComponentIntoLearningPipeline(final MachineLearningModule mlm) {
        log.info("Injecting reader step into learning pipeline.");
        final DefinitionModule pipeModule = loader.load("classpath:/de/evoal/pipeline/io.dl");
        final ClassDefinition readerDefinition = pipeModule.getTypes()
                .stream()
                .filter(t -> "reader".equals(t.getName()))
                .findFirst()
                .get();

        final AttributeDefinition filenameDefinition = readerDefinition.getAttributes()
                .stream()
                .filter(a -> "filename".equals(a.getName()))
                .findFirst()
                .get();

        final StringLiteral filenameLiteral = exprFactory.createStringLiteral();
        filenameLiteral.setLiteral(mlm.getTask().getLearningData().get(0)); // TODO Merge multiple files

        final Attribute filenameAttribute = exprFactory.createAttribute();
        filenameAttribute.setDefinition(filenameDefinition);
        filenameAttribute.setValue(filenameLiteral);

        final Instance readerInstance = exprFactory.createInstance();
        readerInstance.getAttributes().add(filenameAttribute);
        readerInstance.setDefinition(readerDefinition);

        final ConcreteStep readerStep = GeneratorFactory.eINSTANCE.createConcreteStep();
        readerStep.getWrites()
                  .addAll(combinedSpaces());
        readerStep.setInstance(readerInstance);

        // TODO mlm.getLearningUseCase().getSteps().add(0, readerStep);
    }

    private Collection<? extends TypeDefinitionReference> combinedSpaces() {
        return Stream.concat(inputs.stream(), outputs.stream())
                    .map(is -> {
                        final TypeDefinitionReference ref = exprFactory.createTypeDefinitionReference();
                        ref.setDefinition(is);
                        return ref;
                    })
                    .toList();
    }

    private void injectDefaultPipelines(final MachineLearningModule module) {
        log.info("Injecting default pipelines into machine learning module {}.", module.getName());
    }

    private void injectAccessedData(final MachineLearningModule module) {
        log.info("Injecting accessed data into machine learning module {}.", module.getName());
    }
}
