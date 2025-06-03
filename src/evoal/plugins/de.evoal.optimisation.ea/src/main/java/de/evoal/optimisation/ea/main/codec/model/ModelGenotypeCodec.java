package de.evoal.optimisation.ea.main.codec.model;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.types.ArrayType;
import de.evoal.languages.model.base.types.DefinitionReference;
import de.evoal.languages.model.base.types.Type;
import de.evoal.optimisation.ea.api.codec.CustomCodec;
import de.evoal.optimisation.ea.api.codec.model.ModelChromosome;
import de.evoal.optimisation.ea.api.codec.model.ModelGene;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.StructuredDataDescription;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.dl.util.FQNProvider;
import io.jenetics.Genotype;
import io.jenetics.util.Factory;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@ApplicationScoped
public class ModelGenotypeCodec implements CustomCodec<ModelGene> {
    private static final String CHROMOSOME_NAME = "de.evoal.optimisation.ea.mdo.model-chromosome";
    static final String GENOTYPE_NAME = "de.evoal.optimisation.ea.mdo.model-genotype";
    private static final String MODEL_DATA_NAME = "de.evoal.optimisation.ea.mdo.model";

    @Inject
    private AttributeHelper helper;

    @Inject
    private @Named("genotype-specification") PropertiesSpecification specification;

    @Inject
    private @Named("optimisation-space-specification") PropertiesSpecification optimisationSpace;

    private List<DataDescription> genotypeSpec = Collections.emptyList();

    private PropertiesSpecification mapping;

    private PropertiesSpecification variablesSpecification;

    private List<GenotypeInformation> information;

    @Override
    public ModelGenotypeCodec init(final Instance config) {
        log.info("Initialising model genotype codec");
        final List<Instance> chromosomeConfigurations = helper.lookup(config, "chromosomes");

        final FQNProvider provider = new FQNProvider();

        Requirements.requireFalse(chromosomeConfigurations
                                        .stream()
                                        .anyMatch(i -> !CHROMOSOME_NAME.equals(provider.get(i))),
                                 "Non model-chromosome are not allowed.");

        genotypeSpec = chromosomeConfigurations
                             .stream()
                             .filter(i -> CHROMOSOME_NAME.equals(provider.get(i)))
                             .map(i -> helper.<DataDescription>lookup(i, "root"))
                             .collect(Collectors.toList());

        Requirements.requireTrue(
                genotypeSpec.stream()
                        .allMatch(StructuredDataDescription.class::isInstance),
                "A model chromosome can only use structured data: data <name> of instance program;"
        );

        Requirements.requireTrue(
                genotypeSpec.stream()
                        .map(StructuredDataDescription.class::cast)
                        .map(StructuredDataDescription::getType)
                        .allMatch(ModelGenotypeCodec::isSubclassOfModel),
                "A model chromosome can only use structured data: data <name> of instance model;"
        );

        mapping = PropertiesSpecification.builder()
                                         .addDescriptions(genotypeSpec.stream())
                                         .build();

        Requirements.requireTrue(mapping.size() == chromosomeConfigurations.size(), "Required to be of same size.");

        information = IntStream.range(0, mapping.size())
                               .mapToObj(i -> {
                                    final Instance configuration = (Instance) chromosomeConfigurations.get(i);

                                    return toChromosome(configuration, i);
                               })
                               .collect(Collectors.toList());

        return this;
    }

    private static boolean isSubclassOfModel(final ClassDefinition definition) {
        final FQNProvider provider = new FQNProvider();

        if(MODEL_DATA_NAME.equals(provider.get(definition))) {
            return true;
        }

        if(definition.getSuperType() == null) {
            return false;
        }

        return isSubclassOfModel(definition.getSuperType());
    }

    private GenotypeInformation toChromosome(final Instance configuration, int genotypeIndex) {
        final StructuredDataDescription type = (StructuredDataDescription)genotypeSpec.get(genotypeIndex);

        log.info("Converting configuration with base {} to chromosome.", type.getName());
        final Map<ClassDefinition, Set<ClassDefinition>> subtypes = createSubtypeTable(type);
        final Map<AttributeDefinition, Set<ClassDefinition>> attributes = createAttributeTable(type, subtypes);
        final Set<AttributeDefinition> arrays = collectArrays(type);

/*
        Object [] validatorConfiguration = helper.lookup(configuration, "validators");
        List<TreeValidator> validators = Arrays.stream(validatorConfiguration)
                .map(Instance.class::cast)
                .map(i -> BeanFactory.createComponent(TreeValidator.class, i))
                .collect(Collectors.toList());

        Predicate<? super ModelChromosome> validator = c -> validators.stream().allMatch(v -> v.validate(c));
*/

        final ModelBuilder memento = new ModelBuilder(type.getType(),
                                                                          subtypes,
                                                                          attributes);
        final ModelChromosome chromosome = ModelChromosome.of(memento);

        return new GenotypeInformation(mapping.get(genotypeIndex), memento, chromosome);
    }

