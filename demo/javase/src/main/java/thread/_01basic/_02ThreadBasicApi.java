package thread._01basic;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Leexiaobu
 * @date 2020-09-29 12:07:23
 */
@Slf4j
public class _02ThreadBasicApi {

    public static void main(String[] args) throws InterruptedException {
        _02ThreadBasicApi test = new _02ThreadBasicApi();
        test.testIsAlive();
        test.interrupt();

    }

    void testIsAlive() throws InterruptedException {
        ThreadSubClass basic_aPi = new ThreadSubClass(" basic APi ");
        System.out.println("before" + basic_aPi.getName() + basic_aPi.isAlive());
        basic_aPi.start();
        System.out.println("start" + basic_aPi.getName() + basic_aPi.isAlive());
        Thread.sleep(10);
        System.out.println("end" + basic_aPi.getName() + basic_aPi.isAlive());
    }

    /**
     * NOTE:
     * Interrupted 将状态改为false
     * isInterrupted 返回状态
     */
    void interrupt() throws InterruptedException {
        testInterrupt();
        testInterruptStopThread();
        testInterruptSleep();
        testSleepInterrupt();
    }

    void testInterrupt() {
        log.info("testInterrupt===");
        ThreadSubClassLong basic_aPi = new ThreadSubClassLong(" basic Long ");
        basic_aPi.start();
        System.out.println(basic_aPi.isInterrupted());
        basic_aPi.interrupt();
        boolean interrupted = basic_aPi.isInterrupted();
        System.out.println(interrupted);
        System.out.println("end");
        log.info("testInterrupt===");
    }

    void testInterruptStopThread() {
        log.info("testInterruptStopThread===");
        InterruptStop interrupt = new InterruptStop();
        interrupt.start();
        interrupt.interrupt();
        log.info("testInterruptStopThread===");
    }
    void testInterruptSleep() {
        log.info("SleepInterrupt===");
        SleepInterrupt interrupt = new SleepInterrupt();
        interrupt.start();
        interrupt.interrupt();
        log.info("SleepInterrupt===");
    }
    void testSleepInterrupt() {
        log.info("InterruptSleep===");
        InterruptSleep interrupt = new InterruptSleep();
        interrupt.start();
        interrupt.interrupt();
        log.info("InterruptSleep===");
    }
}

class InterruptStop extends Thread {
    @Override
    public void run() {
        while (!this.isInterrupted()) {
            System.out.println("lee");
        }
        System.out.println("Interrupt end ");
    }
}

class SleepInterrupt extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            System.out.println("sleep Exception");
        }
        System.out.println("Interrupt end ");
    }
}

class InterruptSleep extends Thread {
    @Override
    public void run() {
        this.interrupt();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            System.out.println("InterruptSleep");
        }
        System.out.println("Interrupt end ");
    }
}