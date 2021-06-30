package thread;

public class ThreadTestInterrupt implements Runnable {

    public static void main(String[] args) {
        ThreadTestInterrupt threadTestInterrupt = new ThreadTestInterrupt();
        Thread thread = new Thread(threadTestInterrupt);
        thread.start();
//        System.out.println(thread.isInterrupted());
      /*  try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        thread.interrupt();

        System.out.println(thread.isInterrupted());
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("exit");
                break;
            }
            System.out.println(i);
        }
    }
}
