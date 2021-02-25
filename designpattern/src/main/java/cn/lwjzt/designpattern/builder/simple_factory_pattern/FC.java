package cn.lwjzt.designpattern.builder.simple_factory_pattern;

public class FC implements GameMachine {

    @Override
    public void startUp() {
        System.out.println("defalut Game Machine can't do anything!");
    }
}
