package cn.lwjzt.designpattern.builder.singleton;

/**
 * @author Leexiaobu
 * @date 2020-08-21 11:36:23
 */
public enum GameMachine3 {
    GAMEMACHINE;

    protected void showMessage() {
        System.out.println(this.hashCode() + this.getClass().getName());
    }
}
