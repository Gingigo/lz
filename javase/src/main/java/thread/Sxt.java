package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Sxt {
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    static int a = 0;

    public static int getAtomicInteger() {
        return atomicInteger.get();
    }

    public static int getInt() {
        return a;
    }

    public synchronized void m1() {
        for (int i = 0; i < 100000000; i++) {
            atomicInteger.incrementAndGet();
//            System.out.println(Thread.currentThread().getName() + "    " + atomicInteger.get());
        }


    }

    public /*synchronized*/ void m2() {
        for (int i = 0; i < 1000; i++) {
            atomicInteger.incrementAndGet();
            System.out.println(Thread.currentThread().getName() + "    " + atomicInteger.get());
        }
    }

    public synchronized void m3() {
        for (int i = 0; i < 100000000; i++) {
            a++;
//            System.out.println(a);
        }
    }

    /*
        AtomicBoolean aBoolean = new AtomicBoolean(true);*/
//    volatile boolean aBoolean = true;
    AtomicBoolean aBoolean = new AtomicBoolean(true);

    public synchronized void m4() {
        while (aBoolean.get()) {
//            System.out.println(Thread.currentThread().getName());
           /* try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println("end");
    }


    int anInt = 0;

    public synchronized void m5() {
        while (anInt < 100000000) {
            anInt++;
        }
        countDownLatch.countDown();
    }

    public void m6() {
        while (anInt < 100000000) {
            anInt++;
        }
        countDownLatch.countDown();
    }
   CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) {
        Sxt sxt = new Sxt();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Thread(sxt::m6).start();
        }
        try {
            sxt.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long l1 = System.currentTimeMillis();
        System.out.println(sxt.anInt);
        System.out.println(l1-l);


/*        new Thread(sxt::m1).start();
        new Thread(sxt::m2).start();*/
    }
}
