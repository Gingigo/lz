package thread;

public class VolatileTest {

    boolean flag = true;

    void m1() {
        System.out.println("start");

        String ss = new String();
        while (flag) {
          /*  System.out.println("111");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
//            synchronized (ss) {
//
//            }

        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        new Thread(() -> {
            volatileTest.m1();

        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        volatileTest.flag = false;
        System.out.println("已更改");
    }
}
