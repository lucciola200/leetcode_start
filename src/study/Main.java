package study;

import java.util.ArrayList;

class Node {
    int x;
    Node l;
    Node r;
    Node parent;

    public Node(int x, Node parent) {
        this.x = x;
        this.parent = parent;
        this.l = null;
        this.r = null;
    }
}

class Tree {
    Node root;

    Tree() {
        root = null;
    }

    void add(Node v, int x) {
        if (v == null) {
            return;
        }
        if (x < v.x) {
            if (v.l == null) {
                v.l = new Node(x, v);
                return;
            }
            add(v.l, x);
        } else {
            if (v.r == null) {
                v.r = new Node(x, v);
                return;
            }
            add(v.r, x);
        }
    }

    void add(int x) {
        if (root == null) {
            root = new Node(x, null);
            return;
        }
        add(root, x);
    }

    Node fromArray(ArrayList<Integer> a, int l, int r) {
        if (l + 1 > r) return null;
        if (l + 1 == r) {
            return new Node(a.get(l), null);
        }

        int m = (l + r) / 2;
        Node t = new Node(a.get(m), null);

        t.l = fromArray(a, l, m);
        t.r = fromArray(a, m + 1, r);

        if (t.l != null) {
            t.l.parent = t;
        }
        if (t.r != null) {
            t.r.parent = t;
        }

        return t;
    }

    Tree fromArray(ArrayList<Integer> a) {
        Tree res = new Tree();
        res.root = fromArray(a, 0, a.size());

        return res;
    }

    Node find(Node v, int x) {
        if (v == null) return null;
        if (v.x == x) return v;
        if (v.x > x) {
            return find(v.l, x);
        } else {
            return find(v.r, x);
        }
    }

    Node find(int x) {
        return find(root, x);
    }

    void delete(Node t){
        if (t == null) return;
    }

    void delete(int x) {
        if (root == null) {
            return;
        }
        Node t = find(x);
        if (t == null) {
            return;
        }

        delete(t);

    }

}

public class Main {
    public static void main(String[] args) {

    }
}