    private Set<AttributeDefinition> collectArrays(StructuredDataDescription type) {
        final Set<AttributeDefinition> arrays = new HashSet<>();

        final Set<ClassDefinition> working = new HashSet<>();
        final Set<ClassDefinition> visited = new HashSet<>();
        working.add(type.getType());

        while(!working.isEmpty()) {
            final ClassDefinition currentType = working.iterator().next();
            working.remove(currentType);

            if(visited.contains(currentType)) {
                continue;
            }

            visited.add(currentType);

            for(final AttributeDefinition attr : currentType.getAttributes()) {
                Type attrType = attr.getType();

                if(attrType instanceof ArrayType arrayType) {
                    arrays.add(attr);
                    attrType = arrayType.getElements();
                }

                if(attrType instanceof DefinitionReference instanceType) {
                    working.add((ClassDefinition) instanceType.getDefinition());
                }
            }
        }

        return arrays;
    }

    private Map<AttributeDefinition, Set<ClassDefinition>> createAttributeTable(final StructuredDataDescription type, final Map<ClassDefinition, Set<ClassDefinition>> subtypes) {
        final Map<AttributeDefinition, Set<ClassDefinition>> attributes = new HashMap<>();

        final Set<ClassDefinition> working = new HashSet<>();
        final Set<ClassDefinition> visited = new HashSet<>();
        working.add(type.getType());

        while(!working.isEmpty()) {
            final ClassDefinition currentType = working.iterator().next();
            working.remove(currentType);

            if(visited.contains(currentType)) {
                continue;
            }

            visited.add(currentType);

            for(final AttributeDefinition attr : currentType.getAttributes()) {
                Type attrType = attr.getType();

                if(attrType instanceof ArrayType) {
                    attrType = ((ArrayType)attrType).getElements();
                }

                if(attrType instanceof DefinitionReference instanceType) {
                    final Set<ClassDefinition> types = subtypes.get(instanceType.getDefinition());
                    attributes.put(attr, types);
                    working.add((ClassDefinition) instanceType.getDefinition());
                }
            }
        }

        return attributes;
    }

    private Map<ClassDefinition, Set<ClassDefinition>> createSubtypeTable(final StructuredDataDescription root) {
        final DefinitionModule module = (DefinitionModule) root.getType().eContainer();
        final Map<ClassDefinition, Set<ClassDefinition>> subtypes = new HashMap<>();

        for(final ClassDefinition type : module.getTypes()) {
            subtypes.put(type, new HashSet<>());
        }

        for(final ClassDefinition type : module.getTypes()) {
            if(type.isAbstract()) {
                continue;
            }

            ClassDefinition parent = type;
            while(parent != null) {
                if(subtypes.containsKey(parent)) {
                    subtypes.get(parent).add(type);
                }
                parent = parent.getSuperType();
            }
        }

        return subtypes;
    }


    @Override
    public Genotype<ModelGene> encode(final Properties p) {
        return Genotype.of(
                information.stream()
                                 .map(info -> {
                                     PropertySpecification spec = info.searchSpaceProperty();
                                     final Instance model = (Instance)p.get(spec);

                                     return ModelChromosome.of(info.memento(), model);
                                 })
                                .collect(Collectors.toList())
        );
    }

    @Override
    public Factory<Genotype<ModelGene>> encoding() {
        return Genotype.of(
                information.stream()
                           .map(GenotypeInformation::chromosome)
                           .collect(Collectors.toList())
        );
    }

    @Override
    public Function<Genotype<ModelGene>, Properties> decoder() {
        return this::decodeGenotype;
    }

    private Properties decodeGenotype(final Genotype<ModelGene> genotype) {
        final Properties result = new Properties(specification);

        IntStream.range(0, genotype.length())
                 .forEach(i -> {
                     final ModelChromosome chromosome = (ModelChromosome)genotype.get(i);
                     final Instance model = chromosome.getModel();
                     final GenotypeInformation info = information.get(i);
                     result.put(info.searchSpaceProperty(), model);
                 });

        return result;
    }

    @Produces
    @Named(GENOTYPE_NAME)
    @ApplicationScoped
    public static CustomCodec create() {
        log.info("Creating model-based codec for optimisation problem.");
        return BeanFactory.injectFields(new ModelGenotypeCodec());
    }
}
