package de.evoal.core.api.dynamic;

import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.ExpressionsPackage;
import de.evoal.languages.model.base.types.*;
import de.evoal.languages.model.dynamic.*;
import de.evoal.languages.model.interpreter.ConstantEvaluator;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import de.evoal.models.core.cdi.ConfiguredBy;
import de.evoal.models.core.utils.FQNProvider;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.*;

import de.evoal.languages.model.base.Module;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.EnumDefinition;
import de.evoal.languages.model.base.definitions.EnumLiteralDefinition;
import org.eclipse.emf.ecore.util.EcoreUtil;

@ApplicationScoped
@Slf4j
public class DynamicEClassProvider {
    private final static EcoreFactory eFactory = EcoreFactory.eINSTANCE;
    private final static EcorePackage ePackage = EcorePackage.eINSTANCE;

    /**
     * Source of the annotation that maps a generated {@link EClass} to a DL type.
     *   The annotation's {@link #DL_MAPPING_TYPE} detail contains the fully-qualified
     *   name of the DL type, e.g., {@code de.evoal.core.base.configuration}.
     */
    public static final String DL_MAPPING_SOURCE = "https://evoal.de/v202610/models/core/DL-Mapping";

    /**
     * Detail key of the DL-Mapping annotation that contains the DL type.
     */
    public static final String DL_MAPPING_TYPE = "type";

    /**
     * Source of the annotation that documents the DL type configuring a generated
     *   component {@link EClass}. The annotation's {@link #CONFIGURED_BY_TYPE} detail
     *   contains the fully-qualified name of the DL type. The Java counterpart is
     *   {@link ConfiguredBy}.
     */
    public static final String CONFIGURED_BY_SOURCE = "https://evoal.de/v202610/models/core/configured-by";

    /**
     * Detail key of the configured-by annotation that contains the DL type.
     */
    public static final String CONFIGURED_BY_TYPE = "type";

    /**
     * For generating fully-qualified DL type names of dynamic classes.
     */
    private static final FQNProvider fqName = new FQNProvider();

    private final HashMap<String, EPackage> ePackageCache = new HashMap<>();

    /**
     * Configuring DL types of generated component classes (Java instance class to fully-qualified
     *   DL type name). Built from the configured-by annotations of the packages passed to
     *   {@link #registerPackage(EPackage)}.
     */
    private final Map<Class<?>, String> configuringTypes = new HashMap<>();

    /**
     * Generated classes that serve as super class for the dynamic class of a DL type
     *   (fully-qualified DL type name to generated class). Built from the DL-Mapping
     *   annotations of the packages passed to {@link #registerPackage(EPackage)}.
     *
     * The packages have to be registered explicitly, since the global EMF package registry
     *   cannot be enumerated in a standalone (non-Eclipse) environment.
     */
    private final Map<String, EClass> superClasses = new HashMap<>();

    /**
     * Name of the dynamic package that contains the generated array classes.
     */
    public static final String ARRAY_PACKAGE = "de.evoal.core.dynamic.arrays";

    /**
     * Generated array classes (class name to class), see {@link DynamicArrays}.
     */
    private final Map<String, EClass> arrayClasses = new HashMap<>();

    /**
     * Generated enumerations (DL enum to EEnum).
     */
    private final Map<EnumDefinition, EEnum> enums = new HashMap<>();

    public EClass toEClass(final @NonNull ClassDefinition definition) {
        final Optional<ClassMapping> mapping = findMapping(definition, ClassMapping.class);

        // check if EClass was already mapped and return it
        if(mapping.isPresent()) {
            Requirements.requireEqual(definition, mapping.get().getSource());
            return mapping.get().getTarget();
        }

        // create new eclass and put it into the cache
        log.info("Creating EClass for {}", definition.getName());
        final EClass eClass = eFactory.createEClass();
        eClass.setName(definition.getName());

        // connect to internal model
        final String fqn = ((Module)definition.eContainer()).getName() + "." + definition.getName();
        // the generated super class has to be the first super type, since EMF instantiates
        // dynamic classes using the factory of the first super type with a Java class.
        findGeneratedSuperClass(fqn).ifPresent(eClass.getESuperTypes()::add);


        attachMapping(definition, eClass, DynamicFactory.eINSTANCE::createClassMapping, DynamicPackage.eINSTANCE.getClassMapping_Source(), DynamicPackage.eINSTANCE.getClassMapping_Target());

        final Module module = (Module) definition.eContainer();
        final String moduleName = module.getName();
        final EPackage ePackage = toEPackage(moduleName);

        ePackage.getEClassifiers()
                .add(eClass);

        final ClassDefinition superClass = definition.getSuperType();
        if(superClass != null) {
            log.info("  processing super class {}", superClass.getName());
            eClass.getESuperTypes()
                    .add(toEClass(superClass));
        }

        for(int i = 0; i < definition.getAttributes().size(); i++) {
//        for(final AttributeDefinition attribute : definition.getAttributes()) {
            log.info("  processing attribute {} of {} in {} -- {}", i, definition.getAttributes().size(), definition.getName(), definition.getAttributes());
            final AttributeDefinition attribute = definition.getAttributes()
                                                            .get(i);
            eClass.getEStructuralFeatures()
                  .add(toEStructuralFeature(attribute));
        }

        return eClass;
    }

