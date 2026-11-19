package de.evoal.optimisation.ea.main.codec.program;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.Requirements;
import de.evoal.optimisation.ea.api.codec.CustomCodec;
import de.evoal.optimisation.ea.api.codec.program.Operation;
import de.evoal.optimisation.ea.api.codec.program.TreeValidator;
import de.evoal.optimisation.ea.main.codec.program.operations.GenotypeInformation;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.StructuredDataDescription;
import de.evoal.languages.model.dl.util.FQNProvider;
import io.jenetics.Chromosome;
import io.jenetics.Genotype;
import io.jenetics.ext.util.Tree;
import io.jenetics.ext.util.TreeNode;
import io.jenetics.prog.ProgramChromosome;
import io.jenetics.prog.ProgramGene;
import io.jenetics.prog.op.Const;
import io.jenetics.prog.op.EphemeralConst;
import io.jenetics.prog.op.Op;
import io.jenetics.prog.op.Var;
import io.jenetics.util.Factory;
import io.jenetics.util.ISeq;
import io.jenetics.util.RandomRegistry;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class ProgramGenotypeCodec implements CustomCodec<ProgramGene<Double>> {
    @Inject
    private AttributeHelper helper;

    @Inject
    private @Named("genotype-specification") PropertiesSpecification specification;

    @Inject
    private @Named("optimisation-space-specification") PropertiesSpecification optimisationSpace;

    private List<DataDescription> genotypeSpec = Collections.emptyList();

    private PropertiesSpecification mapping;

    private List<GenotypeInformation> information;

    @Override
    public ProgramGenotypeCodec init(final Instance config) {
        log.info("Initialising program genotype codec");
        final List<Instance> chromosomeConfigurations = helper.lookup(config, "chromosomes");

        final FQNProvider provider = new FQNProvider();

        Requirements.requireFalse(chromosomeConfigurations.stream()
                                        .anyMatch(i -> !"de.evoal.optimisation.ea.genetic-programming.program-chromosome".equals(provider.get(i))),
                                 "Non program-chromosome are not allowed.");

        genotypeSpec = chromosomeConfigurations.stream()
                             .filter(i -> "de.evoal.optimisation.ea.genetic-programming.program-chromosome".equals(provider.get(i)))
                             .map(i -> helper.<DataDescription>lookup(i, "content"))
                             .collect(Collectors.toList());

        Requirements.requireTrue(
                genotypeSpec.stream()
                        .allMatch(StructuredDataDescription.class::isInstance),
                "A program chromosome can only use structured data: data <name> of instance program;"
        );

        Requirements.requireTrue(
                genotypeSpec.stream()
                        .map(StructuredDataDescription.class::cast)
                        .map(StructuredDataDescription::getType)
                        .allMatch(s -> "de.evoal.optimisation.ea.genetic-programming.program".equals(provider.get(s))),
                "A program chromosome can only use structured data: data <name> of instance program;"
        );

        mapping = PropertiesSpecification.builder()
                                         .addDescriptions(genotypeSpec.stream())
                                         .build();

        Requirements.requireSameSize(mapping.getProperties(), chromosomeConfigurations);

        information = IntStream.range(0, mapping.size())
                               .mapToObj(i -> {
                                    final Instance configuration = chromosomeConfigurations.get(i);

                                    return toChromosome(configuration, i);
                               })
                               .collect(Collectors.toList());

        return this;
    }

    private GenotypeInformation toChromosome(final Instance configuration, int genotypeIndex) {
        // TODO lookup fails if no constants are given instead of using the default values.
        final List<Const<Double>> constants = readConstants(helper.lookup(configuration, "constants"));
        final PropertiesSpecification variablesSpecification = readVariablesSpecification(helper.lookup(configuration, "variables"));
        final List<Var<Double>> vars = createVariables(variablesSpecification);
        final List<Op<Double>> operations = readOperations(helper.lookup(configuration, "operations"));
        final int depth = helper.lookup(configuration, "initial-depth");

        final List<EphemeralConst<Double>> eConstants = new ArrayList<>();

        final List<Instance> emphConfigurations = helper.lookup(configuration, "ephemeral-constants");
        emphConfigurations.stream()
                .forEach(i -> {
                    int count = helper.lookup(i, "count");
                    int lower = helper.lookup(i, "lower");
                    int upper = helper.lookup(i, "upper");

                    IntStream.range(0, count)
                             .mapToObj(o -> EphemeralConst.of(() -> ((Integer)RandomRegistry.random().nextInt(lower, upper)).doubleValue()))
                            .forEach(eConstants::add);
                });

        List<Instance> validatorConfiguration = helper.lookup(configuration, "validators");
        List<TreeValidator> validators = validatorConfiguration.stream()
                .map(i -> BeanFactory.createComponent(TreeValidator.class, i))
                .collect(Collectors.toList());

        Predicate<? super ProgramChromosome<Double>> validator = c -> validators.stream().allMatch(v -> v.validate( c));

        ProgramChromosome<Double> chromosome = ProgramChromosome.of(depth,
                                                                    validator,
                                                                    ISeq.of(operations),
                                                                    ISeq.concat(
                                                                            ISeq.concat(ISeq.of(vars), ISeq.of(constants)),
                                                                            ISeq.of(eConstants)));



        return new GenotypeInformation(mapping.get(genotypeIndex),
                                       chromosome,
                                       depth,
                                       ISeq.of(operations),
                                       ISeq.concat(ISeq.concat(ISeq.of(vars), ISeq.of(constants)), ISeq.of(eConstants)),
                                       variablesSpecification,
                                       optimisationSpace.get(genotypeIndex),
                                       genotypeIndex,
                                       validator);
    }

    private List<Op<Double>> readOperations(final List<Instance> operations) {
        return operations.stream()
                     .map(i -> BeanFactory.createComponent(Operation.class, i))
                     .map(c -> (Op<Double>)(Op<?>)c)
                     .collect(Collectors.toList());
    }

    private List<Var<Double>> createVariables(final PropertiesSpecification variablesSpecification) {
        return variablesSpecification.getProperties()
                .stream()
                .map(p -> Var.<Double>of(p.name(), variablesSpecification.indexOf(p)))
                .collect(Collectors.toList());
    }

    private PropertiesSpecification readVariablesSpecification(final List<Definition> variables) {
        return PropertiesSpecification.builder()
                                      .add(variables.stream())
                                      .build();
    }

    private <T> List<Const<Double>> readConstants(final List<Instance> constants) {
        return constants.stream()
                     .map(constant -> {
                         final String name = helper.lookup(constant, "name");
                         final double value = helper.lookup(constant, "value");

                         log.info("Found constant {} with value {}.", name, value);

                         return Const.of(name, value);
                     })
                     .collect(Collectors.toList());
    }

    @Override
    public Genotype<ProgramGene<Double>> encode(final Properties p) {
        return Genotype.of(
                information.stream()
                                 .map(info -> {
                                     PropertySpecification spec = info.searchSpaceProperty();
                                     Tree<Op<Double>, ProgramGene<Double>> tree = (Tree<Op<Double>, ProgramGene<Double>>)p.get(spec);

                                     return ProgramChromosome.of(tree, info.validator(), info.operations(), info.terminals());
                                 })
                                .collect(Collectors.toList())
        );
    }

    @Override
    public Factory<Genotype<ProgramGene<Double>>> encoding() {
        return Genotype.of(
                information.stream()
                           .map(GenotypeInformation::chromosome)
                           .collect(Collectors.toList())
        );
    }

    @Override
    public Function<Genotype<ProgramGene<Double>>, Properties> decoder() {
        return this::decodeGenotype;
    }

    private Properties decodeGenotype(final Genotype<ProgramGene<Double>> genotype) {
        final Properties result = new Properties(specification);

        IntStream.range(0, genotype.length())
                 .forEach(i -> {
                     final Chromosome<ProgramGene<Double>> chromosome = genotype.get(i);
                     final TreeNode<Op<Double>> tree = chromosome.gene().toTreeNode();
                     final GenotypeInformation info = information.get(i);
                     result.put(info.searchSpaceProperty(), tree);
                 });

        return result;
    }

    @Produces
    @Named("de.evoal.optimisation.ea.genetic-programming.program-genotype")
    @ApplicationScoped
    public static CustomCodec create() {
        log.info("Creating program-based codec for optimisation problem.");
        return BeanFactory.injectFields(new ProgramGenotypeCodec());
    }
}
