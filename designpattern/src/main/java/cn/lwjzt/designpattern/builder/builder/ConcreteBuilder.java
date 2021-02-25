package cn.lwjzt.designpattern.builder.builder;

/**
 * @author lwj
 * @title 具体的建造者
 * @description 需要几个产品类就要有几个具体的建造者
 * @updateTime 2020/8/4/004
 * @throws
 */
public class ConcreteBuilder extends Builder {


    @Override
    public void buildPartA() {
        System.out.println("刷牙");
    }

    @Override
    public void buildPartB() {
        System.out.println("洗脸");
    }

    @Override
    public void buildPartC() {
        System.out.println("穿袜子");
    }
}
