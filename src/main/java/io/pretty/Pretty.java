package io.pretty;

import io.pretty.core.CommonDoc;

public class Pretty {

    public static String print(Object object) {
        return print(object, 2);
    }

    public static String print(Object object, int indent) {
        return print(object, indent, false);
    }

    public static String print(Object object, int indent, boolean flatten) {
        try {
            String doc = new CommonDoc(object, flatten, 0).toText();
            System.out.println(doc);
            return doc;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}