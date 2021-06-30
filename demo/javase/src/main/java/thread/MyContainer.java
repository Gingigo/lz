package thread;

import java.util.LinkedList;

public class MyContainer<T> {
    private final int MAX = 10;
    private int count = 0;
    private LinkedList<T> list = new LinkedList<>();

    synchronized public void put(T t) {
        while (this.count == MAX) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        ++count;
        notifyAll();
    }

    synchronized public T get() {
        while (this.count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = list.removeFirst();
        --count;
        notifyAll();
        return t;
    }

}
