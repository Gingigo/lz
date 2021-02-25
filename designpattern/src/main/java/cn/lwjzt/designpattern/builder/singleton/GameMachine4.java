package cn.lwjzt.designpattern.builder.singleton;

/**
 * 懒汉式线程安全
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：易
 * 效率低
 *
 * @author Leexiaobu
 * @date 2020-08-21 11:27:13
 */
public class GameMachine4 {
    static GameMachine4 gameMachine;

    private GameMachine4() {
    }

    public static synchronized GameMachine4 getGameMachine() {
        if (gameMachine == null) {
            gameMachine = new GameMachine4();
        }
        return gameMachine;
    }

    protected void showMessage() {
        System.out.println(this.hashCode() + this.getClass().getName());
    }
}
