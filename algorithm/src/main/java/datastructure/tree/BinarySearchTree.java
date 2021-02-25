package datastructure.tree;
import datastructure.tree.printer.BinaryTreeInfo;
import datastructure.tree.printer.BinaryTrees;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<E> implements BinaryTreeInfo {
    private int size;
    /*思考为什么需要根节点*/
    private Node<E> root;

    public Node<E> getRoot() {
        return root;
    }

    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public static class Node<E> {
        E element;
        Node<E> right;
        Node<E> left;
        Node<E> parent;

        //        int value;
        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

    }

    public void add(E e) {
        elementNotNullCheck(e);
        //添加的是第一个节点
        if (root == null) {
            root = new Node<>(e, null);
            size++;
            afterAdd(root);
            return;
        }


        // 添加的不是第一个节点
        Node<E> parent = null;
        Node<E> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(e, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else if (cmp == 0) {
                node.element = e;
                return;
            }
        }
        Node<E> newNode = new Node<>(e, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
        afterAdd(newNode);
    }

    protected void afterAdd(Node<E> node) {

    }

    protected void afterRemove(Node<E> node) {

    }

    /*
     *0 相等
     * 1 e1>e2
     * -1 e1<e2
     * */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void remove(Node<E> node) {
        afterRemove(node);
    }


    public boolean contains(E e) {
        return false;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element can't be null");
        }
    }

    /**
     * who is the root node
     */
    @Override
    public Object root() {
        return root;
    }

    /**
     * how to get the left child of the node
     *
     * @param node
     */
    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    /**
     * how to get the right child of the node
     *
     * @param node
     */
    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    /**
     * how to print the node
     *
     * @param node
     */
    @Override
    public Object string(Object node) {
        return ((Node<E>) node).element.toString();
    }

    /*前序遍历 递归*/
    public void preorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(" " + node.element);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    /*前序遍历非递归*/
    public void IpreorderTraversal(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.print(" " + node.element);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
    }


    /*中序遍历 递归*/
    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(" " + node.element);
            inOrderTraversal(node.right);
        }

    }

    /*中序非递归*/
    public void IinOrderTraversal(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.print(" " + node.element);
            node = node.right;


        }

    }

    /*后序遍历 递归*/
    public void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(" " + node.element);

    }

    /*后序非递归*/
    public void IpostOrderTraversal(Node node) {
        Stack<Node> stack = new Stack<>();
        Node temp = null;
        Node cur = node;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == temp) {
                System.out.print(" " + cur.element);
                temp = cur;
                stack.pop();
                cur = null;
            } else {
                cur = cur.right;
            }

        }
    }

    /*层次遍历非递归*/
    public void levelOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(" " + node.element);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /*重要 访问者模式
     *
     * 返回true 停止*/
    public static abstract class Visitor<E> {
        /*用来判断停止*/
        boolean stop;

        abstract boolean visit(E e);
    }

    /*访问者模式 前序遍历*/
    public void preTraversal(Visitor<E> visitor) {
        if (visitor == null) return;
//        preTraversal(root, visitor);
        preTraversal2(root, visitor);
    }

    public void preTraversal(Node<E> node, Visitor<E> visitor) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                /*这么写法只适合 迭代*/
                boolean visit = visitor.visit(node.element);
                if (visit) {
                    return;
                }

                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
    }

    public void preTraversal2(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) {
            return;
        }
        /*适合递归的方法*/
        visitor.stop = visitor.visit(node.element);
        if (visitor.stop) return;
        preTraversal2(node.left, visitor);
        preTraversal2(node.right, visitor);
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        toString(root, stringBuilder, "");
        return stringBuilder.toString();
    }

    private void toString(Node<E> node, StringBuilder sb, String prefix) {
        if (node == null) return;
        toString(node.left, sb, prefix + "L--");
        sb.append(prefix).append(node.element).append("\n");
        toString(node.right, sb, prefix + "R--");
    }

    /*获取高度*/
    public int height() {
        return height2(root);
    }

    public int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /*迭代写法*/
    public int height2(Node<E> node) {
        Queue<Node> queue = new LinkedList<>();
        int height = 0;
        if (node == null) {
            return height;
        }
        queue.add(node);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);

                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            height++;

        }
        return height;
    }

    public boolean isFullBinaryTree() {
        return isFullBinaryTree(root);
    }

    /*是否完全二叉树*/
    public boolean isFullBinaryTree(Node<E> node) {
        Queue<Node> queue = new LinkedList<>();
        if (node == null) {
            return false;
        }
        int height = 0;
        boolean leaf = false;
        queue.add(node);
        while (!queue.isEmpty()) {
            Node<E> eNode = queue.poll();
            if (!isLeaf(eNode) && leaf) {
                return false;
            }
            if (eNode.left != null && eNode.right != null) {
                queue.add(eNode.left);
                queue.add(eNode.right);
            } else if (hasTwoChildren(eNode)) {
                return false;
            } else {
                leaf = true;
                if (eNode.left != null) {
                    queue.add(eNode.left);
                }
            }

        }
        return true;
    }

    private boolean isLeaf(Node<E> eNode) {
        return eNode.left == null && eNode.right == null;
    }

    private boolean hasTwoChildren(Node<E> node) {
        return node.left != null && node.right != null;
    }

    public boolean isLeftChild(Node<E> node) {
        return node.parent != null && node == node.parent.left;
    }

    public boolean isRightChild(Node<E> node) {
        return node.parent != null && node == node.parent.right;
    }

    public Node<E> sibling(Node<E> node) {
        if (isLeftChild(node)) {
            return node.parent.right;
        }
        if (isRightChild(node)) {
            return node.parent.left;
        }
        return null;
    }


    /*翻转二叉树前序遍历递归法  本质时遍历二叉树*/
    public Node<E> invertBinaryTree(Node<E> node) {
        if (node == null) return node;
        Node<E> tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        invertBinaryTree(node.left);
        invertBinaryTree(node.right);
        return node;
    }

    public Node<E> invertBinaryTreeLDR(Node<E> node) {
        if (node == null) return node;
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            Node<E> tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            /*这一步很关键,区分左右*/
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 1, 12, 33, 23, 25};
        BinarySearchTree<Integer> objectBinarySearchTree = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            objectBinarySearchTree.add(data[i]);
        }
        BinaryTrees.print(objectBinarySearchTree);
        System.out.println();

        BinarySearchTree<Integer> printerLee = new BinarySearchTree<>();
