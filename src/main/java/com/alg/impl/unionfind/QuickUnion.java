package com.alg.impl.unionfind;

import com.alg.base.unionfind.UnionFind;

public class QuickUnion implements UnionFind {

    private int[] ids;

    public QuickUnion(int N) {
        ids = new int[N];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }
    }

    private int root(int i) {
        while (i != ids[i]) {
            i = ids[i];
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
        return ids[p];
    }

    @Override
    public int count() {
        return ids.length;
    }

}