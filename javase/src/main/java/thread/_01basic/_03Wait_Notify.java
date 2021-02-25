package thread._01basic;

/**
 * @author Leexiaobu
 * @date 2020-09-29 16:41:07
 */
public class _03Wait_Notify {

    public static void main(String[] args) throws InterruptedException {
        _03Wait_Notify test = new _03Wait_Notify();

        new Thread(test::doSomething).start();
        new Thread(test::notifyTest).start();
        Thread.sleep(100);
//        test.notifyAll();
        System.out.println("end");
    }

    synchronized void doSomething() {
        try {
            System.out.println(Thread.currentThread().getId());
            wait();
            System.out.println(Thread.currentThread().getId() + "end");
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    synchronized void notifyTest() {
        System.out.println(Thread.currentThread().getId()+" notify ");
        notify();
        System.out.println(Thread.currentThread().getId() + " notify end");

    }
}

