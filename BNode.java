package lab11;

import java.util.List;

public class BNode<E extends Comparable<E>> {
    private E data;
    private BNode<E> left;
    private BNode<E> right;

    public BNode(E data1) {
        data = data1;
        left = null;
        right = null;
    }

    public BNode(E data, BNode<E> left, BNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public E getData() {
        return data;
    }

    public BNode<E> getLeft() {
        return left;
    }

    public BNode<E> getRight() {
        return right;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setLeft(BNode<E> left) {
        this.left = left;
    }

    public void setRight(BNode<E> right) {
        this.right = right;
    }

    public void add(BNode<E> node, E e) {
        if (node == null) {
            node = new BNode<>(e);
        } else {
            if (node.getData().compareTo(e) < 0) {
                if (node.getRight() == null) {
                    node.setRight(new BNode<>(e));
                } else {
                    add(node.getRight(), e);
                }
            } else {
                if (node.getLeft() == null) {
                    node.setLeft(new BNode<>(e));
                } else {
                    add(node.getLeft(), e);
                }
            }
        }
    }

    public int depth(BNode<E> supRoot, E node, int flag) {
        if (supRoot == null) return -1;
        if (node.compareTo(supRoot.getData()) == 0) return 0;
        if (node.compareTo(supRoot.getData()) > 0) {
            if (supRoot.getRight() == null) {
                return -(flag + 1);
            } else {
                flag++;
                return 1 + depth(supRoot.getRight(), node, flag);
            }
        } else {
            if (supRoot.getLeft() == null) {
                return -(flag + 1);
            } else {
                flag++;
                return 1 + depth(supRoot.getLeft(), node, flag);
            }
        }
    }

    public int height(BNode<E> t) {
        if (t == null) return 0;
        int a = height(t.getLeft());
        int b = height(t.getRight());
        if (a > b) {
            return a + 1;
        } else return b + 1;
    }

    public int size(BNode<E> t) {
        if (t == null) return 0;
        if (t.getLeft() == null && t.getRight() == null) return 1;
        return size(t.getLeft()) + 1 + size(t.getRight());
    }

    public E findMin(BNode<E> t) {
        if (t == null) return null;
        if (t.getLeft() == null) return t.getData();
        else return findMin(t.getLeft());
    }

    public E findMax(BNode<E> t) {
        if (t == null) return null;
        if (t.getRight() == null) return t.getData();
        else return findMax(t.getRight());
    }

    public boolean remove(BNode<E> t, BNode<E> parent, E e) {
        if (t.getData().compareTo(e) == 0) {
            if (isLeaf(t)) {
                removeLeaf(t, parent);
                return true;
            } else {
                if (t.getLeft() == null) {
                    E temp = findMin(t.getRight());
                    t.setData(temp);
                    removeLeafVipPro(t, temp);
                } else if (t.getRight() == null) {
                    E temp = findMax(t.getLeft());
                    t.setData(temp);
                    removeLeafVipPro(t, temp);
                } else {
                    E temp = findMax(t.getLeft());
                    removeLeafVipPro(t, temp);
                    t.setData(temp);
                }
            }
            return true;
        }
        if (t.getData().compareTo(e) > 0) {
            remove(t.getLeft(), t, e);
        } else {
            remove(t.getRight(), t, e);
        }
        return true;
    }

    public BNode<E> findParent(BNode<E> tree, E e) {
        if (tree.getLeft().getData().compareTo(e) == 0 || tree.getRight().getData().compareTo(e) == 0) return tree;
        if (tree.getData().compareTo(e) == 0) return null;
        if (tree.getData().compareTo(e) < 0) {
            return findParent(tree.getRight(), e);
        } else return findParent(tree.getLeft(), e);
    }

    public BNode<E> findNode(BNode<E> tree, E e) {
        if (tree == null) return null;
        if (tree.getData().compareTo(e) == 0) return tree;
        if (tree.getData().compareTo(e) < 0) {
            return findNode(tree.getRight(), e);
        } else return findNode(tree.getLeft(), e);
    }

    public void removeLeafVipPro(BNode<E> tree, E e) {
        removeLeaf(findNode(tree, e), findParent(tree, e));
    }

    public void removeLeaf(BNode<E> leaf, BNode<E> parent) {
        if (parent.getLeft().getData().compareTo(leaf.getData()) == 0) {
            parent.setLeft(null);
        }
        if (parent.getRight().getData().compareTo(leaf.getData()) == 0) {
            parent.setRight(null);
        }
        leaf = null;
    }

    public boolean isLeaf(BNode<E> t) {
        return t.getLeft() == null && t.getRight() == null;
    }

    public void descendants(BNode<E> t, E data, List<E> list) {
        if (t.getData().compareTo(data) != 0) list.add(t.getData());
        if (t.getData().compareTo(data) > 0 && t.getLeft() != null && t.getLeft().getData().compareTo(data) != 0) {
            descendants(t.getLeft(), data, list);
        } else if (t.getData().compareTo(data) < 0 && t.getRight() != null && t.getRight().getData().compareTo(data) != 0) {
            descendants(t.getRight(), data, list);
        }
    }

    public void ancestors(BNode<E> t, List<E> list) {
        if (t != null) {
            if (t.getLeft() != null) list.add(t.getLeft().getData());
            ancestors(t.getLeft(), list);
            if (t.getRight() != null) list.add(t.getRight().getData());
            ancestors(t.getRight(), list);
        }
    }

    public void inorder(BNode<E> t) {
        if (t != null) {
            inorder(t.getLeft());
            System.out.print(t.getData() + " ");
            inorder(t.getRight());
        }
    }
    public void preorder(BNode<E> t) {
        if (t != null) {
            System.out.print(t.getData() + " ");
            preorder(t.getLeft());
            preorder(t.getRight());
        }
    }

    public void postorder(BNode<E> t) {
        if (t != null) {
            postorder(t.getLeft());
            postorder(t.getRight());
            System.out.print(t.getData() + " ");
        }
    }
    @Override
    public String toString() {
        return "BNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
