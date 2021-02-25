package thread;

import lombok.Data;

@Data
public class ThreadTestRunable implements Runnable {
    public static void main(String[] args) {
        ThreadTestRunable threadTestRunable = new ThreadTestRunable();

    }


    @Override
    public void run() {
        int n = 0;
        while (n++ < 100) {
            System.out.println("++Runnable：" + Thread.currentThread().getName() + ":" + Thread.currentThread().getState() + ":" + n);
            if (n == 30) {
                System.out.println("=======END======");
                return;
            }
        }
    }
}
