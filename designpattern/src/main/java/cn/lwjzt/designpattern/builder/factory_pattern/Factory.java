package cn.lwjzt.designpattern.builder.factory_pattern;

public interface Factory {
    public GameMachine createGameMachine();

    GameMachine createGameMachine(String args);
}
