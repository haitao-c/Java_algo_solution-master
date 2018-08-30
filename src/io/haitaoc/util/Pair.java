package io.haitaoc.util;

public class Pair<E extends Object,F extends Object> {
    private E first;
    private F second;

    public E getFirst() {
        return first;
    }

    public Pair(E first, F second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(E first) {
        this.first = first;
    }

    public F getSecond() {
        return second;
    }

    public void setSecond(F second) {
        this.second = second;
    }
}
