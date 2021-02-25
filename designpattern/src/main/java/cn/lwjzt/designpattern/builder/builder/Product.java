package cn.lwjzt.designpattern.builder.builder;

import lombok.Data;

@Data
public class Product {
    //定义部件，部件可以是任意类型，包括值类型和引用类型
    private String partA;

    private String partB;

    private String partC;
}
