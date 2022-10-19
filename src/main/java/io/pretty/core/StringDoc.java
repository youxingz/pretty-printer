package io.pretty.core;

public class StringDoc extends Doc {
    private static final String seg = "\"";

    public StringDoc(String value, boolean flatten, int depth) {
        super(value, flatten, depth);
    }

    @Override
    public String toText() {
        // if too long
        String val = value.toString();
        if (val.length() <= Context.COLS - 4) { // if end with: '", \n'
            return Color.CYAN_BOLD + seg + val + seg + Color.RESET;
        }
        // split
        StringBuilder builder = new StringBuilder();
        builder.append(seg);
//        builder.append(Color.ANSI_CYAN);
        int width = Context.COLS - depth * Context.INDENT - 1; // 1: seg:
        int current = 0;
        int length = val.length() - width;
        while (current < length) {
            builder.append(val, current, width);
            current += width;
        }
        builder.append(val, current, val.length());
//        builder.append(Color.ANSI_RESET);
        builder.append(seg);
        return Color.WHITE_BACKGROUND + Color.BLUE + builder.toString() + Color.RESET;
    }
}
