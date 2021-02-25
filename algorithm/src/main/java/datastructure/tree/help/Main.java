package datastructure.tree.help;

import datastructure.tree.BinarySearchTree;
import datastructure.tree.printer.BinaryTrees;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3
        };
        BinarySearchTree<Integer> objectBinarySearchTree = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            objectBinarySearchTree.add(data[i]);
        }

//        BinaryTrees.print(objectBinarySearchTree);



        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        };
        Comparator<Person> comparator1 = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.age - o1.age;
            }
        };
        Person person1 = new Person(1);
        Person person2 = new Person(3);
        Person person3 = new Person(10);
        Person person4 = new Person(2);
        Person person5 = new Person(15);
        Person person6 = new Person(11);
        /*手写比较器*/
        BinarySearchTree<Person> objectBinarySearchTree2 = new BinarySearchTree<>(comparator);



        /*默认比较器 需要在Person里实现比较接口*/
        BinarySearchTree<Person> binarySearchTree = new BinarySearchTree<>();
        /*匿名内部类*/
        BinarySearchTree<Person> objectBinarySearchTree1 = new BinarySearchTree<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.age - o1.age;
            }
        });
        /*lambda 写法1  */
        BinarySearchTree<Person> binarySearchTree4 = new BinarySearchTree<>((o1, o2) -> o1.age - o2.age);
        /*lambda 写法2  */

        BinarySearchTree<Person> binarySearchTree3 = new BinarySearchTree<>(Comparator.comparingInt(o -> o.age));


        objectBinarySearchTree1.add(person1);
        objectBinarySearchTree1.add(person2);
        objectBinarySearchTree1.add(person3);
        objectBinarySearchTree1.add(person4);
        objectBinarySearchTree1.add(person5);
        objectBinarySearchTree1.add(person6);

        BinaryTrees.print(objectBinarySearchTree1);

    }
}
