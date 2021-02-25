package thread;

import java.util.concurrent.*;

public class ThreadPoolTest implements ThreadFactory {


    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
//        不建议使用Exectors 创建
//         new ThreadPoolExecutor(5, 30,
//                60L, TimeUnit.SECONDS,
//                new SynchronousQueue<Runnable>());
//     SynchronousQueue h
        ExecutorService executorService = Executors.newCachedThreadPool();
//        LinkedBlockingQueue

//        new ThreadPoolExecutor(nThreads, nThreads,
//                                      0L, TimeUnit.MILLISECONDS,
//                                      new LinkedBlockingQueue<Runnable>());
//      LinkedBlockingQueue
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);

//      new DelayedWorkQueue()
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//      new LinkedBlockingQueue<Runnable>()
        Executors.newSingleThreadExecutor();

        Callable<Object> callable = new Callable<Object>() {
            /**
             * Computes a result, or throws an exception if unable to do so.
             *
             * @return computed result
             * @throws Exception if unable to compute a result
             */
            @Override
            public Object call() throws Exception {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("start...");
                return "leexiaobu";
            }
        };
        Future<Object> submit = executorService.submit(callable);
        try{
            Object o = submit.get(1,TimeUnit.SECONDS);
            System.out.println(o);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("wait");
        executorService.awaitTermination(2,TimeUnit.SECONDS);
        System.out.println("end");
        executorService.shutdownNow();
    }

    /**
     * Constructs a new {@code Thread}.  Implementations may also initialize
     * priority, name, daemon status, {@code ThreadGroup}, etc.
     *
     * @param r a runnable to be executed by new thread instance
     * @return constructed thread, or {@code null} if the request to
     * create a thread is rejected
     */
    @Override
    public Thread newThread(Runnable r) {
        return null;
    }
}

