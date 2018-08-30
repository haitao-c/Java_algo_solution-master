package io.haitaoc.datastructure.unionFind;

public class UnionFind1 implements UF {
    private int size;                   // 所有元素个数
    int[] id;                           // id[i]表示数组中第i个元素对应的连通集合编号

    public UnionFind1(int size) {
        this.size = size;
        id = new int[size];
    }

    // 找出p所在的集合编号
    private int find(int p) {
        if (p < 0 || p >= id.length)
            throw new IllegalArgumentException("p is out of bound.");

        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        //id[p] = qID;  union是指将p所在集合所有元素并到q所在集合中; 不是只将p并到q中
        if (pID==qID)       // 两个点对应的集合编号相同, 说明所在集合相同
            return ;

        // 遍历所有元素, 将两个点所在集合所有元素并到同一个集合
        for (int i = 0; i <size ; i++) {
            if(id[i]==pID)
                id[i]=qID;
        }

    }

    @Override
    public int getSize() {
        return this.size;
    }
}
