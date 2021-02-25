package cn.lwjzt.designpattern.builder.singleton;

/**
 * 饿汉式
 * 线程安全
 * lazy加载  否
 * 类加载时就初始化，浪费内存。
 * 基于classLoader进行实例化
 *
 * @author Leexiaobu
 * @date 2020-08-21 11:27:13
 */
public class GameMachine1 {
    static GameMachine1 gameMachine = new GameMachine1();

    private GameMachine1() {

    }

    protected static GameMachine1 getGameMachine() {
        return gameMachine;
    }

    protected void showMessage() {
        System.out.println(this.hashCode() + this.getClass().getName());
    }

}
