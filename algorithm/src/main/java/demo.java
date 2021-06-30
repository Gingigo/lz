/**
 * @author Leexiaobu
 * @date 2021-06-15 19:01
 */
public class demo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new TestClass(null),"A");
        Thread t2 = new Thread(new TestClass(t1),"B");
        Thread t3 = new Thread(new TestClass(t2),"C");
        t1.start();
        t3.start();
        t2.start();
    }
    static class TestClass implements Runnable{
      private Thread beforeThread;
      public TestClass(Thread beforeThread) {
        this.beforeThread = beforeThread;
      }
      @Override
      public void run() {
        if(beforeThread!=null) {
          try {
            beforeThread.join();
            System.out.print(Thread.currentThread().getName());
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }else {
          System.out.print(Thread.currentThread().getName());
        }
      }
    }
  }
