package io.pretty.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Context {
    protected static int COLS = 200; // default
    protected static int INDENT = 2; // default

    protected static List<Object> duplicatedObjects = Collections.synchronizedList(new ArrayList<>());

    {
        init();
    }

    public static void init() {
        // set console config

    }

    public static void cleanDuplicatedObjects() {
        duplicatedObjects.clear();
    }

    protected static boolean isDuplicated(Object object) {
        return duplicatedObjects.stream().anyMatch(obj -> obj.equals(object));
    }

    protected static void cacheObject(Object object) {
        duplicatedObjects.add(object);
    }
}
