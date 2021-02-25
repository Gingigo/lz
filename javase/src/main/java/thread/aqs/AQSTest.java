package thread.aqs;

import sun.misc.Unsafe;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Leexiaobu
 * @date 2020-11-28 20:58:51
 */
public class AQSTest {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        reentrantLock.wait();
    }
}