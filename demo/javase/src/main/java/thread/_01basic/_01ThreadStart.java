package thread._01basic;

public class _01ThreadStart {


    public static void main(String[] args) throws InterruptedException {
        new ThreadSubClass("leexiaobu").start();
        new Thread(new ThreadImpl()).start();
        /*匿名*/
        new Thread(() -> System.out.println("1")).start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main");
            Thread.sleep(10);
        }
    }

}

 class ThreadSubClass extends Thread {

    public ThreadSubClass(String name) {
        super(name);
    }
    @Override
    public void run() {
            System.out.println("SubClass");
    }
}
class ThreadSubClassLong extends Thread {

    public ThreadSubClassLong(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.print(i);
        }
    }
}
class ThreadImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("runnable");
        }
    }


}