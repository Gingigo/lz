package thread.productandconsumer.communicate;


/*交替打印*/
public class WaitTest2 {
    boolean all = true;
    boolean flag = false;
    String[] arrayAbc = {"A", "B", "C", "D", "E", "F"};
    int[] array123 = {1, 2, 3, 4, 5, 6};
    int i = 0;

    synchronized void product() {
        while (all) {
            try {
                while (flag) {
//                    Thread.sleep(1000);
                    this.wait();
                }

                flag = true;
                if (i <= 5) {
                    System.out.println(arrayAbc[i]);
                }
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    synchronized void consumer() {
        while (all) {
            try {
                while (!flag) {
//                    Thread.sleep(1000);
                    this.wait();
                }
                flag = false;
                System.out.println(array123[i]);
                i++;
                if (i == 5) {
                    all = false;
                }
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        WaitTest2 waitTest = new WaitTest2();
        new Thread(waitTest::consumer).start();
        new Thread(waitTest::product).start();
    }

}
