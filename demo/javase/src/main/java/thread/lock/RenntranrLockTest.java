package thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RenntranrLockTest {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Condition condition2 = lock.newCondition();

    public static void main(String[] args) {
        RenntranrLockTest renntranrLockTest = new RenntranrLockTest();
        new Thread(() -> {
            renntranrLockTest.m1();
        }).start();
        new Thread(() -> {
            renntranrLockTest.m3();
        }).start();
        new Thread(() -> {
            renntranrLockTest.m2();
        }).start();
    }


    void m1() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            System.out.println("awit");
            condition.await();
            System.out.println(Thread.currentThread().getName());
            System.out.println("re start");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void m3() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            System.out.println("awit");
            condition2.await(1, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName());
            System.out.println("re start");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    void m2() {
        lock.lock();
        try {
            Thread.sleep(1000);
            condition.signal();
            Thread.sleep(1000);
            condition2.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