    /**
     * Looks up the generated class that is mapped to the given DL type.
     *
     * @param fqn Fully-qualified name of the DL type.
     * @return The generated class or an empty optional if the DL type is not mapped.
     */
    private Optional<EClass> findGeneratedSuperClass(final String fqn) {
        return Optional.ofNullable(superClasses.get(fqn));
    }

    /**
     * Registers a generated package whose classes carry DL-Mapping annotations. The
     *   package and its sub-packages are indexed. A package has to be registered before
     *   the first dynamic class of a mapped DL type is created.
     *
     * @param ePackage The generated package to register.
     */
    public void registerPackage(final @NonNull EPackage ePackage) {
        log.info("Registering DL-Mapping annotations of package '{}'.", ePackage.getNsURI());
        indexPackage(ePackage);
    }

    private void indexPackage(final EPackage ePackage) {
        if(ePackage == null) {
            return;
        }

        for(final EClassifier classifier : ePackage.getEClassifiers()) {
            if(!(classifier instanceof EClass eClass)) {
                continue;
            }

            indexConfiguredBy(eClass);

            final EAnnotation annotation = eClass.getEAnnotation(DL_MAPPING_SOURCE);
            if(annotation == null) {
                continue;
            }

            final String dlType = annotation.getDetails().get(DL_MAPPING_TYPE);
            if(dlType == null) {
                log.warn("Ignoring DL-Mapping annotation of '{}' without a '{}' detail.", eClass.getName(), DL_MAPPING_TYPE);
                continue;
            }

            final EClass existing = superClasses.putIfAbsent(dlType, eClass);
            if(existing != null && existing != eClass) {
                throw new IllegalStateException("DL type '" + dlType + "' is mapped to both '" + existing.getName() + "' and '" + eClass.getName() + "'.");
            }

            log.debug("  DL type '{}' is mapped to '{}'.", dlType, eClass.getName());
        }

        // sub-packages are usually registered as well, but we do not rely on it
        ePackage.getESubpackages().forEach(this::indexPackage);
    }

    private void indexConfiguredBy(final EClass eClass) {
        final EAnnotation annotation = eClass.getEAnnotation(CONFIGURED_BY_SOURCE);
        if(annotation == null) {
            return;
        }

        final String dlType = annotation.getDetails().get(CONFIGURED_BY_TYPE);
        final Class<?> instanceClass = eClass.getInstanceClass();
        if(dlType == null || instanceClass == null) {
            log.warn("Ignoring configured-by annotation of '{}' without a '{}' detail or instance class.", eClass.getName(), CONFIGURED_BY_TYPE);
            return;
        }

        configuringTypes.put(instanceClass, dlType);
        log.debug("  '{}' is configured by DL type '{}'.", eClass.getName(), dlType);
    }

    /**
     * Returns the DL type that configures components of the given Java type. The DL type is
     *   taken from the {@link ConfiguredBy} annotation of the type and from the configured-by
     *   annotation of the corresponding generated {@link EClass}. Only the type itself is
     *   inspected, not its super types.
     *
     * @param type The component type.
     * @return The fully-qualified name of the configuring DL type or an empty optional if
     *   neither annotation is present.
     *
     * @throws IllegalStateException if both annotations are present but name different DL types.
     */
    public Optional<String> findConfiguringType(final @NonNull Class<?> type) {
        final ConfiguredBy javaAnnotation = type.getAnnotation(ConfiguredBy.class);
        final String javaType = javaAnnotation == null ? null : javaAnnotation.value();
        final String ecoreType = configuringTypes.get(type);

        if(javaType != null && ecoreType != null && !javaType.equals(ecoreType)) {
            throw new IllegalStateException("Component type '" + type.getName() + "' is configured by '" + javaType + "' (Java) and by '" + ecoreType + "' (Ecore).");
        }

        return Optional.ofNullable(javaType != null ? javaType : ecoreType);
    }

