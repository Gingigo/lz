package thread;

public class ThreadTestExtend extends Thread {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new ThreadTestExtend().start();
        }


    }

    @Override
    public void run() {
        int n = 0;
        while (n++ < 100) {
            System.out.println("EXTEND：" + Thread.currentThread().getName() + ":" + Thread.currentThread().getState() + ":" + n);

        }
    }


}
