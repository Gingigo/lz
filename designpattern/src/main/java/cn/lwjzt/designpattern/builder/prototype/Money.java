package cn.lwjzt.designpattern.builder.prototype;

import lombok.Data;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

@Data
public class Money implements Prototype {
    @Override
    public Prototype clone() {
        Money money = new Money();
        money.setList(this.list);
        money.setValue(this.value);
        money.setName(this.name);
        return money;
    }

    Integer value;
    List<Integer> list;
    String name;

    public static void main(String[] args) {
        String name = "100";
        Money money = new Money();
        money.setValue(199);
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 100);
        money.setName(name);
        money.setList(integers);
        Money clone = (Money) money.clone();
        compare(money, clone);
        money.setList(Arrays.asList(1, 2, 3, 4, 100));
        compare(money, clone);
        money.name = "100";
        compare(money, clone);
        name = "1001";
        compare(money, clone);
    }

    public static void compare(Money money, Money clone) {
        System.out.println("====");
        System.out.print(money.hashCode() + "  ");
        System.out.println(clone.hashCode());
        System.out.println(clone.toString());
        System.out.println(money.equals(clone));
        System.out.println(money == clone);
        System.out.println(money.name.hashCode());
        System.out.println(clone.name.hashCode());
        System.out.println(money.list.hashCode());
        System.out.println(clone.list.hashCode());
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
