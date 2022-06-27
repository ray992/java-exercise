package com.exercise.algorithm.day;

public class RangeModule {

    private static final int MAX_RANGE = (int)1e9 + 7;
    private SegmentTree sg;
    public RangeModule() {
        sg = new SegmentTree();
    }

    public void addRange(int left, int right) {
        sg.update(sg.root, 1, MAX_RANGE, left, right - 1, true);
    }

    public boolean queryRange(int left, int right) {
        return sg.query(sg.root, 1, MAX_RANGE, left, right - 1);
    }

    public void removeRange(int left, int right) {
        sg.update(sg.root, 1, MAX_RANGE, left, right - 1, false);
    }

}

class SegmentTree {
    public Node root;
    public SegmentTree() {
        root = new Node();
    }

    public void update(Node node, int lc, int rc, int l, int r, boolean v) {
        if (l <= lc && rc <= r) {
            node.val = v;
            node.add = true;
            return;
        }
        pushdown(node);
        int mid = lc + rc >> 1;
        if (l <= mid) {
            update(node.ls, lc, mid, l, r, v);
        }
        if (r > mid) {
            update(node.rs, mid + 1, rc, l, r, v);
        }
        pushup(node);
    }

    public boolean query(Node node, int lc, int rc, int l, int r) {
        if (l <= lc && rc <= r) {
            return node.val;
        }
        pushdown(node);
        int mid = lc + rc >> 1;
        boolean ans = true;
        if (l <= mid) {
            ans = ans && query(node.ls, lc, mid, l, r);
        }
        if (r > mid) {
            ans = ans && query(node.rs, mid + 1, rc, l, r);
        }
        return ans;
    }

    private void pushdown(Node node) {
        if (node.ls == null) {
            node.ls = new Node();
        }
        if (node.rs == null) {
            node.rs = new Node();
        }
        if (!node.add) {
            return;
        }
        node.ls.val = node.rs.val = node.val;
        node.ls.add = node.rs.add = true;
        node.add = false;
    }

    private void pushup(Node node) {
        node.val = node.ls.val && node.rs.val;
    }

    public class Node {
        public Node ls, rs;
        public boolean val, add;
        public Node() {
            val = add = false;
        }
    }
}
