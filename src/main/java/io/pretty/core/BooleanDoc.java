package io.pretty.core;

public class BooleanDoc extends Doc {
    public BooleanDoc(Boolean value, boolean flatten, int depth) {
        super(value, flatten, depth);
    }

    @Override
    public String toText() {
        return (Boolean) value
                ? Color.GREEN_BOLD_BRIGHT + "true" + Color.RESET
                : Color.RED_BOLD + "false" + Color.RESET;
    }
}
