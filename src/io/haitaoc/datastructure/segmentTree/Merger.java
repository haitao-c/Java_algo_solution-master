package io.haitaoc.datastructure.segmentTree;

public interface Merger<E> {
    E merge(E a, E b);
}
