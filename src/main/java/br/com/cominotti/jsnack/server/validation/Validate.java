package br.com.cominotti.jsnack.server.validation;

import java.util.Collection;
import java.util.Map;

public class Validate {

    public static void notNullNorEmpty(String string) {
        if (string == null ||  string.length() < 1) {
            throw new IllegalArgumentException("Collection cannot be null nor empty");
        }
    }

    public static void notNullNorEmpty(Map map) {
        if (map == null ||  map.size() < 1) {
            throw new IllegalArgumentException("Collection cannot be null nor empty");
        }
    }

    public static void notNullNorEmpty(Collection collection) {
        if (collection == null ||  collection.size() < 1) {
            throw new IllegalArgumentException("Collection cannot be null nor empty");
        }
    }

    public static void notNull(Object... objects) {
        for (Object object : objects) {
            if (object == null) {
                throw new IllegalArgumentException("Object cannot be null");
            }
        }
    }

    public static void positiveNumber(Number... numbers) {
        for (Number number : numbers) {
            if (number == null || number.longValue() < 0) {
                throw new IllegalArgumentException("Number cannot be negative");
            }
        }
    }

    public static void nonNullKeysAndValues(Map<?, ?> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new IllegalArgumentException("Key or Value cannot be null ");
            }
        }
    }
}
