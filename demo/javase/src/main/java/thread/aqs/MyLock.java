package thread.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author Leexiaobu
 * @date 2020-11-30 10:59:59
 */
public class MyLock {
    class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            //state
            // 0无线程持有锁，
            // 1有线程持有锁
            int c = getState();
            if (c == 0) {
                if (compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            } else {
                if (current == getExclusiveOwnerThread()) {
                    int next = c + acquires;
                    setState(next);
                    return true;
                }
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int acquires) {
            int c = getState() - acquires;
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new IllegalMonitorStateException();
            }
            boolean free = false;
            if (c == 0) {
                free = true;
                setExclusiveOwnerThread(null);
            }
            setState(c);
            return free;
        }

        public void showThread() {
            if (getExclusiveOwnerThread() != null) {
                System.out.println("Thread.currentThread():" + getExclusiveOwnerThread().getName());
            }
        }
    }

    Sync sync;

    MyLock() {
        sync = new Sync();
    }

    void lock() {
        sync.acquire(1);
    }

    void unlock() {
        sync.release(1);
    }

    void showLockThread() {
        sync.showThread();
    }


    public static void main(String[] args) throws InterruptedException {
        MyLock myLock = new MyLock();
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1 start");
                myLock.lock();
                System.out.println("t1 get ");
                Thread.sleep(5000);
                System.out.println("t1 return ");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                myLock.unlock();
            }
        });
        t1.setName("T1");
        Thread t2 = new Thread(() -> {
            try {
                System.out.println("t2 start");
                myLock.lock();
                System.out.println("t2 get ");
//                Thread.sleep(5000);
                System.out.println("t2 return ");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                myLock.unlock();
            }
        });
        t2.setName("T2");
        t1.start();
        t2.start();
        Thread.sleep(2000);
        myLock.showLockThread();
        t1.join();
        t2.join();
    }
}
