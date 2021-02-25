package cn.lwjzt.designpattern.builder.simple_factory_pattern;

public class NintendoSwitch implements GameMachine {
    @Override
    public void startUp() {
        System.out.println("任天堂开机了");
    }
}
