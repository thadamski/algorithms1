package org.coursera.algorithms.qf;

public class QuickUnion {

    private final int[] ids;

    public QuickUnion(int n) {
        ids = new int[n];
        for (int i = 0; i < n; i++) ids[i] = i;
    }

    private int root(int i) {
        int parentId = ids[i];
        if (parentId == i) {
            return i;
        } else {
            return root(ids[parentId]);
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        ids[i] = j;
    }
}
