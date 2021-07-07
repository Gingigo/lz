package thread.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Semaphore;

/**
 * @author Leexiaobu
 * @date 2021-07-05 13:46
 */
public class SemaphoreTest {

  Semaphore semaphore = new Semaphore(3);

  public static void main(String[] args) {
    SemaphoreTest test = new SemaphoreTest();
    new Thread(test::method).start();
    new Thread(test::method).start();
    new Thread(test::method).start();
    new Thread(test::method).start();
    new Thread(test::method).start();
    new Thread(test::method).start();
  }

  public  void method() {

    System.out.println(Thread.currentThread() + " 进入");
    try {
      semaphore.acquire();
      System.out.println(Thread.currentThread() + " =========");
      Thread.sleep(100);
      semaphore.release();
      System.out.println(Thread.currentThread() + " =====结束====");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}