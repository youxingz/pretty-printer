package io.pretty.core;

import java.lang.reflect.Field;
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
        for (Field field : fields) {
//            String name = Color.WHITE_UNDERLINED + Color.BLUE + field.getName() + Color.RESET;
            String name = field.getName();
            field.setAccessible(true);
            Object val = field.get(this.value);
            lines.add(name + seg + new CommonDoc(val, flatten, depth).toText());
//            if (val == null) {
//                lines.add(name + seg + new NullDoc(flatten, depth + 1).toText());
//            } else if (val instanceof String) {
//                lines.add(name + seg + new StringDoc(val.toString(), flatten, depth + 1).toText());
//            } else if (val instanceof Number) {
//                lines.add(name + seg + new NumberDoc((Number) val, flatten, depth + 1).toText());
//            } else if (val instanceof List) {
//                lines.add(name + seg + new ListDoc((List<Object>) val, flatten, depth + 1).toText());
//            } else {
//                lines.add(name + seg + new ObjectDoc(val, flatten, depth + 1).toText());
//            }
        }
        String bracketColor = Color.bracketColor(depth);
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
}
