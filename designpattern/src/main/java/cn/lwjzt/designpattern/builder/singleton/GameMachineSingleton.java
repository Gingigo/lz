package cn.lwjzt.designpattern.builder.singleton;

/**
 * @author Leexiaobu
 * @date 2020-08-21 11:25:14
 */
public class GameMachineSingleton {

    public static void main(String[] args) {
        GameMachine1.getGameMachine().showMessage();
        GameMachine2.getGameMachine().showMessage();
        GameMachine4.getGameMachine().showMessage();
        GameMachine5.getGameMachine().showMessage();
        GameMachine6.getGameMachine().showMessage();
        GameMachine3.GAMEMACHINE.showMessage();
    }


}
