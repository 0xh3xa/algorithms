package com.alg.base.unionfind;

public interface UnionFind {

    void union(int p, int q);

    boolean isConnected(int p, int q);

    int find(int p);

    int count();
}