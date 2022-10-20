package io.pretty.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ObjectDoc extends Doc {
    private static final String seg = ": ";

    public ObjectDoc(Object value, boolean flatten, int depth) {
        super(value, flatten, depth);
    }

    @Override
    public String toText() throws IllegalAccessException {
        List<String> lines = new ArrayList<>();
        Field[] fields = this.value.getClass().getDeclaredFields();
        List<Field> validFields = validFields(value);
        for (Field field : fields) {
            if (validFields.stream().noneMatch(f -> f.equals(field))) {
                continue;
            }
//            String name = Color.WHITE_UNDERLINED + Color.BLUE + field.getName() + Color.RESET;
            String name = field.getName();
            field.setAccessible(true);
            Object val = field.get(this.value);
            lines.add(name + seg + new CommonDoc(val, flatten, depth).toText());
        }
        String bracketColor = Color.bracketColor(depth);
        if (lines.isEmpty()) {
            return bracketColor + "{" + Color.RESET
                    + ".." +
                    bracketColor + "}" + Color.RESET;
        }
        String leftBracket = bracketColor + "{" + Color.RESET;
        String rightBracket = bracketColor + "}" + Color.RESET;
        if (flatten) {
            String delimiter = ", ";
            String content = String.join(delimiter, lines);
            return leftBracket + " " + content + " " + rightBracket;
        } else {
            // align-left
            StringBuilder buffer = new StringBuilder();
            buffer.append("\n");
            for (int i = 0; i < this.depth * Context.INDENT; i++) {
                buffer.append(" ");
            }
            String alignLeft = buffer.toString();
            // last line, align-left
            StringBuilder builder = new StringBuilder();
            builder.append("\n");
            for (int i = 0; i < (this.depth - 1) * Context.INDENT; i++) {
                builder.append(" ");
            }
            String lastAlignLeft = builder.toString();
            String content = String.join("," + alignLeft, lines);
            // return
            return leftBracket +
                    alignLeft + content + lastAlignLeft +
                    rightBracket;
        }
    }

    private List<Field> validFields(Object object) {
        Method[] methods = object.getClass().getDeclaredMethods();
        Field[] fields = object.getClass().getDeclaredFields();
        List<Field> validFields = new ArrayList<>();
        for (Field field : fields) {
            String getter = toGetterCamlCase(field.getName());
            for (Method method : methods) {
                if (method.getName().equals(getter) && method.getParameters().length == 0) {
                    validFields.add(field);
                    break;
                }
            }
        }
        return validFields;
    }

    private String toGetterCamlCase(String name) {
        if (name.length() == 1)
            return "get" + name.toUpperCase();
        return "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
