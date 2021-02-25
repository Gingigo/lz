package cn.lwjzt.designpattern.builder.singleton;

/**
 * double check
 * 静态内部类
 *
 * @author Leexiaobu
 * @date 2020-08-21 11:27:13
 */
public class GameMachine6 {
    private GameMachine6() {
    }

    private static class GameMachineInner {
        private static final GameMachine6 gameMachine6 = new GameMachine6();

    }

    public static GameMachine6 getGameMachine() {
        return GameMachineInner.gameMachine6;
    }

    protected void showMessage() {
        System.out.println(this.hashCode() + this.getClass().getName());
    }
}
