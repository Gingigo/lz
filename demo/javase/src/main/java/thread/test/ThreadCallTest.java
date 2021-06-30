package thread.test;

import java.util.concurrent.Callable;

class ThreadCallTest implements Callable<String> {
    String name;
    public ThreadCallTest(String s) {
        super();
        this.name=s;
    }

    @Override
    public String call() {
        return name;
    }

}
