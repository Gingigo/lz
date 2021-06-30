package thread.test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest2 extends Thread {
    AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        test();
    }

    private void test() {
        for (int i = 0; i < 10; i++) {
            atomicInteger.incrementAndGet();
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i <3 ; i++) {
            ThreadTest2 threadTest2 = new ThreadTest2();
            threadTest2.start();
        }
    }
}
