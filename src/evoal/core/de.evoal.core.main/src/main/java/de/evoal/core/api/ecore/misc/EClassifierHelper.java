package de.evoal.core.api.ecore.misc;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;

public final class EClassifierHelper {
    private final static EClassifier eBoolean = EcorePackage.eINSTANCE.getEBoolean();
    private final static EClassifier eBooleanObject = EcorePackage.eINSTANCE.getEBooleanObject();
    private final static EClassifier eByte = EcorePackage.eINSTANCE.getEByte();
    private final static EClassifier eByteObject = EcorePackage.eINSTANCE.getEByteObject();
    private final static EClassifier eChar = EcorePackage.eINSTANCE.getEChar();
    private final static EClassifier eCharObject = EcorePackage.eINSTANCE.getECharacterObject();
    private final static EClassifier eDouble = EcorePackage.eINSTANCE.getEDouble();
    private final static EClassifier eDoubleObject = EcorePackage.eINSTANCE.getEDoubleObject();
    private final static EClassifier eFloat = EcorePackage.eINSTANCE.getEFloat();
    private final static EClassifier eFloatObject = EcorePackage.eINSTANCE.getEFloatObject();
    private final static EClassifier eInt = EcorePackage.eINSTANCE.getEInt();
    private final static EClassifier eIntObject = EcorePackage.eINSTANCE.getEIntegerObject();
    private final static EClassifier eLong = EcorePackage.eINSTANCE.getELong();
    private final static EClassifier eLongObject = EcorePackage.eINSTANCE.getELongObject();
    private final static EClassifier eShort = EcorePackage.eINSTANCE.getEShort();
    private final static EClassifier eShortObject = EcorePackage.eINSTANCE.getEShortObject();
    private final static EClassifier eString = EcorePackage.eINSTANCE.getEString();


    private EClassifierHelper() {}

    public static boolean isBoolean(final EClassifier type) {
        return type.equals(eBoolean) || type.equals(eBooleanObject);
    }

    public static boolean isByte(final EClassifier type) {
        return type.equals(eByte) || type.equals(eByteObject);
    }

    public static boolean isDouble(final EClassifier type) {
        return type.equals(eDouble) || type.equals(eDoubleObject);
    }

    public static boolean isFloat(final EClassifier type) {
        return type.equals(eFloat) || type.equals(eFloatObject);
    }

    public static boolean isInteger(final EClassifier type) {
        return type.equals(eInt) || type.equals(eIntObject);
    }

    public static boolean isIntegerOrShorter(final EClassifier type) {
        return isInteger(type)
                || isShortOrShorter(type);
    }

    public static boolean isLong(final EClassifier type) {
        return type.equals(eLong) || type.equals(eLongObject) ;
    }

    public static boolean isLongOrShorter(final EClassifier type) {
        return type.equals(eLong) || isIntegerOrShorter(type);
    }

    public static boolean isNumeric(final EClassifier type) {
        return isLongOrShorter(type) || isReal(type);
    }

    public static boolean isReal(final EClassifier type) {
        return isDouble(type) || isFloat(type);
    }

    public static boolean isShort(final EClassifier type) {
        return type.equals(eShort) || type.equals(eShortObject);
    }

    public static boolean isShortOrShorter(final EClassifier type) {
        return isShort(type) || isByte(type);
    }

    public static boolean isString(final EClassifier type) {
        return type.equals(eString);
    }
}
