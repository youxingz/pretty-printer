package io.pretty.core;

public abstract class Doc {
    protected boolean flatten;
    protected Object value;
    protected int depth;
    protected Doc(Object value, boolean flatten, int depth) {
        this.flatten = flatten;
        this.value = value;
        this.depth = depth;
    }
    abstract String toText() throws IllegalAccessException;
}
