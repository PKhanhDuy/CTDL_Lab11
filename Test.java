package lab11;

public class Test {
    public static void main(String[] args) {
        BNode<Integer> root = new BNode<>(25);
        BNode<Integer> node1 = new BNode<>(15);
        BNode<Integer> node2 = new BNode<>(50);
        BNode<Integer> node3 = new BNode<>(10);
        BNode<Integer> node4 = new BNode<>(22);
        BNode<Integer> node5 = new BNode<>(35);
        BNode<Integer> node6 = new BNode<>(70);
        BNode<Integer> node7 = new BNode<>(4);
        BNode<Integer> node8 = new BNode<>(12);
        BNode<Integer> node9 = new BNode<>(18);
        BNode<Integer> node10 = new BNode<>(24);
        BNode<Integer> node11 = new BNode<>(31);
        BNode<Integer> node12 = new BNode<>(44);
        BNode<Integer> node13 = new BNode<>(66);
        BNode<Integer> node14 = new BNode<>(90);

        root.setLeft(node1);root.setRight(node2);
        node1.setLeft(node3);node1.setRight(node4);
        node2.setLeft(node5);node2.setRight(node6);
        node3.setLeft(node7);node3.setRight(node8);
        node4.setLeft(node9);node4.setRight(node10);
        node5.setLeft(node11);node5.setRight(node12);
        node6.setLeft(node13);node6.setRight(node14);


        BNode<Integer> root2 = new BNode<>(15);
        BNode<Integer> node16 = new BNode<>(10);
        BNode<Integer> node17 = new BNode<>(22);
        BNode<Integer> node18 = new BNode<>(2);
        BNode<Integer> node19 = new BNode<>(12);
        BNode<Integer> node20 = new BNode<>(18);
        BNode<Integer> node21 = new BNode<>(24);
        root2.setLeft(node16);root2.setRight(node17);
        node16.setLeft(node18);node16.setRight(node19);
        node17.setLeft(node20);node17.setRight(node21);


        BST<Integer> bst = new BST<>();
        bst.addRoot(root);
        bst.add(32);
//        System.out.println(bst.depth(15));
//        System.out.println(bst.depth(3));
//        System.out.println(bst.height());
//        System.out.println(bst.size());
//        System.out.println(bst.contains(32));
//        System.out.println(bst.findMin());
//        System.out.println(bst.findMax());
//        System.out.println(bst.descendants(4).toString());
//        System.out.println(bst.ancestors(4).toString());
//        bst.inorder();
//        System.out.println();
//        bst.preorder();
//        System.out.println();
//        bst.postorder();


        BST<Integer> tree = new BST<>();
        tree.addRoot(root2);
//        System.out.println(tree.depth(15));
//        System.out.println(tree.height());
//        System.out.println(tree.size());
//        System.out.println(tree.contains(422));
//        System.out.println(tree.findMin());
//        System.out.println(tree.findMax());
//        tree.remove(12);
//        System.out.println(tree.remove(10));
//        System.out.println(tree.findParent(root2, 15));
//        System.out.println(tree.descendants(15).toString());
//        tree.inorder();
    }
}
