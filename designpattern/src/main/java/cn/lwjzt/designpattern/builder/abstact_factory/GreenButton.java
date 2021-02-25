package cn.lwjzt.designpattern.builder.abstact_factory;

public class GreenButton implements Button {
    @Override
    public void display() {
        System.out.println("绿色按钮");
    }
}
