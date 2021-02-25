package cn.lwjzt.designpattern.builder.factory_pattern;

public class PlayStation5 implements GameMachine {

    @Override
    public void startUp() {
        System.out.println("ps5开机失败，因为还没买到");
    }
}
