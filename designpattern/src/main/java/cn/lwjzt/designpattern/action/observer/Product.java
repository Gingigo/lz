package cn.lwjzt.designpattern.action.observer;

/**
 * @author Leexiaobu
 * @date 2020-09-07 23:55:26
 */
public class Product {
    String name;
    int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
