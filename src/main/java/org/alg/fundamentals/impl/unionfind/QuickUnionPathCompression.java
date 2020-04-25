package org.alg.fundamentals.impl.unionfind;

import org.alg.fundamentals.base.UnionFind;

public class QuickUnionPathCompression implements UnionFind {

    private int[] ids;

    public QuickUnionPathCompression(int N) {
        ids = new int[N];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }
    }

    private int root(int i) {
        while (i != ids[i]) {
            i = ids[ids[i]];
        }
        return i;
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        ids[i] = j;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public int find(int p) {
        return root(p);
    }

    @Override
    public int count() {
        return ids.length;
    }

}
