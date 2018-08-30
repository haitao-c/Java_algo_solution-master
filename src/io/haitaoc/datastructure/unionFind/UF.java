package io.haitaoc.datastructure.unionFind;

public interface UF {

    boolean isConnected(int p, int q);  // 判断两个点是否联通

    void unionElements(int p, int q);   // union是指将p所在集合所有元素并到q所在集合中

    int getSize();                      // 获取并查集中所有元素个数
}
