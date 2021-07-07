package thread.deadlock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Leexiaobu
 * @date 2021-07-05 14:04
 */
public class Example1 {

  CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

  public static void main(String[] args) {
    Example1 example1 = new Example1();
    new Thread(example1::method).start();
    new Thread(example1::method).start();
    new Thread(example1::method).start();
  }

  public synchronized void method() {
    System.out.println(Thread.currentThread() + " 获得锁 ");
    try {
      cyclicBarrier.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (BrokenBarrierException e) {
      e.printStackTrace();
    }

  }

}