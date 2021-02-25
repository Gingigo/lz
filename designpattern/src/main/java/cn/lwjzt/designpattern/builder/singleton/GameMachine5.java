package cn.lwjzt.designpattern.builder.singleton;

/**
 * double check
 * 检查2次
 *
 * @author Leexiaobu
 * @date 2020-08-21 11:27:13
 */
public class GameMachine5 {
    static volatile GameMachine5 gameMachine;

    private GameMachine5() {
    }

    public static GameMachine5 getGameMachine() {
        if (gameMachine == null) {
            synchronized (GameMachine5.class) {
                if (gameMachine == null) {
                    gameMachine = new GameMachine5();
                }
            }
        }
        return gameMachine;
    }

    protected void showMessage() {
        System.out.println(this.hashCode() + this.getClass().getName());
    }
}
