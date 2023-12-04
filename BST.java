package lab11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
    private BNode<E> root;

    public BST() {
        this.root = null;
    }

    public void addRoot(BNode<E> node) {
        root = node;
    }

    public void add(E e) {this.root.add(root, e);}

    public void add(Collection<E> col) {
        for (E e : col) add(e);
    }

    public int depth(E node) {
        int flag = 0;
        return this.root.depth(root, node, flag);
    }

    public int height() {
        return this.root.height(root);
    }

    public int size() {return this.root.size(root);}

    public boolean contains(E e) {
        return depth(e) > 0;
    }

    public E findMin() {
        return this.root.findMin(root);
    }

    public E findMax() {
        return this.root.findMax(root);
    }

    public boolean remove(E e) {
        if (this.root.findNode(root, e) == null) return false;
        BNode<E> parent = root;
        return this.root.remove(root, parent, e);
    }

    // get the descendants of a node
    public List<E> descendants(E data) {
        List<E> descendantsList = new ArrayList<>();
        if (this.root.findNode(root, data) != null) {
            if (root.getData().compareTo(data) == 0) return descendantsList;
            this.root.descendants(root, data, descendantsList);
        } else {return null;
        }return descendantsList;
    }

    // get the ancestors of a node
    public List<E> ancestors(E data) {
        List<E> ancestorList = new ArrayList<>();
        if (this.root.findNode(root, data) == null || this.root.isLeaf(this.root.findNode(root, data)))
            return ancestorList;
        BNode<E> flagNode = this.root.findNode(root, data);
        this.root.ancestors(flagNode, ancestorList);
        return ancestorList;
    }

    public void inorder() {this.root.inorder(root);}

    public void preorder() {this.root.preorder(root);}

    public void postorder() {this.root.postorder(root);}
}
