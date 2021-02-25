package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {


   static CountDownLatch countDownLatch = new CountDownLatch(5);

   static CyclicBarrier cyclicBarrier= new CyclicBarrier(3);

   static  Semaphore semaphore =new Semaphore(2);


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final  int temp =i;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();
                System.out.println(Thread.currentThread().getId()+"=="+temp);
           }).start();
        }

    }

}
