package io.pretty.core;

public class NumberDoc extends Doc {
    public NumberDoc(Number value, boolean flatten, int depth) {
        super(value, flatten, depth);
    }

    @Override
    public String toText() {
        return Color.BLUE_BOLD_BRIGHT + value.toString() + Color.RESET;
    }
}
