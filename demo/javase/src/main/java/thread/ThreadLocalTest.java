package thread;

public class ThreadLocalTest {

    ThreadLocal<Leexiaobu> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(1);
        }).start();

    }

}

class Leexiaobu {

    private String name = "leexiaobu";
}