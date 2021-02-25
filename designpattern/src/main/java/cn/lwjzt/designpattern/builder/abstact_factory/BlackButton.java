package cn.lwjzt.designpattern.builder.abstact_factory;

public class BlackButton implements Button {

    @Override
    public void display() {
        System.out.println("黑色按钮");
    }
}
