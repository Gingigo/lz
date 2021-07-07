package thread.juc.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Leexiaobu
 * @date 2020-11-28 20:58:51
 */
public class AQSTest {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        reentrantLock.wait();
    }
}
