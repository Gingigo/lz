package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _2ReentantLock {
    Lock lock = new ReentrantLock();

    void m1() {
        lock.lock();
        try {
            System.out.println("m1lock");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void m2() {
        lock.lock();
//        lock.lockInterruptibly();
        try {
            System.out.println("m2lock");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        _2ReentantLock reentantLock = new _2ReentantLock();
        new Thread(reentantLock::m1).start();
        new Thread(reentantLock::m2).start();

    }
}
