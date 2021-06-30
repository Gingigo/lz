package thread.test;

public class ThreadStopTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadTest thread = new ThreadTest();
        thread.start();
        Thread.sleep(500);
        System.out.println("false");
    }
}
