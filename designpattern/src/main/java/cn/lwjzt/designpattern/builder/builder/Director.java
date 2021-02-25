package cn.lwjzt.designpattern.builder.builder;

public class Director {
    private Builder builder;

    public Director(Builder builder) {

        this.builder = builder;

    }


    public void setBuilder(Builder builder) {

        this.builder = builder;

    }


    //产品构建与组装方法

    public Product constructA() {

        builder.buildPartA();

        builder.buildPartB();

        builder.buildPartC();

        return builder.getResult();

    }

    public Product constructB() {
        builder.buildPartB();
        builder.buildPartA();
        builder.buildPartC();
        return builder.getResult();
    }

    public static void main(String[] args) {
        //可通过配置文件实现
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.constructA();
        Product product1 = director.constructB();

    }
}
