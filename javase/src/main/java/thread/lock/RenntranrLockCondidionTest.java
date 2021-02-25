package thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RenntranrLockCondidionTest {
    Lock lock = new ReentrantLock();



    void m1() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void m2() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    Lock locks = new ReentrantLock();
    Condition condition = locks.newCondition();

    void waitTest() {
        locks.lock();
        try {
            System.out.println("await");
            condition.await();
            System.out.println("await end");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            locks.unlock();
        }
    }


    void singleTest() {
        locks.lock();
        try {
            System.out.println("single");
            condition.signal();
            System.out.println("single end");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            locks.unlock();
        }
    }
    public static void main(String[] args) {
        RenntranrLockCondidionTest renntranrLockTest = new RenntranrLockCondidionTest();
        new Thread(renntranrLockTest::waitTest).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(renntranrLockTest::singleTest).start();
    }
}
