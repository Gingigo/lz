package thread.threadpoolexecute;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Leexiaobu
 * @date 2020-11-16 12:48:22
 */
public class ThreadPoolExecute {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println(
                    "线程池中线程数目：" + executor.getPoolSize()
                            + "，队列中等待执行的任务数目：" + executor.getQueue().size()
                            + "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}

class MyTask implements Runnable {
    int num;

    public MyTask(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task " + num);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        System.out.println("task " + num + "执行完毕");

    }
}