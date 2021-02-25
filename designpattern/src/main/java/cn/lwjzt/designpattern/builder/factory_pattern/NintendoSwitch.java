package cn.lwjzt.designpattern.builder.factory_pattern;

public class NintendoSwitch implements GameMachine {
    public String color;

    @Override
    public void startUp() {
        System.out.println(this.color + "任天堂开机了");
    }

    public NintendoSwitch(String color) {
        this.color = color;
    }

    public NintendoSwitch() {
    }
}
