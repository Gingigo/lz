package datastructure.tree;

import java.util.Comparator;

public class RBTree<E> extends BinarySearchTree<E> {
    public static final boolean RED = false;
    public static final boolean BLACK = true;

    public RBTree() {
        super(null);
    }

    public RBTree(Comparator<E> comparator) {
        super(comparator);
    }


    private Node<E> color(Node<E> node, boolean color) {
        if (node == null) return node;
        ((RBNode<E>) node).color = color;
        return node;
    }

    private Node<E> red(Node<E> node) {
        return color(node, RED);
    }

    private Node<E> black(Node<E> node) {
        return color(node, BLACK);
    }

    private boolean colorOf(Node<E> node) {
        return node == null ? BLACK : ((RBNode<E>) node).color;
    }

    private boolean isBlack(Node<E> node) {
        return colorOf(node) == BLACK;
    }

    private static class RBNode<E> extends Node<E> {
        boolean color;

        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }
    }

}
