package thread.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author Leexiaobu
 * @date 2021-07-05 13:46
 */
public class CountDownLatchTest {

  CountDownLatch countDownLatch = new CountDownLatch(5);


  public static void main(String[] args) {
    CountDownLatchTest test = new CountDownLatchTest();
    new Thread(test::method).start();
    new Thread(test::method).start();
    new Thread(test::method).start();
    new Thread(test::method).start();
    new Thread(test::method).start();
    new Thread(test::method).start();
    try {
      test.countDownLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread()+" 主函数执行方法");
  }

    //不带Synchronized 保持method 总体和Main同步互斥
    //带Synchronized 保持method互斥
  public synchronized void method() {
    System.out.println(Thread.currentThread() + " 执行方法");
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    countDownLatch.countDown();
    System.out.println(Thread.currentThread() + " --"+countDownLatch.getCount());
  }
}