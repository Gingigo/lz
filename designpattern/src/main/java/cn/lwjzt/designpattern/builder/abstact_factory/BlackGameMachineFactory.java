package cn.lwjzt.designpattern.builder.abstact_factory;

public class BlackGameMachineFactory implements GameMachineFactory {


    @Override
    public Button createButton() {
        return new BlackButton();
    }

    @Override
    public Screen createScreen() {
        return new BlackScreen();
    }
}