    /**
     * Returns the DL type that the configurations held by the given feature must have,
     *   taken from the feature's configured-by annotation.
     *
     * @param feature The feature, usually a reference of type {@code Configuration}.
     * @return The fully-qualified name of the DL type or an empty optional if the feature
     *   is not annotated.
     */
    public static Optional<String> findConfiguringType(final @NonNull EStructuralFeature feature) {
        return Optional.ofNullable(feature.getEAnnotation(CONFIGURED_BY_SOURCE))
                       .map(annotation -> annotation.getDetails().get(CONFIGURED_BY_TYPE));
    }

    /**
     * Checks if the given configuration is an instance of the given DL type, i.e., if its
     *   dynamic class is the DL type or one of its sub-types.
     *
     * @param configuration The configuration to check.
     * @param dlType The fully-qualified name of the DL type.
     * @return {@code true} iff the configuration is an instance of the DL type.
     */
    public static boolean isInstanceOf(final @NonNull EObject configuration, final @NonNull String dlType) {
        final EClass eClass = configuration.eClass();

        return dlType.equals(fqName.get(eClass))
            || eClass.getEAllSuperTypes()
                     .stream()
                     .map(fqName::get)
                     .anyMatch(dlType::equals);
    }

    /**
     * Returns the fully-qualified DL type name of the given configuration.
     *
     * @param configuration The configuration.
     * @return The fully-qualified name of its dynamic class.
     */
    public static String dlTypeOf(final @NonNull EObject configuration) {
        return fqName.get(configuration.eClass());
    }

    private EPackage toEPackage(final String moduleName) {
        log.info("Fetching EPackage for module {}", moduleName);
        EPackage ePackage = ePackageCache.get(moduleName);

        if(ePackage != null) {
            return ePackage;
        }

        log.info("  creating EPackage");

        ePackage = eFactory.createEPackage();
        ePackage.setName(moduleName);
        ePackageCache.put(moduleName, ePackage);

        final int last = moduleName.lastIndexOf('.');
        if(last != -1) {
            final String parentName = moduleName.substring(0, last);

            final EPackage parent = toEPackage(parentName);
            parent.getESubpackages().add(ePackage);
        }

        return ePackage;
    }

    private EStructuralFeature toEStructuralFeature(final AttributeDefinition definition) {
        log.info("  fetching EStructuralFeature for {}", definition.getName());

        final Optional<AttributeMapping> oMapping = findMapping(definition, AttributeMapping.class);

        if(oMapping.isPresent()) {
            Requirements.requireEqual(definition,  oMapping.get().getSource());

            return oMapping.get().getTarget();
        }

        final Type type = definition.getType();
        if (type instanceof DefinitionReference ref) {
            log.info("    creating EStructuralFeature -- {} --> {}", type, ref.getDefinition());
        } else {
            log.info("    creating EStructuralFeature -- {}", type);
        }

        if(type instanceof ArrayType arrayType) {
            final EStructuralFeature result = createArrayFeature(definition.getName(), arrayType);
            attachMapping(definition, result, DynamicFactory.eINSTANCE::createAttributeMapping, DynamicPackage.eINSTANCE.getAttributeMapping_Source(), DynamicPackage.eINSTANCE.getAttributeMapping_Target());
            return result;
        }

        final EStructuralFeature result;

        if(type instanceof ClassDefinition) {
            result = eFactory.createEReference();
        } else if(type instanceof ExpressionType) {
            result = createExpressionReference();
        } else {
            result = eFactory.createEAttribute();
        }

        result.setName(definition.getName());
        result.setEType(toEClassifier(definition.getType()));
        toDefaultValueLiteral(definition, result.getEType()).ifPresent(result::setDefaultValueLiteral);

        // an attribute with a default value does not have to be specified
        if(definition.isOptional() || definition.getInitialisation() != null) {
            result.setLowerBound(0);
            result.setUpperBound(1);
        } else {
            result.setLowerBound(1);
            result.setUpperBound(1);
        }

        attachMapping(definition, result, DynamicFactory.eINSTANCE::createAttributeMapping, DynamicPackage.eINSTANCE.getAttributeMapping_Source(), DynamicPackage.eINSTANCE.getAttributeMapping_Target());

        return result;
    }

