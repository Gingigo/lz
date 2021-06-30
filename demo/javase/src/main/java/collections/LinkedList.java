package collections;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Leexiaobu
 * @date 2020-10-22 17:45:27
 */
public class
LinkedList {
    public static void main(String[] args) {
        test();
    }
     static void test() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        ArrayList<Integer> listNew = new ArrayList<>();
        for (int i = 100; i < 200; i++) {
            listNew.add(i);
        }
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
         System.out.println();
        listNew.addAll(list);
         for (Integer integer : listNew) {
             System.out.print(integer+" ");
         }

    }
}
