package thread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Leexiaobu
 * @date 2021-07-05 15:55
 */
public class LockDemo {

  public static void main(String[] args) {
    LockDemo lockDemo = new LockDemo();
    new Thread(lockDemo::method).start();
    new Thread(lockDemo::method).start();
    new Thread(lockDemo::method).start();
    new Thread(lockDemo::method).start();
    new Thread(lockDemo::method).start();
    new Thread(lockDemo::method).start();
    new Thread(lockDemo::methodB).start();
    ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
    map.get(123);
    map.put(123,123);

  }

  synchronized void method() {
    System.out.println(Thread.currentThread() + " methodA");
    try {
      this.wait();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread() + " methodA  END");
  }

  synchronized void methodB() {
    this.notify();
  }


}