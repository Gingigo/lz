package thread.productandconsumer;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductAndConSumer3 {


  // 仓库容量
  private final int MAX_SIZE = 10;
  //方法1
  //注意while true
  Lock lock = new ReentrantLock();
  Condition condition = lock.newCondition();
  Semaphore semaphore = new Semaphore(5);
  // 仓库存储的载体
  private int count;

  //方法1的改写版 利用ReentrantLock +await +singleAll 实现
  //注意 结尾的singleAll和await
  public static void main(String[] args) {
    ProductAndConSumer3 object = new ProductAndConSumer3();
    new Thread(object::product).start();
    new Thread(object::product).start();
    new Thread(object::product).start();
    new Thread(object::product).start();
    new Thread(object::consumer).start();
    new Thread(object::consumer).start();
    new Thread(object::consumer).start();
    new Thread(object::consumer).start();
  }

  public void product() {
    while (true) {
      lock.lock();
      while (count == MAX_SIZE) {
        System.out.println("list 已满 生产者不在生产");
        try {
          condition.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      count++;
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread() + "list 添加一个对象,当前list 大小为 " + count);
      condition.signalAll();
      try {
        condition.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      lock.unlock();
    }
  }

  public void consumer() {
    while (true) {
      lock.lock();
      while (count == 0) {
        System.out.println("list 已空 消费者没有东西消费");
        try {
          condition.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      count--;
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread() + "list 消费一个对象,当前list 大小为 " + count);
      condition.signalAll();
      try {
        condition.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      lock.unlock();
    }
  }

}
