package org.alg.fundamentals.impl.unionfind;

import org.alg.fundamentals.base.UnionFind;

public class WeightedQuickUnionPassCompression implements UnionFind {

    private int[] ids;
    private int[] sz;

    public WeightedQuickUnionPassCompression(int N) {
        ids = new int[N];
        sz = new int[N];
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

        if (sz[i] < sz[j]) {
            ids[i] = j;
            sz[j] += sz[i];
        } else {
            ids[j] = i;
            sz[i] += sz[j];
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public int find(int p) {
        return ids[p];
    }

    @Override
    public int count() {
        return ids.length;
    }

}
