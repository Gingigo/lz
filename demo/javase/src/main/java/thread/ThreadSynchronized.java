package thread;

public class ThreadSynchronized implements Runnable {

    private static int n = 1;

    @Override
    synchronized  public  void run() {
            System.out.println(Thread.currentThread().getName() + ":" +n++ );
    }
}