//
//        System.out.println(" /*前序遍历 递归*/");
//        printerLee.preorderTraversal(objectBinarySearchTree.getRoot());
//        System.out.println();
//
//
//        System.out.println(" /*前序遍历非递归*/");
//        printerLee.IpreorderTraversal(objectBinarySearchTree.getRoot());
//        System.out.println();
//
//
//        System.out.println("/*中序遍历 递归*/");
//        printerLee.inOrderTraversal(objectBinarySearchTree.getRoot());
//        System.out.println();
//
//        System.out.println("/*中序非递归*/");
//        printerLee.IinOrderTraversal(objectBinarySearchTree.getRoot());
//        System.out.println();
//
//        System.out.println("/*后序递归*/");
//        printerLee.postOrderTraversal(objectBinarySearchTree.getRoot());
//        System.out.println();
//
//
//        System.out.println("/*后序非递归*/");
//        printerLee.IpostOrderTraversal(objectBinarySearchTree.getRoot());
//        System.out.println();
//
//
//        System.out.println("/*层次递归*/");
//        printerLee.levelOrderTraversal(objectBinarySearchTree.getRoot());
//        System.out.println();

//        objectBinarySearchTree.preTraversal(new Visitor<Integer>() {
//            @Override
//            public boolean visit(Integer integer) {
//                System.out.print(integer + " ");
//                return integer == 2;
//            }
//        });


//        System.out.println(objectBinarySearchTree.toString());

//        System.out.println(objectBinarySearchTree.height());
//        System.out.println(objectBinarySearchTree.isFullBinaryTree());


//        objectBinarySearchTree.invertBinaryTree(objectBinarySearchTree.root);
//        BinaryTrees.print(objectBinarySearchTree);
//        System.out.println();
//        objectBinarySearchTree.invertBinaryTreeLDR(objectBinarySearchTree.root);
//        BinaryTrees.print(objectBinarySearchTree);
    }

}
