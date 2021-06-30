package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 写一个程序，证明AtomXXX类比synchronized更高效
 */
public class AtomicSync {

    public static AtomicInteger t = new AtomicInteger(0);

    public static void inc(){
        t.incrementAndGet();
    }

    public static int get(){
        return t.get();
    }


    public static int t1 = 0;

    public static synchronized  void inct(){
        t1++;
    }

    public  static int gett(){
        return t1;
    }


    public static void main(String[] args){
        CountDownLatch latch = new CountDownLatch(10);
        long startTime = System.currentTimeMillis();
        System.out.println("AtomThreads Start!");
        for(int i = 0;  i < 10;i ++){
            new Thread(()-> {
                while (AtomicSync.get() < 100000000){
                    AtomicSync.inc();
                }
                latch.countDown();
            }).start();
        }

        try{
            latch.await();
            long endTime = System.currentTimeMillis();
            System.out.println("AtomThreads End,count = " + AtomicSync.t.toString());
            System.out.println("Atom cost time:" + (endTime - startTime));
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        CountDownLatch latch2 = new CountDownLatch(10);
        startTime = System.currentTimeMillis();
        System.out.println("SyncThreads Start!");
        for(int i = 0;  i < 10;i ++){
            new Thread(()-> {
                while (AtomicSync.gett() < 100000000){
                    AtomicSync.inct();
                }
                latch2.countDown();
            }).start();
        }

        try{
            latch2.await();
            long endTime = System.currentTimeMillis();
            System.out.println("SyncThreads End,count = " + AtomicSync.t);
            System.out.println("Sync cost time:" + (endTime - startTime));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}

class AtomT {

    public static AtomicInteger t = new AtomicInteger(0);

    public static void inc(){
        t.incrementAndGet();
    }

    public static int get(){
        return t.get();
    }

}

class SyncT {

    public static int t = 0;

    public static synchronized  void inc(){
        t++;
    }

    public  static int get(){
        return t;
    }

}
