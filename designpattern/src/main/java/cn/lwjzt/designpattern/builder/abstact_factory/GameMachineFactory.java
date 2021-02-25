package cn.lwjzt.designpattern.builder.abstact_factory;

public interface GameMachineFactory {
    public Button createButton();

    public Screen createScreen();
}
