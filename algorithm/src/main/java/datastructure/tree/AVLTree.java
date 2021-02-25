package datastructure.tree;

import java.util.Comparator;

public class AVLTree<E> extends BinarySearchTree<E> {

    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }

    public AVLTree() {
        super(null);
    }

    @Override
    public void afterAdd(Node<E> node) {

    }

    private static class AVLNode<E> extends Node<E> {

        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }
    }
}
