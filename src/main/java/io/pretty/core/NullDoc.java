package io.pretty.core;

public class NullDoc extends Doc {
    public NullDoc(boolean flatten, int depth) {
        super(null, flatten, depth);
    }

    @Override
    public String toText() {
        return Color.WHITE_BOLD + "null" + Color.RESET;
    }
}