    /**
     * Computes the {@link EStructuralFeature#getDefaultValueLiteral() default value literal}
     *   of an attribute with a data type (boolean, int, real, string, enum). The default is
     *   documented in the dynamic class this way. It is applied when creating runtime objects
     *   (see {@link ValueConverter#applyDefaults}), since EMF only supports defaults for
     *   single-valued data types.
     *
     * @return The literal or an empty optional if the attribute has no (constant) default
     *   or its type does not support default value literals.
     */
    private Optional<String> toDefaultValueLiteral(final AttributeDefinition definition, final EClassifier eType) {
        final Expression initialisation = definition.getInitialisation();
        if(initialisation == null || !(eType instanceof EDataType dataType)) {
            return Optional.empty();
        }

        final Class<?> instanceClass = dataType.getInstanceClass();
        final boolean supported = dataType instanceof EEnum
                               || NumericConversions.isNumeric(dataType)
                               || instanceClass == boolean.class || instanceClass == Boolean.class
                               || instanceClass == String.class;
        if(!supported) {
            return Optional.empty();
        }

        try {
            final Object value = new ConstantEvaluator().doSwitch(initialisation);

            if(dataType instanceof EEnum) {
                return value instanceof EnumLiteralDefinition literal ? Optional.of(literal.getName()) : Optional.empty();
            }

            return Optional.ofNullable(EcoreUtil.convertToString(dataType, NumericConversions.toType(value, dataType)));
        } catch(final RuntimeException e) {
            log.warn("Unable to compute the default value literal of attribute '{}': {}", definition.getName(), e.getMessage());
            return Optional.empty();
        }
    }

    /**
     * Creates the feature for a DL attribute of type {@code expression}. The value is the
     *   parsed {@link Expression} itself, which the component evaluates later (e.g., per
     *   sample). It is not contained, so it stays in the parsed model and its references
     *   (data, constants, ...) remain valid. See {@link ValueConverter#convert(EObject)}.
     */
    private EReference createExpressionReference() {
        final EReference reference = eFactory.createEReference();
        reference.setContainment(false);
        return reference;
    }

    /**
     * Creates the multi-valued feature for an array type. A one-dimensional array becomes
     *   a multi-valued feature of the element type. A multi-dimensional array becomes a
     *   multi-valued containment reference to the array class of the next dimension, see
     *   {@link DynamicArrays}.
     *
     * @param name Name of the feature.
     * @param type The array type.
     * @return The new (unattached) feature.
     */
    private EStructuralFeature createArrayFeature(final String name, final ArrayType type) {
        final EStructuralFeature result;

        if(type.getElements() instanceof ArrayType inner) {
            final EReference reference = eFactory.createEReference();
            reference.setContainment(true);
            reference.setEType(toArrayClass(inner));
            result = reference;
        } else if(type.getElements() instanceof ExpressionType) {
            result = createExpressionReference();
            result.setEType(toEClassifier(type.getElements()));
        } else {
            result = eFactory.createEAttribute();
            result.setEType(toEClassifier(type.getElements()));
            // arrays may contain the same value more than once, e.g., [0.0, 0.0]
            result.setUnique(false);
        }

        result.setName(name);
        result.setLowerBound(0);
        result.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
        result.setOrdered(true);

        return result;
    }

    /**
     * Returns the array class for the given array type, i.e., the class whose instances
     *   contain the elements of one dimension. Array classes are created once per element
     *   type and stored in the package {@link #ARRAY_PACKAGE}.
     *
     * @param type The array type that is represented by the array class.
     * @return The array class.
     */
    private EClass toArrayClass(final ArrayType type) {
        final String name = arrayClassName(type);
        final EClass cached = arrayClasses.get(name);
        if(cached != null) {
            return cached;
        }

        log.info("Creating array class {}", name);
        final EClass eClass = eFactory.createEClass();
        eClass.setName(name);

        final EAnnotation annotation = eFactory.createEAnnotation();
        annotation.setSource(DynamicArrays.ARRAY_SOURCE);
        annotation.getDetails().put(DynamicArrays.ARRAY_ELEMENTS, typeName(type.getElements()));
        eClass.getEAnnotations().add(annotation);

        // register before creating the features to support recursive element types
        arrayClasses.put(name, eClass);
        toEPackage(ARRAY_PACKAGE).getEClassifiers().add(eClass);

        eClass.getEStructuralFeatures().add(createArrayFeature(DynamicArrays.VALUES, type));

        return eClass;
    }

    private static String arrayClassName(final ArrayType type) {
        return "Array_" + typeName(type.getElements()).replaceAll("[^A-Za-z0-9]", "_");
    }

