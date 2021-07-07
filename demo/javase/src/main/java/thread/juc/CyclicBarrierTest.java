package thread.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Leexiaobu
 * @date 2021-07-05 13:46
 */
public class CyclicBarrierTest {

  CyclicBarrier cyclicBarrier = new CyclicBarrier(5,
      () -> System.out.println(Thread.currentThread()+"----------"));

  public static void main(String[] args) {
    CyclicBarrierTest test = new CyclicBarrierTest();
    new Thread(test::method).start();
    new Thread(test::method).start();
    new Thread(test::method).start();
    new Thread(test::method).start();
    new Thread(test::method).start();
    new Thread(test::method).start();
  }

  public  void method() {

    System.out.println(Thread.currentThread()+" 执行方法");
    System.out.println(cyclicBarrier.getParties()+"  "+cyclicBarrier.getNumberWaiting());
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(Thread.currentThread()+" 等待其他方法");
    try {
      cyclicBarrier.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (BrokenBarrierException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread()+" 回调方法");

  }
}