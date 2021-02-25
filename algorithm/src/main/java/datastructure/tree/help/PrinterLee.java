package datastructure.tree.help;
import datastructure.tree.printer.BinaryTrees;
import datastructure.tree.BinarySearchTree;

public class PrinterLee {


    public static void main(String[] args) {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 1, 15, 13, 22, 0};
        BinarySearchTree<Integer> objectBinarySearchTree = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            objectBinarySearchTree.add(data[i]);
        }
        BinaryTrees.print(objectBinarySearchTree);
        System.out.println();

        BinarySearchTree<Integer> printerLee = new BinarySearchTree<>();

        System.out.println(" /*前序遍历 递归*/");
        printerLee.preorderTraversal(objectBinarySearchTree.getRoot());
        System.out.println();


        System.out.println(" /*前序遍历非递归*/");
        printerLee.IpreorderTraversal(objectBinarySearchTree.getRoot());
        System.out.println();


        System.out.println("/*中序遍历 递归*/");
        printerLee.inOrderTraversal(objectBinarySearchTree.getRoot());
        System.out.println();

        System.out.println("/*中序非递归*/");
        printerLee.IinOrderTraversal(objectBinarySearchTree.getRoot());
        System.out.println();

        System.out.println("/*后序递归*/");
        printerLee.postOrderTraversal(objectBinarySearchTree.getRoot());
        System.out.println();


        System.out.println("/*后序非递归*/");
        printerLee.IpostOrderTraversal(objectBinarySearchTree.getRoot());
        System.out.println();


        System.out.println("/*层次递归*/");
        printerLee.levelOrderTraversal(objectBinarySearchTree.getRoot());
        System.out.println();

    }


}