    private static String typeName(final Type type) {
        if (type instanceof ArrayType at) {
            return "array " + typeName(at.getElements());
        } else if (type instanceof BooleanType) {
            return "boolean";
        } else if (type instanceof ClassDefinitionReference cr) {
            final ClassDefinition definition = cr.getDefinition();
            return ((Module)definition.eContainer()).getName() + "." + definition.getName();
        } else if (type instanceof IntType) {
            return "int";
        } else if (type instanceof RealType) {
            return "real";
        } else if (type instanceof StringType) {
            return "string";
        } else if (type instanceof DataType) {
            return "data";
        } else if (type instanceof LiteralType) {
            return "literal";
        } else if (type instanceof ExpressionType) {
            return "expression";
        } else if (type instanceof EnumDefinitionReference er) {
            final EnumDefinition definition = er.getDefinition();
            return "enum " + ((Module)definition.eContainer()).getName() + "." + definition.getName();
        }
        throw new IllegalArgumentException("Unsupported array element type " + type);
    }

    /**
     * Returns the EEnum for the given DL enum. It is created once and stored in the package
     *   of the DL module, next to the classes of that module. The literals keep the order of
     *   the DL definition, i.e., the literal's value is its position.
     *
     * @param definition The DL enum.
     * @return The EEnum.
     */
    public EEnum toEEnum(final @NonNull EnumDefinition definition) {
        final EEnum cached = enums.get(definition);
        if(cached != null) {
            return cached;
        }

        log.info("Creating EEnum for {}", definition.getName());
        final EEnum eEnum = eFactory.createEEnum();
        eEnum.setName(definition.getName());

        int value = 0;
        for(final EnumLiteralDefinition literalDefinition : definition.getLiterals()) {
            final EEnumLiteral literal = eFactory.createEEnumLiteral();
            literal.setName(literalDefinition.getName());
            literal.setLiteral(literalDefinition.getName());
            literal.setValue(value++);
            eEnum.getELiterals().add(literal);
        }

        enums.put(definition, eEnum);
        toEPackage(((Module) definition.eContainer()).getName()).getEClassifiers().add(eEnum);

        return eEnum;
    }

    private EClassifier toEClassifier(final Type type) {
        if (type instanceof ArrayType) {
            throw new IllegalArgumentException("Array types have to be mapped using createArrayFeature.");
        } else if (type instanceof BooleanType) {
            return ePackage.getEBoolean();
        } else if (type instanceof ClassDefinitionReference cr) {
            return toEClass(cr.getDefinition());
        } else if (type instanceof IntType) {
            return ePackage.getEInt();
        } else if (type instanceof RealType) {
            return ePackage.getEDouble();
        } else if (type instanceof StringType) {
            return ePackage.getEString();
        } else if (type instanceof DataType dt) {
            return ePackage.getEStructuralFeature();
        } else if (type instanceof LiteralType) {
            return ePackage.getEJavaObject();
        } else if (type instanceof ExpressionType) {
            return ExpressionsPackage.Literals.EXPRESSION;
        } else if (type instanceof EnumDefinitionReference er) {
            return toEEnum(er.getDefinition());
        }
        throw new IllegalArgumentException("Unsupported type " + type);
    }

    public EObject getEObject(final EClass clazz) {
        log.info("Creating EObject for {}", clazz.getName());
        return clazz
                .getEPackage()
                .getEFactoryInstance()
                .create(clazz);
    }

    public EStructuralFeature getFeature(final AttributeDefinition feature) {
        Optional<AttributeMapping> oMapping = findMapping(feature, AttributeMapping.class);

        if(oMapping.isEmpty()) {
            throw new IllegalArgumentException("Cannot find definition for " + feature);
        }

        final AttributeMapping mapping = oMapping.get();

        Requirements.requireEqual(mapping.getSource(), feature);
        return mapping.getTarget();
    }


    private <T extends Mapping> Optional<T> findMapping(final Definition object, final Class<T> clazz) {
        log.info("Looking up mapping for {}", object);
        return object
                .getEAnnotations()
                .stream()
                .filter(a -> DynamicPackage.eNS_URI.equals(a.getSource()))
                .map(a -> a.getContents().stream().filter(clazz::isInstance).findFirst())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(clazz::cast)
                .findFirst();
    }

    private <S extends Definition, T extends EModelElement> void attachMapping(final S dsl, final T ecore, final Supplier<EObject> factory, final EStructuralFeature dslSetter, final EStructuralFeature ecoreSetter) {
        final EObject mapping = factory.get();
        mapping.eSet(dslSetter, dsl);
        mapping.eSet(ecoreSetter, ecore);

        final EAnnotation annotation = eFactory.createEAnnotation();
        annotation.setSource(DynamicPackage.eNS_URI);
        annotation.getContents().add(mapping);

        dsl.getEAnnotations()
           .add(annotation);

        ecore.getEAnnotations()
           .add(EcoreUtil.copy(annotation));
    }
}
