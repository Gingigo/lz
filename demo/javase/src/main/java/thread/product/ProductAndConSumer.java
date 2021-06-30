package thread.product;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductAndConSumer {
    int count = 0;

    synchronized void product() {
        while (true) {
            try {
                while (count == 10) {
                    System.out.println("product: " + Thread.currentThread().getName() + " : is full " + count);
                    Thread.sleep(1000);
                    this.wait();
                }
                count++;
                System.out.println("product: " + Thread.currentThread().getName() + " :+1  " + count);
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void consumer() {
        while (true) {
            try {
                while (count == 0) {
                    System.out.println("consumer: " + Thread.currentThread().getName() + " : is empty" + count);
                    Thread.sleep(1000);
                    this.wait();
                }
                count--;
                System.out.println("consumer: " + Thread.currentThread().getName() + " :-1  " + count);
                Thread.sleep(1000);
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        ProductAndConSumer productAndConSumer = new ProductAndConSumer();
        new Thread(productAndConSumer::product).start();
        new Thread(productAndConSumer::product).start();
        new Thread(productAndConSumer::product).start();
        new Thread(productAndConSumer::consumer).start();
    }


    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    boolean flag = true;

    void productLock() {
        try {
            lock.lock();
            while (true) {
                while (flag) {
                    System.out.println("product");
                    condition.await();
                }
                flag = true;
                count++;
                Thread.sleep(1000);
                System.out.println("product LOCK: " + Thread.currentThread().getName() + " :+1  " + count);
                condition.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void consumerLock() {
        try {
            lock.lock();
            while (true) {
                while (!flag) {
                    System.out.println("consumer");
                    condition.await();
                }
                flag = false;
                count--;
                Thread.sleep(1000);
                System.out.println("consumer LOCK: " + Thread.currentThread().getName() + " :-1  " + count);
                condition.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
