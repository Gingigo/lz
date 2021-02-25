package thread.communicate;

public class JoinTest {

    void m1() {
        System.out.println("begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }

    void m2() {

    }

    public static void main(String[] args) {
        JoinTest joinTest = new JoinTest();
        Thread thread = new Thread(joinTest::m1);
        try {
            thread.start();
            thread.join(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main end");
    }
}
