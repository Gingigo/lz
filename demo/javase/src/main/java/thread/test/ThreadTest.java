package thread.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadTest extends Thread {
    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(10);
                System.out.println("do something");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("new Thread 1 end");
    }

    public volatile boolean flag = true;

    void executor() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        ExecutorService pool1 = Executors.newCachedThreadPool();
        ExecutorService pool2 = Executors.newScheduledThreadPool(10);
        ExecutorService pool3 = Executors.newSingleThreadExecutor();
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Callable c = new ThreadCallTest(i + " call ");
            Future f = pool.submit(c);
            list.add(f);
        }
        pool.shutdown();
        for (Future f : list) {
            System.out.println(f.get());
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new ThreadTest().start();
        new Thread(new ThreadTestImpl()).start();
        System.out.println(new ThreadCallTest("leexiaobu").call());
        new ThreadTest().executor();
    }
}
