package com.alg.impl;

import com.alg.base.UnionFind;

public class QuickFind implements UnionFind {

    private int[] ids;

    public QuickFind(int N) {
        ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pid = ids[find(p)];
        int qid = ids[find(q)];
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pid) {
                ids[i] = qid;
            }
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return ids[p] == ids[q];
    }

    @Override
    public int find(int p) {
        int pid = ids[p];
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pid) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int count() {
        return ids.length;
    }
}
