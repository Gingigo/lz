package thread;

public class InterruptedTest {
    public static void main(String[] args) {
        Thread test = new Thread(() -> {
            try {
                for (int i = 0; i < 10000; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedException();
                    } else {
                        System.out.println(i);
                    }
                }
                System.out.println("++++end+++");
            } catch (InterruptedException e) {
                System.out.println("打断 提前退出");
                e.printStackTrace();
            }

        });

        test.suspend();
        test.resume();
        test.start();
        System.out.println( test.isInterrupted());
        System.out.println( test.isInterrupted());
        System.out.println( test.isInterrupted());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始打断");
        System.out.println( test.isInterrupted());
        System.out.println();
        test.interrupt();
        System.out.println( test.isInterrupted());
        test.interrupt();


    }


}
