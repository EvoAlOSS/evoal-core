package de.evoal.core.ea.main.codec.model;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.core.api.utils.Requirements;
import de.evoal.core.ea.api.codec.CustomCodec;
import de.evoal.core.ea.api.codec.model.ModelChromosome;
import de.evoal.core.ea.api.codec.model.ModelGene;
import de.evoal.languages.model.base.*;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.StructuredDataDescription;
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
    private static final String CHROMOSOME_NAME = "de.evoal.core.ea.mdo.model-chromosome";
    static final String GENOTYPE_NAME = "de.evoal.core.ea.mdo.model-genotype";
    private static final String MODEL_DATA_NAME = "de.evoal.core.ea.mdo.model";

    @Inject
    private LanguageHelper helper;

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
        final Object[] chromosomeConfigurations = helper.lookup(config, "chromosomes");

        final FQNProvider provider = new FQNProvider();

        Requirements.requireFalse(Arrays.stream(chromosomeConfigurations)
                                        .map(Instance.class::cast)
                                        .anyMatch(i -> !CHROMOSOME_NAME.equals(provider.get(i))),
                                 "Non model-chromosome are not allowed.");

        genotypeSpec = Arrays.stream(chromosomeConfigurations)
                             .map(Instance.class::cast)
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

        Requirements.requireTrue(mapping.size() == chromosomeConfigurations.length, "Required to be of same size.");

        information = IntStream.range(0, mapping.size())
                               .mapToObj(i -> {
                                    final Instance configuration = (Instance) chromosomeConfigurations[i];

                                    return toChromosome(configuration, i);
                               })
                               .collect(Collectors.toList());

        return this;
    }

    private static boolean isSubclassOfModel(final TypeDefinition definition) {
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
        final Map<TypeDefinition, Set<TypeDefinition>> subtypes = createSubtypeTable(type);
        final Map<AttributeDefinition, Set<TypeDefinition>> attributes = createAttributeTable(type, subtypes);
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

        final Set<TypeDefinition> working = new HashSet<>();
        final Set<TypeDefinition> visited = new HashSet<>();
        working.add(type.getType());

        while(!working.isEmpty()) {
            final TypeDefinition currentType = working.iterator().next();
            if(visited.contains(currentType)) {
                continue;
            }

            working.remove(currentType);
            visited.add(currentType);

            for(final AttributeDefinition attr : currentType.getAttributes()) {
                Type attrType = attr.getType();

                if(attrType instanceof ArrayType arrayType) {
                    arrays.add(attr);
                    attrType = arrayType.getElements();
                }

                if(attrType instanceof InstanceType instanceType) {
                    working.add(instanceType.getDefinition());
                }
            }
        }

        return arrays;
    }

    private Map<AttributeDefinition, Set<TypeDefinition>> createAttributeTable(final StructuredDataDescription type, final Map<TypeDefinition, Set<TypeDefinition>> subtypes) {
        final Map<AttributeDefinition, Set<TypeDefinition>> attributes = new HashMap<>();

        final Set<TypeDefinition> working = new HashSet<>();
        final Set<TypeDefinition> visited = new HashSet<>();
        working.add(type.getType());

        while(!working.isEmpty()) {
            final TypeDefinition currentType = working.iterator().next();
            if(visited.contains(currentType)) {
                continue;
            }

            working.remove(currentType);
            visited.add(currentType);

            for(final AttributeDefinition attr : currentType.getAttributes()) {
                Type attrType = attr.getType();

                if(attrType instanceof ArrayType) {
                    attrType = ((ArrayType)attrType).getElements();
                }

                if(attrType instanceof InstanceType instanceType) {
                    final Set<TypeDefinition> types = subtypes.get(instanceType.getDefinition());
                    attributes.put(attr, types);
                    working.add(instanceType.getDefinition());
                }
            }
        }

        return attributes;
    }

    private Map<TypeDefinition, Set<TypeDefinition>> createSubtypeTable(final StructuredDataDescription root) {
        final DefinitionModule module = (DefinitionModule) root.getType().eContainer();
        final Map<TypeDefinition, Set<TypeDefinition>> subtypes = new HashMap<>();

        for(final TypeDefinition type : module.getTypes()) {
            subtypes.put(type, new HashSet<>());
        }

        for(final TypeDefinition type : module.getTypes()) {
            if(type.isAbstract()) {
                continue;
            }

            TypeDefinition parent = type;
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
