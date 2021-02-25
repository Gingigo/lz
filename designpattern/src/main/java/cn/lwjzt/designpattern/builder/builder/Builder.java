package cn.lwjzt.designpattern.builder.builder;

public abstract class Builder {
    //    public abstract void setPart();
//    public abstract Product buildProduct();
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    public Product getResult() {
        return product;
    }

}
