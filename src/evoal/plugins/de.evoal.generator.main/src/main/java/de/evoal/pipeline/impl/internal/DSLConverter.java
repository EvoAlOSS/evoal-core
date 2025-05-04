package de.evoal.pipeline.impl.internal;

import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.Import;
import de.evoal.languages.model.base.expressions.Literal;
import de.evoal.languages.model.generator.*;
import de.evoal.languages.model.generator.util.GeneratorSwitch;
import de.evoal.languages.model.base.expressions.DataReference;
import de.evoal.languages.model.pipeline.PipelineFactory;
import de.evoal.languages.model.pipeline.PipelineModule;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DSLConverter extends GeneratorSwitch<Object> {
    private final PipelineFactory factory = PipelineFactory.eINSTANCE;
    private final Map<String, EStructuralFeature> features = new HashMap<>();
    private final Map<PipelineDefinition, de.evoal.languages.model.pipeline.PipelineDefinition> pipelines = new HashMap<>();

    public DSLConverter(final @NonNull EClass space) {
        for(final EStructuralFeature feature : space.getEStructuralFeatures()) {
            features.put(feature.getName(), feature);
        }
    }

    public PipelineModule convert(final GeneratorModule module) {
        log.info("Converting generator module {} into a PipelineModule.", module.getName());
        return (PipelineModule) this.doSwitch(module);
    }

    @Override
    public PipelineModule caseGeneratorModule(final GeneratorModule obj) {
        final PipelineModule module = factory.createPipelineModule();
        module.setName(obj.getName());

        for(final Import imp : obj.getImports()) {
            module.getImports().add(caseImport(imp));
        }

        for(final PipelineDefinition def : obj.getPipelines()) {
            module.getPipelines().add(casePipelineDefinition(def));
        }

        for(final Statement stmt : obj.getStatements()) {
            module.getStatements().add((de.evoal.languages.model.pipeline.Statement) doSwitch(stmt));
        }

        return module;
    }

    public Import caseImport(final Import imp) {
        return EcoreUtil.copy(imp);
    }

    @Override
    public de.evoal.languages.model.pipeline.PipelineDefinition casePipelineDefinition(final PipelineDefinition obj) {
        final de.evoal.languages.model.pipeline.PipelineDefinition result = factory.createPipelineDefinition();;
        result.setName(obj.getName());

        for(final Step step : obj.getSteps()) {
            result.getSteps().add(caseStep(step));
        }

        pipelines.put(obj, result);

        return result;
    }

    @Override
    public de.evoal.languages.model.pipeline.Step caseStep(final Step obj) {
        final de.evoal.languages.model.pipeline.Step result = factory.createStep();

        result.setInstance(EcoreUtil.copy(obj.getInstance()));

        obj.getReads()
                .stream()
                .map(DataReference::getDefinition)
                .map(Definition::getName)
                .map(features::get)
                .forEach(ef -> result.getReads().add((EAttribute)ef));

        obj.getWrites()
                .stream()
                .map(DataReference::getDefinition)
                .map(Definition::getName)
                .map(features::get)
                .forEach(ef -> result.getWrites().add((EAttribute)ef));

        return result;
    }

    @Override
    public de.evoal.languages.model.pipeline.ForStatement caseForStatement(final ForStatement obj) {
        final de.evoal.languages.model.pipeline.ForStatement result = factory.createForStatement();
        result.setName(obj.getName());

        for(final Statement stmt : obj.getStatements()) {
            result.getStatements().add((de.evoal.languages.model.pipeline.Statement) doSwitch(stmt));
        }

        result.setRange((de.evoal.languages.model.pipeline.Range)doSwitch(obj.getRange()));

        return result;
    }

    @Override
    public Object caseApplyStatement(final ApplyStatement obj) {
        final de.evoal.languages.model.pipeline.ApplyStatement result = factory.createApplyStatement();

        result.setCount(EcoreUtil.copy(obj.getCount()));
        result.setFile(obj.getFile());

        for(final Literal ref : obj.getPipelines()) {
            Requirements.requireInstanceOf(ref, PipelineDefinitionReference.class);

            result.getPipelines().add(casePipelineDefinitionReference((PipelineDefinitionReference) ref));
        }

        log.info("There are {} pipelines in the origin and {} pipelines in the target.", obj.getPipelines().size(), result.getPipelines().size());

        return result;
    }

    @Override
    public de.evoal.languages.model.pipeline.PipelineDefinitionReference casePipelineDefinitionReference(final PipelineDefinitionReference obj) {
        log.info("Converting pipeline reference to {}.", obj.getPipeline().getName());

        final de.evoal.languages.model.pipeline.PipelineDefinitionReference result = factory.createPipelineDefinitionReference();
        result.setPipeline(pipelines.get(obj.getPipeline()));

        return result;
    }

    @Override
    public de.evoal.languages.model.pipeline.CounterRange caseCounterRange(final CounterRange obj) {
        final de.evoal.languages.model.pipeline.CounterRange result = factory.createCounterRange();

        result.setStart(EcoreUtil.copy(obj.getStart()));
        result.setEnd(EcoreUtil.copy(obj.getEnd()));

        return result;
    }

    @Override
    public de.evoal.languages.model.pipeline.LiteralRange caseLiteralRange(final LiteralRange obj) {
        final de.evoal.languages.model.pipeline.LiteralRange result = factory.createLiteralRange();

        for(final Literal literal : obj.getElements()) {
            if(literal instanceof PipelineDefinitionReference) {
                result.getElements().add(casePipelineDefinitionReference((PipelineDefinitionReference) literal));
            } else {
                result.getElements().add(EcoreUtil.copy(literal));
            }
        }

        return result;
    }
}
