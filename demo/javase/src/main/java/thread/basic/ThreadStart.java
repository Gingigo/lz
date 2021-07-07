package thread.basic;

import java.util.concurrent.ConcurrentHashMap;

public class ThreadStart {

  public static void main(String[] args) throws InterruptedException {
    new ThreadSubClass("leexiaobu").start();
    new Thread(new ThreadImpl()).start();
    /*匿名*/
    new Thread(() -> System.out.println("匿名内部类")).start();
    System.out.println("主程序");

  }

 static class ThreadSubClass extends Thread {

    public ThreadSubClass(String name) {
      super(name);
    }

    @Override
    public void run() {
      System.out.println("继承Thread");
    }
  }

  static class ThreadImpl implements Runnable {

    @Override
    public void run() {
      System.out.println("实现RUNNABLE");
    }


  }
}
