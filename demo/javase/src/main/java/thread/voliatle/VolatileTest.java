package thread.voliatle;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Leexiaobu
 * @date 2020-11-29 14:28:11
 */
public class VolatileTest {
    static volatile int a = 0;
    static volatile boolean flag = true;
    static  void increase() {
        synchronized (VolatileTest.class){
            a++;
        }
//        a++;
    }
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        for (int i = 0; i < 10000; i++) {
            executor.execute(
                    () -> increase());
        }
        while (executor.getQueue().size() > 1) {
            Thread.yield();
        }
        System.out.println(a);

    }


}


