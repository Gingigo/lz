package thread.communicate;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*多生产多消费*/
public class WaitTest3 {
    boolean all = true;
    boolean flag = false;
    String[] arrayAbc = {"A", "B", "C", "D", "E", "F"};
    int[] array123 = {1, 2, 3, 4, 5, 6};
    int i = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    void product() {
        lock.lock();
        try {
            while (all) {
                while (flag) {
                    condition.await();
                }
                flag = true;
                if (i <= 5) {
                    System.out.println(arrayAbc[i]);
                }
                condition.signalAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    void consumer() {
        lock.lock();
        try {
            while (all) {
                while (!flag) {
                    condition.await();
                }
                flag = false;
                System.out.println(array123[i]);
                i++;
                if (i == 5) {
                    all = false;
                }
                condition.signalAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void ma() {
        int i = 100;
        i = i++;
        System.out.println(i);
    }

    public static void main(String[] args) {
        WaitTest3 waitTest = new WaitTest3();
        new Thread(waitTest::consumer).start();
        new Thread(waitTest::product).start();
        new Thread(waitTest::consumer).start();
        new Thread(waitTest::product).start();
        new Thread(waitTest::consumer).start();
        new Thread(waitTest::product).start();
        new Thread(waitTest::consumer).start();
        new Thread(waitTest::product).start();

    }


}
