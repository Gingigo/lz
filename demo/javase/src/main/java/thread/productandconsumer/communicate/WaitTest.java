package thread.productandconsumer.communicate;



/*多生产多消费*/
public class WaitTest {

    int anInt = 0;

    synchronized void product() {
        while (true) {

            try {
                while (anInt >=5) {
                    Thread.sleep(100);
                    this.wait();
                }
                anInt++;
                System.out.println(Thread.currentThread().getName()+"  product  "+ anInt);
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    synchronized void product1() {
        while (true) {

            try {
                while (anInt == 5) {
                    Thread.sleep(100);
                    this.wait();
                }
                anInt++;
                System.out.println(Thread.currentThread().getName()+"  product  "+ anInt);
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void consumer() {
        while (true){
            try {
                while (anInt == 0) {
                    Thread.sleep(100);
                    this.wait();
                }
                anInt--;

                System.out.println(Thread.currentThread().getName()+"  consumer  "+ anInt);

                this.notifyAll();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    synchronized void consumer2() {
        while (true){
            try {
                while (anInt == 0) {
                    Thread.sleep(100);
                    this.wait();
                }
                anInt--;
                System.out.println(Thread.currentThread().getName()+"  consumer  "+ anInt);
                this.notifyAll();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        WaitTest waitTest = new WaitTest();
        new Thread(waitTest::consumer).start();
        new Thread(waitTest::product).start();
        new Thread(waitTest::consumer2).start();
        new Thread(waitTest::product1).start();


    }

}
