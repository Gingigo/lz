package thread;

import java.util.concurrent.CountDownLatch;

public class BreakTest {
    int i = 0;

    public static void main(String[] args) {
        BreakTest breakTest = new BreakTest();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        new Thread(() -> {
            if (breakTest.i != 5) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end");
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (breakTest) {
                    breakTest.i++;
                    countDownLatch.countDown();
                    System.out.println(breakTest.i);
/*                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }
            }
        }).start();
    }


}
