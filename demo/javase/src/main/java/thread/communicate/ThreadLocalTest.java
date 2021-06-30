package thread.communicate;

import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {

   static ThreadLocal threadLocal = new ThreadLocal();



    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            final  int temp = i;
            new Thread(()->{
                threadLocal.set(temp);
                System.out.println(Thread.currentThread().getId()+"-"+temp);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId()+"-"+threadLocal.get());
            }).start();
        }

    }
}
