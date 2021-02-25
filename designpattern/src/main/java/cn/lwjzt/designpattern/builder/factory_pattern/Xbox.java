package cn.lwjzt.designpattern.builder.factory_pattern;

public class Xbox implements GameMachine {
    @Override
    public void startUp() {
        System.out.println("xbox 开机失败");
    }
}
