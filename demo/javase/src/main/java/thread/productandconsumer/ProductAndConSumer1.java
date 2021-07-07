package thread.productandconsumer;

import java.util.LinkedList;

public class ProductAndConSumer1 {


  // 仓库容量
  private final int MAX_SIZE = 10;
  // 仓库存储的载体
  private LinkedList<Object> list = new LinkedList<>();
  //方法1 利用Synchronized +wait+ notifyAll 实现
  //注意while true

  public static void main(String[] args) {
    ProductAndConSumer1 object = new ProductAndConSumer1();

    new Thread(object::product).start();
    new Thread(object::product).start();
    new Thread(object::product).start();
    new Thread(object::product).start();
    new Thread(object::consumer).start();
//    new Thread(object::consumer).start();
    new Thread(object::consumer).start();
    new Thread(object::consumer).start();
  }

  public void product() {
    while (true){
      synchronized (this) {
        while (list.size() >= MAX_SIZE) {
          System.out.println("list 已满 生产者不在生产");
          try {
            this.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        list.add(new Object());
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread()+"list++ 添加一个对象,当前list 大小为 " + list.size());
        this.notifyAll();
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
  public void consumer(){
  while (true){
    synchronized (this) {
      while (list.size() == 0) {
        System.out.println("list 已空 消费者没有东西消费");
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      list.removeFirst();
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread()+"list-- 消费一个对象,当前list 大小为 " + list.size());
      this.notifyAll();
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  }

}
