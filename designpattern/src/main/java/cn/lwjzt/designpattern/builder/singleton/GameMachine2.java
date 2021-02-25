package cn.lwjzt.designpattern.builder.singleton;

import cn.lwjzt.designpattern.builder.factory_pattern.GameMachine;

/**
 * 1、懒汉式，线程不安全
 * 是否 Lazy 初始化：是
 * 是否多线程安全：否
 * 实现难度：易
 *
 * @author Leexiaobu
 * @date 2020-08-21 11:27:13
 */
public class GameMachine2 {
    static GameMachine2 gameMachine;

    private GameMachine2() {
    }

    public static GameMachine2 getGameMachine() {
        if (gameMachine == null) {
            gameMachine = new GameMachine2();
        }
        return gameMachine;
    }

    protected void showMessage() {
        System.out.println(this.hashCode() + this.getClass().getName());
    }
}
