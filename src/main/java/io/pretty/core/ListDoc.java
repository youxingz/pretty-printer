package io.pretty.core;

import java.util.ArrayList;
import java.util.List;

public class ListDoc extends Doc {
    public ListDoc(List<Object> value, boolean flatten, int depth) {
        super(value, flatten, depth);
    }

    @Override
    public String toText() throws IllegalAccessException {
        List<String> lines = new ArrayList<>();
        List listValues = (List) value;
//        if (flatten) {
//            return render(listValues, true);
//        }
        int maxLength = 0;
        int totalLength = 0;
        for (Object val : listValues) {
            String line = new CommonDoc(val, true, depth + 1).toText();
            if (maxLength < line.length()) {
                maxLength = line.length();
            }
            totalLength += line.length();
            lines.add(line);
        }
        int width = Context.COLS - 2 - depth * Context.INDENT;
        if (width > totalLength) {
            // render single line
            String bracketColor = Color.bracketColor(depth);
            StringBuilder builder = new StringBuilder();
            builder.append(bracketColor + "[" + Color.RESET);
            builder.append(" " + String.join(", ", lines) + " ");
            builder.append(bracketColor + "]" + Color.RESET);
            return builder.toString();
        } else if (width > maxLength) {
            return render(listValues, true);
        } else {
            return render(listValues, false);
        }
    }

    private String render(List listValues, boolean flat) throws IllegalAccessException {
        List<String> lines = new ArrayList<>();
        for (Object val : listValues) {
            String line = new CommonDoc(val, flat, depth).toText();
            lines.add(line);
        }
        // delimiter
        StringBuilder alignLeftBuilder = new StringBuilder();
        alignLeftBuilder.append("\n");
        for (int i = 0; i < this.depth * Context.INDENT; i++) {
            alignLeftBuilder.append(" ");
        }
        String alignLeft = alignLeftBuilder.toString();
        // last
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for (int i = 0; i < (this.depth - 1) * Context.INDENT; i++) {
            builder.append(" ");
        }
        String lastAlignLeft = builder.toString();
        String content = String.join("," + alignLeft, lines);
        // return
        String bracketColor = Color.bracketColor(depth);
        String leftBracket = bracketColor + "[" + Color.RESET;
        String rightBracket = bracketColor + "]" + Color.RESET;
        return leftBracket + alignLeft + content + lastAlignLeft + rightBracket;
    }
}
