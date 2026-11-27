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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.TreeMap;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.resource.Resource;

import de.evoal.core.api.ecore.info.BoundaryExtractor;
import de.evoal.core.api.ecore.info.ConstraintAnnotations;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.ecore.info.FeatureScales;
import de.evoal.languages.model.base.definitions.ScaleType;

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
        return dlTypeOf(configuration.eClass());
    }

    /**
     * Returns the fully-qualified DL type name of the given dynamic class.
     *
     * @param eClass The dynamic class of a DL type.
     * @return The fully-qualified name of the class, e.g. {@code model.Entry}.
     */
    public static String dlTypeOf(final @NonNull EClass eClass) {
        return fqName.get(eClass);
    }

    /**
     * Returns the package of a module, as EMF names packages: the package carries the last
     *   segment of the module name and is nested in the package of the module name without it,
     *   e.g. {@code de.evoal.core.base} is the package {@code base} in {@code core} in
     *   {@code evoal} in {@code de}. So {@link FQNProvider#get(EPackage)} gives the module name.
     *
     * @param moduleName The full name of the module.
     */
    private EPackage toEPackage(final String moduleName) {
        log.info("Fetching EPackage for module {}", moduleName);
        EPackage ePackage = ePackageCache.get(moduleName);

        if(ePackage != null) {
            return ePackage;
        }

        log.info("  creating EPackage");

        final int last = moduleName.lastIndexOf('.');

        ePackage = eFactory.createEPackage();
        ePackage.setName(moduleName.substring(last + 1));
        ePackageCache.put(moduleName, ePackage);

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
            applyNumberOfElements(definition, result);
            applyValueAnnotations(definition, result);
            attachMapping(definition, result, DynamicFactory.eINSTANCE::createAttributeMapping, DynamicPackage.eINSTANCE.getAttributeMapping_Source(), DynamicPackage.eINSTANCE.getAttributeMapping_Target());
            return result;
        }

        final EStructuralFeature result;

        if(type instanceof ClassDefinitionReference) {
            result = createInstanceReference();
        } else if(type instanceof ExpressionType || type instanceof PathType) {
            result = createExpressionReference();
        } else {
            result = eFactory.createEAttribute();
        }

        result.setName(definition.getName());
        result.setEType(definition.isOptional() ? toOptionalEClassifier(definition.getType()) : toEClassifier(definition.getType()));
        toDefaultValueLiteral(definition, result.getEType()).ifPresent(result::setDefaultValueLiteral);

        // an attribute with a default value does not have to be specified
        if(definition.isOptional() || definition.getInitialisation() != null) {
            result.setLowerBound(0);
            result.setUpperBound(1);
        } else {
            result.setLowerBound(1);
            result.setUpperBound(1);
        }

        applyValueAnnotations(definition, result);
        attachMapping(definition, result, DynamicFactory.eINSTANCE::createAttributeMapping, DynamicPackage.eINSTANCE.getAttributeMapping_Source(), DynamicPackage.eINSTANCE.getAttributeMapping_Target());

        return result;
    }

    /**
     * Sets the multiplicity of a multi-valued feature from the {@code @MinimumNumberOfElements}
     *   and {@code @MaximumNumberOfElements} annotations of the attribute. Without them, the
     *   feature keeps {@code [0..*]}.
     */
    private static void applyNumberOfElements(final AttributeDefinition definition, final EStructuralFeature feature) {
        final OptionalInt minimum = ConstraintAnnotations.minimumNumberOfElements(definition);
        final OptionalInt maximum = ConstraintAnnotations.maximumNumberOfElements(definition);

        minimum.ifPresent(feature::setLowerBound);
        maximum.ifPresent(feature::setUpperBound);
    }

    /**
     * Stores the boundaries ({@code @LowerBoundary}, {@code @UpperBoundary}) of a numeric
     *   attribute and the scale of every attribute with data values in annotations of the feature
     *   (see {@link FeatureBoundaries} and {@link FeatureScales}). The scale is the one of
     *   {@code @Scale}, else the scale of the attribute's enum, else nominal. Boundaries of other
     *   attributes, e.g. of an {@code expression} that is computed per sample, stay checks of
     *   the configuration.
     */
    private static void applyValueAnnotations(final AttributeDefinition definition, final EStructuralFeature feature) {
        if(!(feature instanceof EAttribute attribute)) {
            return;
        }

        if(NumericConversions.isNumeric(attribute.getEType())) {
            final BoundaryExtractor.Extracted boundaries = BoundaryExtractor.extract(definition);
            FeatureBoundaries.annotate(attribute, boundaries);
        }

        final ScaleType scale = ConstraintAnnotations.scaleOf(definition)
                                                     .orElseGet(() -> enumScaleOf(definition.getType()));
        FeatureScales.annotate(attribute, scale);
    }

    /**
     * Creates the feature for a DL attribute of type {@code instance T}: a containment reference,
     *   so the object is part of the tree of its owner (e.g. {@code eContainer},
     *   {@code eAllContents} and {@code EcoreUtil.copy} include it).
     */
    private static EReference createInstanceReference() {
        final EReference reference = eFactory.createEReference();
        reference.setContainment(true);

        return reference;
    }

    /**
     * @return The declared scale of the enum of the type (also of an array of the enum), nominal
     *   for every other type.
     */
    private static ScaleType enumScaleOf(final Type type) {
        if(type instanceof ArrayType array) {
            return enumScaleOf(array.getElements());
        }

        if(type instanceof EnumDefinitionReference reference && reference.getDefinition().getScale() != null) {
            return reference.getDefinition().getScale();
        }

        return ScaleType.NOMINAL;
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
     * Creates the feature for a DL attribute of type {@code expression} or {@code path}. The
     *   value is the parsed {@link Expression} (or path expression) itself, which the component
     *   evaluates later (e.g., per sample). It is not contained, so it stays in the parsed model and its references
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
        } else if(type.getElements() instanceof ClassDefinitionReference) {
            result = createInstanceReference();
            result.setEType(toEClassifier(type.getElements()));
        } else if(type.getElements() instanceof ExpressionType || type.getElements() instanceof PathType) {
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
        } else if (type instanceof PathType) {
            return "path";
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

    /**
     * Returns the Ecore type of an {@code optional} attribute. A boolean, int or real becomes
     *   the object type ({@code EBooleanObject}, {@code EIntegerObject}, {@code EDoubleObject}),
     *   whose default is {@code null}: an unassigned attribute reads as {@code null} and an
     *   assigned {@code false} or 0 counts as set. With the primitive types, EMF cannot tell
     *   these values from unassigned ones. All other types are mapped as by
     *   {@link #toEClassifier(Type)}.
     */
    private EClassifier toOptionalEClassifier(final Type type) {
        if (type instanceof BooleanType) {
            return ePackage.getEBooleanObject();
        } else if (type instanceof IntType) {
            return ePackage.getEIntegerObject();
        } else if (type instanceof RealType) {
            return ePackage.getEDoubleObject();
        }
        return toEClassifier(type);
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
        } else if (type instanceof PathType) {
            return ExpressionsPackage.Literals.PATH_EXPRESSION;
        } else if (type instanceof EnumDefinitionReference er) {
            return toEEnum(er.getDefinition());
        }
        throw new IllegalArgumentException("Unsupported type " + type);
    }

    /**
     * Returns the classes of the concrete DL types that are the given type or extend it, e.g.
     *   the comparisons a model can contain where its attribute has the abstract type
     *   {@code Comparison}. The DL types come from the modules that were loaded together with
     *   the type (the resource set of its module, i.e. the configuration and its imports), or
     *   from the module of the type if it was not loaded from a file. They are ordered by their
     *   qualified names, so the order does not depend on the loading order.
     *
     * @param type The class of a DL type.
     * @return The classes of the concrete subtypes, including the type itself if it is
     *   concrete; the class itself if it is no class of a DL type.
     */
    public List<EClass> concreteSubclassesOf(final @NonNull EClass type) {
        final Optional<ClassDefinition> definition = toClassDefinition(type);
        if(definition.isEmpty()) {
            return List.of(type);
        }

        final ClassDefinition root = definition.get();
        final Map<String, ClassDefinition> subtypes = new TreeMap<>();
        for(final ClassDefinition candidate : loadedClassDefinitions(root)) {
            final boolean isConcreteSubtype = !candidate.isAbstract() && isSubtypeOf(candidate, root);
            if(isConcreteSubtype) {
                subtypes.putIfAbsent(qualifiedNameOf(candidate), candidate);
            }
        }

        return subtypes.values()
                       .stream()
                       .map(this::toEClass)
                       .toList();
    }

    /**
     * @return {@code true} if the feature belongs to a DL attribute declared {@code optional}.
     */
    public static boolean isOptional(final @NonNull EStructuralFeature feature) {
        return feature.getEAnnotations()
                      .stream()
                      .filter(annotation -> DynamicPackage.eNS_URI.equals(annotation.getSource()))
                      .flatMap(annotation -> annotation.getContents().stream())
                      .filter(AttributeMapping.class::isInstance)
                      .map(AttributeMapping.class::cast)
                      .map(AttributeMapping::getSource)
                      .anyMatch(attribute -> attribute != null && attribute.isOptional());
    }

    /**
     * @return The DL type of a class created by this provider, or empty for any other class.
     */
    public static Optional<ClassDefinition> toClassDefinition(final @NonNull EClass type) {
        return type.getEAnnotations()
                   .stream()
                   .filter(annotation -> DynamicPackage.eNS_URI.equals(annotation.getSource()))
                   .flatMap(annotation -> annotation.getContents().stream())
                   .filter(ClassMapping.class::isInstance)
                   .map(ClassMapping.class::cast)
                   .map(ClassMapping::getSource)
                   .filter(Objects::nonNull)
                   .findFirst();
    }

    /**
     * @return The DL types of the modules loaded together with the type; the types of its own
     *   module if it was not loaded from a resource.
     */
    private static List<ClassDefinition> loadedClassDefinitions(final ClassDefinition type) {
        final Resource resource = type.eResource();
        if(resource == null || resource.getResourceSet() == null) {
            final Module module = (Module) type.eContainer();

            return classDefinitionsIn(module);
        }

        final List<ClassDefinition> definitions = new ArrayList<>();
        for(final Resource loaded : resource.getResourceSet().getResources()) {
            loaded.getContents()
                  .forEach(content -> definitions.addAll(classDefinitionsIn(content)));
        }

        return definitions;
    }

    private static List<ClassDefinition> classDefinitionsIn(final EObject root) {
        final List<ClassDefinition> definitions = new ArrayList<>();
        root.eAllContents()
            .forEachRemaining(element -> {
                if(element instanceof ClassDefinition definition) {
                    definitions.add(definition);
                }
            });

        return definitions;
    }

    private static boolean isSubtypeOf(final ClassDefinition candidate, final ClassDefinition type) {
        for(ClassDefinition current = candidate; current != null; current = current.getSuperType()) {
            if(current == type) {
                return true;
            }
        }

        return false;
    }

    private static String qualifiedNameOf(final ClassDefinition definition) {
        return ((Module) definition.eContainer()).getName() + "." + definition.getName();
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
